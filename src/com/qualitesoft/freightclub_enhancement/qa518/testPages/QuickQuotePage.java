package com.qualitesoft.freightclub_enhancement.qa518.testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class QuickQuotePage {

	WebDriver driver;
	public QuickQuotePage(WebDriver driver){
		this.driver=driver;
	}

	public WebElement rates(String carriername){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//td/span[text()='"+carriername+"']//following::td[4]"), 60);
	}


	public WebElement diningChair(){

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//img[@class='product-item-img'])[1]"), 10);
	}

	public WebElement HomeSqdiningChair(){

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//img[@class='product-item-img product-click-event'])[1]"), 10);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//a[@class='product-description list-product-title'])[1]"), 10);
	}
	
	public String productPrice() {
		return SeleniumFunction.getText(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//h3[@itemprop='price']"), 10));
	}
}
