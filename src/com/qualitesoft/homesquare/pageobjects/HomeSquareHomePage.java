package com.qualitesoft.homesquare.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class HomeSquareHomePage {

	WebDriver driver;

	public HomeSquareHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement myAccountLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath
			("//a[@href='/MyAccount/Default.aspx']"), 10);
	}
	
	
	public WebElement searchTextField() {
		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[contains(@id,'searchTextBox')]"), 10);
	}
	
	public WebElement searchField(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='Search']"), 60);
	}
	//*[@id="Under$250"]
		
	public WebElement searchButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='frm']/div/span/button"), 10);
	}
	public WebElement searchButton1(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@id='btn-top-search']"), 60);
	}
	
	public WebElement homeLink() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@src='/images/homesquare-logo.png' or @href='http://qa.homesquare.com']"), 10);
	}
	
	public WebElement diningChairsLink() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/kitchen-dining--PC588.htm']"), 10);
	}
	
	public WebElement diningChairs() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/Dining-Chairs--C635.htm']"), 10);
	}

	public WebElement sortDropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='filter-dropdown' or @class='form-control input-sm spacer-mobile select-sort']"), 10);
	}

	public WebElement sortDropdownhigh() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*//*[@id='filter-dropdown']/option[6]"), 10);
	}
	public WebElement listView() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='list']"), 10);
	}
	
	public WebElement gridView() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='grid']"), 10);
	}

	public WebElement under$250Filter() {
		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='collapsePrice']/ul/li[1]/label"), 10);
	}
	
	public WebElement armChair() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='collapseDesign']/ul/li[1]/label"), 10);
	}
	
	public WebElement banquette() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='collapseDesign']/ul/li[2]/label"), 10);
	}
	
}
