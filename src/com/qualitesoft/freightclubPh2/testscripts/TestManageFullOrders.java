package com.qualitesoft.freightclubPh2.testscripts;

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
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/FCFile_Ph2.xlsx");
		System.out.println("xr:" + xr);
		int i = Integer.parseInt(Row);
		jse.executeScript("window.scrollBy(0,-450)", "");
		
			String orderid=xr.getCellData("Input","OrderId", i).trim();
			//System.out.println("crorderIdexcel:" + orderid);
			SeleniumFunction.sendKeys(landingPage.IDTextBox(), orderid);
			SeleniumFunction.KeyBoradEnter(driver);
		    WaitTool.sleep(10);
		    //jse.executeScript("window.scrollBy(0,250)", "");
		    SeleniumFunction.click(landingPage.ViewDetail());
		    WaitTool.sleep(5);
			//Navigate to Update Order Page
			ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(newTab.get(1));//move to second tab
			jse.executeScript("window.scrollBy(0,250)", "");
			ScreenShot.takeScreenShot(driver, "Order Info for order id "+orderid);
			driver.close();
			driver.switchTo().window(newTab.get(0));
	}
}
