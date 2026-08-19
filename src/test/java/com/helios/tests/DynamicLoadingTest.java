package com.helios.tests;

import com.helios.driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;
import pages.HomePage;

public class DynamicLoadingTest extends BaseTest{

    String EXPECTED_LOADED_TEXT = "Hello World!";

    @Test (groups = "regression")
    public void testDynamicLoading() {
        HomePage homePage = new HomePage(DriverManager.get());
        homePage.open();

        DynamicLoadingPage dynamicLoadingPage = homePage.openDynamicLoading();
        dynamicLoadingPage.openExample2();
        dynamicLoadingPage.clickStartButton();

        Assert.assertEquals(dynamicLoadingPage.getLoadedText(), EXPECTED_LOADED_TEXT, "Loaded text does not match expected value");
    }
}
