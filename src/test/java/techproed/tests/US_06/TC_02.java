package techproed.tests.US_06;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.ProductPage;
import techproed.utilities.*;

public class TC_02 {

    /*
    Pre-condition:
    User has signed in.

    Click in the search box, enter random special characters and click enter
    Verify message 'No products were found matching your selection.' appears
     */

    HomePage homePage = new HomePage();

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
    public void US06_TC02(){

//    Click in the search box, enter random special characters and click enter
    ExtentReportUtils.pass("User enters random special characters in search box on homepage and clicks enter");
    homePage.searchBox.click();
    homePage.searchBox.clear();
    homePage.searchBox.sendKeys(ConfigReader.getProperty("random1"), Keys.ENTER);
    WaitUtils.waitFor(2);

//    Verify message 'No products were found matching your selection.' appears
    String successMessage = homePage.noProductsFoundAlert.getText();
    System.out.println(successMessage);
    Assert.assertTrue(successMessage.contains("No products were found"));
    ExtentReportUtils.passAndCaptureScreenshot("No products found message successfully displayed");
    ExtentReportUtils.flush();
    }

    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }
}