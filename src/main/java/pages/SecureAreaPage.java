package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage {

    private final By flashMessageContent = By.id("flash");
    private final By header = By.tagName("h2");
    private final By subHeader = By.cssSelector("[class='subheader']");
    private final By logoutButton = By.cssSelector("[href='/logout']");

    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage logout() {
        driver.findElement(logoutButton).click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoading();
        return loginPage;
    }

    void waitForLoading() {
        waitForElementVisible(header);
    }

    public String getHeader() {
        return driver.findElement(header).getText();
    }

    public String getFlashMessageContent() {
        return driver.findElement(flashMessageContent).getText();
    }

    public String getSubHeader() {
        return driver.findElement(subHeader).getText();
    }

}
