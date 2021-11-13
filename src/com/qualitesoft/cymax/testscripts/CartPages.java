package com.qualitesoft.cymax.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.cymax.pageobjects.CartPage;
import com.qualitesoft.cymax.pageobjects.CheckoutPage;

public class CartPages extends InitializeTest {

	@Test
	public void testCartPages() {

		CartPage cartPage = new CartPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		SeleniumFunction.sendKeys(checkoutPage.creditCardNumberTextbox(), "4111111111111111");
		SeleniumFunction.select(checkoutPage.expiryMonthDropdown(), "01 (Jan)");
		SeleniumFunction.select(checkoutPage.expiryYearDropdown(), "2031");
		SeleniumFunction.sendKeys(checkoutPage.securityCodeTextbox(), "123");
		SeleniumFunction.sendKeys(checkoutPage.cardHolderNameTextbox(), "Selenium Cymax");
		ScreenShot.takeScreenShot(driver, "Payment info");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,550)", "");
		SeleniumFunction.click(cartPage.reviewButton());// place my order
	}

}
