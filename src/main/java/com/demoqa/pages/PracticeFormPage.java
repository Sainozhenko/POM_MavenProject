package com.demoqa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PracticeFormPage extends BasePage{
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="firstName")
    WebElement firstName;

    @FindBy(id="lastName")
    WebElement lastName;

    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="userNumber")
    WebElement userNumber;

    public PracticeFormPage enterPersonalData(String fName, String lName, String email,String phNumber) {
            type(firstName,fName);
            type(lastName,lName);
            type(userEmail,email);
            type(userNumber,phNumber);
        return  this;
    }

    @FindBy(css = "[for='gender-radio-1']")
    WebElement male;

    @FindBy(css = "[for='gender-radio-2']")
    WebElement female;

    @FindBy(css = "[for='gender-radio-3']")
    WebElement other;

    public PracticeFormPage selectGender(String gender) {

        if(gender.equals("Male")){
            click(male);
        }else if(gender.equals("Female")){
            click(female);
        }else{
            click(other);
        }

        return this;
    }


    @FindBy(id= "dateOfBirthInput")
    WebElement dateOfBirthInput;

    public PracticeFormPage typeDate(String bDay) {
        click(dateOfBirthInput);

        selectOS();

        dateOfBirthInput.sendKeys(bDay);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }

    public void selectOS() {
        String os = System.getProperty("os.name");
        System.out.println("My OS: "+os);

        if(os.startsWith("Mac")){
            dateOfBirthInput.sendKeys(Keys.chord(Keys.COMMAND,"a"));
        }else{
            dateOfBirthInput.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        }

    }

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    public PracticeFormPage addSubject(String[] subject) {
        for (int i = 0; i < subject.length; i++) {
            if(subject[i]!= null){
                type(subjectsInput,subject[i]);
                subjectsInput.sendKeys(Keys.ENTER);
            }
        }
        return this;
    }

    @FindBy(css = "[for='hobbies-checkbox-1']")
    WebElement sports;

    @FindBy(css = "[for='hobbies-checkbox-2']")
    WebElement reading;

    @FindBy(css = "[for='hobbies-checkbox-3']")
    WebElement music;

    public PracticeFormPage selectHobby(String[] hobbies) {
        for (int i = 0; i < hobbies.length; i++) {
            if(hobbies[i].equals("Sports")){
                click(sports);
            }if (hobbies[i].equals("Reading")){
                click(reading);
            }if (hobbies[i].equals("Music")){
                click(music);
            }

        }
        return this;
    }


    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;
    public PracticeFormPage uploadFile(String path) {
        uploadPicture.sendKeys(path); // SendKeys метод для загрузки файла
        return this;
    }

    @FindBy(id="currentAddress")
    WebElement currentAddress;


    public PracticeFormPage enterAddress(String address) {
        type(currentAddress,address);
        return this;
    }

    @FindBy(id="state")
    WebElement stateContainer;

    @FindBy(id="react-select-3-input")
    WebElement stateInput;

    public PracticeFormPage selectState(String state) {
        clickWithJSExecutor(stateContainer,0,120);
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);
        return this;
    }
    @FindBy(id="city")
    WebElement cityContainer;

    @FindBy(id="react-select-4-input")
    WebElement cityInput;
    public PracticeFormPage selectCity(String city) {
        clickWithJSExecutor(cityContainer,0,120);
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);
        return this;
    }


    @FindBy(id="submit")
    WebElement submitButton;

    public PracticeFormPage submit() {
        clickWithRentangle(submitButton,2,3);
        return this;
    }

    public void clickWithRentangle(WebElement element,int x,int y) {

        Rectangle rectangle = element.getRect();
        int offSetX = rectangle.getWidth() / x;
        int offSetY = rectangle.getHeight() / y;

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.moveByOffset(-offSetX,-offSetY).click().perform();

    }

@FindBy(css =".react-datepicker__month-select")
WebElement month;

    @FindBy(css =".react-datepicker__year-select")
    WebElement year;

    public PracticeFormPage selectDate(String m, String y, String d) {
        click(dateOfBirthInput);

        Select select = new Select(month);
        select.selectByVisibleText(m);

        Select select1 = new Select(year);
        select1.selectByVisibleText(y);

        driver.findElement(By.xpath("//div[.='" + d + "']")).click();
        return this;
    }
    @FindBy(id="example-modal-sizes-title-lg")
    WebElement success;

    public PracticeFormPage assertFinal(){
        String expanced = success.getText();
        Assert.assertEquals("Thanks for submitting the form",expanced);
        return this;
    }

}