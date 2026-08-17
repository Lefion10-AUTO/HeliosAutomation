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

    public static Duration explicitWaitTimeout() {
        return Duration.ofSeconds(
                Long.parseLong(
                        System.getProperty("waitTimeout", "10")
                )
        );
    }

}
