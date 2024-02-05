package techproed.tests.US_03;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.pages.Bill_ShipAddressPage;
import techproed.pages.DashboardPage;
import techproed.pages.HomePage;
import techproed.utilities.*;

public class TC_01 {

    /*
    Pre-condition:
    User has just registered.
    User has already entered first name and last name under Account Details.
    User is on Billing address page (Home>My Account> Addresses>Billing address).

    Verify first name has been populated.
    Verify last name has been populated.
    Verify email address has been populated.
    From the country drop down list click on a valid country
    Click on street address line 1 and enter a valid street address for the chosen country
    Click on street address line 2 and enter a valid street address for the chosen country
    Click on town/city and enter valid town name
    Click on county and enter valid county name
    Click on Postcode and enter a valid postcode
    Click on Phone and enter a valid phone number
    Click on Save Address button
    Verify message 'Address changed successfully.' appears
    Verify billing address has been added
    */

    HomePage homePage = new HomePage();
    Bill_ShipAddressPage billShipAddressPage = new Bill_ShipAddressPage();
    Faker faker = new Faker();
    DashboardPage dashboardPage = new DashboardPage();
    SoftAssert softAssert = new SoftAssert();
    JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();

    @BeforeMethod
    public void setUp(){
//    User is on www.allovercommerce.com
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
//    User has just registered.
        homePage.register.click();
        homePage.regUsername.click();
        homePage.regUsername.clear();
        homePage.regUsername.sendKeys(faker.name().username());
        homePage.regEmail.click();
        homePage.regEmail.clear();
        homePage.regEmail.sendKeys(faker.internet().emailAddress());
        homePage.regPassword.click();
        homePage.regPassword.clear();
        homePage.regPassword.sendKeys(faker.internet().password());
        homePage.agreePolicy.click();
        homePage.singUp.click();
        JSUtils.JSclickWithTimeout(homePage.MyAccountOnFooter);
        JSUtils.JSclickWithTimeout(dashboardPage.accountDetails);
    }

      @Test
    public void US06_TC01() {
//    Verify first name has been populated.
//        WaitUtils.waitFor(2);
//        String firstName = JSUtils.JSgetValueBy(dashboardPage.accDetailsFirstName);
//        Assert.assertNotNull(firstName, "The first name is not null");
//          Assert.assertFalse(firstName.isEmpty(), "The first name is not empty");
//
//
//
//
//
////    Verify last name has been populated.
////    Verify email address has been populated.
//          String email = JSUtils.JSgetValueBy(dashboardPage.accDetailsEmail.getText());
//          WaitUtils.waitFor(2);
//          Assert.assertTrue(email.contains("@"));
//    From the country drop down list click on a valid country
          //        billShipAddressPage.billCountryDD.click();
//    Click on street address line 1 and enter a valid street address for the chosen country
//    Click on street address line 2 and enter a valid street address for the chosen country
//    Click on town/city and enter valid town name
//    Click on county and enter valid county name
//    Click on Postcode and enter a valid postcode
//    Click on Phone and enter a valid phone number
//    Click on Save Address button
//    Verify message 'Address changed successfully.' appears
//    Verify billing address has been added


      }
}
