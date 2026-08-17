package com.helios.driver;

import com.helios.config.BrowserConfig;
import org.openqa.selenium.WebDriver;

// Creates WebDriver instances through the configured provider.
public class DriverFactory {

    private DriverFactory() {
        // Prevents instantiation of this utility class.
    }

    // Selects the appropriate provider and creates the WebDriver.
    public static WebDriver create(BrowserConfig config) {

        WebDriverProvider provider = new LocalWebDriverProvider();
        return provider.create(config);
    }
}
