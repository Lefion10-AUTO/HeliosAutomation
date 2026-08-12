package com.helios.driver;

import com.helios.config.BrowserConfig;
import org.openqa.selenium.WebDriver;

// Creates WebDriver instances through the configured provider.
public class DriverFactory {

    private DriverFactory() {
        // Prevents instantiation of this utility class.
    }

    public static WebDriver create(WebDriverProvider provider, BrowserConfig config) {
        return provider.create(config);
    }
}
