package com.qualitesoft.FCsalesinquiryformsubmission.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class ContactUsLink {

	WebDriver driver;

	public ContactUsLink(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement contactusLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='https://www.freightclub.com/contact-us/']"), 30);
	}
	public WebElement contactourAgent() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"post-56996\"]/div/div/div/div/div/div/div[2]/div/div/div/div/div[1]/h3/span"), 30);
	}
	
	public WebElement name() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='your-name']"), 30);
	}
	public WebElement subject() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//textarea[@name='your-subject']"), 30);
	}
	public WebElement email() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='your-email']"), 30);
	}
	public WebElement message() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"wpcf7-f57200-p56996-o1\"]/form/p[2]/span/textarea"), 30);
	}
	public WebElement sendmessage() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@type='submit']"), 30);
	}
	public WebElement successMessage() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ok']"), 30);
	}
}
