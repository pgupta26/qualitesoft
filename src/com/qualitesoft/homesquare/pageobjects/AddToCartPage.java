package com.qualitesoft.homesquare.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class AddToCartPage {

	WebDriver driver;

	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement quantityDropdown() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@class='form-control qty cb-qty']"),10);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='Main.Qty']"),10);
	}
	
	public WebElement quantityDropdownHome() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@class='form-control qty cb-qty']"),10);

	}
	public WebElement addToCartButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@data-eventmessage='Add To Cart']"), 30);
	}
	public WebElement keepshoppingButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='btn-continue-shopping']"), 30);
	}
	
	public WebElement moreDetails() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.linkText("More Details"), 30);	
	}
	
	public WebElement closeShippingDetails() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='close float-right']"), 30);	
	}
	
	public WebElement aboutTheBrand() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@aria-controls='cancelPanel']"), 30);	
	}
	
	public WebElement brandLogo() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//img[@alt='Brand Logo']"), 30);	
	}
	
	
	
}
