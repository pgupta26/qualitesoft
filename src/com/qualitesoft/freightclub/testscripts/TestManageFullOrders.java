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
import com.qualitesoft.freightclub.pageobjects.QuickQuote;

public class TestManageFullOrders extends InitializeTest{

	@Test
	public void testManageFullOrders(){

		LandingPage landingPage = new LandingPage(driver);
		QuickQuote quickQuote = new QuickQuote(driver);

		SeleniumFunction.clickJS(driver, landingPage.manageOrdersLink());
		ScreenShot.takeScreenShot(driver, "ManageOrderPage");

		WaitTool.sleep(5);
		quickQuote.acceptPopup();
		WaitTool.sleep(2);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/FCFile.xlsx");
		int i=Integer.parseInt(Row);
		jse.executeScript("window.scrollBy(0,-450)", "");
		String orderid=xr.getCellData("Input","OrderId", i).trim();
		SeleniumFunction.sendKeys(landingPage.IDTextBox(), orderid);
		SeleniumFunction.KeyBoradEnter(driver);
		WaitTool.sleep(20);
		SeleniumFunction.click(landingPage.ViewDetail());
		WaitTool.sleep(10);
		//Navigate to Update Order Page
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1));//move to second tab
		jse.executeScript("window.scrollBy(0,250)", "");
		ScreenShot.takeScreenShot(driver, "Order Info for order id "+orderid);
		driver.close();
		driver.switchTo().window(newTab.get(0));

	}
}
