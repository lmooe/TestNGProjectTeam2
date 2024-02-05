package techproed.tests.US_19;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.utilities.BrowserUtils;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.WaitUtils;

public class TC_01 {

    HomePage homepage = new HomePage();
    @BeforeTest
    public void setUP(){

        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
       // homepage.singIn1.click;
      //  BrowserUtils.clickWithTimeOut(homepage.singIn1,2);


    }

  //  @Test
   //public void TC_01test(){



     //   homepage.singIn1.click;
      //  BrowserUtils.clickWithTimeOut(homepage.singIn1,2);
       // Driver.getDriver().findElement(xpath "//span[text()='Sign In']").click();
        //BrowserUtils.clickWithTimeOut(homepage.singIn1,2);


      //  homepage.singIn1.click();
       // BrowserUtils.clickWithTimeOut(homepage.singIn1,2);






    }



