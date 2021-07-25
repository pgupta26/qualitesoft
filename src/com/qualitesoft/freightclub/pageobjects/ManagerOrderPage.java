package com.qualitesoft.freightclub.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class ManagerOrderPage {
	
	WebDriver driver;

	public ManagerOrderPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement manageOrdersLink() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[contains(@href,'/Order/Index')]"), 30);
	}
	
	public WebElement orderIdFilter() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@ref='eColumnFloatingFilter'])[1]"), 30);
	}
	
	public WebElement ExpandMenupage() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@title='Click to retract or expand the page menu']"), 30);
	}
	
	public WebElement ViewDetail() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[text()='Detail'])[1]"), 30);
	}
	
	public void orderIDFilter(String orderid) {
		SeleniumFunction.sendKeys(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@ref='eColumnFloatingFilter'])[1]"), 10), orderid);
	}
	
	public WebElement orderIDGridValueFirstRow() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@class='ag-cell-no-focus ag-cell ag-cell-not-inline-editing ag-cell-value' and @colid='ID'])[1]"), 20);
	}
	
	public WebElement ActionButton() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[@class='btn btn-primary btn-xs dropdown-toggle'])[1]"), 30);
	}
	
	public WebElement billOfLoadingPdf() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.linkText("Download Bill of Lading(s) - PDF"), 10);
	}
	
	public WebElement shippingLabelsPdf() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.linkText("Download Shipping Label(s) - PDF"), 10);
	}
	
	public boolean requestCancellation() {
		return WaitTool.isElementPresentAndDisplay(driver, By.xpath("//a[text()='Request Cancellation']"));
	}
	
	public WebElement clone() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[text()='Clone']"), 30);
	}
	
	public WebElement customerPONumber() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.id("poNumber"), 30);
	}
	
	public WebElement cloneNow() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"cloneModal\"]/div/div/form/div[2]/button[2]"), 30);
	}
	
	public WebElement customerPO() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div[1]/div[4])[1]"), 30);
	}
	
	public WebElement reQuote() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[text()='Re-Quote']"), 30);
	}
	
	public WebElement notQuoted() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.id("incompleteOrders"), 30);
	}
	
	public WebElement customerPO_NotQuoted() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div[1]/div[3])[3]"), 30);
	}
	
	public WebElement openQuotes() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='#quickOrders']"), 30);
	}
	
	public WebElement quotedPrice() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='quickOrders']/descendant::div[@class='ag-body-container']/div/div[6]"), 30);
	}
	
	public WebElement actions() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div[1]/div[7]/div/button"), 30);
	}
	
	public WebElement book() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div[1]/div[7]/div/ul/li[1]"), 30);
	}
	
	public WebElement delete() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div[1]/div[7]/div/ul/li[2]"), 30);
	}
	
	public WebElement openQuotesActions() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='center']/div/div[4]/div[3]/div/div/div[1]/div[9]/div/button"), 30);
	}
	
	public WebElement openQuotesBook() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='center']/div/div[4]/div[3]/div/div/div[1]/div[9]/div/ul/li[2]/a"), 30);
	}
	
	//***************************************Initiate Claim***********************************
	
	public WebElement listingPageHeader(int index){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//span[contains(@class,'ag-header-cell-text')])["+index+"]"), 30);
	}
	
	public void initiateClaim() {
		SeleniumFunction.clickJS(driver,WaitTool.waitForElementPresentAndDisplay(driver, By.linkText("Initiate Claim"), 10));
	}
	
	
	////values are PendingPickup and Booked
	public void selectStatus(String value){
		WebElement button = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@class='ms-parent ']//button)[1]"), 120);
		SeleniumFunction.click(button);
		WebElement option = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@value='"+value+"']"), 10);
		SeleniumFunction.click(option);
		WaitTool.sleep(2);
		SeleniumFunction.click(button);
		WaitTool.sleep(2);
	}
	
	public WebElement initiateClaimPopup(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//h4[@id='initiateClaimLabel']"), 30);
	}
	
	//Value 1 is for Damage and 2 if for Loss
	public void selectClaimType(String value){
		SeleniumFunction.selectByvalue(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='claimType']"), 30), value);
	}
	
	public void clickInitiateClaimButton() {
		SeleniumFunction.clickJS(driver,WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[contains(@class,'input-group-btn')]//button"), 10));
	}
	
	//********************************Pagination***************
	
	public void clickPaginationButton(int index){
		WebElement button = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@class='paging-panel pager-visible']//button)["+index+"]"), 20);
		SeleniumFunction.scrollDownUptoFooter(driver);
		SeleniumFunction.click(button);
	}
	
	public String getPagiationTotalRows (){
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@class='paging-panel pager-visible']//span[contains(@class,'summary-panel')])[1]"), 20));
	}
	
	public void setPageNumber(String text){
		SeleniumFunction.sendKeys(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@class='paging-panel pager-visible']//input[@type='number'])[1]"), 20), text);
	}
	
	public String getPageNumber(){
		WebElement inputPage = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@class='paging-panel pager-visible']//input[@type='number'])[1]"), 20);
		return SeleniumFunction.getAttribute(inputPage, "value");
	}
	
	public Integer getRowsCount(){
		List<WebElement> elements = WaitTool.waitForElementsPresentAndDisplay(driver, By.xpath("(//div[@class='ag-body-viewport'])[1]//div[contains(@class,'ag-row')]"), 30);
		return elements.size();
	}
	
	public String getTotalPages(){
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@class='paging-panel pager-visible']//span[contains(@class,'action-panel')])[1]"), 20));
	}
	
	//**************Searching************
	// values 1 order id, 3 Way bill, 4 tracking
	public void searchFields(String index,String value) {
		SeleniumFunction.sendKeys(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@ref='eColumnFloatingFilter'])["+index+"]"), 10), value);
	}
	
	//index 2, 9, 10
	public String getColumnData(String index){
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[contains(@class,'ag-cell-value')])["+index+"]"), 20));
	}
	
	//************Page filters header
	
	public String getFilterHeader(int index){
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@class='ag-header-cell ag-header-cell-sortable'])["+index+"]"), 20));
	}
	
	//******************************Request Reroute*************************
	//Delivery Reroute Request

	public void clickRequestRerouteLink() {
		SeleniumFunction.clickJS(driver, WaitTool.waitForElementPresentAndDisplay(driver, By.linkText("Request Reroute"), 10));
	}
	
	public void clickClosePopupButton() {
		SeleniumFunction.clickJS(driver, WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='rerouteModal']//button[contains(@class,'close')]"), 10));
	}
	
	public void clickConfirmReroute() {
		SeleniumFunction.clickJS(driver, WaitTool.waitForElementPresentAndDisplay(driver, By.linkText("Confirm Reroute"), 10));
	}
	
	public void clickDeniedReroute() {
		SeleniumFunction.clickJS(driver, WaitTool.waitForElementPresentAndDisplay(driver, By.linkText("Reroute Denied"), 10));
	}
	
	public WebElement requestReroutePopup(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//h4[@id='rerouteLabel']"), 30);
	}
	
	public WebElement deniedReroutePopup(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='rerouteDeniedModal']//h4[@id='rerouteLabel']"), 30);
	}
	
	public void fillRerouteRequestForm(String labelName, String text){
		SeleniumFunction.sendKeys(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//h4[@id='rerouteLabel']//following::label[contains(text(),'"+labelName+"')]//parent::div//input"), 60), text);
	}
	
	public String getFieldValidation(int index){
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//h4[@id='rerouteLabel']//following::span[@class='form-group-message'])["+index+"]"), 60));
	}
	
	public void clickSendRequestBtn(){
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//h4[@id='rerouteLabel']//following::button[@class='btn btn-primary pull-right'])[1]"), 30));
	}
	
	public boolean requestRerouteIsPresent() {
		return WaitTool.isElementPresentAndDisplay(driver, By.linkText("Request Reroute"));
	}
	
	public WebElement checkboxStatus(String fieldName){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[contains(text(),'"+fieldName+"')]//input"), 60);
	}
	
	public WebElement locationType(String locationType){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='rerouteModal']//label[contains(text(),'"+locationType+"')]//parent::div//select"), 60);
	}
	
	public boolean dropOffDropdownStatus(String locationType){
		return WaitTool.isElementPresentAndDisplay(driver, By.xpath("//div[@id='rerouteModal']//label[contains(text(),'"+locationType+"')]//parent::div//select"));
	}
	
	public String verifyToastMessage(){
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='toast toast-success']"), 60));
	}
	
	public void setRerouteDeniedReason(String text){
		SeleniumFunction.sendKeys(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//textarea[@class='form-control form-input']"), 60), text);
	}
	
	public void clickProceedDenialBtn(){
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='rerouteDeniedModal']//button[contains(@class,'btn btn-primary')]"), 30));
	}
	
	//*******************admin dashboard feedback popup
	public void acceptFeedbackPopup(){
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='step-0']//button[@class='btn btn-primary']"), 15));
	}
	
	public boolean acceptFeedbackPopupStatus(){
		return WaitTool.waitForElementBoolean(driver, By.xpath("//div[@id='step-0']//button[@class='btn btn-primary']"), 15);
	}
}
