
package techproed.tests.US_08;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import techproed.pages.WishListPage;
import techproed.utilities.*;

public class AddingProductToTheWishlist {

    WishListPage wishListPage= new WishListPage();
//@AfterTest
//public void quit(){
//    Driver.closeDriver();
//

    //}
    @Test
    public void addProducttoWishlist() throws InterruptedException {
        Actions actions= new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));
        ActionUtils.actionsScrollDown();
        Thread.sleep(2000);
        actions.click(wishListPage.clickOnAutomaticCrusher).build().perform();
        WaitUtils.waitForPageToLoad(2);

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
        WaitUtils.waitForPageToLoad(2);
//        actions.moveToElement(wishListPage.priceOnPopUp).perform();
//        BrowserUtils.frameSwitchTo("//div[@class='mfp-figure']");
//        JSUtils.JSgetValueBy("WishListPage.")
        WaitUtils.waitForPageToLoad(3);
//      User should see a new window pop up
//      User should see details about the product like price, category, review
        BrowserUtils.verifyElementDisplayed(wishListPage.priceOnPopUp);
//        BrowserUtils.verifyElementDisplayed(wishListPage.categoryOnPopUp);
//        BrowserUtils.verifyElementDisplayed(wishListPage.reviewsVisible);


    }
}

