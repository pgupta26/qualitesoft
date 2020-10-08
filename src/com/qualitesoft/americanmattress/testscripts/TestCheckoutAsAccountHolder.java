package com.qualitesoft.americanmattress.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.qualitesoft.americanmattress.pageobjects.ConfirmationPage;
import com.qualitesoft.americanmattress.pageobjects.GuestCustomerPage;
import com.qualitesoft.americanmattress.pageobjects.PaymentPage;
import com.qualitesoft.americanmattress.pageobjects.ProductPage;
import com.qualitesoft.americanmattress.pageobjects.ReviewYourOrderPage;
import com.qualitesoft.americanmattress.pageobjects.ShippingInformationPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestCheckoutAsAccountHolder extends InitializeTest{
	
	@Test
	public void testCheckoutAsAccountHolder(){
		
/*		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		SeleniumFunction.click(shoppingCartPage.proceedToCheckoutButton());*/
		
		
		ProductPage productPage = new ProductPage(driver);
		SeleniumFunction.click(productPage.ProceedButton());
		
		GuestCustomerPage guestCustomerPage = new GuestCustomerPage(driver);
		guestCustomerPage.emailAddressTextfield();
		ScreenShot.takeScreenShot(driver, "GuestcustomerPage");
		SeleniumFunction.sendKeys(guestCustomerPage.emailAddressTextfield(), TestCreateNewAccount.emailAddress);
		WaitTool.sleep(1);
		SeleniumFunction.sendKeys(guestCustomerPage.passwordTextfield(), "Cymax123");
		WaitTool.sleep(10);
		SeleniumFunction.click(guestCustomerPage.signInButton());
		WaitTool.sleep(3);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,450)", "");
		ShippingInformationPage shippingInformationPage = new ShippingInformationPage(driver);
		if(driver.findElements(By.xpath("//form[@id='formShippingInformation']//div//div[2]//div//h4//a//span"))!= null){
			//jse.executeScript("window.scrollBy(0,350)", "");
			SeleniumFunction.click(shippingInformationPage.deliver());
	    	}else{
	    	System.out.println("Element is Absent");
	    	}
		
		jse.executeScript("window.scrollBy(0,-250)", "");
		//shippingInformationPage.reviewOrderButton();
		SeleniumFunction.sendKeys(shippingInformationPage.firstNameTextfield(), "SeleniumFirst");
		SeleniumFunction.sendKeys(shippingInformationPage.lastNameTextfield(), "SeleniumLast");
		SeleniumFunction.sendKeys(shippingInformationPage.addressTextfield(), "SeleniumAddress");
		SeleniumFunction.sendKeys(shippingInformationPage.zipCodeTextfield(), "99501");
		SeleniumFunction.sendKeys(shippingInformationPage.cityTextfield(), "SeleniumCity");
		SeleniumFunction.select(shippingInformationPage.countryDropdown(), "USA");
		shippingInformationPage.stateDropdownWaitForOptions();
		WaitTool.sleep(2);
		
		jse.executeScript("window.scrollBy(0,250)", "");
		SeleniumFunction.select(shippingInformationPage.stateDropdown(), "Alabama");
		SeleniumFunction.sendKeys(shippingInformationPage.phoneTextfield(), "907-465-2111");
		ScreenShot.takeScreenShot(driver, "ShippingInformationPage");
		WaitTool.sleep(2);
		jse.executeScript("window.scrollBy(0,250)", "");
		SeleniumFunction.click(shippingInformationPage.reviewOrderButton());
		
		ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(driver);
		reviewYourOrderPage.continueToPaymentButton();
		WaitTool.sleep(6);
		ScreenShot.takeScreenShot(driver, "ReviewOrderPage");
		jse.executeScript("window.scrollBy(0,250)", "");
		SeleniumFunction.click(reviewYourOrderPage.continueToPaymentButton());
		
		PaymentPage paymentPage = new PaymentPage(driver);
		paymentPage.creditCardNameTextfield();
		ScreenShot.takeScreenShot(driver, "PaymentPage");
		SeleniumFunction.sendKeys(paymentPage.creditCardNumberTextfield(), "4111111111111111");
		WaitTool.sleep(2);
		SeleniumFunction.sendKeys(paymentPage.creditCardNameTextfield(), "Selenium");
		WaitTool.sleep(2);
		SeleniumFunction.select(paymentPage.expiryDateDropdown(), "01 (Jan)");
		WaitTool.sleep(2);
		SeleniumFunction.select(paymentPage.yearDropdown(), "2019");
		WaitTool.sleep(2);
		CharSequence chars = "123";
		jse.executeScript("window.scrollBy(0,250)", "");
		SeleniumFunction.sendKeysAction(driver, paymentPage.securityCodeTextbox(), chars);
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "PaymentPageFilled");
		WaitTool.sleep(6);
		SeleniumFunction.sendKeysAction(driver, paymentPage.placeOrderButton(), Keys.ENTER);
		
		//paymentPage.validation();
		
		
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		confirmationPage.returnToHomepageButton();
		ScreenShot.takeScreenShot(driver, "ConfirmationPage");	
		WaitTool.sleep(20);
	}
}
