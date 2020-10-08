package com.qualitesoft.cymax.testscripts;

import java.text.NumberFormat;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymax.pageobjects.CartPage;
import com.qualitesoft.cymax.pageobjects.PaymentInformationPage;
import com.qualitesoft.cymax.pageobjects.PaypalCheckout;

public class PaymentInformation extends InitializeTest {

	@Test
	public void testPurchaseOrder() {

		try {
			CartPage cartPage = new CartPage(driver);
			NumberFormat f = NumberFormat.getInstance(); 
			if(suiteName.contains("Homesquare")) {
				Assert.assertEquals(f.parse(cartPage.productPrice().replace("$", "")).doubleValue(), (productPrice * 2));
			} else {
				Assert.assertEquals(f.parse(cartPage.productPrice().replace("$", "")).doubleValue(), (productPrice * 2));
			}
			Assert.assertEquals(cartPage.shipping(), shipping);
			Assert.assertEquals(cartPage.tax(), tax);
			ScreenShot.takeFullScreenShot("Payment Information Page");

			PaymentInformationPage paymentInfoPage = new PaymentInformationPage(driver);
			paymentInfoPage.selectPO();
			WaitTool.sleep(2);
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='cart-box-buttons margin-top-20 row']/descendant::button[@title='Place order']"), 10));
			WaitTool.sleep(30);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void testPaymentInformation() {
		try {
			CartPage cartPage = new CartPage(driver);
			NumberFormat f = NumberFormat.getInstance(); 
			Assert.assertEquals(f.parse(cartPage.productPrice().replace("$", "")).doubleValue(), (productPrice * 2));
			Assert.assertEquals(cartPage.shipping(), fastShipping);
			Assert.assertEquals(cartPage.tax(), amazonTax);
			ScreenShot.takeFullScreenShot("Payment Information Page");
			SeleniumFunction.click(cartPage.reviewButton());
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void testPaypal() {
		try{
			CartPage cartPage = new CartPage(driver);
			NumberFormat f = NumberFormat.getInstance(); 
			if(suiteName.contains("Homesquare")) {
				Assert.assertEquals(f.parse(cartPage.productPrice().replace("$", "")).doubleValue(), (productPrice * 2));
			} else {
				Assert.assertEquals(f.parse(cartPage.productPrice().replace("$", "")).doubleValue(), (productPrice * 2));
			}
			Assert.assertEquals(cartPage.shipping(), shipping);
			Assert.assertEquals(cartPage.tax(), tax);
			ScreenShot.takeFullScreenShot("Payment Information Page");
			
			PaymentInformationPage paymentInfoPage = new PaymentInformationPage(driver);
			paymentInfoPage.selectPaypal();
			WaitTool.sleep(5);
			paymentInfoPage.payWithPaypal();
			WaitTool.sleep(30);
			
			//Switch to Paypal window
			ScreenShot.takeFullScreenShot("PayPal Window");
			SeleniumFunction.getCurrentWindow(driver);
			Log.info("Switch to Window Title: "+driver.getTitle());
			driver.manage().window().maximize();
			PaypalCheckout payPalCheckOut = new PaypalCheckout(driver);
			payPalCheckOut.payPalLogIn();
			ScreenShot.takeFullScreenShot("PayPal Log In");
			payPalCheckOut.email("raj.cymax@gmail.com");
			payPalCheckOut.next();
			payPalCheckOut.password("Welcome@2");
			payPalCheckOut.signInButton();
			WaitTool.sleep(30);
			payPalCheckOut.changeLink();
			WaitTool.sleep(2);
			if(suiteName.contains("Homesquare")) {
				Assert.assertEquals(payPalCheckOut.infoMessage().trim(), "This is the address provided by Homesquare. To change it, return to Homesquare before completing your purchase.");
			} else {
				Assert.assertEquals(payPalCheckOut.infoMessage().trim(), "This is the address provided by Cymax Stores. To change it, return to Cymax Stores before completing your purchase.");
			}
			ScreenShot.takeFullScreenShot("PayPal Information Page");
			payPalCheckOut.payNow();
		    SeleniumFunction.getCurrentWindow(driver); 
			WaitTool.sleep(40);	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
