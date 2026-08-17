package com.helios.data;

import org.testng.annotations.DataProvider;

public final class TestDataProvider {

    private TestDataProvider() {
    }

    @DataProvider(name = "loginData")
    public static Object[][] loginData() {
        return new Object[][]{
                {new LoginData("tomsmith", "SuperSecretPassword!")}
        };
    }

    @DataProvider(name = "invalidLoginData")
    public static Object[][] invalidLoginData() {
        return new Object[][]{
                {new LoginData("invalid", "wrongPassword")}
        };
    }
}