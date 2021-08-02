package com.qualitesoft.freightclub.testscripts.manageorders;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.appcommon.CommonOps;
import com.qualitesoft.freightclub.pageobjects.ManagerOrderPage;

public class TestAcceptRerouteRequest extends InitializeTest{
	CommonOps commonOps = new CommonOps();
	@Test(priority = 1)
	public void acceptRequestByAdmin(){
		try{
			Xls_Reader xr1=new Xls_Reader("binaries/FCfiles/ManageOrdersTestData.xlsx");
			int i=Integer.parseInt(Row);
			
			String orderId = xr1.getCellData("Reroute Request", "OrderId", i);

			commonOps.openManageOrdersPageAndSearchOrder(orderId);
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
			if(manageOrderpage.acceptFeedbackPopupStatus() == true){
				manageOrderpage.acceptFeedbackPopup();
			}
			SeleniumFunction.clickJS(driver, manageOrderpage.ActionButton());
			manageOrderpage.clickConfirmReroute();
			String successMessage = manageOrderpage.verifyToastMessage();
			UseAssert.assertEquals(successMessage, "Reroute successfully confirmed.");
			WaitTool.sleep(3);
		}catch(Exception ex){
			ex.printStackTrace();
			throw ex;
		}
	}
	
	@Test(priority = 2)
	public void verifyRerouteRequestLinkIsPresent(){
		try{
			ManagerOrderPage manageOrderpage = new ManagerOrderPage(driver);
			WaitTool.sleep(3);
			SeleniumFunction.clickJS(driver, manageOrderpage.ActionButton());
			boolean status = manageOrderpage.requestRerouteIsPresent();
			Assert.assertEquals(status, true);			
		}catch(Exception ex){
			ex.printStackTrace();
			throw ex;
		}
	}
}