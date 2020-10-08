package com.qualitesoft.freightclub.testscripts;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.HomePage;
import com.qualitesoft.freightclub.pageobjects.LandingPage;

public class TestManageFullOrders extends InitializeTest{
	
	@Test
	public void testManageFullOrders(){
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.manageOrdersLink();
		SeleniumFunction.clickJS(driver, landingPage.manageOrdersLink());
		ScreenShot.takeScreenShot(driver, "ManageOrderPage");
/*		landingPage.uploadFileFullOrderChrome();
		SeleniumFunction.clickAction(driver, landingPage.uploadButton());
		landingPage.OKButton();
		landingPage.sucessMsgManageProducts();
		SeleniumFunction.clickJS(driver, landingPage.OKButton());
		ScreenShot.takeScreenShot(driver, "ManageOrdersUploaded");
		
		SeleniumFunction.clickJS(driver, landingPage.bookFullOrdersButton());
		landingPage.fullOrderOKButton();
		ScreenShot.takeScreenShot(driver, "FullOrderBookingConformation");
		SeleniumFunction.clickJS(driver, landingPage.fullOrderOKButton());
		WaitTool.sleep(4);
		ScreenShot.takeScreenShot(driver, "FullOrderBooked");
		WaitTool.sleep(4);
		SeleniumFunction.clickJS(driver, landingPage.exportOrdersinCSVFormatButton());*/
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/FCFile.xlsx");
		System.out.println("xr:" + xr);
		int rcnt=xr.getRowCount("Input");
		//System.out.println("rcntTESTRUN:" + rcnt);
		jse.executeScript("window.scrollBy(0,-450)", "");
		for(int i=2;i<=rcnt;i++)
		{
			String orderid=xr.getCellData("Input","OrderId", i).trim();
			//System.out.println("crorderIdexcel:" + orderid);
			SeleniumFunction.sendKeys(landingPage.IDTextBox(), orderid);
			SeleniumFunction.KeyBoradEnter(driver);
		    WaitTool.sleep(20);
		    //jse.executeScript("window.scrollBy(0,250)", "");
		    SeleniumFunction.click(landingPage.ViewDetail());
		    WaitTool.sleep(10);
			//Navigate to Update Order Page
			ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(newTab.get(1));//move to second tab
			jse.executeScript("window.scrollBy(0,250)", "");
			ScreenShot.takeScreenShot(driver, "Order Info for order id "+orderid);
			driver.close();
			driver.switchTo().window(newTab.get(0));
/*			WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='modal-header']/h3[@class='pull-left']"), 60);
			String vieworder1=SeleniumFunction.getText(driver.findElement(By.xpath("//div[@class='modal-header']/h3[@class='pull-left']")));
			//System.out.println("vieworderbefore split:" + vieworder1);
			String[] order = vieworder1.split("-");
			String vieworder = order[1].trim(); // order id
			//System.out.println("vieworder:" + vieworder);
			if(vieworder.equals(orderid))
			{
				try {
					Log.info("Order Id displayed correctly: " + vieworder);
				} catch (Exception e) {
					Log.warn("Incorrect Order Id: " + vieworder);
					throw e;
				}	
			}
			
			jse.executeScript("window.scrollBy(0,550)", "");//scroll down
			ScreenShot.takeScreenShot(driver, "Order Info for order id "+orderid);
			SeleniumFunction.click(landingPage.updatehistory());
			SeleniumFunction.click(landingPage.Okbutton1());
			WaitTool.sleep(10);
			jse.executeScript("window.scrollBy(0,-450)", "");*/
			   
		}
		
	}
}
