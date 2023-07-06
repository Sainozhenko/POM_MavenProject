package com.demoqa.tests;

import com.demoqa.data.StudentData;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.PracticeFormPage;
import com.demoqa.pages.SidePanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm();
    }

    @Test
    public void fillPracticeFormTest(){
        new PracticeFormPage(driver).hideIframes();
        new PracticeFormPage(driver).enterPersonalData("Mark","Gonzo","markgonzo@gmail.com","0932229966")
                .selectGender("Male")
                .selectDate("April","2004","16")
//                .typeDate("05.03.2001")
                // .typeDate("05 May 1994")
                .addSubject(new String[]{"English", "Computer Science", "Maths"})
                .selectHobby(new String[]{"Reading","Music","Sports"})
                .uploadFile("C:/1.png")
                .enterAddress("Berlin")
                .selectState("NCR")
                .selectCity("Delhi")
                .submit();
    }


    @Test
    public void fillPracticeFormWithFinalDataTest(){
        new PracticeFormPage(driver).hideIframes();
        new PracticeFormPage(driver)
                .enterPersonalData(StudentData.FIRST_NAME,StudentData.LAST_NAME,StudentData.EMAIL,StudentData.PHONE)
                .selectGender(StudentData.GENDER)
                .typeDate(StudentData.B_DAY)// .typeDate("05 May 1994")
                .addSubject(StudentData.SUBJECTS)
                .selectHobby(StudentData.HOBBIES)
                .uploadFile(StudentData.PHOTO)
                .enterAddress(StudentData.ADDRESS)
                .selectState(StudentData.STATE)
                .selectCity(StudentData.CITY)
                .submit()
                .assertFinal();
    }
}
