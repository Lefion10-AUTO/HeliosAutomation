package com.helios.tests;

import com.helios.driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MultipleWindows;

public class MultipleWindowsTest extends BaseTest {

    @Test(groups = "regression")
    public void testMultipleWindows() {

        HomePage homePage = new HomePage(DriverManager.get());
        homePage.open();

        MultipleWindows multipleWindows = homePage.openMultipleWindowsPage();
        multipleWindows.openNewWindow();
        Assert.assertTrue(multipleWindows.isNewWindowHeadingVisible(), "New window should be opened after clicking the link.");

        multipleWindows.switchToOriginalWindow();
        Assert.assertTrue(multipleWindows.isPageHeadingVisible(), "Should be back to the original window.");

    }

}
