package techproed.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;

import java.util.List;

public class AddNewProductPage{


    public AddNewProductPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(partialLinkText = "Products")
    public WebElement productsOption;

    @FindBy(xpath = "//span[text()='Add New']")
    public WebElement addNewButton;

    @FindBy(id = "product_type")
    public WebElement productTypeDropdown;

    @FindBy(id = "main")
    public WebElement spaceField;

    @FindBy(xpath = "//option[text()='Variable Product']")
    public WebElement variableProductOption;

    @FindBy(id = "featured_img_display")
    public WebElement addDisplayPhotoIcon;

//    @FindBy(id = "__wp-uploader-id-1")
//    public WebElement selectFilesButton;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement selectFilesButton;

    @FindBy(xpath = "//button[text()='Select']")
    public WebElement selectToUploadButton;

    @FindBy(id = "featured_img_remove_button")
    public WebElement removeImgButton;

    @FindBy(id = "gallery_img_gimage_0_display")
    public WebElement addGalleryPhotoIcon;

    @FindBy (xpath = "(//button[text()='Upload files'])[2]")
    public WebElement uploadFiles;

//    @FindBy(xpath = "//button[text()='Add to Gallery']")
//    public WebElement addToGalleryButton;

    @FindBy(xpath = "(//button[text()='Add to Gallery'])[2]")
    public WebElement addToGalleryButton;

    @FindBy(id = "gallery_img_gimage_0_remove_button")
    public WebElement removeGalleryImgButton;

    @FindBy(id = "wcfm_products_simple_submit_button")
    public WebElement productSubmitButton;

    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']")
    public List<WebElement> errorMessageRequiredFields;

    @FindBy(id = "pro_title")
    public WebElement productTitleInput;

    @FindBy(xpath = "(//body[@id='tinymce'])[1]")
    public WebElement shortDescriptionInput;

    @FindBy(xpath = "//body[@id='tinymce']")
    public WebElement descriptionInput;

    @FindBy(xpath = "//*[@id='tinymce']/p")
    public WebElement verifyTextOfDescription;

    @FindBy(xpath = "//*[@id='product_cats_checklist']/li/input")
    public List<WebElement> categoriesCheckboxList;

    @FindBy(xpath = "//input[@value='1283']")
    public WebElement categoryboxTarhana;

    @FindBy(xpath = "//*[.='+Add new category']")
    public List<WebElement> addNewCategory;

    @FindBy(id = "wcfm_new_cat")
    public WebElement categoryNameInput;

    @FindBy(xpath = "(//button[text()='Add'])[1]")
    public WebElement addCategoryNameButton;

    @FindBy(xpath = "//*[@id='product_cats_checklist']/li/span[2]")
    public List<WebElement> allMainCategoryNames;

    @FindBy(id = "wcfm_new_parent_cat")
    public WebElement categorySectionDropdown;

    /////not sure:
    @FindBy(xpath = "//ul[@id='product_cats_checklist']/li")
    public List<WebElement> categorySelectOptions;

    @FindBy(xpath = "//input[@name='product_cats[]']")
    public List<WebElement> categoryCheckbox;

//    @FindBy(xpath = "//ul[@id='product_cats_checklist']/li")
//    private List<WebElement> selectCategoriesOptions;

//    public void selectCategories(String desiredValue) {
//        for (WebElement category : selectCategoriesOptions) {
//            String categoryValue =category.getText();
//            if (categoryValue.equals(desiredValue)) {
//                JSUtils.JSclickWithTimeout(category);
//                break;
//            }
//        }
//    }


    @FindBy (id = "regular_price")
    public WebElement priceField;
    @FindBy (id = "sale_price")
    public WebElement salePriceField;

    @FindBy(xpath = " //*[@id='product_cats_checklist']/li/ul/li/span")
    public List<WebElement> allSubCategoryNames;

    @FindBy(xpath = "//*[@id='product_brand']/li/input")
    public List<WebElement> brandsCheckboxList;

    @FindBy(xpath = "//*[.='+Add new Product brands']")
    public WebElement addNewProductBrandsButton;

    @FindBy(id = "wcfm_new_product_brand")
    public WebElement brandNameInput;

    @FindBy(xpath = "(//button[text()='Add'])[2]")
    public WebElement addBrandNameButton;

    @FindBy(xpath = "//*[@id='product_brand']/li")
    public List<WebElement> allBrandNames;

    @FindBy(id = "wcfm_new_parent_product_brand")
    public WebElement brandSectionsDropdown;

    @FindBy(xpath = "//*[@id='product_brand']/li/ul/li")
    public List<WebElement> allSubBrandNames;

    @FindBy(id = "product_tags")
    public WebElement productTagsInput;

    @FindBy(id = "catalog_visibility")
    public WebElement catalogVisibilityDropdown;

//    @FindBy(xpath = "//*[@id='catalog_visibility']/option")
//    public List<WebElement> allCatVisibilityDropdownOptions;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FindBy (id = "is_virtual")
    public WebElement virtualBox;

    @FindBy (id = "is_downloadable")
    public WebElement downloadBox;

    public static void radioClickByProducCategorytIndex(int index){
        int numOfRadio =Driver.getDriver().findElements(By.xpath("//ul[@id='product_cats_checklist']/li")).size();
        for (int i=0;i<numOfRadio;i++){
            if (!Driver.getDriver().findElements(By.xpath("//ul[@id='product_cats_checklist']/li")).get(index).isSelected()) {
                Driver.getDriver().findElements(By.xpath("//ul[@id='product_cats_checklist']/li")).get(index).click();
            }
        }
    }

//Inventory Section

    @FindBy (xpath = "//div[text()='Inventory']")
    public WebElement menuInventory;

    @FindBy (id = "sku")
    public WebElement sku;

    @FindBy (id = "manage_stock")
    public WebElement manageStock;

    @FindBy(id = "stock_qty")
    public WebElement stockQuantity;

    @FindBy(id = "sold_individually")
    public WebElement soldIndividually;


//Shipping Section

    @FindBy (xpath = "//div[text()='Shipping']")
    public WebElement menuShipping;

    @FindBy (id = "weight")
    public WebElement weight;

    @FindBy (id = "length")
    public WebElement length;

    @FindBy (id = "width")
    public WebElement width;

    @FindBy (id = "height")
    public WebElement height;

    @FindBy(id = "_wcfmmp_processing_time" )
    public WebElement processingTime;

// Attributes Section

    @FindBy (xpath = "//div[text()='Attributes']")
    public WebElement menuAttributes;

    @FindBy (id = "attributes_is_active_1")
    public WebElement colorSelectBox;

    @FindBy (id = "attributes_is_active_2")
    public WebElement sizeSelectBox;

    @FindBy (xpath = "(//li[@class='select2-search select2-search--inline'])[2]")
    public WebElement colorType;

    @FindBy (xpath = "(//li[@class='select2-search select2-search--inline'])[3]")
    public WebElement sizeType;

//
    @FindBy (xpath = "(//div[@class='page_collapsible_content_holder'])[7]")
    public WebElement menuLinked;

    @FindBy (xpath = "(//div[@class='page_collapsible_content_holder'])[8]")
    public WebElement menuSeo;

    @FindBy (xpath = "(//div[@class='page_collapsible_content_holder'])[10]")
    public WebElement menuAdvanced;

//

    @FindBy (xpath = "//span[@class='product-status product-status-publish' and text()='Published']")
    public WebElement published;



}







