package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final String URL = "https://the-internet.herokuapp.com/";

    private final By pageHeading = By.tagName("h1");
    private final By abTestingLink = By.cssSelector("a[href='/abtest']");
    private final By dynamicLoadingLink = By.cssSelector("a[href='/dynamic_loading']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(URL);
        waitForLoading();
    }

    void waitForLoading() {
        waitForElementVisible(pageHeading);
    }

    public ABTestingPage openABTesting() {
        clickWhenClickable(abTestingLink);

        ABTestingPage abTestingPage = new ABTestingPage(driver);
        abTestingPage.waitForLoading();
        return abTestingPage;
    }

    public DynamicLoadingPage openDynamicLoading() {
        clickWhenClickable(dynamicLoadingLink);

        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);
        dynamicLoadingPage.waitForLoading();
        return dynamicLoadingPage;
    }

}