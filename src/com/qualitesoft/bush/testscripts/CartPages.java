package com.qualitesoft.bush.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.bush.pageobjects.CartPage;
import com.qualitesoft.bush.pageobjects.CheckoutPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;


public class CartPages extends InitializeTest{
	
	@Test
	public void testCartPages(){
		
		CartPage cartPage = new CartPage(driver);
		//SeleniumFunction.click(cartPage.checkoutButton());
		
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		//WebElement shippingSameAsBillingCheckbox = checkoutPage.shippingSameAsBillingCheckbox();
		//ScreenShot.takeScreenShot(driver, "CheckoutPage");
		//SeleniumFunction.click(shippingSameAsBillingCheckbox);
		//ScreenShot.takeScreenShot(driver, "ShippingSameAsBillingCheckboxClicked");
		//SeleniumFunction.click(checkoutPage.paymentRadioButton());
		SeleniumFunction.sendKeys(checkoutPage.creditCardNumberTextbox(), "4111111111111111");
		SeleniumFunction.select(checkoutPage.expiryMonthDropdown(), "01 (Jan)");
		SeleniumFunction.select(checkoutPage.expiryYearDropdown(), "2021");
		SeleniumFunction.sendKeys(checkoutPage.securityCodeTextbox(), "123");
		SeleniumFunction.sendKeys(checkoutPage.cardHolderNameTextbox(), "Selenium Cymax");
		ScreenShot.takeScreenShot(driver, "Payment info");
		//SeleniumFunction.click(checkoutPage.placeYourOrderButton());
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("window.scrollBy(0,550)", "");
		SeleniumFunction.click(cartPage.reviewButton());//place my order
	}
}
