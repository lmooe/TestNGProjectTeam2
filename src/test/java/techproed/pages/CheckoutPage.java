package techproed.pages;

import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class CheckoutPage {

    public CheckoutPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
