package com.helios.tests;

import com.helios.config.BrowserConfig;
import com.helios.config.BrowserType;
import com.helios.driver.DriverManager;
import com.helios.utils.ScreenshotUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;

public class BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        BrowserConfig config = new BrowserConfig(BrowserType.CHROME, false, false, null);
        DriverManager.start(config);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            ScreenshotUtils.capture(DriverManager.get(), result.getName());
        }

        DriverManager.stop();
    }
}
