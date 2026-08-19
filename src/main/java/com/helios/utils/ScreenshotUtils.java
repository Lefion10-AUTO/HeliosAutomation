package com.helios.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public final class ScreenshotUtils {

    private static final Logger log = LoggerFactory.getLogger(ScreenshotUtils.class);

    private ScreenshotUtils() {
    }

    public static void capture(WebDriver driver, String testName) {
        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            Path destination = getFileDestination(testName);

            copyFile(source, destination);

            log.info("Screenshot saved: {}", destination);

        } catch (IOException e) {
            log.error("Failed to capture screenshot", e);
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