package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final String URL = "https://the-internet.herokuapp.com/";

    private final By pageHeading = By.tagName("h1");
    private final By abTestingLink = By.cssSelector("a[href='/abtest']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(URL);
        waitForLoading();
    }

    private void waitForLoading() {
        waitForElementVisible(pageHeading);
    }

    public boolean isABTestingButtonVisible() {
        return driver.findElement(abTestingLink).isDisplayed();
    }
}