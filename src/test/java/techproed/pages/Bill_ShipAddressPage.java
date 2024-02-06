package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class Bill_ShipAddressPage {

    public Bill_ShipAddressPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    /////////////  Billing Address  ////////////////


    // Note: works for both existing and new profile

    @FindBy(xpath = "//*[@class='edit btn btn-link btn-primary btn-underline mb-4']")
    public WebElement editBillingAdd;

    @FindBy (xpath = "//*[text()='Address changed successfully.']") // Sarah added locator on 06/02/24
    public WebElement addressChangedMsg;

    @FindBy (xpath = "//*[text()='Street address is a required field.']") // Sarah added locator on 06/02/24
    public WebElement streetAddRequiredMsg;

    @FindBy(id = "billing_first_name")
    public WebElement billFirstName;

    @FindBy(id = "billing_last_name")
    public WebElement billLastName;

    @FindBy(id = "billing_company")
    public WebElement billCompOptional;

    @FindBy (id="billing_country") // Sarah updated locator on 06/02/24
    public WebElement billCountryDD;

    @FindBy (name="billing_address_1")
    public WebElement billAddressLine1;

    @FindBy (name="billing_address_2")
    public WebElement billAddressLine2;

    @FindBy(name="billing_city")
    public WebElement billTownCity;

    @FindBy (id = "billing_state")
    public WebElement billCounty;

    @FindBy (id="select2-billing_state-container")
    public WebElement billStateProvinceDD;

    @FindBy(name="billing_postcode")
    public WebElement billZipPostCode;

    @FindBy(id="billing_phone")
    public WebElement billPhoneNumb;

    @FindBy (id="billing_email")
    public WebElement billEmail;

    @FindBy  (xpath = "//button[@name='save_address']")
    public WebElement billSaveAddressButton;


    /////////////  Shipping Address  ////////////////

    // Note: works for both existing and new profile

    @FindBy(xpath = "//*[@class='edit btn btn-link btn-primary btn-underline mb-4']")
    public WebElement editShippingAdd;

    //need non edit option

    @FindBy(id = "shipping_first_name")
    public WebElement shipFirstName;

    @FindBy(id = "shipping_last_name")
    public WebElement shipLastName;

    @FindBy(id = "shipping_company")
    public WebElement shipCompOptional;

    @FindBy (id="select2-shipping_country-container")
    public WebElement shipCountryDD;

    @FindBy (name="shipping_address_1")
    public WebElement shipAddressLine1;

    @FindBy (name="shipping_address_2")
    public WebElement shipAddressLine2;

    @FindBy(name="shipping_city")
    public WebElement shipTownCity;

    @FindBy (id="select2-shipping_state-container")
    public WebElement shipStateProvinceDD;

    @FindBy(name="shipping_postcode")
    public WebElement shipZipPostCode;

    @FindBy  (xpath = "//button[@name='save_address']")
    public WebElement shipSaveAddressButton;




}