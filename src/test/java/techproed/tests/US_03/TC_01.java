package techproed.tests.US_03;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.pages.Bill_ShipAddressPage;
import techproed.pages.DashboardPage;
import techproed.pages.HomePage;
import techproed.utilities.*;

import javax.swing.*;

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
    */

    HomePage homePage = new HomePage();
    Bill_ShipAddressPage bill_shipAddressPage = new Bill_ShipAddressPage();
    Faker faker = new Faker();
    DashboardPage dashboardPage = new DashboardPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @BeforeMethod
    public void setUp() {
//    User is on www.allovercommerce.com
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
//    User has just registered.
        homePage.register.click();
        homePage.regUsername.sendKeys(faker.name().username());
        homePage.regEmail.sendKeys(faker.internet().emailAddress());
        homePage.regPassword.sendKeys(faker.internet().password());
        homePage.agreePolicy.click();
        homePage.singUp.click();
        JSUtils.JSclickWithTimeout(homePage.MyAccountOnFooter);
        dashboardPage.accountDetails.click();
        dashboardPage.accDetailsFirstName.sendKeys(faker.name().firstName());
        dashboardPage.accDetailsLastName.sendKeys(faker.name().lastName());
        dashboardPage.confirmPassButton.sendKeys(Keys.ENTER);
        dashboardPage.addresses.click();
        bill_shipAddressPage.editBillingAdd.click();
    }

    @Test
    public void US06_TC01() {
//    Verify first name has been populated.
        boolean firstName = bill_shipAddressPage.billFirstName.isDisplayed();
        System.out.println("firstName = " + firstName);
        Assert.assertTrue(firstName);
//    Verify last name has been populated.
        boolean lastName = bill_shipAddressPage.billLastName.isDisplayed();
        System.out.println("lastName = " + lastName);
        Assert.assertTrue(lastName);
//    Verify email address has been populated.
        boolean email = bill_shipAddressPage.billEmail.isDisplayed();
        System.out.println("email = " + email);
        Assert.assertTrue(email);
//    From the country drop down list click on a valid country
        WebElement countryDropDown = bill_shipAddressPage.billCountryDD;
        Select selectCountry = new Select(countryDropDown);
        selectCountry.selectByVisibleText("United Kingdom (UK)");
//    Click on street address line 1 and enter a valid street address for the chosen country
        bill_shipAddressPage.billAddressLine1.sendKeys(ConfigReader.getProperty("streetaddress1"));
//    Click on street address line 2 and enter a valid street address for the chosen country
        bill_shipAddressPage.billAddressLine2.sendKeys(ConfigReader.getProperty("streetaddress2"));
//    Click on town/city and enter valid town name
        bill_shipAddressPage.billTownCity.sendKeys(ConfigReader.getProperty("town"));
//    Click on county and enter valid county name
        bill_shipAddressPage.billCounty.sendKeys(ConfigReader.getProperty("county"));
//    Click on Postcode and enter a valid postcode
        bill_shipAddressPage.billZipPostCode.sendKeys(ConfigReader.getProperty("postcode"));
//    Click on Phone and enter a valid phone number
        bill_shipAddressPage.billPhoneNumb.sendKeys(ConfigReader.getProperty("phone"));
//    Click on Save Address button
        ActionUtils.actionsDoubleClick(bill_shipAddressPage.billSaveAddressButton);
//    Verify message 'Address changed successfully.' appears
        String successMsg = bill_shipAddressPage.addressChangedMsg.getText();
        System.out.println("successMsg = " + successMsg);
        Assert.assertEquals(successMsg, "Address changed successfully.");
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

    }

