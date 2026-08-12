package com.helios.driver;

import com.helios.config.BrowserConfig;
import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverManager() {
    }

    public static void start(WebDriverProvider provider, BrowserConfig config) {

        if (DRIVER.get() != null) {
            throw new IllegalStateException("WebDriver is already initialized for thread: " + Thread.currentThread().getName());
        }


        DRIVER.set(provider.create(config));
    }

    public static WebDriver get() {
        WebDriver driver = DRIVER.get(); // get the driver belonging to this thread !!

        if (driver == null) {
            throw new IllegalStateException("No WebDriver exists for thread: " + Thread.currentThread().getName());
        }

        return driver;
    }

    public static void stop() {
        // get the driver belonging to this thread in order to clean up
        WebDriver driver = DRIVER.get();

        try {
            if (driver != null) {
                driver.quit();
            }
        } finally {
            DRIVER.remove();
        }
    }


}
