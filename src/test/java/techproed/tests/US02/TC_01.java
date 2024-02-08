package techproed.tests.US02;

import com.github.javafaker.Faker;
import org.testng.annotations.*;
import techproed.pages.HomePage;
import techproed.utilities.BrowserUtils;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.WaitUtils;

public class TC_01 {

//    user clicks in "Register" button
//    user enters valid username
//    user enters valid e-mail
//    user submits an 11-character password
//    user selects the 'I agree to the privacy policy' checkbox
//    user clicks on sign-up button
//    user registers successfully

//    @BeforeTest
//    public void setUp(){
//        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
//        WaitUtils.waitForPageToLoad(2);
//    }

//    @AfterTest
//    public void tearDown(){
//        Driver.closeDriver();
//    }

    @Test
    public void TC_01(){

//    user clicks in "Register" button
//    user enters valid username
//    user enters valid e-mail
//    user submits an 11-character password
//    user selects the 'I agree to the privacy policy' checkbox
//    user clicks on sign-up button
//    user registers successfully

        Faker faker = new Faker();
        String fakeName = faker.name().firstName();
        String fakeEmail = faker.internet().emailAddress();
        String  invalidPasssword= "Adf./;'1234";

        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
        WaitUtils.waitForPageToLoad(2);

        HomePage homePage = new HomePage();

        BrowserUtils.clickWithTimeOut(homePage.register,2);

        BrowserUtils.sendKeysWithTimeout(homePage.regUsername,fakeName,2);

        BrowserUtils.sendKeysWithTimeout(homePage.regEmail,fakeEmail,2);

        BrowserUtils.sendKeysWithTimeout(homePage.regPassword,invalidPasssword,2); //11-character password

        BrowserUtils.clickWithTimeOut(homePage.regCheckBox,2);

        BrowserUtils.clickWithTimeOut(homePage.signUpButton,2);

        String currentUrl = Driver.getDriver().getCurrentUrl();
        if (currentUrl.equals("https://allovercommerce.com/my-account-2/")){
            System.out.println("Test FAILED");
        }else {
            System.out.println("Test PASSED");
        }

        Driver.closeDriver();
    }
}
