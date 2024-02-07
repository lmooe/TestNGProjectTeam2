package techproed.pages;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.util.LRUMap;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class Bill_ShipAddressPage {


    public static LRUMap<Object, Object> shippingZipcodeInput;
    public static Alert shipAddressLine1Input;
    public static WebElement[] allShippingAddressTableElements;
    public static WebElement saveAddressButton;
    public static Bill_ShipAddressPage shipZipPostCodeInput;
    public static Bill_ShipAddressPage townCityInput;
    public static JsonFormat.Features invalidDataAlertList;


    public Bill_ShipAddressPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    /////////////  Billing Address  ////////////////


    // Note: works for both existing and new profile

    @FindBy(xpath = "//*[@class='edit btn btn-link btn-primary btn-underline mb-4']")
    public static WebElement editBillingAdd;

    @FindBy(id = "billing_first_name")
    public static WebElement billFirstName;

    @FindBy(id = "billing_last_name")
    public static WebElement billLastName;

    @FindBy(id = "billing_company")
    public WebElement billCompOptional;

    @FindBy(id = "select2-billing_country-container")
    public WebElement billCountryDD;

    @FindBy(name = "billing_address_1")
    public WebElement billAddressLine1;

    @FindBy(name = "billing_address_2")
    public WebElement billAddressLine2;

    @FindBy(name = "billing_city")
    public WebElement billTownCity;

    @FindBy(id = "select2-billing_state-container")
    public WebElement billStateProvinceDD;

    @FindBy(name = "billing_postcode")
    public WebElement billZipPostCode;

    @FindBy(id = "billing_phone")
    public WebElement billPhoneNumb;

    @FindBy(id = "billing_email")
    public WebElement billEmail;

    @FindBy(xpath = "//button[@name='save_address']")
    public WebElement billSaveAddressButton;

    @FindBy (xpath = "//div[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public WebElement successMessageBilling;


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

    @FindBy(id = "select2-shipping_country-container")
    public static WebElement shipCountryDD;

    @FindBy(name = "shipping_address_1")
    public WebElement shipAddressLine1;

    @FindBy(name = "shipping_address_2")
    public WebElement shipAddressLine2;

    @FindBy(name = "shipping_city")
    public WebElement shipTownCity;

    @FindBy(id = "select2-shipping_state-container")
    public static WebElement shipStateProvinceDD;

    @FindBy(name = "shipping_postcode")
    public WebElement shipZipPostCode;

    @FindBy(xpath = "//button[@name='save_address']")
    public WebElement shipSaveAddressButton;
}

