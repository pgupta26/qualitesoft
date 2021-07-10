package com.qualitesoft.homesquare.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class HomeSquareOrderConfirmationPage {

	WebDriver driver;

	public HomeSquareOrderConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement orderNumber() {
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[contains(@class,'order-number')]/bold"), 90);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='row']//div[@class='col-sm-8']//div[@class='row confirmation-message cymax-load-event']//div[@class='col-sm-6']//p[@class='order-number']//bold"), 200);
	}
	
	public WebElement cymaxLogoImg() {
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//img[@*='logo']"), 10);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//img[@id='cymaxLogo']"), 90);
	}

	//**************Copied from cymax

	public void close() {
		if(WaitTool.isElementPresentAndDisplay(driver, By.xpath("//div[@alt='Close']")) == true) {
			SeleniumFunction.click(driver.findElement(By.xpath("//div[@alt='Close']")));
		}
	}
	
	public boolean successMsg() {
		return WaitTool.isElementPresentAndDisplay(driver, By.xpath("//h4[text()='Thank you for your order!']"));
	}
	
}
