package com.tests.FormsTests;

import com.pages.Forms.PracticeFormPage;
import com.pages.HomePage;
import com.pages.SideMenu;
import com.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class PracticeFormTest extends TestBase {

    public static final String CLOSE = "//*[@id=\"closeLargeModal\"]";
    public static final String CONFIRM_MESSAGE = "Thanks for submitting the form";

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).openForms();
        new SideMenu(driver).openPracticeForm();
    }

    @Test(priority = 0)
    public void correctStudentRegistrationForm() throws IOException {
        Assert.assertTrue( new PracticeFormPage(driver).typeName().confirmText().contains(CONFIRM_MESSAGE));
        Assert.assertTrue( driver.findElement(By.xpath(CLOSE)).isEnabled());
    }
    @Test(priority = 4)
    public void negativeFirstNameTest(){
        Assert.assertEquals( new PracticeFormPage(driver).namePresent(), "Eugenia");
    }

    @Test(priority = 1)
    public void submitFormWithEmptyCreds() {
//        String confirmationMessage = driver.getPageSource();
//        Assert.assertFalse(confirmationMessage.contains(CONFIRM_MESSAGE));
        Assert.assertFalse( new PracticeFormPage(driver).submitEmptyForm().formIsDisplayed());
    }

    @Test(priority = 2)
    public void countSelectedRadioButtons(){
       Assert.assertEquals(new PracticeFormPage(driver).clickOnMale().getSelectedRadioButtonsCount(), 1);
    }
    @Test(priority = 3)
    public void chooseAllHobbyCheckboxes(){
        Assert.assertTrue(new PracticeFormPage(driver).chooseAllHobbies().getSelectedCheckBoxCount());
    }
}
