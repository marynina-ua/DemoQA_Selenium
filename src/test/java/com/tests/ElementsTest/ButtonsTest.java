package com.tests.ElementsTest;

import com.pages.Elements.ButtonsPage;
import com.pages.HomePage;
import com.pages.SideMenu;
import com.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTest extends TestBase {

    // Pre-conditions: Buttons page is opened
    @BeforeMethod
    public void preconditionds() {
        new HomePage(driver).openElements();
        new SideMenu(driver).openButtons();
    }

    // Title: Check double click message is displayed after Double Click Me button is double clicked
    @Test
    public void clickOnDoubleClickButton() {
        // Step1: Double click on Double Click Me button
        // Expected result: Double click message is displayed
        Assert.assertTrue( new ButtonsPage(driver).doubleClick().getDCMsg().contains("double") );
    }

    // Title: Check right click message is displayed after Right Click Me button is right clicked
    @Test
    public void clickOnRightClickButton() {
        // Step1: Right click on Right Click Me button
        // Expected result: Right click message is displayed
        Assert.assertTrue( new ButtonsPage(driver).rightClick().getRCMsg().contains("right") );
    }
}
