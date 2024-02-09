package techproed.tests.US_05;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.DashboardPage;
import techproed.pages.Bill_ShipAddressPage;
import techproed.utilities.*;

public class TC {

    HomePage homePage = new HomePage();
    DashboardPage dashboardPage = new DashboardPage();
    Bill_ShipAddressPage addressPage = new Bill_ShipAddressPage();

    @BeforeTest
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
        WaitUtils.waitForPageToLoad(20);
    }

    @AfterTest
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void changeAccountDetailsTest() {
        // Perform login actions
        JSUtils.JSclickWithTimeout(homePage.singIn1);
        homePage.username.sendKeys(ConfigReader.getProperty("US11username"));
        homePage.password.sendKeys(ConfigReader.getProperty("US11password"));
        JSUtils.JSclickWithTimeout(homePage.signInButton);

        WaitUtils.waitForVisibility(homePage.MyAccountOnFooter, 20);
        ActionUtils.actionsScrollDown();
        ActionUtils.actionsScrollDown();
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", homePage.MyAccountOnFooter);

        // Navigate to Account Details
        JSUtils.JSclickWithTimeout(dashboardPage.accountDetails);

        // Verify Account Details page is displayed
        assertPageURL("Account Details", "https://allovercommerce.com/my-account-2/edit-account/");

        // Change First Name, Last Name, Display Name, and Email Address
        addressPage.accFirstName.clear();
        addressPage.accFirstName.sendKeys("Hasan");
        addressPage.accLastName.clear();
        addressPage.accLastName.sendKeys("Yekeler");
        addressPage.ADN.clear();
        addressPage.ADN.sendKeys("Hasan Yekeler");
        addressPage.AEA.clear();
        addressPage.AEA.sendKeys("hby@example.com");

        ActionUtils.actionsScrollDown();

        // Fill in the Biography Section
        BrowserUtils.frameSwitchTo("//iframe[@id='user_description_ifr']");

//        addressPage.biog.clear();
        addressPage.biog.sendKeys("Hello, this is Biography section.");

        Driver.getDriver().switchTo().defaultContent();

        // Change Password
        addressPage.curpass.sendKeys(ConfigReader.getProperty("US11password"));
        addressPage.newpass.sendKeys("123456abc");
        addressPage.conpass.sendKeys("123456abc");

        // Save Changes
        JSUtils.JSclickWithTimeout(addressPage.accSaveButton);

        WaitUtils.waitFor(10);

        System.out.println("Code works perfectly fine , but");
        System.out.println("Failed on purpose to not affect US11 and US12");
    }
    private void assertPageURL(String pageName, String expectedURL) {
        String actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, pageName + " page is selected");
    }
}