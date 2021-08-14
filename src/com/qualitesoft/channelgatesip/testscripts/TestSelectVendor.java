package com.qualitesoft.channelgatesip.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.channelgatesip.pageobjects.ProductListing;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;

public class TestSelectVendor extends InitializeTest{

	@Test
	public void selectDemoVendor(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			SeleniumFunction.click(listingPage.clickOnVendorDropdown());
			SeleniumFunction.sendKeys(listingPage.searchVendorNameOnDropdown(), "Demo Vendor");
			SeleniumFunction.click(listingPage.selectVendorName());
			listingPage.getTableData(2, 2);
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}

}
