package com.qualitesoft.channelgatesip.testscripts.products;

import org.testng.annotations.Test;

import com.qualitesoft.channelgatesip.pageobjects.CommonPage;
import com.qualitesoft.channelgatesip.pageobjects.ProductListing;
import com.qualitesoft.channelgatesip.pageobjects.WhiteLabelProductPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;

public class TestWhiteLabelProduct extends InitializeTest{

	@Test
	public void aTestFilterWhiteLabelProduct() {		
		WhiteLabelProductPage productPage = new WhiteLabelProductPage(driver);
		ProductListing listingPage = new ProductListing(driver);
		CommonPage commonPage = new CommonPage(driver);
		
		
		SeleniumFunction.click(commonPage.clickLeftMenuOption("Product Management"));
		SeleniumFunction.click(commonPage.clickLeftMenuOption("Products"));
		SeleniumFunction.click(commonPage.clickLeftMenuOption("Create White Label"));
		
		WaitTool.sleep(5);
		
		SeleniumFunction.click(productPage.clickBrandField());
		SeleniumFunction.click(listingPage.selectCheckbox("Test 3 (ID - 2207)"));
		SeleniumFunction.click(listingPage.clickCloseMultiselectPopup());
		WaitTool.sleep(2);
		
		SeleniumFunction.click(productPage.clickWhiteLabelBrandField());
		SeleniumFunction.click(listingPage.selectDropdownValue("Test On Live (ID - 2208) (WL)"));
		WaitTool.sleep(2);
		
		SeleniumFunction.click(listingPage.clickApplyFilterBtn());
		WaitTool.sleep(10);
		
		UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(1)), "Brand is ( Test 3 )");
		UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getSelectedFilterText(2)), "White Label Brand is (Test On Live )");		
		
	}
	
	@Test
	public void bTestExportWhiteLabelProduct() {		
		WhiteLabelProductPage productPage = new WhiteLabelProductPage(driver);
		CommonPage commonPage = new CommonPage(driver);
		
		
		SeleniumFunction.click(productPage.clickExportBtn());
		UseAssert.assertEquals(SeleniumFunction.getText(commonPage.getToastMessage()), "File Export successfully");
		
	}
	
}
