package com.helios.tests;

import com.helios.config.BrowserConfig;
import com.helios.config.BrowserType;
import com.helios.driver.DriverManager;
import com.helios.driver.LocalWebDriverProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        BrowserConfig config = new BrowserConfig(BrowserType.CHROME, false, false, null);
        DriverManager.start(new LocalWebDriverProvider(), config);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.stop();
        // stops the driver belonging to the current thread
    }
}
