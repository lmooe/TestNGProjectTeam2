package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Sign In']")      //  OR ==> "//a[@class='login inline-type']")
    public WebElement singIn1;

    @FindBy (xpath = "//a[@class='register inline-type']")
    public WebElement register;

    @FindBy(xpath = "//a[text()='Sign Up'])")
    public WebElement singUp;

    @FindBy (xpath = "//input[@id='register-policy']")
    public WebElement agreePolicy;

    @FindBy (xpath = "//button[text()='Sign Up']")
    public WebElement singUpButton;

    @FindBy (xpath = "//a[text()='Become a Vendor']")
    public WebElement becomeVendor;

    @FindBy(id="//input[@id='username']")
    public WebElement username;

    @FindBy(id="//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement signInButton;

    @FindBy(xpath = "//h2 [text()='My Account']")
    public WebElement verify;

    @FindBy(xpath ="(//*[@class='w-icon-cart'])[1]")
    public WebElement cart;

    @FindBy(xpath = "//*[@class='wishlist block-type']")
    public WebElement wishList;

    @FindBy(xpath = "//a[@class='login logout inline-type']")
    public WebElement signOut;


    @FindBy(xpath = "//li[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--wcfm-store-manager']")
    public WebElement storeMng; //check this one please !!


    @FindBy ( xpath="//div[@class='search-wrapper hs-simple']") //  OR  (//input[@name='s'])[1]
    public WebElement searchBox;



    @FindBy (xpath = "//a[text()='My Account']")
    public WebElement MyAccountOnFooter;

    //    For Registration Page:
    @FindBy(id = "reg_username")
    public WebElement regUsername;

    @FindBy(id = "reg_email")
    public WebElement regEmail;

    @FindBy(id = "reg_password")
    public WebElement regPassword;

    @FindBy(id = "register-policy")
    public WebElement regCheckBox;
    @FindBy(xpath = "//button[@name='register']")
    public WebElement signUpButton;

    @FindBy(linkText = "Register")
    public WebElement registerButton;

}