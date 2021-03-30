package com.selenium.automation.project.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestUtil {

    protected WebDriver driver;

    public TestUtil(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterTest
    public void tearDown() {
            driver.close();  //само затваря браузъра
        // driver.quit();  //спира самия селениум, разваля връзката
    }
}
