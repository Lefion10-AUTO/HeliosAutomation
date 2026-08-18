package listeners;

import com.helios.config.TestConfig;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private final int maxRetries;
    private int retryCount = 0;

    public RetryAnalyzer() {
        this.maxRetries = TestConfig.retryCount();
    }

    @Override
    public boolean retry(ITestResult result) {

        if (result.getMethod().isBeforeMethodConfiguration()) {
            return false;
        }

        if (maxRetries <= 0) {
            return false;
        }

        if (retryCount < maxRetries) {
            retryCount++;
            return true;
        }

        return false;
    }
}