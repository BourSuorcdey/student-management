package services;

import io.StudentIO;
import io.StudentTableModel;
import model.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class StudentService {
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();
    static List<Student> students = StudentIO.getAll();
    private static final int rowSize = 4;
    public static void addNewData() {
        System.out.println(".........................");
        System.out.print("[+] Insert student's name: ");
        String name = sc.nextLine();
        System.out.println("[+] Student date of birth");
        System.out.print("> Year (number): ");
        int year = Integer.parseInt(sc.nextLine());
        System.out.print("> Month (number): ");
        int month = Integer.parseInt((sc.nextLine()));
        System.out.print("> Day (number): ");
        int day = Integer.parseInt(sc.nextLine());
        System.out.print("[+] Insert student's classroom: ");
        String classroom = sc.nextLine();
        System.out.print("[+] Insert student's subject: ");
        String subject = sc.nextLine();

        Student student = new Student();
        student.setId(random.nextInt(10000));
        student.setName(name);
        student.setDateOfBirth(LocalDate.of(year, month, day).toString());
        student.setClassroom(classroom);
        student.setSubject(subject);

        StudentIO.add(student);
    }

    public static void getAllData() {

        if (students == null) {
            System.out.println("Unable to get students data");
        }

        int currentPage = 1;
        int totalPages = (int)Math.ceil((double)students.size() / rowSize);
        int totalRecords = students.size();
        while (true) {
            int startIndex = (currentPage -1) * rowSize;
            int endIndex = Math.min(startIndex + rowSize, students.size());
            List<Student> pageStudents = students.subList(startIndex, endIndex);

            System.out.println();
            StudentTableModel.renderStudentsToTable(pageStudents, rowSize, currentPage, totalPages, totalRecords);
            StudentTableModel.renderPagination();

            System.out.print("Enter the option(pagination): ");
            String pageOption = new Scanner(System.in).nextLine();
            if (pageOption.equalsIgnoreCase("p")) {
                if (currentPage > 1) {
                    currentPage--;
                } else {
                    System.out.println("You're already on the first page.");
                }
            } else if (pageOption.equalsIgnoreCase("n")){
                if (currentPage < totalPages) {
                    currentPage++;
                } else {
                    System.out.println("You're already on the last page.");
                }
            } else if (pageOption.equalsIgnoreCase("f")) {
                currentPage = 1;
            } else if (pageOption.equalsIgnoreCase("l")) {
                currentPage = totalPages;
            } else if (pageOption.equalsIgnoreCase("b")) {
                return;
            } else {
                try {
                    int pageNumber = Integer.parseInt(pageOption);
                    if (pageNumber >= 1 && pageNumber <= totalPages) {
                        currentPage = pageNumber;
                    } else {
                        System.out.println("Invalid page number. Please enter a number between 1 and " + totalPages);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input!");
                }
            }
        }
    }

    public static void commitDataToFile() {

    }

    public static void searchForData() {

    }

    public static void updateDataById() {

    }

    public static void deleteData() {

    }

    public static void generateDataIntoFile() {

    }

    public static void deleteAllDataFromFile() {

    }
}
