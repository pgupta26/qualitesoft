package com.qualitesoft.homesquare.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymax.pageobjects.CartPage;

public class TestHomeSquareShippingInfo extends InitializeTest {
	@Test
	public void testCreateNewAccount() {

		WebDriver driver = getDriver(); 
		CartPage cartPage = new CartPage(driver);
		//If user buy without login as a guest user
/*		String Emailid=RandomStringUtils.randomAlphanumeric(3).toLowerCase();
		 GuestEmailid ="test"+Emailid+"@g.com";
		System.out.println("GuestEmailid:"+GuestEmailid.trim());
		SeleniumFunction.sendKeys(cartPage.guestUserName(), GuestEmailid);
		SeleniumFunction.click(cartPage.continueButton());*/
		WaitTool.sleep(3);
		ScreenShot.takeScreenShot(driver, "CheckOut Page");
		/*SeleniumFunction.click(cartPage.alreadyaccountButton());
		WaitTool.sleep(3);
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("window.scrollBy(0,250)", "");
		 System.out.println("emailuser "+TestHomeSquareCreateNewAccount.emailuser);
		SeleniumFunction.sendKeys(cartPage.emailTextbox(), TestHomeSquareCreateNewAccount.emailuser);
		SeleniumFunction.sendKeys(cartPage.passwordTextbox(), "123456");
		
		ScreenShot.takeScreenShot(driver, "Logged in user Info");
		SeleniumFunction.click(cartPage.signinButton());*/
		
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
		ScreenShot.takeScreenShot(driver, "review order");
		SeleniumFunction.click(cartPage.reviewButton()); //continue payment		
		
	}


}
