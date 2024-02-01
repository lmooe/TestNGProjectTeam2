package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(xpath = "//*[@ class='login inline-type']")
    public WebElement singin;

    @FindBy(id="//input[@id='username']")
    public WebElement username;


    @FindBy(id="//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement signButtoN;

    @FindBy(xpath = "//*[@class='cart-toggle']")// GUYS PLS CHECK THIS XPATH ----- 2 ELEMENTS COME UP IN a TAG
    public WebElement cart;

    @FindBy(xpath = "//*[@class='wishlist block-type']")
    public WebElement wishList;

    @FindBy(xpath = "//a[@class='login logout inline-type']")
    public WebElement signOut;

    //----------- I GIVE UP :(  WHO FINDS THE XPATH FOR  "SEARCH" WEBELEMENT  WILL GET A CHOCOLATE FROM ME

    @FindBy(xpath = "//li[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--wcfm-store-manager']")
    public WebElement storeMng; //check this one please !!


}
