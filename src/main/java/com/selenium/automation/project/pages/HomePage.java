package com.selenium.automation.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage {
    protected final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "agree")
    private WebElement agreeBtn;


    public void clickOnAgreeBtn() {
        if (agreeBtn.isDisplayed()){
            agreeBtn.click();
        }
    }

    public <T> T executeExplicitWait(long timeOutInSeconds, ExpectedCondition<T> expectedCondition, int implicitWait){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        turnOffImplicitWait(driver);
        T result = wait.until(expectedCondition);
        turnOnImplicitWait(driver, implicitWait);
        return result;
    }

    private void turnOnImplicitWait(WebDriver driver, int implicitWait) {
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
    }

    private void turnOffImplicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }
}
