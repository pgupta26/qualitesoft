package com.qualitesoft.channelgatesip.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import com.qualitesoft.core.WaitTool;

public class ProductListing {

	WebDriver driver;
	public ProductListing(WebDriver driver){
		this.driver = driver;		
	}

	public WebElement dialogTitle(){
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//h4[contains(@id,'dialog-help-intro')]"), 180);
		return webElement;
	}

	public WebElement skipTourBtn(){
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//h4[contains(@id,'dialog-help-intro')]//following::button)[1]"), 60);
		return webElement;
	}
	
	//***********************************Set Vendor ***************************************
	
	public WebElement clickOnVendorDropdown(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[@id='select2-vendorSelect-container']"), 180);		
	}
	
	public WebElement searchVendorNameOnDropdown(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[contains(@class,'select2-search--dropdown')]//input[@type='search']"), 60);		
	}
	
	public WebElement selectVendorName(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//ul[@id='select2-vendorSelect-results']//li"), 60);		
	}
	
	//********************Product Listing page*************************
	
	public WebElement exportContentScoreBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[text()='Export Content Score ']"), 60);	
	}
	
	public WebElement exportProductsBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[contains(text(),'Export Products')]"), 60);	
	}
	
	public WebElement bulkActionsBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[contains(text(),'Bulk Actions')]"), 60);	
	}
	
	public WebElement downloadTemplateLink(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='text-underline']"), 60);	
	}
	
	public WebElement searchByBrandField(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@type='search' and @class='select2-search__field']"), 60);	
	}
	
	public WebElement selectBrand(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//ul[@id='select2-brandsSelect-results']//li"), 60);	
	}
	
	public boolean selectedBrandName(){
		return WaitTool.isElementPresentAndDisplay(driver, By.xpath("//ul[@class='select2-selection__rendered']//li[@title='Test 3']"));	
	}	
	
	public WebElement searchBySkuAndProductIdField(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@type='search' and @onfocusclass='form-group']"), 120);	
	}
	
	public WebElement goBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='input-group-append']//button"), 60);	
	}
	
	public WebElement filterBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='input-group-prepend']//button"), 60);	
	}
	
	public WebElement filterOptions(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@name='filterOptions']"), 60);	
	}
	
	public WebElement filterOptionValues(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@name='filterOptionsValues']"), 60);	
	}
	
	public WebElement applyFilterBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[contains(text(),'Apply Filter')]"), 60);	
	}
	
	public WebElement applyFilterLabel(int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//ul[@class='ui-tags active-filters']//li)["+index+"]"), 60);	
	}
	
	public WebElement newProductBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@routerlink='/app/vendor/product/']"), 60);	
	}
	
	public WebElement getTableData(int rowNum, int colNum){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("((//datatable-body[@class='datatable-body']//div[contains(@class,'center datatable-row-group')])["+rowNum+"]//div)["+colNum+"]"), 180);	
	}
	
	public WebElement productTitle(int rowNum, int colNum){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("((//datatable-body[@class='datatable-body']//div[contains(@class,'center datatable-row-group')])["+rowNum+"]//div)["+colNum+"]//a"), 60);	
	}
	
	public List<WebElement> getCountOfRows(){
		return driver.findElements(By.xpath("//div[@class='visible']//datatable-body//datatable-body-row"));
		//return WaitTool.waitForElementsPresentAndDisplay(driver, By.tagName("datatable-body-row"), 60);
		//return WaitTool.waitForElementsPresentAndDisplay(driver, By.xpath("//datatable-body-row[contains(@class,'datatable-body-row')]"), 60);
		//return WaitTool.waitForElementsPresentAndDisplay(driver, By.xpath("//div[contains(@class,'center datatable-row-group')]"), 60);	
	}
	
	public WebElement getTotalProductCount(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[@class='product-counter']"), 60);
	}
	
	public WebElement pageBtn(int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//li[@role='button']//a)["+index+"]"), 60);
	}
	
	public WebElement firstPageBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@aria-label='go to first page']"), 10);
	}
	
	public WebElement lastPageBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@aria-label='go to last page']"), 10);
	}
	
	public WebElement nextPageBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@aria-label='go to next page']"), 10);
	}
	
	public WebElement previousPageBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@aria-label='go to previous page']"), 10);
	}
	
	public WebElement firstPageBtnStatus(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@aria-label='go to first page']//parent::li"), 60);
	}
	
	public WebElement lastPageBtnStatus(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@aria-label='go to last page']//parent::li"), 60);
	}
	
	public WebElement nextPageBtnStatus(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@aria-label='go to next page']//parent::li"), 60);
	}
	
	public WebElement previousPageBtnStatus(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@aria-label='go to previous page']//parent::li"), 60);
	}
	
	//********************Bulk Actions***************************
	
	public WebElement bulkActionPopupHeader(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//h4[@id='importProductsTitle']"), 60);
	}
	
	public WebElement bulkActionButtons(String btnName){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[contains(text(),'"+btnName+"')]//parent::a"), 60);
	}
	
	public WebElement uploadBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[contains(text(),'Upload')]"), 60);
	}
	
	public WebElement warningMessage(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//h4[@class='text-center']"), 60);
	}
	
	public WebElement acceptWarning(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[@class='btn btn-success'])[1]"), 60);
	}
	
	public WebElement uploadMessage(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[contains(@class,'toast-info')]"), 120);
	}
	
	public WebElement uploadingSuccessMessage(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[contains(@class,'toast-success')]"), 720);
	}
	
	//********************Add Product Details Tab*******************************
	
	public WebElement getAlertMessage(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[contains(@class,'alert alert-danger')]"), 60);	
	}
	
	public List<WebElement> getValidationMessage(){
		return WaitTool.waitForElementsPresentAndDisplay(driver, By.xpath("//span[contains(@class,'help-block')]"), 60);	
	}
	
	public WebElement getValidationMess(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[contains(@class,'help-block')]"), 60);	
	}
	
	public WebElement addProductHeaders(String headerName){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[text()='"+headerName+"']//parent::a"), 60);	
	}
	
	/*public WebElement descriptionHeader(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[text()='Description']//parent::a"), 60);	
	}
	
	public WebElement shippingHeader(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[text()='Shipping']//parent::a"), 60);	
	}
	
	public WebElement imagesHeader(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[text()='Images']//parent::a"), 60);	
	}
	
	public WebElement resourcesHeader(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[text()='Resources']//parent::a"), 60);	
	}*/
	
	public boolean historyHeader(){
		return WaitTool.isElementPresentAndDisplay(driver, By.xpath("//span[text()='History']//parent::a"));	
	}
	
	public boolean contentScore(){
		return WaitTool.isElementPresentAndDisplay(driver, By.xpath("//span[text()='Content Score']//parent::a"));	
	}
	
	public WebElement discontinuedToggle(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[text()='Discontinued']//parent::div//label"), 60);	
	}
	
	public WebElement activeToggle(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[text()='Active']//parent::div//label"), 60);	
	}
	
	public WebElement newProductButton(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@routerlink='/app/vendor/product/']"), 60);	
	}
	
	public WebElement cancelBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@routerlink='/app/vendor/']"), 180);	
	}
	
	public WebElement saveBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[@type='submit'])[1]"), 60);	
	}
	
	public WebElement setProductTitle(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='productTitle']"), 60);	
	}
	
	public WebElement SelectBrand(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='brandSelect']"), 60);	
	}
	
	public WebElement SelectCollections(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='collectionsSelect']"), 60);	
	}
	
	public WebElement clicktCategoryDropdown(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[@id='select2-categorySelect-container']"), 60);	
	}
	
	public WebElement selectCategoryName(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//ul[@id='select2-categorySelect-results']//li"), 60);		
	}
	
	public WebElement setSku(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='sku']"), 60);	
	}
	
	public WebElement setUpc(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='upc']"), 60);	
	}
	
	public WebElement selectManufactureCountry(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@name='countryManufacture']"), 60);	
	}
	
	public WebElement setWholesalePrice(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='price-wholesale']"), 60);	
	}
	
	public WebElement setFreightPrice(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='price-freight']"), 60);	
	}
	
	public WebElement setMsrpPrice(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='price-msrp']"), 60);	
	}
	
	public WebElement setMapPrice(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='price-map']"), 60);	
	}
	
	public WebElement selectColor(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@name='Color']"), 60);	
	}
	
	public WebElement selectMaterial(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@name='Material']"), 60);	
	}
	
	public WebElement selectStyle(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@name='Style']"), 60);	
	}
	
	//********************Add Product Description Tab*******************************

	public WebElement setShortDescription(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//textarea[@name='productDescription']"), 60);	
	}
	
	public WebElement setCommercialUseRadio(int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@name='commercialUse']//parent::label)["+index+"]"), 60);	
	}
	
	public WebElement clickExternalLink(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[contains(text(),'CLICK HERE TO KNOW MORE')]"), 60);	
	}
	
	public WebElement setFeature_1(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='feature-0']"), 60);	
	}
	
	public WebElement setFeature_2(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='feature-1']"), 60);	
	}
	
	public WebElement setFeature_3(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='feature-2']"), 60);	
	}
	
	public WebElement setFeature_4(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='feature-3']"), 60);	
	}
	
	public WebElement addFeatureRow(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@name='feature-2']//following::button[contains(text(),'New')])[1]"), 60);	
	}
	
	public WebElement deleteFeatureRow(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@name='feature-3']//following::button[contains(@class,'danger')])[1]"), 60);	
	}
	
	public WebElement setKey_1(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='specsKey0']"), 60);	
	}
	
	public WebElement setKey_2(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='specsKey1']"), 60);	
	}
	
	public WebElement setKey_3(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='specsKey2']"), 60);	
	}
	
	public WebElement setKey_4(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='specsKey3']"), 60);	
	}
	
	public WebElement setValue_1(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='specs-value-1']"), 60);	
	}
	
	public WebElement setValue_2(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='specs-value-2']"), 60);	
	}
	
	public WebElement setValue_3(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='specs-value-3']"), 60);	
	}
	
	public WebElement setValue_4(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='specs-value-4']"), 60);	
	}
	
	public WebElement removeProductSpecificationRow(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='specs-value-3']//following::button[contains(@class,'danger')]"), 60);	
	}
	
	public WebElement addProductSpecificationRow(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='specs-value-3']//following::button[contains(@class,'btn-sm')]"), 60);	
	}
	
	//********************Add Product Shipping Tab*******************************
	
	public WebElement setAvailableQuantity(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='available-qty']"), 60);	
	}
	public WebElement selectShippingService(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='shippingService']"), 60);	
	}
	
	public WebElement setLeadMinTime(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='ships-from']"), 60);	
	}
	
	public WebElement setLeadMaxTime(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='ships-to']"), 60);	
	}
	
	public WebElement setHsCode(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='hs-code']"), 60);	
	}
	
	public WebElement setSoldInCanadaRadio(int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@name='toCanadaCheck']//parent::label)["+index+"]"), 60);	
	}
	
	public WebElement setShipPalletCheckRadio(int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@name='shipPalletCheck']//parent::label)["+index+"]"), 60);	
	}
	
	public WebElement setPreAssembledCheck(int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@name='isPreassembledCheck']//parent::label)["+index+"]"), 60);	
	}
	
	public WebElement setUsaCheck(int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@name='toUsaCheck']//parent::label)["+index+"]"), 60);	
	}
	
	public WebElement setBackOrderedCheck(int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@name='isBackOrderedCheck']//parent::label)["+index+"]"), 60);	
	}
	
	public WebElement setProductHeight(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='dimension-height']"), 60);	
	}
	
	public WebElement setProductWidth(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='dimension-width']"), 60);	
	}
	
	public WebElement setProductDepth(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='dimension-depth']"), 60);	
	}
	
	public WebElement setProductWeight(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='dimension-weight']"), 60);	
	}
	
	public WebElement setPackageHeight(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='package-height-0']"), 60);	
	}
	
	public WebElement setPackageWidth(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='package-width-0']"), 60);	
	}
	
	public WebElement setPackageDepth(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='package-depth-0']"), 60);	
	}
	
	public WebElement setPackageWeight(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='package-weight-0']"), 60);	
	}
	
	public WebElement setPackageQuantity(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='package-qty-0']"), 60);	
	}
	
	public WebElement setPackageType(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@name='package-type-0']"), 60);	
	}
	
	public WebElement setPackageSku(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='package-sku-0']"), 60);	
	}
	
	public WebElement addNewPackage(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='package-sku-0']//following::button[contains(@class,'btn-sm')]"), 60);	
	}
	
	public WebElement removeNewPackage(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='package-sku-1']//following::button[contains(@class,'btn-danger')]"), 60);	
	}
	
	public WebElement scrollToTop(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='scroll-to-top show-scrollTop']//button"), 20);
	}
	
	public WebElement setPrimaryImage(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//label[contains(text(),'Set as Primary White Background Image')]//span)[1]"), 60);	
	}
	
	public WebElement uploadImage(int index){
		return WaitTool.returnWebElement(driver, By.xpath("(//input[@type='file'])["+index+"]"));	
	}
	
	public WebElement uploadResourceFile(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@type='file' and @id='multipleFile2']"), 60);	
	}
	
	
	
	
	
	
}
