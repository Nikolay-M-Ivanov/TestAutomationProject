package com.selenium.automation.project.project;

import com.opencsv.exceptions.CsvException;
import com.selenium.automation.project.base.TestUtil;
import com.selenium.automation.project.utils.CsvReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationNegative extends TestUtil {

    @DataProvider(name = "login-file-negativeInfo")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/login-file-negative.csv");
    }

    @Test(dataProvider = "login-file-negativeInfo")
    public void loginYahoo(String firstName, String lastName, String email, String password, String phone, String day, String year) {
        WebElement agreeButton = driver.findElement(By.name("agree"));
        //намира бутона приемам и го натиска
        if (agreeButton.isDisplayed()) {
            agreeButton.click();
        }
        //намира бутона за login и го натиска
        WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),'Sign in')]"));
        loginButton.click();
        //намира бутона за create account и го натиска
        WebElement createAccountButton = driver.findElement(By.xpath("//a[@id='createacc']"));
        createAccountButton.click();
        //намираме инпута за първо име и въвеждаме стойността зададена в csv файла
        WebElement userFirstNameInput = driver.findElement(By.id("usernamereg-firstName"));
        userFirstNameInput.sendKeys(firstName);
        //намираме инпута за второ име и въвеждаме стойността зададена в csv файла
        WebElement userLastNameInput = driver.findElement(By.id("usernamereg-lastName"));
        userLastNameInput.sendKeys(lastName);
        //намираме инпута за email и въвеждаме стойността зададена в csv файла
        WebElement emailInput = driver.findElement(By.id("usernamereg-yid"));
        emailInput.sendKeys(email);
        //намираме инпута за password и въвеждаме стойността зададена в csv файла
        WebElement passwordInput = driver.findElement(By.id("usernamereg-password"));
        passwordInput.sendKeys(password);
        //Thread.sleep(1000);
        //намираме инпута за phone number и въвеждаме стойността зададена в csv файла
        WebElement phoneNumberInput = driver.findElement(By.id("usernamereg-phone"));
        phoneNumberInput.sendKeys(phone);
        //намираме инпута за месец на раждане и чрез класа Select избираме даден елемент по value
        WebElement birthMonthDropDown = driver.findElement(By.id("usernamereg-month"));
        Select dropDownList = new Select(birthMonthDropDown);
        dropDownList.selectByValue("3");
        //намираме инпута за phone number и въвеждаме стойността зададена в csv файла
        WebElement birthDayInput = driver.findElement(By.id("usernamereg-day"));
        birthDayInput.sendKeys(day);
        //намираме инпута за phone number и въвеждаме стойността зададена в csv файла
        WebElement birthYearInput = driver.findElement(By.id("usernamereg-year"));
        birthYearInput.sendKeys(year);
        WebElement continueBtn = driver.findElement(By.id("reg-submit-button"));
        continueBtn.click();
    }
}
