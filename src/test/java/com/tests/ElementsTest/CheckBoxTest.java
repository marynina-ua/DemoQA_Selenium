package com.tests.ElementsTest;

import com.pages.Elements.CheckBoxPage;
import com.pages.HomePage;
import com.pages.SideMenu;
import com.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxTest extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).openElements();
        new SideMenu(driver).openCheckBox();
    }
    @Test
    public void checkIfHomeCheckBoxIsSelected(){
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        Assert.assertTrue(checkBoxPage.clickOnElement(checkBoxPage.home).isSelectedHome(checkBoxPage.home));
    }

    @Test
    public void checkIfDesctopCheckBoxIsSelected(){
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        Assert.assertTrue(checkBoxPage.clickOnElement(checkBoxPage.homeToggler)
                                      .clickOnElement(checkBoxPage.desktop)
                                      .isSelectedHome(checkBoxPage.desktop));
    }

    @Test
    public void checkIfNotesCheckBoxIsSelected(){
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        Assert.assertTrue(checkBoxPage.clickOnElement(checkBoxPage.homeToggler)
                                      .clickOnElement(checkBoxPage.desktopToggler)
                                      .clickOnElement(checkBoxPage.notes)
                                      .isSelectedHome(checkBoxPage.notes));
    }
}
