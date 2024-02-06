package techproed.tests.US_15;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.AddNewProductPage;
import techproed.pages.DashboardPage;
import techproed.pages.HomePage;
import techproed.utilities.BrowserUtils;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import org.openqa.selenium.support.ui.Select;

public class TC_01 {


    /*Task:

    Pre-cond:
    1- User must be landed on valid url,
    2- Sign in with given credentials,
    3- than must land on to Store Manager from My Account. User must click "Product" on left sidebar and then "Add New"
    4- User must enter valid product title, product image, gallery image, product category

    Test Steps:
    1- The user needs to verify the visibility of the Inventory, Shipping, Attributes, Linked, SEO, and Advanced menus
    2- The user needs to click on "Inventory" and must see related section is visible needs to enter valid data to SKU
    field, click to Manage Stock box, enter valid data to Stock Qty field, click to Sold Individually box
    3- The user needs to click on "Shipping" and must see related section is visible and needs to enter valid data to
     Weight, Dimensions (Length, Width, Height) fields. User needs to select valid options of Shipping class and
     Processing Time dropdown lists.
    4- The user needs to click on "Attributes" and must see related section is visible and needs to click Color
    and Size boxes, and choose given data in color and size sections
    5- The user needs to click submit button

    Excepted result: User must publish the product

    */


    @Test
    public void TC_01(){
        //PC_1- User must be landed on valid url
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));

        //PC_2- Sign in with given credentials
        HomePage hp = new HomePage();
        BrowserUtils.clickWithTimeOut(hp.singIn1,1);
        BrowserUtils.sendKeysWithTimeout(hp.username,ConfigReader.getProperty("email"),1);
        BrowserUtils.sendKeysWithTimeout(hp.username,ConfigReader.getProperty("password"),1);
        BrowserUtils.clickWithTimeOut(hp.signInButton,1);

        //PC_3- than must land on to Store Manager from My Account.
        BrowserUtils.clickWithTimeOut(hp.signOut,1);
        DashboardPage dbp = new DashboardPage();
        BrowserUtils.clickWithTimeOut(dbp.storeManager,1);
        AddNewProductPage anpp = new AddNewProductPage();
        BrowserUtils.clickWithTimeOut(anpp.productsOption,1);
        BrowserUtils.clickWithTimeOut(anpp.addNewButton,1);

        //PC_4- User must enter valid product title, product image, gallery image, product category
        BrowserUtils.sendKeysWithTimeout(anpp.productTitleInput, ConfigReader.getProperty("product_title"),1);
        BrowserUtils.

















    }
}
