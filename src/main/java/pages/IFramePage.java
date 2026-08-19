package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class IFramePage extends BasePage {

    private final By header = By.xpath("//h3[contains(text(),'An iFrame containing the TinyMCE WYSIWYG Editor')]");
    private final By editorFrame = By.id("mce_0_ifr");
    private final By editorBody = By.id("tinymce");

    public IFramePage(WebDriver driver) {
        super(driver);
    }

    void waitForLoading() {
        waitForElementVisible(header);
    }

    private void switchToIFrame() {
        driver.switchTo().frame(driver.findElement(editorFrame));
    }

    public String getEditorText() {
        switchToIFrame();

        String text = driver.findElement(editorBody).getText();

        driver.switchTo().defaultContent();
        return text;
    }

    public void setEditorText(String text) {
        switchToIFrame();

        clearWithKeyboard(editorBody);
        driver.findElement(editorBody).sendKeys(text);

        driver.switchTo().defaultContent();
    }

}