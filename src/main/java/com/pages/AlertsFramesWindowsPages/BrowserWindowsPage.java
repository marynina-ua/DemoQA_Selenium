package com.pages.AlertsFramesWindowsPages;

import com.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsPage extends PageBase {

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="tabButton")
    WebElement newTabButton;

    @FindBy(id="windowButton")
    WebElement newWindowButton;

    @FindBy(id="messageWindowButton")
    WebElement newMessageWindowButton;

    public BrowserWindowsPage openNewTab() {
        click(newTabButton);
        //String thisWindow = driver.getWindowHandle();
        List<String> allWindows = new ArrayList<>(driver.getWindowHandles());
        String tabName = allWindows.get(1);
        driver.switchTo().window(tabName);
        return this;
    }

    @FindBy(id="sampleHeading")
    WebElement newPageHeading;

    public String getNewPageHeading(){
        return newPageHeading.getText();
    }

    public BrowserWindowsPage openNewWindow() {

        String thisWindow = driver.getWindowHandle();

        click(newWindowButton);

        for (String windowH : driver.getWindowHandles())
        {
            System.out.println(windowH);
            if (!thisWindow.contentEquals(windowH))
            {
                driver.switchTo().window(windowH);
                break;
            }
        }
        return this;
    }

    public BrowserWindowsPage closeWindow(){
        driver.close();
        return this;
    }

    public BrowserWindowsPage openNewWindowMessage() {
        click(newMessageWindowButton);
        wait(1000);
        List<String> allWindows = new ArrayList<>(driver.getWindowHandles());
        String tabName = allWindows.get(1);
        driver.switchTo().window(tabName);
        return this;
    }
    @FindBy(xpath = "/html/body")
    WebElement messageWindowBody;

    public String getMessageWindowBody() {
        return messageWindowBody.getText();
    }
}
