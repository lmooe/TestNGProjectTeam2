package techproed.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AddNewProductPage {


//Inventory Section

    @FindBy (xpath = "(//div[@class='page_collapsible_content_holder'])[1]")
    public WebElement inventory;

    @FindBy (id = "sku")
    public WebElement sku;

    @FindBy (id = "manage_stock")
    public WebElement manageStock;

    @FindBy(id = "stock_qty")
    public WebElement stockQuantity;

    @FindBy(id = "sold_individually")
    public WebElement soldIndividually;


//Shipping Section

    @FindBy (xpath = "(//div[@class='page_collapsible_content_holder'])[4]")
    public WebElement shipping;

    @FindBy (id = "weight")
    public WebElement weight;

    @FindBy (id = "length")
    public WebElement length;

    @FindBy (id = "width")
    public WebElement width;

    @FindBy (id = "height")
    public WebElement height;

    // >>>>> PROCCESSING TIME DROPDOWN LIST BAK

// Attributes Section

    @FindBy (xpath = "(//div[@class='page_collapsible_content_holder'])[5]")
    public WebElement attributes;
}

