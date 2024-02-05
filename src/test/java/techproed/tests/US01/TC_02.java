package techproed.tests.US01;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import techproed.pages.LoginPage;
import techproed.utilities.BrowserUtils;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.WaitUtils;

public class TC_02 {

//    user clicks in "Register" button
//    user enters valid username
//    user writes email without '@'
//    user enters valid password
//    user selects the 'I agree to the privacy policy' checkbox
//    user clicks on sign-up button

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
        WaitUtils.waitForPageToLoad(20);
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

    @Test
    public void TC_02(){

//    user clicks in "Register" button
//    user enters valid username
//    user writes email without '@'
//    user enters valid password
//    user selects the 'I agree to the privacy policy' checkbox
//    user clicks on sign-up button

        Faker faker = new Faker();
        String fakeName = faker.name().firstName();
        String fakeEmail = faker.internet().emailAddress();
        String  validPasssword= faker.internet().password(12,20);

        LoginPage loginPage = new LoginPage();

        BrowserUtils.clickWithTimeOut(loginPage.registerButton,2);

        BrowserUtils.sendKeysWithTimeout(loginPage.regUsername,fakeName,2);

        BrowserUtils.sendKeysWithTimeout(loginPage.regEmail,fakeEmail,2);

        BrowserUtils.sendKeysWithTimeout(loginPage.regPassword,validPasssword,2);

        BrowserUtils.clickWithTimeOut(loginPage.regCheckBox,2);

        BrowserUtils.clickWithTimeOut(loginPage.signUpButton,2);

        Alert alert = Driver.getDriver().switchTo().alert();

        String alertMessage = alert.getText();

        System.out.println("alertMessage = " + alertMessage);

//        if (alertMessage.equals(""))
    }








}
