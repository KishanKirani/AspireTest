package com.aspire.test.automation.test;

import com.aspire.test.automation.helpers.DriverManager;
import com.aspire.test.automation.hooks.ServiceHooks;
import com.aspire.test.automation.pageobjects.HomePage;
import com.aspire.test.automation.pageobjects.InventoryPage;
import com.aspire.test.automation.pageobjects.LoginPage;
import com.aspire.test.automation.pageobjects.ManufacturingPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CompleteFeatureTest extends ServiceHooks {
    private WebDriver driver ;
    public CompleteFeatureTest() {
        driver= DriverManager.getDriver();
    }

    @Test
    public void createAndValidateInventoryToManufactureTest() throws Exception {
        //1.Login to the web application
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyDefaultLoginPageContents();
        loginPage.performLoginToApplication();
        HomePage homePage = new HomePage(driver);
        //2.Navigate to inventory feature
        homePage.clickOnSpecificFeature("Inventory");
        //Validate inventory page and create a product
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.verifyPageNavigatedToInventory();
        //3.From the top-menu bar, select `Products -> Products` item, then create a new product
        inventoryPage.clickOnSpecificTypeOfProductMenu("Products");
        inventoryPage.createANewProduct();
        //4.Update the quantity of new product is more than 10
        inventoryPage.updateQuantity();
        //5.From top-left page, click on 'Application' icon
        inventoryPage.clickOnApplicationsButton();
        //6.Navigate to `Manufacturing` feature, then create a new Manufacturing Order item
        //for the created Product on step #3
        homePage.clickOnSpecificFeature("Manufacturing");
        ManufacturingPage manufacturingPage = new ManufacturingPage(driver);
        manufacturingPage.createANewManufacturingOrderItem();
        //7.Update the status of new Orders to “Done” successfully
        manufacturingPage.markTheOrderToDone();
        //8.Validate the new Manufacturing Order is created with corrected information.
    }
}
