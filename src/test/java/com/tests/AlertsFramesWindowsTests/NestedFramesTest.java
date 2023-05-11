package com.tests.AlertsFramesWindowsTests;

import com.pages.AlertsFramesWindowsPages.NestedFramesPage;
import com.pages.HomePage;
import com.pages.SideMenu;
import com.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFramesTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openAlertsFrameWindowsPage();
        new SideMenu(driver).openNestedFramesPage();
    }

    @Test
    public void verifyTextInParentAndChildFrames(){
        Assert.assertTrue( new NestedFramesPage(driver).getParentFrameText().contains("Parent") );
        Assert.assertTrue( new NestedFramesPage(driver).getChildFrameText().contains("Child") );
    }
}
