package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class CouponPage {


    public CouponPage (){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Coupons")
    public WebElement couponsButton;

    @FindBy(id = "add_new_coupon_dashboard")
    public WebElement addNewCouponButton;

    @FindBy(id = "title")
    public WebElement codeField;

    @FindBy(id = "description")
    public WebElement descriptionField;

    @FindBy(id = "discount_type")
    public WebElement discountTypeDropdown;

    @FindBy(id = "coupon_amount")
    public WebElement couponAmountField;

    @FindBy(xpath = "//input[@name='expiry_date']")
    public WebElement expireDateField;

    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    public WebElement monthDropdown;

    @FindBy(xpath = "//select[@class='ui-datepicker-year']")
    public WebElement yearDropdown;

    @FindBy(linkText = "15")
    public WebElement dayBox;

    @FindBy(id = "free_shipping")
    public WebElement allowFreeShippingCheckBox;

    @FindBy(id = "show_on_store")
    public WebElement showOnStoreCheckBox;

    @FindBy(id = "minimum_amount")
    public WebElement minimumAmount;

    @FindBy(id = "maximum_amount")
    public WebElement maximumAmount;

    @FindBy(id = "product_categories")
    public WebElement productCategoriesDropDown;



    @FindBy(id = "exclude_product_categories")
    public WebElement excludeCategoriesDropDown;

    @FindBy(id = "customer_email")
    public WebElement emailRestrictionField;

    @FindBy(id = "wcfm_coupon_manager_submit_button")
    public WebElement submitButton;

    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']")
    public WebElement errorMessage;

    @FindBy(linkText = "SUMMER2024")
    public WebElement couponName;





}
