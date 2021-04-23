package com.selenium.automation.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SearchCompany extends HomePage {

    public SearchCompany(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "yfin-usr-qry")
    private WebElement searchTab;

    @FindBy(id = "header-desktop-search-button")
    private WebElement searchBtn;

    @FindBy(xpath = "//td[@data-test='DIVIDEND_AND_YIELD-value']")
    private WebElement dividendsRate;


    public void searchCompanyByName(String companyName) {
        searchTab.click();
        searchTab.sendKeys(companyName);
        searchBtn.click();
    }

    public void checkingDividendsRate(String dividendsFromCsv) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@data-test='DIVIDEND_AND_YIELD-value']")));
        String div = dividendsRate.getText();
        if (div.equalsIgnoreCase("N/A (N/A)")) {
            System.out.println("No dividends");
        } else System.out.println("Given dividends are " + dividendsFromCsv);

    }
}
