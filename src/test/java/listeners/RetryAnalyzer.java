package listeners;

import com.helios.config.TestConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private static final Logger log = LoggerFactory.getLogger(RetryAnalyzer.class);

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

            log.warn("Retrying test {} | attempt {}/{}", result.getName(), retryCount, maxRetries);

            return true;
        }

        return false;
    }
}