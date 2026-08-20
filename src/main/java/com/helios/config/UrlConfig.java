package com.helios.config;

public final class UrlConfig {

    private static final String BASE_URL =
            System.getProperty(
                    "baseUrl",
                    "https://the-internet.herokuapp.com"
            );

    private UrlConfig() {
    }

    public static String home() {
        return BASE_URL + "/";
    }

    public static String login() {
        return BASE_URL + "/login";
    }

    public static String secureArea() {
        return BASE_URL + "/secure";
    }
}