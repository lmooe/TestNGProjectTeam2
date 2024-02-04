package techproed.tests.US_19;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.utilities.BrowserUtils;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.WaitUtils;

public class TC_01 {


    @Test
    public void test01(){

        HomePage homepage = new HomePage();

        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));

        homepage.username.sendKeys(ConfigReader.getProperty("username"),Keys.TAB,ConfigReader.getProperty("password"),Keys.ENTER);




    }








    }



