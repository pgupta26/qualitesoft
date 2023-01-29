package com.qualitesoft.channelgatesip.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class OrderPage {

	WebDriver driver;
	public OrderPage(WebDriver driver){
		this.driver = driver;		
	}
	
	private By orderDateFilter = By.xpath("//div[contains(@class,'text-orange-800')]//div[contains(@class,'p-chip-text')]");
	private By searchBar = By.xpath("//input[@placeholder='Search by Order ID']");
	private By searchBtn = By.xpath("//button[@icon='pi pi-search']");
	private By calendarIcon = By.xpath("//button[contains(@class,'p-datepicker-trigger')]");
	private By getOrderId = By.xpath("//table[contains(@class,'p-datatable-table')]//tr[1]//td[3]");
	private By orderStatus = By.xpath("//table[contains(@class,'p-datatable-table')]//tr[1]//td[5]");
	private By getPaginationRow = By.xpath("(//p-paginator//parent::div//div[contains(@class,'text-center text-xs')])[1]");
	private By expandAllBtn = By.xpath("//thead//tr//th//button");
	private By currentDate = By.xpath("//td[contains(@class,'p-datepicker-today')]");
	
	
	public WebElement getOrderDateFilter () {
		return WaitTool.waitForElementPresentAndDisplay(driver, orderDateFilter, 60);
	}
	public WebElement setOrderIdOnSearchBar () {
		return WaitTool.waitForElementPresentAndDisplay(driver, searchBar, 60);
	}
	public WebElement clickSearchBtn () {
		return WaitTool.waitForElementPresentAndDisplay(driver, searchBtn, 60);
	}
	public WebElement clickCalendarIcon () {
		return WaitTool.waitForElementPresentAndDisplay(driver, calendarIcon, 60);
	}
	public WebElement getOrderId () {
		return WaitTool.waitForElementPresentAndDisplay(driver, getOrderId, 60);
	}
	public WebElement getOrderStatus () {
		return WaitTool.waitForElementPresentAndDisplay(driver, orderStatus, 60);
	}
	public WebElement getPaginationRow () {
		return WaitTool.waitForElementPresentAndDisplay(driver, getPaginationRow, 60);
	}
	public WebElement clickExpandAllBtn () {
		return WaitTool.waitForElementPresentAndDisplay(driver, expandAllBtn, 60);
	}
	
	public WebElement getOrderCountOnBadge(String orderStatus) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@aria-labelledby='"+orderStatus+"']//span"), 60);
	}
	public WebElement selectStatusDate(String datesFilter) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@label='"+datesFilter+"']"), 60);
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
	public WebElement getSelectedFilter(String selectedStatus) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@title='"+selectedStatus+"']"), 60);
	}
	public WebElement clickButtonByText(String btnText) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//tr[6]//td//span[contains(text(),'"+btnText+"')]//parent::button"), 60);
	}
	
	public WebElement clickSelectCarrierDropdown () {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//p-dropdown[@formcontrolname='carrierID']"), 60);
	}
	public WebElement selectCarrier(String carrierName) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//li[@aria-label='"+carrierName+"']"), 60);
	}
	
	public WebElement setTrackingNum () {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@formcontrolname='tracking']"), 60);
	}
	public WebElement selectCurrentDate () {
		return WaitTool.waitForElementPresentAndDisplay(driver, currentDate, 60);
	}
}

