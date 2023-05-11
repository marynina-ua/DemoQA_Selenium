package com.tests.WidgetsTests;

import com.pages.HomePage;
import com.pages.SideMenu;
import com.pages.Widgets.ProgressBarPage;
import com.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProgressBarTest extends TestBase {

    String percent = Integer.toString(faker.number().numberBetween(10, 99));
    String actualPercent;
    ProgressBarPage progressBarPage;

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openWidgets();
        new SideMenu(driver).openProgressBar();
    }

    @Test
    public void progressBarTest() {
        progressBarPage = new ProgressBarPage(driver);
        progressBarPage.clickToButton();
        progressBarPage.clickToStop(percent);
        actualPercent = progressBarPage.getPercent();
        Assert.assertEquals(actualPercent, percent + "%");
        System.out.println(percent);
    }

    @Test
    public void progressBarCompleted(){
        progressBarPage = new ProgressBarPage(driver);
        progressBarPage.clickToButton();
        progressBarPage.webDriverWait();
        Assert.assertTrue(progressBarPage.ResetButtonIsClickable());
    }
}
