package com.helios.config;

public final class TestConfig {

    private TestConfig() {

    }

    public static String browser() {
        return System.getProperty("browser", "chrome");
    }

    public static boolean headless() {
        return Boolean.parseBoolean(System.getProperty("headless", "false"));
    }

}
