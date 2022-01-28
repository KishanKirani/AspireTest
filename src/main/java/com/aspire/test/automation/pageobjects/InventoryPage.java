package com.aspire.test.automation.pageobjects;

import com.aspire.test.automation.utils.CommonUtils;
import com.aspire.test.automation.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Date;

public class InventoryPage {

    private WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@role='button' and text()='Inventory']")
    private WebElement inventoryButton;

    @FindBy(xpath = "//a[@role='button' and text()='Inventory']/following-sibling::ul/li[3]")
    private WebElement inventoryProductMenu;

    @FindBy(xpath = "//button[@type='button' and @accesskey='c']")
    private WebElement createButton;

    @FindBy(xpath = "//button[@type='button' and @accesskey='s']")
    private WebElement saveButton;

    @FindBy(xpath = "//button[@type='button' and @accesskey='j']")
    private WebElement discardButton;

    @FindBy(xpath = "//button[@type='button']/span[text()='Update Quantity']")
    private WebElement updateQuantityButton;

    @FindBy(xpath = "//li[@class='breadcrumb-item active']")
    private WebElement menuItemBreadCrumb;

    @FindBy(xpath = "//input[@placeholder='Product Name']")
    private WebElement productNameTextField;

    @FindBy(xpath = "//div[@name='location_id']")
    private WebElement locationDropdown;

    @FindBy(xpath = "//li/a[text()='Partner Locations/Stock']")
    private WebElement locationDropdownFirstElement;

    @FindBy(xpath = "//div[@name='package_id']")
    private WebElement packageDropdown;

    @FindBy(xpath = "//li/a[text()='1']")
    private WebElement packageDropdownFirstElement;

    @FindBy(xpath = "//input[@name='inventory_quantity']")
    private WebElement inventoryQuantityField;

    @FindBy(xpath = "//a[@title='Applications']")
    private WebElement applicationsButton;



    public void verifyPageNavigatedToInventory(){
        SeleniumUtils.waitUntilElementVisible(inventoryButton,driver,2);
        Assert.assertTrue(inventoryButton.isDisplayed(),"Inventory page is not visible");
    }

    public void clickOnSpecificTypeOfProductMenu(String menu) {
        SeleniumUtils.waitUntilElementVisible(inventoryProductMenu,driver,2);
        SeleniumUtils.clickOnAnElement(inventoryProductMenu);

        WebElement element = driver.findElement(By.xpath("//a[@role='button' and text()='Inventory']/following-sibling::ul/li[3]//a/span[text()='"+menu+"']"));
        SeleniumUtils.clickOnAnElement(element);

        SeleniumUtils.wait(2);
        Assert.assertTrue(menuItemBreadCrumb.getText().equalsIgnoreCase("products"),"Item selected from dropdown is not Product");
    }

    public void createANewProduct(){
        SeleniumUtils.waitUntilElementVisible(createButton,driver,2);
        SeleniumUtils.clickOnAnElement(createButton);
        Date date = new Date();
        String dateField = "test_"+ String.valueOf(date.getTime());
        System.out.println("Product Name :" + dateField);
        CommonUtils.setConfigProperty("product.name",dateField);
        SeleniumUtils.enterTextToAField(productNameTextField,dateField);
        SeleniumUtils.clickOnAnElement(saveButton);
    }

    public void updateQuantity(){
        SeleniumUtils.wait(2);
        SeleniumUtils.clickOnAnElement(updateQuantityButton);
        SeleniumUtils.wait(2);
        SeleniumUtils.clickOnAnElement(createButton);
        enterQuantityField();
    }

    public void enterQuantityField(){
        //update location field
        SeleniumUtils.clickOnAnElement(locationDropdown);
        SeleniumUtils.wait(1);
        SeleniumUtils.clickOnAnElement(locationDropdownFirstElement);
        //update package field
        /*if(packageDropdown.isDisplayed()){
            SeleniumUtils.clickOnAnElement(packageDropdown);
            SeleniumUtils.wait(1);
            SeleniumUtils.clickOnAnElement(packageDropdownFirstElement);
        }*/
        SeleniumUtils.wait(1);
        //update quantity field
        SeleniumUtils.enterTextToAField(inventoryQuantityField,"10");
        SeleniumUtils.clickOnAnElement(saveButton);
    }

    public void clickOnApplicationsButton(){
        SeleniumUtils.wait(3);
        SeleniumUtils.waitUntilElementVisible(applicationsButton,driver,2);
        SeleniumUtils.clickOnAnElement(applicationsButton);
    }

}
