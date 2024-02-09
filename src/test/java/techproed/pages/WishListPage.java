package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class WishListPage {
    public  WishListPage(){
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "(//a[@data-title='Add to wishlist'])[1]")
    public WebElement clickOnHeart;

    @FindBy(xpath = "(//li[@class='product-wrap slider-slide slider-slide-active'])[1]")
    public WebElement clickOnAutomaticCrusher;

    @FindBy(xpath = "//div[@class='yith-wcwl-wishlistaddedbrowse']")
    public WebElement redHeartIcon;

    @FindBy(xpath = "//a[@class='wishlist block-type']")
    public WebElement clickOnWishListTab;

    @FindBy(xpath = "//th[@class='product-thumbnail']")
    public WebElement productIsVisible;

    @FindBy(xpath = "(//span[@class='nobr'])[1]")
    public WebElement priceIsVisible;

    @FindBy(xpath = "(//span[@class='nobr'])[2]")
    public WebElement stockStatusIsVisible;

    @FindBy(xpath = "//th[@class='product-add-to-cart']")
    public WebElement actionsIsVisible;

    @FindBy(xpath = "//button[@title='Quick View']")
    public WebElement quickViewButton;

    @FindBy(xpath = "//p[@class='price']")
    public WebElement priceOnPopUp;

    @FindBy(xpath = "//span[@class='posted_in']")
    public WebElement categoryOnPopUp;

    @FindBy(xpath = "//a[@class='woocommerce-review-link scroll-to']")
    public WebElement reviews;

    @FindBy(xpath = "//button[@title='Close (Esc)']")
    public WebElement closeButtonOnPopUp;

    @FindBy(xpath = "//span[@class='sku_wrapper']")
    public WebElement skuNumber;

    @FindBy(xpath="//a[@aria-label='Add “Automatic Crusher” to your cart']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement successMessage;


}

