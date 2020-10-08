package com.qualitesoft.freightclub_enhancement.qa517.testscripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.pageobjects.QuickQuote;

public class TestReviewAndBook  extends InitializeTest {

	@Test
	public void testReviewAndBook() {
		try{
			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_517.xlsx");
			int i=Integer.parseInt(Row);
			Log.info("Data Row: "+Row);

			String shipmentType=xr.getCellData("Input","shipmentType", i).trim();
			String packageType = xr.getCellData("Input", "packageType", i).trim();

			QuickQuote quickQuote = new QuickQuote(driver);
			
			if(i == 5 || i == 6 || i == 7) {
				Assert.assertTrue(quickQuote.verifyBasicThresholdAtReview());
				ScreenShot.takeScreenShot(driver, "Basic threshold present at review page");
			} else if(i == 2 || i == 3 || i == 4) {
				Assert.assertFalse(quickQuote.verifyBasicThresholdAtReview());
				ScreenShot.takeScreenShot(driver, "Basic threshold not present at review page");
			} else {
				Log.info("Do Nothing");
			}

			SeleniumFunction.click(quickQuote.Book());
			WaitTool.sleep(15);
			quickQuote.Okbutton();
			ScreenShot.takeScreenShot(driver, "Order Confirmation "+shipmentType+" "+packageType);
			SeleniumFunction.click(quickQuote.Okbutton());
			WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@class='ag-body'])[1]/descendant::div[@row='0']/div[@colid='ID']"), 60);
			WaitTool.sleep(10);
			crorderId=SeleniumFunction.getText(driver.findElement(By.xpath("(//div[@class='ag-body'])[1]/descendant::div[@row='0']/div[@colid='ID']")));
			System.out.println("crorderId:" + crorderId.trim());
			//set order id in excel
			xr.setCellData("Input","OrderId", i,crorderId.trim());
			WaitTool.sleep(5);

		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}	
}
