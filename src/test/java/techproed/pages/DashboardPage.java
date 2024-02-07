package techproed.pages;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class DashboardPage {

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
//  Added by Sarah

    @FindBy(xpath = "//a[text()='Dashboard']")
    public WebElement dashboard;

    @FindBy(xpath = "//a[text()='Store Manager']")
    public WebElement storeManager;

    @FindBy(xpath = "//a[text()='Orders']")
    public WebElement orders;

    @FindBy(xpath = "//a[text()='Downloads']")
    public WebElement downloads;

    @FindBy(xpath = "//a[text()='Addresses']")
    public WebElement addresses;

    @FindBy (xpath = "//p[text()='Account details']")
    public WebElement accountDetails;
//  xpath corrected by Sarah
// This doesn't work for me Sarah So, I created new one with same name but 1 at the end and make it work for me
@FindBy (xpath = "//a[text()='Account details']")
public WebElement accountDetails1;

    @FindBy(xpath = "//a[text()='Wishlist']")
    public WebElement wishlist;

    @FindBy(xpath = "//a[text()='Support Tickets']")
    public WebElement supportTickets;

    @FindBy(xpath = "//a[text()='Followings']")
    public WebElement followings;

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logOut;

    @FindBy(partialLinkText = "vendor-register")
    public WebElement becomeAVendor;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div/div[3]/div[1]/div/a")
    public WebElement editBillingAddress;
    //This is different.
    //It doesn't accept partialLinkText or class name, and I had to copy and paste the xpath from the inspecting

    @FindBy(partialLinkText = "edit-address/shipping/")
    public WebElement editShippingAddress;

    @FindBy (id = "account_first_name")
    public WebElement accDetailsFirstName;

    @FindBy (id = "account_last_name")
    public WebElement accDetailsLastName;

    @FindBy (id = "account_email")
    public WebElement accDetailsEmail;


    
    @FindBy (id = "password_2")
    public WebElement confirmPassButton;

    @FindBy (id = "//button[@name='save_account_details']")
    public WebElement accDetailsSaveChanges;
//  I can't get the test to click this locator in a way that returns the success message.

}
