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
        JSUtils.JSclickWithTimeout(homePage.singIn1);
        homePage.username.sendKeys(ConfigReader.getProperty("email"));
        homePage.password.sendKeys(ConfigReader.getProperty("password"));
        homePage.signInButton.click();
        WaitUtils.waitFor(2);
    }

    @Test
    public void vendorCheckEditableInAddress(){
        //Search and add product
        homePage.searchBox.sendKeys(ConfigReader.getProperty("product2"), Keys.ENTER);

        WebElement leatherShoe = Driver.getDriver().findElement(By.linkText("Leather shoes"));
        JSUtils.JSclickWithTimeout(leatherShoe);
        WaitUtils.waitFor(2);

        productPage.plusButton.click();
        WaitUtils.waitFor(2);


        productPage.addToCartButton2.click();
        WaitUtils.waitFor(1);


        //Go to cart pop-up and click checkout button
        homePage.cart.click();
        WaitUtils.waitFor(2);
        checkOutPage.checkoutButton.click();

        //Check editable fields in billing address
        checkOutPage.billFirstName.clear();
        WaitUtils.waitFor(1);
        checkOutPage.billFirstName.sendKeys(ConfigReader.getProperty("vendorfirstname"));

        checkOutPage.billLastName.clear();
        WaitUtils.waitFor(1);
        checkOutPage.billLastName.sendKeys(ConfigReader.getProperty("vendorlastname"));

        Select selectCounty = new Select(checkOutPage.countryDropDown);
        selectCounty.selectByVisibleText("Canada");
        WaitUtils.waitFor(2);
        selectCounty.selectByVisibleText("United States (US)");

        checkOutPage.billAddressLine1.clear();
        WaitUtils.waitFor(1);
        checkOutPage.billAddressLine1.sendKeys(ConfigReader.getProperty("streetaddress"));

        checkOutPage.billTownCity.clear();
        WaitUtils.waitFor(1);
        checkOutPage.billTownCity.sendKeys(ConfigReader.getProperty("city"));

        checkOutPage.billZipPostCode.clear();
        WaitUtils.waitFor(1);
        checkOutPage.billZipPostCode.sendKeys(ConfigReader.getProperty("zipcode"));

        checkOutPage.billPhoneNumb.clear();
        WaitUtils.waitFor(1);
        checkOutPage.billPhoneNumb.sendKeys(ConfigReader.getProperty("phoneno"));

        checkOutPage.billEmail.clear();
        WaitUtils.waitFor(1);
        checkOutPage.billEmail.sendKeys(ConfigReader.getProperty("email"));

        WaitUtils.waitFor(2);
        Select selectCity = new Select(checkOutPage.stateDropdown);
        selectCity.selectByValue("NY");

        Driver.closeDriver();


    }
    }
