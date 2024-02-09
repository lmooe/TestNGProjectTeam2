package techproed.tests.US_03;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import techproed.pages.Bill_ShipAddressPage;
import techproed.pages.DashboardPage;
import techproed.pages.HomePage;
import techproed.utilities.*;

public class TC_02 {

    /*
    Pre-condition:
    User has just registered.
    User has already entered first name and last name under Account Details.
    User is on Billing address page (Home>My Account> Addresses>Billing address).

    From the country drop down list click on a valid country
    Leave street address line 1 empty
    Click on street address line 2 and enter a valid street address for the chosen country
    Click on town and enter valid town/city name
    Click on Postcode and enter a valid postcode
    Click on Phone and enter a valid phone number
    Click on Save Address button
    Verify message 'Street address line 1 is a required field.' appears
     */

    @BeforeMethod
    public void setUp() {
            Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
        }

    @Test
    public void US03_TC02() {
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
        BrowserUtils.clickWithTimeOut(homePage.register, 1);
        BrowserUtils.sendKeysWithTimeout(homePage.regUsername, (faker.name().username()),1);
        BrowserUtils.sendKeysWithTimeout(homePage.regEmail, (faker.internet().emailAddress()), 1);
        BrowserUtils.sendKeysWithTimeout(homePage.regPassword, (faker.internet().password()), 1);
        BrowserUtils.clickWithTimeOut(homePage.agreePolicy,1);
        BrowserUtils.clickWithTimeOut(homePage.singUp, 1);

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


//    From the country drop down list click on a valid country
        ExtentReportUtils.pass("User selects valid country");
        WebElement countryDropDown = bill_shipAddressPage.billCountryDDs;
        Select selectCountry = new Select(countryDropDown);
        selectCountry.selectByVisibleText("United Kingdom (UK)");

//    Leave street address line 1 empty
        ExtentReportUtils.pass("User leaves street address line 1 empty");

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

//    Verify message 'Street address is a required field.' appears
        String successMsg = bill_shipAddressPage.streetAddRequiredMsg.getText();
        System.out.println("successMsg = " + successMsg);
        Assert.assertEquals(successMsg, "Street address is a required field.");
        ExtentReportUtils.passAndCaptureScreenshot("Billing address not added. Error message successfully displayed.");
        ExtentReportUtils.flush();
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
