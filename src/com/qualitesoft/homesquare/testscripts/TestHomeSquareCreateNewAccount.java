package com.qualitesoft.homesquare.testscripts;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.homesquare.pageobjects.CreateAccountPage;
import com.qualitesoft.homesquare.pageobjects.HomePage;
import com.qualitesoft.homesquare.pageobjects.LoginPage;


public class TestHomeSquareCreateNewAccount extends InitializeTest{
	public static String emailuser;
	@Test
	public void testshippinginfo(){
		
		WebDriver driver = getDriver();
		
		HomePage homePage = new HomePage(driver);
		//SeleniumFunction.click(homePage.HomeSqcloseButton());	
		WebElement myAccountLink = homePage.HomeSqmyAccountLink();
		//ScreenShot.takeScreenShot(driver, "HomePage");
		SeleniumFunction.click(myAccountLink);
		
		LoginPage loginPage = new LoginPage(driver);
		WebElement createNewAccountLink = loginPage.HomeSqcreateNewAccountLink();
		//ScreenShot.takeScreenShot(driver, "LoginPage");
		SeleniumFunction.click(createNewAccountLink);
		
		CreateAccountPage createAccountPage = new CreateAccountPage(driver);
		WebElement firstNameTextbox = createAccountPage.HomeSqfirstNameTextbox();
		ScreenShot.takeScreenShot(driver, "CreateAccountPage");
		SeleniumFunction.sendKeys(firstNameTextbox, "Selenium_First");
		SeleniumFunction.sendKeys(createAccountPage.HomeSqlastNameTextbox(), "Selenium_Last");
		emailAddress=emailAddress();
		System.out.println(emailAddress);
		SeleniumFunction.sendKeys(createAccountPage.HomeSqemailTextbox(), emailAddress);
		SeleniumFunction.sendKeys(createAccountPage.HomeSqpasswordTextbox(), "CymaxQa1234");
		SeleniumFunction.sendKeys(createAccountPage.HomeSqconfirmPasswordTextbox(), "CymaxQa1234");
		ScreenShot.takeScreenShot(driver, "CreateAccountPageFilled");		 
		SeleniumFunction.click(createAccountPage.HomeSqregisterButton());
		WaitTool.sleep(5);
	} 
	
	private static String emailAddress() {

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH-mm-ss");
		//String emailAddress = "Selenium_" + dateFormat.format(date).replaceAll("\\s", "_") + "@email.com";
		String emailAddress1 = "cymax" + dateFormat.format(date).replaceAll(" ", "") + "@yopmail.com";
		String emailAddress = emailAddress1.replaceAll("-", "") ;
		return emailAddress;
	}

}
