package com.qualitesoft.bush.testscripts;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.bush.pageobjects.CreateAccountPage;
import com.qualitesoft.bush.pageobjects.HomePage;
import com.qualitesoft.bush.pageobjects.LoginPage;


public class CreateNewAccount extends InitializeTest{


	@Test
	public void testCreateNewAccount(){

		HomePage homePage = new HomePage(driver);
		WebElement myAccountLink = homePage.myAccountLink();
		//SeleniumFunction.click(homePage.noThanks()); //to remove popup
		//ScreenShot.takeScreenShot(driver, "HomePage");
		SeleniumFunction.click(myAccountLink);
		
		LoginPage loginPage = new LoginPage(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		WebElement createNewAccountLink = loginPage.createNewAccountLink();
		ScreenShot.takeScreenShot(driver, "LoginPage");

		SeleniumFunction.click(createNewAccountLink);

		CreateAccountPage createAccountPage = new CreateAccountPage(driver);
		WebElement firstNameTextbox = createAccountPage.firstNameTextbox();
		ScreenShot.takeScreenShot(driver, "CreateAccountPage");
		SeleniumFunction.sendKeys(firstNameTextbox, "TestSelenium_First");
		SeleniumFunction.sendKeys(createAccountPage.lastNameTextbox(), "TestSelenium_Last");
		emailAddress = this.emailAddress();
		System.out.println("*******************************************************8Email address Created: "+emailAddress);
		SeleniumFunction.sendKeys(createAccountPage.emailTextbox(), emailAddress());
		SeleniumFunction.sendKeys(createAccountPage.passwordTextbox(), "CymaxQa1234");
		SeleniumFunction.sendKeys(createAccountPage.confirmPasswordTextbox(), "CymaxQa1234");
		SeleniumFunction.sendKeys(createAccountPage.companyNameTextbox(), "Selenium_Cymax");
		SeleniumFunction.sendKeys(createAccountPage.streetAddressTextBox(), "Selenium_Street");
		SeleniumFunction.sendKeys(createAccountPage.addressLine2TextBox(), "Selenium_Street1");
		SeleniumFunction.sendKeys(createAccountPage.cityTextBox(), "Selenium_City");
		SeleniumFunction.select(createAccountPage.countryDropdown(), "United States");
		SeleniumFunction.select(createAccountPage.stateDropdown(), "Alabama");
		SeleniumFunction.sendKeys(createAccountPage.zipCodeTextbox(), "35004");
		SeleniumFunction.sendKeys(createAccountPage.phoneTextbox(), "123456");
		SeleniumFunction.sendKeys(createAccountPage.commentTextbox(), "Selenium_Comment");
		ScreenShot.takeScreenShot(driver, "CreateAccountPageFilled");
		SeleniumFunction.click(createAccountPage.registerButton());
	} 

	private static String emailAddress() {

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		//String emailAddress = "Selenium_" + dateFormat.format(date).replaceAll("\\s", "_") + "@email.com";
		String emailAddress1 = "cymax" + dateFormat.format(date).replaceAll(" ", "") + "@yopmail.com";
		emailAddress = emailAddress1.replaceAll("-", "") ;
		return emailAddress;
	}

}
