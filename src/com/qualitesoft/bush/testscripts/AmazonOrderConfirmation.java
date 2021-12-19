package com.qualitesoft.bush.testscripts;

import java.text.NumberFormat;
import java.text.ParseException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.bush.pageobjects.HomePage;
import com.qualitesoft.bush.pageobjects.MyAccountPage;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymax.pageobjects.CartPage;
import com.qualitesoft.cymax.pageobjects.OrderConfirmationPage;

public class AmazonOrderConfirmation extends InitializeTest{

	@Test
	public void testOrderConfirmation() throws ParseException {

		ScreenShot.takeFullScreenShot("OrderConfirmationPage");
		CartPage cartPage = new CartPage(driver);
		NumberFormat f = NumberFormat.getInstance(); 

		Assert.assertEquals(f.parse(cartPage.productPrice().replace("$", "")).doubleValue(), (productPrice * 2));
		Assert.assertEquals(cartPage.shipping(), fastShipping);
		Assert.assertEquals(cartPage.tax(), amazonTax);
		WaitTool.sleep(15);
		OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
		orderConfirmationPage.successMsg();
		WebElement orderNumber = orderConfirmationPage.orderNumber();
		String orderNumberString = SeleniumFunction.getText(orderNumber);
		Log.info("Order Id on Order Confirmation page: " + orderNumberString);

		SeleniumFunction.click(orderConfirmationPage.cymaxLogoImg());
		/*HomePage homePage = new HomePage(driver);
		WebElement myAccountLink = homePage.myAccountLink();
		ScreenShot.takeScreenShot(driver, "HomePage");
		SeleniumFunction.click(myAccountLink);
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
			Assert.fail("Order Id did not matched on Order confirmation and My Account page");
		}*/

		}

	}
