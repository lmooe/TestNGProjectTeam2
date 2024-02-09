package techproed.tests.US_16;

import com.github.javafaker.Faker;
import org.bouncycastle.oer.its.ieee1609dot2.VerificationKeyIndicator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.AddNewProductPage;
import techproed.pages.DashboardPage;
import techproed.pages.HomePage;
import techproed.pages.ProductPage;
import techproed.utilities.*;

public class TC_01 {

    /*Task:

    Pre-cond:
    1- User must be landed on valid url,
    2- Sign in with given credentials,
    3- than must land on to Store Manager from My Account. User must click "Product" on left sidebar and then "Add New"
    4- User must enter valid product title, product image, gallery image

    Test Steps:
    1- The user should verify that the default option is set to "Simple Product."
    2- The user needs to confirm the selection of the Virtual and Downloadable options by clicking each of.
    3-The user needs to type valid data to Price and Sale Price section
    4- User needs to type valid data to Product Title field
    5- User needs to click valid product Category
    6- User needs to click Submit button
    7- Enter product title in Search field on top of the page and Click the product
    8- User needs to click "add to cart"
    9- User needs to click shopping card icon ( right top corner shopping bag icon) and then click "view cart"button

    Expected Result: Product must be seen after added to Cart

     */


    HomePage hp = new HomePage();
    DashboardPage dbp = new DashboardPage();
    AddNewProductPage anpp = new AddNewProductPage();
    ProductPage pp = new ProductPage();
    Faker fake = new Faker();

    @Test
    public void TC_01() throws InterruptedException {
        //PC_1- User must be landed on valid url
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));

        //PC_2- Sign in with given credentials

        BrowserUtils.clickWithTimeOut(hp.singIn1, 5);
        BrowserUtils.sendKeysWithTimeout(hp.username, ConfigReader.getProperty("email"), 3);
        BrowserUtils.sendKeysWithTimeout(hp.password, ConfigReader.getProperty("password"), 3);
        BrowserUtils.clickWithTimeOut(hp.signInButton, 5);

        //PC_3- than must land on to Store Manager from My Account.
        BrowserUtils.clickWithTimeOut(hp.signOut, 5);

        BrowserUtils.clickWithTimeOut(dbp.storeManager, 5);

        BrowserUtils.clickWithTimeOut(anpp.productsOption, 5);
        BrowserUtils.clickWithTimeOut(anpp.addNewButton, 5);

        //PC_4- User must enter valid product image, gallery image, product category

        //product image for display
        // String newProductImage = "C:\\Users\\paulr\\IdeaProjects\\TestNGProjectTeam2\\Resources\\images\\images.jpg";
        String newProductImage = System.getProperty("user.dir")+"/src/main/resources/images/images.jpg";
        BrowserUtils.clickWithTimeOut(anpp.addDisplayPhotoIcon, 5);
        BrowserUtils.sendKeysWithTimeout(anpp.selectFilesButton, newProductImage, 10);
        Thread.sleep(5000);
        BrowserUtils.clickWithTimeOut(anpp.selectToUploadButton, 10);
        Thread.sleep(5000);

        //product image for gallery
        BrowserUtils.clickWithTimeOut(anpp.addGalleryPhotoIcon, 10);
        Thread.sleep(5000);
        JSUtils.JSclickWithTimeout(anpp.uploadFiles);
        BrowserUtils.sendKeysWithTimeout(anpp.selectFilesButton, newProductImage, 10);
        Thread.sleep(5000);
        BrowserUtils.clickWithTimeOut(anpp.addToGalleryButton, 10);
        Thread.sleep(5000);

        // >>>>>>>>>>>>>>>>>>
        //TS_01- The user should verify that the default option is set to "Simple Product."
        Select selectProductTypeDropdown = new Select(anpp.productTypeDropdown);
        Assert.assertTrue(selectProductTypeDropdown.getFirstSelectedOption().getText().contains("Simple Product"));

        //TS_02- The user needs to confirm the selection of the Virtual and Downloadable options by clicking each of.
        BrowserUtils.verifyElementClickable(anpp.virtualBox);
        BrowserUtils.verifyElementClickable(anpp.downloadBox);

        //TS_03-The user needs to type valid data to Price and Sale Price section
        BrowserUtils.sendKeysWithTimeout(anpp.priceField, ConfigReader.getProperty("Price"),5);
        BrowserUtils.sendKeysWithTimeout(anpp.salePriceField, ConfigReader.getProperty("Sale_price"),5);

        //TS_04- User needs to type valid data to Product Title field
        BrowserUtils.sendKeysWithTimeout(anpp.productTitleInput, ConfigReader.getProperty("product_title"), 5);

        //TS_05- User needs to click valid product Category
        JSUtils.JSclickWithTimeout(anpp.categoryboxTarhana);
        Thread.sleep(2000);

        //sku
        BrowserUtils.sendKeysWithTimeout(anpp.sku,fake.number().digits(6),5);

        //TS_06- User needs to click Submit button
        BrowserUtils.clickWithTimeOut(anpp.productSubmitButton,5);
        Thread.sleep(5000);
        //TS_07- Enter product title in Search field on top of the page and Click the product
        hp.searchBox.sendKeys(ConfigReader.getProperty("product_title"), Keys.ENTER);
        JSUtils.JSclickWithTimeout(anpp.productCreated);
        //TS_08- User needs to click "add to cart"
        JSUtils.JSclickWithTimeout(pp.addToCartButton2);
        //TS_09- User needs to click shopping card icon ( right top corner shopping bag icon) and then click "view cart"button
        JSUtils.JSclickWithTimeout(hp.cart);
        JSUtils.JSclickWithTimeout(pp.viewCartButton);

    //VERIFICATION
        BrowserUtils.verifyElementDisplayed(anpp.productCreated);
        System.out.println("PASSED");

        Driver.closeDriver();
    }
}