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

    @FindBy(xpath = "//input[@id='payment_method_cod']")
    public WebElement payAtDoor;

    @FindBy(xpath = "//button[@id='place_order']")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//div[@class='woocommerce-order']")
    public WebElement verificationOrderMessage;


}