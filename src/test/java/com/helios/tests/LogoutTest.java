package com.helios.tests;

import com.helios.data.LoginData;
import com.helios.data.TestDataProvider;
import com.helios.driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LogoutTest extends BaseTest {

    private static final String EXPECTED_HEADING = "Secure Area";
    private static final String EXPECTED_LOGIN_FLASH = "You logged into a secure area!";
    private static final String EXPECTED_SUBHEADER = "Welcome to the Secure Area. When you are done click logout below.";

    @Test(groups = "regression", dataProvider = "validLoginData", dataProviderClass = TestDataProvider.class)
    public void logoutTest(LoginData loginData) {
        LoginPage loginPage = new LoginPage(DriverManager.get());
        loginPage.open();

        SecureAreaPage secureAreaPage = loginPage.login(loginData.username(), loginData.password());

        Assert.assertEquals(secureAreaPage.getHeader(), EXPECTED_HEADING);
        Assert.assertTrue(secureAreaPage.getFlashMessageContent().contains(EXPECTED_LOGIN_FLASH));
        Assert.assertEquals(secureAreaPage.getSubHeader(), EXPECTED_SUBHEADER);

        LoginPage loggedOutPage = secureAreaPage.logout();
        Assert.assertFalse(loggedOutPage.isUserLoggedIn(), "User should be logged out after logout action");
    }
}
