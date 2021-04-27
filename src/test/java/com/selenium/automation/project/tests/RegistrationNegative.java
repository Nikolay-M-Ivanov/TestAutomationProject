package com.selenium.automation.project.tests;

import com.opencsv.exceptions.CsvException;
import com.selenium.automation.project.base.TestUtil;
import com.selenium.automation.project.pages.HomePage;
import com.selenium.automation.project.pages.RegistrationPage;
import com.selenium.automation.project.utils.CsvReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RegistrationNegative extends TestUtil {


    @DataProvider(name = "login-file-negativeInfo")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/login-file-negative.csv");
    }

    @Test(dataProvider = "login-file-negativeInfo")
    public void loginYahoo(String firstName, String lastName, String email, String password, String phone, String day, String year, String gender) {
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        homePage.clickOnAgreeBtn();
        registrationPage.goToCreateAccountPage();
        registrationPage.enterFullNameAndEmail(firstName, lastName, email);
        registrationPage.passwordInput(password);
        registrationPage.phoneNumberInput(phone);
        registrationPage.dateOfBirthInput(day, year, gender);


        //Explicit wait - условно (чакаме някакво условие)
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //изключваме преди условното
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reg-error-yid")));
        String usernameError = driver.findElement(By.id("reg-error-yid")).getText();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS); //включваме отново




        String passError = driver.findElement(By.id("reg-error-password")).getText();
        String phoneError = driver.findElement(By.id("reg-error-phone")).getText();
        String birthDateError = driver.findElement(By.id("reg-error-birthDate")).getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(usernameError, "This email address is not available for sign up, try something else");
        softAssert.assertEquals(passError, "Your password isn’t strong enough, try making it longer.");
        softAssert.assertEquals(phoneError, "That doesn’t look right, please re-enter your phone number.");
        softAssert.assertEquals(birthDateError, "That doesn’t look right, please re-enter your birthday.");
       // softAssert.assertAll();
    }
}
