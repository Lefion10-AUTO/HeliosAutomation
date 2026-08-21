package com.helios.driver;

import com.helios.config.BrowserConfig;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Creates WebDriver instances through the configured provider.
public final class DriverFactory {
    private static final Logger log = LoggerFactory.getLogger(DriverFactory.class);

    private DriverFactory() {
        // Prevents instantiation of this utility class.
    }

    // Selects the appropriate provider and creates the WebDriver.
    public static WebDriver create(BrowserConfig config) {

        WebDriverProvider provider = config.remote() ? new RemoteWebDriverProvider() : new LocalWebDriverProvider();

        log.info("Using {} for {} browser", provider.getClass().getSimpleName(), config.browser());

        return provider.create(config);
    }
}
