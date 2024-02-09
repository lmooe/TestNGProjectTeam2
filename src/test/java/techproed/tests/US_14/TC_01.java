package techproed.tests.US_14;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.AddNewProductPage;
import techproed.pages.DashboardPage;
import techproed.pages.HomePage;
import techproed.pages.VendorPage;
import techproed.utilities.BrowserUtils;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TC_01 {

        //  US_14 "User should be able to see the options to add items as a Vendor
        //        (My Account > Store Manager > Product > Add New)"

        // Acceptance Criteria : There should be Simple Product, Variable Product, Grouped Product, External - Affiliate Product options.

        //  TC_01 - All the dropdown options (Simple Product, Variable Product, Grouped Product, External - Affiliate Product options)should be selectable.

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
    AddNewProductPage addNewProductPage = new AddNewProductPage();

        @Test
        public void TC_01() throws InterruptedException {
            //Given User should navigate to Allover Commerce url
            Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));


            HomePage homepage = new HomePage();
            //Click on sign in button
            BrowserUtils.clickWithTimeOut(homepage.singIn1,10);
            //Enter username into username/email box
            BrowserUtils.sendKeysWithTimeout(homepage.username,ConfigReader.getProperty("email"),10);
            //Enter password into password box
            BrowserUtils.sendKeysWithTimeout(homepage.password,ConfigReader.getProperty("password"),10);
            //Click on sign in button
            BrowserUtils.clickWithTimeOut(homepage.signInButton,10);

            //Click on sign out button
            BrowserUtils.clickWithTimeOut(homepage.signOut,10);
            //Click on user icon to navigate My Account page
            DashboardPage dashboardpage = new DashboardPage();
            //Click on Store Manager to navigate to store manager url
            BrowserUtils.clickWithTimeOut(dashboardpage.storeManager,10);
            //Click on Products option
            AddNewProductPage addNewProductPage = new AddNewProductPage();
            BrowserUtils.clickWithTimeOut(addNewProductPage.productsOption,10);
            //Click on Add New option
            BrowserUtils.clickWithTimeOut(addNewProductPage.addNewButton,10);



            //Verify Simple Product, Variable Product, Grouped Product, External - Affiliate Product options are available
            Select select = new Select(addNewProductPage.productTypeDropdown);
            List<WebElement> allOptions = select.getOptions();
            List<String> optionsNames =new ArrayList<>(Arrays.asList("Simple Product", "Variable Product", "Grouped Product", "External/Affiliate Product"));
            boolean isAllOptionsExist=false;
            int idx = 0;
            for (WebElement eachOption : allOptions){
                if (eachOption.getText().equals(optionsNames.get(idx))){
                    isAllOptionsExist=true;
                    idx++;
                }
            }
            Assert.assertTrue(isAllOptionsExist);


        }
        @AfterMethod
        public void tearDown(){
            Driver.closeDriver();
        }


    }














