package com.lockers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * The Operations program contains methods which
 * performs file operations like
 * create, delete, retrieve file and etc.
 *
 * @author Riyaz J
 * @version 1.0
 * @since 2020-11-20
 */
public class Operation {

    private final String path = "src/main/resources/";
    private File file;

    /**
     * This method gives the list of all files in ascending order.
     *
     * @return List<String> (This returns list of all files).
     */
    public List<String> allFilesAsc() {

        file = new File(path);

        return Arrays.stream(file.list())
                .sorted()
                .collect(Collectors.toList());

    }

    /**
     * This method gives the list of all files in descending order.
     *
     * @return List<String> (This returns list of all files).
     */
    public List<String> allFilesDsc() {

        List<String> dscList = new ArrayList<>();

        final List<String> ascList = allFilesAsc();

        int i = ascList.size() - 1;

        while (i >= 0) {

            dscList.add(ascList.get(i));

            --i;
        }
        return dscList;
    }

    /**
     * This method creates file.
     *
     * @param scanner This method required scanner object
     * @return boolean (It returns true if file gets created else return false).
     */
    public boolean createFile(Scanner scanner) {

        try {
            if (!checkFile(scanner))
                return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * This method deletes file.
     *
     * @param scanner This method required scanner object
     * @return boolean (It returns true if file gets deleted else return false).
     */
    public boolean deleteFile(Scanner scanner) {

        if (checkFile(scanner))
            return file.delete();
        return false;
    }

    /**
     * This method checks if file exists or not.
     *
     * @param scanner This method required scanner object
     * @return boolean (It returns true if file exists else return false).
     */
    public boolean searchFile(Scanner scanner) {

        return checkFile(scanner);
    }

    /**
     * This method checks if file exists or not.
     *
     * @param scanner This method required scanner object
     * @return boolean (It returns true if file exists else return false).
     */
    private boolean checkFile(Scanner scanner) {

        System.out.println("Enter file name along with extension");

        String fileName = scanner.next();

        if (fileName.equals("") || fileName == null) {
            return false;
        }

        file = new File(path, fileName);

        return file.exists();
    }
}
