package com.helios.tests;

import com.helios.driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ABTestingPage;
import pages.HomePage;

import java.util.Set;

public class ABTestingTest extends BaseTest {

    private static final Set<String> EXPECTED_HEADINGS = Set.of(
            "A/B Test Control",
            "A/B Test Variation 1"
    );

    @Test(groups = "smoke")
    public void abTestingPageLoadsSuccessfully() {

        HomePage homePage = new HomePage(DriverManager.get());

        homePage.open();
        ABTestingPage abTestingPage = homePage.openABTesting();

        String actualHeading = abTestingPage.getHeading();

        Assert.assertTrue(
                EXPECTED_HEADINGS.contains(actualHeading),
                "Unexpected A/B Testing page heading: " + actualHeading
        );
    }
}
