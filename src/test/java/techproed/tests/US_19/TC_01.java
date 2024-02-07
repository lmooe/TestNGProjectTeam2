package techproed.tests.US_19;

import com.aventstack.extentreports.ExtentReports;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import techproed.pages.CheckOutPage;
import techproed.pages.CouponPage;
import techproed.pages.HomePage;
import techproed.pages.ShoppingCartPage;
import techproed.utilities.*;

public class TC_01{

    HomePage homepage = new HomePage();

    ShoppingCartPage shoppingcartpage = new ShoppingCartPage();
    CheckOutPage checkoutPage = new CheckOutPage();
    CouponPage couponpage =new CouponPage();
    ExtentReportUtils extentreportutils =new ExtentReportUtils();

       @BeforeTest
       public void setUp() {

           Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));

           // Driver.getDriver().get("https://allovercommerce.com/");
            // WaitUtils.waitForPageToLoad(2);
            //ExtentReportUtils.pass("User is on Allover Commerce Homepage");
           }

           @Test
           public void test01 () {

               // Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
               // WaitUtils.waitForPageToLoad(2);
               //ExtentReportUtils.passAndCaptureScreenshot("User is on Allover Commerce Homepage");
               //}


               homepage.singIn1.click();
               homepage.username.sendKeys(ConfigReader.getProperty("email"));
               homepage.password.sendKeys(ConfigReader.getProperty("password"));
               homepage.signInButton.click();
               WaitUtils.waitForPageToLoad(2);


               WebElement search = Driver.getDriver().findElement(By.xpath("(//input[@name='s'])[1]"));
               search.click();
               WebElement product = Driver.getDriver().findElement(By.xpath("//a//img[@class='wp-post-image']"));
              // product.click();




               // homepage.searchBox.click();
           }


       }



