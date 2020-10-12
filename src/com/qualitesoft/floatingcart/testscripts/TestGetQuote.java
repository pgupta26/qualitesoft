package com.qualitesoft.floatingcart.testscripts;

import com.qualitesoft.floatingcart.pageobjects.FloatingQuickQuote;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;


public class TestGetQuote extends InitializeTest{ 
	@Test
	public void testGetQuote() {
		
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;	
			FloatingQuickQuote quickQuote = new FloatingQuickQuote(driver);

			//second time place an order
			if(loginuser.equals("Mstore2") || loginuser.equals("Mstoreuser") || loginuser.equals("Mstore2")) {
				SeleniumFunction.clickAction(driver,quickQuote.quickquoteLink());
				WaitTool.sleep(2);
				quickQuote.acceptPopup();
				WaitTool.sleep(2);

				SeleniumFunction.executeJS(driver, "window.scrollBy(0,-500)");
				SeleniumFunction.click(quickQuote.LTLShipment());
			}
			
			//To accept popup if present
			WaitTool.sleep(5);
			quickQuote.acceptPopup();
			WaitTool.sleep(2);
			
			SeleniumFunction.click(quickQuote.OrderDate());
			WaitTool.sleep(5);
			SeleniumFunction.click(quickQuote.OrderDate1());
			SeleniumFunction.sendKeys(quickQuote.OrderReferenceID(), "Floating_C01");
			WaitTool.sleep(2);

			SeleniumFunction.click(quickQuote.ServiceLevelfloating());
			SeleniumFunction.click(quickQuote.ServiceLevelCURFloating());
			
			if(loginuser.equals("new")) {
				SeleniumFunction.sendKeys(quickQuote.QuickEmail(),emailAddressRandom());
				SeleniumFunction.selectByvalue(quickQuote.AccountType(), "11");
			}
			
			jse.executeScript("window.scrollBy(0,800)", "");
			SeleniumFunction.selectByVisibleText(quickQuote.DropOffLocationType(), "Residential");
			SeleniumFunction.selectByVisibleText(quickQuote.DropOffLocationType(), "Commercial");
			SeleniumFunction.sendKeys(quickQuote.PickUpZip(), "90001");
			SeleniumFunction.sendKeys(quickQuote.DropOffZip(),"90002");	
			jse.executeScript("window.scrollBy(0,350)", "");
			SeleniumFunction.click(quickQuote.PackageType());
			quickQuote.PackageTypeOptions("Custom Pallet (enter dimensions)");

			jse.executeScript("window.scrollBy(0,250)", "");
			SeleniumFunction.click(quickQuote.CategoryButton());
			jse.executeScript("window.scrollBy(0,250)", "");
			WaitTool.sleep(5);
			SeleniumFunction.click(quickQuote.Categoryother());//SELECT CATEGORY OTHER

			WaitTool.sleep(5);
			//Add popup on cateory 
			if(loginuser.equals("new") || loginuser.equals("Mstoreuser")|| loginuser.equals("Mstore2")) {
				SeleniumFunction.click(quickQuote.notloggedpopupCateogory());	
			}else {
				SeleniumFunction.click(quickQuote.popupCateogory());
			}			
			WaitTool.sleep(2);
			jse.executeScript("window.scrollBy(0,350)", "");
			WaitTool.sleep(5);
			SeleniumFunction.click(quickQuote.Weight());
			SeleniumFunction.sendKeys(quickQuote.Weight(), "40");
			SeleniumFunction.sendKeys(quickQuote.DimensionL(), "40");
			SeleniumFunction.sendKeys(quickQuote.DimensionW(), "40");
			SeleniumFunction.sendKeys(quickQuote.DimensionH(), "40");
			SeleniumFunction.sendKeys(quickQuote.DeclaredValue(), "200");
			SeleniumFunction.sendKeys(quickQuote.Cartons(), "2");

			WaitTool.sleep(7);
			ScreenShot.takeScreenShot(driver, "Shipmentinfo");
			jse.executeScript("window.scrollBy(0,250)", "");
			SeleniumFunction.click(quickQuote.SaveButton());
			WaitTool.sleep(20);
			
			//select carrier
			jse.executeScript("window.scrollBy(0,800)", "");
			quickQuote.expandCarries();

			ScreenShot.takeFullScreenShot("Rates wih Carriers ");
			SeleniumFunction.scrollDownUptoFooter(driver);
			quickQuote.expandCarries();
			//if(loginuser.equals("new")) {
				quickQuote.selectCarrier("Pilot Freight Services[Televisions new]");	
			/*}else {
				quickQuote.selectCarrier("Pilot Freight Services[Televisions]");
			}	*/
			
			WaitTool.sleep(20);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	private static String emailAddressRandom() {

		String emailAddress = JavaFunction.randomText("Selenium", 4) + "@email.com";
		return emailAddress;
	}
}