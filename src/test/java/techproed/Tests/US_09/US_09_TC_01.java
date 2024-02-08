package techproed.Tests.US_09;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.DashboardPage;
import techproed.pages.HomePage;
import techproed.pages.VendorPage;
import techproed.utilities.BrowserUtils;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.WaitUtils;

public class US_09_TC_01 {

    HomePage homePage = new HomePage();
    Faker faker = new Faker();

    VendorPage vendorPage = new VendorPage();

    @Test
    public void us9TC1(){


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

        homePage.becomeVendor.click();

        vendorPage.vendorRegistrationEmail.click();
        vendorPage.vendorRegistrationEmail.sendKeys("lipa.logen@farmoaks.com");
        //vendorPage.vendorRegistrationEmail.sendKeys(faker.internet().emailAddress());
        vendorPage.vendorResendCode.click();

        //manually retrieve code from email and input into verification code

        vendorPage.vendorConfirmButton.click();
        WaitUtils.waitFor(2);

        String successMsg = vendorPage.setupPage.getText();

        Assert.assertEquals(successMsg, "Welcome to Allover Commerce");


    }
}
