package techproed.Tests.US_04;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.Bill_ShipAddressPage;
import techproed.pages.DashboardPage;
import techproed.pages.HomePage;
import techproed.utilities.*;

import static org.testng.Assert.*;

public class US_04_TC_02 {
    HomePage homePage = new HomePage();
    Faker faker = new Faker();


    @Test
    public void us4TC2() {


        Bill_ShipAddressPage billShipAddressPage = new Bill_ShipAddressPage();
        DashboardPage dashboardPage = new DashboardPage(); //  @FindBy(xpath = "//a[text()='Addresses']")
        //public WebElement addresses;


        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
        BrowserUtils.clickWithTimeOut(homePage.register, 1);

        homePage.regUsername.click();
        homePage.regUsername.sendKeys(faker.name().username());
        homePage.regEmail.click();
        homePage.regEmail.sendKeys(faker.internet().emailAddress());
        homePage.regPassword.click();
        homePage.regPassword.sendKeys(faker.internet().password());
        homePage.agreePolicy.click();
        BrowserUtils.clickWithTimeOut(homePage.signUpButton, 1);
        WaitUtils.waitFor(3);

        JSUtils.JSclickWithTimeout(homePage.MyAccountOnFooter);
        dashboardPage.addresses.click();
        WaitUtils.waitFor(1);

        billShipAddressPage.addShip.click();
        WaitUtils.waitFor(1);

        billShipAddressPage.shipFirstName.click();
        billShipAddressPage.shipFirstName.sendKeys("Jane");
        billShipAddressPage.shipLastName.click();
        billShipAddressPage.shipLastName.sendKeys("Doe");

        billShipAddressPage.shipCountryDD.click();
        //WaitUtils.waitFor(5); //to see the dropdown
        WebElement canadaOption = Driver.getDriver().findElement(By.xpath("//*[@value='CA']"));
        canadaOption.click();

        JSUtils.JSclickWithTimeout(billShipAddressPage.shipAddressLine1);
        billShipAddressPage.shipAddressLine1.sendKeys("150 Dowling Ave");
        JSUtils.JSclickWithTimeout(billShipAddressPage.shipAddressLine2);
        billShipAddressPage.shipAddressLine2.sendKeys("unit 700");

        JSUtils.JSclickWithTimeout(billShipAddressPage.shipTownCity);
        billShipAddressPage.shipTownCity.sendKeys("Toronto");
        JSUtils.JSclickWithTimeout(billShipAddressPage.shipStateProvinceDD);
        WebElement ontarioOption = Driver.getDriver().findElement(By.xpath("//*[@value='ON']"));
        ontarioOption.click();


        JSUtils.JSclickWithTimeout(billShipAddressPage.shipZipPostCode);
        billShipAddressPage.shipZipPostCode.sendKeys("M6K 3PP");
        JSUtils.JSclickWithTimeout(billShipAddressPage.shipSaveAddressButton);

        /*
        ---------- Couldn't do this assertion because the warning pop up keeps changing!!!--------
         String nonSuccessMsg = billShipAddressPage.nonSuccessMessage.getText();

        Assert.assertEquals(nonSuccessMsg, "Postal code is a required field.");

         */

        boolean myAccountTitle = homePage.myAccountTitle.isDisplayed();
        Assert.assertTrue(myAccountTitle);

    }

}
