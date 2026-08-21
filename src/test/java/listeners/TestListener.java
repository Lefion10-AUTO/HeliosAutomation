package listeners;

import com.helios.driver.DriverManager;
import com.helios.utils.ScreenshotUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {

    private static final Logger log = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test passed: {}", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        DriverManager.currentDriver().ifPresent(driver -> {
            try {
                log.error("Test failed: {} | url={}", result.getName(), driver.getCurrentUrl());

                ScreenshotUtils.capture(driver, result.getName());

            } catch (Exception e) {
                log.warn("Failed to collect diagnostics for test {}", result.getName(), e);
            }
        });
    }
}