package com.aspire.test.automation.pageobjects;

import com.aspire.test.automation.utils.CommonUtils;
import com.aspire.test.automation.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufacturingPage {
    private WebDriver driver;

    public ManufacturingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@type='button' and @accesskey='c']")
    private WebElement createButton;

    @FindBy(xpath = "//button[@type='button' and @accesskey='s']")
    private WebElement saveButton;

    @FindBy(xpath = "//button[@type='button' and @accesskey='a']")
    private WebElement editButton;

    @FindBy(xpath = "//button/span[text()='Confirm']")
    private WebElement confirmButton;

    @FindBy(xpath = "//button/span[text()='Mark as Done']")
    private WebElement markAsDoneButton;

    @FindBy(xpath = "//label[text()='Product']/parent::td/following-sibling::td//input")
    private WebElement productDropdown;

    @FindBy(xpath = "//input[@name='product_qty']")
    private WebElement newQuantity;

    @FindBy(xpath = "//input[@name='qty_producing']")
    private WebElement quantityProducing;

    @FindBy(xpath = "//a[@role='button' and text()='Add a line']")
    private WebElement addALineButton;

    @FindBy(xpath = "//div[contains(@id,'notebook_page')]//tbody//div[@name='product_id']//input")
    private WebElement productComponent;

    @FindBy(xpath = "//div[contains(@id,'notebook_page')]//input[@name='product_uom_qty']")
    private WebElement toConsumeComponent;

    @FindBy(xpath = "//span[@placeholder='Manufacturing Reference']")
    private WebElement manufacturingReference;

    public void createANewManufacturingOrderItem() throws Exception {
        String product = CommonUtils.getConfigProperty("product.name");
        SeleniumUtils.waitUntilElementVisible(createButton,driver,2);
        SeleniumUtils.clickOnAnElement(createButton);

        SeleniumUtils.typeAndEnterTheSearch(driver,productDropdown,product);

        addAProductToConsume(product);

        SeleniumUtils.enterTextToAField(newQuantity,"10");

        SeleniumUtils.waitUntilElementVisible(saveButton,driver,2);
        SeleniumUtils.clickOnAnElement(saveButton);

        SeleniumUtils.wait(3);
        clickOnConfirmButton();
    }

    public void addAProductToConsume(String product) throws Exception {
        SeleniumUtils.waitUntilElementVisible(addALineButton,driver,2);
        SeleniumUtils.clickOnAnElement(addALineButton);
        SeleniumUtils.wait(1);
        SeleniumUtils.typeAndEnterTheSearch(driver,toConsumeComponent,"10");
        SeleniumUtils.wait(1);
        SeleniumUtils.typeAndEnterTheSearch(driver,productComponent,product);
    }

    public void markTheOrderToDone(){
        SeleniumUtils.wait(2);
        SeleniumUtils.waitUntilElementVisible(editButton,driver,2L);
        SeleniumUtils.clickOnAnElement(editButton);

        SeleniumUtils.enterTextToAField(quantityProducing,"10");

        SeleniumUtils.waitUntilElementVisible(saveButton,driver,2);
        SeleniumUtils.clickOnAnElement(saveButton);

        clickOnMarkAsDoneButton();
    }

    public void clickOnConfirmButton(){
        SeleniumUtils.waitUntilElementVisible(confirmButton,driver,2);
        SeleniumUtils.clickOnAnElement(confirmButton);
    }

    public void clickOnMarkAsDoneButton(){
        SeleniumUtils.waitUntilElementVisible(markAsDoneButton,driver,2);
        SeleniumUtils.clickOnAnElement(markAsDoneButton);
    }

    public String getManufacturingReference(){
       String reference ;
       reference = SeleniumUtils.getTextOfAWebElement(manufacturingReference);
       return reference;
    }

}
