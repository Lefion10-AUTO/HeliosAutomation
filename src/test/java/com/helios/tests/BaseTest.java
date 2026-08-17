package com.helios.tests;

import com.helios.config.BrowserConfig;
import com.helios.driver.DriverManager;
import com.helios.utils.ScreenshotUtils;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected final BrowserConfig config = BrowserConfig.fromSystemProperties();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverManager.start(this.config);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            ScreenshotUtils.capture(DriverManager.get(), result.getName());
        }

        DriverManager.stop();
    }
}
