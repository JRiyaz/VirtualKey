package com.lockers;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

    private static final String path = "src/main/resources/";
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

        final List<String> dscList = allFilesAsc();

        Collections.reverse(dscList);

        return dscList;

//        List<String> dscList = new ArrayList<>();
//
//        final List<String> ascList = allFilesAsc();
//
//        int i = ascList.size() - 1;
//
//        while (i >= 0) {
//
//            dscList.add(ascList.get(i));
//
//            --i;
//        }
//        return dscList;
    }

    /**
     * This method creates file.
     *
     * @param file_name This method required file name to perform the operation
     * @return boolean (It returns true if file gets created else return false).
     */
    public boolean createFile(final String file_name) {

        file = new File(path, file_name.toLowerCase());
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * This method deletes file.
     *
     * @param file_name This method required file name to perform the operation
     * @return boolean (It returns true if file gets deleted else return false).
     */
    public boolean deleteFile(final String file_name) {

        file = new File(path, file_name.toLowerCase());
        return file.delete();
    }

    /**
     * This method checks if file exists or not.
     *
     * @param file_name This method required file name to perform the operation
     * @return boolean (It returns true if file exists else return false).
     */
    public String searchFile(final String file_name) {

        file = new File(path, file_name.toLowerCase());
        if (file.exists())
            return file.getName();
        return null;
    }
}
