package com.helios.tests;

import com.helios.config.BrowserConfig;
import com.helios.driver.DriverManager;
import listeners.RetryListener;
import listeners.TestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({RetryListener.class, TestListener.class})
public class BaseTest {

    protected final BrowserConfig config = BrowserConfig.fromSystemProperties();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverManager.start(this.config);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.stop();
    }
}
