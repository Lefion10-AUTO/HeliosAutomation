package com.helios.tests;

import com.helios.data.LoginData;
import com.helios.data.TestDataProvider;
import com.helios.driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    private static final String INVALID_USERNAME_MESSAGE = "Your username is invalid!";

    @Test(groups = "smoke", dataProvider = "validLoginData", dataProviderClass = TestDataProvider.class)
    public void validLogin(LoginData data) {

        LoginPage loginPage = new LoginPage(DriverManager.get());

        loginPage.open();
        loginPage.login(data.username(), data.password());

        Assert.assertTrue(loginPage.isUserLoggedIn(), "Login should be successful");
    }

    @Test(groups = "regression", dataProvider = "invalidLoginData", dataProviderClass = TestDataProvider.class)
    public void invalidLogin(LoginData data) {

        LoginPage loginPage = new LoginPage(DriverManager.get());

        loginPage.open();
        loginPage.attemptLogin(data.username(), data.password());

        Assert.assertFalse(loginPage.isUserLoggedIn(), "Login should not be successful");
        Assert.assertTrue(
                loginPage.getFlashMessage().contains(INVALID_USERNAME_MESSAGE),
                "Expected an invalid username error message"
        );
    }

}
