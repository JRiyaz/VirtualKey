package com.lockers;

import java.util.Scanner;

public class Menu {

    //        Scanner object
    final Scanner scanner = new Scanner(System.in);

    final Operation operation = new Operation();

    public static void main(String[] args) {

        System.out.println("\n\t\t\t\tWelcome to Lockers. Developed by 'Riyaz J'");
        System.out.println("\t\t\t\t------------------------------------------\n");

        new Menu().options();
    }

    public void options() {

        System.out.println("Select from the option\n");

        String options = "1. See All Files\n" +
                "2. Create File\n" +
                "3. Delete File\n" +
                "4. Search File\n" +
                "5. Close Application";

//        Take int value by the user thorough command line
        int option = correctOption(options, 5, 1);

        switch (option) {

            case -1:
                System.err.println("\nYou tried maximum attempts, application is closed. Thank you!");
                System.exit(0);
                break;

//            See All Files
            case 1:
                System.out.println("All Files are showed in ascending order by default.\n");
                operation.allFilesAsc()
                        .forEach(System.out::println);
                break;

//            Create File
            case 2:
                System.out.println("Create File");
                break;

//            Delete File
            case 3:
                System.out.println("Delete File");
                break;

//            Search File
            case 4:
                System.out.println("Search File");
                break;

//            Close Application
            case 5:
                System.out.println("Thank you for using our application! Application is closed");
                System.exit(0);
                break;

            default:
                System.out.println("Nothing has selected");

        }
    }

    public int correctOption(String options, int lastOption, int maxAttempts) {

//        Take int value by user thorough command line
        int option = 0;

//        Count the iterations of while loop and show the options again to the user if user has chosen wrong option.
        int loop = 0;

//        To iterate while loop
        boolean flag = true;

//        Show options to user for first time and if user has chosen wrong one.
        boolean repeat = true;

        while (flag) {

//            Show options again to the user, if user has chosen wrong one.
            if (repeat) {
                repeat = false;
                System.out.println(options);
                option = scanner.nextInt();
            }

//            If the input is in between the range specified, just break the loop and return the value
            if (option <= lastOption && option > 0)
                break;

//            If the attempts exceed close the resources and return -1 value which will close the program
            if (loop >= maxAttempts) {
                scanner.close();
                option = -1;
                break;
            } else {
                System.err.println("\nPlease select correct option");
                repeat = true;
                flag = true;
            }
            loop++;
        }
        return option;
    }
}
