package com.selenium.automation.project.tests;

import com.opencsv.exceptions.CsvException;
import com.selenium.automation.project.base.TestUtil;
import com.selenium.automation.project.pages.HomePage;
import com.selenium.automation.project.pages.SearchCompany;
import com.selenium.automation.project.utils.CsvReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class FinanceCompanyInfo extends TestUtil {

    @DataProvider(name = "names-dividends")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/company-names-dividends.csv");
    }

    @Test(dataProvider = "names-dividends")
    public void CompanyCheck(String searchTab, String dividendsRate, String priceMrqCsv) {
        HomePage homePage = new HomePage(driver);
        SearchCompany searchCompany = new SearchCompany(driver);

        homePage.clickOnAgreeBtn();
        searchCompany.searchCompanyByName(searchTab);
        searchCompany.checkingDividendsRate(dividendsRate);
        searchCompany.getStatistictsBtn();
        String priceBook = searchCompany.checkingPriceMrq();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(priceBook,priceMrqCsv);
    }
}
