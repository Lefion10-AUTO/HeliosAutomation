package com.helios.tests;

import com.helios.data.LoginData;
import com.helios.data.TestDataProvider;
import com.helios.driver.DriverManager;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ABTestingPage;
import pages.HomePage;
import pages.LoginPage;

public class BrowserSmokeTest extends BaseTest {

    @Test
    public void homePageLoadsSuccessfully() {

        HomePage homePage = new HomePage(DriverManager.get());

        homePage.open();
        ABTestingPage abTestingPage = homePage.openABTesting();

        Assert.assertTrue(abTestingPage.isLoaded(), "A/B Testing page was not loaded");
    }

    @Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
    public void validLogin(LoginData data) {

        LoginPage loginPage = new LoginPage(DriverManager.get());

        loginPage.open();
        loginPage.login(data.username(), data.password());

        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login should be successful");
    }
}
