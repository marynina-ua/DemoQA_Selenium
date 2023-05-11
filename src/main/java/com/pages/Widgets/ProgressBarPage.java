package com.pages.Widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProgressBarPage {
    WebDriver driver;

    public ProgressBarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id=\"startStopButton\"]")
    WebElement startStopButton;

    @FindBy(xpath = "//div[@role=\"progressbar\"]")
    WebElement progressBar;

    private final String ATTRIBUTE_NAME = "aria-valuenow";

    public void clickToButton() {
        startStopButton.click();
    }

    public void fluentWaitAttribute(String percent) {
        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofNanos(2000000))
                .until(ExpectedConditions.attributeToBe(progressBar, ATTRIBUTE_NAME, percent));
    }

    public void clickToStop(String percent) {
        fluentWaitAttribute(percent);
        clickToButton();
    }

    public String getPercent() {
        return progressBar.getText();
    }



    @FindBy(xpath = "//button[@id=\"resetButton\"]")
    WebElement resetButton;

    public void webDriverWait(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(100));
        wait.until(ExpectedConditions.attributeToBe(resetButton, "id", "resetButton"));
    }


    public boolean ResetButtonIsClickable(){
        resetButton.click();
        return true;
    }
}
