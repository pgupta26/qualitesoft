package com.qualitesoft.cymax.testscripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymax.pageobjects.HomePage;
import com.qualitesoft.cymax.pageobjects.MyAccountPage;
import com.qualitesoft.cymax.pageobjects.OrderConfirmationPage;

public class OrderConfirmation1 extends InitializeTest {

	@Test
	public void testOrderConfirmation() {

		OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
		WebElement orderNumber = orderConfirmationPage.orderNumber();
		ScreenShot.takeScreenShot(driver, "OrderConfirmationPage");
		String orderNumberString = SeleniumFunction.getText(orderNumber);
		System.out.println("Orderid :" + orderNumberString);
		Log.info("Order Id on Order Confirmation page: " + orderNumberString);
		SeleniumFunction.click(orderConfirmationPage.cymaxLogoImg());
		HomePage homePage = new HomePage(driver);
		WebElement myAccountLink = homePage.myAccountLink();
		ScreenShot.takeScreenShot(driver, "HomePage");
		SeleniumFunction.click(myAccountLink);
		WaitTool.sleep(5);
		
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		//enter username and id(GuestUser)
		/*System.out.println("GuestEmailid:"+emailAddress);
		SeleniumFunction.sendKeys(myAccountPage.emailTextbox(),emailAddress.trim());
		SeleniumFunction.sendKeys(myAccountPage.passwordTextbox(),"CymaxQa1234");
		SeleniumFunction.click(myAccountPage.Loginbutton());
		WaitTool.sleep(10);*/
		
		
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
