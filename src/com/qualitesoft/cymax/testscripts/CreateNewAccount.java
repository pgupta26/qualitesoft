package com.qualitesoft.cymax.testscripts;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.cymax.pageobjects.CreateAccountPage;
import com.qualitesoft.cymax.pageobjects.HomePage;
import com.qualitesoft.cymax.pageobjects.LoginPage;

public class CreateNewAccount extends InitializeTest{
	
	@Test
	public void testCreateNewAccount(){
				
		HomePage homePage = new HomePage(driver);
		if(homePage.cymaxPopup()!=null) {
			SeleniumFunction.click(homePage.cymaxPopup());
		}
		//WebElement myAccountLink = ;
		//SeleniumFunction.click(homePage.noThanks()); //to remove popup
		//ScreenShot.takeScreenShot(driver, "HomePage");
		SeleniumFunction.click(homePage.myAccountLink());
		
		LoginPage loginPage = new LoginPage(driver);
		WebElement createNewAccountLink = loginPage.createNewAccountLink();
		ScreenShot.takeFullScreenShot("LoginPage");
		SeleniumFunction.click(createNewAccountLink);

		CreateAccountPage createAccountPage = new CreateAccountPage(driver);
		WebElement firstNameTextbox = createAccountPage.firstNameTextbox();
		ScreenShot.takeScreenShot(driver, "CreateAccountPage");
		SeleniumFunction.sendKeys(firstNameTextbox, "TestSelenium_First");
		SeleniumFunction.sendKeys(createAccountPage.lastNameTextbox(), "TestSelenium_Last");
		emailAddress = this.emailAddress();
		System.out.println("*******************************************************Email address Created: "+emailAddress);
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
		SeleniumFunction.sendKeys(createAccountPage.phoneTextbox(), "1234567890");
		SeleniumFunction.sendKeys(createAccountPage.commentTextbox(), "Selenium_Comment");
		ScreenShot.takeFullScreenShot("Create Account Entered Detail");
		SeleniumFunction.click(createAccountPage.registerButton());
		
		/*MyAccountPage myAccountPage = new MyAccountPage(driver);
		WebElement kitchenAndDiningLink = myAccountPage.kitchenAndDiningLink();*/
		//ScreenShot.takeScreenShot(driver, "MyAccountPage");
		
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
