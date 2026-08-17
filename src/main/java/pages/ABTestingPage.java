package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ABTestingPage extends BasePage {

    private final By heading = By.tagName("h3");

    public ABTestingPage(WebDriver driver) {
        super(driver);
    }

    private void waitForLoading() {
        waitForElementVisible(heading);
    }

    public boolean isLoaded() {
        waitForLoading();
        return driver.findElement(heading).isDisplayed();
    }
}