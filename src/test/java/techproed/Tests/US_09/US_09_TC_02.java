package techproed.Tests.US_09;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.VendorPage;
import techproed.utilities.BrowserUtils;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.WaitUtils;

public class US_09_TC_02 {
    HomePage homePage = new HomePage();
    Faker faker = new Faker();

    VendorPage vendorPage = new VendorPage();

    @Test
    public void us9TC2() {


        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
        WaitUtils.waitFor(3);
        BrowserUtils.clickWithTimeOut(homePage.register, 1);

        homePage.regUsername.click();
        homePage.regUsername.sendKeys(faker.name().username());
        homePage.regEmail.click();
        homePage.regEmail.sendKeys("lipa.logen@farmoaks.com");
        homePage.regPassword.click();
        homePage.regPassword.sendKeys(faker.internet().password());
        homePage.agreePolicy.click();
        BrowserUtils.clickWithTimeOut(homePage.signUpButton, 1);
        WaitUtils.waitFor(3);


        String emailUsedMessage = homePage.noSuccess.getText();
        Assert.assertEquals(emailUsedMessage, "Account is already registered with your email address");

    }
}