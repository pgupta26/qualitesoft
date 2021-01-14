package com.qualitesoft.freightclub.testscripts;

import org.testng.annotations.Test;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.LandingPage;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;

public class TestBillofLading extends InitializeTest{

	@Test
	public void testBillofLading(){
		LandingPage landingPage = new LandingPage(driver);
		QuickQuote quickQuote = new QuickQuote(driver);
		SeleniumFunction.clickJS(driver, landingPage.billofLadingButton());
		WaitTool.sleep(2);
		quickQuote.acceptPopup();
		WaitTool.sleep(2);

		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/FCFile.xlsx");
		int i=Integer.parseInt(Row);

		String orderid=xr.getCellData("Input","OrderId", i).trim();
		SeleniumFunction.sendKeys(landingPage.OrderIDTextBox(), orderid);
		SeleniumFunction.KeyBoradEnter(driver);
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "BillofLadingPage for order id "+ orderid);
		SeleniumFunction.click(landingPage.ActionButton());
		SeleniumFunction.click(landingPage.DownloadPDFButton());
		WaitTool.sleep(5);	
		ScreenShot.takeScreenShot(driver, "BillofLadingPDF for order id "+orderid);	
	}
}
