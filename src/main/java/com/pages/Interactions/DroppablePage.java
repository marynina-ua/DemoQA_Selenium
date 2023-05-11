package com.pages.Interactions;

import com.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DroppablePage extends PageBase {

//    Actions actions = new Actions(driver);

    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "droppableExample-tab-simple")
    WebElement simple;
    @FindBy(id = "draggable")
    WebElement draggable;
    @FindBy(id = "droppable")
    WebElement droppable;


    public DroppablePage testDroppableHere() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop( draggable, droppable ).perform();
        return this;
    }
    public String getDroppedResult() {
        return droppable.getText();
    }


    public DroppablePage testDroppableByOffset() {
//        actions.dragAndDropBy(draggable, 320, 0).perform();
//        actions.clickAndHold(draggable).moveByOffset(320, 0).release().build().perform();
        Actions actions = new Actions(driver);

        int xOffsetDraggable = draggable.getLocation().getX();
        int yOffsetDraggable = draggable.getLocation().getY();

        int xOffsetDroppable = droppable.getLocation().getX();
        int yOffsetDroppable = droppable.getLocation().getY();

        int xOffset = (xOffsetDroppable - xOffsetDraggable) + 30;
        int yOffset = (yOffsetDroppable - yOffsetDraggable) + 30;

        actions.dragAndDropBy(draggable, xOffset, yOffset).perform();
        wait(2000);
        return this;
    }

    public DroppablePage dragElement() {
        Actions actions = new Actions(driver);
        click(simple);
        actions.dragAndDrop(draggable, droppable).perform();
        return this;
    }
    public String getResultStatus() {
        WebElement resultStatus =  droppable.findElement(By.tagName("p"));
        return resultStatus.getText();
    }

}

