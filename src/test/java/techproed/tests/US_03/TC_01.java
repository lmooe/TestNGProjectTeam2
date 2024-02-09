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

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
    }

    @Test
    public void US03_TC01() {
        HomePage homePage = new HomePage();
        Bill_ShipAddressPage bill_shipAddressPage = new Bill_ShipAddressPage();
        Faker faker = new Faker();
        DashboardPage dashboardPage = new DashboardPage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        ExtentReportUtils.createTestReport("End-to-End Test Report", "Add Billing Address Function");

//    Pre-condition:
//    User is on www.allovercommerce.com
//    User has just registered.
        ExtentReportUtils.info("Pre-condition: User is on https://allovercommerce.com/ and signs up");
        homePage.registerButton.click();
        homePage.regUsername.sendKeys(faker.name().username());
        homePage.regEmail.sendKeys(faker.internet().emailAddress());
        homePage.regPassword.sendKeys(faker.internet().password());
        homePage.agreePolicy.click();
        homePage.singUp.click();

        ExtentReportUtils.info("Pre-condition: User clicks Account button on homepage footer");
        JSUtils.JSclickWithTimeout(homePage.MyAccountOnFooter);

        ExtentReportUtils.info("Pre-condition: User clicks Account Details on dashboard");
        dashboardPage.accountDetails.click();

        ExtentReportUtils.info("Pre-condition: User enters first name and last name");
        dashboardPage.accDetailsFirstName.sendKeys(faker.name().firstName());
        dashboardPage.accDetailsLastName.sendKeys(faker.name().lastName());

        ExtentReportUtils.info("Pre-condition: User clicks Save Changes button");
        dashboardPage.confirmPassButton.sendKeys(Keys.TAB);
        ActionUtils.actionsHoverOverOnElement(dashboardPage.accDetailsSaveChanges);
        WaitUtils.waitFor(2);
        ActionUtils.actionsDoubleClick(dashboardPage.accDetailsSaveChanges1);
        WaitUtils.waitFor(2);

        ExtentReportUtils.info("Pre-condition: User clicks Add Your Billing Address button and moves to Billing Address page");
        dashboardPage.addresses.click();
        bill_shipAddressPage.editBillingAdd.click();


//    Verify first name has been populated.
        String firstName = bill_shipAddressPage.billFirstName.getAttribute("value");
        System.out.println("firstName = " + firstName);
        Assert.assertTrue(bill_shipAddressPage.billFirstName.isDisplayed());
        ExtentReportUtils.passAndCaptureScreenshot("First name is populated");

//    Verify last name has been populated.
        String lastName = bill_shipAddressPage.billLastName.getAttribute("value");
        System.out.println("lastName = " + lastName);
        Assert.assertTrue(bill_shipAddressPage.billLastName.isDisplayed());
        ExtentReportUtils.passAndCaptureScreenshot("Last name is populated");

//    Verify email address has been populated.
        String email = bill_shipAddressPage.billEmail.getAttribute("value");
        System.out.println("email = " + email);
        Assert.assertTrue(bill_shipAddressPage.billEmail.isDisplayed());
        ExtentReportUtils.passAndCaptureScreenshot("Email is populated");

//    From the country drop down list click on a valid country
        ExtentReportUtils.pass("User selects valid country");
        WebElement countryDropDown = bill_shipAddressPage.billCountryDD;
        Select selectCountry = new Select(countryDropDown);
        selectCountry.selectByVisibleText(ConfigReader.getProperty("uk"));

//    Click on street address line 1 and enter a valid street address for the chosen country
        ExtentReportUtils.pass("User enters valid street address line 1");
        bill_shipAddressPage.billAddressLine1.sendKeys(ConfigReader.getProperty("streetaddress1"));

//    Click on street address line 2 and enter a valid street address for the chosen country
        ExtentReportUtils.pass("User enters valid street address line 2");
        bill_shipAddressPage.billAddressLine2.sendKeys(ConfigReader.getProperty("streetaddress2"));

//    Click on town/city and enter valid town name
        ExtentReportUtils.pass("User enters valid town");
        bill_shipAddressPage.billTownCity.sendKeys(ConfigReader.getProperty("town"));

//    Click on county and enter valid county name
        ExtentReportUtils.pass("User enters valid county");
        bill_shipAddressPage.billCounty.sendKeys(ConfigReader.getProperty("county"));

//    Click on Postcode and enter a valid postcode
        ExtentReportUtils.pass("User enters valid postcode");
        bill_shipAddressPage.billZipPostCode.sendKeys(ConfigReader.getProperty("postcode"));

//    Click on Phone and enter a valid phone number
        ExtentReportUtils.pass("User enters valid phone number");
        bill_shipAddressPage.billPhoneNumb.sendKeys(ConfigReader.getProperty("phone"));

//    Click on Save Address button
        ExtentReportUtils.pass("User clicks Save Address button");
        ActionUtils.actionsDoubleClick(bill_shipAddressPage.billSaveAddressButton);

//    Verify message 'Address changed successfully.' appears
        String successMsg = bill_shipAddressPage.addressChangedMsg.getText();
        System.out.println("successMsg = " + successMsg);
        Assert.assertEquals(successMsg, "Address changed successfully.");
        ExtentReportUtils.passAndCaptureScreenshot("Billing address changed message successfully displayed");
        ExtentReportUtils.flush();
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}

