package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage extends BasePage {

    private final By pageHeading = By.xpath("//h3[contains(text(),'JavaScript Alerts')]");
    private final By jsAlertButton = By.cssSelector("button[onclick='jsAlert()']");
    private final By jsConfirmButton = By.cssSelector("button[onclick='jsConfirm()']");
    private final By jsPromptButton = By.cssSelector("button[onclick='jsPrompt()']");
    private final By resultText = By.id("result");

    protected JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }


    void waitForLoading() {
        waitForElementVisible(pageHeading);
    }

    public void clickJSAlertButton() {
        clickWhenClickable(jsAlertButton);
    }

    public void clickJSConfirmButton() {
        clickWhenClickable(jsConfirmButton);
    }

    public void clickJSPromptButton() {
        clickWhenClickable(jsPromptButton);
    }

    public String getResultText() {
        waitForElementVisible(resultText);
        return driver.findElement(resultText).getText();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void enterPromptText(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public void acceptPrompt() {
        driver.switchTo().alert().accept();
    }
}
