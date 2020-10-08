package com.qualitesoft.cymax.testscripts;

import java.text.NumberFormat;
import java.text.ParseException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymax.pageobjects.CartPage;
import com.qualitesoft.cymax.pageobjects.HomePage;
import com.qualitesoft.cymax.pageobjects.MyAccountPage;
import com.qualitesoft.cymax.pageobjects.OrderConfirmationPage;

public class OrderConfirmation extends InitializeTest {

	@Test
	public void testOrderConfirmation() throws ParseException {

		OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
		orderConfirmationPage.close();
		WaitTool.sleep(2);
		ScreenShot.takeFullScreenShot("OrderConfirmationPage");
		CartPage cartPage = new CartPage(driver);
		NumberFormat f = NumberFormat.getInstance(); 
		if(suiteName.contains("Homesquare")) {
			Assert.assertEquals(f.parse(cartPage.productPrice().replace("$", "")).doubleValue(), (productPrice * 2));
		} else {
			Assert.assertEquals(f.parse(cartPage.productPrice().replace("$", "")).doubleValue(), (productPrice * 2));
		}
		Assert.assertEquals(cartPage.shipping(), shipping);
		Assert.assertEquals(cartPage.tax(), tax);
		WaitTool.sleep(15);

		orderConfirmationPage.successMsg();
		WebElement orderNumber = orderConfirmationPage.orderNumber();
		String orderNumberString = SeleniumFunction.getText(orderNumber);
		Log.info("Order Id on Order Confirmation page: " + orderNumberString);
		
		SeleniumFunction.click(orderConfirmationPage.cymaxLogoImg());
		HomePage homePage = new HomePage(driver);
		if(suiteName.contains("Homesquare")) {
			WebElement myAccountLink = homePage.HomeSqmyAccountLink();
			ScreenShot.takeScreenShot(driver, "HomePage");
			SeleniumFunction.click(myAccountLink);
			SeleniumFunction.click(homePage.HomeSqmyOrder());

		} else {
			WebElement myAccountLink = homePage.myAccountLink();
			ScreenShot.takeScreenShot(driver, "HomePage");
			SeleniumFunction.click(myAccountLink);
		}
		
		WaitTool.sleep(5);
		
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		WebElement orderId = myAccountPage.orderId();
		ScreenShot.takeScreenShot(driver, "OrderOnMyAccount");
		String orderIdString = SeleniumFunction.getText(orderId);
		System.out.println("Orderid account :" + orderIdString);
		Log.info("Order Id on My Account page: " + orderIdString);

		if (orderNumberString.equalsIgnoreCase(orderIdString)) {
			Log.info("Order Id matched on Order confirmation and My Account page");
		} else {
			Log.error("Order Id did not matched on Order confirmation and My Account page");
			Assert.fail();
		}
	}
}
