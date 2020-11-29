package com.lockedme;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class OperationTest {

    final static String path = "src/main/resources/";
    static Operation operation;
    static File file;

    //    BeforeAll used to setup the connection and assign values before any test run
    @BeforeAll
    static void setUp() {

        operation = new Operation();
        file = new File(path);
    }

    //AfterAll used to close the connection or clean up activities
    @AfterAll
    static void tearDown() {

        operation = null;
        file = null;
    }

    @Test
    @DisplayName("Should check count of all files in the directory")
    void shouldCheckCountOfAllFilesInTheDirectory() {

        final int expectedLength = file.list().length;
        final int actualLength = operation.allFilesAsc().size();
        assertEquals(expectedLength, actualLength, "Both the list doesn't contain equal no.of elements");
    }

    @Test
    @DisplayName("Should check the order of the files")
    void shouldCheckTheOrderOfTheFiles() {

        final List<String> actualOrder = operation.allFilesDsc();

        assertThat(actualOrder).containsExactly("java.txt", "img", "hello.txt", "app.log", "app.bin");
    }

    @Test
    @DisplayName("Should check the file creation operation")
    void shouldCheckTheFileCreationOperation() {

        final String file_name = "bin.bin";
        file = new File(path, file_name);

        assumeTrue(operation.createFile(file_name), "File already exists.");
        assertTrue(file.exists(), "File doesn't exists");
    }

    @Test
    @DisplayName("Should check the file deletion operation")
    void shouldCheckTheFileDeletionOperation() {

        final String file_name = "app.bin";
        file = new File(path, file_name);

        assumeTrue(operation.deleteFile(file_name), "File doesn't exists");
        assertFalse(file.exists(), "File exits");
    }

    @Test
    @DisplayName("Should check the file search operation")
    void shouldCheckTheFileSearchOperation() {

        final String file_name = "hello.txt";
        file = new File(path, file_name);

        assertEquals(operation.searchFile(file_name), file.getName(), "File names doesn't match");
    }
}