package techproed.tests.US_19;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.utilities.BrowserUtils;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.WaitUtils;

public class TC_01{

    HomePage homepage = new HomePage();


       @BeforeTest
       public void setUp() {
            Driver.getDriver().get("https://allovercommerce.com/");
            WaitUtils.waitForPageToLoad(2);

       }

        @Test
        public void test01(){

           homepage.singIn1.click();
           // Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));


        //   BrowserUtils.sendKeysWithTimeout("email",2);

           // homepage.singIn1.click();
           // homepage.username.sendKeys(ConfigReader.getProperty("email"));
           // homepage.password.sendKeys(ConfigReader.getProperty("password"));
           // WaitUtils.waitFor(2);
            //homepage.signUpButton.click();






       // homepage.searchBox.click();
    }



    }



