package services;

import io.StudentIO;
import model.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class StudentService {
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void listAllStudent() {
        List<Student> students = StudentIO.getAll();
        if (students == null) {
            System.out.println("Unable to get students data");
        } else {
            Student s;
            System.out.println(students);
        }
    }
    public static void addStudent() {
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
}
