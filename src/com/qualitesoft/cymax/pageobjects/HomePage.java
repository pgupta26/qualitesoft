package com.qualitesoft.cymax.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement cymaxPopup() {
		WaitTool.sleep(5);
		if(WaitTool.isElementPresentAndDisplay(driver, By.xpath("//div[@data-cc-state='cancelled']"))) {
			return WaitTool.returnWebElement(driver, By.xpath("//div[@data-cc-state='cancelled']"));
		}
		return null;
	}

	public WebElement myAccountLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath
			("//a[@href='/MyAccount/Default.aspx']"), 15);
	}
	public WebElement HomeSqmyAccountLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath
			("//*[@id=\"my-account-btn\"]"), 15);
	}
	public WebElement HomeSquserAccount() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath
			("//span[@class='pe-7f-user']"), 30);
	}		
	public WebElement HomeSqmyOrder() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath
			("//a[@href='/MyAccount/Default.aspx?ti=0']"), 30);
	}		
	public WebElement noThanks() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='no-thanks']"), 10);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[text()[contains(.,\"no thanks\")]]"), 30);
	}
	public WebElement HomeSqcloseButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='frel_button-close']"), 20);
	}	
	public WebElement searchIconButton() {
		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//i[@class='pe-7s-search']"), 10);
	}	
	public WebElement searchTextField() {
		
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[contains(@id,'searchTextBox')]"), 10);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@placeholder='Find furniture and decor for your business']"), 10);
	}
	public WebElement HomeSqsearchTextField() {
		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[contains(@name,'Search')]"), 60);
		
	}	
	//*[@id="Under$250"]
	
	
	public WebElement searchButton() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='frm']/div/span/button"), 10);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='btn-top-search']"), 60);
	}
	public WebElement errorpage() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='frm']/div/span/button"), 10);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("/html/body/span/h1/[contains(@text,'Server Error in '/' Application.')]"), 60);
	}
	public WebElement HomeSqsearchButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//i[@class='pe-7s-search']"), 10);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-main logSearch hidden-xms']"), 60);
	}	
    public WebElement furniturelink() {
		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/Furniture--PC100078.htm']"), 10);
	}
    
    public WebElement homeOfficeLink() {
		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/home-office--p1.htm']"), 10);
	}
	
	
	public WebElement diningChairsLink() {
		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/kitchen-dining--PC588.htm']"), 30);
	}
	public WebElement diningChairs() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/Dining-Chairs--C635.htm']"), 30);
	}
	public WebElement HomeSqdiningChairs() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/dining-chairs--C635.htm']"), 30);
	}
	public WebElement hsqHomeLink() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@src='/images/homesquare-logo.png' or @href='http://qa02.homesquare.com']"), 30);
	}
	
	public WebElement cymaxHomeLink() {
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@src='/images/cymax-logo.png' or @href='http://qa.cymax.com']"), 10);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@src='https://media.cymaxstores.com/Images/Cymax/header/logo-cymax.png' or @alt='Logo Cymax']"), 50);
	}
	
	public WebElement sortDropdown() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='filter-select' or @class='form-control input-sm width-150 margin-left-5 display-inline-block']"), 30);

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='filter-dropdown' or @class='form-control input-sm spacer-mobile select-sort']"), 30);
	}
	public WebElement highestPrice() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"filter-select\"]/option[6]"), 30);

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='filter-dropdown' or @class='form-control input-sm spacer-mobile select-sort']"), 30);
	}	
	public WebElement HomeSqsortDropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='filter-dropdown']"), 30);
	}
	public WebElement sortDropdownhigh() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*//*[@id='filter-dropdown']/option[6]"), 10);
	}
	public WebElement listView() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='list']"), 10);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='show-list-btn']"), 10);
	}
	public WebElement homelistView() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='list']"), 10);
		
	}	
	public WebElement gridView() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='grid']"), 10);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='show-grid-btn']"), 10);
	}
	public WebElement homegridView() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='grid']"), 10);
		
	}	
	public WebElement Price() {
		
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='#Price_fg']"), 10);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//h6[@data-target='#filter-Price']"), 30);
	}
	public WebElement homePrice() {
		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='#Price_fg']"), 10);
		
	}
	public WebElement Design() {
		
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='#Design_fg']"), 10);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//h6[@data-target='#filter-Design']"), 30);
	}
	public WebElement homeDesign() {
		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='#Design_fg']"), 10);
		
	}	
	public WebElement under$250Filter() {
		
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='collapsePrice']/ul/li[1]/label"), 30);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"filter-Price\"]/ul/li[1]/a"), 30);
	}
	public WebElement HomeSqunder$250Filter() {
		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='dining-chairs--C635-11170.htm?Sort=Price-Desc&Count=60']"), 10);
	}	
	public WebElement armChair() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"filter-Design\"]/ul/li[1]/a"), 10);
	}
	public WebElement HomeSqarmChair() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='dining-chairs--C635-4189.htm']"), 10);
	}	
	public WebElement banquette() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"filter-Design\"]/ul/li[2]/a"), 10);
	}
	public WebElement HomeSqbanquette() {
		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='dining-chairs--C635-4189-7830.htm']"), 10);
	}
	
	public WebElement subscriptionEmail() {	
		return WaitTool.waitForElementPresentAndDisplay(driver, By.id("email-footer-input"), 10);
	}
	
	public WebElement subscriptionSignUp() {	
		return WaitTool.waitForElementPresentAndDisplay(driver, By.id("subscription-btn"), 10);
	}
	
	public WebElement subscriptionSuccessMessage() {	
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='message-area success']"), 10);
	}
}
