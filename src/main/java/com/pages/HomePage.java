package com.pages;

import com.pages.AlertsFramesWindowsPages.AlertsPage;
import com.pages.BookStore.BookStorePage;
import com.pages.Widgets.MenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//*[@id=\"app\"]/div/div/div[2]/div/div[6]")
    WebElement bookStoreAppLink;

    public BookStorePage openBookStoreApp(){
        clickWithJSExecutor(bookStoreAppLink, 0, 300);
        return new BookStorePage(driver);
    }

    @FindBy(xpath="//*[@id=\"app\"]/div/div/div[2]/div/div[3]/div/div[3]")
    WebElement alertsFrameWindowsLink;

    public AlertsPage openAlertsFrameWindowsPage() {
        click(alertsFrameWindowsLink);
        return new AlertsPage(driver);

    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[4]")
    WebElement widgetsLink;

    public SideMenu openWidgets() {
        hideAds();
        click(widgetsLink);
        return new SideMenu(driver);
    }


    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]")
    WebElement elementsPageLink;

    public SideMenu openElements() {
        click(elementsPageLink);
        wait(2000);
        return new SideMenu(driver);
    }

    @FindBy(xpath = "//span[.='Menu']")
    WebElement menuPageLink;

    public MenuPage openMenu() {
        clickWithJSExecutor(menuPageLink, 0, 350);
        return new MenuPage(driver);
    }

//------------------------------------------------------------------
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[5]")
    WebElement interactionsPageLink;


    public SideMenu openInteractions() {
        hideAds();
        click(interactionsPageLink);
        return new SideMenu(driver);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[2]")
    WebElement formsPageLink;

    public SideMenu openForms() {
//        hideAds();
        click(formsPageLink);
        return new SideMenu(driver);
    }
//----------------------------------------------------------------------
}
