package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage extends BasePage {

    private final By pageHeading = By.xpath("//h3[contains(text(), 'Frames')]");
    private final By nestedFramesLink = By.cssSelector("a[href='/nested_frames']");
    private final By iFrameLink = By.cssSelector("a[href='/iframe']");

    protected FramesPage(WebDriver driver) {
        super(driver);
    }

    void waitForLoading() {
        waitForElementVisible(pageHeading);
    }

    public IFramePage openIFramePage() {
        clickWhenClickable(iFrameLink);

        IFramePage iFramePage = new IFramePage(driver);
        iFramePage.waitForLoading();
        return iFramePage;
    }

}
