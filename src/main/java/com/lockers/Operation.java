package com.lockers;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Operation {

    private final File file = new File("src/main/resources/");

    //    Return List of files in ascending order
    public List<String> allFilesAsc() {

        return Arrays.stream(file.list())
                .sorted()
                .collect(Collectors.toList());

    }
}
