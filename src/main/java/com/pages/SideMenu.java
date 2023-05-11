package com.pages;

import com.pages.AlertsFramesWindowsPages.AlertsPage;
import com.pages.AlertsFramesWindowsPages.BrowserWindowsPage;
import com.pages.AlertsFramesWindowsPages.FramesPage;
import com.pages.AlertsFramesWindowsPages.NestedFramesPage;
import com.pages.BookStore.ProfilePage;
import com.pages.Elements.*;
import com.pages.BookStore.BookStorePage;
import com.pages.BookStore.LoginPage;
import com.pages.Forms.PracticeFormPage;
import com.pages.Interactions.DroppablePage;
import com.pages.Widgets.MenuPage;
import com.pages.Widgets.ProgressBarPage;
import com.pages.Widgets.SelectMenuPage;
import com.pages.Widgets.SliderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideMenu extends PageBase {

    public SideMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]")
    WebElement loginPageLink;

    public LoginPage openLoginPage() {
        clickWithJSExecutor(loginPageLink, 0, 200);
        wait(500);
        return new LoginPage(driver);
    }

    @FindBy(xpath="/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[2]")
    WebElement alertsPageLink;

    public AlertsPage openAlertsPage() {
        clickWithJSExecutor(alertsPageLink, 0, 200);
        return new AlertsPage(driver);
    }

    @FindBy(xpath ="/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]")
    WebElement profilePageLink;

    public ProfilePage openProfilePage() {
        clickWithJSExecutor(profilePageLink, 0,300);
        return new ProfilePage(driver);
    }

    @FindBy(xpath = "//span[.='Book Store']")
    WebElement bookStorePageLink;

    public BookStorePage openBookStorePage() {
        wait(1000);
        clickWithJSExecutor(bookStorePageLink, 0, 500);
        return new BookStorePage(driver);
    }

    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindowsLink;
    public BrowserWindowsPage openBrowserWindowsPage() {
        click(browserWindowsLink);
        return new BrowserWindowsPage(driver);
    }

    @FindBy(xpath = "//span[.='Frames']")
    WebElement framesPage;

    public FramesPage openFramesPage() {
        clickWithJSExecutor(framesPage, 0, 250);
        return new FramesPage(driver);
    }

    @FindBy(xpath = "//span[.='Nested Frames']")
    WebElement nestedFramesPage;

    public NestedFramesPage openNestedFramesPage() {
        clickWithJSExecutor(nestedFramesPage, 0, 250);
        return new NestedFramesPage(driver);
    }

    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenuPageLink;

    public SelectMenuPage openSelectMenu() {
        clickWithJSExecutor(selectMenuPageLink, 0, 400);
        wait(1000);
        return new SelectMenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Text Box']")
    WebElement textBoxPageLink;

    public TextBoxPage openTextBox() {
        click(textBoxPageLink);
        return new TextBoxPage(driver);
    }

    @FindBy(xpath = "//span[.='Buttons']")
    WebElement buttonsPageLink;

    public ButtonsPage openButtons() {
        clickWithJSExecutor(buttonsPageLink, 0, 200);
        wait(1000);
        return new ButtonsPage(driver);
    }


    @FindBy(xpath = "//span[.='Upload and Download']")
    WebElement uploadAndDownloadPageLink;

    public UploadAndDownloadPage openUploadandDownloadPage() {
        clickWithJSExecutor(uploadAndDownloadPageLink, 0, 300);
        return new UploadAndDownloadPage(driver);
    }


    @FindBy(xpath = "//span[.='Broken Links - Images']")
    WebElement brokenLinksImagesLink;

    public BrokenLinksImagesPage openBrokenLinksImages() {
        clickWithJSExecutor(brokenLinksImagesLink, 0, 250);
        return new BrokenLinksImagesPage(driver);
    }

    @FindBy(xpath = "//span[.='Menu']")
    WebElement menuPageLink;

    public MenuPage openMenu() {
        clickWithJSExecutor(menuPageLink, 0, 350);
        return new MenuPage(driver);
    }


    @FindBy(xpath = "//span[.='Radio Button']")
    WebElement radioButtonLink;

    public RadioButtonPage openRadioButton() {
        clickWithJSExecutor(radioButtonLink, 0, 300);
        return new RadioButtonPage(driver);
    }


    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceForm;

    public PracticeFormPage openPracticeForm() {
        clickWithJSExecutor(practiceForm, 0, 200);
        return new PracticeFormPage(driver);
    }

    @FindBy(xpath = "//span[.='Check Box']")
    WebElement checkBox;

    public CheckBoxPage openCheckBox() {
        clickWithJSExecutor(checkBox, 0, 50);
        return new CheckBoxPage(driver);
    }

    @FindBy(xpath = "//span[.='Dynamic Properties']")
    WebElement dynamicProperties;

    public DynamicPropertiesPage openDynamicProperties() {
        clickWithJSExecutor(dynamicProperties, 0, 150);
        return new DynamicPropertiesPage(driver);
    }

    @FindBy(xpath = "//span[.='Progress Bar']")
    WebElement progressBar;

    public ProgressBarPage openProgressBar(){
        clickWithJSExecutor(progressBar, 0, 150);
        return new ProgressBarPage(driver);
    }

    @FindBy(xpath = "//span[.='Slider']")
    WebElement slider;

    public SliderPage openSlider() {
        clickWithJSExecutor(slider, 0, 150);
        return new SliderPage(driver);
    }


    @FindBy(xpath = "//span[.='Web Tables']")
    WebElement webTables;

    public WebTablesPage openWebTables() {
        click(webTables);
        return new WebTablesPage(driver);
    }


    @FindBy(xpath = "//span[.='Droppable']")
    WebElement droppableLink;

    public DroppablePage openDroppablePage() {
        clickWithJSExecutor(droppableLink, 0, 350);
        return new DroppablePage(driver);
    }

}
