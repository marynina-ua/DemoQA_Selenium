package com.tests.ElementsTest;

import com.pages.Elements.RadioButtonPage;
import com.pages.HomePage;
import com.pages.SideMenu;
import com.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTest extends TestBase {

    @BeforeMethod
    public void preconditions(){
        new HomePage(driver).openElements();
        new SideMenu(driver).openRadioButton();
    }

    @Test
    public void selectRadioButton() {
        Assert.assertTrue(new RadioButtonPage(driver).selectYes().checkSelected().contains("Yes"));
    }


}
