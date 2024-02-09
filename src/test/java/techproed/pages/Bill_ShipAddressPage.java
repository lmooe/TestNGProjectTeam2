package techproed.pages;

import freemarker.cache.WebappTemplateLoader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class Bill_ShipAddressPage {




    public Bill_ShipAddressPage() {
        PageFactory.initElements(Driver.getDriver(), this);
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

    @FindBy(id = "account_first_name")
    public WebElement accFirstName;

    @FindBy(id = "billing_last_name")
    public WebElement billLastName;

    @FindBy(id = "account_last_name")
    public WebElement accLastName;

    @FindBy(id = "account_display_name")
    public WebElement ADN;

    @FindBy(id = "account_email")
    public WebElement AEA;

    @FindBy(xpath = "//*[@id=\"tinymce\"]/p")
    public WebElement biog;

    @FindBy(id = "password_current")
    public WebElement curpass;

    @FindBy(id = "password_1")
    public WebElement newpass;

    @FindBy(id = "password_2")
    public WebElement conpass;

    @FindBy (xpath = "//button[@name='save_account_details']")
    public WebElement accSaveButton;

    @FindBy(id = "billing_company")
    public WebElement billCompOptional;

    @FindBy (id="billing_country") // Sarah updated locator on 06/02/24
    public WebElement billCountryDD;

    //@FindBy(name = "billing_address_1")

    @FindBy (id="billing_country") // Sarah updated locator on 06/02/24
    public WebElement billCountryDDs;

    //For US_12
    @FindBy (id="select2-billing_country-container") // Fatih added locator on 07/02/24
    public WebElement billCountryDD1;

    @FindBy (name="billing_address_1")
    public WebElement billAddressLine1;

    @FindBy (name="billing_address_2")
    public WebElement billAddressLine2;

    @FindBy(name="billing_city")
    public WebElement billTownCity;


    @FindBy(id = "select2-billing_state-container")
public WebElement billstate;
    @FindBy (id = "billing_state")
    public WebElement billCounty;

    @FindBy (id="select2-billing_state-container")
    public WebElement billStateProvinceDD;

    @FindBy(name="billing_postcode")
    public WebElement billZipPostCode;

    @FindBy(id = "billing_phone")
    public WebElement billPhoneNumb;

    @FindBy (id="billing_email")
    public WebElement billEmail;

    @FindBy  (xpath = "//button[@name='save_address']")
    public WebElement billSaveAddressButton;

    @FindBy (xpath = "//div[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public WebElement successMessageBilling;


    /////////////  Shipping Address  ////////////////

    // Note: works for both existing and new profile

    @FindBy(xpath = "//*[@class='w-icon-long-arrow-right']")
    public WebElement editShippingAdd;

    @FindBy (xpath = "//*[@href='https://allovercommerce.com/my-account-2/edit-address/shipping/']")
    public WebElement addShip;

    @FindBy(id = "shipping_first_name")
    public WebElement shipFirstName;

    @FindBy(id = "shipping_last_name")
    public WebElement shipLastName;

    @FindBy(id = "shipping_company")
    public WebElement shipCompOptional;

    @FindBy  (xpath = "//*[@class='select2-selection select2-selection--single']")
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

    @FindBy (xpath = "//*[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public WebElement successMessage;

    @FindBy (xpath = "//*[@class='alert alert-simple alert-icon alert-close-top alert-danger']")
    public WebElement nonSuccessMessage;



}