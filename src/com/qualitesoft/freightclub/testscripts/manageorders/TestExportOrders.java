package com.qualitesoft.freightclub.testscripts.manageorders;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.ManagerOrderPage;

public class TestExportOrders extends InitializeTest
{

	@Test
	public void exportAllOrdersAndVerifyCount(){
		try{
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
			SeleniumFunction.click(manageOrderpage.manageOrdersLink());
			WaitTool.sleep(7);

			if(manageOrderpage.acceptFeedbackPopupStatus() == true){
				manageOrderpage.acceptFeedbackPopup();
			}

			if(keyword.equals("quickOrders") == true){
				SeleniumFunction.click(manageOrderpage.openQuoteTab());
			}else if(keyword.equals("fullOrders") == true){
				Log.info("Already in booked table");
			}
			
			SeleniumFunction.click(manageOrderpage.clickExportOrdersBtn(keyword));
			WaitTool.sleep(10);

			String sheetName = JavaFunction.currentPSTDate("yyyy-M-d");
			int numOfRows = JavaFunction.countLineBufferedReader("download\\" + testData +  sheetName + ".csv");

			String rowsCount = manageOrderpage.getPagiationTotalRows(keyword);
			String[] num = rowsCount.split(" ");
			String totalRecords = num[4];
			Log.info("Pagination count " + totalRecords + " \n Excel rows " + numOfRows);
			Assert.assertTrue(numOfRows >= Integer.parseInt(totalRecords));
			
		}catch(Exception e){
			Assert.fail(e.getMessage());
		}
	}
}
