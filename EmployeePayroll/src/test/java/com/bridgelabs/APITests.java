package com.bridgelabs;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class APITests {
    private static String HOME = System.getProperty("user.home");
    private static String PLAY_WITH_NIO = "TempPlayGround";

    @Test
    public void givenPathWhen_CheckedThenConfirm() throws IOException {
        Path homePath = Paths.get(HOME);
        Assert.assertTrue(Files.exists(homePath));

        Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
        if (Files.exists(playPath))
            EmployeePayrollUtil.deleteFiles(playPath.toFile());
        Assert.assertTrue(Files.notExists(playPath));

        // Create Directory
        Files.createDirectory(playPath);
        Assert.assertTrue(Files.exists(playPath));

        // Create File
        IntStream.range(1, 10).forEach(cntr -> {
            Path tempFile = Paths.get(playPath + "/temp" + cntr);
            Assert.assertTrue(Files.notExists(tempFile));
            try {
                Files.createFile(tempFile);
            } catch (IOException e) {

            }
            Assert.assertTrue(Files.exists(tempFile));
        });

        //List of files, directories as well as files with extension
        Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
        Files.newDirectoryStream(playPath).forEach(System.out::println);
        Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp"))
                .forEach(System.out::println);
    }
}