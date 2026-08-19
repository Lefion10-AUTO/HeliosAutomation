package com.helios.driver;

import com.helios.config.BrowserConfig;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Manages one WebDriver instance per execution thread.
public final class DriverManager {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    private static final Logger log = LoggerFactory.getLogger(DriverManager.class);

    private DriverManager() {
    }

    // Starts a WebDriver for the current execution thread.
    public static void start(BrowserConfig config) {

        if (DRIVER.get() != null) {
            throw new IllegalStateException("WebDriver is already initialized for thread: " + Thread.currentThread().getName());
        }

        log.info("Starting {} browser | headless={} | remote={}", config.browser(), config.headless(), config.remote());

        DRIVER.set(DriverFactory.create(config));
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
                log.info("Stopping WebDriver | thread={}", Thread.currentThread().getName());

                driver.quit();
                //why quit() and not close():
                //if multiple windows/tabs exist, the WebDriver session may remain alive.
            }
        } finally {
            DRIVER.remove();
        }
    }


}
