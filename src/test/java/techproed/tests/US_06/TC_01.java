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

        ExtentReportUtils.createTestReport("End-to-End Test Report", "Product Purchase Function");

//    User is on www.allovercommerce.com
        ExtentReportUtils.info("Pre-condition: User is on https://allovercommerce.com/");
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));

//    User has signed in.
        ExtentReportUtils.info("Pre-condition: User signs in");
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
        ExtentReportUtils.pass("User enters product in search box on homepage and clicks enter");
        homePage.searchBox.click();
        homePage.searchBox.clear();
        homePage.searchBox.sendKeys(ConfigReader.getProperty("product1"), Keys.ENTER);
        WaitUtils.waitFor(2);

//    Click 'Add to Cart' button
        ExtentReportUtils.pass("User clicks Add To Cart button");
        productPage.addToCartButton.click();

//    Verify message "'Tshirt' has been added to your cart." appears
        String successMessage = productPage.addedToCartAlert.getText();
        System.out.println(successMessage);
        Assert.assertTrue(successMessage.contains("has been added to your cart."));
        ExtentReportUtils.passAndCaptureScreenshot("Product added to cart message successfully displayed");

//    Click on Cart icon
        ExtentReportUtils.pass("User clicks cart icon");
        homePage.cart.click();
        WaitUtils.waitFor(2);

//    Click on View Cart button
        ExtentReportUtils.pass("User clicks View Cart button");
        JSUtils.JSclickWithTimeout(productPage.viewCartButton);

//    Verify product is visible in Shopping Cart
        String productInCart = shoppingCartPage.productAddedInCart.getText();
        System.out.println(productInCart);
        Assert.assertTrue(productInCart.contains(ConfigReader.getProperty("product1")));
        ExtentReportUtils.passAndCaptureScreenshot("Product visible in cart");

//    Click on '+' button
        ExtentReportUtils.pass("User clicks + button");
        shoppingCartPage.plusButton.click();

//    Click on Update Cart button
        ExtentReportUtils.pass("User clicks Update Cart button");
        shoppingCartPage.updateCartButton.click();
        WaitUtils.waitFor(2);

//    Verify message "Cart updated." appears
        String cartUpdateMsg = shoppingCartPage.cartUpdated.getText();
        Assert.assertEquals(cartUpdateMsg, "Cart updated.");
        ExtentReportUtils.passAndCaptureScreenshot("Cart Updated message successfully displayed");

//    Click on 'Proceed to Checkout' button
        ExtentReportUtils.pass("User clicks Procced to Checkout button");
        JSUtils.JSclickWithTimeout(shoppingCartPage.checkoutButton);

//    Verify country, street address lines 1 & 2, town, county, postcode and phone have been populated
        Assert.assertEquals(checkOutPage.billCountryDD.getAttribute("title"), ConfigReader.getProperty("uk"));
        Assert.assertEquals(checkOutPage.billAddressLine1.getAttribute("value"), ConfigReader.getProperty("streetaddress1"));
        Assert.assertEquals(checkOutPage.billAddressLine2.getAttribute("value"), ConfigReader.getProperty("streetaddress2"));
        Assert.assertEquals(checkOutPage.billTownCity.getAttribute("value"), ConfigReader.getProperty("town"));
        Assert.assertEquals(checkOutPage.billCounty.getAttribute("value"), ConfigReader.getProperty("county"));
        Assert.assertEquals(checkOutPage.billZipPostCode.getAttribute("value"), ConfigReader.getProperty("postcode"));
        Assert.assertEquals(checkOutPage.billPhoneNumb.getAttribute("value"), ConfigReader.getProperty("phone"));
        ExtentReportUtils.passAndCaptureScreenshot("Billing address successfully populated");

//    Verify 'Payment Methods' are visible
        Assert.assertEquals(checkOutPage.wireTransferEFTLabel.getText(), ConfigReader.getProperty("payment1"));
        Assert.assertEquals(checkOutPage.payAtDoorLabel.getText(), ConfigReader.getProperty("payment2"));
        ExtentReportUtils.passAndCaptureScreenshot("Payment methods successfully displayed");

//    Select 'Pay at the door'
        ExtentReportUtils.pass("User selects payment method");
        BrowserUtils.clickWithTimeOut(checkOutPage.payAtDoor, 1);
        BrowserUtils.clickWithTimeOut(checkOutPage.placeOrderButton, 1);

//    On order complete page, verify 'Thank you. Your order has been received.' is visible
        WaitUtils.waitFor(2);
        String orderRecMsg = checkOutPage.orderReceivedMessage.getText();
        System.out.println(orderRecMsg);
        Assert.assertEquals(orderRecMsg,"Thank you. Your order has been received.");
        ExtentReportUtils.passAndCaptureScreenshot("Order received message successfully displayed");
        ExtentReportUtils.flush();
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}