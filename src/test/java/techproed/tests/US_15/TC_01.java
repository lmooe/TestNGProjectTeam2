package techproed.tests.US_15;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.AddNewProductPage;
import techproed.pages.DashboardPage;
import techproed.pages.HomePage;
import techproed.utilities.BrowserUtils;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
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
        //PC_1- User must be landed on valid url
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));

        //PC_2- Sign in with given credentials
        HomePage hp = new HomePage();
        BrowserUtils.clickWithTimeOut(hp.singIn1,1);
        BrowserUtils.sendKeysWithTimeout(hp.username,ConfigReader.getProperty("email"),1);
        BrowserUtils.sendKeysWithTimeout(hp.password,ConfigReader.getProperty("password"),1);
        BrowserUtils.clickWithTimeOut(hp.signInButton,1);

        //PC_3- than must land on to Store Manager from My Account.
        BrowserUtils.clickWithTimeOut(hp.signOut,1);
        DashboardPage dbp = new DashboardPage();
        BrowserUtils.clickWithTimeOut(dbp.storeManager,1);
        AddNewProductPage anpp = new AddNewProductPage();
        BrowserUtils.clickWithTimeOut(anpp.productsOption,1);
        BrowserUtils.clickWithTimeOut(anpp.addNewButton,1);

        //PC_4- User must enter valid product title, product image, gallery image, product category
            //product title
//            BrowserUtils.sendKeysWithTimeout(anpp.productTitleInput, ConfigReader.getProperty("product_title"),1);
//            //product image for display
//            String newProductImage = "C:\\Users\\paulr\\IdeaProjects\\TestNGProjectTeam2\\Resources\\images\\images.jpg";
//            BrowserUtils.clickWithTimeOut(anpp.addDisplayPhotoIcon,1);
//            BrowserUtils.sendKeysWithTimeout(anpp.selectFilesButton, newProductImage, 1);
//            BrowserUtils.clickWithTimeOut(anpp.selectToUploadButton,1);

// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> look at here later <<<<<<<<<<<<<<<<<<<
            //product image for gallery
      //  BrowserUtils.clickWithTimeOut(anpp.addGalleryPhotoIcon,1);
//            BrowserUtils.sendKeysWithTimeout(anpp.addGalleryPhotoIcon, newProductImage, 1);
//            BrowserUtils.clickWithTimeOut(anpp.addToGalleryButton,1);

//  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> look at here later <<<<<<<<<<<<<<<<<<<

//            //product category
//            Select selectCategory = new Select((WebElement) anpp.categoriesCheckboxList);
//            selectCategory.selectByVisibleText(ConfigReader.getProperty("product_category"));
//
//
//            //BrowserUtils.dropdownSelectByValue(anpp.categoriesCheckboxList, ConfigReader.getProperty("product_category"));

        //TS_1- The user needs to verify the visibility of the Inventory, Shipping, Attributes, Linked, SEO, and Advanced menus
        BrowserUtils.verifyElementDisplayed(anpp.menuInventory);
        BrowserUtils.verifyElementDisplayed(anpp.menuShipping);
        BrowserUtils.verifyElementDisplayed(anpp.menuAttributes);
        BrowserUtils.verifyElementDisplayed(anpp.menuLinked);
        BrowserUtils.verifyElementDisplayed(anpp.menuSeo);
        BrowserUtils.verifyElementDisplayed(anpp.menuAdvanced);

//        //TS_2- The user needs to click on "Inventory" and must see related section is visible needs to enter valid data to SKU
//        //field, click to Manage Stock box, enter valid data to Stock Qty field, click to Sold Individually box
        BrowserUtils.clickWithTimeOut(anpp.menuInventory,1);
        BrowserUtils.verifyElementDisplayed(anpp.sku);
        BrowserUtils.sendKeysWithTimeout(anpp.sku, ConfigReader.getProperty("SKU_field"),1);
//
////       if(!anpp.manageStock.isSelected()){
////           BrowserUtils.clickWithTimeOut(anpp.manageStock,1);
////       }
////
//////        Thread.sleep(5000);
//////        anpp.manageStock.click();
////        BrowserUtils.sendKeysWithTimeout(anpp.stockQuantity, ConfigReader.getProperty("Stock_Qty"),1);
////           BrowserUtils.clickWithTimeOut(anpp.soldIndividually,1);


        //TS_3- The user needs to click on "Shipping" and must see related section is visible and needs to enter valid data to
        //     Weight, Dimensions (Length, Width, Height) fields. User needs to select valid options of Shipping class and
        //     Processing Time dropdown lists.
       BrowserUtils.clickWithTimeOut(anpp.menuShipping,1);
//        BrowserUtils.verifyElementDisplayed(anpp.weight);
//        BrowserUtils.sendKeysWithTimeout(anpp.weight, ConfigReader.getProperty("Weight"),1);
//        BrowserUtils.sendKeysWithTimeout(anpp.length, ConfigReader.getProperty("Length"),1);
//        BrowserUtils.sendKeysWithTimeout(anpp.width, ConfigReader.getProperty("Width"),1);
//        BrowserUtils.sendKeysWithTimeout(anpp.height, ConfigReader.getProperty("Height"),1);
//        Select dropdownProcessingTime = new Select(anpp.processingTime);
//        dropdownProcessingTime.selectByVisibleText(ConfigReader.getProperty("Processing_Time"));



        //TS_4- The user needs to click on "Attributes" and must see related section is visible and needs to click Color
        //    and Size boxes, and choose given data in color and size sections

        BrowserUtils.clickWithTimeOut(anpp.menuAttributes,1);










    }
}
