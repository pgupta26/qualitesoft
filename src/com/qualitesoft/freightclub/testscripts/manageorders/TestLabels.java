package com.qualitesoft.freightclub.testscripts.manageorders;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.appcommon.CommonOps;
import com.qualitesoft.freightclub.pageobjects.ManagerOrderPage;

public class TestLabels extends InitializeTest {
	
	@Test
	public void testLabels() throws IOException {

		ManagerOrderPage manageOrderPage =new ManagerOrderPage(driver);
		CommonOps commonOps = new CommonOps();

		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/FCFile.xlsx"); 
		int i=Integer.parseInt(Row);
		String orderId=xr.getCellData("Input","OrderId", i).trim();

		commonOps.openManageOrdersPageAndSearchOrder(orderId);
		SeleniumFunction.click(manageOrderPage.ActionButton());
		SeleniumFunction.click(manageOrderPage.shippingLabelsPdf());
		WaitTool.sleep(10); 
		ScreenShot.takeScreenShot(driver, "Shipping Label PDF for order id "+orderId);

		TestBOL obj = new TestBOL();
		String quantity = xr.getCellData("Input","Quantity", i).trim();
		String fileName = orderId+".pdf";
		obj.checkPdfFilePresenceAndPageCount(fileName, Integer.parseInt(quantity));
	}
}
