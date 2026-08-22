package com.helios.driver;

import com.helios.config.BrowserConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public final class RemoteWebDriverProvider implements WebDriverProvider {

    @Override
    public WebDriver create(BrowserConfig config) {

        try {
            return switch (config.browser()) {
                case CHROME -> new RemoteWebDriver(URI.create(config.gridUrl()).toURL(), createChromeOptions(config));
                case FIREFOX -> new RemoteWebDriver(URI.create(config.gridUrl()).toURL(), createFirefoxOptions(config));
                case EDGE -> new RemoteWebDriver(URI.create(config.gridUrl()).toURL(), createEdgeOptions(config));
            };
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid Grid URL: " + config.gridUrl(), e);
        }
    }

    private ChromeOptions createChromeOptions(BrowserConfig config) {

        ChromeOptions options = new ChromeOptions();

        if (config.headless()) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        }

        return options;
    }

    private FirefoxOptions createFirefoxOptions(BrowserConfig config) {

        FirefoxOptions options = new FirefoxOptions();

        if (config.headless()) {
            options.addArguments("-headless");
            options.addArguments("--width=1920");
            options.addArguments("--height=1080");
        }

        return options;
    }

    private EdgeOptions createEdgeOptions(BrowserConfig config) {

        EdgeOptions options = new EdgeOptions();

        if (config.headless()) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        }

        return options;
    }
}