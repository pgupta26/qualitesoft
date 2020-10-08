package com.qualitesoft.freightclub_enhancement.qa517.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub_enhancement.qa517.pageobjects.ManagerOrderPage;

public class TestManageOrders extends InitializeTest {
	
	@Test
	public void testVerifyAppointmentFlagUnderBOLPdf() {
		
		try{
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
			SeleniumFunction.click(manageOrderpage.manageOrdersLink());
			
			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/QA_517.xlsx");
			int i=Integer.parseInt(Row);
			Log.info("Data Row: " +Row);
			String orderid=xr.getCellData("Input","OrderId", i).trim();
			
			manageOrderpage.orderIDFilter(orderid);
			SeleniumFunction.KeyBoradEnter(driver);
		    WaitTool.sleep(5);
		    
		    if(!manageOrderpage.ExpandMenupage().getAttribute("class").equals("active")) {
		    	 SeleniumFunction.click(manageOrderpage.ExpandMenupage());
		    }
		    SeleniumFunction.clickJS(driver,manageOrderpage.ActionButton());
		    manageOrderpage.billOfLoadingPdf();
			WaitTool.sleep(2);
			ScreenShot.takeScreenShot(driver, "Bill of Lading PDF for order id "+orderid);	
			
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
}
