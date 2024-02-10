package techproed.tests.US_20;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import techproed.pages.*;
import techproed.utilities.*;

public class TC_01 {

    HomePage homepage = new HomePage();
    ProductPage productPage = new ProductPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    ShoppingCartPage shoppingcartpage = new ShoppingCartPage();
    CheckOutPage checkoutPage = new CheckOutPage();
    CouponPage couponpage = new CouponPage();
    ExtentReportUtils extentreportutils = new ExtentReportUtils();
    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));

        WaitUtils.waitFor(5);
        JSUtils.JSclickWithTimeout(homepage.singIn1);
        homepage.username.sendKeys(ConfigReader.getProperty("email"));
        homepage.password.sendKeys(ConfigReader.getProperty("password"));
        JSUtils.JSclickWithTimeout(homepage.signInButton);
        WaitUtils.waitFor(5);
    }

    @Test
    public void vendorBuyProductTest1() {



        homepage.searchBox.sendKeys(ConfigReader.getProperty("product0"), Keys.ENTER);

        WebElement womenBag= Driver.getDriver().findElement(By.linkText("Women’s leather white hangbag"));
        JSUtils.JSclickWithTimeout(womenBag);

        WaitUtils.waitFor(1);

        for (int i = 1; i < 4; i++) {
            productPage.plusButton.click();
        }
        productPage.addToCartButton2.click();
        WaitUtils.waitFor(1);

        homepage.cart.click();
        WaitUtils.waitFor(2);

        WebElement checkOut = Driver.getDriver().findElement(By.xpath("//a[@class='button checkout wc-forward']"));
        JSUtils.JSclickWithTimeout(checkOut);


        checkOutPage.enterYourCode.click();
        WaitUtils.waitFor(1);
        checkOutPage.couponCodeField.click();
        checkOutPage.couponCodeField.sendKeys(ConfigReader.getProperty("code"));
        WaitUtils.waitFor(1);
        checkOutPage.applyCouponButton.click();
        WaitUtils.waitFor(3);

        ExtentReportUtils.createTestReport("vendorBuyProductTest1", "fail");
        ExtentReportUtils.passAndCaptureScreenshot("Sorry, this coupon is not applicable to selected products");
        ExtentReportUtils.flush();

       // Driver.closeDriver();


    }

}