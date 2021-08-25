package com.qualitesoft.channelgatesip.testscripts.products;

import org.testng.annotations.Test;

import com.qualitesoft.channelgatesip.pageobjects.ProductListing;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;

public class TestBulkActionFunctionality extends InitializeTest{
	
	public static void bulkAction(String fileName, String btnName){
		try{
		ProductListing listingPage = new ProductListing(driver);
		driver.navigate().refresh();
		listingPage.getTableData(1, 1);
		SeleniumFunction.click(listingPage.bulkActionsBtn());
		WaitTool.sleep(3);
		SeleniumFunction.click(listingPage.bulkActionButtons(btnName));
		String popupHeader = SeleniumFunction.getText(listingPage.bulkActionPopupHeader());
		UseAssert.assertEquals(popupHeader, "Bulk Actions");
		SeleniumFunction.uploadImage(listingPage.uploadImage(1), System.getProperty("user.dir") + fileName);
		SeleniumFunction.scrollDownUptoFooter(driver);
		SeleniumFunction.scrollIntoView(driver, listingPage.bulkActionPopupHeader());
		
		SeleniumFunction.click(listingPage.uploadBtn());
		
		String actualMess = SeleniumFunction.getText(listingPage.warningMessage());
		UseAssert.assertEquals(actualMess, "It seems the file was not downloaded today, do you want to proceed with the update ?");
		WaitTool.sleep(5);
		SeleniumFunction.scrollIntoView(driver, listingPage.warningMessage());
		
		SeleniumFunction.click(listingPage.acceptWarning());
		String uploadMessage = SeleniumFunction.getText(listingPage.uploadMessage());
		UseAssert.assertEquals(uploadMessage, "Uploading Products\nWe are uploading your products");
		String successMessage = SeleniumFunction.getText(listingPage.uploadingSuccessMessage());
		Log.info(successMessage);
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}
	
	@Test(priority = 1)
	public void downloadTemplate(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			SeleniumFunction.click(listingPage.downloadTemplateLink());
			WaitTool.sleep(10);
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}

	@Test(priority = 2)
	public void addUpdateProducts(){
		bulkAction("//binaries//CGFiles//AddProductsTemplate.xlsx", "Add / Update Products");
	}
	
	@Test(priority = 3)
	public void updateInventory(){
		bulkAction("//binaries//CGFiles//UpdateProductTemplate.xlsx", "Add / Update Products");
	}
	
	/*@Test
	public void deactivateProducts(){
		bulkAction("//binaries//CGFiles//Deactivate Products Template.xlsx", "Deactivate Products");
	}*/
}
