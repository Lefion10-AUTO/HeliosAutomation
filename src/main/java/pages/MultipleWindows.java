package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MultipleWindows extends BasePage {

    private final By pageHeading = By.xpath("//h3[contains(text(), 'Opening a new window')]");
    private final By clickHereLink = By.cssSelector("a[href='/windows/new']");
    private final By newWindowHeading = By.xpath("//h3[contains(text(), 'New Window')]");
    private String originalWindow;

    public MultipleWindows(WebDriver driver) {
        super(driver);
    }


    void waitForLoading() {
        waitForElementVisible(pageHeading);
    }

    public void openNewWindow() {
        originalWindow = driver.getWindowHandle();

        clickWhenClickable(clickHereLink);
        switchToNewWindow();
    }

    private void switchToNewWindow() {
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void switchToOriginalWindow() {
        driver.switchTo().window(originalWindow);
    }

    public boolean isPageHeadingVisible() {
        return isElementVisible(pageHeading);
    }

    public boolean isNewWindowHeadingVisible() {
        return isElementVisible(newWindowHeading);
    }

}
