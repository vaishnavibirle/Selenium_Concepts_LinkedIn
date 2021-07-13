package com.blz.selenium.pages;

import com.blz.selenium.base.BaseClass;
import com.blz.selenium.utility.Log;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Feature("Login Feature")
@Description("Created Login class and login method")
@Severity(SeverityLevel.CRITICAL)
@Story("Finded the elements by using locators" +
        "called constructor where .init elements just call the elements by locators" +
        "Used parameters like username password and data" +
        "used if else statements" +
        "returning the title of page for validation.")

public class Login  extends BaseClass {

    @FindBy(xpath = "//a[normalize-space()='Sign in']")
    WebElement sign_In;

    @FindBy(id = "username")
    WebElement username_id;

    @FindBy(id = "password")
    WebElement password_input;

    @FindBy(className = "login__form_action_container")
    WebElement signIn_btn;

    @FindBy(xpath = "//*[@id=\"ember33\"]")
    WebElement me_btn;

    @FindBy(xpath = "//a[normalize-space()='Sign Out']")
    WebElement sign_out;

    public Login(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void login(String UserName,String PassWord,String Data) throws InterruptedException {

        Log.info("clicking sign in button");
        sign_In.click();
        Thread.sleep(1000);
        Log.info("Sending email or username in input_box");
        username_id.sendKeys(UserName);
        Log.info("sending password in input_box");
        password_input.sendKeys(PassWord);
        Thread.sleep(2000);
        Log.info("Clicking on sign in and logging into application");
        signIn_btn.click();
        Thread.sleep(2000);

        String exp_title = "Feed | LinkedIn";
        String act_title = driver.getTitle();

        if(Data.equals("valid")){
            if(exp_title.equals(act_title)){
                Log.info("Clicking on me button");
                me_btn.click();
                Log.info("Clicking on sign out button");
                sign_out.click();
                Thread.sleep(2000);
                Assert.assertTrue(true);
            }
            else {
                Assert.assertTrue(false);
            }
        }
        else if(Data.equals("invalid"))
        {
            if(exp_title.equals(act_title)) {
                Log.info("Clicking on me button");
                me_btn.click();
                Thread.sleep(3000);
                Log.info("Clicking on sign out button");
                sign_out.click();
                Thread.sleep(2000);
                Assert.assertTrue(false);
            }
            else {
                Log.info("Navigating url for again clicking on sign in");
                driver.navigate().to("https://www.linkedin.com");
                Assert.assertTrue(true);
            }
        }
    }

}
