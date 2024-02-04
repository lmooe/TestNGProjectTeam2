package techproed.tests.US_15;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.AddNewProductPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import org.openqa.selenium.support.ui.Select;

public class TC_01 {

    AddNewProductPage product=new AddNewProductPage();
    Select select=new Select(product.processingTime);

    @Test
    public void test1(){
        select.selectByIndex(2);

    }
}
