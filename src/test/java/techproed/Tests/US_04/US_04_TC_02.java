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

        billShipAddressPage.shipAddressLine1.click();
        billShipAddressPage.shipAddressLine1.sendKeys("150 Dowling Ave");
        billShipAddressPage.shipAddressLine2.click();
        billShipAddressPage.shipAddressLine2.sendKeys("unit 700");

        billShipAddressPage.shipTownCity.click();
        billShipAddressPage.shipTownCity.sendKeys("Toronto");
        billShipAddressPage.shipStateProvinceDD.click();
        WebElement ontarioOption = Driver.getDriver().findElement(By.xpath("//*[@value='ON']"));
        ontarioOption.click();


        billShipAddressPage.shipZipPostCode.click();
        billShipAddressPage.shipZipPostCode.sendKeys("M6K 3PP");
        billShipAddressPage.shipSaveAddressButton.click();

        String successMsg = billShipAddressPage.nonSuccessMessage.getText();

        Assert.assertEquals(successMsg, "Please enter a valid postcode/ZIP");
    }

}
