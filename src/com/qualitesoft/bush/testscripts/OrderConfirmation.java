package com.qualitesoft.bush.testscripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.bush.pageobjects.HomePage;
import com.qualitesoft.bush.pageobjects.MyAccountPage;
import com.qualitesoft.bush.pageobjects.OrderConfirmationPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;


public class OrderConfirmation extends InitializeTest {

	@Test
	public void testOrderConfirmation() {

		OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
		   //order id
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("Categories.readPopular()");
		WebElement orderNumber = orderConfirmationPage.orderNumber();
		ScreenShot.takeScreenShot(driver, "OrderConfirmationPage");
		String orderNumberString = SeleniumFunction.getText(orderNumber);
		System.out.println("Orderid :" + orderNumberString);
		Log.info("Order Id on Order Confirmation page: " + orderNumberString);
		
		//setpassword for guest user(In case of guest user)
/*		SeleniumFunction.sendKeys(orderConfirmationPage.setPasswordText(), "12345689");
		SeleniumFunction.click(orderConfirmationPage.setPwdButton());*/
        
		
		SeleniumFunction.click(orderConfirmationPage.cymaxLogoImg());
		
		driver.navigate().to("http://qa-bushfurniturecollection.constantretail.com/");
		HomePage homePage = new HomePage(driver);
		WebElement myAccountLink = homePage.myAccountLink();
		ScreenShot.takeScreenShot(driver, "HomePage");
		SeleniumFunction.click(myAccountLink);
		WaitTool.sleep(5);
		
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		//enter username and id(GuestUser)
/*		System.out.println("GuestEmailid:"+GuestEmailid);
		SeleniumFunction.sendKeys(myAccountPage.emailTextbox(),GuestEmailid.trim());
		SeleniumFunction.sendKeys(myAccountPage.passwordTextbox(),"12345689");
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
			Assert.fail("Order Id did not matched on Order confirmation and My Account page");
		}
	}
}
