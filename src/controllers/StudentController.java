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
                    StudentService.addNewData();
                    break;
                case "2":
                    StudentService.getAllData();
                    break;
                case "3":
                    System.out.println("3. Commit data to file");
                    break;
                case "4":
                    StudentService.searchForData();
                    break;
                case "5":
                    StudentService.updateDataById();
                    break;
                case "6":
                    StudentService.deleteData();
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
