package com.qualitesoft.homesquare.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class HomeSquareCartPage {
	
	WebDriver driver;

	public HomeSquareCartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement checkoutButton(){
		
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(.//*[@id='topGotoCheckout'])"), 10);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//a[@class='proceed-to-checkout-btn next-page cymax-click-event cymax-click-event'])"), 10);
	}

	public WebElement continueShoppingButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@class='btn-continue-shopping']"), 10);
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
	public String shipping() {
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[text()='Shipping']/following-sibling::div[1]"), 10));
	}

	public String tax() {
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[text()='Tax: ']/following-sibling::div[1]"), 10));
	}

	public String productPrice() {
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[contains(text(),'Product Total')]/following-sibling::div[1]"), 10));
	}
	
	//*********************Copied from cymax
	public int cartItemCount() {
		return WaitTool.waitForElementsPresentAndDisplay(driver, By.xpath("//orderitemsserverdiv[@id='body_body_ucOrderItemGrid_ServerDiv']/div"), 30).size();
	}
	
	public WebElement haveACouponCode() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.partialLinkText("Have a coupon code?"), 30);
	}
	
	public String couponCodeValue() {
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[text()='Coupon (HSQJBTEST)']/following-sibling::div"), 30));
	}

	
	public WebElement couponCode() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@placeholder='Enter Coupon Code']"), 30);
	}
	
	public WebElement applyCouponCode() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@placeholder='Enter Coupon Code']/following-sibling::a"), 30);
	}
	
	public WebElement couponResponse() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@placeholder='Enter Coupon Code']/following-sibling::p"), 30);
	}
	public String totalPrice() {
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//p[text()='Total:']/parent::div/following-sibling::div/p"), 60));
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
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[@class='primary-checkout-btn next-page btn-checkout cymax-click-event col-xs-12'])[1]"), 60);
	}
	
	//***********************************Copied from Bush pages**********
		public String getProductPrice() {
			return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[contains(text(),'Product Total')]/following-sibling::div[1]"), 10));
		}
		
		public String getShipping() {
			return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[text()='Shipping']/following-sibling::div[1]"), 10));
		}
		
		public String getTax() {
			return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[text()='Tax: ']/following-sibling::div[1]"), 10));
		}
}
