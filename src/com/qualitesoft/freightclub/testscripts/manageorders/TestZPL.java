package com.qualitesoft.freightclub.testscripts.manageorders;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.freightclub.appcommon.CommonOps;
import com.qualitesoft.freightclub.pageobjects.ManagerOrderPage;

public class TestZPL extends InitializeTest {
	
	@Test
	public void testZPL() {
		try {
			
			ManagerOrderPage manageOrderPage =new ManagerOrderPage(driver);
			CommonOps commonOps = new CommonOps();

			Xls_Reader xr=new Xls_Reader("binaries/FCfiles/FCFile.xlsx"); int
			i=Integer.parseInt(Row);
			String orderId=xr.getCellData("Input","OrderId", i).trim();

			commonOps.openManageOrdersPageAndSearchOrder(orderId);
			SeleniumFunction.click(manageOrderPage.ActionButton());
			SeleniumFunction.click(manageOrderPage.shippingLabelsZPL());
			WaitTool.sleep(10); 
			ScreenShot.takeScreenShot(driver, "Shipping labels ZPL for order id "+orderId+ "downloaded.");
			
			String fileName = orderId+".txt";
			
			String downloadDir = System.getProperty("user.dir") +File.separator+"download"+File.separator;
			File file = new File(downloadDir+fileName);

			if(file.exists()) {
				Assert.assertTrue(true);
			}else {
				Assert.fail();
			}			
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
}
