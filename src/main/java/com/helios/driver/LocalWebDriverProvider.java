package com.helios.driver;

import com.helios.config.BrowserConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

// Creates WebDriver instances for browsers running locally.
public final class LocalWebDriverProvider implements WebDriverProvider {

    @Override
    public WebDriver create(BrowserConfig config) {

        return switch (config.browser()) {
            case CHROME -> createChrome(config);
            case FIREFOX -> createFirefox(config);
            case EDGE -> createEdge(config);
        };
    }

    private WebDriver createChrome(BrowserConfig config) {

        ChromeOptions options = new ChromeOptions();

        if (config.headless()) {
            // Run the browser without displaying a visible UI.
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        }

        return new ChromeDriver(options);
    }

    private WebDriver createFirefox(BrowserConfig config) {

        FirefoxOptions options = new FirefoxOptions();

        if (config.headless()) {
            // Run the browser without displaying a visible UI.
            options.addArguments("-headless");
            options.addArguments("--width=1920");
            options.addArguments("--height=1080");
        }

        return new FirefoxDriver(options);
    }

    private WebDriver createEdge(BrowserConfig config) {

        EdgeOptions options = new EdgeOptions();

        if (config.headless()) {
            // Run the browser without displaying a visible UI.
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        }

        return new EdgeDriver(options);
    }
}
