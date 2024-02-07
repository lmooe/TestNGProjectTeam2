package techproed.tests.US_12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.DashboardPage;
import techproed.pages.Bill_ShipAddressPage;
import techproed.utilities.ActionUtils;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.WaitUtils;

import java.time.Duration;

public class TC_03_and_05_and_07 {

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
    public void addBillingAddressTest() {
        // Perform login actions
        homePage.singIn1.click();
        homePage.username.sendKeys(ConfigReader.getProperty("US11username"));
        homePage.password.sendKeys(ConfigReader.getProperty("US11password"));
        homePage.signInButton.click();

        WaitUtils.waitForVisibility(homePage.MyAccountOnFooter, 20);
        ActionUtils.actionsScrollDown();
        ActionUtils.actionsScrollDown();
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", homePage.MyAccountOnFooter);

        // Navigate to the Addresses page and click on the Add Button under Billing Address
        dashboardPage.addresses.click();
        WaitUtils.waitForVisibility(dashboardPage.editBillingAddress, 20);
        dashboardPage.editBillingAddress.click();


        addressPage.billCountryDD.click();
        //WaitUtils.waitFor(5); //to see the dropdown
        WebElement canadaOption = Driver.getDriver().findElement(By.xpath("//span[text()='Canada']"));
        canadaOption.click();

      //  addressPage.billAddressLine2.click();
       // addressPage.billAddressLine1.sendKeys(ConfigReader.getProperty("US12StreetAddress"));
        String actualStreetAddress = addressPage.billAddressLine1.getAttribute("value");
        Assert.assertEquals(actualStreetAddress, ConfigReader.getProperty("US12StreetAddress"));

       // addressPage.billAddressLine2.sendKeys(ConfigReader.getProperty("US12StreetAddressUnit"));
        String actualStreetAddressUnit = addressPage.billAddressLine2.getAttribute("value");
        Assert.assertEquals(actualStreetAddressUnit, ConfigReader.getProperty("US12StreetAddressUnit"));

        //addressPage.billTownCity.sendKeys(ConfigReader.getProperty("US12City"));
        String actualCity = addressPage.billTownCity.getAttribute("value");
        Assert.assertEquals(actualCity, ConfigReader.getProperty("US12City"));

        ActionUtils.actionsScrollDown();

        addressPage.billStateProvinceDD.click();
        WebElement ontarioOption = Driver.getDriver().findElement(By.xpath("//span[text()='Ontario']"));
        ontarioOption.click();
        // addressPage.billStateProvinceDD.sendKeys("Ontario" + Keys.ENTER);

        //addressPage.billZipPostCode.sendKeys(ConfigReader.getProperty("US12PostalCode"));
        String actualPostalCode = addressPage.billZipPostCode.getAttribute("value");
        Assert.assertEquals(actualPostalCode, ConfigReader.getProperty("US12PostalCode"));

        //addressPage.billPhoneNumb.sendKeys(ConfigReader.getProperty("US12PhoneNumber"));
        String actualPhoneNumber = addressPage.billPhoneNumb.getAttribute("value");
        Assert.assertEquals(actualPhoneNumber, ConfigReader.getProperty("US12PhoneNumber"));

        ActionUtils.actionsScrollDown();
        // Save the billing address (TC_05)
        addressPage.billSaveAddressButton.submit();

        // Assert that the billing address is added successfully (TC_07)
        // Wait for the success message to appear
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        //WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")));
        WebElement successMessage = addressPage.successMessageBilling;
        Assert.assertEquals(successMessage.getText(), "Address changed successfully.");
    }
}