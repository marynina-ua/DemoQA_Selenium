package com.pages.AlertsFramesWindowsPages;

import com.pages.PageBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsPage extends PageBase {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="alertButton")
    WebElement alertButton;

    public AlertsPage clickOnSimpleAlert() {
        click(alertButton);
        wait(1000);
        driver.switchTo().alert().accept();
        return this;
    }

    @FindBy(id="timerAlertButton")
    WebElement timerAlertButton;

    public AlertsPage clickOnSimpleAlertWithTimer() {
        click(timerAlertButton);

        wait(500);
        //driver.switchTo().alert().accept();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(myAlert.getText());
        myAlert.accept();

        return this;
    }

    @FindBy(id="confirmButton")
    WebElement confirmButton;

    public AlertsPage clickOnConfirmBox(String action) {
        click(confirmButton);
        wait(1000);
        if (action == "OK") {
            driver.switchTo().alert().accept();
        }

        if (action == "Cancel") {
            driver.switchTo().alert().dismiss();
        }

        return this;
    }

    @FindBy(id="confirmResult")
    WebElement confirmText;

    public String getConfirmText() {
        return confirmText.getText();
    }

    @FindBy(id="promtButton")
    WebElement promtButton;
    
    public AlertsPage enterTextToPrompt(String name) {
        clickWithJSExecutor(promtButton, 0, 200);
        driver.switchTo().alert().sendKeys(name);
        driver.switchTo().alert().accept();
        return this;
    }

    @FindBy(id="promptResult")
    WebElement promptResult;

    public String getPromptResult() {
        return promptResult.getText();
    }
}
