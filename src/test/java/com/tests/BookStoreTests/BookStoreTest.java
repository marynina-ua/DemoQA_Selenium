package com.tests.BookStoreTests;

import com.pages.BookStore.BookStorePage;
import com.pages.HomePage;
import com.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookStoreTest extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).openBookStoreApp();
    }


    @Test
    public void searchForBookTest(){
        new BookStorePage(driver).searchBook("Web");
        Assert.assertTrue(new BookStorePage(driver).getFirstBookTitle().contains("Web"));
    }

}
