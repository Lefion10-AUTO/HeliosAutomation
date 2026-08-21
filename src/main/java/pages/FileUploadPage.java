package pages;

import com.helios.utils.ResourceUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends BasePage {

    private final By pageHeading = By.xpath("//h3[contains(text(), 'File Uploader')]");
    private final By chooseFileButton = By.id("file-upload");
    private final By uploadButton = By.id("file-submit");
    private final By uploadedFiles = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    void waitForLoading() {
        waitForElementVisible(pageHeading);
    }

    public void uploadFile(String fileName) {
        String filePath =
                ResourceUtils.getFilePath("files/" + fileName);

        driver.findElement(chooseFileButton).sendKeys(filePath);
        clickWhenClickable(uploadButton);
        waitForUpload();
    }

    private void waitForUpload() {
        waitForElementVisible(uploadedFiles);
    }

    public boolean isFileUploaded(String fileName) {
        waitForElementVisible(uploadedFiles);
        String uploadedFileName = driver.findElement(uploadedFiles).getText();

        return uploadedFileName.equals(fileName);
    }


}
