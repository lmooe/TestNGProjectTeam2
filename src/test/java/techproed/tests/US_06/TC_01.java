package techproed.tests.US_06;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import techproed.pages.AddNewProductPage;
import techproed.pages.HomePage;
import techproed.pages.ProductPage;
import techproed.pages.ShoppingCartPage;
import techproed.utilities.*;

public class TC_01 {

    /*
    Pre-condition:
    User has signed in.

    Click in the search box, enter product name (Tshirt) and click enter
    Click 'Add to Cart' button
    Verify the message '"Tshirt" has been added to your cart.' appears
    Click on Cart icon
    Click on View Cart button
    Verify product is visible in Shopping Cart
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
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @BeforeMethod
    public void setUp(){
//    User is on www.allovercommerce.com
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
//    User has signed in.
        BrowserUtils.clickWithTimeOut(homePage.singIn1, 1);
        homePage.username.click();
        homePage.username.clear();
        homePage.username.sendKeys(ConfigReader.getProperty("user1"));
        homePage.password.click();
        homePage.password.clear();
        homePage.password.sendKeys(ConfigReader.getProperty("pass1"));
        BrowserUtils.clickWithTimeOut(homePage.signInButton, 1);
        WaitUtils.waitFor(3);
    }

    @Test
    public void TC_01() throws InterruptedException {
//    Click in the search box, enter product name (Tshirt) and click enter
        homePage.searchBox.click();
        homePage.searchBox.clear();
        homePage.searchBox.sendKeys(ConfigReader.getProperty("product1"), Keys.ENTER);
        WaitUtils.waitFor(2);
//    Click 'Add to Cart' button
        productPage.addToCartButton.click();
//    Verify the message "'Tshirt' has been added to your cart." appears
        String successMessage = productPage.addedToCartAlert.getText();
        System.out.println(successMessage);
        Assert.assertTrue(successMessage.contains("has been added to your cart."));
//    Click on Cart icon
        homePage.cart.click();
        WaitUtils.waitFor(2);
//    Click on View Cart button
        JSUtils.JSclickWithTimeout(productPage.viewCartButton);
//    Verify product is visible in Shopping Cart
        String productInCart = shoppingCartPage.productAddedInCart.getText();
        System.out.println(productInCart);
        Assert.assertTrue(productInCart.contains(ConfigReader.getProperty("product1")));
//    Click on '+' button
//        "//table[@id='table1']//tr//td[5]"


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