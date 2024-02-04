package techproed.tests.US_13;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TC_01 {
    package techproed.pages;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

    public class AddNewProductPage {


        @FindBy(xpath = "//*[@id='product_type']")
        public WebElement SimpleProduct;

        @FindBy(xpath = "//*[@id='product_type']")
        public WebElement VariableProduct;

        @FindBy(xpath = "//*[@id='product_type']")
        public WebElement GroupedProduct;

        @FindBy(xpath = "//*[@id='product_type']")
        public WebElement ExternalAffiliateProduct;

        @FindBy(xpath = "//*[@id='featured_img_display']")
        public WebElement ProductImage;


        @FindBy(xpath = "//*[@id='gallery_img_gimage_0_display']")
        public WebElement addnewproductgallery;

        @FindBy(xpath = "//*[@id='is_virtual']")
        public WebElement checkboxvirtual;

        @FindBy(xpath = "//*[@id='is_downloadable']")
        public WebElement checkboxdownloadable;



        @FindBy(xpath = "//*[@id='pro_title']")
        public WebElement producttitle;


        @FindBy(xpath = "//[@id='regular_price']")
        public WebElement regularprice;

        @FindBy(xpath = "//[@id='sale_price']")
        public WebElement saleprice;

        @FindBy(xpath = "//[@id='wp-excerpt-wrap']")
        public WebElement Shortdescription;

        @FindBy(xpath = "//[@id='wp-description-wrap']")
        public WebElement description;

        @FindBy(xpath = "//[@id='product_cats_checklist']")
        public WebElement categories;

        @FindBy(xpath = "//[@id='wp-product_brand']")
        public WebElement productbrands;










    }
}