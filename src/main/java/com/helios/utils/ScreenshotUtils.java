package com.helios.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public final class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    public static void capture(WebDriver driver, String testName) {
        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path destination = getFileDestination(testName);

            copyFile(source, destination);
            System.out.println("Screenshot saved: " + destination);
        } catch (IOException e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        }
    }

    private static Path getFileDestination(String testName) {
        String fileName = testName + "_" + Thread.currentThread().getName() + "_" + System.currentTimeMillis() + ".png";
        return Path.of("target", "screenshots", fileName);
    }

    private static void copyFile(File source, Path destination) throws IOException {
        Files.createDirectories(destination.getParent());
        Files.copy(source.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
    }

}
