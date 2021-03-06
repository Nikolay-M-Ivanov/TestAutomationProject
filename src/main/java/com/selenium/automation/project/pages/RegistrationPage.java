package com.selenium.automation.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends HomePage{


    @FindBy(xpath = "//span[contains(text(),'Sign in')]")
    private WebElement loginBtn;

    @FindBy(xpath = "//a[@id='createacc']")
    private WebElement createAccountBtn;

    @FindBy(id = "usernamereg-firstName")
    private WebElement firstName;

    @FindBy(id = "usernamereg-lastName")
    private WebElement lastName;

    @FindBy(id = "usernamereg-yid")
    private WebElement emailAddress;

    @FindBy(id = "usernamereg-password")
    private WebElement pass;

    @FindBy(id = "usernamereg-phone")
    private WebElement phoneNumber;

    @FindBy(id = "usernamereg-month")
    private WebElement monthOfBirth;

    @FindBy(id = "usernamereg-day")
    private WebElement dayOfBirth;

    @FindBy(id = "usernamereg-year")
    private WebElement yearOfBirth;

    @FindBy(id = "reg-submit-button")
    private WebElement sumbitBtn;

    @FindBy(xpath = "//input[@id='usernamereg-freeformGender']")
    private WebElement genderField;

    public RegistrationPage(WebDriver driver) {

        super(driver);
    }

    public void goToCreateAccountPage(){
        loginBtn.click();
        createAccountBtn.click();
    }

    public void enterFullNameAndEmail(String fName, String lName, String email){
        firstName.click();
        firstName.sendKeys(fName);
        lastName.click();
        lastName.sendKeys(lName);
        emailAddress.click();
        emailAddress.sendKeys(email);
    }
    public void passwordInput(String password){

        pass.click();
        pass.sendKeys(password);
    }
    public void phoneNumberInput(String phone){

        phoneNumber.click();
        phoneNumber.sendKeys(phone);
    }
    public void dateOfBirthInput(String day, String year, String gender){
        Select dropDownList = new Select(monthOfBirth);
        dropDownList.selectByValue("3");
        dayOfBirth.sendKeys(day);
        yearOfBirth.sendKeys(year);
       // executeExplicitWait(20,ExpectedConditions.visibilityOf(genderField),4);
        genderField.sendKeys(gender);
      //  sumbitBtn.click();
    }

}