package com.qualitesoft.channelgatesip.testscripts.products;

import org.testng.annotations.Test;

import com.qualitesoft.channelgatesip.pageobjects.CommonPage;
import com.qualitesoft.channelgatesip.pageobjects.ProductListing;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;

public class TestBulkActionFunctionality extends InitializeTest{
	
	public static void bulkAction(String fileName, String btnName, int index, String messHeader, String messBody){
		try{
		ProductListing listingPage = new ProductListing(driver);
		CommonPage commonPage = new CommonPage(driver);
		
		SeleniumFunction.click(listingPage.bulkActionsBtn());
		WaitTool.sleep(3);
		
		SeleniumFunction.click(listingPage.bulkActionButtons(btnName));
		String popupHeader = SeleniumFunction.getText(listingPage.bulkActionPopupHeader());
		UseAssert.assertEquals(popupHeader, "Bulk Actions");
		SeleniumFunction.uploadImage(listingPage.uploadImage(index), System.getProperty("user.dir") + fileName);
		
		SeleniumFunction.scrollDownUptoFooter(driver);
		SeleniumFunction.scrollIntoView(driver, listingPage.bulkActionPopupHeader());
		
		SeleniumFunction.click(listingPage.uploadBtn());
	
		UseAssert.assertEquals(SeleniumFunction.getText(commonPage.getToastMessageHeader(1)), messHeader);
		UseAssert.assertEquals(SeleniumFunction.getText(commonPage.getToastMessageText(1)), messBody);
		WaitTool.sleep(6);
		
		String header = SeleniumFunction.getText(commonPage.getToastMessageHeader(1));
		String successMessage = SeleniumFunction.getText(commonPage.getToastMessageText(1));
		Log.info(header + successMessage);
		WaitTool.sleep(6);
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}
	
	@Test(priority = 1)
	public void downloadTemplate(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			SeleniumFunction.click(listingPage.bulkActionsBtn());
			WaitTool.sleep(3);
			
			SeleniumFunction.click(listingPage.downloadTemplateLink(1));
			WaitTool.sleep(5);
			SeleniumFunction.click(listingPage.cancelBtn());
		
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}

	@Test(priority = 2)
	public void addUpdateProducts(){
		bulkAction("//testdata//CGFiles//AddProductsTemplate.xlsx", "ADD/UPDATE PRODUCTS", 1, "Uploading Products", "We are uploading your products");
	}
	
	@Test(priority = 3)
	public void updateProducts(){
		bulkAction("//testdata//CGFiles//UpdateProductTemplate.xlsx", "ADD/UPDATE PRODUCTS", 1, "Uploading Products", "We are uploading your products");
	}
	
	@Test(priority = 4)
	public void downloadDeactivateProductsTemplate(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			SeleniumFunction.click(listingPage.bulkActionsBtn());
			WaitTool.sleep(3);
			
			SeleniumFunction.click(listingPage.bulkActionButtons("DEACTIVATE PRODUCTS"));
			SeleniumFunction.click(listingPage.downloadTemplateLink(2));
			WaitTool.sleep(5);
			SeleniumFunction.click(listingPage.cancelBtn());
		
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}
	
	@Test(priority = 5)
	public void deactivateProducts(){
		bulkAction("//testdata//CGFiles//DeactivateProductsTemplate.xlsx", "DEACTIVATE PRODUCTS", 2, "Deactivating Products", "We are deactivating your products");
	}
}
