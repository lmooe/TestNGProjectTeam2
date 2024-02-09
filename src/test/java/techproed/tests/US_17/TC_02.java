package techproed.tests.US_17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import techproed.pages.*;
import techproed.utilities.*;

public class TC_02 {

    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    CheckOutPage checkOutPage = new CheckOutPage();


    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));

        //Sign in
        WaitUtils.waitFor(5);
        JSUtils.JSclickWithTimeout(homePage.singIn1);
        homePage.username.sendKeys(ConfigReader.getProperty("email"));
        homePage.password.sendKeys(ConfigReader.getProperty("password"));
        JSUtils.JSclickWithTimeout(homePage.signInButton);
        WaitUtils.waitFor(5);
    }

    @Test
    public void vendorCheckEditableInAddress(){
        //Search and add product
        homePage.searchBox.sendKeys(ConfigReader.getProperty("product2"), Keys.ENTER);

        WebElement leatherShoe = Driver.getDriver().findElement(By.linkText("Leather shoes"));
        JSUtils.JSclickWithTimeout(leatherShoe);
        WaitUtils.waitFor(5);

        JSUtils.JSclickWithTimeout(productPage.plusButton);
        WaitUtils.waitFor(5);


        JSUtils.JSclickWithTimeout(productPage.addToCartButton2);
        WaitUtils.waitFor(5);


        //Go to cart pop-up and click checkout button
        JSUtils.JSclickWithTimeout(homePage.cart);
        WaitUtils.waitFor(5);
        JSUtils.JSclickWithTimeout(checkOutPage.checkoutButton);

        //Check editable fields in billing address
        checkOutPage.billFirstName.clear();
        WaitUtils.waitFor(5);
        checkOutPage.billFirstName.sendKeys(ConfigReader.getProperty("vendorfirstname"));

        checkOutPage.billLastName.clear();
        WaitUtils.waitFor(5);
        checkOutPage.billLastName.sendKeys(ConfigReader.getProperty("vendorlastname"));

        Select selectCounty = new Select(checkOutPage.countryDropDown);
        selectCounty.selectByVisibleText("Canada");
        WaitUtils.waitFor(5);
        selectCounty.selectByVisibleText("United States (US)");

        checkOutPage.billAddressLine1.clear();
        WaitUtils.waitFor(5);
        checkOutPage.billAddressLine1.sendKeys(ConfigReader.getProperty("streetaddress"));

        checkOutPage.billTownCity.clear();
        WaitUtils.waitFor(5);
        checkOutPage.billTownCity.sendKeys(ConfigReader.getProperty("city"));

        checkOutPage.billZipPostCode.clear();
        WaitUtils.waitFor(5);
        checkOutPage.billZipPostCode.sendKeys(ConfigReader.getProperty("zipcode"));

        checkOutPage.billPhoneNumb.clear();
        WaitUtils.waitFor(5);
        checkOutPage.billPhoneNumb.sendKeys(ConfigReader.getProperty("phoneno"));

        checkOutPage.billEmail.clear();
        WaitUtils.waitFor(5);
        checkOutPage.billEmail.sendKeys(ConfigReader.getProperty("email"));

        WaitUtils.waitFor(5);
        Select selectCity = new Select(checkOutPage.stateDropdown);
        selectCity.selectByValue("NY");

        Driver.closeDriver();


    }
    }
