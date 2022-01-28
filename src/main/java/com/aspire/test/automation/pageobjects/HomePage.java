package com.aspire.test.automation.pageobjects;

import com.aspire.test.automation.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnSpecificFeature(String feature){
        WebElement element = driver.findElement(By.xpath("//a/div/following-sibling::div[text()='"+feature+"']"));
        SeleniumUtils.waitUntilElementClickable(element,driver,2);
        SeleniumUtils.clickOnAnElement(element);
    }

}
