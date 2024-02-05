package techproed.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class VendorPage {

    public void VendorPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "user_email")
    public WebElement vendorRegistrationEmail;

    @FindBy (name = "wcfm_email_verified_input")
    public WebElement vendorVerificationCode;

    @FindBy (name = "wcfm_email_verified_button")
    public WebElement vendorResendCode;

    @FindBy (id = "wcfm_membership_register_button")
    public WebElement vendorConfirmButton;

    @FindBy (xpath = "//*[@id='wcfm_membership_registration_form_expander']/div[2]")
    public WebElement vendorVerifyMessage;



}
