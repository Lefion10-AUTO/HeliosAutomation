package com.helios.tests;

import com.helios.driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ABTestingPage;
import pages.HomePage;

public class ABTestingTest extends BaseTest {

    @Test(groups = "smoke")
    public void abTestingPageLoadsSuccessfully() {

        HomePage homePage = new HomePage(DriverManager.get());

        homePage.open();
        ABTestingPage abTestingPage = homePage.openABTesting();

        Assert.assertTrue(abTestingPage.isLoaded(), "A/B Testing page was not loaded");
    }
}