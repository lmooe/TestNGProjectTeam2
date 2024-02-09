package techproed.tests.US_18;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import techproed.pages.*;
import techproed.utilities.*;

public class TC_01 {

  //  HomePage homePage = new HomePage();
//    ProductPage productPage = new ProductPage();
//    CheckOutPage checkOutPage = new CheckOutPage();
//    DashboardPage dashboardPage = new DashboardPage();
//    CouponPage couponPage = new CouponPage();

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("allovercom_url"));

        HomePage homePage = new HomePage();

        //Sign in
        JSUtils.JSclickWithTimeout(homePage.singIn1);
        homePage.username.sendKeys(ConfigReader.getProperty("email"));
        homePage.password.sendKeys(ConfigReader.getProperty("password"));
        homePage.signInButton.click();
        WaitUtils.waitFor(2);
    }

    @Test
    public void vendorCreateCouponTest(){

        HomePage homePage = new HomePage();
        ProductPage productPage = new ProductPage();
        CheckOutPage checkOutPage = new CheckOutPage();
        DashboardPage dashboardPage = new DashboardPage();
        CouponPage couponPage = new CouponPage();


        JSUtils.JSclickWithTimeout(homePage.signOut);
        JSUtils.JSclickWithTimeout(dashboardPage.storeManager);
        JSUtils.JSclickWithTimeout(couponPage.couponsButton);
        JSUtils.JSclickWithTimeout(couponPage.addNewCouponButton);

        //fill the fields in coupon
        couponPage.codeField.sendKeys(ConfigReader.getProperty("code"));
        couponPage.descriptionField.sendKeys(ConfigReader.getProperty("description"));

        Select selectDiscType = new Select(couponPage.discountTypeDropdown);
        selectDiscType.selectByVisibleText("Percentage discount");
        couponPage.couponAmountField.sendKeys(ConfigReader.getProperty("couponamount"));
        couponPage.expireDateField.sendKeys(ConfigReader.getProperty("expiredate"));

        WaitUtils.waitFor(1);
        JSUtils.JSclickWithTimeout(couponPage.allowFreeShippingCheckBox);
        WaitUtils.waitFor(1);
        JSUtils.JSclickWithTimeout(couponPage.showOnStoreCheckBox);


        couponPage.minimumAmount.sendKeys(ConfigReader.getProperty("minspend"));
        WaitUtils.waitFor(1);
        couponPage.maximumAmount.sendKeys(ConfigReader.getProperty("maxspend"));
        WaitUtils.waitFor(1);
        Select selectProducts = new Select(couponPage.productCategoriesDropDown);
        selectProducts.selectByVisibleText("Bags");
        selectProducts.selectByVisibleText("Kitchen");
        WaitUtils.waitFor(1);
        selectProducts.selectByValue("370");

        Select selectExcludeProducts = new Select(couponPage.excludeCategoriesDropDown);
        selectExcludeProducts.selectByVisibleText("Home Decoration");
        WaitUtils.waitFor(1);

        JSUtils.JSclickWithTimeout(couponPage.submitButton);

        //Assert the coupon exists
        JSUtils.JSclickWithTimeout(couponPage.couponsButton);
        Assert.assertTrue(couponPage.couponName.getText().contains("SUMMER2024"));

        //Close Driver
        Driver.closeDriver();




    }

}
