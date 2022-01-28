package com.aspire.test.automation.helpers;

import com.aspire.test.automation.utils.CommonUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static com.aspire.test.automation.constants.FrameworkConstants.CHROME_DRIVER;

public class DriverManager {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    private static WebDriver createDriver() {
        String browserName = CommonUtils.getConfigProperty("web.browser.name");
        if (browserName.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-dev-shm-usage");
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            File file = new File(CHROME_DRIVER);
            System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void initialDriverSetUp() {
        long wait = Long.parseLong(CommonUtils.getConfigProperty("implicitly.wait"));
        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }

}
