package techproed.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.pages.LoginPage;
import techproed.utilities.Driver;

public class test1 {

    DashboardPage dashboardPage = new DashboardPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void allOverTest1(){

        Driver.getDriver().get("https://allovercommerce.com/");

        loginPage.singin.click();
        WebElement userName = loginPage.username;
        userName.sendKeys("oz401@yahoo.com");

        WebElement passWord = loginPage.password;
        passWord.sendKeys("vendoraccount123");

        loginPage.signButtoN.click();

        loginPage.signOut.click();


        dashboardPage.accountDetailsButton.click();






    }




}
