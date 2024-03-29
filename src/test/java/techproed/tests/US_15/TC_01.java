package techproed.tests.US_15;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import techproed.pages.AddNewProductPage;
import techproed.pages.DashboardPage;
import techproed.pages.HomePage;
import techproed.utilities.*;
import org.openqa.selenium.support.ui.Select;

public class TC_01 {


    /*Task:

    Pre-cond:
    1- User must be landed on valid url,
    2- Sign in with given credentials,
    3- than must land on to Store Manager from My Account. User must click "Product" on left sidebar and then "Add New"
    4- User must enter valid product title, product image, gallery image, product category

    Test Steps:
    1- The user needs to verify the visibility of the Inventory, Shipping, Attributes, Linked, SEO, and Advanced menus
    2- The user needs to click on "Inventory" and must see related section is visible needs to enter valid data to SKU
    field, click to Manage Stock box, enter valid data to Stock Qty field, click to Sold Individually box
    3- The user needs to click on "Shipping" and must see related section is visible and needs to enter valid data to
     Weight, Dimensions (Length, Width, Height) fields. User needs to select valid options of Shipping class and
     Processing Time dropdown lists.
    4- The user needs to click on "Attributes" and must see related section is visible and needs to click Color
    and Size boxes, and choose given data in color and size sections
    5- The user needs to click submit button

    Excepted result: User must publish the product

    */



    @Test
    public void TC_01() throws InterruptedException {

        HomePage hp = new HomePage();
        DashboardPage dbp = new DashboardPage();
        AddNewProductPage anpp = new AddNewProductPage();
        Faker fake = new Faker();

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
       // String newProductImage = "C:\\Users\\paulr\\IdeaProjects\\TestNGProjectTeam2\\Resources\\images\\images.jpg";
        String newProductImage = System.getProperty("user.dir")+"/src/main/resources/images/images.jpg";
        BrowserUtils.clickWithTimeOut(anpp.addDisplayPhotoIcon, 10);
        BrowserUtils.sendKeysWithTimeout(anpp.selectFilesButton, newProductImage, 10);
        Thread.sleep(3000);
        BrowserUtils.clickWithTimeOut(anpp.selectToUploadButton, 10);
        Thread.sleep(2000);

        //product image for gallery
          BrowserUtils.clickWithTimeOut(anpp.addGalleryPhotoIcon,10);
        Thread.sleep(3000);
        JSUtils.JSclickWithTimeout(anpp.uploadFiles);
        Thread.sleep(3000);
       //  anpp.uploadFiles.click();
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

            //TS_2- The user needs to click on "Inventory" and must see related section is visible needs to enter valid data to SKU
            //field, click to Manage Stock box, enter valid data to Stock Qty field, click to Sold Individually box
            BrowserUtils.clickWithTimeOut(anpp.menuInventory,1);
            BrowserUtils.verifyElementDisplayed(anpp.sku);
            BrowserUtils.sendKeysWithTimeout(anpp.sku,fake.number().digits(6) ,5);
            if(!anpp.manageStock.isSelected()){
                BrowserUtils.clickWithTimeOut(anpp.manageStock,5);
            }
            anpp.stockQuantity.clear();
            BrowserUtils.sendKeysWithTimeout(anpp.stockQuantity, ConfigReader.getProperty("Stock_Qty"),5);
            BrowserUtils.clickWithTimeOut(anpp.soldIndividually,5);
            Thread.sleep(2000);


            //TS_3- The user needs to click on "Shipping" and must see related section is visible and needs to enter valid data to
            //     Weight, Dimensions (Length, Width, Height) fields. User needs to select valid options of Shipping class and
            //     Processing Time dropdown lists.
            BrowserUtils.clickWithTimeOut(anpp.menuShipping,5);
            BrowserUtils.sendKeysWithTimeout(anpp.weight, ConfigReader.getProperty("Weight"),5);
            BrowserUtils.sendKeysWithTimeout(anpp.length, ConfigReader.getProperty("Length"),5);
            BrowserUtils.sendKeysWithTimeout(anpp.width, ConfigReader.getProperty("Width"),5);
            BrowserUtils.sendKeysWithTimeout(anpp.height, ConfigReader.getProperty("Height"),5);
            Select dropdownProcessingTime = new Select(anpp.processingTime);
            dropdownProcessingTime.selectByVisibleText(ConfigReader.getProperty("Processing_Time"));
            Thread.sleep(2000);


            //TS_4- The user needs to click on "Attributes" and must see related section is visible and needs to click Color
            //    and Size boxes, and choose given data in color and size sections
            BrowserUtils.clickWithTimeOut(anpp.menuAttributes,5);
            BrowserUtils.clickWithTimeOut(anpp.colorSelectBox,5);
            Thread.sleep(2000);
//            BrowserUtils.sendKeysWithTimeout(anpp.colorType, ConfigReader.getProperty("Color"),10);
//            Thread.sleep(3000);
//            BrowserUtils.clickWithTimeOut(anpp.sizeSelectBox,1);
//            Thread.sleep(2000);
//            BrowserUtils.sendKeysWithTimeout(anpp.sizeType, ConfigReader.getProperty("Size"),5);
//            Thread.sleep(2000);

            //TS_5- The user needs to click submit button
            BrowserUtils.clickWithTimeOut(anpp.productSubmitButton,5);
            Thread.sleep(2000);

        //VERIFICATION
        Assert.assertTrue(anpp.published.isDisplayed());  //OR Assert.assertTrue(anpp.published.getText().contains("Published"));
        System.out.println("US_15 TC_1 is passed!!!");

        Driver.closeDriver();


        }






}
