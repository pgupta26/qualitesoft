package com.qualitesoft.channelgatesip.testscripts.products;

import org.testng.annotations.Test;

import com.qualitesoft.channelgatesip.pageobjects.ProductListing;
import com.qualitesoft.channelgatesip.testdata.ProductData;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;

public class TestEditProduct extends InitializeTest{

	@Test
	public void updateAddedProduct(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			ProductData data = new ProductData();

			Xls_Reader xr1=new Xls_Reader("testdata/CGFiles/ChannelGateTestData.xlsx");
			int i=Integer.parseInt(Row);
			String skuNumber = xr1.getCellData("Add Product", "SKU", i);
			String productTitle = xr1.getCellData("Add Product", "Product Title", i);
			
			SeleniumFunction.sendKeys(listingPage.searchBySkuAndProductIdField(), skuNumber);
			SeleniumFunction.click(listingPage.goBtn());
			WaitTool.sleep(3);
			
			listingPage.getTableData(1, 1);
			
			SeleniumFunction.click(listingPage.getProductTitle());
			listingPage.backBtn();
			
			UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getProductDetails("SKU")), skuNumber);
			UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getProductDetails("Data Source")), "CG");
			UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getProductDetails("Content Score")), data.getContentScore());
			UseAssert.assertEquals(SeleniumFunction.getText(listingPage.getProductDetails("Created Date")), JavaFunction.currentPSTDate("MMM dd, yyyy"));

			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setProductTitle(), "value"), productTitle);
			UseAssert.assertEquals(SeleniumFunction.getText(listingPage.SelectBrand()), data.getProductBrand());
			
			UseAssert.assertEquals(SeleniumFunction.getText(listingPage.SelectCollections()), data.getCollections());
			UseAssert.assertEquals(SeleniumFunction.getText(listingPage.clicktCategoryDropdown()), data.getCategory());
			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setSku(), "value"), data.getSku());
			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setUpc(), "value"), data.getUpcCode());
			UseAssert.assertEquals(SeleniumFunction.getText(listingPage.selectManufactureCountry()), data.getManufactureCountry());
			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setWholesalePrice(), "value"), data.getWholesalePrice());
			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setFreightPrice(), "value"), "0");
			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setMsrpPrice(), "value"), data.getMsrpPrice());
			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setMapPrice(), "value"), data.getMapPrice());
			UseAssert.assertEquals(SeleniumFunction.getText(listingPage.selectColor()), data.getColor());
			UseAssert.assertEquals(SeleniumFunction.getText(listingPage.selectMaterial()), data.getMaterial());
			UseAssert.assertEquals(SeleniumFunction.getText(listingPage.selectStyle()), data.getStyle());
			//UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.getSellingPrice(), "value"), baseRateRow);
			
			
			SeleniumFunction.scrollIntoView(driver, listingPage.scrollUptoSaveBtn());
			SeleniumFunction.click(listingPage.addProductHeaders("Description"));
			
			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setShortDescription(), "value"), data.getShortDescription());
			WaitTool.sleep(5);
			System.out.println(listingPage.setPreposition65Radio("No").isSelected());
			System.out.println(listingPage.setCommercialUseRadio("Yes").isSelected());
			//UseAssert.assertEquals(listingPage.setPreposition65Radio("No").isSelected(), true);
			//UseAssert.assertEquals(listingPage.setCommercialUseRadio("Yes").isSelected(), true);
			
			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setFeature_1(), "value"), data.getFeature1());
			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setFeature_2(), "value"), data.getFeature2());
			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setFeature_3(), "value"), data.getFeature3());
			UseAssert.assertEquals(SeleniumFunction.getText(listingPage.selectKey(1)), data.getKey1());
			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setKeysValue(1), "value"), data.getValue1());
			
			SeleniumFunction.scrollIntoView(driver, listingPage.scrollUptoSaveBtn());
			SeleniumFunction.click(listingPage.addProductHeaders("Shipping"));
			
			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setAvailableQuantity(), "value"), data.getAvailableQuantity());
			UseAssert.assertEquals(SeleniumFunction.getText(listingPage.selectShippingService()), data.getShippingService());
			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setLeadMinTime(), "value"), data.getMinLeadTime() + " days");
			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setLeadMaxTime(), "value"), data.getMaxLeadTime() + " days");
			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setHsCode(), "value"), data.getHsCode());
			
			
			System.out.println(listingPage.setSoldInCanadaRadio("Yes").isSelected());
			System.out.println(listingPage.setPreAssembledCheck("No").isSelected());
			System.out.println(listingPage.setShipPalletCheckRadio("Yes").isSelected());
			System.out.println(listingPage.setUsaCheck("Yes").isSelected());
			System.out.println(listingPage.setBackOrderedCheck("No").isSelected());
			
			//UseAssert.assertEquals(listingPage.setSoldInCanadaRadio("Yes").isSelected(), true);
			//UseAssert.assertEquals(listingPage.setShipPalletCheckRadio("Yes").isSelected(), true);
			//UseAssert.assertEquals(listingPage.setPreAssembledCheck("No").isSelected(), true);
			//UseAssert.assertEquals(listingPage.setUsaCheck("Yes").isSelected(), true);
			//UseAssert.assertEquals(listingPage.setBackOrderedCheck("No").isSelected(), true);
			
			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setProductHeight(), "value"), data.getHeight());
			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setProductWidth(), "value"), data.getWidth());
			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setProductDepth(), "value"), data.getDepth());
			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setProductWeight(), "value"), data.getWeight());
			
			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setPackageHeight(), "value"), data.getPackageHeight());
			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setPackageWidth(), "value"), data.getPackageWidth());
			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setPackageDepth(), "value"), data.getPackageDepth());
			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setPackageWeight(), "value"), data.getPackageWeight());
			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setPackageSku(), "value"), data.getPackageSKU());
			UseAssert.assertEquals(SeleniumFunction.getText(listingPage.setPackageType()), data.getPackageType());
			UseAssert.assertEquals(SeleniumFunction.getAttribute(listingPage.setPackageQuantity(), "value"), data.getQty());
			
			xr1.setCellData("Add Product", "Product Title", i, "Test Automation Title " + JavaFunction.getRandomNumber(10, 100000));
			String updatedProductTitle = xr1.getCellData("Add Product", "Product Title", i);
			
			//SeleniumFunction.click(listingPage.activeToggle());
			WaitTool.sleep(5);
			
			SeleniumFunction.scrollIntoView(driver, listingPage.scrollUptoSaveBtn());
			SeleniumFunction.click(listingPage.addProductHeaders("Details"));
			
			SeleniumFunction.sendKeys(listingPage.setProductTitle(), updatedProductTitle);
			
			SeleniumFunction.scrollIntoView(driver, listingPage.scrollUptoSaveBtn());
			SeleniumFunction.click(listingPage.addProductHeaders("Images"));
			
			SeleniumFunction.scrollIntoView(driver, listingPage.addProductHeaders("Images"));
			SeleniumFunction.uploadImage(listingPage.uploadImage(1), System.getProperty("user.dir") + "\\testdata\\CGFiles\\CG_image.jpg");

			SeleniumFunction.scrollUp(driver);			
			UseAssert.assertEquals(listingPage.contentScore(), true);
			
			SeleniumFunction.click(listingPage.scrollUptoSaveBtn());
			String mess = SeleniumFunction.getText(listingPage.uploadingSuccessMessage());
			UseAssert.assertEquals(mess, "The product is successfully saved.");
		}catch(Exception e){
			Log.warn(e.getMessage());
		}
	}
}
