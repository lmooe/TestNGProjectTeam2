package techproed.tests.US_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import techproed.utilities.Driver;
import techproed.utilities.WaitUtils;

public class TC_05 {

    @BeforeTest
    public void setUp() {
        Driver.getDriver().get("https://allovercommerce.com/my-account-2/");
        WaitUtils.waitForPageToLoad(20);
        // Driver.initialiseDriver();
    }

    @AfterTest
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void dashboardElementsVisibilityTest() {
        // Perform login actions
        enterUsername("trystin.domingo@farmoaks.com");
        enterPassword("123456abc");
        clickSignIn();

        // Navigate to the Dashboard
        navigateToDashboard();

        // Navigate to the Store Manager
        navigateToStoreManager();

        // Navigate to the Orders
        Driver.getDriver().navigate().back();
        navigateToOrders();

        // Navigate to the Downloads
        navigateToDownloads();

        navigateToAddresses();

        navigateToAccountDetails();

        navigateToWishlist();

        Driver.getDriver().navigate().back();
        navigateToSupportTickets();

        navigateToFollowings();

        navigateToLogout();

    }

    private void enterUsername(String username) {
        WebElement usernameField = Driver.getDriver().findElement(By.xpath("//input[@id='username']"));
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

    private void navigateToDashboard() {
        WebElement dashboardLink = Driver.getDriver().findElement(By.xpath("//a[text()='Dashboard']"));
        dashboardLink.click();

        String expectedDashboardURL = "https://allovercommerce.com/my-account-2/";

        String actualDashboardURL = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualDashboardURL, expectedDashboardURL, "Dashboard page is selected");
    }

    private void navigateToStoreManager() {
        WebElement storeManager = Driver.getDriver().findElement(By.xpath("//a[text()='Store Manager']"));
        storeManager.click();

        String expectedStoreManagerURL = "https://allovercommerce.com/store-manager/";

        String actualStoreManagerURL = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualStoreManagerURL, expectedStoreManagerURL, "Store Manager page is selected");
    }

    private void navigateToOrders() {
        WebElement orders = Driver.getDriver().findElement(By.xpath("//a[text()='Orders']"));
        orders.click();

        String expectedOrdersURL = "https://allovercommerce.com/my-account-2/orders/";

        String actualOrdersURL = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualOrdersURL, expectedOrdersURL, "Orders page is selected");
    }

    private void navigateToDownloads() {
        WebElement downloads = Driver.getDriver().findElement(By.xpath("//a[text()='Downloads']"));
        downloads.click();

        String expectedDownloadsURL = "https://allovercommerce.com/my-account-2/downloads/";

        String actualDownloadsURL = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualDownloadsURL, expectedDownloadsURL, "Downloads page is selected");
    }

    private void navigateToAddresses() {
        WebElement addresses = Driver.getDriver().findElement(By.xpath("//a[text()='Addresses']"));
        addresses.click();

        String expectedAddressesURL = "https://allovercommerce.com/my-account-2/edit-address/";

        String actualAddressesURL = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualAddressesURL, expectedAddressesURL, "Addresses page is selected");
    }

    private void navigateToAccountDetails() {
        WebElement accountDetails = Driver.getDriver().findElement(By.xpath("//a[text()='Account details']"));
        accountDetails.click();

        String expectedAccountDetailsURL = "https://allovercommerce.com/my-account-2/edit-account/";

        String actualAccountDetailsURL = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualAccountDetailsURL, expectedAccountDetailsURL, "Account Details is selected");
    }

    private void navigateToWishlist() {
        WebElement wishlist = Driver.getDriver().findElement(By.xpath("//a[text()='Wishlist']"));
        wishlist.click();

        String expectedWishlistURL = "https://allovercommerce.com/wishlist/";

        String actualWishlistURL = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualWishlistURL, expectedWishlistURL, "Wishlist is selected");
    }

    private void navigateToSupportTickets() {
        WebElement supportTickets = Driver.getDriver().findElement(By.xpath("//a[text()='Support Tickets']"));
        supportTickets.click();

        String expectedSupportTicketsURL = "https://allovercommerce.com/my-account-2/support-tickets/";

        String actualSupportTicketsURL = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualSupportTicketsURL, expectedSupportTicketsURL, "Support Tickets is selected");
    }

    private void navigateToFollowings() {
        WebElement followings = Driver.getDriver().findElement(By.xpath("//a[text()='Followings']"));
        followings.click();

        String expectedFollowingsURL = "https://allovercommerce.com/my-account-2/followings/";

        String actualFollowingsURL = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualFollowingsURL, expectedFollowingsURL, "Followings is selected");
    }

    private void navigateToLogout() {
        WebElement logOut = Driver.getDriver().findElement(By.xpath("//a[text()='Logout']"));
        logOut.click();

        String expectedLogoutURL = "https://allovercommerce.com/my-account-2/";

        String actualLogoutURL = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualLogoutURL, expectedLogoutURL, "Logout is selected");
    }

}