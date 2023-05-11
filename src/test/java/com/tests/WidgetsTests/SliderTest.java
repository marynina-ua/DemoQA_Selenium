package com.tests.WidgetsTests;

import com.pages.HomePage;
import com.pages.SideMenu;
import com.pages.Widgets.SliderPage;
import com.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderTest extends TestBase {


    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openWidgets();
        new SideMenu(driver).openSlider();
    }

    @Test
    public void sliderTestWithDoWhile(){
        SliderPage sliderPage = new SliderPage(driver);
        sliderPage.moveSliderWithDoWhile("50");
        Assert.assertEquals(sliderPage.getAttribute(), "50");
        Assert.assertEquals(sliderPage.getSliderValue(), "50");
    }

    @Test
    public void sliderTestWithFor(){
        SliderPage sliderPage = new SliderPage(driver);
        sliderPage.moveSliderWithFor("75");
        Assert.assertEquals(sliderPage.getAttribute(), "75");
        Assert.assertEquals(sliderPage.getSliderValue(), "75");
    }
}
