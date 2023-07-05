package com.demoqa.tests;

import com.demoqa.pages.AlertsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getAlertsFrameWindows();
        new SidePanel(driver).selectAlerts();
    }

    @Test
    public void sentMessageToAlertTest(){
        new AlertsPage(driver).sendMessageToAlert("Hello world")
                .assertMessage("Hello world");
    }
    @Test
    public void clickAndSeeAlart(){
        new AlertsPage(driver).alertButton().isAlertPresent();
    }

    @Test
    public void clickAlertButton(){
        new AlertsPage(driver).assertButton();
    }

    @Test
    public void acceptAlert(){
        new AlertsPage(driver).acceptAlert().isAlertPresent();
        String actualText = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertTrue(actualText.contains("You selected Cancel"));
    }
}
