package com.lockers;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final Operation operation = new Operation();

        System.out.println("\n\t\t\t\tWelcome to Lockers. Developed by 'Riyaz J'");
        System.out.println("\t\t\t\t------------------------------------------\n");

        System.out.println("Select from the option\n");

        String options = "1. See All Files\n" +
                "2. Create File\n" +
                "3. Delete File\n" +
                "4. Search File\n" +
                "5. Close Application";

        System.out.println(options);

//        Take int value by the user thorough command line
        int option = scanner.nextInt();

//        Count the iterations of while loop and show the options again to the user if user has chosen wrong option.
        int loop = 0;

        boolean flag = true;

        boolean repeat = false;

        while (flag) {

//            Show options again to the user, if they have chosen wrong one.
            if (repeat) {
                repeat = false;
                System.out.println(options);
                option = scanner.nextInt();
            }
            if (loop > 2) {
                System.err.println("\nYou tried maximum attempts, application is closed. Thank you!");
                scanner.close();
                System.exit(0);
                break;
            } else {

                switch (option) {

//                    See All Files
                    case 1:
                        System.out.println("All Files are showed in ascending order by default.\n");
                        operation.allFilesAsc()
                                .forEach(System.out::println);

                        String op = "\n" +
                                "1. View in Descending Order\n" +
                                "2. Main Menu\n" +
                                "3. Close Application";
                        System.out.println(op);
                        flag = false;
                        break;

//                        Create File
                    case 2:
                        System.out.println("Create File");
                        flag = false;
                        break;

//                        Delete File
                    case 3:
                        System.out.println("Delete File");
                        flag = false;
                        break;

//                        Search File
                    case 4:
                        System.out.println("Search File");
                        flag = false;
                        break;

//                        Close Application
                    case 5:
                        System.out.println("Thank you for using our application! Application is closed");
                        scanner.close();
                        flag = false;
                        break;

                    default:
                        if (loop <= 2) {
                            System.err.println("\nPlease select correct option");
                            repeat = true;
                        }
                        flag = true;
                }
            }
            loop++;
        }
    }
}
