package com.tests.ElementsTest;

import com.github.javafaker.Faker;
import com.pages.Elements.TextBoxPage;
import com.pages.HomePage;
import com.pages.SideMenu;
import com.pages.data.TextBoxData;
import com.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class TextBoxTest extends TestBase {

    Faker faker = new Faker();
    String name = faker.name().firstName();
    String email = faker.internet().emailAddress();
    String currentAddress = faker.address().fullAddress();
    String permanentAddress = faker.address().fullAddress();

    TextBoxPage textBoxPage;

    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openElements();
        new SideMenu(driver).openTextBox();
    }

    @Test // Current and Permanent addresses are equal
    public void simpleFormSubmit() throws IOException, UnsupportedFlavorException{
        new TextBoxPage(driver).fillAndSubmitForm();
        Assert.assertTrue(new TextBoxPage(driver).checkSubmittedData().contains(TextBoxData.FULLNAME));
        Assert.assertTrue(new TextBoxPage(driver).checkSubmittedData().contains(TextBoxData.ADDRESS));
        Assert.assertTrue(new TextBoxPage(driver).checkSubmittedData().contains(TextBoxData.EMAIL));
        Assert.assertEquals(new TextBoxPage(driver).getPermanentAddress(),TextBoxData.ADDRESS);
    }


    @Test // every field "assertEquals"
    public void textBoxTestWithFaker() {
        textBoxPage = new TextBoxPage(driver);
        textBoxPage.fillTextBox(name, email, currentAddress, permanentAddress);
        textBoxPage.waitText();

        Assert.assertEquals(textBoxPage.getTextFromInfoField("name"), "Name:" + name);
        Assert.assertEquals(textBoxPage.getTextFromInfoField("email"), "Email:" + email);
        Assert.assertEquals(textBoxPage.getTextFromInfoField("currentAddress"),
                "Current Address :" + currentAddress);
        Assert.assertEquals(textBoxPage.getTextFromInfoField("permanentAddress"),
                "Permananet Address :" + permanentAddress);
    }
}
