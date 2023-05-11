package com.tests.ElementsTest;

import com.pages.Elements.DynamicPropertiesPage;
import com.pages.HomePage;
import com.pages.SideMenu;
import com.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicPropertiesTest extends TestBase {

    @BeforeMethod
    public void preconditionds() {
        new HomePage(driver).openElements();
        new SideMenu(driver).openDynamicProperties();
    }
    @Test
    public void visibleButton(){
        new DynamicPropertiesPage(driver).waitButton();
    }
}