package techproed.tests.US_17;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import techproed.pages.*;
import techproed.utilities.*;

public class TC_01 {

    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    DashboardPage dashboardPage = new DashboardPage();

    @BeforeMethod
    public void deleteCart(){
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));

        //Sign in
        JSUtils.JSclickWithTimeout(homePage.singIn1);
        homePage.username.sendKeys(ConfigReader.getProperty("email"));
        homePage.password.sendKeys(ConfigReader.getProperty("password"));
        homePage.signInButton.click();
        WaitUtils.waitFor(4);

        //Delete cart, if it is not empty
        if(Integer.parseInt(checkOutPage.productCounter.getText())>0){
            homePage.cart.click();
            checkOutPage.viewChartButton.click();
            checkOutPage.clearChart.click();
        }
    }


    @Test
    public void vendorBuyProductTest(){


        ExtentReportUtils.createTestReport("Extent Report for US_17  TC_01","Place Order As Vendor Functionality");

        ExtentReportUtils.info("Vendor places order successfully");

        //Search and add product
        homePage.searchBox.sendKeys(ConfigReader.getProperty("product2"), Keys.ENTER);

        WebElement leatherShoe = Driver.getDriver().findElement(By.linkText("Leather shoes"));
        JSUtils.JSclickWithTimeout(leatherShoe);

        BrowserUtils.clickWithTimeOut(productPage.plusButton,2);
        BrowserUtils.clickWithTimeOut(productPage.addToCartButton2,1);

        ExtentReportUtils.pass("Vendor adds product into cart successfully.");

        //Go to cart pop-up and click checkout button
        homePage.cart.click();
        WaitUtils.waitFor(2);

        checkOutPage.checkoutButton.click();

        ExtentReportUtils.pass("Vendor clicks 'checkout button'");

        //verify the products' name and price
        Assert.assertTrue(checkOutPage.productNameAndNumber.getText().contains(ConfigReader.getProperty("productNameAndNumber")));
        Assert.assertTrue(checkOutPage.productPrice.getText().contains(ConfigReader.getProperty("productPrice")));

        ExtentReportUtils.passAndCaptureScreenshot("Vendor sees the added product in checkout.");


        //Click Wire/Transfer Button and verify the addition information
        JSUtils.JSclickWithTimeout(checkOutPage.wireTransferEFT);
        Assert.assertTrue(checkOutPage.additionInfoForWireTransfer.isDisplayed());

        ExtentReportUtils.pass("Vendor sees the addition information, when clicks Wire/Transfer Button");


        //Click Place Order and Verify order
        JSUtils.JSclickWithTimeout(checkOutPage.placeOrderButton);

        ExtentReportUtils.pass("Vendor clicks place order");

        Assert.assertTrue(checkOutPage.verificationOrderMessage.getText().contains("Thank you. Your order has been received."));
        WaitUtils.waitFor(1);

        ExtentReportUtils.passAndCaptureScreenshot("Vendor sees the order verification message, after clicks place order");


        //Go to order and verify your order
        homePage.signOut.click();
        dashboardPage.orders.click();
        checkOutPage.view.click();
        Assert.assertTrue(checkOutPage.productNameInOrder.getText().contains("Leather shoes × 2"));

        ExtentReportUtils.passAndCaptureScreenshot("Vendor sees the order details in Order");


        //Close driver
        Driver.closeDriver();

        ExtentReportUtils.pass("Driver is closed");
        ExtentReportUtils.flush();

    }
}
