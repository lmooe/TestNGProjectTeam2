package techproed.tests.US_19;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import techproed.pages.*;
import techproed.utilities.*;

import java.io.IOException;

import static techproed.utilities.MediaUtils.takeScreenshotOfTheEntirePageAsString;

public class TC_01 {

    HomePage homepage = new HomePage();
    ProductPage productPage = new ProductPage();
    DashboardPage dashboardPage = new DashboardPage();
    ShoppingCartPage shoppingcartpage = new ShoppingCartPage();
    CheckOutPage checkoutPage = new CheckOutPage();
    CouponPage couponpage = new CouponPage();
    ExtentReportUtils extentreportutils = new ExtentReportUtils();


      @Test
       public void test01() {

          Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
          homepage.singIn1.click();
          homepage.username.sendKeys(ConfigReader.getProperty("email"));
          homepage.password.sendKeys(ConfigReader.getProperty("password"));
          homepage.signInButton.click();
          WaitUtils.waitFor(2);


          homepage.searchBox.sendKeys(ConfigReader.getProperty("product0"), Keys.ENTER);
          WebElement womenBag = Driver.getDriver().findElement(By.linkText("Women’s leather white hangbag"));
          JSUtils.JSclickWithTimeout(womenBag);

          WaitUtils.waitFor(1);

          for (int i = 1; i < 4; i++) {
              productPage.plusButton.click();
          }
          productPage.addToCartButton2.click();
          WaitUtils.waitFor(1);

          homepage.cart.click();
          WaitUtils.waitFor(1);

          WebElement checkOut = Driver.getDriver().findElement(By.xpath("//a[@class='button checkout wc-forward']"));
          JSUtils.JSclickWithTimeout(checkOut);

          checkoutPage.enterYourCode.click();
          WaitUtils.waitFor(1);
          checkoutPage.couponCodeField.click();
          checkoutPage.couponCodeField.sendKeys(ConfigReader.getProperty("code"));
          WaitUtils.waitFor(1);
          checkoutPage.applyCouponButton.click();
          WaitUtils.waitFor(3);

          ExtentReportUtils.createTestReport("test01", "fail");
          ExtentReportUtils.passAndCaptureScreenshot("Sorry, this coupon is not applicable to selected products");
          ExtentReportUtils.flush();

          Driver.closeDriver();

      }

        }






