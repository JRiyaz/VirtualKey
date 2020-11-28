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
    private final Scanner scanner = new Scanner(System.in);

    private final Operation operation = new Operation();

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
        final int option = correctOption(options, 5);

        switch (option) {

//            Close Program
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

                final int sub_option = correctOption(sub_options, 3);

                switch (sub_option) {

//                    Close Program
                    case -1:
                        closeProgram("You tried maximum attempts, application is closed. Thank you!", true);
                        break;

//                        View Files in Descending Order
                    case 1:
                        System.out.println("\nAll Files are showed in descending order.\n");
                        operation.allFilesDsc()
                                .forEach(System.out::println);
//                        Call options() method recursively so that program will close only if the user choose to close.
                        options();
                        break;

//                        Main Menu
                    case 2:
//                        recursive call
                        options();
                        break;

//                        Close Program
                    case 3:
                        closeProgram("Thank you for using our application! Application is closed", false);
                        break;

                    default:
                        System.out.println("Nothing has selected");
                }
                break;

//            Create File
            case 2:

                String file_name = checkName();
                if (file_name != null) {
                    if (operation.createFile(file_name))
                        System.out.println("File created successfully");
                    else
                        System.err.println("Something went wrong. Please try after some time.");
                } else
                    System.err.println("Invalid file name");
                options();
                break;

//            Delete File
            case 3:

                file_name = checkName();
                if (file_name != null) {
                    if (operation.deleteFile(file_name))
                        System.out.println("File deleted successfully");
                    else
                        System.err.println("File doesn't exists.");
                } else
                    System.err.println("Invalid file name");
                options();
                break;

//            Search File
            case 4:

                file_name = checkName();
                if (file_name != null) {
                    file_name = operation.searchFile(file_name);
                    if (file_name != null)
                        System.out.println("File '" + file_name + "' exists");
                    else
                        System.err.println("File doesn't exists");
                } else
                    System.err.println("Invalid file name");
                options();
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
     * @param options    This parameter will be showed to the user
     *                   to choose a option.
     * @param lastOption The user input will be compared with the
     *                   parameter, if the input is in between the
     *                   range or not.
     * @return int (It returns the user input value).
     */
    private int correctOption(final String options, final int lastOption) {

//        Take int value by user thorough command line
        int option;

//        Count the iterations of while loop and show the options again to the user if user has chosen wrong option.
        int loop = 0;

        while (true) {

            System.out.println(options);
            option = scanner.nextInt();

//            If the input is in between the range specified, just break the loop and return the value
            if (option <= lastOption && option > 0)
                break;

//            If the attempts exceed close the resources and return -1 value which will close the program
            if (loop >= 2) {
                option = -1;
                break;
            } else
                System.err.println("\nPlease select correct option");

            loop++;
        }
        return option;
    }

    /**
     * This method verifies the user input for file name.
     *
     * @return String (It returns the user input value).
     */
    private String checkName() {

        System.out.println("Enter file name along with extension");

        String fileName = scanner.next();

        if (fileName.equals("") || !(fileName.contains(".")))
            return null;

        return fileName;
    }

    /**
     * This method close the program and show appropriate message.
     *
     * @param message       This parameter will be showed to the user.
     * @param errorOccurred To show the message as an error or just as info.
     */
    private void closeProgram(final String message, final boolean errorOccurred) {

        if (errorOccurred)
            System.err.println("\n" + message);
        else
            System.out.println("\n" + message);

        scanner.close();
        System.exit(0);
    }
}
