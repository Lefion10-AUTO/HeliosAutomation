package com.helios.config;

import java.util.Arrays;

public record BrowserConfig(
        BrowserType browser,
        boolean headless,
        boolean remote,
        String gridUrl
) {

    public static BrowserConfig fromSystemProperties() {
        return new BrowserConfig(
                parseBrowser(TestConfig.browser()),
                TestConfig.headless(),
                TestConfig.remote(),
                TestConfig.gridUrl()
        );
    }

    private static BrowserType parseBrowser(String browser) {
        try {
            return BrowserType.valueOf(browser.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    "Unsupported browser: " + browser
                            + ". Supported browsers: "
                            + Arrays.toString(BrowserType.values())
            );
        }
    }
}