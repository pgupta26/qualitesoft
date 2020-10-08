package com.qualitesoft.MBShopify.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class Registration {
	WebDriver driver;

	public Registration(WebDriver driver) {
		this.driver = driver;
	}
		
	public WebElement CreateNew() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-cyan']"), 40);
	}
	public WebElement fname() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='fisrtName']"), 40);
	}
	public WebElement lname() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='lastName']"), 40);
	}
	public WebElement email() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='email']"), 40);
	}
	public WebElement password() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='password']"), 40);
	}
	public WebElement confirmPassword() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='confirmPassword']"), 40);
	}
	public WebElement checkbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//checkbox[@name='agree']/div/label/span/span"), 40);
	}		
	public WebElement register() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-primary btn-round']"), 40);
	}	
	public WebElement closevideo() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("/html/body/my-app/layout/div[1]/div/muzeboard-list/div[4]/div[1]/div/div[1]/button"), 40);
	}

		
}

