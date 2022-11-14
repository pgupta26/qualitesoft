package com.qualitesoft.channelgatesip.testscripts.products;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.channelgatesip.pageobjects.CommonPage;
import com.qualitesoft.channelgatesip.pageobjects.ProductListing;
import com.qualitesoft.channelgatesip.testdata.ProductData;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;

public class TestAddProduct extends InitializeTest{

	public static void scrollUptoHeader(String headerName){
		ProductListing listingPage = new ProductListing(driver);

		SeleniumFunction.scrollIntoView(driver, listingPage.scrollUptoSaveBtn());
		SeleniumFunction.click(listingPage.addProductHeaders(headerName));
		WaitTool.sleep(1);
	}

	@Test(priority = 1,  enabled = false)
	public void clickNewProductBtnAndVerifyValidations(){
		try{
			CommonPage commonPage = new CommonPage(driver);

			SeleniumFunction.click(commonPage.clickLeftMenuOption("Product Management"));
			SeleniumFunction.click(commonPage.clickLeftMenuOption("Products"));
			SeleniumFunction.click(commonPage.clickLeftMenuOption("Add New Product"));

			String validationMessage = "";
			SeleniumFunction.click(commonPage.clickButtonByText("Save"));
			String invalidCredentials= SeleniumFunction.getText(commonPage.getToastMessageText(1));

			UseAssert.assertEquals(invalidCredentials, "Please correct the following errors");

			List<WebElement> validationElement = driver.findElements(By.xpath("(//span[contains(@class,'text-xs text-danger')])"));

			for(int i=0; i<validationElement.size(); i++){
				if(i==9){
					scrollUptoHeader("Description");
				}
				else if(i==15){
					scrollUptoHeader("Shipping");
				}
				String validationMess = SeleniumFunction.getText(validationElement.get(i));
				SeleniumFunction.scrollIntoView(driver, validationElement.get(i));
				WaitTool.sleep(1);
				validationMessage = validationMessage + validationMess;
				Log.info(validationMessage);
			}
			UseAssert.assertEquals(validationMessage, "Product Title is required.Brand Name is required."
					+ "Category is required.SKU is required.UPC is required.Country of Manufacture is required."
					+ "Wholesale price should be greater than 0.Color Family Name is required.Material Name is required."
					+ "Description is required.Feature is requiredFeature is requiredFeature is required"
					+ "Proposition 65 is required.Commercial Use is required.Shipping Service is required."
					+ "Ship on Pallet? is required.Assembly Required? is required.Sold in US? is required."
					+ "Sold in Canada? is required.Is Backordered? is required.Product Weight should be greater than 0."
					+ "Package SKU is required.Package Type is requiredQuantity should be greater than 0.");

		}catch(Exception e){
			Log.info(e.getMessage());
		}
	}

