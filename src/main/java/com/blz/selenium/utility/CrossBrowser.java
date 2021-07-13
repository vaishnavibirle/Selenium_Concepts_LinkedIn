package com.blz.selenium.utility;

import com.blz.selenium.base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@Feature("Browser")
@Description("Created crossBrowser class for performing operation" +
        "on multiple users")
@Story("Created crossBrowser method and provided parameter as browserName" +
        "Used if else if statements for performing on multiple browsers")

public class CrossBrowser extends BaseClass {
    public static WebDriver crossBrowser(String browserName){

        if(browserName.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("Firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        }
        return driver;
    }
}
