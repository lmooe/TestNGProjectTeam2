package techproed.tests.US_09;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.VendorPage;
import techproed.utilities.*;

public class US_09_TC_02 {
    HomePage homePage = new HomePage();
    Faker faker = new Faker();

    VendorPage vendorPage = new VendorPage();

    @Test
    public void us9TC2() {


        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
        WaitUtils.waitFor(5);
        BrowserUtils.clickWithTimeOut(homePage.register, 5);

        JSUtils.JSclickWithTimeout(homePage.regUsername);
        homePage.regUsername.sendKeys(faker.name().username());
        JSUtils.JSclickWithTimeout(homePage.regEmail);
        homePage.regEmail.sendKeys("lipa.logen@farmoaks.com");
        JSUtils.JSclickWithTimeout(homePage.regPassword);
        homePage.regPassword.sendKeys(faker.internet().password());
        JSUtils.JSclickWithTimeout((homePage.agreePolicy));
        BrowserUtils.clickWithTimeOut(homePage.signUpButton, 5);
        WaitUtils.waitFor(5);



        String emailUsedMessage = homePage.noSuccess.getText();
        Assert.assertTrue(emailUsedMessage.contains("An account is already registered with your email address."));

    }
}