package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ABTestingPage extends BasePage {

    private final By heading = By.tagName("h3");

    public ABTestingPage(WebDriver driver) {
        super(driver);
    }

    void waitForLoading() {
        waitForElementVisible(heading);
    }

    public String getHeading() {
        return driver.findElement(heading).getText();
    }
}