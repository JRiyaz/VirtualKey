package com.lockers;

import java.util.Scanner;

/**
 * The Menu program contains few methods along with main method.
 * It runs the program and perform several operations
 * like showing command line options to user and verifies
 * the user input to show relevant result.
 *
 * @author Riyaz J
 * @version 1.0
 * @since 2020-11-20
 */
public class Menu {

    //        Scanner object
    final Scanner scanner = new Scanner(System.in);

    final Operation operation = new Operation();

    public static void main(String[] args) {

        System.out.println("\n\t\t\t\tWelcome to Lockers. Developed by 'Riyaz J'");
        System.out.println("\t\t\t\t------------------------------------------");

        new Menu().options();
    }

    /**
     * This method perform several operations like create, delete, search
     * and show files based on the user input.
     */
    public void options() {

        System.out.println("\nSelect from the option\n");

        final String options = "1. See All Files\n" +
                "2. Create File\n" +
                "3. Delete File\n" +
                "4. Search File\n" +
                "5. Close Application";

//        Take int value by the user thorough command line
        final int option = correctOption(options, 5, 2);

        switch (option) {

            case -1:
                closeProgram("You tried maximum attempts, application is closed. Thank you!", true);
                break;

//            See All Files
            case 1:
                System.out.println("\nAll Files are showed in ascending order by default.\n");
                operation.allFilesAsc()
                        .forEach(System.out::println);

//                Show sub options after the result is shown.
                final String sub_options = "\n" +
                        "1. View in Descending Order\n" +
                        "2. Main Menu\n" +
                        "3. Close Application";

                final int sub_option = correctOption(sub_options, 3, 2);

                switch (sub_option) {

                    case -1:
                        closeProgram("You tried maximum attempts, application is closed. Thank you!", true);
                        break;

                    case 1:
                        System.out.println("\nAll Files are showed in descending order.\n");
                        operation.allFilesDsc()
                                .forEach(System.out::println);
//                        Call options() method recursively so that program will close only if the user choose to close.
                        options();
                        break;

                    case 2:
//                        recursive call
                        options();
                        break;

                    case 3:
                        closeProgram("Thank you for using our application! Application is closed", false);
                        break;

                    default:
                        System.out.println("Nothing has selected");
                }
                break;

//            Create File
            case 2:
                if (operation.createFile(scanner))
                    System.out.println("File created successfully");
                else
                    System.err.println("Something went wrong. Please try after some time.");
                options();
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
                closeProgram("Thank you for using our application! Application is closed", false);
                break;

            default:
                System.out.println("Nothing has selected");

        }
    }

    /**
     * This method verifies the user input and prompts to choose
     * correct option and return the user input if the input
     * meet the requirements.
     *
     * @param options     This parameter will be showed to the user
     *                    to choose a option.
     * @param lastOption  The user input will be compared with the
     *                    parameter, if the input is in between the
     *                    range or not.
     * @param maxAttempts This parameter is used to limit the
     *                    chances given to the user to choose
     *                    correct option.
     * @return int (It returns the user input value).
     */
    public int correctOption(final String options, final int lastOption, final int maxAttempts) {

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

    /**
     * This method close the program and show appropriate message.
     *
     * @param message This parameter will be showed to the user.
     * @param error   To show the message as an error or just as info.
     */
    public void closeProgram(final String message, final boolean error) {
        if (error)
            System.err.println("\n" + message);
        else
            System.out.println("\n" + message);
        System.exit(0);
    }
}
