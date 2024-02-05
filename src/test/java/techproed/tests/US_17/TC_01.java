package techproed.tests.US_17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import techproed.pages.CheckOutPage;
import techproed.pages.CouponPage;
import techproed.pages.HomePage;
import techproed.pages.ProductPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;
import techproed.utilities.WaitUtils;

public class TC_01 {

    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    CheckOutPage checkOutPage = new CheckOutPage();

    @BeforeMethod
    public void deleteCart(){
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));

        //Sign in
        JSUtils.JSclickWithTimeout(homePage.singIn1);
        homePage.username.sendKeys(ConfigReader.getProperty("email"));
        homePage.password.sendKeys(ConfigReader.getProperty("password"));
        homePage.signInButton.click();
        WaitUtils.waitFor(2);

        //Delete cart, if it is not empty
        homePage.cart.click();
        WaitUtils.waitFor(2);
        if(Integer.parseInt(checkOutPage.productCounter.getText())>0){
            checkOutPage.viewChartButton.click();
            checkOutPage.clearChart.click();
        }
    }


    @Test
    public void vendorBuyProductTest(){


        //Search and add product
        homePage.searchBox.sendKeys("Shoe", Keys.ENTER);
        WebElement leatherShoe = Driver.getDriver().findElement(By.linkText("Leather shoes"));
        JSUtils.JSclickWithTimeout(leatherShoe);
        WaitUtils.waitFor(2);

        productPage.plusButton.click();
        WaitUtils.waitFor(2);

        //ASK========>>>>>>> value is different for each product
        WebElement addToChartButton = Driver.getDriver().findElement(By.xpath("//button[@name='add-to-cart']"));
        addToChartButton.click();
        WaitUtils.waitFor(1);


        //Go to cart pop-up and click checkout button
        homePage.cart.click();
        WaitUtils.waitFor(2);
        checkOutPage.checkoutButton.click();


        //verify the products' name and price
        Assert.assertTrue(checkOutPage.productNameAndNumber.getText().contains("Leather shoes  × 2"));
        Assert.assertTrue(checkOutPage.productPrice.getText().contains("$200.00"));


        //Click Wire/Transfer Button and verify the addition information
        JSUtils.JSclickWithTimeout(checkOutPage.wireTransferEFT);
        Assert.assertTrue(checkOutPage.additionInfoForWireTransfer.isDisplayed());


        //Click Place Order and Verify order
        JSUtils.JSclickWithTimeout(checkOutPage.placeOrderButton);
        Assert.assertTrue(checkOutPage.verificationOrderMessage.getText().contains("Thank you. Your order has been received."));
        WaitUtils.waitFor(1);


        //Close driver
        Driver.closeDriver();

    }
}
