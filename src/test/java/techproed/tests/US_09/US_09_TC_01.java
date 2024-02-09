package techproed.tests.US_09;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.DashboardPage;
import techproed.pages.HomePage;
import techproed.pages.VendorPage;
import techproed.utilities.*;

public class US_09_TC_01 {

    HomePage homePage = new HomePage();
    Faker faker = new Faker();
    DashboardPage dashboardPage= new DashboardPage();

    VendorPage vendorPage = new VendorPage();

    @Test
    public void us9TC1(){


        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
        BrowserUtils.clickWithTimeOut(homePage.register, 5);

        JSUtils.JSclickWithTimeout(homePage.regUsername);
        homePage.regUsername.sendKeys(faker.name().username());
        JSUtils.JSclickWithTimeout(homePage.regEmail);
        homePage.regEmail.sendKeys(faker.internet().emailAddress());
        JSUtils.JSclickWithTimeout(homePage.regPassword);
        homePage.regPassword.sendKeys(faker.internet().password());
        JSUtils.JSclickWithTimeout(homePage.agreePolicy);
        BrowserUtils.clickWithTimeOut(homePage.signUpButton, 5);
        JSUtils.JSclickWithTimeout(homePage.MyAccountOnFooter);


        JSUtils.JSclickWithTimeout(homePage.becomeVendor);

        //JSUtils.JSclickWithTimeout(vendorPage.vendorRegistrationEmail);
        //vendorPage.vendorRegistrationEmail.sendKeys("lipa.logen@farmoaks.com");
        //vendorPage.vendorRegistrationEmail.sendKeys(faker.internet().emailAddress());
        JSUtils.JSclickWithTimeout(vendorPage.vendorResendCode);

        //manually retrieve code from email and input into verification code
        // tc will fail here as expected, since we cannot get code via faker email.

        JSUtils.JSclickWithTimeout(vendorPage.vendorConfirmButton);
        WaitUtils.waitFor(2);

        String successMsg = vendorPage.setupPage.getText();

        Assert.assertEquals(successMsg, "Welcome to Allover Commerce");


    }
}
