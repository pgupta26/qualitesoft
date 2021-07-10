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
import com.qualitesoft.homesquare.pageobjects.HomeSquareCreateAccountPage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareHomePage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareLoginPage;


public class TestHomeSquareCreateNewAccount extends InitializeTest{
	public static String emailuser;
	@Test
	public void testshippinginfo(){
		
		WebDriver driver = getDriver();
		
		HomeSquareHomePage homePage = new HomeSquareHomePage(driver);
		//SeleniumFunction.click(homePage.HomeSqcloseButton());	
		WebElement myAccountLink = homePage.HomeSqmyAccountLink();
		//ScreenShot.takeScreenShot(driver, "HomePage");
		SeleniumFunction.click(myAccountLink);
		
		HomeSquareLoginPage loginPage = new HomeSquareLoginPage(driver);
		WebElement createNewAccountLink = loginPage.HomeSqcreateNewAccountLink();
		//ScreenShot.takeScreenShot(driver, "LoginPage");
		SeleniumFunction.click(createNewAccountLink);
		
		HomeSquareCreateAccountPage createAccountPage = new HomeSquareCreateAccountPage(driver);
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
