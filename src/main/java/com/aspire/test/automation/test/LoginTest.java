package com.aspire.test.automation.test;

import com.aspire.test.automation.helpers.DriverManager;
import com.aspire.test.automation.hooks.ServiceHooks;
import com.aspire.test.automation.pageobjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends ServiceHooks{
    private WebDriver driver ;
    public LoginTest() {
        driver= DriverManager.getDriver();
    }

    @Test
    public void loginTest(){
        LoginPage loginPage = new LoginPage(driver);
        //Verify the login page contents
        loginPage.verifyDefaultLoginPageContents();
        //Enter the user in the username text filed
        loginPage.enterUserName();
        //Enter the user in the username text filed
        loginPage.enterPassword();
        //Click on the Next button to proceed
        loginPage.clickOnLoginButton();
    }
}
