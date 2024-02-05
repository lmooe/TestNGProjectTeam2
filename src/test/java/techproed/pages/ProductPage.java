package techproed.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class ProductPage {

    public ProductPage() {
        PageFactory.initElements(Driver.getDriver(), this); }
    @FindBy(xpath = "//button[@value='15773']")
    public WebElement addToCartButton;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement addedToCartAlert;
    @FindBy(xpath = "//button[@title='Minus']")
    public WebElement minusButton;
    @FindBy(xpath = "//button[@title='Plus']")
    public WebElement plusButton;
    @FindBy(xpath = "//a[@title='Compare']")
    public WebElement compareButton;
    @FindBy(xpath = "//a[@data-title='Add to wishlist']")
    public WebElement wishListButton;

    @FindBy(xpath = "//button[@title='Minus']")
    public WebElement minusButton;

    @FindBy(xpath = "//button[@title='Plus']")
    public WebElement plusButton;

    @FindBy(xpath = "//a[@title='Compare']")
    public WebElement compareButton;

    @FindBy(xpath = "//a[@data-title='Add to wishlist']")
    public WebElement wishListButton;

//  Shopping Cart Sidebar
    @FindBy (xpath = "//a[@class='button wc-forward']")
    public WebElement viewCartButton;

    @FindBy (linkText = "Checkout")
    public WebElement checkoutButton;
}
