package com.qualitesoft.channelgatesip.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.SeleniumFunction;
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
	
	public WebElement listingBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/app/vendor']"), 60);	
	}
	
	public WebElement exportContentScoreBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@label='Export Content Score']"), 60);	
	}
	
	public WebElement exportProductsBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[contains(@label,'Export Products')]"), 60);	
	}
	
	public WebElement bulkActionsBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[contains(@label,'Bulk Actions')]"), 60);	
	}
	
	public WebElement downloadTemplateLink(int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//a[contains(text(),'Download Template')])["+index+"]"), 60);	
	}
	
	public WebElement searchByBrandField(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@type='search' and @class='select2-search__field']"), 60);	
	}
	
	public WebElement selectBrand(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//ul[@id='select2-brandsSelect-results']//li"), 60);	
	}
	
	public boolean selectedBrandName(String brandName){
		return WaitTool.isElementPresentAndDisplay(driver, By.xpath("//ul[@class='select2-selection__rendered']//li[@title='"+brandName+"']"));	
	}	
	
	public WebElement searchBySkuAndProductIdField(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@placeholder='Search product by SKU or Product ID']"), 120);	
	}
	
	public WebElement goBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@icon='pi pi-search']"), 60);	
	}
	
	public WebElement filterBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@label='Filter']"), 60);	
	}
	
	public WebElement filterOptions(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@name='filterOptions']"), 60);	
	}
	
	public WebElement filterOptionValues(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@name='filterOptionsValues']"), 60);	
	}
	
	public WebElement applyFilterBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[contains(text(),'Apply Filter')]//parent::button"), 60);	
	}
	
	public WebElement applyFilterLabel(int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//ul[@class='ui-tags active-filters']//li)["+index+"]"), 60);	
	}
	
	public WebElement newProductBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@label='Add New Product']"), 60);	
	}
	
	public WebElement getTableData(int rowNum, int colNum){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//table//tbody//tr["+rowNum+"]//td["+colNum+"]"), 180);	
	}
	
	public WebElement productTitle(int rowNum, int colNum){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("((//datatable-body[@class='datatable-body']//div[contains(@class,'center datatable-row-group')])["+rowNum+"]//div)["+colNum+"]//a"), 60);	
	}
	
	public List<WebElement> getCountOfRows(){
		return driver.findElements(By.xpath("//table//tbody//tr"));	
	}
	
	public WebElement getTotalProductCount(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[contains(@class,'text-center text-xs text-gray-500')]"), 60);
	}
	
	public WebElement pageBtn(String text){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[contains(text(),'"+text+"')]"), 60);
	}
	
	public WebElement firstPageBtn(int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[contains(@class,'p-paginator-first')])["+index+"]"), 10);
	}
	
	public WebElement lastPageBtn(int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[contains(@class,'p-paginator-last')])["+index+"]"), 10);
	}
	
	public WebElement nextPageBtn(int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[contains(@class,'p-paginator-next')])["+index+"]"), 10);
	}
	
	public WebElement previousPageBtn(int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[contains(@class,'p-paginator-prev')])["+index+"]"), 10);
	}
	
	public WebElement firstPageBtnStatus(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[contains(@class,'p-paginator-first')]"), 60);
	}
	
	public WebElement lastPageBtnStatus(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[contains(@class,'p-paginator-last')]"), 60);
	}
	
	public WebElement nextPageBtnStatus(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[contains(@class,'p-paginator-next')]"), 60);
	}
	
	public WebElement previousPageBtnStatus(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[contains(@class,'p-paginator-prev')]"), 60);
	}
	
	//********************Bulk Actions***************************
	
	public WebElement bulkActionPopupHeader(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[contains(@class,'p-dialog-title')]"), 60);
	}
	
	public WebElement bulkActionButtons(String btnName){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[contains(text(),'"+btnName+"')]//parent::a"), 60);
	}
	
	public WebElement uploadBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[contains(@label,'Upload')]"), 60);
	}
	
	public WebElement cancelBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[contains(@label,'Cancel')]"), 60);
	}
	
	public WebElement warningMessage(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//h4[@class='text-center']"), 60);
	}
	
	public WebElement acceptWarning(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[@class='btn btn-success'])[1]"), 60);
	}
	
	public WebElement toastMessage(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.id("toast-container"), 120);
	}
	
	public WebElement uploadMessage(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[contains(@class,'toast-info')]"), 120);
	}
	
	public WebElement uploadingSuccessMessage(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[contains(@class,'toast-success')]"), 120);
	}
	
	//**************************************Add Product Details Tab*******************************
	
	public WebElement getProductDetails(String label) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//span[contains(text(),'"+label+"')]//parent::div//span)[2]"), 60);
	}
	
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
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//p-inputswitch[@formcontrolname='IsDiscontinued']"), 60);	
	}
	
	public WebElement activeToggle(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//p-inputswitch[@formcontrolname='IsActive']//div"), 60);	
	}
	
	public WebElement newProductButton(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@routerlink='/app/vendor/product/']"), 60);	
	}
	
	public WebElement backBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@icon='pi pi-arrow-left']"), 180);	
	}
	
	public WebElement saveBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[@type='submit'])[1]"), 60);	
	}
	
	public WebElement setProductTitle(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='prod-title']"), 60);	
	}
	
	public WebElement SelectBrand(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[contains(text(),'Product Brand')]//parent::div//p-dropdown"), 60);	
	}
	
	public WebElement SelectCollections(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[contains(text(),'Collection')]//parent::div//p-dropdown"), 60);	
	}
	
	public WebElement clicktCategoryDropdown(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[contains(text(),'Category')]//parent::div//p-dropdown"), 60);	
	}
	
	public WebElement selectDropdownValueByText(String optionText){
		WaitTool.sleep(1);
		SeleniumFunction.sendKeys(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[contains(@class,'p-dropdown-filter')]"), 60), optionText);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//p-dropdownitem//span[contains(text(),'"+optionText+"')]"), 60);		
	}
	
	public WebElement setSku(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='prod-sku']"), 60);	
	}
	
	public WebElement setUpc(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='prod-upc']"), 60);	
	}
	
	public WebElement selectManufactureCountry(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[contains(text(),'Country')]//parent::div//p-dropdown"), 60);	
	}
	
	public WebElement setWholesalePrice(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[contains(text(),'Wholesale')]//parent::div//input"), 60);	
	}
	
	public WebElement setFreightPrice(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[contains(text(),'Freight')]//parent::div//input"), 60);	
	}
	
	public WebElement setMsrpPrice(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[contains(text(),'MSRP')]//parent::div//input"), 60);	
	}
	
	public WebElement setMapPrice(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[contains(text(),'MAPS')]//parent::div//input"), 60);	
	}
	public WebElement getSellingPrice(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[contains(text(),'Selling Price')]//parent::div//input"), 60);	
	}
	
	public WebElement selectColor(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[contains(text(),'Color')]//parent::div//p-dropdown"), 60);	
	}
	
	public WebElement selectMaterial(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[contains(text(),'Material')]//parent::div//p-dropdown"), 60);	
	}
	
	public WebElement selectStyle(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[contains(text(),'Style')]//parent::div//p-dropdown"), 60);	
	}
	
	//********************Add Product Description Tab*******************************

	public WebElement setShortDescription(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//textarea[@formcontrolname='Value']"), 60);	
	}
	public WebElement setPreposition65Radio(String label){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//p-radiobutton[@label='"+label+"' and @name='Prop65']//div[contains(@class,'p-radiobutton-box')]"), 60);	
	}
	public WebElement setCommercialUseRadio(String label){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//p-radiobutton[@label='"+label+"' and @name='IsCommercial']//div[contains(@class,'p-radiobutton-box')]"), 60);	
	}
	
	
	public WebElement setFeature_1(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='prod-feature1']"), 60);	
	}
	
	public WebElement setFeature_2(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='prod-feature2']"), 60);	
	}
	
	public WebElement setFeature_3(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='prod-feature3']"), 60);	
	}
	
	public WebElement setFeature_4(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='prod-feature4']"), 60);	
	}
	
	public WebElement addFeatureRow(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@id='prod-feature3']//following::button[@icon='pi pi-plus'])[1]"), 60);	
	}
	
	public WebElement deleteFeatureRow(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@id='prod-feature4']//following::button[@icon='pi pi-trash'])[1]"), 60);	
	}
	
	public WebElement selectKey(int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//label[contains(text(),'Key')]//parent::div//p-dropdown)["+index+"]"), 60);	
	}
	
	public WebElement setKeysValue(int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//label[contains(text(),'Value')]//parent::div//input)["+index+"]"), 60);	
	}
	
	public WebElement removeProductSpecificationRow(int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//label[contains(text(),'Value')]//parent::div//input//following::button[@icon='pi pi-trash'])["+index+"]"), 60);	
	}
	
	public WebElement addProductSpecificationRow(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//label[contains(text(),'Value')]//parent::div//input//following::button)[1]"), 60);	
	}
	
	//********************Add Product Shipping Tab*******************************
	
	public WebElement setAvailableQuantity(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//p-inputnumber[@formcontrolname='Stock']//input"), 60);	
	}
	public WebElement selectShippingService(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[contains(text(),'Shipping Service')]//parent::div//p-dropdown"), 60);	
	}
	
	public WebElement setLeadMinTime(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[contains(text(),'min')]//parent::div//p-inputnumber//input"), 60);	
	}
	
	public WebElement setLeadMaxTime(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[contains(text(),'max')]//parent::div//p-inputnumber//input"), 60);	
	}
	
	public WebElement setHsCode(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='prod-harmonized-code']"), 60);	
	}
	
	public WebElement setSoldInCanadaRadio(String label){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//p-radiobutton[@label='"+label+"' and @name='ToCanada']//div[contains(@class,'p-radiobutton-box')]"), 60);	
	}
	
	public WebElement setShipPalletCheckRadio(String label){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//p-radiobutton[@label='"+label+"' and @name='ShipsOnPallet']//div[contains(@class,'p-radiobutton-box')]"), 60);	
	}
	
	public WebElement setPreAssembledCheck(String label){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//p-radiobutton[@label='"+label+"' and @name='IsPreAssembled']//div[contains(@class,'p-radiobutton-box')]"), 60);	
	}
	
	public WebElement setUsaCheck(String label){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//p-radiobutton[@label='"+label+"' and @name='ToUSA']//div[contains(@class,'p-radiobutton-box')]"), 60);	
	}
	
	public WebElement setBackOrderedCheck(String label){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//p-radiobutton[@label='"+label+"' and @name='IsBackOrdered']//div[contains(@class,'p-radiobutton-box')]"), 60);	
	}
	
	public WebElement setProductHeight(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//p-inputnumber[@formcontrolname='Height']//input)[1]"), 60);	
	}
	
	public WebElement setProductWidth(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//p-inputnumber[@formcontrolname='Width']//input)[1]"), 60);	
	}
	
	public WebElement setProductDepth(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//p-inputnumber[@formcontrolname='Depth']//input)[1]"), 60);	
	}
	
	public WebElement setProductWeight(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//p-inputnumber[@formcontrolname='Weight']//input)[1]"), 60);	
	}
	
	public WebElement setPackageHeight(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//p-inputnumber[@formcontrolname='Height']//input)[2]"), 60);	
	}
	
	public WebElement setPackageWidth(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//p-inputnumber[@formcontrolname='Width']//input)[2]"), 60);	
	}
	
	public WebElement setPackageDepth(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//p-inputnumber[@formcontrolname='Depth']//input)[2]"), 60);	
	}
	
	public WebElement setPackageWeight(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//p-inputnumber[@formcontrolname='Weight']//input)[2]"), 60);	
	}
	
	public WebElement setPackageQuantity(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//p-inputnumber[@formcontrolname='Quantity']//input"), 60);	
	}
	
	public WebElement setPackageType(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//p-dropdown[@formcontrolname='IsWrap']	"), 60);	
	}
	
	public WebElement setPackageSku(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@formcontrolname='sku']"), 60);	
	}
	
	
	
	public WebElement addNewPackage(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@formarrayname='PackageDimensions']//button[@icon='pi pi-plus']"), 60);	
	}
	
	public WebElement removeNewPackage(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@formarrayname='PackageDimensions']//button[@icon='pi pi-trash'])[2]"), 60);	
	}
	
	public WebElement scrollUptoSaveBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//span[contains(text(),'Save')])"), 20);
	}
	
	public WebElement clickImportResources(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@label='IMPORT RESOURCES']"), 60);	
	}
	
	public WebElement uploadImage(int index){
		return WaitTool.returnWebElement(driver, By.xpath("(//input[@type='file'])["+index+"]"));	
	}
	
	public WebElement uploadResourceFile(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@type='file' and @id='multipleFile2']"), 60);	
	}
	public WebElement clickCloseButton(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@label='Close']"), 60);	
	}
	
	
	//*****************************Listing table data************************
	private By productImage = By.xpath("(//table//tbody//tr[1]//td//img)[1]");
	private By productTitle = By.xpath("(//table//tbody//tr[1]//td//a)[2]");
	private By productSku = By.xpath("(//table//tbody//tr[1]//td//div)[2]");
	private By activeIcon = By.xpath("(//table//tbody//tr[1]//td//i)[1]");
	
	public WebElement getProductImage() {
		return WaitTool.waitForElementPresentAndDisplay(driver, productImage, 60);
	}
	public WebElement getProductTitle() {
		return WaitTool.waitForElementPresentAndDisplay(driver, productTitle, 60);
	}
	public WebElement getProductIdAndChannel(int index) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//table//tbody//tr[1]//td//span)["+ index +"]"), 60);
	}
	public WebElement getProductSku() {
		return WaitTool.waitForElementPresentAndDisplay(driver, productSku, 60);
	}
	public WebElement getProductSkus(int rowNum) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//table//tbody//tr["+rowNum+"]//td//div)[2]"), 60);
	}
	public WebElement getProductQtyPriceAndDates(int index) { //6 and 7 10 and 11
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//table//tbody//tr[1]//td)["+ index +"]"), 60);
	}
	public WebElement getProductActiveIcon() {
		return WaitTool.waitForElementPresentAndDisplay(driver, activeIcon, 60);
	}
	
	//***************************************Filter Data************************
	
	private By brandField = By.xpath("//p-multiselect[@optionvalue='ID']");
	private By categoryField = By.xpath("//p-multiselect[@optionvalue='Id']");
	private By closeIcon = By.xpath("//span[contains(@class,'p-multiselect-close-icon')]");
	private By searchOnFilter = By.xpath("//input[contains(@class,'p-multiselect-filter')]");
	private By applyFilterBtn = By.xpath("//span[contains(text(),'Apply Filters')]//parent::button");
	private By closeFilter = By.xpath("//button[contains(@class,'p-ripple p-element p-sidebar-close')]");
	private By clearBtn = By.xpath("//button[@label='Clear']");
	
	public WebElement clickBrandField() {
		return WaitTool.waitForElementPresentAndDisplay(driver, brandField, 60);
	}
	
	public WebElement clickCategoryField() {
		return WaitTool.waitForElementPresentAndDisplay(driver, categoryField, 60);
	}
	
	public WebElement clickCloseMultiselectPopup() {
		return WaitTool.waitForElementPresentAndDisplay(driver, closeIcon, 60);
	}
	public WebElement searchFilterOptionText() {
		return WaitTool.waitForElementPresentAndDisplay(driver, searchOnFilter, 30);
	}
	public WebElement selectCheckbox(String optionText) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//p-multiselectitem//li[contains(@aria-label,'"+optionText+"')]//div[contains(@class,'p-checkbox-box')]"), 60);
	}
	public WebElement clickApplyFilterBtn() {
		return WaitTool.waitForElementPresentAndDisplay(driver, applyFilterBtn, 60);
	}
	
	public WebElement clickDropdownField(String fieldName) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//label[contains(text(),'"+fieldName+"')]//following::p-dropdown[@optionvalue='FilterBy'])[1]"), 60);
	}
	public WebElement selectDropdownValue(String optionText) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//p-dropdownitem//li//span[contains(text(),'"+optionText+"')]"), 60);
	}
	
	public WebElement clickCloseFilter() {
		return WaitTool.waitForElementPresentAndDisplay(driver, closeFilter, 60);
	}
	public WebElement clickClearFilter() {
		return WaitTool.waitForElementPresentAndDisplay(driver, clearBtn, 60);
	}
	
	public WebElement getSelectedFilterText(int index) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//p-chip//div[contains(@class,'p-chip-text')])["+index+"]"), 60);
	}
}
