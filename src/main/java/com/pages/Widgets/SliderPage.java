package com.pages.Widgets;

import com.pages.PageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends PageBase {

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='range']")
    WebElement slider;

    @FindBy(xpath = "//input[@id='sliderValue']")
    WebElement sliderValue;

    public String getAttribute() {
        return slider.getAttribute("value");
    }

    public String getSliderValue() {
        return sliderValue.getAttribute("value");
    }

    public void moveSliderWithDoWhile(String value) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, -500, 0).build().perform();
        String valueCurrent;

        do {
            actions.sendKeys(Keys.ARROW_RIGHT).perform();
            valueCurrent = getAttribute();
        } while (!valueCurrent.equals(value));
    }

    public void moveSliderWithFor(String value) {
        int val = Integer.parseInt(value);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, -500, 0).build().perform();

        for(int i = 0; i<val; i++) {
            actions.sendKeys(Keys.ARROW_RIGHT).perform();
        }
    }
}
