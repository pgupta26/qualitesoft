package com.qualitesoft.bush.testscripts;

import org.openqa.selenium.JavascriptExecutor;
//import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qualitesoft.bush.pageobjects.CartPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;


public class AddPayment extends InitializeTest {

	@Test
	public void testAddItemsToCart() {

		WebDriver driver = getDriver();
		CartPage cartPage = new CartPage(driver);
		//CreateNewAccount create = new CreateNewAccount();
		
		//If user buy without login as a guest user
	/*	String Emailid=RandomStringUtils.randomAlphanumeric(3).toLowerCase();
		 GuestEmailid ="test"+Emailid+"@g.com";
		System.out.println("GuestEmailid:"+GuestEmailid.trim());
		SeleniumFunction.sendKeys(cartPage.guestUserName(), GuestEmailid);
		SeleniumFunction.click(cartPage.continueButton());*/
		
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("window.scrollBy(0,350)", "");
		SeleniumFunction.click(cartPage.alreadyaccountButton());
		WaitTool.sleep(5);
		
		System.out.println(emailcreated);
		SeleniumFunction.sendKeys(cartPage.emailTextbox(),emailcreated);
		SeleniumFunction.sendKeys(cartPage.passwordTextbox(), "Aa123456");
		SeleniumFunction.click(cartPage.signinButton());
		WaitTool.sleep(5);
		SeleniumFunction.sendKeys(cartPage.firstName(), "test");
		SeleniumFunction.sendKeys(cartPage.lastName(), "one");
		SeleniumFunction.sendKeys(cartPage.address1(), "Selenium_Address");
		SeleniumFunction.sendKeys(cartPage.address2(), "Selenium_Address");
		SeleniumFunction.sendKeys(cartPage.zipcode(), "83341");
		System.out.println(" zip code  83341");
		SeleniumFunction.sendKeys(cartPage.city(), "Selenium_city");
		SeleniumFunction.select(cartPage.country(), "United States");
		WaitTool.sleep(5);
		SeleniumFunction.select(cartPage.state(), "Alabama");
		
		SeleniumFunction.sendKeys(cartPage.phone(), "4444444444");
		SeleniumFunction.sendKeys(cartPage.SpecialDelivery(), "test");
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "shipping info");
		SeleniumFunction.click(cartPage.reviewButton());
		WaitTool.sleep(5);
		SeleniumFunction.click(cartPage.reviewButton()); //continue payment		
		
	}
}
