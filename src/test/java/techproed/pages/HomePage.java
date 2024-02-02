package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(xpath = "//*[@ class='login inline-type']")
    public WebElement singin;

    @FindBy(id="//input[@id='username']")
    public WebElement username;


    @FindBy(id="//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement signButton;

    @FindBy(xpath = "//*[@class='cart-toggle']")// GUYS PLS CHECK THIS XPATH ----- 2 ELEMENTS COME UP IN a TAG
    public WebElement cart;

    @FindBy(xpath = "//*[@class='wishlist block-type']")
    public WebElement wishList;

    @FindBy(xpath = "//a[@class='login logout inline-type']")
    public WebElement signOut;


    @FindBy(xpath = "//li[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--wcfm-store-manager']")
    public WebElement storeMng; //check this one please !!

    // ************************
    @FindBy ( xpath="//div[@class='search-wrapper hs-simple']") //  this one shows 1:1 i am still not sure pls check !!!
    public WebElement searchBox;

    //**********************



}
