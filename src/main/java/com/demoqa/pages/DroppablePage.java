package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DroppablePage extends BasePage {
    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="draggable")
    WebElement dragMe;

    @FindBy(id="droppable")
    WebElement dropHere;

    public DroppablePage actionDragMe() {
        pause(1000);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMe,dropHere).perform();

        String text = dropHere.getText();
        if(text.equals("Dropped!")) {
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
        return this;
    }

    public DroppablePage dragMeBy(int x, int y) {

        Actions actions = new Actions(driver);
        int xOffSet1 = dragMe.getLocation().getX();
        int yOffSet1 = dragMe.getLocation().getY();

        System.out.println("xOffset1 ---> " + xOffSet1 + " yOffset1 ----> " + yOffSet1);

        int xOffSet = dropHere.getLocation().getX();
        int yOffSet = dropHere.getLocation().getY();

        System.out.println("xOffset ---> " + xOffSet + " yOffset ----> " + yOffSet);

        xOffSet = (xOffSet-xOffSet1)+x;
        yOffSet = (yOffSet-yOffSet1)+y;

        actions.dragAndDropBy(dragMe,xOffSet, yOffSet).perform();

        String text = dropHere.getText();
        if(text.equals("Dropped!")) {
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        return this;
    }
}
