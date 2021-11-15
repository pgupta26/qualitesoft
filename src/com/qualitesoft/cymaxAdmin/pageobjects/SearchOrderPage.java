package com.qualitesoft.cymaxAdmin.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class SearchOrderPage {
	
	WebDriver driver;

	public SearchOrderPage(WebDriver driver){
		this.driver = driver;
	}
	
	By orderId = By.xpath("//input[contains(@name,'txtOrderid')]");
	By findBtn = By.xpath("//input[@type='submit']");
	By firstOrderId = By.xpath("//table[@class='tablesorter']//tr[1]//td[1]//a");
	
	public WebElement setOrderId(){
		return WaitTool.waitForElementPresentAndDisplay(driver, orderId , 120);
	}
	public WebElement clickFindBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, findBtn , 120);
	}
	
	public WebElement clickFirstOrderId(){
		return WaitTool.waitForElementPresentAndDisplay(driver, firstOrderId , 120);
	}
}
