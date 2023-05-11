package com.tests.ElementsTest;

import com.pages.Elements.BrokenLinksImagesPage;
import com.pages.HomePage;
import com.pages.SideMenu;
import com.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksImagesTest extends TestBase {

    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openElements();
        new SideMenu(driver).openBrokenLinksImages();
    }

    // Title: Check page for broken images (not displayed, non-existent source)
    @Test
    public void checkBrokenImages() {
        Assert.assertEquals( new BrokenLinksImagesPage(driver).checkNoBrokenImages(), 0 );
    }
    @Test
    public void checkBrokenLinks() {
        Assert.assertEquals(new BrokenLinksImagesPage(driver).checkNumberBrokenLinks(), 0 );
    }

}
