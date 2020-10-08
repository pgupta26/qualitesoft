package com.qualitesoft.bush.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class CartPage {
	
	WebDriver driver;
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement checkoutButton(){
		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='proceed-to-checkout-btn next-page cymax-click-event cymax-click-event']"), 40);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(.//*[@href='https://qa.cymax.com/Checkout/v2/login.aspx' or 'https://qa.cymax.com/checkout/v2/shippinginformation.aspx'])"), 30);
	}

	public WebElement continueShoppingButton() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@class='btn-continue-shopping']"), 10);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"btn-continue-cart\"]"), 20);
	}
	
	public WebElement deleteProductLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(.//*[@class='cart-remove-link cymax-click-event' or @data-eventmessage='Delete Cartrow'])[1]"), 10);
	}
	
	public WebElement addProductQuantity() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(.//*[@class='cart-quantity'])"), 10);
	}
	
	public WebElement updateProductQuantity() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(.//*[@class='cart-update-link cymax-click-event' or @data-eventmessage='Update Cartrow'])"), 10);
	}
	public WebElement guestUserName() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='txtEmailAddress']"), 60);
		
	}
	
	public String getProductPrice() {
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[contains(text(),'Product Total')]/following-sibling::div[1]"), 10));
	}
	
	public String getShipping() {
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[text()='Shipping']/following-sibling::div[1]"), 10));
	}
	
	public String getTax() {
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[text()='Tax: ']/following-sibling::div[1]"), 10));
	}
	
/*	public WebElement alreadyaccount() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"headingOne\"]/h4/a"), 60);
		
	}
	public WebElement useremail() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"txtExistingEmailAddress\"]"), 60);
		
	}
	public WebElement userpassword() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"txtPassword\"]"), 60);
		
	}*/
	public WebElement continueButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@id='btnSignIn']"), 60);
	}	
	
	public WebElement alreadyaccountButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='panel panel-default login-panel']"), 60);
	}
	public WebElement emailTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"txtExistingEmailAddress\"]"), 60);
	}
	public WebElement passwordTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='txtPassword']"), 60);
	}
	public WebElement signinButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"btnHaveAnAccount\"]"), 60);
	}	
	public WebElement firstName() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='first-name']"), 60);
	}
	
	public WebElement lastName() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='last-name']"), 60);
	}
	
	public WebElement address1() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='address-1']"), 60);
	}
	
	public WebElement address2() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='address-2']"), 60);
	}
	
	public WebElement zipcode() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='zipcode']"), 60);
	}
	
	public WebElement city() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='city']"), 60);
	}
	

	public WebElement country() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='ddlCountry']"), 60);
	}
	
	public WebElement state() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='ddlState']"), 60);
	}
	
	public WebElement phone() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='phone']"), 60);
	}
	public WebElement SpecialDelivery() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//textarea[@class='form-control no-resize']"), 60);
	}	
	public WebElement reviewButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='primary-checkout-btn next-page btn-checkout cymax-click-event col-xs-12']"), 60);
	}
}
