package com.qualitesoft.channelgatesip.testscripts.products;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.channelgatesip.pageobjects.ProductListing;
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
		SeleniumFunction.click(listingPage.scrollToTop());
		SeleniumFunction.scrollIntoView(driver, listingPage.addProductHeaders(headerName));
		SeleniumFunction.click(listingPage.addProductHeaders(headerName));
		WaitTool.sleep(1);
	}

	@Test(priority = 1)
	public void clickNewProductBtnAndVerifyValidations(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			SeleniumFunction.click(listingPage.newProductBtn());
			listingPage.cancelBtn();

			WaitTool.sleep(15);
			String validationMessage = "";
			SeleniumFunction.click(listingPage.saveBtn());

			List<WebElement> validationElement = driver.findElements(By.xpath("//span[@class='help-block']"));

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
			UseAssert.assertEquals(validationMessage, "Product Title is required.Brand is required. "
					+ "Please choose a valid brand.Category is required. Please choose a valid category."
					+ "SKU is required.UPC is required.Country of manufacture is required. "
					+ "Please select from the list.The Wholesale price is required."
					+ "Color Family is required. Please select from the list.Material is required. "
					+ "Please select from the list.Short Description is required."
					+ "Short Description should be between 40-2000 characters.For Commercial Use value is required."
					+ "Feature value is required.Feature value is required.Feature value is required."
					+ "The Shipping Service is required.Product Weight should be above 0."
					+ "Quantity value should be above 0.The Package Type is required.Package SKU is required.");

			scrollUptoHeader("Details");
			SeleniumFunction.click(listingPage.scrollToTop());
			
			String alertMess = SeleniumFunction.getText(listingPage.getAlertMessage());
			UseAssert.assertEquals(alertMess, "Please correct the following errors:\nProduct Title\nBrand\n"
					+ "Category\nSKU\nUPC\nCountry of Manufacture\nWholesale Price\nShipping Service\nProduct"
					+ " Dimensions: Weight\nShort Description\nFor Commercial Use\nFeature 1\nFeature 2\nFeature 3"
					+ "\nColor Family\nMaterial\nPackage Dimensions: Qty\nPackage Type\nPackage Dimensions: Package SKU\n"
					+ "All the letters in the title cannot be either UPPERCASE or lowercase.\nField: Category, "
					+ "Error: Select a Value");


		}catch(Exception e){
			Log.info(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = false)
	public void fillProductData(){
		try{
			ProductListing listingPage = new ProductListing(driver);
			Xls_Reader xr1=new Xls_Reader("binaries/CGFiles/ChannelGateTestData.xlsx");
			int i=Integer.parseInt(Row);
			xr1.setCellData("Add Product", "Product Title", i, "Test Automation Title " + JavaFunction.getRandomNumber(10, 20));
			xr1.setCellData("Add Product", "SKU", i, "automation_sku_" + JavaFunction.getRandomNumber(10, 1000));
			
			
			String productTitle = xr1.getCellData("Add Product", "Product Title", i);
			String brand = xr1.getCellData("Add Product", "Brand", i);
			String collections = xr1.getCellData("Add Product", "Collections", i);
			String category = xr1.getCellData("Add Product", "Category", i);
			String sku = xr1.getCellData("Add Product", "SKU", i);
			String upc = xr1.getCellData("Add Product", "UPC", i);
			String manufactureCountry = xr1.getCellData("Add Product", "Country of Manufacture", i);
			String wholesale = xr1.getCellData("Add Product", "Wholesale", i);
			//String freight = xr1.getCellData("Add Product", "Freight", i);
			String msrp = xr1.getCellData("Add Product", "MSRP", i);
			String map = xr1.getCellData("Add Product", "MAP", i);
			String color = xr1.getCellData("Add Product", "Color", i);
			String material = xr1.getCellData("Add Product", "Material", i);
			String style = xr1.getCellData("Add Product", "Style", i);
			String shortDesc = xr1.getCellData("Add Product", "Short Description", i);
			String feature_1 = xr1.getCellData("Add Product", "Feature 1", i);
			String feature_2 = xr1.getCellData("Add Product", "Feature 2", i);
			String feature_3 = xr1.getCellData("Add Product", "Feature 3", i);
			String key_1 = xr1.getCellData("Add Product", "Key1", i);
			String value_1 = xr1.getCellData("Add Product", "Value1", i);
			String key_2 = xr1.getCellData("Add Product", "Key2", i);
			String value_2 = xr1.getCellData("Add Product", "Value2", i);
			String key_3 = xr1.getCellData("Add Product", "Key3", i);
			String value_3 = xr1.getCellData("Add Product", "Value3", i);
			String available_quantity = xr1.getCellData("Add Product", "Available Quantity", i);
			String shippingService = xr1.getCellData("Add Product", "Shipping Service", i);
			String minLeadTime = xr1.getCellData("Add Product", "Min Lead Time", i);
			String maxLeadTime = xr1.getCellData("Add Product", "Max Lead Time", i);
			String hsCode = xr1.getCellData("Add Product", "HS Code", i);
			String height = xr1.getCellData("Add Product", "Height", i);
			String width = xr1.getCellData("Add Product", "Width", i);
			String depth = xr1.getCellData("Add Product", "Depth", i);
			String weight = xr1.getCellData("Add Product", "Weight", i);
			String p_height = xr1.getCellData("Add Product", "Package Height", i);
			String p_width = xr1.getCellData("Add Product", "Package Width", i);
			String p_depth = xr1.getCellData("Add Product", "Package Depth", i);
			String p_weight = xr1.getCellData("Add Product", "Package Weight", i);
			String p_quantity = xr1.getCellData("Add Product", "Qty ", i);
			String p_type = xr1.getCellData("Add Product", "Package Type", i);
			String p_sku = xr1.getCellData("Add Product", "Package SKU", i);

			SeleniumFunction.sendKeys(listingPage.setProductTitle(), productTitle);
			SeleniumFunction.selectByVisibleText(listingPage.SelectBrand(), brand);
			SeleniumFunction.selectByVisibleText(listingPage.SelectCollections(), collections);

			SeleniumFunction.scrollIntoView(driver, listingPage.SelectCollections());
			SeleniumFunction.click(listingPage.clicktCategoryDropdown());
			SeleniumFunction.sendKeys(listingPage.searchVendorNameOnDropdown(), category);
			SeleniumFunction.click(listingPage.selectCategoryName());

			SeleniumFunction.sendKeys(listingPage.setSku(), sku);
			SeleniumFunction.sendKeys(listingPage.setUpc(), upc);
			SeleniumFunction.selectByvalue(listingPage.selectManufactureCountry(), manufactureCountry);
			SeleniumFunction.sendKeys(listingPage.setWholesalePrice(), wholesale);
			//SeleniumFunction.sendKeys(listingPage.setFreightPrice(), freight);
			SeleniumFunction.sendKeys(listingPage.setMsrpPrice(), msrp);
			SeleniumFunction.sendKeys(listingPage.setMapPrice(), map);

			SeleniumFunction.selectByVisibleText(listingPage.selectColor(), color);
			SeleniumFunction.selectByVisibleText(listingPage.selectMaterial(), material);
			SeleniumFunction.selectByVisibleText(listingPage.selectStyle(), style);
			SeleniumFunction.click(listingPage.scrollToTop());

			SeleniumFunction.click(listingPage.addProductHeaders("Description"));
			SeleniumFunction.sendKeys(listingPage.setShortDescription(), shortDesc);

			SeleniumFunction.scrollIntoView(driver, listingPage.addProductHeaders("Description"));
			SeleniumFunction.click(listingPage.setCommercialUseRadio(1));
			//SeleniumFunction.click(listingPage.clickExternalLink());
			WaitTool.sleep(2);
			SeleniumFunction.sendKeys(listingPage.setFeature_1(), feature_1);
			SeleniumFunction.sendKeys(listingPage.setFeature_2(), feature_2);
			SeleniumFunction.scrollIntoView(driver, listingPage.setFeature_2());

			SeleniumFunction.sendKeys(listingPage.setFeature_3(), feature_3);
			SeleniumFunction.click(listingPage.addFeatureRow());
			SeleniumFunction.sendKeys(listingPage.setFeature_4(), feature_3);
			SeleniumFunction.click(listingPage.deleteFeatureRow());

			WaitTool.sleep(2);
			SeleniumFunction.selectByVisibleText(listingPage.setKey_1(), key_1);
			SeleniumFunction.sendKeys(listingPage.setValue_1(), value_1);
			SeleniumFunction.selectByVisibleText(listingPage.setKey_2(), key_2);
			SeleniumFunction.sendKeys(listingPage.setValue_2(), value_2);
			SeleniumFunction.selectByVisibleText(listingPage.setKey_3(), key_3);
			SeleniumFunction.sendKeys(listingPage.setValue_3(), value_3);
			SeleniumFunction.click(listingPage.addProductSpecificationRow());
			SeleniumFunction.selectByVisibleText(listingPage.setKey_4(), key_3);
			SeleniumFunction.sendKeys(listingPage.setValue_4(), value_3);
			SeleniumFunction.click(listingPage.removeProductSpecificationRow());
			WaitTool.sleep(2);
			SeleniumFunction.click(listingPage.scrollToTop());
			SeleniumFunction.click(listingPage.addProductHeaders("Shipping"));

			SeleniumFunction.sendKeys(listingPage.setAvailableQuantity(), available_quantity);
			SeleniumFunction.selectByVisibleText(listingPage.selectShippingService(), shippingService);
			SeleniumFunction.sendKeys(listingPage.setLeadMinTime(), minLeadTime);
			SeleniumFunction.sendKeys(listingPage.setLeadMaxTime(), maxLeadTime);

			SeleniumFunction.scrollIntoView(driver, listingPage.addProductHeaders("Shipping"));
			SeleniumFunction.sendKeys(listingPage.setHsCode(), hsCode);
			
			SeleniumFunction.click(listingPage.setSoldInCanadaRadio(1));
			SeleniumFunction.click(listingPage.setShipPalletCheckRadio(1));
			SeleniumFunction.click(listingPage.setPreAssembledCheck(2));
			SeleniumFunction.click(listingPage.setUsaCheck(2));

			SeleniumFunction.scrollIntoView(driver, listingPage.setHsCode());
			SeleniumFunction.sendKeys(listingPage.setProductHeight(), height);
			SeleniumFunction.sendKeys(listingPage.setProductWidth(), width);
			SeleniumFunction.sendKeys(listingPage.setProductDepth(), depth);
			SeleniumFunction.sendKeys(listingPage.setProductWeight(), weight);

			SeleniumFunction.scrollIntoView(driver, listingPage.setProductHeight());
			SeleniumFunction.sendKeys(listingPage.setPackageHeight(), p_height);
			SeleniumFunction.sendKeys(listingPage.setPackageWidth(), p_width);
			SeleniumFunction.sendKeys(listingPage.setPackageDepth(), p_depth);
			SeleniumFunction.sendKeys(listingPage.setPackageWeight(), p_weight);
			SeleniumFunction.sendKeys(listingPage.setPackageQuantity(), p_quantity);
			SeleniumFunction.selectByVisibleText(listingPage.setPackageType(), p_type);
			SeleniumFunction.sendKeys(listingPage.setPackageSku(), p_sku);
			SeleniumFunction.click(listingPage.scrollToTop());
			SeleniumFunction.click(listingPage.addProductHeaders("Images"));
			SeleniumFunction.scrollIntoView(driver, listingPage.addProductHeaders("Images"));
			
			String fileName =  System.getProperty("user.dir") + "\\binaries\\logo\\logo.jpg";
			SeleniumFunction.uploadImage(listingPage.uploadImage(1), fileName);

			SeleniumFunction.click(listingPage.setPrimaryImage());
			SeleniumFunction.click(listingPage.scrollToTop());
			SeleniumFunction.click(listingPage.addProductHeaders("Resources"));
			SeleniumFunction.uploadImage(listingPage.uploadImage(2), System.getProperty("user.dir") + "\\binaries\\CGFiles\\sample.pdf");

			if(existingbrand.contains("Yes")){
				SeleniumFunction.click(listingPage.activeToggle());
			}
			
			WaitTool.sleep(5);
			SeleniumFunction.click(listingPage.saveBtn());
			String mess = SeleniumFunction.getText(listingPage.uploadingSuccessMessage());
			UseAssert.assertEquals(mess, "×\nThe product is successfully saved");
		}catch(Exception e){
			Log.info(e.getMessage());
		}
	}
}
