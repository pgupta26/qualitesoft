package com.qualitesoft.channelgatesip.testscripts.products;

import org.testng.annotations.Test;

import com.qualitesoft.channelgatesip.pageobjects.ProductListing;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;

public class TestEditProduct extends InitializeTest{

	@Test
	public void openEditProductPage(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			listingPage.firstPageBtnStatus();
			SeleniumFunction.click(listingPage.productTitle(1, 2));
			SeleniumFunction.getCurrentWindow(driver);
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}
	
	@Test
	public void updateAddedProduct(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			Xls_Reader xr1=new Xls_Reader("binaries/CGFiles/ChannelGateTestData.xlsx");
			int i=Integer.parseInt(Row);
			xr1.setCellData("Add Product", "Product Title", i, "Test Automation Title " + JavaFunction.getRandomNumber(10, 100000));
			String productTitle = xr1.getCellData("Add Product", "Product Title", i);
			
			listingPage.cancelBtn();

			WaitTool.sleep(15);
			SeleniumFunction.sendKeys(listingPage.setProductTitle(), productTitle);
			
			SeleniumFunction.click(listingPage.addProductHeaders("Images"));
			SeleniumFunction.scrollIntoView(driver, listingPage.addProductHeaders("Images"));
			SeleniumFunction.uploadImage(listingPage.uploadImage(1), System.getProperty("user.dir") + "\\binaries\\CGFiles\\CG_image.jpg");

			SeleniumFunction.click(listingPage.scrollToTop());
			SeleniumFunction.click(listingPage.addProductHeaders("Resources"));
			SeleniumFunction.uploadImage(listingPage.uploadImage(2), System.getProperty("user.dir") + "\\binaries\\CGFiles\\AssemblyFile.pdf");

			UseAssert.assertEquals(listingPage.historyHeader(), true);
			UseAssert.assertEquals(listingPage.contentScore(), true);
			
			/*SeleniumFunction.click(lirstingPage.activeToggle());*/
			WaitTool.sleep(5);
			SeleniumFunction.click(listingPage.saveBtn());
			String mess = SeleniumFunction.getText(listingPage.uploadingSuccessMessage());
			UseAssert.assertEquals(mess, "×\nThe product is successfully saved");
			SeleniumFunction.closeWindow(driver);
			SeleniumFunction.getCurrentWindow(driver);
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}
}
