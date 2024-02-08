package techproed.tests.US_14;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import techproed.pages.AddNewProductPage;
import techproed.pages.DashboardPage;
import techproed.pages.HomePage;
import techproed.utilities.BrowserUtils;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExtentReportUtils;

public class TC_02 {


        /*
        Given User should navigate to Allover Commerce url
        When Click on sign in button
        And Enter username into username/email box
        And Enter password into password box
        And Click on sign in button
        And Click on user icon to navigate My Account page
        And Click on Store Manager to navigate to store manager url
        And Click on Products option
        And Click on Add New option
        Then Verify Simple Product, Variable Product, Grouped Product, External - Affiliate Product options are available
         */
        HomePage homePage = new HomePage();
        DashboardPage dashboardPage = new DashboardPage();


        @Test
        public void TC_02() throws InterruptedException {
            //Given User should navigate to Allover Commerce url
            Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));


            HomePage homepage = new HomePage();
            //Click on sign in button
            BrowserUtils.clickWithTimeOut(homepage.singIn1, 10);
            //Enter username into username/email box
            BrowserUtils.sendKeysWithTimeout(homepage.username, ConfigReader.getProperty("email"), 10);
            //Enter password into password box
            BrowserUtils.sendKeysWithTimeout(homepage.password, ConfigReader.getProperty("password"), 10);
            //Click on sign in button
            BrowserUtils.clickWithTimeOut(homepage.signInButton, 10);

            //Click on sign out button
            BrowserUtils.clickWithTimeOut(homepage.signOut, 10);
            //Click on user icon to navigate My Account page
            DashboardPage dashboardpage = new DashboardPage();
            //Click on Store Manager to navigate to store manager url
            BrowserUtils.clickWithTimeOut(dashboardpage.storeManager, 10);
            //Click on Products option
            AddNewProductPage addNewProductPage = new AddNewProductPage();
            BrowserUtils.clickWithTimeOut(addNewProductPage.productsOption, 10);
            //Click on Add New option
            BrowserUtils.clickWithTimeOut(addNewProductPage.addNewButton, 10);
            Thread.sleep(2000);

            //   Click on dropdown to see all dropdown options
            BrowserUtils.clickWithTimeOut(addNewProductPage.productTypeDropdown, 10);

            //  Click on a space field to collapse dropdown menu
            BrowserUtils.clickWithTimeOut(addNewProductPage.spaceField, 10);

            //  Verify dropdown menu has collapsed
            Thread.sleep(2000);
            Select select = new Select(addNewProductPage.productTypeDropdown);
            Assert.assertNotEquals(select.getFirstSelectedOption().getText(), "Variable Product");

            //	Click on image display
            BrowserUtils.clickWithTimeOut(addNewProductPage.productImage, 10);

            //  Select an image file from computer
            String userHOME = System.getProperty("user.home");
            String pathOfFile = userHOME + "\\desktop\\image-70.jpg";
            addNewProductPage.selectFilesButton.sendKeys(pathOfFile);

            //  Click on select button to complete uploading image
            BrowserUtils.clickWithTimeOut(addNewProductPage.productImage, 10);

            // Verify image is displayed on the page
            Assert.assertTrue(addNewProductPage.removeImgButton.isDisplayed());


            Assert.assertTrue(addNewProductPage.removeGalleryImgButton.isDisplayed());
            ExtentReportUtils.passAndCaptureScreenshot("verified the uploaded image is displayed on the web page");


            //  Click on Submit button
            Thread.sleep(2000);
            BrowserUtils.clickWithTimeOut(addNewProductPage.productSubmitButton, 10);

        }

       @AfterClass
        public void tearDown() {
            //Driver.closeDriver();
        }
    }

