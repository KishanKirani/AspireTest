package com.aspire.test.automation.pageobjects;

import com.aspire.test.automation.utils.CommonUtils;
import com.aspire.test.automation.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//img[contains(@src,'company_logo') and @alt='Logo']")
    private WebElement aspireLogo;

    @FindBy(xpath = "//label[text()='Email']")
    private WebElement emailLabel;

    @FindBy(xpath = "//input[@name='login' and @id='login']")
    private WebElement emailTextBoxField;

    @FindBy(xpath = "//label[text()='Password']")
    private WebElement passwordLabel;

    @FindBy(xpath = "//input[@name='password' and @id='password']")
    private WebElement passwordTextBoxField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement logInButton;

    public void enterUserName(){
        String user = getUserName();
        emailTextBoxField.sendKeys(user);
    }

    public void enterPassword(){
        String password = getPassword();
        passwordTextBoxField.sendKeys(password);
    }

    public String getUserName(){
        String userName = CommonUtils.getConfigProperty("application.account");
        assert userName != null;
        return userName.trim();
    }

    public String getPassword(){
        String password = CommonUtils.getConfigProperty("application.password");
        assert password != null;
        return password.trim();
    }

    public void clickOnLoginButton(){
        SeleniumUtils.waitUntilElementVisible(logInButton,driver,2);
        SeleniumUtils.clickOnAnElement(logInButton);
    }

    public void verifyDefaultLoginPageContents(){
        SeleniumUtils.waitUntilElementVisible(aspireLogo,driver,2);
        Assert.assertTrue(aspireLogo.isDisplayed(),"Aspire logo is not displayed");
        SeleniumUtils.waitUntilElementVisible(emailLabel,driver,2);
        Assert.assertTrue(SeleniumUtils.getTextOfAWebElement(emailLabel).equalsIgnoreCase("Email"),
                                    "Email label is not present");
        SeleniumUtils.waitUntilElementClickable(passwordLabel,driver,2);
        Assert.assertTrue(SeleniumUtils.getTextOfAWebElement(passwordLabel).equalsIgnoreCase("Password"),
                "Email label is not present");
    }

    public void performLoginToApplication(){
        enterUserName();
        enterPassword();
        clickOnLoginButton();
    }
}
