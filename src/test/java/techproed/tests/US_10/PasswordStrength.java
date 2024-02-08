package techproed.tests.US_10;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.utilities.ActionUtils;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.WaitUtils;

public class PasswordStrength {

    @AfterTest
    public void quit(){
        Driver.closeDriver();
    }


    @Test
    public void shortPasswordTest() throws InterruptedException {
        HomePage homePage=new HomePage();
//    User goes to https://www.allovercommerce.com
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
//    User clicks on the "Register" button in the upper right corner
       homePage.register.click();
//    User clicks on the ""Become a Vendor"" button on the opened pop up window
        homePage.becomeVendor.click();

//    User types "Abc" to the password part and see "too short" message under password box
        Driver.getDriver().findElement(By.xpath("//input[@id='passoword']")).sendKeys(ConfigReader.
                getProperty("short_pwd"));
        WaitUtils.waitForPageToLoad(3);
        ActionUtils.actionsScrollDown();
        Thread.sleep(2000);
        WaitUtils.waitFor(3);
//        Driver.getDriver().findElement(By.xpath("//div[@name='password_strength']")).getText().contains("Too short");
        String actualtext1=Driver.getDriver().findElement(By.xpath("//div[@name='password_strength']")).getText();
        System.out.println(actualtext1);
        String expectedText1="Too short";
        Assert.assertEquals(actualtext1,expectedText1);
//        MediaUtils.takeScreenshotOfTheEntirePage();


//        User types "Abcdef" to the password part and see "Weak" message under password box
        Driver.getDriver().navigate().refresh();
        WaitUtils.waitForPageToLoad(3);
        ActionUtils.actionsScrollDown();
        Driver.getDriver().findElement(By.xpath("//input[@id='passoword']")).sendKeys(ConfigReader.
                getProperty("weak_pwd"));
//        Driver.getDriver().findElement(By.xpath("//div[@name='password_strength']")).getText().contains("Weak");
        String actualtext2=Driver.getDriver().findElement(By.xpath("//div[@name='password_strength']")).getText();
        System.out.println(actualtext2);
        String expectedText2="Weak";
        Assert.assertEquals(actualtext2,expectedText2);
        Thread.sleep(2000);
        WaitUtils.waitFor(3);

//        User types "Abcdefgh" to the password part and see "Good" message under password box
        Driver.getDriver().navigate().refresh();
        WaitUtils.waitForPageToLoad(3);
        Driver.getDriver().findElement(By.xpath("//input[@id='passoword']")).sendKeys(ConfigReader.
                getProperty("good_pwd"));
//        Driver.getDriver().findElement(By.xpath("//div[@name='password_strength']")).getText().contains("Good");
        String actualtext3=Driver.getDriver().findElement(By.xpath("//div[@name='password_strength']")).getText();
        System.out.println(actualtext3);
        String expectedText3="Good";
        Assert.assertEquals(actualtext3,expectedText3);
        Thread.sleep(2000);
        WaitUtils.waitFor(3);

//        User types "Abcdefg1" to the password part and see "Strong" under password box
        Driver.getDriver().navigate().refresh();
        WaitUtils.waitForPageToLoad(5);
        Driver.getDriver().findElement(By.xpath("//input[@id='passoword']")).sendKeys(ConfigReader.
                getProperty("strong_pwd"));
//        Driver.getDriver().findElement(By.xpath("//div[@name='password_strength']")).getText().contains("Strong");
        String actualtext4=Driver.getDriver().findElement(By.xpath("//div[@name='password_strength']")).getText();
        System.out.println(actualtext4);
        String expectedText4="Strong";
        Assert.assertEquals(actualtext4,expectedText4);
        WaitUtils.waitForPageToLoad(2);

    }
}
