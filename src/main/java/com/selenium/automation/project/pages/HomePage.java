package com.selenium.automation.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}
