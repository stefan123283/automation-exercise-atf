package com.stefan.automation.managers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {

    private static Path getDownloadedFileLocation(String fileName) {
        return Path.of(System.getProperty("user.home"), "Downloads").resolve(fileName);
    }

    public static boolean checkIfFileExists(String fileName) {
        return Files.exists(getDownloadedFileLocation(fileName));
    }

    public static void deleteFile(String fileName) {
        try {
            if (Files.deleteIfExists(getDownloadedFileLocation(fileName))) {
                Log.debug("The \"" + fileName + "\" was successfully deleted");
            } else {
                Log.debug("The \"" + fileName + "\" was not successfully deleted");
            }
        } catch (IOException e) {
            Log.warn(e.getMessage());
        }
    }
}
