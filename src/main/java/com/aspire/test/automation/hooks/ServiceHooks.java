package com.aspire.test.automation.hooks;

import org.openqa.selenium.WebDriver;

import com.aspire.test.automation.helpers.DriverManager;
import com.aspire.test.automation.utils.SeleniumUtils;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ServiceHooks {
	private WebDriver driver;

	@BeforeTest
	public void initializeTest() {
		driver = DriverManager.getDriver();
		DriverManager.initialDriverSetUp();
		SeleniumUtils.navigateToUrl(driver);
	}

	@AfterTest
	public void tearDown() {
		// Take Screenshot for Failed test and quit the driver
		byte[] screenshotBytes = SeleniumUtils.getScreenshotAsBytes(driver);
		DriverManager.quitDriver();
	}
}
