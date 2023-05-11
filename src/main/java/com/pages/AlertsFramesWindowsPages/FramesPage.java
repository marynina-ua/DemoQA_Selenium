package com.pages.AlertsFramesWindowsPages;

import com.pages.PageBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FramesPage extends PageBase {
    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> iframes;

    public int getFramesNumber() {
        //return iframes.size();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Integer numberOfFrames = Integer.parseInt( js.executeScript("return window.length").toString() );
        return numberOfFrames;
    }

    @FindBy(id = "frame1")
    WebElement frame1;

    public FramesPage switchToFrameById() {
        driver.switchTo().frame(frame1);
        return this;
    }

    @FindBy(id="sampleHeading")
    WebElement sampleHeading;

    public String getH1() {
        return sampleHeading.getText();
    }
}
