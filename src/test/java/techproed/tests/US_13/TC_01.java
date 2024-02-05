package techproed.tests.US_13;

import org.openqa.selenium.By;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import techproed.pages.DashboardPage;
import techproed.pages.HomePage;
import techproed.pages.VendorPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.WaitUtils;



public class TC_01 {
    private Object JSUtils;

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


    public Object[][] vendorData(){
        //  TEST DATA
        Object [][] vendorCredentials = {

                {"Country/Region: United States Town/City: Buffalo, Zip Code: 14201"}

        };
        return vendorCredentials;
    }

    HomePage homePage = new HomePage();
    DashboardPage loginPage = new DashboardPage();
    VendorPage vendorMyAccountPage = new VendorPage();

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get("https://allovercommerce.com/");
        WaitUtils.waitForPageToLoad(30);


        //    Click on sign in button
        HomePage.singUpButton.click();

        //    Enter username into username/email box
        HomePage.username.sendKeys(ConfigReader.getProperty("Username: Vendor, Email Address: oz401@yahoo.com"));


        //    Enter password into password box
        HomePage.password.sendKeys(techproed.tests.HomePage.signInButton.click();




            //    Click on user icon to navigate My Account page
            JSUtils.clickElementByJS(HomePage.signOutButton);

            //    Click on Addresses button
            JSUtils.clickElementByJS(vendorMyAccountPageUS_12.addressesOption);

            //    Click add button under the Shipping Address
            JSUtils.clickElementByJS(vendorMyAccountPageUS_12.addShippingAddressButton);

            //    Enter firstname into First name box
            VendorPage.vendorShippingFirstNameInput.clear();
            vendorMyAccountPage.vendorShippingFirstNameInput.sendKeys(firstname);

            //    Enter lastname into Last name box
            vendorMyAccountPageUS_12.vendorShippingLastNameInput.clear();
            vendorMyAccountPageUS_12.vendorShippingLastNameInput.sendKeys(lastname);

            //    Enter Country/Region into County/Region box
            Select selectCountry = new Select(vendorMyAccountPageUS_12.shippingCountryDropdown);
            selectCountry.selectByVisibleText("Canada");

            //    Enter a Street address into Street address box
            vendorMyAccountPageUS_12.shippingStreetInput.clear();
            vendorMyAccountPageUS_12.shippingStreetInput.sendKeys(street);
    }
        }

}

