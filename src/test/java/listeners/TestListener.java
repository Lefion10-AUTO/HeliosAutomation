package listeners;

import com.helios.driver.DriverManager;
import com.helios.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        DriverManager.currentDriver()
                .ifPresent(driver ->
                        ScreenshotUtils.capture(driver, result.getName())
                );
    }
}