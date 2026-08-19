package pages;

import com.helios.config.UrlConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By pageHeading = By.tagName("h2");
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By flashMessage = By.id("flash");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(UrlConfig.login());
        waitForLoading();
    }

    void waitForLoading() {
        waitForElementVisible(pageHeading);
    }

    public SecureAreaPage login(String username, String password) {
        submitCredentials(username, password);

        SecureAreaPage secureAreaPage = new SecureAreaPage(driver);
        secureAreaPage.waitForLoading();
        return secureAreaPage;
    }

    public void attemptLogin(String username, String password) {
        submitCredentials(username, password);
        waitForElementVisible(flashMessage);
    }

    public String getFlashMessage() {
        return driver.findElement(flashMessage).getText();
    }

    public boolean isUserLoggedIn() {
        return driver.getCurrentUrl().equals(UrlConfig.secureArea());
    }

    private void submitCredentials(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        clickWhenClickable(loginButton);
    }
}
