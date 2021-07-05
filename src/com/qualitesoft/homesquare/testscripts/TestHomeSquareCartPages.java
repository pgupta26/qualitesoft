package com.qualitesoft.homesquare.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.homesquare.pageobjects.CartPage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareCartPage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareCheckoutPage;



public class TestHomeSquareCartPages extends InitializeTest{
	
	@Test
	public void testCartPages(){
		CartPage cartPage1 = new CartPage(driver);
		HomeSquareCartPage cartPage = new HomeSquareCartPage(driver);
		//SeleniumFunction.click(cartPage.checkoutButton());
		
		HomeSquareCheckoutPage checkoutPage = new HomeSquareCheckoutPage(driver);
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
		ScreenShot.takeScreenShot(driver, "CheckoutPageFilled");
		//SeleniumFunction.click(checkoutPage.placeYourOrderButton());
		SeleniumFunction.click(cartPage1.reviewButton());//place my order
	}
}
