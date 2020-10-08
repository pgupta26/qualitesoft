package com.qualitesoft.homesquare.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qualitesoft.core.WaitTool;

public class ProfileInfoMuzeboardPage {
	
	WebDriver driver;

	public ProfileInfoMuzeboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement aboutMeTextbox() {

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//textarea[@name='aboutProfessional']"))).build().perform();
		return WaitTool.returnWebElement(driver, By.xpath("//textarea[@name='aboutProfessional']"));
	}
	
	public WebElement contactInfoLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='#mb-user-contact-pane']"), 60);
	}
	
	public WebElement zipCodeTextbox() {

		return WaitTool.returnWebElement(driver, By.xpath("(//input[@class='form-control input-lg create-pro-profile-input mandatory'])[2]"));
	}
	
	public WebElement licenseNumberTextbox() {

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//input[@id='Phone']"))).build().perform();
		return WaitTool.returnWebElement(driver, By.xpath("//input[@id='Phone']"));
	}
	
	public WebElement saveButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@id='mb-user-btn-save']"), 60);
	}

}
