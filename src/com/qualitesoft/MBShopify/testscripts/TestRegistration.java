package com.qualitesoft.MBShopify.testscripts;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.qualitesoft.MBShopify.pageobjects.AddProduct;
import com.qualitesoft.MBShopify.pageobjects.CreateNewStore;
import com.qualitesoft.MBShopify.pageobjects.DisablePassword;
import com.qualitesoft.MBShopify.pageobjects.InstallMuzeBoard;
import com.qualitesoft.MBShopify.pageobjects.Registration;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestRegistration extends InitializeTest{
	@Test
	public void testRegistration(){
		WebDriver driver = getDriver();
		Registration reg = new Registration(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		SeleniumFunction.click(reg.CreateNew());
		ScreenShot.takeScreenShot(driver, "Create New Muzeboard Account");
		WaitTool.sleep(4);
		SeleniumFunction.sendKeys(reg.fname(),"test");
		SeleniumFunction.sendKeys(reg.lname(),"test");
		SeleniumFunction.sendKeys(reg.email(), emailAddress());
		SeleniumFunction.sendKeys(reg.password(),"123456");
		SeleniumFunction.sendKeys(reg.confirmPassword(),"123456");
		SeleniumFunction.click(reg.checkbox());
		SeleniumFunction.click(reg.register());
		WaitTool.sleep(9);
		ScreenShot.takeScreenShot(driver, "Admin portal after registration");
		SeleniumFunction.click(reg.closevideo());
		ScreenShot.takeScreenShot(driver, "Video popup closed");
		

	
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
