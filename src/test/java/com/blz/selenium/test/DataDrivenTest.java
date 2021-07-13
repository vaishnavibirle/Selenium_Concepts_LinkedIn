package com.blz.selenium.test;

import com.blz.selenium.base.BaseClass;
import com.blz.selenium.pages.Login;
import com.blz.selenium.utility.DataProvider;
import com.blz.selenium.utility.listeners.CustomListeners;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class DataDrivenTest extends BaseClass {

    @Description("Used loginTest method for logging into application")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Provided userName , password and data  for performing login operations.")
    @Test(dataProvider = "test1",dataProviderClass = DataProvider.class)
    public void LoginTest(String UserName, String PassWord, String Data) throws InterruptedException {
        Login login = new Login(driver);
        login.login(UserName, PassWord, Data);
    }
}
