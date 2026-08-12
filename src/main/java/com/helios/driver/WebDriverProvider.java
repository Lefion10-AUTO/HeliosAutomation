package com.helios.driver;

import com.helios.config.BrowserConfig;
import org.openqa.selenium.WebDriver;

public interface WebDriverProvider {

    WebDriver create(BrowserConfig config);
}