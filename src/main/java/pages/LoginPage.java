package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static final String URL = "https://the-internet.herokuapp.com/login";

    private final By pageHeading = By.tagName("h2");
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(URL);
        waitForLoading();
    }

    void waitForLoading() {
        waitForElementVisible(pageHeading);
    }

    public SecureAreaPage login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();

        SecureAreaPage secureAreaPage = new SecureAreaPage(driver);
        secureAreaPage.waitForLoading();
        return secureAreaPage;
    }

    public boolean isUserLoggedIn() {
        return driver.getCurrentUrl().contains("/secure");
    }
}
