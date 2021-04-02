package com.selenium.automation.project.base;

import com.selenium.automation.project.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtil {

    public WebDriver driver;
    private String url;
    private String browser;
    private int implicitWait;
    /*public TestUtil(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }*/

    /*@BeforeSuite
    public void readConfigProperties() {
        try (
                FileInputStream configFile = new FileInputStream("src/test/resources/config.properties")) {
            Properties config = new Properties();
            config.load(configFile);
            url = config.getProperty("urlAddress");
            implicitWait = Integer.parseInt(config.getProperty("implicitWait"));
            // browser to be taken from property file
            browser = config.getProperty("browser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    @BeforeMethod
    public void setUp() {
        setupBrowserDriver();
        loadUrl();
    }

    public void loadUrl() {
        driver.get(url);
    }

    public void setupBrowserDriver() {
        try (
                FileInputStream configFile = new FileInputStream("src/test/resources/config.properties")) {
            Properties config = new Properties();
            config.load(configFile);
            url = config.getProperty("urlAddress");
            implicitWait = Integer.parseInt(config.getProperty("implicitWait"));
            // browser to be taken from property file
            browser = config.getProperty("browser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (browser) {
            case "chrome":
                driver = DriverFactory.getChromeDriver(implicitWait);
                break;
            case "firefox":
                driver = DriverFactory.getFirefoxDriver(implicitWait);
            default:
                throw new IllegalStateException("Unsuported browser");
        }

    }

    @AfterTest
    public void tearDown() {
        //driver.close();  //само затваря браузъра
        driver.quit();  //спира самия селениум, разваля връзката
    }
}
