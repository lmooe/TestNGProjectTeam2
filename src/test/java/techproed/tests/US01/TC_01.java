package techproed.tests.US01;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import techproed.pages.LoginPage;
import techproed.utilities.BrowserUtils;
import techproed.utilities.Driver;
import techproed.utilities.WaitUtils;

public class TC_01 {

    /*
    user clicks in "Register" button
    user enters valid username
    user enters valid e-mail
    user enters valid password
    user selects the 'I agree to the privacy policy' checkbox
    user clicks on sign-up button
    user registers successfully
     */


    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("https://allovercommerce.com/");
        WaitUtils.waitForPageToLoad(20);
    }

    @Test
    public void TC_01(){

        /*
           user clicks in "Register" button
           user enters valid username
           user enters valid e-mail
           user enters valid password
           user selects the 'I agree to the privacy policy' checkbox
           user clicks on sign-up button
           user registers successfully
     */
        Faker faker = new Faker();
        String fakeName = faker.name().firstName();
        String fakeEmail = faker.internet().emailAddress();
        String password = "Adf./;'1234"; // 11 length

        LoginPage loginPage = new LoginPage();

        BrowserUtils.clickWithTimeOut(loginPage.registerButton,2);

//        loginPage.regUsername.sendKeys();
        BrowserUtils.sendKeysWithTimeout(loginPage.regUsername,fakeName,2);
        loginPage.regEmail.sendKeys(fakeEmail);
        loginPage.regPassword.sendKeys(password);
//        loginPage.regCheckBox.click();
        BrowserUtils.clickWithTimeOut(loginPage.regCheckBox,2);
        BrowserUtils.clickWithTimeOut(loginPage.signUpButton,2);

        String currentUrl = Driver.getDriver().getCurrentUrl();
        if (currentUrl.equals("https://allovercommerce.com/my-account-2/")){
            System.out.println("Register is successful...");
        }else {
            System.out.println("Register is NOT successful");
        }


    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }


}