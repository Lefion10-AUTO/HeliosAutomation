package pages;

import com.helios.config.UrlConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By pageHeading = By.tagName("h1");
    private final By abTestingLink = By.cssSelector("a[href='/abtest']");
    private final By dynamicLoadingLink = By.cssSelector("a[href='/dynamic_loading']");
    private final By framesLink = By.cssSelector("a[href='/frames']");
    private final By javaScriptAlertsLink = By.cssSelector("a[href='/javascript_alerts']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(UrlConfig.home());
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

    public FramesPage openFramesPage() {
        clickWhenClickable(framesLink);

        FramesPage framesPage = new FramesPage(driver);
        framesPage.waitForLoading();
        return framesPage;
    }

    public JavaScriptAlertsPage openJavaScriptAlertsPage() {
        clickWhenClickable(javaScriptAlertsLink);

        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
        javaScriptAlertsPage.waitForLoading();
        return javaScriptAlertsPage;
    }

}