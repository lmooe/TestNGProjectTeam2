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
    WebElement couponsButton;

    @FindBy(id = "add_new_coupon_dashboard")
    WebElement addNewCouponButton;

    @FindBy(id = "title")
    WebElement codeField;

    @FindBy(id = "description")
    WebElement descriptionField;

    @FindBy(id = "discount_type")
    WebElement discountTypeDropdown;

    @FindBy(id = "coupon_amount")
    WebElement couponAmountField;

    @FindBy(xpath = "//input[@name='expiry_date']")
    WebElement yearField;

    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    WebElement monthDropdown;

    @FindBy(xpath = "//select[@class='ui-datepicker-year']")
    WebElement yearDropdown;

    @FindBy(linkText = "15")
    WebElement dayBox;

    @FindBy(id = "free_shipping")
    WebElement allowFreeShippingCheckBox;

    @FindBy(id = "show_on_store")
    WebElement showOnStoreCheckBox;

    @FindBy(id = "minimum_amount")
    WebElement minimumAmount;

    @FindBy(id = "maximum_amount")
    WebElement maximumAmount;

    @FindBy(xpath = "(//input[@class='select2-search__field'])[3]")
    WebElement productCategoriesField;

    @FindBy(xpath = "(//input[@class='select2-search__field'])[4]")
    WebElement excludeCategoriesField;

    @FindBy(id = "customer_email")
    WebElement emailRestrictionField;

    @FindBy(id = "wcfm_coupon_manager_submit_button")
    WebElement submitButton;
}
