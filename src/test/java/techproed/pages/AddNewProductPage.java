package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class AddNewProductPage {

    @FindBy (xpath = "(//div[@class='page_collapsible_content_holder'])[1]")
    public WebElement inventory;

    @FindBy (id = "sku")
    public WebElement sku;

    @FindBy (id = "manage_stock")
    public WebElement manageStock;



///

    @FindBy (xpath = "(//div[@class='page_collapsible_content_holder'])[4]")
    public WebElement shipping;

///

    @FindBy (xpath = "(//div[@class='page_collapsible_content_holder'])[5]")
    public WebElement attributes;
}
