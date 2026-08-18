package com.helios.config;

public record BrowserConfig(BrowserType browser, boolean headless, boolean remote, String gridUrl) {
    public static BrowserConfig fromSystemProperties() {
        return new BrowserConfig(BrowserType.valueOf(TestConfig.browser().toUpperCase()), TestConfig.headless(), TestConfig.remote(), TestConfig.gridUrl());
    }
}