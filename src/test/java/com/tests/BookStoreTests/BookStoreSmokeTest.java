package com.tests.BookStoreTests;

import com.pages.BookStore.BookStorePage;
import com.pages.BookStore.LoginPage;
import com.pages.BookStore.ProfilePage;
import com.pages.HomePage;
import com.pages.SideMenu;
import com.pages.data.LoginData;
import com.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookStoreSmokeTest extends TestBase {

    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openBookStoreApp();
        new SideMenu(driver).openLoginPage();
    }

    @Test
    public void bookStoreSmokeTest(){
        String title = "Web";
        new LoginPage(driver).login(LoginData.USERNAME, LoginData.PASSWORD);
        new SideMenu(driver).openBookStorePage();
        new BookStorePage(driver).searchBook(title).openFirstBook();
        new BookStorePage(driver).addToYourCollection();
        new SideMenu(driver).openProfilePage();
        Assert.assertTrue( new ProfilePage(driver).getFirstBookTitle().contains(title) );
    }

    @AfterMethod
    public void deleteBookAndLogOut() {
        new ProfilePage(driver).deleteBook().logOut();
    }

}
