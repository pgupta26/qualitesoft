package com.qualitesoft.homesquare.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.homesquare.pageobjects.HomePage;
import com.qualitesoft.homesquare.pageobjects.MyAccountPage;
import com.qualitesoft.homesquare.pageobjects.OrderConfirmationPage;


public class TestHomeSquareOrderConfirmation extends InitializeTest {

	@Test
	public void testOrderConfirmation() {

		OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
		//order page
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("Categories.readPopular()");
		WebElement orderNumber = orderConfirmationPage.orderNumber();
		ScreenShot.takeScreenShot(driver, "OrderConfirmationPage");
		String orderNumberString = SeleniumFunction.getText(orderNumber);
		Log.info("Order Id on Order Confirmation page: " + orderNumberString);
		SeleniumFunction.click(orderConfirmationPage.cymaxLogoImg());

		//Home page
		HomePage homePage = new HomePage(driver);
		WebElement myAccountLink = homePage.HomeSqmyAccountLink();
		ScreenShot.takeScreenShot(driver, "HomePage");
		SeleniumFunction.hoverAction(driver,myAccountLink);
		WaitTool.sleep(3);
		SeleniumFunction.click(homePage.HomeSqmyOrder());//click on order link
		
		//order page
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		WebElement orderId = myAccountPage.orderId();		
		ScreenShot.takeScreenShot(driver, "OrderOnMyAccount");
		String orderIdString = SeleniumFunction.getText(orderId);
		Log.info("Order Id on My Account page: " + orderIdString);

		if (orderNumberString.equalsIgnoreCase(orderIdString)) {
			Log.info("Order Id matched on Order confirmation and My Account page");
		} else {
			Log.error("Order Id did not matched on Order confirmation and My Account page");
			Assert.fail();
		}
	}
}
