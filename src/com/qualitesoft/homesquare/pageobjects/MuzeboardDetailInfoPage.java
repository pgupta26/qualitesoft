package com.qualitesoft.homesquare.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class MuzeboardDetailInfoPage {
	
	WebDriver driver;

	public MuzeboardDetailInfoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement businessDescriptionTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//textarea[@name='aboutProfessional']"), 10);
	}
	
	public WebElement servicesProvidedTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//textarea[@name='servicesProvided']"), 10);
	}
	
	public WebElement areaServedTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//textarea[@name='areasServed']"), 10);
	}
	
	public WebElement websiteTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='website']"), 10);
	}
	
	public WebElement licensenoTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='licenseNumber']"), 10);
	}
	
	public WebElement certsAndAwardsTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//textarea[@name='awardsCertification']"), 10);
	}
	
	public WebElement affiliationsTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//textarea[@name='affiliations']"), 10);
	}
	
	public WebElement saveProfileButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='Overview.aspx']"), 10);
	}
	
	public WebElement imageUploadButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@id='modify-user-pickfiles']"), 10);
	}
	
	public void uploadProficPicChrome() {

		try {
			SeleniumFunction.clickAction(driver, imageUploadButton());
			String[] path = {
					System.getProperty("user.dir") + "\\binaries\\muzeboard\\logo.jpg" };
			SeleniumFunction.runAutoItScript("logoUploadchrome.exe", path[0]);
			WaitTool.waitForElementPresentAndDisplay(driver,
					By.xpath("//canvas"), 20);
		} catch (Exception e) {
			Log.error("Not able to upload file: " + e.getMessage());
			throw e;
		}
	}
	

}
