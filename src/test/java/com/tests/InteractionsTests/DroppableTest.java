package com.tests.InteractionsTests;

import com.pages.HomePage;
import com.pages.Interactions.DroppablePage;
import com.pages.SideMenu;
import com.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DroppableTest extends TestBase {
    public static final String DROPPED = "Dropped!";

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openInteractions();
        new SideMenu(driver).openDroppablePage();
    }

    @Test (priority = 1)
    public void dragHereTest() {
        Assert.assertTrue( new DroppablePage(driver).testDroppableHere().getDroppedResult().contains(DROPPED) );
    }


    @Test (priority = 2)
    public void dragByOffsetElement() {
        Assert.assertTrue( new DroppablePage(driver).testDroppableByOffset().getDroppedResult().contains(DROPPED) );
    }


    @Test (priority = 3)
    public void simpleDragAndDropTest() {
        Assert.assertEquals( new DroppablePage(driver).dragElement().getResultStatus(), DROPPED);
    }
}
