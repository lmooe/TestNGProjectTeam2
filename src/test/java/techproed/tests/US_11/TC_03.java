package techproed.tests.US_11;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import techproed.pages.DashboardPage;
import techproed.pages.HomePage;
import techproed.utilities.*;

public class TC_03 {

    private DashboardPage dashboardPage;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
        WaitUtils.waitForPageToLoad(20);

//        homePage = new HomePage();
//        dashboardPage = new DashboardPage();
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void dashboardElementsVisibilityTest() {
        homePage = new HomePage();
        dashboardPage = new DashboardPage();
        // Perform login actions
        JSUtils.JSclickWithTimeout(homePage.singIn1);
        homePage.username.sendKeys(ConfigReader.getProperty("US11username"));
        homePage.password.sendKeys(ConfigReader.getProperty("US11password"));
        JSUtils.JSclickWithTimeout(homePage.signInButton);
        WaitUtils.waitForVisibility(homePage.MyAccountOnFooter,20);
        ActionUtils.actionsScrollDown();
        ActionUtils.actionsScrollDown();
//        homePage.MyAccountOnFooter.click();
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", homePage.MyAccountOnFooter);
//
//        WaitUtils.waitFor(10);

        // Assert the visibility of elements under the Dashboard
        assertDashboardElementsVisible();
    }

    private void assertDashboardElementsVisible() {
        Assert.assertTrue(dashboardPage.dashboard.isDisplayed(), "Dashboard is visible under the Dashboard.");
        Assert.assertTrue(dashboardPage.storeManager.isDisplayed(), "Store Manager is visible under the Dashboard.");
        Assert.assertTrue(dashboardPage.orders.isDisplayed(), "Orders is visible under the Dashboard.");
        Assert.assertTrue(dashboardPage.downloads.isDisplayed(), "Downloads is visible under the Dashboard.");
        Assert.assertTrue(dashboardPage.addresses.isDisplayed(), "Addresses is visible under the Dashboard.");
        Assert.assertTrue(dashboardPage.accountDetails.isDisplayed(), "Account Details is visible under the Dashboard.");
        Assert.assertTrue(dashboardPage.wishlist.isDisplayed(), "Wishlist is visible under the Dashboard.");
        Assert.assertTrue(dashboardPage.supportTickets.isDisplayed(), "Support Tickets is visible under the Dashboard.");
        Assert.assertTrue(dashboardPage.followings.isDisplayed(), "Followings is visible under the Dashboard.");
        Assert.assertTrue(dashboardPage.logOut.isDisplayed(), "Log Out is visible under the Dashboard.");
        System.out.println("Success!!! US_11 TC_03");
    }
}





//package techproed.tests.US_11;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import techproed.utilities.Driver;
//import techproed.utilities.WaitUtils;
//
//public class TC_03 {
//
//    @BeforeMethod
//    public void setUp() {
//        Driver.getDriver().get("https://allovercommerce.com/my-account-2/");
//        WaitUtils.waitForPageToLoad(20);
//        // Driver.initialiseDriver();
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        Driver.closeDriver();
//    }
//
//    @Test
//    public void dashboardElementsVisibilityTest() {
//        // Perform login actions
//        enterUsername("trystin.domingo@farmoaks.com");
//        enterPassword("123456abc");
//        clickSignIn();
//
//        // Navigate to the Dashboard
//        navigateToDashboard();
//
//        // Assert the visibility of elements under the Dashboard
//        assertDashboardElementsVisible();
//    }
//
//    private void enterUsername(String username) {
//        WebElement usernameField = Driver.getDriver().findElement(By.xpath("//input[@id='username']"));
//        usernameField.sendKeys(username);
//    }
//
//    private void enterPassword(String password) {
//        WebElement passwordField = Driver.getDriver().findElement(By.xpath("//input[@id='password']"));
//        passwordField.sendKeys(password);
//    }
//
//    private void clickSignIn() {
//        WebElement signInButton = Driver.getDriver().findElement(By.xpath("//button[@name='login']"));
//        signInButton.click();
//    }
//
//    private void navigateToDashboard() {
//        // Assuming there's a navigation link to the Dashboard after login
//        WebElement dashboardLink = Driver.getDriver().findElement(By.xpath("//a[text()='Dashboard']"));
//        dashboardLink.click();
//    }
//
//    private void assertDashboardElementsVisible() {
//
//        WebElement dashboard = Driver.getDriver().findElement(By.xpath("//a[text()='Dashboard']"));
//        Assert.assertTrue(dashboard.isDisplayed(), "Dashboard is visible under the Dashboard.");
//
//        WebElement storeManager = Driver.getDriver().findElement(By.xpath("//a[text()='Store Manager']"));
//        Assert.assertTrue(storeManager.isDisplayed(), "Store Manager is visible under the Dashboard.");
//
//        WebElement orders = Driver.getDriver().findElement(By.xpath("//a[text()='Orders']"));
//        Assert.assertTrue(orders.isDisplayed(), "Orders is visible under the Dashboard.");
//
//        WebElement downloads = Driver.getDriver().findElement(By.xpath("//a[text()='Downloads']"));
//        Assert.assertTrue(downloads.isDisplayed(), "Downloads is visible under the Dashboard.");
//
//        WebElement addresses = Driver.getDriver().findElement(By.xpath("//a[text()='Addresses']"));
//        Assert.assertTrue(addresses.isDisplayed(), "Addresses is visible under the Dashboard.");
//
//        WebElement accountDetails = Driver.getDriver().findElement(By.xpath("//a[text()='Account details']"));
//        Assert.assertTrue(accountDetails.isDisplayed(), "Account Details is visible under the Dashboard.");
//
//        WebElement wishlist = Driver.getDriver().findElement(By.xpath("//a[text()='Wishlist']"));
//        Assert.assertTrue(wishlist.isDisplayed(), "Wishlist is visible under the Dashboard.");
//
//        WebElement supportTickets = Driver.getDriver().findElement(By.xpath("//a[text()='Support Tickets']"));
//        Assert.assertTrue(supportTickets.isDisplayed(), "Support Tickets is visible under the Dashboard.");
//
//        WebElement followings = Driver.getDriver().findElement(By.xpath("//a[text()='Followings']"));
//        Assert.assertTrue(followings.isDisplayed(), "Followings is visible under the Dashboard.");
//
//        WebElement logOut = Driver.getDriver().findElement(By.xpath("//a[text()='Logout']"));
//        Assert.assertTrue(logOut.isDisplayed(), "Log Out is visible under the Dashboard.");
//    }
//}