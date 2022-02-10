package com.qualitesoft.MBDesigner.testscripts;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qualitesoft.MBDesigner.pageobjects.BoardList;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestCheckout extends InitializeTest{
	@Test
	public void testCheckout(){
		WebDriver driver = getDriver();
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1));//move to second tab
		WaitTool.sleep(5);
		BoardList view = new BoardList(driver);
		SeleniumFunction.click(view.proceedButton());
		WaitTool.sleep(15);
		ScreenShot.takeScreenShot(driver, "Checkout");
		SeleniumFunction.sendKeys(view.guestemail(), "test123@a.com");
		SeleniumFunction.click(view.continueButton());
		WaitTool.sleep(10);
		ScreenShot.takeScreenShot(driver, "Shipping info");
		SeleniumFunction.sendKeys(view.firstNameTextbox(), "test");
		SeleniumFunction.sendKeys(view.lastNameTextbox(), "one");
		SeleniumFunction.sendKeys(view.companynameTextbox(), "one");
		SeleniumFunction.sendKeys(view.add1Textbox(), "Selenium_Address");
		SeleniumFunction.sendKeys(view.add2Textbox(), "Selenium_Address");
		SeleniumFunction.sendKeys(view.zipTextbox(), "83341");
		SeleniumFunction.sendKeys(view.cityTextbox(), "Selenium_city");
		SeleniumFunction.select(view.countrydropdown(), "USA");
		WaitTool.sleep(5);
		SeleniumFunction.select(view.statedropdown(), "Alabama");
		WaitTool.sleep(5);
		SeleniumFunction.sendKeys(view.phone(), "4444444444");	
		SeleniumFunction.click(view.reviewButton());
		WaitTool.sleep(30);
		ScreenShot.takeScreenShot(driver, "Review order");
		SeleniumFunction.click(view.reviewButton());//continue payment
		WaitTool.sleep(10);
		ScreenShot.takeScreenShot(driver, "Payment page");
		SeleniumFunction.sendKeys(view.creditCardNo(), "4111111111111111");
		SeleniumFunction.sendKeys(view.cardName(), "Selenium test");
		SeleniumFunction.select(view.expMonth(), "10 (Oct)");
		SeleniumFunction.select(view.expYear(), "2019");
		SeleniumFunction.sendKeys(view.securityCode(), "123");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,450)", "");
		SeleniumFunction.click(view.reviewButton());//place order
		WaitTool.sleep(15);
		ScreenShot.takeScreenShot(driver, "Order Confirmation Page");
		   //order id
	    WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[contains(@class,'order-number')]/strong"), 60);
	    crorderId=SeleniumFunction.getText(driver.findElement(By.xpath("//*[contains(@class,'order-number')]/strong")));
	    System.out.println("Orderid :" + crorderId);
		//ScreenShot.takeScreenShot(driver, "orderId");
		driver.close();
		driver.switchTo().window(newTab.get(0));//switch to admin portal window
		WaitTool.sleep(5);
		
	}
}
