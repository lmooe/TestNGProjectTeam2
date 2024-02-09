package techproed.tests.US_04;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.Bill_ShipAddressPage;
import techproed.pages.DashboardPage;
import techproed.pages.HomePage;
import techproed.utilities.*;


public class US_04_TC_01 {

//    HomePage homePage = new HomePage();
//    Faker faker = new Faker();


    @Test
    public void us4TC1() {


        HomePage homePage = new HomePage();
        Faker faker = new Faker();





        Bill_ShipAddressPage billShipAddressPage = new Bill_ShipAddressPage();
        DashboardPage dashboardPage = new DashboardPage(); //  @FindBy(xpath = "//a[text()='Addresses']")
        //public WebElement addresses;


        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
        BrowserUtils.clickWithTimeOut(homePage.register, 5);

        WaitUtils.waitFor(5);
        JSUtils.JSclickWithTimeout(homePage.regUsername);
        homePage.regUsername.sendKeys(faker.name().username());
        JSUtils.JSclickWithTimeout(homePage.regEmail);
        homePage.regEmail.sendKeys(faker.internet().emailAddress());
        JSUtils.JSclickWithTimeout(homePage.regPassword);
        homePage.regPassword.sendKeys(faker.internet().password());
        JSUtils.JSclickWithTimeout(homePage.agreePolicy);
        BrowserUtils.clickWithTimeOut(homePage.signUpButton, 5);
        WaitUtils.waitFor(5);

        JSUtils.JSclickWithTimeout(homePage.MyAccountOnFooter);
        JSUtils.JSclickWithTimeout(dashboardPage.addresses);
        WaitUtils.waitFor(5);

        JSUtils.JSclickWithTimeout(billShipAddressPage.addShip);
        WaitUtils.waitFor(5);

        JSUtils.JSclickWithTimeout(billShipAddressPage.shipFirstName);
        WaitUtils.waitFor(5);
        billShipAddressPage.shipFirstName.sendKeys("Jane");
        billShipAddressPage.shipLastName.click();
        billShipAddressPage.shipLastName.sendKeys("Doe");

        JSUtils.JSclickWithTimeout(billShipAddressPage.shipCountryDD);
        //WaitUtils.waitFor(5); //to see the dropdown
        WebElement canadaOption = Driver.getDriver().findElement(By.xpath("//*[@value='CA']"));
        JSUtils.JSclickWithTimeout(canadaOption);

        JSUtils.JSclickWithTimeout(billShipAddressPage.shipAddressLine1);
        billShipAddressPage.shipAddressLine1.sendKeys("150 Dowling Ave");
        JSUtils.JSclickWithTimeout(billShipAddressPage.shipAddressLine2);
        billShipAddressPage.shipAddressLine2.sendKeys("unit 700");

        JSUtils.JSclickWithTimeout(billShipAddressPage.shipTownCity);
        billShipAddressPage.shipTownCity.sendKeys("Toronto");
        JSUtils.JSclickWithTimeout(billShipAddressPage.shipStateProvinceDD);
        WaitUtils.waitFor(5);
        WebElement ontarioOption = Driver.getDriver().findElement(By.xpath("//*[@id='select2-shipping_state-result-mutp-ON']"));
        JSUtils.JSclickWithTimeout(ontarioOption);


        JSUtils.JSclickWithTimeout(billShipAddressPage.shipZipPostCode);
        billShipAddressPage.shipZipPostCode.sendKeys("M6K 3A8");
        JSUtils.JSclickWithTimeout(billShipAddressPage.shipSaveAddressButton);

        String successMsg = billShipAddressPage.successMessage.getText();

        Assert.assertEquals(successMsg, "Address changed successfully.");
    }
}