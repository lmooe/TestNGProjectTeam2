package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {

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

    @FindBy(xpath ="//a[text()='Account details']" )
    public WebElement accountDetails;

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

    @FindBy(partialLinkText = "edit-address/billing/")
    public WebElement editBillingAddress;

    @FindBy(partialLinkText = "edit-address/shipping/")
    public WebElement editShippingAddress;

}
