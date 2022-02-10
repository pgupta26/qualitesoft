package com.qualitesoft.MBDesigner.testscripts;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qualitesoft.MBDesigner.pageobjects.RegisterAccount;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestRegisterAccount extends InitializeTest{
	@Test
	public void testRegisterAccount(){
		WebDriver driver = getDriver();
		WaitTool.sleep(8);
		RegisterAccount register = new RegisterAccount(driver);	
		ScreenShot.takeScreenShot(driver, "Registeration Page");
		SeleniumFunction.sendKeys(register.firstNameTextbox(), "TestSelenium_First");
		SeleniumFunction.sendKeys(register.lastNameTextbox(), "TestSelenium_Last");
		String email =emailAddress();
		System.out.println(email);
		SeleniumFunction.sendKeys(register.emailTextbox(), email);
		SeleniumFunction.sendKeys(register.passwordTextbox(), "Aa123456");
		SeleniumFunction.sendKeys(register.ConfirmPasswordTextbox(), "Aa123456");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,450)", "");
		WaitTool.sleep(5);
		SeleniumFunction.sendKeys(register.storeNameTextbox(), JavaFunction.randomText("store",10));	
		SeleniumFunction.click(register.agreeCheckBox());
		SeleniumFunction.click(register.signUpButton());
		WaitTool.sleep(25);
		ScreenShot.takeScreenShot(driver, "SignUp Page");
		
		jse.executeScript("window.scrollBy(0,450)", "");
		SeleniumFunction.click(register.rightArrow());
		ScreenShot.takeScreenShot(driver, "Selecting an inspiration image");
		SeleniumFunction.click(register.rightArrow());
		ScreenShot.takeScreenShot(driver, "Building your MuzeBoard");
		SeleniumFunction.click(register.rightArrow());
		ScreenShot.takeScreenShot(driver, "Writing the Description");
		
		jse.executeScript("window.scrollBy(0,250)", "");
		SeleniumFunction.click(register.continueButton());
		WaitTool.sleep(25);
}
	private static String emailAddress() {

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		//String emailAddress = "Selenium_" + dateFormat.format(date).replaceAll("\\s", "_") + "@email.com";
		String emailAddress1 = "mb" + dateFormat.format(date).replaceAll(" ", "") + "@email.com";
		String emailAddress = emailAddress1.replaceAll("-", "") ;
		return emailAddress;
	}
	
}