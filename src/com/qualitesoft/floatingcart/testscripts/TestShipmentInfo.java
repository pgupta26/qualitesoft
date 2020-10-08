package com.qualitesoft.floatingcart.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.floatingcart.pageobjects.FloatingQuickQuote;

public class TestShipmentInfo extends InitializeTest {
	@Test
	public void testShipmentInfo(){
		FloatingQuickQuote quickQuote = new FloatingQuickQuote(driver);
		if(driver.findElements(By.xpath("//div[@class='introjs-tooltip']") ).size() != 0)
		{
			SeleniumFunction.click(quickQuote.toolTipskip());
		}
		WaitTool.sleep(5);
		JavascriptExecutor jse = (JavascriptExecutor) driver;	
		jse.executeScript("window.scrollBy(0,-250)", "");
		//SeleniumFunction.sendKeys(quickQuote.TotalCartoonCount(), "1");
		//SeleniumFunction.sendKeys(quickQuote.PalletDesc(), "TestPalletDesc");
		SeleniumFunction.sendKeys(quickQuote.SpecialHandling(), "TestSpecialHandling");
		SeleniumFunction.sendKeys(quickQuote.Address1(), "Address1");
		
		if(!loginuser.equalsIgnoreCase("new")) {
			SeleniumFunction.sendKeys(quickQuote.Phone1(), "12345678900");
		}
		if(loginuser.equalsIgnoreCase("new")) {
			SeleniumFunction.sendKeys(quickQuote.Address2(), "Address2");
			SeleniumFunction.sendKeys(quickQuote.City(), "City");
			SeleniumFunction.sendKeys(quickQuote.Country(), "Country");
			SeleniumFunction.sendKeys(quickQuote.State(), "State");
			SeleniumFunction.sendKeys(quickQuote.ZipCode(), "133001");	
			SeleniumFunction.sendKeys(quickQuote.Email(), "a@a.com");	
			
		}
		

		//Pick Up Location detail
		if(loginuser.equalsIgnoreCase("new")) {
			SeleniumFunction.sendKeys(quickQuote.LocationName(), JavaFunction.randomText("TestUsername ",5));
			
		}
		SeleniumFunction.sendKeys(quickQuote.PickUpFirstName(), "PickUserFirstName");
		SeleniumFunction.sendKeys(quickQuote.PickUpLastName(), "PickUserLastName");
		SeleniumFunction.sendKeys(quickQuote.PickUpAddress1(), "PickAddress1");
		SeleniumFunction.sendKeys(quickQuote.PickUpPhone1(), "0098764321");

		//Drop Off Location Detail
		jse.executeScript("window.scrollBy(0,250)", "");
		if(loginuser.equalsIgnoreCase("new")) {
			SeleniumFunction.sendKeys(quickQuote.DropLocationName(), JavaFunction.randomText("TestDropname ",5));
			SeleniumFunction.sendKeys(quickQuote.DropAddress1(), "DropAddress1");
			SeleniumFunction.sendKeys(quickQuote.DropAddress2(), "DropAddress2");
			SeleniumFunction.sendKeys(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='col-xs-12 col-md-6'][2]/descendant::input[@id='Phone1']"), 30), "12345678900");
			SeleniumFunction.sendKeys(quickQuote.DropEmail(), "Drop@a.com");
		}
		
		
		SeleniumFunction.sendKeys(quickQuote.DropFirstName(), "DropUserFirstName");
		SeleniumFunction.sendKeys(quickQuote.DropLastName(), "DropUserLastName");
		ScreenShot.takeScreenShot(driver, "Filled Shipment info");
		SeleniumFunction.click(quickQuote.ReviewOrder());
		WaitTool.sleep(5);
		if(driver.findElements(By.xpath("//div[@class='introjs-tooltip']") ).size() != 0)
		{
			SeleniumFunction.click(quickQuote.toolTipskip());
		}
		//ShipmentReview
		ScreenShot.takeScreenShot(driver, "Shipment Review");
		SeleniumFunction.click(quickQuote.ReviewOrder());
		WaitTool.sleep(30);
	}
}
