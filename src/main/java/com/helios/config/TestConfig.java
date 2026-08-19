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

    public static boolean remote() {
        return Boolean.parseBoolean(System.getProperty("remote", "false"));
    }

    public static String gridUrl() {
        return System.getProperty("gridUrl", "http://localhost:4444");
    }

    public static int retryCount() {
        try {
            return Math.max(0, Integer.parseInt(System.getProperty("test.retry.count", "2")));
        } catch (NumberFormatException ex) {
            return 2;
        }
    }

}
