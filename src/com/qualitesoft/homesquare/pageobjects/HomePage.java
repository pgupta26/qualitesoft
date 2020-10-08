package com.qualitesoft.homesquare.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement signUpLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//a[@href='/Components/MuzeBoard/loginSignup.aspx']"), 10);
	}

	
	public WebElement emailTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='body_Email']"), 10);
	}

	public WebElement passowrdTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='body_Password']"), 10);
	}

	public WebElement signUpButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@id='signUpBtn']"), 10);
	}

	public WebElement describeBestButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@id='body_btnProfessional']"), 30);
	}
	
	public WebElement signInLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/MyAccount/Login.aspx']"), 30);
	}
	
	public WebElement emailSigninTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='UserName']"), 10);
	}
	
	public WebElement passowrdSigninTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Password']"), 10);
	}
	
	public WebElement designerCheckbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='chkIsDesigner']"), 10);
	}
	
	public WebElement loginButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Login1']"), 10);
	}
	
	public WebElement homesquareLogo() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//img[@src='/images/homesquare-logo.png'])[1]"), 10);
	}

}
