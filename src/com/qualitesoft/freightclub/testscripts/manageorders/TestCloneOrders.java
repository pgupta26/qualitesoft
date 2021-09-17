package com.qualitesoft.freightclub.testscripts.manageorders;


import org.testng.annotations.Test;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
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

		String packageType = xr.getCellData("Input", "packageType", i).trim();
		String carrier = xr.getCellData("Input","Carrier", i).trim();
		String palletType1 = xr.getCellData("Input", "PalletType1", i).trim();
		String palletType2 = xr.getCellData("Input", "PalletType2", i).trim();

		//click on clone button under actions dropdown
		SeleniumFunction.click(manageOrderPage.ActionButton());
		SeleniumFunction.click(manageOrderPage.clone());
		
		//click on clone now button
		String CloneOrder="CloneOrder"+Row;
		Log.info("Clone order customer PO: "+CloneOrder);
		SeleniumFunction.sendKeys(manageOrderPage.customerPONumber(), CloneOrder);
		SeleniumFunction.click(manageOrderPage.cloneNow());
		ScreenShot.takeScreenShot(driver, "Order cloned");

		//enter order date and select carrier
		SeleniumFunction.click(quickQuote.OrderDate());
		commonOps.selectCarrier();
		quickQuote.selectCarrier(carrier);
		
		//click on review order
		SeleniumFunction.click(quickQuote.ReviewOrder());
		quickQuote.acceptPopup();
		WaitTool.sleep(10);
		
		//verify pallet details
		if (!palletType1.isEmpty()) {
			if(palletType1.equals("Non-Palletized")) {
				commonOps.verifyPalletizedDetail(xr, i, "4", packageType);
			} else {
				commonOps.verifyPalletizedDetail(xr, i, "3", packageType);
			}
			
		}
		if (!palletType2.isEmpty()) {
			if(palletType1.equals("Non-Palletized")) {
				commonOps.verifyPalletizedDetail(xr, i, "4", packageType);
			} else {
				commonOps.verifyPalletizedDetail(xr, i, "3", packageType);
			}
		}
		
		//click on book order
		SeleniumFunction.clickJS(driver, quickQuote.Book());
		
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
