package com.qualitesoft.constantretail.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qualitesoft.core.WaitTool;

public class ReportPage{
	
	WebDriver driver;

	public ReportPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement reportsLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/reports']"), 60);
	}

	public WebElement categories() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='selectCategory']"), 60);
	}

	public WebElement reports() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='selectReport']"), 60);
	}
	
	public WebElement dateFrom() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='param_11']"), 60);
	}
	
	public WebElement dateTo() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='param_12']"), 60);
	}
	
	public WebElement runReport() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='report-content']/div/div/div[1]/div/div[3]/div/button"), 60);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-success btn-search margin-top-20 pull-right']"), 60);
	}




}	