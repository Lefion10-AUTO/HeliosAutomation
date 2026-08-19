package com.helios.tests;

import com.helios.driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FramesPage;
import pages.HomePage;
import pages.IFramePage;

public class IFrameTest extends BaseTest {

    String EDITOR_TEXT = "Your content goes here.";

    @Test(groups = "regression")
    public void testIFrame() {
        HomePage homePage = new HomePage(DriverManager.get());
        homePage.open();

        FramesPage framesPage = homePage.openFramesPage();
        IFramePage iFramePage = framesPage.openIFramePage();

        Assert.assertEquals(iFramePage.getEditorText(), EDITOR_TEXT, "The text in the iFrame editor does not match the expected text.");
    }

}
