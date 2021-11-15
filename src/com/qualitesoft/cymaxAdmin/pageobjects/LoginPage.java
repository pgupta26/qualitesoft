package com.qualitesoft.cymaxAdmin.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qualitesoft.core.WaitTool;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	By username = By.xpath("//input[@type='text']");
	By password = By.xpath("//input[@type='password']");
	By loginBtn = By.xpath("//input[@type='submit']");
	By logout = By.xpath("//a[contains(@href,'logout.aspx')]");
	
	public WebElement clickLoginBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, loginBtn , 120);
	}
	public WebElement setUsername(){
		return WaitTool.waitForElementPresentAndDisplay(driver, username , 120);
	}
	public WebElement setPassword(){
		return WaitTool.waitForElementPresentAndDisplay(driver, password , 120);
	}
	public WebElement clickLogoutBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, logout , 40);
	}
}
