package com.lockers;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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

    private File file = new File("src/main/resources/");

    /**
     * This method gives the list of all files in ascending order.
     *
     * @return List<String> (This returns list of all files).
     */
    public List<String> allFilesAsc() {

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
}
