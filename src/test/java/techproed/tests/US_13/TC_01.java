package techproed.tests.US_13;

import org.apache.logging.log4j.message.ReusableMessage;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
import org.bouncycastle.asn1.x500.style.RFC4519Style;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.Bill_ShipAddressPage;
import techproed.pages.DashboardPage;
import techproed.pages.HomePage;
import techproed.pages.VendorPage;
import techproed.utilities.*;


public class TC_01 {


    // US_13 : "Vendor should be able to add Shipping Address. (My Account > Addresses > Shipping Address)"

    // Acceptance Criteria : Vendor should enter First name, Last name, Country/Region, Street address, Town / City, State, ZIP Code.

    // TC_01 : Vendor should enter First name, Last name, Country/Region, Street address, Town / City, State, ZIP Code.
     /*
    Given User should navigate to Allover Commerce url
    When Click on sign in button
    And Enter username into username/email box
    And Enter password into password box
    And Click on sign in button
    And Click on user icon to navigate My Account page
    And Click on Addresses button
    And Click add button under the Shipping Address
    And Enter firstname into First name box
    And Enter lastname into Last name box
    And Enter Country/Region into County/Region box
    And Enter a Street address into Street address box
    And Enter a Town/City into Town/City box
    And Enter a state into State box
    And Enter a Zip Code into ZipCode box
    And Click on save address button
    Then Verify data has been entered in all required blank fields
     */

    HomePage homePage = new HomePage();
    DashboardPage loginPage = new DashboardPage();
    VendorPage vendorMyAccountPage = new VendorPage();
    private CharSequence shipFirstNam;
    private CharSequence shipLastName;


    @DataProvider
    public Object[][] vendorPage() {
        //  TEST DATA
        Object[][] vendorCredentials = {

                {"Vendor", "Account", "United States", " Town/City: Buffalo", "Zip Code: 14201"},
        };
        return vendorCredentials;
    }


    //Given User should navigate to Allover Commerce url
    @Test
    public void setUp() {
        // Navigate to the Allover Commerce URL
        Driver.getDriver().get("https://www.allovercommerce.com");
        WaitUtils.waitForPageToLoad(30);



            //    Click on sign in button
            HomePage.signInButton.click();

            //    Enter username into username/email box
            HomePage.username.sendKeys(ConfigReader.getProperty("oz401@yahoo.com"));

            //    Enter password into password box
            HomePage.password.sendKeys(ConfigReader.getProperty("vendoraccount123"));

            //    Click on sign in button
            HomePage.signInButton.click();

            //    Click on user icon to navigate My Account page
            JSUtils.JSclickWithTimeout(HomePage.signOutButton);

            //    Click on Addresses button
            JSUtils.JSclickWithTimeout(DashboardPage.addresses);

            //    Click add button under the Shipping Address
            JSUtils.JSclickWithTimeout(Bill_ShipAddressPage.editBillingAdd);

            //    Enter firstname into First name box
            Bill_ShipAddressPage.billFirstName.clear();
            Bill_ShipAddressPage.billFirstName.sendKeys(shipFirstNam);

            //    Enter lastname into Last name box
            Bill_ShipAddressPage.billLastName.clear();
            Bill_ShipAddressPage.billLastName.sendKeys(shipLastName);

            //    Enter Country/Region into County/Region box
            Select selectCountry = new Select(Bill_ShipAddressPage.shipCountryDD);
            selectCountry.selectByVisibleText("Canada");

            //    Enter a Street address into Street address box
            Bill_ShipAddressPage.clear();
            Alert address;
        String shipAddressLine1 = "shipAddressLine1";
        Bill_ShipAddressPage.shipAddressLine1Input.sendKeys(shipAddressLine1);

            //    Enter a Town/City into Town/City box
            Bill_ShipAddressPage.clear();
           Object townCity = null;
           Bill_ShipAddressPage.townCityInput.notify(townCity);

            //    Enter a state into State box
            WebElement shipStateProvinceDD = null;
            Select selectState = new Select(shipStateProvinceDD);
            selectState.selectByVisibleText("Ontario");

            //    Enter a Zip Code into ZipCode box
            Bill_ShipAddressPage.clear();
            Bill_ShipAddressPage shipZipPostCode = null;
            Bill_ShipAddressPage.shipZipPostCodeInput.clear(shipZipPostCode);

            //    Click on save address button
            WaitUtils.waitForPageToLoad(20);
            JSUtils.JSclickWithTimeout(Bill_ShipAddressPage.saveAddressButton);

            //    Then Verify data has been entered in all required blank fields
            for (WebElement eachShippingAddressTableElement : Bill_ShipAddressPage.allShippingAddressTableElements) {
                WaitUtils.waitForPageToLoad(20);
                Assert.assertTrue(eachShippingAddressTableElement.isDisplayed());
            }
        }
        @AfterMethod
        public void tearDown () {
            Driver.closeDriver();
        }


    }











