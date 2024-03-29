package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class CheckOutPage {


    public CheckOutPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    //SHOPPING CHART POP-UP
    @FindBy(xpath = "//a[@class='button wc-forward']")
    public WebElement viewChartButton;

    @FindBy(xpath = "//button[@name='clear_cart']")
    public WebElement clearChart;

    @FindBy(xpath = "//a[@class='button checkout wc-forward']")
    public WebElement checkoutButton;


    //BILLING DETAILS
//  Added by Sarah (same locators as in BillShipAddressPage)
    @FindBy(id = "billing_first_name")
    public WebElement billFirstName;

    @FindBy(id = "billing_last_name")
    public WebElement billLastName;

    @FindBy(id = "billing_company")
    public WebElement billCompOptional;

    @FindBy (id="select2-billing_country-container")
    public WebElement billCountryDD;

    @FindBy(xpath = "//select[@id='billing_country']")  //added by Esra
    public WebElement countryDropDown;

    @FindBy (name="billing_address_1")
    public WebElement billAddressLine1;

    @FindBy (name="billing_address_2")
    public WebElement billAddressLine2;

    @FindBy(name="billing_city")
    public WebElement billTownCity;

    @FindBy (id="select2-billing_state-container")
    public WebElement billStateProvinceDD;

    @FindBy(id = "billing_state")  //added by Esra
    public WebElement stateDropdown;

    @FindBy(name="billing_postcode")
    public WebElement billZipPostCode;

    @FindBy(id="billing_phone")
    public WebElement billPhoneNumb;

    @FindBy (id="billing_email")
    public WebElement billEmail;

    @FindBy (id = "billing_state")
    public WebElement billCounty;
//  Added by Sarah (UK specific for US_03 & US_06)


    //ENTER CODE
    @FindBy(xpath = "//a[@class='showcoupon']")
    public WebElement enterYourCode;

    @FindBy(id = "coupon_code")
    public WebElement couponCodeField;

    @FindBy(xpath = "//button[@name='apply_coupon']")
    public WebElement applyCouponButton;



    //YOUR ORDER PART

    @FindBy(xpath = "(//td[@class='product-name'])[1]")
    public WebElement productNameAndNumber;


    @FindBy(xpath = "(//td//span[@class='woocommerce-Price-amount amount'])[1]")
    public WebElement productPrice;

    @FindBy(xpath = "//input[@id='payment_method_bacs']")
    public WebElement wireTransferEFT;

    @FindBy(xpath = "//div[@class='payment_box payment_method_bacs']")
    public WebElement additionInfoForWireTransfer;

    @FindBy(xpath = "//*[@for='payment_method_bacs']")
    public WebElement wireTransferEFTLabel;

    @FindBy(xpath = "//input[@id='payment_method_cod']")
    public WebElement payAtDoor;

    @FindBy(xpath = "//*[@for='payment_method_cod']")
    public WebElement payAtDoorLabel;

    @FindBy(xpath = "//button[@id='place_order']")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//div[@class='woocommerce-order']")
    public WebElement verificationOrderMessage;

    @FindBy(xpath = "//a[@class='btn btn-dark btn-link btn-icon-right btn-close']")
    public WebElement closeButton;

    @FindBy(xpath = "(//span[@class='cart-count'])[1]")
    public WebElement productCounter;

    @FindBy(xpath = "//<li[@class='alert alert-simple alert-icon alert-close-top alert-danger']")
    public WebElement alertMsg;
    @FindBy(xpath = "//p[text()='Thank you. Your order has been received.']")
    public WebElement orderReceivedMessage;
//  Added by Sarah (almost the same as verificationOrderMessage but for 'Thank you. Your order has been received.' text only)



    //Orders Part
    @FindBy(xpath = "(//a[@class='woocommerce-button btn btn-default btn-rounded btn-outline btn-sm btn-block view'])[1]")
    public WebElement view;


    @FindBy(xpath = "//td[@class='woocommerce-table__product-name product-name']")
    public  WebElement productNameInOrder;


}