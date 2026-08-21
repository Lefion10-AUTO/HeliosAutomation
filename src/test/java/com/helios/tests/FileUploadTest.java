package com.helios.tests;

import com.helios.driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileUploadPage;
import pages.HomePage;

public class FileUploadTest extends BaseTest {
    private static final String FILE_NAME = "test-upload.png";

    @Test(groups = "regression")
    public void testFileUpload() {
        HomePage homepage = new HomePage(DriverManager.get());
        homepage.open();

        FileUploadPage fileUploadPage = homepage.openFileUploadPage();
        fileUploadPage.uploadFile(FILE_NAME);

        Assert.assertTrue(fileUploadPage.isFileUploaded(FILE_NAME));

    }

}
