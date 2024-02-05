package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class DashboardPage {

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Orders")
    public WebElement ordersButton;
     @FindBy(linkText = "Downloads")
    public WebElement downloadsButton;
     @FindBy(linkText = "Addresses")
    public WebElement addressesButton;
     @FindBy(xpath = " //li[*='Account details']//a")
    public WebElement accountDetailsButton;
     @FindBy(linkText = "Wishlist")
    public WebElement wishlistsButton;

    @FindBy(xpath = "//li[*='Chat Box']//a")
    public WebElement chatBoxButton;

    @FindBy(linkText = "Logout")
    public WebElement logoutButton;

    @FindBy(xpath = "//li[*='Store Manager']//a")
    public WebElement storeManagerButton;











}
