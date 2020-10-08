package com.qualitesoft.freightclubPh2.testscripts;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.annotations.Test;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.LandingPage;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;

public class TestBillofLading extends InitializeTest {

	@Test
	public void testBillofLading() {

		// TestManageNewQuickOrders testManageNewQuickOrders = new
		// TestManageNewQuickOrders();
		// testManageNewQuickOrders.testManageNewQuickOrders();
		QuickQuote quickQuote = new QuickQuote(driver);
		LandingPage landingPage = new LandingPage(driver);
		SeleniumFunction.clickJS(driver, landingPage.billofLadingButton());
		Xls_Reader xr = new Xls_Reader("binaries/FCfiles/FCFile_Ph2.xlsx");
		System.out.println("xr:" + xr);
		int i = Integer.parseInt(Row);
		int rcnt = xr.getRowCount("Input");
		// for(int i=2;i<=rcnt;i++)
		// {
		String orderid = xr.getCellData("Input", "OrderId", i).trim();
		SeleniumFunction.sendKeys(landingPage.OrderIDTextBox(), orderid);
		SeleniumFunction.KeyBoradEnter(driver);
		WaitTool.sleep(7);
		quickQuote.acceptPopup();
		WaitTool.sleep(2);
		/*if (Row.equalsIgnoreCase("6") || Row.equalsIgnoreCase("7") || Row.equalsIgnoreCase("8") || Row.equalsIgnoreCase("9")) {
			System.out.println(Row);
			SeleniumFunction.click(landingPage.ActionButton());
			SeleniumFunction.click(landingPage.newDownloadZPLButton());
			
			WaitTool.sleep(2);
			Robot r;
			try {
				r = new Robot();
				r.keyPress(KeyEvent.VK_ENTER);
			} catch (AWTException e) {
				e.printStackTrace();
			}
			ScreenShot.takeFullScreenShot("Download Popup" + orderid);
			WaitTool.sleep(2);
			//ScreenShot.takeFullScreenShot("Downloaded ZPL " + orderid);
		}*/
		
		//landingPage.exportToPDFButton();
		ScreenShot.takeScreenShot(driver, "BillofLadingPage for order id " + orderid);
		//SeleniumFunction.clickJS(driver, landingPage.exportToPDFButton());
		SeleniumFunction.click(landingPage.ActionButton());
		SeleniumFunction.click(landingPage.DownloadPDFButton());
		WaitTool.sleep(10);	
		Robot r;
		try {
			r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "BillofLadingPDF for order id "+orderid);	
		
		//Open downloaded file
/*		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_J);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WaitTool.sleep(3);
		//Navigate to Downloaded files
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1));//move to second tab		
		SeleniumFunction.click(landingPage.opendownloaded());
		driver.close();
		driver.switchTo().window(newTab.get(0));
		WaitTool.sleep(3);
		//Navigate to bills of lading 
		ArrayList<String> newTab1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab1.get(1));//move to second tab	
		ScreenShot.takeScreenShot(driver, "BillofLadingPDF for order id "+orderid);
		driver.close();
		driver.switchTo().window(newTab1.get(0));*/
		
/*		SeleniumFunction.clickJS(driver, landingPage.exportToPDFButton());
		WaitTool.sleep(4);
		// SeleniumFunction.click(landingPage.logOffButton());
		// Close PDF
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		WaitTool.sleep(4);
		ScreenShot.takeScreenShot(driver, "BillofLadingPDF for order id " + orderid);
		driver.close(); // only for child wondow
		WaitTool.sleep(4);
		driver.switchTo().window(parent);
		WaitTool.sleep(10);*/
		// }
	}
}
