package com.helios.tests;

import com.helios.driver.DriverManager;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class BrowserSmokeTest extends BaseTest {

    @Test
    public void homePageLoadsSuccessfully() {

        HomePage homePage = new HomePage(DriverManager.get());

        homePage.open();
        Assert.assertTrue(homePage.isABTestingButtonVisible(), "A/B Testing button should be visible on the Home Page");

    }
}