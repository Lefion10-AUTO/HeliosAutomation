package com.helios.tests;

import com.helios.driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ABTestingPage;
import pages.HomePage;

public class ABTestingTest extends BaseTest {
    private static final String EXPECTED_HEADING = "A/B Test Control";

    @Test(groups = "smoke")
    public void abTestingPageLoadsSuccessfully() {

        HomePage homePage = new HomePage(DriverManager.get());

        homePage.open();
        ABTestingPage abTestingPage = homePage.openABTesting();

        Assert.assertEquals(abTestingPage.getHeading(), EXPECTED_HEADING, "Unexpected A/B Testing page heading");
    }
}