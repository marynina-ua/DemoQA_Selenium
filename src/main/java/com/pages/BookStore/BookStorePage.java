package com.pages.BookStore;

import com.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookStorePage extends PageBase {

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]")
    WebElement loginPageLink;

    public LoginPage openLoginPage() {
        clickWithJSExecutor(loginPageLink, 0, 200);
        this.wait(500);
        return new LoginPage(driver);
    }



    @FindBy(id="searchBox")
    WebElement searchBox;

    public BookStorePage searchBook(String web) {
        type(searchBox, web);
        wait(500);
        return this;
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div/span/a")
    WebElement firstBook;

    public String getFirstBookTitle() {
        return firstBook.getText();
    }

    public BookStorePage openFirstBook() {
        click(firstBook);
        wait(5000);
        return this;
    }

    @FindBy(xpath="/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]/button")
    WebElement addNewRecordButton;

    public BookStorePage addToYourCollection() {
        hideAds();
        wait(1000);
        clickWithJSExecutor(addNewRecordButton, 0, 350);
        wait(1000);
        driver.switchTo().alert().accept();
        return this;
    }
}
