package com.qualitesoft.constantretail.testscripts;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qualitesoft.constantretail.pageobjects.LoginPage;
import com.qualitesoft.constantretail.pageobjects.RegisterPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class CreateNewUser extends InitializeTest {

	public CreateNewUser() {
	}

	@Test
	public void testCreateNewUser() {

		WebDriver driver = getDriver();
		LoginPage loginPage = new LoginPage(driver);
		ScreenShot.takeScreenShot(driver, "LoginPage");
		SeleniumFunction.click(loginPage.signUpLink());
		WaitTool.sleep(4);
		RegisterPage registerPage = new RegisterPage(driver);
		ScreenShot.takeScreenShot(driver, "RegisterPage");
		SeleniumFunction.sendKeys(registerPage.firstNameTextBox(), "TestSelenium_First");
		SeleniumFunction.sendKeys(registerPage.lastNameTextBox(), "TestSelenium_Last");
		String email =emailAddressRandom();
		System.out.println(email);
		SeleniumFunction.sendKeys(registerPage.emailTextBox(), email);
		SeleniumFunction.sendKeys(registerPage.createPasswordTextBox(), "Password");
		SeleniumFunction.sendKeys(registerPage.confirmPassowrdTextBox(), "Password");
		ScreenShot.takeScreenShot(driver, "RegisterPageFilled");
		SeleniumFunction.click(loginPage.termsCondition());
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		SeleniumFunction.click(registerPage.signUpLink());
		WaitTool.sleep(20);	
		//registerPage.validationSummaryMsg();
	}

	private static String emailAddress() {

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String emailAddress = "Selenium_" + dateFormat.format(date).replaceAll("\\s", "_") + "@email.com";
		return emailAddress;
	}
	
	private static String emailAddressRandom() {

		String emailAddress = JavaFunction.randomText("Selenium", 4) + "@email.com";
		return emailAddress;
	}
}
