package techproed.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class ShoppingCartPage {

    public ShoppingCartPage() {
        PageFactory.initElements(Driver.getDriver(), this); }

    @FindBy (linkText = "Tshirt")
    public WebElement productAddedInCart;

    @FindBy (xpath = "//table/tbody/tr/td[4]/div/div/button[@title='Plus']")
    public WebElement plusButton;

    @FindBy (xpath = "//button[@name='update_cart']")
    public WebElement updateCartButton;

}
