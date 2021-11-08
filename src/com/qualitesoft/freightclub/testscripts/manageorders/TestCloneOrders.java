package com.qualitesoft.freightclub.testscripts.manageorders;


import org.testng.annotations.Test;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.appcommon.CommonOps;
import com.qualitesoft.freightclub.pageobjects.ManageOverages;
import com.qualitesoft.freightclub.pageobjects.ManagerOrderPage;
import com.qualitesoft.freightclub.pageobjects.QuickQuoteFinal;

public class TestCloneOrders extends InitializeTest{

	@Test
	public void testCloneOrders(){
		
		ManageOverages manageOverage = new ManageOverages(driver);
		ManagerOrderPage manageOrderPage =new ManagerOrderPage(driver);
		QuickQuoteFinal quickQuote = new QuickQuoteFinal(driver);
		CommonOps commonOps = new CommonOps();

		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/"+testData);
		int i=Integer.parseInt(Row);
		Log.info("Data row number: "+i);

		String shipmentType=xr.getCellData("Input","shipmentType", i).trim();
		String packageType = xr.getCellData("Input", "packageType", i).trim();
		String packageType2 = xr.getCellData("Input", "packageType2", i).trim();
		String carrier = xr.getCellData("Input","Carrier", i).trim();
		
		//click on clone button under actions dropdown
		SeleniumFunction.click(manageOrderPage.ActionButton());
		SeleniumFunction.click(manageOrderPage.clone());
		
		//click on clone now button
		WaitTool.sleep(5);
		String CloneOrder="CloneOrder"+Row;
		Log.info("Clone order customer PO: "+CloneOrder);
		SeleniumFunction.sendKeys(manageOrderPage.customerPONumber(), CloneOrder);
		WaitTool.sleep(2);
		SeleniumFunction.click(manageOrderPage.cloneNow());
		ScreenShot.takeScreenShot(driver, "Order cloned");

		//enter order date and select carriers
		SeleniumFunction.scrollUpByPixel(driver, "2000");
		SeleniumFunction.click(quickQuote.OrderDate());
		quickQuote.acceptPopup();
		SeleniumFunction.scrollDownUptoFooter(driver);
		commonOps.selectCarrier();
		quickQuote.selectCarrier(carrier);
		
		//click on review order
		WaitTool.sleep(5);
		SeleniumFunction.clickJS(driver, quickQuote.ReviewOrder());
		quickQuote.acceptPopup();
		WaitTool.sleep(10);
		
		//verify pallet details
		if (!packageType.isEmpty()) {
			if(shipmentType.equals("Parcel") ||  packageType.equals("Non-Palletized")) {
				commonOps.verifyPalletizedDetailCloneOrder(xr, i, "5", packageType);
			} else {
				commonOps.verifyPalletizedDetailCloneOrder(xr, i, "3", packageType);
			}
		}
		if (!packageType2.isEmpty()) {
			if(shipmentType.equals("Parcel") || packageType2.equals("Non-Palletized")) {
				commonOps.verifyPalletizedDetailCloneOrder(xr, i, "5", packageType2);
			} else {
				commonOps.verifyPalletizedDetailCloneOrder(xr, i, "3", packageType2);
			}
		}
		ScreenShot.takeScreenShot(driver, "Clone order palletized detail");
		
		
		//click on book order
		SeleniumFunction.clickJS(driver, quickQuote.Book());
		
		if(quickQuote.acknowleadgeBtnStatus() == true){
			String actualPopupHeader = SeleniumFunction.getText(quickQuote.acknowleadgeModalHeader());
			String actualPopupBody = SeleniumFunction.getText(quickQuote.acknowleadgeModalBody());
			UseAssert.assertEquals(actualPopupHeader, "A matching order has already been placed.1");
			UseAssert.assertEquals(actualPopupBody, "We have identified that the order that you are about to place is similar to an order that has already been booked. Would you like to continue with placing a duplicate order?");
			SeleniumFunction.click(quickQuote.acknowleadgeBtn());
			WaitTool.sleep(2);
			SeleniumFunction.clickJS(driver, quickQuote.Book());
		}
		
		
		//click on ok button
		SeleniumFunction.click(quickQuote.Okbutton1());
		WaitTool.sleep(10);
		ScreenShot.takeScreenShot(driver, "Cloned order successfully booked");
		crorderId=SeleniumFunction.getText(manageOverage.gridData(1, 1));
		Log.info("Clone Order Id: "+crorderId);
		
		//set order id in excel
		xr.setCellData("Input","CloneOrderId", i,crorderId.trim());
	}
}
