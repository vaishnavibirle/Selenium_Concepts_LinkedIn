package com.blz.selenium.base;

import com.blz.selenium.utility.CrossBrowser;
import com.blz.selenium.utility.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {

    public static WebDriver driver;

    @Feature("BrowserName and url for starting test")
    @Parameters({"browserName","url"})
    @Description("Used setUp method for setting the browser")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Navigating to url : https://www.linkedin.com")
    @BeforeTest
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
//        driver = CrossBrowser.crossBrowser(browserName);
        Log.info("Test is starting");
        Log.info("chrome is starting");
        driver = new ChromeDriver();
        Log.info("navigating to url : https://www.linkedin.com/");
        driver.get("https://www.linkedin.com/");
//        driver.get("https://www.linkedin.com/");
        driver.manage().window().maximize();
        Log.info("Launched the web application.");
        Thread.sleep(5000);
    }

    @AfterTest
    @Feature("Closing application")
    @Description("Used tearDown method for closing the browser.")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Closing the browser.")
    public void tearDown() {
        Log.info("Browser is closed");
        driver.quit();
        Log.info("Test is ended");
        Reporter.log("====Application Launched====");
    }
}
