package techproed.tests.US_15;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.AddNewProductPage;
import techproed.pages.DashboardPage;
import techproed.pages.HomePage;
import techproed.utilities.*;

import java.util.List;

public class TC_02 {

          /*Task:

    Pre-cond:
    1- User must be landed on valid url,
    2- Sign in with given credentials,
    3- than must land on to Store Manager from My Account. User must click "Product" on left sidebar and then "Add New"
    4- User must enter valid product title, product image, gallery image, product category

    Test Steps:
    1- The user needs to verify the visibility of the Inventory, Shipping, Attributes, Linked, SEO, and Advanced menus
    2- The user needs to click on "Inventory" and must see related section is visible, than enter unique
       SKU, click to Manage Stock box, leave empty of Stock Qty field
    3- The user needs to click on "Shipping" and must see related section is visible and needs to leave empty Weight,
        Dimensions (Length, Width, Height) fields. User needs to select valid options of Shipping class and  Processing
        Time must choose "Ready to ship in"
    4- The user needs to click on "Attributes" and must see related section is visible and confirm that Color and Size
        boxes are not selected
    5- The user needs to click submit button

    Excepted result: User must couldn't be able to publish the product


    */

        HomePage hp = new HomePage();
        DashboardPage dbp = new DashboardPage();
        AddNewProductPage anpp = new AddNewProductPage();
        Faker fake = new Faker();

        @Test
        public void TC_02() throws InterruptedException {
            //PC_1- User must be landed on valid url
            Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));

            //PC_2- Sign in with given credentials
            BrowserUtils.clickWithTimeOut(hp.singIn1, 1);
            BrowserUtils.sendKeysWithTimeout(hp.username, ConfigReader.getProperty("email"), 1);
            BrowserUtils.sendKeysWithTimeout(hp.password, ConfigReader.getProperty("password"), 1);
            BrowserUtils.clickWithTimeOut(hp.signInButton, 1);

            //PC_3- than must land on to Store Manager from My Account.
            BrowserUtils.clickWithTimeOut(hp.signOut, 1);
            BrowserUtils.clickWithTimeOut(dbp.storeManager, 1);
            BrowserUtils.clickWithTimeOut(anpp.productsOption, 1);
            BrowserUtils.clickWithTimeOut(anpp.addNewButton, 1);

            //PC_4- User must enter valid product title, product image, gallery image, product category
            //product title
            BrowserUtils.sendKeysWithTimeout(anpp.productTitleInput, ConfigReader.getProperty("product_title"), 3);
            //product image for display
            //String newProductImage = "C:\\Users\\paulr\\IdeaProjects\\TestNGProjectTeam2\\Resources\\images\\images.jpg";
            String newProductImage = System.getProperty("user.dir")+"/src/main/resources/images/images.jpg";
            BrowserUtils.clickWithTimeOut(anpp.addDisplayPhotoIcon, 10);
            BrowserUtils.sendKeysWithTimeout(anpp.selectFilesButton, newProductImage, 10);
            Thread.sleep(3000);
            BrowserUtils.clickWithTimeOut(anpp.selectToUploadButton, 10);
            Thread.sleep(2000);

            //product image for gallery
            BrowserUtils.clickWithTimeOut(anpp.addGalleryPhotoIcon,10);
            Thread.sleep(3000);
            anpp.uploadFiles.click();
            BrowserUtils.sendKeysWithTimeout(anpp.selectFilesButton, newProductImage, 10);
            Thread.sleep(3000);
            BrowserUtils.clickWithTimeOut(anpp.addToGalleryButton,10);
            Thread.sleep(3000);

            //product category
            JSUtils.JSclickWithTimeout(anpp.categoryboxTarhana);
            Thread.sleep(2000);

            //TS_1- The user needs to verify the visibility of the Inventory, Shipping, Attributes, Linked, SEO, and Advanced menus
            BrowserUtils.verifyElementDisplayed(anpp.menuInventory);
            BrowserUtils.verifyElementDisplayed(anpp.menuShipping);
            BrowserUtils.verifyElementDisplayed(anpp.menuAttributes);
            BrowserUtils.verifyElementDisplayed(anpp.menuLinked);
            BrowserUtils.verifyElementDisplayed(anpp.menuSeo);
            BrowserUtils.verifyElementDisplayed(anpp.menuAdvanced);


            //TS_2- The user needs to click on "Inventory" and must see related section is visible, then needs enter unique
            //      SKU, click to Manage Stock box, leave empty of Stock Qty field
            BrowserUtils.clickWithTimeOut(anpp.menuInventory,1);
 //           BrowserUtils.verifyElementDisplayed(anpp.sku);
            BrowserUtils.sendKeysWithTimeout(anpp.sku,fake.number().digits(6),5);
//            if(!anpp.manageStock.isSelected()){
//                BrowserUtils.clickWithTimeOut(anpp.manageStock,5);
//            }
//            anpp.stockQuantity.clear();

            //TS_3- The user needs to click on "Shipping" and must see related section is visible and needs to leave empty Weight,
            //        Dimensions (Length, Width, Height) fields. User needs to select valid options of Shipping class and  Processing
            //        Time must choose "Ready to ship in"
            BrowserUtils.clickWithTimeOut(anpp.menuShipping,5);
 //           BrowserUtils.verifyElementDisplayed(anpp.weight);
            anpp.weight.clear();
            anpp.length.clear();
            anpp.width.clear();
            anpp.height.clear();
            Select dropdownProcessingTime = new Select(anpp.processingTime);
            dropdownProcessingTime.getFirstSelectedOption();
            Thread.sleep(2000);


            //TS_4- The user needs to click on "Attributes" and must see related section is visible and confirm that Color and Size
            //        boxes are not selected
            BrowserUtils.clickWithTimeOut(anpp.menuAttributes,5);
            if (anpp.colorSelectBox.isSelected()) {
                BrowserUtils.clickWithTimeOut(anpp.colorSelectBox, 5);
            }
            if (anpp.sizeSelectBox.isSelected()) {
                BrowserUtils.clickWithTimeOut(anpp.sizeSelectBox, 5);
            }

            //TS_5- The user needs to click submit button
            BrowserUtils.clickWithTimeOut(anpp.productSubmitButton,5);
            Thread.sleep(2000);

            //VERIFICATION
            Assert.assertFalse(anpp.published.isDisplayed());  //OR Assert.assertTrue(!anpp.published.getText().contains("Published"));
            System.out.println("US_15 TC_2 is Failed!!!-bug-");

            Driver.closeDriver();

        }

















    }




