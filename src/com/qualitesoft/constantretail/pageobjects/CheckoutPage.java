package com.qualitesoft.constantretail.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qualitesoft.core.WaitTool;

public class CheckoutPage{
	
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement visitStore() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='visit-store-url']"), 60);
	}
	
	public WebElement furnitureLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/catalog/office-furniture']"), 60);
	}
	
//catalog/office-supplies
	public WebElement furnitureLink1() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/catalog/office-chairs-qqq-more]"), 60);
	}
	//catalog/soaps
	public WebElement furnitureLink2() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/catalog/desks]"), 60);
	}	
	
	public WebElement product1() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//h2[@class='product-title'])[1]"), 60);
	}
	
	public WebElement addToCart() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-lg btn-primary btn-add-to-cart']"), 60);
	}
	
	public WebElement checkoutButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/checkout/login']"), 60);
	}
	
	public WebElement guestUserName() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='GuestUserName']"), 60);
	}
	
	public WebElement continueButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@id='btnSignIn']"), 60);
	}
	
	public WebElement firstName() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='first-name']"), 60);
	}
	
	public WebElement lastName() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='last-name']"), 60);
	}
	
	public WebElement companyName() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='company-name']"), 60);
	}
	
	public WebElement address1() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='address-1']"), 60);
	}
	
	public WebElement address2() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='address-2']"), 60);
	}
	
	public WebElement zipcode() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='zip-code']"), 60);
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
	
	public WebElement reviewButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='proceed-to-checkout-btn next-page']"), 60);
	}
	
	public WebElement continuePayment() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//a[@href='/checkout/payment'])[2]"), 60);
	}
			
	public WebElement creditCardNo() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='txtCreditCardNumber']"), 60);
	}
	
	public WebElement cardName() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='txtNameOnCard']"), 60);
	}
	
	public WebElement expMonth() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='ddlExpiryMonth']"), 60);
	}
	
	public WebElement expYear() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='ddlExpiryYear']"), 60);
	}
	
	public WebElement securityCode() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='txtSecurityCode']"), 60);
	}
	
	public WebElement placeOrder() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='proceed-to-checkout-btn next-page']"), 60);
	}
	
	public WebElement orderPage() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='btn-checkout btn-default-checkout btn-primary-checkout text-uppercase expand']"), 60);
	}
}
