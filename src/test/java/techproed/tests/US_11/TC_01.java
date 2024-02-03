package techproed.tests.US_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import techproed.utilities.Driver;
import techproed.utilities.WaitUtils;

public class TC_01 {

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get("https://allovercommerce.com/my-account-2/");
        WaitUtils.waitForPageToLoad(20);
       // Driver.initialiseDriver();
    }

    @Test (description = "Vendor Sign-In with Valid Credentials", priority = 1)
    public void vendorSignInTest() {
        // Login Credentials for Vendor
        String validEmail = "trystin.domingo@farmoaks.com";
        String validPassword = "123456abc";


        enterUsername(validEmail);

        enterPassword(validPassword);

        clickSignIn();

        assertMyAccountDisplayed();
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

    private void enterUsername(String username) {
        WebElement usernameField = Driver.getDriver().findElement(By.id("username"));
        usernameField.sendKeys(username);
    }

    private void enterPassword(String password) {
        WebElement passwordField = Driver.getDriver().findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys(password);
    }

    private void clickSignIn() {
        WebElement signInButton = Driver.getDriver().findElement(By.xpath("//button[@name='login']"));
        signInButton.click();
    }

    private void assertMyAccountDisplayed() {
        WebElement myAccountLink = Driver.getDriver().findElement(By.xpath("//a[text()='Dashboard']"));
        Assert.assertTrue(myAccountLink.isDisplayed(), "My Account page is displayed after login.");
    }

//    private void verifyMyAccountPage() {
//        // Simulate verifying that the My Account page is displayed using XPath
//        WebElement myAccountPage = Driver.getDriver().findElement(By.xpath("//div[@class='my-account']"));
//        // Perform assertions based on the actual behavior of your application
//        Assert.assertTrue(myAccountPage.isDisplayed(), "My Account page is not displayed");
//    }
}