package com.demoqa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertsPage extends BasePage{

    public AlertsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="promtButton")
    WebElement promptButton;
    public AlertsPage sendMessageToAlert(String message) {
        click(promptButton);

        if(message!=null){
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }
        return this;
    }

    @FindBy(id="promptResult")
    WebElement promptResult;
    public AlertsPage assertMessage(String message) {
        Assert.assertTrue(promptResult.getText().contains(message));
        return this;
    }
    @FindBy(id="timerAlertButton")
    WebElement TimerAlertButton;

    public AlertsPage alertButton(){
        click(TimerAlertButton);
        pause(5000);
        return this;
    }
    public boolean isAlertPresent() {

        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            driver.switchTo().alert();
            alert.dismiss();
            return true;
        }
    }
    @FindBy(id="alertButton")
    WebElement alertButton;

    public AlertsPage assertButton(){
        click(alertButton);
        isAlertPresent();
        return this;
    }

    @FindBy(id="confirmButton")
    WebElement confirmButton;


    public AlertsPage acceptAlert() {
        click(confirmButton);
        return this;
    }
}
