package com.helios.config;

public record BrowserConfig(BrowserType browser, boolean headless, boolean remote, String gridUrl) {
}