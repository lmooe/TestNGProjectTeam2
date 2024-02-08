package techproed.tests.US_13;


import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import techproed.pages.Bill_ShipAddressPage;
import techproed.pages.DashboardPage;
import techproed.pages.HomePage;
import techproed.utilities.ActionUtils;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.WaitUtils;


public class TC_01 {

     /*
    Given User should navigate to Allover Commerce url
    When Click on sign in button
    And Enter username into username
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
    DashboardPage dashboardPage = new DashboardPage();
    Bill_ShipAddressPage billShipAddressPage = new Bill_ShipAddressPage();

    @BeforeTest
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
        WaitUtils.waitForPageToLoad(20);
    }

        @Test
        public void vendorShippingAddressTest() throws InterruptedException {


                homePage.singIn1.click();
                homePage.username.sendKeys(ConfigReader.getProperty("email"));
                homePage.password.sendKeys(ConfigReader.getProperty("password"));
                homePage.signInButton.click();

                WaitUtils.waitForVisibility(homePage.MyAccountOnFooter, 10);
                ActionUtils.actionsScrollDown();
                ActionUtils.actionsScrollDown();
                JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
                executor.executeScript("arguments[0].click();", homePage.MyAccountOnFooter);
                Thread.sleep(3000);

                dashboardPage.addresses.click();
                 Thread.sleep(3000);
            ActionUtils.actionsScrollDown();
                dashboardPage.editShippingAddress.click();
                //WaitUtils.waitForVisibility(dashboardPage.editShippingAddress, 10);
            Thread.sleep(3000);
                //dashboardPage.editShippingAddress.click();


                Assert.assertTrue(billShipAddressPage.shipFirstName.getAttribute("email").

                                equals(ConfigReader.getProperty("value")),
                        "First name must entered.");

                Assert.assertTrue(billShipAddressPage.shipLastName.getAttribute("value").

                                equals(ConfigReader.getProperty("Account")),
                        "Last name must entered.");

                Assert.assertTrue(billShipAddressPage.shipCompOptional.getAttribute("value").

                                equals(ConfigReader.getProperty("Company name optional")),
                        " Company name optional");

                Assert.assertTrue(billShipAddressPage.shipCountryDD.getAttribute("value").
                                equals(ConfigReader.getProperty("United States")),
                        "Country/Region must be entered.");

                Assert.assertTrue(billShipAddressPage.shipAddressLine1.getAttribute("value").
                                equals(ConfigReader.getProperty("Clinton Street")),
                        "First Address line must be entered.");

                Assert.assertTrue(billShipAddressPage.shipAddressLine2.getAttribute("value").
                                equals(ConfigReader.getProperty("Buffalo")),
                        "Second Address line must be entered.");

                Assert.assertTrue(billShipAddressPage.shipZipPostCode.getAttribute("value").
                                equals(ConfigReader.getProperty("14201")),
                        "State and zip cod must be entered.");

                Assert.assertTrue(billShipAddressPage.shipTownCity.getAttribute("value").
                                equals(ConfigReader.getProperty("New York")),
                        "Town/City must be entered.");
                System.out.println();


            }
        }







