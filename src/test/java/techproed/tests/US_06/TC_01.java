package techproed.tests.US_06;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import techproed.pages.AddNewProductPage;
import techproed.pages.HomePage;
import techproed.pages.ProductPage;
import techproed.utilities.*;

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

    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();

    @BeforeMethod
    public void setUp(){
//    User is on www.allovercommerce.com
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
    }

    @Test
    public void TC_01(){
//    User has signed in.
        BrowserUtils.clickWithTimeOut(homePage.singIn1, 1);
        Driver.getDriver().findElement(By.id("username")).click();
        Driver.getDriver().findElement(By.id("username")).clear();
        Driver.getDriver().findElement(By.id("username")).sendKeys(ConfigReader.getProperty("user1"));
        Driver.getDriver().findElement(By.id("password")).click();
        Driver.getDriver().findElement(By.id("password")).clear();
        Driver.getDriver().findElement(By.id("password")).sendKeys(ConfigReader.getProperty("pass1"));
        BrowserUtils.clickWithTimeOut(homePage.signInButton, 1);

//        BrowserUtils.sendKeysWithTimeout(homePage.username, ConfigReader.getProperty("user1"), 1);
//        BrowserUtils.sendKeysWithTimeout(homePage.password, ConfigReader.getProperty("pass1"), 1);
//        BrowserUtils.clickWithTimeOut(homePage.signInButton, 1);

//    Click in the search box, enter product name (Tshirt) and click enter
//        BrowserUtils.sendKeysWithTimeout(homePage.searchBox, "Tshirt", 1);
//    Searchbox locator //input[@class='form-control']
//    Click 'Add to Cart' button
//        BrowserUtils.clickWithTimeOut(productPage.addToCartButton, 1);
//    Verify the message "'Tshirt' has been added to your cart." appears
//        String successMessage = productPage.addedToCartAlert.getText();
//        Assert.assertEquals(successMessage,"VIEW CART \"Tshirt\" has been added to your cart.");
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