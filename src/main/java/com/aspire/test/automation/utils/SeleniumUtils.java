package com.aspire.test.automation.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all the Selenium Wrapper methods to perform various actions on the WebPage
 *
 */
public class SeleniumUtils {

	/**
	 *  This method navigates to an url.
	 */
	public static void navigateToUrl(WebDriver driver) {
		String url = CommonUtils.getConfigProperty("application.url");
		driver.get(url);
		System.out.println("Navigated to the url " + url);
	}

	/**
	 * @param element This method clears the input text
	 */
	public static void clearInputText(WebElement element) {
		element.clear();
	}

	/**
	 * @param element
	 * @param keysToSend
	 * 
	 * We are entering text to an input field by passing in the
	 * WebElement and the text to enter.
	 */

	public static void enterTextToAField(WebElement element, CharSequence... keysToSend) {
		clearInputText(element);
		element.sendKeys(keysToSend);
	}

	/**
	 * @param element
	 * @return This method gets us the text of an element.
	 */
	public static String getTextOfAWebElement(WebElement element) {
		return element.getText();
	}

		public static boolean isElementDisplayed(WebElement element){
		return element.isDisplayed();
	}
	
	/**
	 * @param element We are performing click operation on a WebElement.
	 */
	public static void clickOnAnElement(WebElement element) {
		element.click();
	}


	/**
	 * @return We are capturing the screenshots as bytes
	 */
	public static byte[] getScreenshotAsBytes(WebDriver driver) {
		try {
			byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			return screenshotBytes;
		} catch (Exception e) {
			throw e;
		}
	}

	public static void wait(int seconds){
		long milliSeconds = seconds * 1000;
		try{
			Thread.sleep(milliSeconds);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @param targetFile Taking the screenshot and saving it in file.
	 */
	public static void takeScreenshotAndSaveInFile(WebDriver driver, File targetFile) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, targetFile);
		} catch (IOException e) {
		}
	}

	// Explicit Wait
	/**
	 * This is an explicit wait method for a WebElement to be clickable
	 * 
	 * @param element
	 * @param driver
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitUntilElementClickable(WebElement element, WebDriver driver, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		WebElement foo = wait.until(ExpectedConditions.elementToBeClickable(element));
		return foo;

	}

	public static WebElement waitUntilElementVisible(WebElement element, WebDriver driver, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		WebElement foo;
		foo = wait.until(ExpectedConditions.visibilityOf(element));
		return foo;
	}

	/**
	 * @param driver, element, text
	 * @return This method enters a text and does an Enter.
	 */
	public static void typeAndEnterTheSearch(WebDriver driver, WebElement element, String text) throws Exception {
		try {
			waitUntilElementVisible(element, driver, 2);
			clearInputText(element);
			enterTextToAField(element,text);

			wait(1);

			Actions builder = new Actions(driver);
			builder.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("No such element" + element);
		}
	}

}
