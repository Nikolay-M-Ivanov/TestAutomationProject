package com.selenium.automation.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    @FindBy(css = "li[data-test='STATISTICS']")
    private WebElement statistictsBtn;

    @FindBy(xpath = "//span[contains(text(),'Price/Book')]/../following-sibling::td")
    private WebElement priceMrq;


    public void searchCompanyByName(String companyName) {
        searchTab.click();
        searchTab.sendKeys(companyName);
        searchBtn.click();
    }

    public WebElement getStatistictsBtn() {
        executeExplicitWait(20, ExpectedConditions.visibilityOf(statistictsBtn), 4);
        statistictsBtn.click();
        return null;
    }

    public void checkingDividendsRate(String dividendsFromCsv) {
        executeExplicitWait(20, ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@data-test='DIVIDEND_AND_YIELD-value']")), 4);
       /* driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@data-test='DIVIDEND_AND_YIELD-value']")));*/
        String div = dividendsRate.getText();
        if (div.equalsIgnoreCase("N/A (N/A)")) {
            System.out.println("No dividends");
        } else System.out.println("Given dividends are " + dividendsFromCsv);
    }
    public String checkingPriceMrq(){
        executeExplicitWait(20, ExpectedConditions.visibilityOf(priceMrq), 4);
        priceMrq.getText();
        return null;
    }
}
