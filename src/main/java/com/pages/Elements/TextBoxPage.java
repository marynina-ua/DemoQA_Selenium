package com.pages.Elements;

import com.pages.PageBase;
import com.pages.data.TextBoxData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;

public class TextBoxPage extends PageBase {

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="userName")
    WebElement fullName;
    @FindBy(id="userEmail")
    WebElement email;
    @FindBy(id="currentAddress")
    WebElement currentAddress;
    @FindBy(id="permanentAddress")
    WebElement permanentAddress;
    @FindBy(id="submit")
    WebElement submit;
    @FindBy(id="output")
    WebElement output;


    public void fillAndSubmitForm() throws IOException, UnsupportedFlavorException {
        hideAds();

        type(fullName, TextBoxData.FULLNAME);
        type(email, TextBoxData.EMAIL);
        type(currentAddress, TextBoxData.ADDRESS);

        Actions action = new Actions(driver);
        
        Keys cmdCtrl = getCmdCtrl();

        action.keyDown(currentAddress, cmdCtrl).sendKeys("a").keyUp(cmdCtrl).perform();
        action.keyDown(cmdCtrl).sendKeys("c").keyUp(cmdCtrl).perform();

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);

        String result = (String)contents.getTransferData(DataFlavor.stringFlavor);

        if (result.equals(TextBoxData.ADDRESS))
        {
            action.sendKeys(Keys.TAB).perform();
            action.keyDown(cmdCtrl).sendKeys("v").keyUp(cmdCtrl).perform();
        }

        clickWithJSExecutor(submit, 0, 150);
    }

    public String checkSubmittedData() {
        System.out.println(output.getText());
        return output.getText();
    }

    public String getPermanentAddress(){
        return permanentAddress.getAttribute("value");
    }



    public void fillTextBox(String name, String emailA, String currentAddressA, String permanentAddressA) {
        fullName.clear();
        fullName.sendKeys(name);
        email.clear();
        email.sendKeys(emailA);
        currentAddress.clear();
        currentAddress.sendKeys(currentAddressA);
        permanentAddress.clear();
        permanentAddress.sendKeys(permanentAddressA);
        submit.click();
    }

    public void waitText() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElement(output, "Name"));
    }

    public String getTextFromInfoField(String idName) {
        return driver.findElement(By.xpath(String.format("//p[@id='%s']", idName))).getText();
    }
}
