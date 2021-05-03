package com.qualitesoft.freightclub.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;
import com.qualitesoft.freightclub.pageobjects.Admin.ManageOrderOpenQuotesPage;

public class TestBookCustomOrder extends InitializeTest {
	
	@Test
	public void testBookCustomOrder() {
		try{
			QuickQuote quickQuote = new QuickQuote(driver);
			ManageOrderOpenQuotesPage openQuotes = new ManageOrderOpenQuotesPage(driver);
			SeleniumFunction.click(openQuotes.manageOrdersLink());
			SeleniumFunction.click(openQuotes.openQuotes());
			
			WaitTool.sleep(5);
			quickQuote.acceptPopup();
			WaitTool.sleep(2);
			
			WaitTool.sleep(5);
			quickQuote.acceptPopup();
			WaitTool.sleep(2);
			
			Xls_Reader xr;
			String testDatasheet= "binaries/FCfiles/"+testData;
			xr=new Xls_Reader(testDatasheet);
			int i=Integer.parseInt(Row);
			Log.info("Data Row: " +Row);
			
			//filter record by order id
			String orderid=xr.getCellData("Input","OrderId", i).trim();
			SeleniumFunction.sendKeys(openQuotes.orderIdFilter(), orderid);
			WaitTool.sleep(2);
			SeleniumFunction.KeyBoradEnter(driver);
		    WaitTool.sleep(10);
		    
		    //Verify Quoted Price
			String COGS = xr.getCellData("Input","COGS", i).trim();
			float floatCogs = Float.parseFloat(COGS);
			float percentage = ((floatCogs * 6) / 100); 
			float quotedPrice = floatCogs + percentage;
			String quotePrice2 = "$"+quotedPrice;
			
			Assert.assertEquals(SeleniumFunction.getText(openQuotes.quotedPrice()).replaceAll(",", ""), quotePrice2);
			
		    //Verify action buttons
			ScreenShot.takeScreenShot(driver, "Quoted Price at Open Quotes page");
		    SeleniumFunction.click(openQuotes.actions());

		    SeleniumFunction.click(openQuotes.book());
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
