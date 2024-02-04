package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class CheckoutPage {

    public CheckoutPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    //SHOPPING CHART POP-UP
    @FindBy(linkText = "View cart")
    WebElement viewChartButton;

    @FindBy(linkText = "View cart")
    WebElement checkoutButton;




    //ENTER CODE
    @FindBy(linkText = "Enter your code")
    WebElement enterYourCode;

    @FindBy(id = "coupon_code")
    WebElement couponCodeField;

    @FindBy(xpath = "//button[@name='apply_coupon']")
    WebElement applyCouponButton;



    //YOUR ORDER PART

    @FindBy(xpath = "(//td[@class='product-name'])[1]")
    WebElement productNameAndNumber;


    @FindBy(xpath = "(//td//span[@class='woocommerce-Price-amount amount'])[1]")
    WebElement productPrice;

    @FindBy(xpath = "//input[@value='bacs']")
    WebElement wireTransferEFT;

    @FindBy(xpath = "//div[@class='payment_box payment_method_bacs']")
    WebElement additionInfoForWireTransfer;

    @FindBy(xpath = "//input[@value='cod']")
    WebElement payAtDoor;

    @FindBy(id = "//button[@id='place_order']")
    WebElement placeOrderButton;

    @FindBy(xpath = "//div[@class='woocommerce-order']")
    WebElement verificationOrderMessage;

}
