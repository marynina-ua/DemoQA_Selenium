package com.pages.Elements;

import com.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxPage extends PageBase {
    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/span/button")
    public WebElement homeToggler;
    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button")
    public WebElement desktopToggler;
    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/span/label")
    public WebElement home;
    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/label")
    public WebElement desktop;
    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[1]/span/label")
    public WebElement notes;

    public CheckBoxPage clickOnElement(WebElement element){
        click(element);
        return this;
    }
    public boolean isSelectedHome(WebElement element){
        return element.findElement(By.tagName("input")).isSelected();
    }
}
