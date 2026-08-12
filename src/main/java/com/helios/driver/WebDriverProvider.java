package com.helios.driver;

import com.helios.config.BrowserConfig;
import org.openqa.selenium.WebDriver;

// Defines the contract for creating WebDriver instances.
public interface WebDriverProvider {

    WebDriver create(BrowserConfig config);
}