	@Test(priority = 2)
	public void fillProductData(){		
		try{
			ProductListing listingPage = new ProductListing(driver);
			ProductData data = new ProductData();
			CommonPage commonPage = new CommonPage(driver);

			SeleniumFunction.click(commonPage.clickLeftMenuOption("Product Management"));
			SeleniumFunction.click(commonPage.clickLeftMenuOption("Products"));
			SeleniumFunction.click(commonPage.clickLeftMenuOption("Add New Product"));

			Xls_Reader xr1=new Xls_Reader("testdata/CGFiles/ChannelGateTestData.xlsx");
			int i=Integer.parseInt(Row);
			
			String title =  "Test Automation Title " + JavaFunction.getRandomNumber(10, 1000);
			
			xr1.setCellData("Add Product", "Product Title", i, title);
			xr1.setCellData("Add Product", "SKU", i, "automation_sku_" + JavaFunction.getRandomNumber(10, 1000));

			
			String producttitle = xr1.getCellData("Add Product", "Product Title", i);
			

			SeleniumFunction.sendKeys(listingPage.setProductTitle(), producttitle);
			SeleniumFunction.click(listingPage.SelectBrand());
			SeleniumFunction.click(listingPage.selectDropdownValueByText(data.getProductBrand()));

			SeleniumFunction.click(listingPage.SelectCollections());
			SeleniumFunction.click(listingPage.selectDropdownValueByText(data.getCollections()));


			SeleniumFunction.scrollIntoView(driver, listingPage.SelectCollections());
			SeleniumFunction.click(listingPage.clicktCategoryDropdown());
			SeleniumFunction.click(listingPage.selectDropdownValueByText(data.getCategory()));


			SeleniumFunction.sendKeys(listingPage.setSku(), data.getSku());
			SeleniumFunction.sendKeys(listingPage.setUpc(), data.getUpcCode());

			SeleniumFunction.click(listingPage.selectManufactureCountry());
			SeleniumFunction.click(listingPage.selectDropdownValueByText(data.getManufactureCountry()));

			SeleniumFunction.sendKeys(listingPage.setWholesalePrice(), data.getWholesalePrice());
			//SeleniumFunction.sendKeys(listingPage.setFreightPrice(), freight);
			SeleniumFunction.sendKeys(listingPage.setMsrpPrice(), data.getMsrpPrice());
			SeleniumFunction.sendKeys(listingPage.setMapPrice(), data.getMapPrice());

			SeleniumFunction.click(listingPage.selectColor());
			SeleniumFunction.click(listingPage.selectDropdownValueByText(data.getColor()));

			SeleniumFunction.click(listingPage.selectMaterial());
			SeleniumFunction.click(listingPage.selectDropdownValueByText(data.getMaterial()));

			SeleniumFunction.click(listingPage.selectStyle());
			SeleniumFunction.click(listingPage.selectDropdownValueByText(data.getStyle()));

			SeleniumFunction.scrollIntoView(driver, listingPage.scrollUptoSaveBtn());
			SeleniumFunction.click(listingPage.addProductHeaders("Description"));


			SeleniumFunction.sendKeys(listingPage.setShortDescription(), data.getShortDescription());
			SeleniumFunction.scrollIntoView(driver, listingPage.addProductHeaders("Description"));

			SeleniumFunction.click(listingPage.setPreposition65Radio("No"));
			SeleniumFunction.click(listingPage.setCommercialUseRadio("Yes"));
			WaitTool.sleep(2);
			SeleniumFunction.sendKeys(listingPage.setFeature_1(), data.getFeature1());
			SeleniumFunction.sendKeys(listingPage.setFeature_2(), data.getFeature2());
			SeleniumFunction.scrollIntoView(driver, listingPage.setFeature_2());

			SeleniumFunction.sendKeys(listingPage.setFeature_3(), data.getFeature3());
			SeleniumFunction.click(listingPage.addFeatureRow());
			SeleniumFunction.sendKeys(listingPage.setFeature_4(), data.getFeature3());
			SeleniumFunction.click(listingPage.deleteFeatureRow());

			WaitTool.sleep(2);
			SeleniumFunction.click(listingPage.selectKey(1));
			SeleniumFunction.click(listingPage.selectDropdownValueByText(data.getKey1()));


			SeleniumFunction.sendKeys(listingPage.setKeysValue(1), data.getValue1());

			SeleniumFunction.click(listingPage.addProductSpecificationRow());
			SeleniumFunction.click(listingPage.selectKey(2));
			SeleniumFunction.click(listingPage.selectDropdownValueByText(data.getKey3()));
			SeleniumFunction.sendKeys(listingPage.setKeysValue(2), data.getValue3());

			SeleniumFunction.click(listingPage.removeProductSpecificationRow(2));
			WaitTool.sleep(2);
			SeleniumFunction.scrollIntoView(driver, listingPage.scrollUptoSaveBtn());
			SeleniumFunction.click(listingPage.addProductHeaders("Shipping"));

			SeleniumFunction.sendKeys(listingPage.setAvailableQuantity(), data.getAvailableQuantity());

			SeleniumFunction.click(listingPage.selectShippingService());
			SeleniumFunction.click(listingPage.selectDropdownValueByText(data.getShippingService()));

			SeleniumFunction.sendKeys(listingPage.setLeadMinTime(), data.getMinLeadTime());
			SeleniumFunction.sendKeys(listingPage.setLeadMaxTime(), data.getMaxLeadTime());

			SeleniumFunction.scrollIntoView(driver, listingPage.addProductHeaders("Shipping"));
			int length = data.getHsCode().length();
			for(int p = 0; p < length; p++){  
				String chars = String.valueOf(data.getHsCode().charAt(p));
				listingPage.setHsCode().sendKeys(chars);
			}  

			SeleniumFunction.click(listingPage.setSoldInCanadaRadio("No"));
			SeleniumFunction.click(listingPage.setShipPalletCheckRadio("Yes"));
			SeleniumFunction.click(listingPage.setPreAssembledCheck("No"));
			SeleniumFunction.click(listingPage.setUsaCheck("Yes"));
			SeleniumFunction.click(listingPage.setBackOrderedCheck("No"));


			SeleniumFunction.scrollIntoView(driver, listingPage.setHsCode());
			SeleniumFunction.sendKeys(listingPage.setProductHeight(), data.getHeight());
			SeleniumFunction.sendKeys(listingPage.setProductWidth(), data.getWidth());
			SeleniumFunction.sendKeys(listingPage.setProductDepth(), data.getDepth());
			SeleniumFunction.sendKeys(listingPage.setProductWeight(), data.getWeight());

			SeleniumFunction.scrollIntoView(driver, listingPage.setProductHeight());
			SeleniumFunction.sendKeys(listingPage.setPackageHeight(), data.getPackageHeight());
			SeleniumFunction.sendKeys(listingPage.setPackageWidth(), data.getPackageWidth());
			SeleniumFunction.sendKeys(listingPage.setPackageDepth(), data.getPackageDepth());
			SeleniumFunction.sendKeys(listingPage.setPackageWeight(), data.getPackageWeight());
			SeleniumFunction.sendKeys(listingPage.setPackageSku(), data.getPackageSKU());
			SeleniumFunction.sendKeys(listingPage.setPackageQuantity(), data.getQty());

			SeleniumFunction.click(listingPage.setPackageType());
			SeleniumFunction.click(listingPage.selectDropdownValueByText(data.getPackageType()));

			SeleniumFunction.scrollIntoView(driver, listingPage.scrollUptoSaveBtn());
			SeleniumFunction.click(listingPage.addProductHeaders("Images"));
			SeleniumFunction.scrollIntoView(driver, listingPage.addProductHeaders("Images"));

			String fileName =  System.getProperty("user.dir") + "\\testdata\\logo\\logo.jpg";
			SeleniumFunction.uploadImage(listingPage.uploadImage(1), fileName);

			//SeleniumFunction.click(listingPage.setPrimaryImage());
			SeleniumFunction.scrollIntoView(driver, listingPage.scrollUptoSaveBtn());

			SeleniumFunction.click(listingPage.addProductHeaders("Resources"));
			SeleniumFunction.click(listingPage.clickImportResources());

			SeleniumFunction.uploadImage(listingPage.uploadImage(2), System.getProperty("user.dir") + "\\testdata\\CGFiles\\sample.pdf");

			if(existingbrand.contains("Yes")){
				SeleniumFunction.click(listingPage.activeToggle());
			}

			WaitTool.sleep(5);
			SeleniumFunction.click(listingPage.clickCloseButton());
			SeleniumFunction.click(listingPage.scrollUptoSaveBtn());
			String mess = SeleniumFunction.getText(commonPage.getToastMessageText(1));
			UseAssert.assertEquals(mess, "The product is successfully saved.");
		}catch(Exception e){ Log.info(e.getMessage()); }

	}
}
