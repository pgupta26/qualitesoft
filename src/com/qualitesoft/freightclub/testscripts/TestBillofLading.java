package com.qualitesoft.freightclub.testscripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.testng.annotations.Test;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.LandingPage;

public class TestBillofLading extends InitializeTest{
	
	@Test
	public void testBillofLading(){
		LandingPage landingPage = new LandingPage(driver);
		SeleniumFunction.clickJS(driver, landingPage.billofLadingButton());
		
		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/FCFile.xlsx");
		System.out.println("xr:" + xr);
		int rcnt=xr.getRowCount("Input");
		for(int i=2;i<=rcnt;i++)
		{
			String orderid=xr.getCellData("Input","OrderId", i).trim();
			SeleniumFunction.sendKeys(landingPage.OrderIDTextBox(), orderid);
			SeleniumFunction.KeyBoradEnter(driver);
		    WaitTool.sleep(5);
			//landingPage.exportToPDFButton();
			ScreenShot.takeScreenShot(driver, "BillofLadingPage for order id "+ orderid);
			//SeleniumFunction.clickJS(driver, landingPage.exportToPDFButton());
			SeleniumFunction.click(landingPage.ActionButton());
			SeleniumFunction.click(landingPage.DownloadPDFButton());
			WaitTool.sleep(10);	
			Robot
			r;
			try {
				r = new Robot();
				r.keyPress(KeyEvent.VK_ENTER);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WaitTool.sleep(2);
			ScreenShot.takeScreenShot(driver, "BillofLadingPDF for order id "+orderid);	
		}
	}
}
