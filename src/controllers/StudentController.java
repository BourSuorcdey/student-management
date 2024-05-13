package controllers;

import services.StudentService;
import view.View;

import java.util.Scanner;

public class StudentController {

    public static void display() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("\t\t\tSTUDENT MANAGEMENT SYSTEM");
        View.menu();
        String option = "";
        while (!option.equalsIgnoreCase("0")) {
            System.out.print("> Insert option: ");
            option = sc.nextLine();

            switch (option) {
                case "1":
                    StudentService.addStudent();
                    break;
                case "2":
                    StudentService.listAllStudent();
                    break;
                case "3":
                    System.out.println("3. Commit data to file");
                    break;
                case "4":
                    System.out.println("4. Search for student");
                    break;
                case "5":
                    System.out.println("5. Update students by ID");
                    break;
                case "6":
                    System.out.println("6. Delete student's data ");
                    break;
                case "7":
                    System.out.println("7. Generate data into file");
                    break;
                case "8":
                    System.out.println("8. Delete/Clear all data from Data store");
                    break;
                case "9":
                    System.out.println("9. Exit");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Bye!");
            }
        }
    }
}
