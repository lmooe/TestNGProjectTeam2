package techproed.tests.US_13;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import techproed.pages.Bill_ShipAddressPage;
import techproed.pages.DashboardPage;
import techproed.pages.HomePage;
import techproed.utilities.ActionUtils;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.WaitUtils;

import java.time.Duration;

public class TC_02 {

    HomePage homePage = new HomePage();
    DashboardPage dashboardPage = new DashboardPage();
    Bill_ShipAddressPage billShipAddressPage = new Bill_ShipAddressPage();

    @BeforeTest
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
        WaitUtils.waitForPageToLoad(20);




        public void bill_Ship_Address_Test () {


            homePage.signIn.click();
            homePage.username.sendKeys(ConfigReader.getProperty("Vendor"));
            homePage.password.sendKeys(ConfigReader.getProperty("VendorAccount"));
            homePage.signInButton.click();

            WaitUtils.waitForVisibility(homePage.MyAccountOnFooter, 10);
            ActionUtils.actionsScrollDown();
            ActionUtils.actionsScrollDown();
            JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
            executor.executeScript("arguments[0].click();", homePage.MyAccountOnFooter);


            dashboardPage.addresses.click();
            WaitUtils.waitForVisibility(dashboardPage.editShippingAddress, 10);
            dashboardPage.editShippingAddress.click();


            Assert.assertTrue(billShipAddressPage.shipFirstName.getAttribute("value").equals(ConfigReader.getProperty("Vendor")),
                    "First name must entered.");

            Assert.assertTrue(billShipAddressPage.shipLastName.getAttribute("value").equals(ConfigReader.getProperty("Account")),
                    "Last name must entered.");

            Assert.assertTrue(billShipAddressPage.shipCompOptional.getAttribute("value").equals(ConfigReader.getProperty("Company name optional")),
                    " Company name optional");

            Assert.assertTrue(billShipAddressPage.shipCountryDD.getAttribute("value").equals(ConfigReader.getProperty("United States")),
                    "Country/Region must be entered.");

            Assert.assertTrue(billShipAddressPage.shipAddressLine1.getAttribute("value").equals(ConfigReader.getProperty("Clinton Street")),
                    "First Address line must be entered.");

            Assert.assertTrue(billShipAddressPage.shipAddressLine2.getAttribute("value").equals(ConfigReader.getProperty("Buffalo")),
                    "Second Address line must be entered.");

            Assert.assertTrue(billShipAddressPage.shipZipPostCode.getAttribute("value").equals(ConfigReader.getProperty("14201")),
                    "State and zip cod must be entered.");

            Assert.assertTrue(billShipAddressPage.shipTownCity.getAttribute("value").equals(ConfigReader.getProperty("New York")),
                    "Town/City must be entered.");


            ActionUtils.actionsScrollDown();

            billShipAddressPage.billStateProvinceDD.click();
            WebElement ontarioOption = Driver.getDriver().findElement(By.xpath("//span[text()='Ontario']"));
            ontarioOption.click();


            String actualFirstName = billShipAddressPage.shipFirstName.getAttribute("value");
            Assert.assertEquals(actualFirstName,ConfigReader.getProperty("Vendor"));

            String actualLastName = billShipAddressPage.shipLastName.getAttribute("value");
            Assert.assertEquals(actualLastName,ConfigReader.getProperty("Account"));

            String actualCompanyName = billShipAddressPage.shipCompOptional.getAttribute("value");
            Assert.assertEquals(actualCompanyName,ConfigReader.getProperty("Optional"));

            String actualCountryAndRegion = billShipAddressPage.shipCountryDD.getAttribute("value");
            Assert.assertEquals(actualCountryAndRegion,ConfigReader.getProperty("United State"));

            String actualShipAddressLine1 = billShipAddressPage.shipAddressLine1.getAttribute("value");
            Assert.assertEquals(actualFirstName,ConfigReader.getProperty("Clinton"));

            String actualTownAndCity = billShipAddressPage.shipTownCity.getAttribute("value");
            Assert.assertEquals(actualTownAndCity,ConfigReader.getProperty("Buffalo"));

            String actualStateAndZip = billShipAddressPage.shipZipPostCode.getAttribute("value");
            Assert.assertEquals(actualFirstName,ConfigReader.getProperty("14201"));

            String actual = billShipAddressPage.shipFirstName.getAttribute("value");
            Assert.assertEquals(actualFirstName,ConfigReader.getProperty("Vendor"));



            ActionUtils.actionsScrollDown();
            billShipAddressPage.shipSaveAddressButton.submit();


            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
            WebElement successMessage = billShipAddressPage.addressChangedMsg;
            Assert.assertEquals(successMessage.getText(), "Address changed successfully.");

            System.out.println("Address changed successfully.");
        }
    }

}

