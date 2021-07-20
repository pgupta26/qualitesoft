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

public class TestBOL extends InitializeTest {

	public void checkPdfFilePresenceAndPageCount(String fileName, int expectedPageCount ) throws IOException {

		String downloadDir = System.getProperty("user.dir") +File.separator+"download"+File.separator;
		File file = new File(downloadDir+fileName);

		if(file.exists()) {
			PDDocument doc = Loader.loadPDF(file);
			int count = doc.getNumberOfPages();
			UseAssert.assertEquals(count, expectedPageCount);
		}else {
			Assert.fail();
		}
	}

	@Test
	public void testBOL() throws IOException {

		ManagerOrderPage manageOrderPage =new ManagerOrderPage(driver);
		CommonOps commonOps = new CommonOps();

		Xls_Reader xr=new Xls_Reader("binaries/FCfiles/FCFile.xlsx"); int
		i=Integer.parseInt(Row);
		String orderId=xr.getCellData("Input","OrderId", i).trim();

		commonOps.openManageOrdersPageAndSearchOrder(orderId);
		SeleniumFunction.click(manageOrderPage.ActionButton());
		SeleniumFunction.click(manageOrderPage.billOfLoadingPdf());
		WaitTool.sleep(10); 
		ScreenShot.takeScreenShot(driver, "BillofLadingPDF for order id "+orderId);


		String fileName = orderId+"BOL.pdf";
		this.checkPdfFilePresenceAndPageCount(fileName, 1);
	}

}
