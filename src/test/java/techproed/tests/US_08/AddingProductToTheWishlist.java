
package techproed.tests.US_08;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import techproed.pages.WishListPage;
import techproed.utilities.*;

public class AddingProductToTheWishlist {

    WishListPage wishListPage= new WishListPage();
    @AfterTest
    public void quit(){
        Driver.closeDriver();
    }
    @Test
    public void addProducttoWishlist() throws InterruptedException {
        Actions actions= new Actions(Driver.getDriver());

//      User goes to https://www.allovercommerce.com
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
//      User must click on the specific product (Automatic crusher) he/she likes
        ActionUtils.actionsScrollDown();
        Thread.sleep(2000);
        actions.click(wishListPage.clickOnAutomaticCrusher).build().perform();
        WaitUtils.waitForPageToLoad(2);

//      User must click on the wishlist icon(heart icon under add to cart button)
        actions.click(wishListPage.clickOnHeart).build().perform();

//      User must see heart icon with filled color
        BrowserUtils.verifyElementDisplayed(wishListPage.redHeartIcon);

//      User must click on the wishlist icon on the top right corner
        actions.click(wishListPage.clickOnWishListTab).build().perform();

//      User must see the product in the wishlist
//      User must see the same product icon,price,stock status and action
        BrowserUtils.verifyElementDisplayed(wishListPage.productIsVisible);
        BrowserUtils.verifyElementDisplayed(wishListPage.priceIsVisible);
        BrowserUtils.verifyElementDisplayed(wishListPage.stockStatusIsVisible);
        BrowserUtils.verifyElementDisplayed(wishListPage.actionsIsVisible);

//      User must click the quick view button under actions tab
        actions.click(wishListPage.quickViewButton).build().perform();
        WaitUtils.waitForPageToLoad(15);

//      User should see a new window pop up
//      User should see details about the product like price, category, review,SKU number
//      Category:
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        // Use JavaScript Executor to get the text content (JS Executor returns Object, so you have to typecast to String)
        String textContent1 = (String) js.executeScript("return arguments[0].textContent.trim()",wishListPage.categoryOnPopUp);
        // Assert that the text content "Categories"
        Assert.assertTrue(textContent1.contains("Category: Kitchen"));
        // Print the full text content
        System.out.println("Text content: " + textContent1);
//      Price:
        Thread.sleep(5000);
        String actualAmount=BrowserUtils.getTextWithTimeout(wishListPage.priceOnPopUp,10);
        String expectedAmount="$220.25";
        System.out.println(actualAmount);
        Assert.assertEquals(actualAmount,expectedAmount);
//      Reviews:
        Thread.sleep(5000);
        String actualReview=BrowserUtils.getTextWithTimeout(wishListPage.reviews,10);
        System.out.println(actualReview);
        String expectedReview="(0 Reviews)";
        Assert.assertEquals(actualReview,expectedReview);
//      SKU number:
        Thread.sleep(5000);
        String actualSKU=BrowserUtils.getTextWithTimeout(wishListPage.skuNumber,5);
        System.out.println(actualSKU);
        String expectedSKU="SKU: MS46891362";
        Assert.assertEquals(actualSKU,expectedSKU);

//      User closes the pop-up window
        JSUtils.JSscrollIntoView(wishListPage.priceOnPopUp);
        JSUtils.JSclickWithTimeout(wishListPage.closeButtonOnPopUp);
        WaitUtils.waitForPageToLoad(5);

//      User must click on the add to cart button in the actions tab
        Thread.sleep(5000);
        WaitUtils.waitFor(5);
        wishListPage.addToCartButton.click();
        Thread.sleep(9000);
        WaitUtils.waitForPageToLoad(10);

//      User should see the message: “Product name” has been added to your cart.
        String actualMessage=BrowserUtils.getTextWithTimeout(wishListPage.successMessage,5);
        String expectedMessage="VIEW CART “Automatic Crusher” has been added to your cart.";
        System.out.println(actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage);
        Thread.sleep(5000);

    }
}

