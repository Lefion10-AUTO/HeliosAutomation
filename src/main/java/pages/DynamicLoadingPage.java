package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage extends BasePage{

    private final By header = By.xpath("//h3[contains(text(),'Dynamically Loaded Page Elements')]");
    private final By example2Link = By.cssSelector("a[href='/dynamic_loading/2']");
    private final By startButton = By.id("start");
    private final By loadingIndicator = By.id("loading");
    private final By loadedText = By.id("finish");

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    public void waitForLoading() {
        waitForElementVisible(header);
    }

    public void openExample2() {
        clickWhenClickable(example2Link);
    }

    public void clickStartButton() {
        clickWhenClickable(startButton);
        waitForElementVisible(loadingIndicator);
        waitForElementToBeInvisible(loadingIndicator);
    }

    public String getLoadedText() {
        waitForElementVisible(loadedText);
        return driver.findElement(loadedText).getText();
    }

}
