package com.tests.AlertsFramesWindowsTests;

import com.pages.AlertsFramesWindowsPages.AlertsPage;
import com.pages.HomePage;
import com.pages.SideMenu;
import com.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTest extends TestBase {

    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openAlertsFrameWindowsPage();
        new SideMenu(driver).openAlertsPage();
    }

    @Test
    public void invokeAlert() {
        new AlertsPage(driver).clickOnSimpleAlert();
    }

    @Test
    public void simpleAlert5Secs() {
        new AlertsPage(driver).clickOnSimpleAlertWithTimer();
    }

    @Test
    public void confirmBoxTest() {
        Assert.assertTrue(new AlertsPage(driver).clickOnConfirmBox("OK").getConfirmText().contains("Ok"));
        Assert.assertTrue(new AlertsPage(driver).clickOnConfirmBox("Cancel").getConfirmText().contains("Cancel"));
    }

    @Test
    public void enterTextToPromptTest() {
        String name = "Evheniia";
        new AlertsPage(driver).enterTextToPrompt(name);
        Assert.assertTrue(new AlertsPage(driver).getPromptResult().contains(name));
    }
}
