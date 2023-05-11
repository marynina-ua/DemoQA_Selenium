package com.tests.WidgetsTests;

import com.pages.HomePage;
import com.pages.SideMenu;
import com.pages.Widgets.SelectMenuPage;
import com.tests.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectMenuTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openWidgets();
        new SideMenu(driver).openSelectMenu();
    }

    // Preconditions: 1. Open Home Page 2. Open Widgets 3. Open Select menu

    @Test
    public void fillInTwoSelectFields() {
        Assert.assertTrue( new SelectMenuPage(driver).choseFromSelectValue().getSelectValueText().contains("Group 1") );
        Assert.assertTrue( new SelectMenuPage(driver).choseFromSelectOne().getSelectOneText().contains("Prof.") );
    }


    // Title: The value of old style select is Yellow if we chose Yellow

    @Test
    public void oldStyleSelectMenu() {

        SelectMenuPage ourPage = new SelectMenuPage(driver);

        // Step 1: Click on dropdown menu (old style select menu)
        // Step 2: Chose Yellow by clicking on this value in the list
        ourPage.choseYellowFromOldStyleSelect();

        // Expected result: Yellow is selected in the old style select
        String ourText = ourPage.getOldStyleSelectValueText();
        Assert.assertTrue( ourText.contains("Yellow") );

        //Assert.assertTrue( new SelectMenuPage(driver).choseFromOldStyleSelect().getOldStyleSelectValue().contains("Yellow") );
    }

    @Test
    public void standardMultiSelect() {
        List<WebElement> selectedItems = new SelectMenuPage(driver).choseTwoCars().standartMultiSelectValueTexts();
        Assert.assertTrue(selectedItems.get(0).getText().contains("Volvo"));
        Assert.assertTrue(selectedItems.get(1).getText().contains("Opel"));
    }
}
