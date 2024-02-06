package techproed.tests.US_14;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.AddNewProductPage;
import techproed.pages.DashboardPage;
import techproed.pages.HomePage;
import techproed.pages.VendorPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;

import java.lang.reflect.Array;
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
        DashboardPage loginPage = new DashboardPage();
        VendorPage vendorMyAccountPage = new VendorPage();


        public void login() {
            //    User should navigate to Allover Commerce url https://allovercommerce.com/
            Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

            //    Click on sign in button
            HomePage.signIn.click();

            //    Enter username into username/email box
            HomePage.username.sendKeys(ConfigReader.getProperty("username: Vendor, Email Address: oz401@yahoo.com"));

            //    Enter password into password box
            HomePage.sendkeys(ConfigReader.getProperty(""));
        }
    }

