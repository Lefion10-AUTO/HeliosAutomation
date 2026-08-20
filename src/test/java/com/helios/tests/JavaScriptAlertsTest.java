package com.helios.tests;

import com.helios.driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.JavaScriptAlertsPage;

public class JavaScriptAlertsTest extends BaseTest {
    private static final String EXPECTED_CLICK_RESULT_TEXT = "You successfully clicked an alert";
    private static final String EXPECTED_DISMISS_RESULT_TEXT = "You clicked: Cancel";
    private static final String INPUT_TEXT = "Test Input";
    private static final String EXPECTED_PROMPT_RESULT_TEXT = "You entered: " + INPUT_TEXT;

    @Test(groups = "regression")
    public void testJavaScriptAlerts() {
        HomePage homePage = new HomePage(DriverManager.get());
        homePage.open();

        JavaScriptAlertsPage alertsPage = homePage.openJavaScriptAlertsPage();

        alertsPage.clickJSAlertButton();
        alertsPage.acceptAlert();

        Assert.assertEquals(alertsPage.getResultText(), EXPECTED_CLICK_RESULT_TEXT);
    }

    @Test(groups = "regression")
    public void testJavaScriptConfirm() {
        HomePage homePage = new HomePage(DriverManager.get());
        homePage.open();

        JavaScriptAlertsPage alertsPage = homePage.openJavaScriptAlertsPage();
        alertsPage.clickJSConfirmButton();
        alertsPage.dismissAlert();

        Assert.assertEquals(alertsPage.getResultText(), EXPECTED_DISMISS_RESULT_TEXT);
    }

    @Test(groups = "regression")
    public void testJavaScriptPrompt() {
        HomePage homePage = new HomePage(DriverManager.get());
        homePage.open();

        JavaScriptAlertsPage alertsPage = homePage.openJavaScriptAlertsPage();
        alertsPage.clickJSPromptButton();
        alertsPage.enterPromptText(INPUT_TEXT);
        alertsPage.acceptAlert();

        Assert.assertEquals(alertsPage.getResultText(), EXPECTED_PROMPT_RESULT_TEXT);
    }
}
