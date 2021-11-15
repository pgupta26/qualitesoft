package com.qualitesoft.cymaxAdmin.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	By operations = By.xpath("//a[@name='Operations']");
	By searchOrders = By.xpath("//a[@href='/OrderSearch.aspx']");
	
	public WebElement hoverOperationsTab(){
		return WaitTool.waitForElementPresentAndDisplay(driver, operations , 120);
	}
	
	public WebElement clickSearchOrdersOption(){
		return WaitTool.waitForElementPresentAndDisplay(driver, searchOrders , 120);
	}
}
