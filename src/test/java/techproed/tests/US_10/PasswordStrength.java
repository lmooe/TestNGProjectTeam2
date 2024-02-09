package techproed.tests.US_10;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.WaitUtils;

public class PasswordStrength {


//    User clicks on the ""Become a Vendor"" button on the opened pop up window
//    User types "Abc" to the password part and see "too short" message under password box

//    @AfterTest
//    public void quit(){
//        Driver.closeDriver();
//    }

    @Test
    public void shortPasswordTest(){

//    User goes to https://www.allovercommerce.com
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
        WaitUtils.waitFor(5);
//    User clicks on the "Register" button in the upper right corner
        Driver.getDriver().findElement(By.xpath("//a[@class='register inline-type']")).click();
        WaitUtils.waitFor(5);
        Driver.getDriver().findElement(By.xpath("//div[@class='wcfmmp_become_vendor_link']")).click();


        WaitUtils.waitFor(5);


        Driver.getDriver().findElement(By.xpath("//input[@id='passoword']")).sendKeys("Abc");
    }


}
