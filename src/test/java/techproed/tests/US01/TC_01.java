package techproed.tests.US01;

import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.utilities.BrowserUtils;
import techproed.utilities.ConfigReader;
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
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
        WaitUtils.waitForPageToLoad(10);
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

        HomePage homePage = new HomePage();

        BrowserUtils.clickWithTimeOut(homePage.registerButton,2);

//        loginPage.regUsername.sendKeys();
        BrowserUtils.sendKeysWithTimeout(homePage.regUsername,fakeName,2);
        homePage.regEmail.sendKeys(fakeEmail);
        homePage.regPassword.sendKeys(password);
//        loginPage.regCheckBox.click();
        BrowserUtils.clickWithTimeOut(homePage.regCheckBox,2);
        BrowserUtils.clickWithTimeOut(homePage.signUpButton,2);

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