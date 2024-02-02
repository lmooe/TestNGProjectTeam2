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

}
