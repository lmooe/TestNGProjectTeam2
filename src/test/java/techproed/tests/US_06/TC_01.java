package techproed.tests.US_06;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import techproed.pages.*;
import techproed.utilities.*;

import java.util.ArrayList;
import java.util.List;

public class TC_01 {

    /*
    Pre-condition:
    User has signed in.

    Click in the search box, enter product name and click enter
    Click 'Add to Cart' button
    Verify message "VIEW CART '(product name)' has been added to your cart." appears
    Click on Cart icon
    Click on View Cart button
    Verify product is visible in Shopping Cart
    Click on '+' button
    Click on Update Cart button
    Verify message "Cart updated." appears
    Click on 'Proceed to Checkout' button
    Verify country, street address lines 1 & 2 , town, postcode and phone have been populated
    Verify 'Payment Methods' are visible
    Select 'Pay at the door'
    Select 'Place order'
    On order complete page, verify 'Thank you. Your order has been received.' is visible
     */

    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckOutPage checkOutPage = new CheckOutPage();

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
    public void US06_TC01() throws InterruptedException {
//    Click in the search box, enter product name (Tshirt) and click enter
        homePage.searchBox.click();
        homePage.searchBox.clear();
        homePage.searchBox.sendKeys(ConfigReader.getProperty("product1"), Keys.ENTER);
        WaitUtils.waitFor(2);
//    Click 'Add to Cart' button
        productPage.addToCartButton.click();
//    Verify message "'Tshirt' has been added to your cart." appears
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
        shoppingCartPage.plusButton.click();
//    Click on Update Cart button
        shoppingCartPage.updateCartButton.click();
        WaitUtils.waitFor(2);
//    Verify message "Cart updated." appears
        String cartUpdateMsg = shoppingCartPage.cartUpdated.getText();
        Assert.assertEquals(cartUpdateMsg, "Cart updated.");
//    Click on 'Proceed to Checkout' button
        JSUtils.JSclickWithTimeout(shoppingCartPage.checkoutButton);
//    Verify country, street address lines 1 & 2, town, county, postcode and phone have been populated
        Assert.assertTrue(checkOutPage.billCountryDD.isDisplayed());
        Assert.assertTrue(checkOutPage.billAddressLine1.isDisplayed());
        Assert.assertTrue(checkOutPage.billAddressLine2.isDisplayed());
        Assert.assertTrue(checkOutPage.billTownCity.isDisplayed());
        Assert.assertTrue(checkOutPage.billCounty.isDisplayed());
        Assert.assertTrue(checkOutPage.billZipPostCode.isDisplayed());
        Assert.assertTrue(checkOutPage.billPhoneNumb.isDisplayed());
//    Verify 'Payment Methods' are visible
        Assert.assertTrue(checkOutPage.wireTransferEFT.isDisplayed());
        Assert.assertTrue(checkOutPage.payAtDoor.isDisplayed());
//    Select 'Pay at the door'
        BrowserUtils.clickWithTimeOut(checkOutPage.payAtDoor, 1);
        BrowserUtils.clickWithTimeOut(checkOutPage.placeOrderButton, 1);
//    On order complete page, verify 'Thank you. Your order has been received.' is visible
        WaitUtils.waitFor(2);
        String orderRecMsg = checkOutPage.orderReceivedMessage.getText();
        System.out.println(orderRecMsg);
        Assert.assertEquals(orderRecMsg,"Thank you. Your order has been received.");
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}