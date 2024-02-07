package techproed.tests.US_18;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import techproed.pages.*;
import techproed.utilities.*;

public class TC_02 {

    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    DashboardPage dashboardPage = new DashboardPage();
    CouponPage couponPage = new CouponPage();

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
    public void vendorCreateCouponTest(){

        JSUtils.JSclickWithTimeout(homePage.signOut);
        JSUtils.JSclickWithTimeout(dashboardPage.storeManager);
        JSUtils.JSclickWithTimeout(couponPage.couponsButton);
        JSUtils.JSclickWithTimeout(couponPage.addNewCouponButton);

        //fill the fields in coupon (except code field)
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
        WaitUtils.waitFor(1);

        //Assert the error message exists
        Assert.assertTrue(couponPage.errorMessage.getText().contains("Please insert atleast Coupon Title before submit."));

        //Close Driver
        Driver.closeDriver();




    }

}
