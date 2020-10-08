package com.qualitesoft.americanmattress.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class ShoppingCartPage {
	
	WebDriver driver;

	

	public ShoppingCartPage(WebDriver driver){
		
		this.driver = driver;
	}
	public WebElement email() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='Email']"), 60);
	}
	public WebElement password() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='Password']"), 60);
	}
	public WebElement signup() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@type='submit']"), 60);
	}	
	public WebElement keepShoppingLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='btn-continue-shopping']"), 60);
		//return WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath("//a[@class='proceed-to-checkout-btn next-page']"), 30);
	}
	
	public WebElement removeLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//a[@class='cart-remove-link'])[1]"), 60);
	}
	
	public WebElement updateLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='cart-update-link']"), 60);
	}
	
	public WebElement quantityTextfield() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@class='cart-quantity']"), 60);
	}
	
	public WebElement proceedToCheckoutButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='primary-checkout-btn next-page']"), 60);
	}
	public WebElement Dining() { 

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"display-nav-bar\"]/ul/li[5]/a"), 60);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"display-nav-bar\"]/ul/li[3]/a"), 60);
	}
	public WebElement Diningchair() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"display-nav-bar\"]/ul/li[5]/div/div[3]/a"), 60);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"product-catalog-container\"]/div/div[1]/div/a[1]"), 60);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/catalog/chair/category=dining-chairs/name/1']"), 60);
	}	
	public WebElement AddChair() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"product-catalog-container\"]/div/div[1]/div/a[1]/img"), 60);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"addtoCartButton\"]"), 60);
	}
	public WebElement AddChair_vig() {
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"product-catalog-container\"]/div/div[1]/div/a[1]/img"), 60);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"catalogContainer\"]/div/div[3]/div/div[1]/div/a[1]/img"), 60);
	}
	public WebElement Addotheritem() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"catalogContainer\"]/div/div[2]/div[2]/div[1]/div/a/img"), 60);
	}
	public WebElement Addotheritem_vig() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"catalogContainer\"]/div/div[3]/div/div[1]/div/a[1]/img"), 60);
	}	
	public WebElement furnitureLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/catalog/furniture']"), 60);
	}
}
