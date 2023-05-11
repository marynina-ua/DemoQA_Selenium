package com.tests.WidgetsTests;

import com.pages.HomePage;
import com.pages.SideMenu;
import com.pages.Widgets.MenuPage;
import com.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openWidgets();
        new SideMenu(driver).openMenu();
    }

    @Test
    public void checkSubMenu() {
        Assert.assertTrue(new MenuPage(driver).openSubSubMenu().checkSubSubMenuText().contains("Item 1") );
    }

}
