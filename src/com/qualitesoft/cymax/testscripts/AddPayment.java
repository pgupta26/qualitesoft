package com.qualitesoft.cymax.testscripts;

//import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymax.pageobjects.CartPage;

public class AddPayment extends InitializeTest {

	@Test
	public void testAddItemsToCart() {

		WebDriver driver = getDriver();
		CartPage cartPage = new CartPage(driver);

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
		SeleniumFunction.click(cartPage.reviewButton()); // continue payment

	}
}
