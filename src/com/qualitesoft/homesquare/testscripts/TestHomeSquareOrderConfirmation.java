package com.qualitesoft.homesquare.testscripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.homesquare.pageobjects.HomeSquareHomePage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareMyAccountPage;
import com.qualitesoft.homesquare.pageobjects.HomeSquareOrderConfirmationPage;


public class TestHomeSquareOrderConfirmation extends InitializeTest {

	@Test
	public void testOrderConfirmation() {

		HomeSquareOrderConfirmationPage orderConfirmationPage = new HomeSquareOrderConfirmationPage(driver);
		//order page
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("Categories.readPopular()");
		WebElement orderNumber = orderConfirmationPage.orderNumber();
		ScreenShot.takeScreenShot(driver, "OrderConfirmationPage");
		String orderNumberString = SeleniumFunction.getText(orderNumber);
		Log.info("Order Id on Order Confirmation page: " + orderNumberString);
		SeleniumFunction.click(orderConfirmationPage.cymaxLogoImg());

		//Home page
		HomeSquareHomePage homePage = new HomeSquareHomePage(driver);
		WebElement myAccountLink = homePage.HomeSqmyAccountLink();
		ScreenShot.takeScreenShot(driver, "HomePage");
		SeleniumFunction.hoverAction(driver,myAccountLink);
		WaitTool.sleep(3);
		SeleniumFunction.click(homePage.HomeSqmyOrder());//click on order link
		
		//order page
		HomeSquareMyAccountPage myAccountPage = new HomeSquareMyAccountPage(driver);
		WebElement orderId = myAccountPage.orderId();		
		ScreenShot.takeScreenShot(driver, "OrderOnMyAccount");
		String orderIdString = SeleniumFunction.getText(orderId);
		Log.info("Order Id on My Account page: " + orderIdString);

		if (orderNumberString.equalsIgnoreCase(orderIdString)) {
			Log.info("Order Id matched on Order confirmation and My Account page");
		} else {
			Assert.fail("Order Id did not matched on Order confirmation and My Account page");
		}
	}
}
