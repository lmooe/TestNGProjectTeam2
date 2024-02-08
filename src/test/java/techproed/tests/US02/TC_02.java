package techproed.tests.US02;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.utilities.BrowserUtils;
import techproed.utilities.Driver;
import techproed.utilities.WaitUtils;

public class TC_02 {

//    user clicks in "Register" button
//    user enters valid username
//    user enters valid e-mail
//    user enters valid password
//    user selects the 'I agree to the privacy policy' checkbox
//    user clicks on sign-up button
//    user sees ''

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("https://allovercommerce.com/");
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
//    user enters valid e-mail
//    user enters valid password
//    user selects the 'I agree to the privacy policy' checkbox
//    user clicks on sign-up button
//    user sees warning text and "Please log in." message

        Faker faker = new Faker();
        String fakeName = faker.name().firstName();
        String usedEmailAdress = "oz401@yahoo.com";
        String  validPasssword= faker.internet().password(12,20);

        HomePage homePage = new HomePage();

        BrowserUtils.clickWithTimeOut(homePage.registerButton,2);

        BrowserUtils.sendKeysWithTimeout(homePage.regUsername,fakeName,2);

        BrowserUtils.sendKeysWithTimeout(homePage.regEmail,usedEmailAdress,2);

        BrowserUtils.sendKeysWithTimeout(homePage.regPassword,validPasssword,2);

        BrowserUtils.clickWithTimeOut(homePage.regCheckBox,2);

        BrowserUtils.clickWithTimeOut(homePage.signUpButton,2);

        if (homePage.emailWarningText.equals("An account is already registered with your email address. ")){
            System.out.println("Test PASSED...");
        }else {
            System.out.println("Test Failed...");
        }



    }
}
