package com.helios.config;

import java.time.Duration;

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

    public static Duration explicitWaitTimeout() {
        String value = System.getProperty("waitTimeout", "10");

        try {
            long seconds = Long.parseLong(value);

            if (seconds <= 0) {
                throw new IllegalArgumentException(
                        "waitTimeout must be greater than 0 seconds: " + value
                );
            }

            return Duration.ofSeconds(seconds);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "waitTimeout must be a valid number: " + value,
                    e
            );
        }
    }

    public static Duration pageLoadTimeout() {
        // Maximum time Selenium waits for a page navigation to finish loading.
        String value = System.getProperty("pageLoadTimeout", "30");

        try {
            long seconds = Long.parseLong(value);

            if (seconds <= 0) {
                throw new IllegalArgumentException(
                        "pageLoadTimeout must be greater than 0 seconds: " + value
                );
            }

            return Duration.ofSeconds(seconds);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "pageLoadTimeout must be a valid number: " + value,
                    e
            );
        }
    }

    public static int retryCount() {
        try {
            return Math.max(0, Integer.parseInt(System.getProperty("test.retry.count", "2")));
        } catch (NumberFormatException ex) {
            return 2;
        }
    }

}
