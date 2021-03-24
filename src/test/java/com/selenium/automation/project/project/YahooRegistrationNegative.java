package com.selenium.automation.project.project;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.selenium.automation.project.utils.CsvReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class YahooRegistrationNegative {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @DataProvider(name = "login-file-negativeInfo")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/login-file-negative.csv");
    }


    @Test(dataProvider = "login-file-negativeInfo")
    public void loginYahoo(String firstName, String lastName, String email, String password, String phone, String birthMonth, String day, String year){
        driver.get("https://finance.yahoo.com/");
        //намира бутона приемам и го натиска
        WebElement agreeButton = driver.findElement(By.name("agree"));
        agreeButton.click();
        //намира бутона за login и го натиска
        WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),'Sign in')]"));
        loginButton.click();
        //намира бутона за create account и го натиска
        WebElement createAccountButton = driver.findElement(By.xpath("//a[@id='createacc']"));
        createAccountButton.click();
        //намираме инпута за първо име и въвеждаме стойността зададена в csv файла
        WebElement userFirstNameInput = driver.findElement(By.id("usernamereg-firstName"));
        userFirstNameInput.clear();
        userFirstNameInput.sendKeys(firstName);
        //намираме инпута за второ име и въвеждаме стойността зададена в csv файла
        WebElement userLastNameInput = driver.findElement(By.id("usernamereg-lastName"));
        userLastNameInput.clear();
        userLastNameInput.sendKeys(lastName);
        //намираме инпута за email и въвеждаме стойността зададена в csv файла
        WebElement emailInput = driver.findElement(By.id("usernamereg-yid"));
        emailInput.clear();
        emailInput.sendKeys(email);
        //намираме инпута за password и въвеждаме стойността зададена в csv файла
        WebElement passwordInput = driver.findElement(By.id("usernamereg-password"));
        passwordInput.clear();
        passwordInput.sendKeys(password);
        //намираме инпута за phone number и въвеждаме стойността зададена в csv файла
        WebElement phoneNumberInput = driver.findElement(By.id("usernamereg-phone"));
        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phone);
        //намираме инпута за месец на раждане и въвеждаме стойността зададена в csv файла
        WebElement birthMonthDropDown = driver.findElement(By.id("usernamereg-month"));
        birthMonthDropDown.clear();
        birthMonthDropDown.click();
        WebElement selectBirthMonth = driver.findElement(By.cssSelector("[value=3]"));
        selectBirthMonth.click();
        //намираме инпута за phone number и въвеждаме стойността зададена в csv файла
        WebElement birthDayInput = driver.findElement(By.id("usernamereg-day"));
        birthDayInput.clear();
        birthDayInput.sendKeys(day);
        //намираме инпута за phone number и въвеждаме стойността зададена в csv файла
        WebElement birthYearInput = driver.findElement(By.id("usernamereg-year"));
        birthYearInput.clear();
        birthYearInput.sendKeys(year);

    }

    public void tearDown() {
        //    driver.close();  //само затваря браузъра
        driver.quit();  //спира самия селениум, разваля връзката
    }
}
