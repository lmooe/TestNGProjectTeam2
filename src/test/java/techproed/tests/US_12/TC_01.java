package techproed.tests.US_12;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import techproed.pages.Bill_ShipAddressPage;
import techproed.pages.HomePage;
import techproed.pages.DashboardPage;
import techproed.utilities.*;

public class TC_01 {

//    HomePage homePage = new HomePage();
//    DashboardPage dashboardPage = new DashboardPage();
//    Bill_ShipAddressPage billShipAddressPage = new Bill_ShipAddressPage();

    @BeforeTest
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
        WaitUtils.waitForPageToLoad(20);
    }

//    @AfterTest
//    public void tearDown() {
//        Driver.closeDriver();
//    }

    @Test
    public void vendorAddBillingAddressTest() {
        HomePage homePage = new HomePage();
        DashboardPage dashboardPage = new DashboardPage();
        Bill_ShipAddressPage billShipAddressPage = new Bill_ShipAddressPage();
        // Perform login actions
        WaitUtils.waitFor(5);
        JSUtils.JSclickWithTimeout(homePage.singIn1);
        WaitUtils.waitFor(5);
        homePage.username.sendKeys(ConfigReader.getProperty("US11username"));
        homePage.password.sendKeys(ConfigReader.getProperty("US11password"));
        JSUtils.JSclickWithTimeout(homePage.signInButton);

        WaitUtils.waitForVisibility(homePage.MyAccountOnFooter, 20);
        ActionUtils.actionsScrollDown();
        ActionUtils.actionsScrollDown();
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", homePage.MyAccountOnFooter);

        // Navigate to the Address page and click edit billing address
        JSUtils.JSclickWithTimeout(dashboardPage.addresses);
        WaitUtils.waitForVisibility(dashboardPage.editBillingAddress, 20);
        JSUtils.JSclickWithTimeout(dashboardPage.editBillingAddress);

        // Assert that the billing address is already filled
        Assert.assertTrue(billShipAddressPage.billFirstName.getAttribute("value").equals(ConfigReader.getProperty("US12firstname")),
                "First name does not match.");

        Assert.assertTrue(billShipAddressPage.billLastName.getAttribute("value").equals(ConfigReader.getProperty("US12lastname")),
                "Last name does not match.");

        Assert.assertTrue(billShipAddressPage.billEmail.getAttribute("value").equals(ConfigReader.getProperty("US12email")),
                "Email address does not match.");
        System.out.println("Success!!! US_12 TC_01");

        Driver.closeDriver();
    }
}