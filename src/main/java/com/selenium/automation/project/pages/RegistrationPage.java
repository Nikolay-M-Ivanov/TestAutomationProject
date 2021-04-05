package com.selenium.automation.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

    protected final WebDriver driver;

    @FindBy(name = "agree")
    private WebElement agreeBtn;

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

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToCreateAccountPage(){
        if (agreeBtn.isDisplayed()){
            agreeBtn.click();
        }
        loginBtn.click();
        createAccountBtn.click();
    }

    public void enterFullNameAndEmail(String fName, String lName, String email){
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        emailAddress.sendKeys(email);
    }
    public void passwordInput(String password){
        pass.sendKeys(password);
    }
    public void phoneNumberInput(String phone){
        phoneNumber.sendKeys(phone);
    }
    public void dateOfBirthInput(String day, String year){
        Select dropDownList = new Select(monthOfBirth);
        dropDownList.selectByValue("3");
        dayOfBirth.sendKeys(day);
        yearOfBirth.sendKeys(year);
        sumbitBtn.click();
    }
}