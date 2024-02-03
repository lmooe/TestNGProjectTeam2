package techproed.tests.US_06;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.AddNewProductPage;
import techproed.pages.HomePage;
import techproed.pages.ProductPage;
import techproed.utilities.BrowserUtils;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class TC_01 {

    /*
    Pre-condition:
    User has signed in.

    Click in the search box, enter product name (Tshirt) and click enter
    Click 'Add to Cart' button
    Verify the message '"Tshirt" has been added to your cart.' appears
    Click on Cart icon
    Verify product is visible on Shopping Cart sidebar
    Click on View Cart button
    Click on '+' button
    Verify quantity amount has increased
    Click on Update Cart button
    Click on 'Proceed to Checkout' button
    Verify country, street address, town, postcode and phone have been populated
    Verify 'Payment Methods' are visible
    Select 'Pay at the door'
    Select 'Place order'
    On order complete page verify 'Thank you. Your order has been received.' is visible
     */

    @Test
    public void TC_01(){
//    User is on www.allovercommerce.com
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
//    User has signed in.
        HomePage homePage = new HomePage();
//        BrowserUtils.clickWithTimeOut(homePage.singin, 1);
        BrowserUtils.clickWithTimeOut(Driver.getDriver().findElement(By.xpath("//*[text()='Sign In']")), 1);
//        BrowserUtils.sendKeysWithTimeout(homePage.password, ConfigReader.getProperty("username"), 1);
//        BrowserUtils.sendKeysWithTimeout(homePage.password, ConfigReader.getProperty("password"), 1);
//        BrowserUtils.clickWithTimeOut(homePage.signButton, 1);
//    Click in the search box, enter product name (Tshirt) and click enter
        BrowserUtils.sendKeysWithTimeout(homePage.searchBox, "Tshirt", 1);
//    Searchbox locator //input[@class='form-control']
//    Click 'Add to Cart' button
        ProductPage productPage = new ProductPage();
        BrowserUtils.clickWithTimeOut(productPage.addToCartButton, 1);
//    Verify the message "'Tshirt' has been added to your cart." appears
        String successMessage = productPage.addedToCartAlert.getText();
        Assert.assertEquals(successMessage,"VIEW CART \"Tshirt\" has been added to your cart.");
//    Click on Cart icon
//    Verify product is visible on Shopping Cart sidebar
//    Click on View Cart button
//    Click on '+' button
//    Verify quantity amount has increased
//    Click on Update Cart button
//    Click on 'Proceed to Checkout' button
//    Verify country, street address, town, postcode and phone have been populated
//    Verify 'Payment Methods' are visible
//    Select 'Pay at the door'
//    Select 'Place order'
//    On order complete page verify 'Thank you. Your order has been received.' is visible

    }
}