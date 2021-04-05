package com.selenium.automation.project.project;

import com.opencsv.exceptions.CsvException;
import com.selenium.automation.project.base.TestUtil;
import com.selenium.automation.project.pages.RegistrationPage;
import com.selenium.automation.project.utils.CsvReader;
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
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.goToCreateAccountPage();
        registrationPage.enterFullNameAndEmail(firstName, lastName, email);
        registrationPage.passwordInput(password);
        registrationPage.phoneNumberInput(phone);
        registrationPage.dateOfBirthInput(day, year);
    }
}
