package techproed.tests.US_03;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import techproed.pages.Bill_ShipAddressPage;
import techproed.pages.DashboardPage;
import techproed.pages.HomePage;
import techproed.utilities.ActionUtils;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;

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
    public void US03_TC02() {
//    From the country drop down list click on a valid country
        WebElement countryDropDown = bill_shipAddressPage.billCountryDD;
        Select selectCountry = new Select(countryDropDown);
        selectCountry.selectByVisibleText("United Kingdom (UK)");
//    Leave street address line 1 empty
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
//    Verify message 'Street address is a required field.' appears
        String successMsg = bill_shipAddressPage.streetAddRequiredMsg.getText();
        System.out.println("successMsg = " + successMsg);
        Assert.assertEquals(successMsg, "Street address is a required field.");
    }
}