package com.qualitesoft.constantretail.testscripts;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.testng.annotations.Test;

import com.qualitesoft.constantretail.pageobjects.NavigationBarPage;
import com.qualitesoft.constantretail.pageobjects.ProductPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;

public class TestAddNewProduct extends InitializeTest{
	
	public static String adminPortalWindow;
	public static String websiteWindow;
	@Test
	public void testAddNewProduct(){
		
		NavigationBarPage navigationBarPage = new NavigationBarPage(driver);
		SeleniumFunction.clickJS(driver, navigationBarPage.productsLink());
		SeleniumFunction.clickJS(driver, navigationBarPage.allProductsLink());
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "AllProductsPage");
		ProductPage productsPage = new ProductPage(driver);
		WaitTool.sleep(5);
	//SeleniumFunction.click(productsPage.expand());
		SeleniumFunction.click(productsPage.BrandId("1453"));
		SeleniumFunction.clickJS(driver, productsPage.categoryListDropdown());
		SeleniumFunction.click(productsPage.FurnitureChairCategory());
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,550)", "");
		SeleniumFunction.click(productsPage.applyFilter());
		WaitTool.sleep(5);
		// Click on sellable for 5 items
		jse.executeScript("window.scrollBy(0,350)", "");
		SeleniumFunction.click(productsPage.IssellableCheckbox("1"));
		SeleniumFunction.click(productsPage.IssellableCheckbox("2"));
		SeleniumFunction.click(productsPage.IssellableCheckbox("3"));
		SeleniumFunction.click(productsPage.IssellableCheckbox("4"));
		SeleniumFunction.click(productsPage.IssellableCheckbox("5"));
		WaitTool.sleep(5);
		jse.executeScript("window.scrollBy(0,550)", "");
		SeleniumFunction.clickJS(driver, productsPage.addProductButton());		
		SeleniumFunction.clickJS(driver, productsPage.productExpandButton());
		SeleniumFunction.select(productsPage.brandDropdown(), brandname);
		WaitTool.sleep(2);
		SeleniumFunction.click(productsPage.expand());
		WaitTool.sleep(2);
		SeleniumFunction.clickJS(driver, productsPage.categoryListDropdown());
		WaitTool.sleep(5);

		
	    SeleniumFunction.click(productsPage.chooseCategory());
	    WaitTool.sleep(5);
		SeleniumFunction.sendKeys(productsPage.chooseCategorySearch(), "cleaner");
		
		WaitTool.sleep(5);
	    SeleniumFunction.click(productsPage.chooseCategoryResults());
		//String options=SeleniumFunction.getText(productsPage.chooseCategoryResults());
		//System.out.println(options);

	//	SeleniumFunction.select(productsPage.categoryListDropdown(), "Office Supplies / Cleaning & Breakroom / Soaps / Cleaners");
		SeleniumFunction.select(productsPage.countryOfManufactureDropdown(), "India");
		String prodName="Selenium Product - black";
		SeleniumFunction.sendKeys(productsPage.titleTextbox(), "Selenium Product");
		ScreenShot.takeScreenShot(driver, "ProductDetailsFilled");
		
		productsPage.uploadLogoChrome();
		
		WaitTool.sleep(4);
		ScreenShot.takeScreenShot(driver, "ImageUploaded");
		
		//add variant
		        jse.executeScript("window.scrollBy(0,350)", "");
				SeleniumFunction.clickJS(driver, productsPage.addVariantButton());
				//productsPage.newOptionsGroupButton();
				ScreenShot.takeScreenShot(driver, "AddVariant");
				SeleniumFunction.clickJS(driver, productsPage.newOptionsGroupButton());
				WaitTool.sleep(3);
				
				SeleniumFunction.sendKeys(productsPage.optionGroupNameTexbox(), "color");
				WaitTool.sleep(5);
				SeleniumFunction.sendKeys(productsPage.optionValuesTexbox(), "red");
				SeleniumFunction.click(productsPage.newOptionValueLink());
				WaitTool.sleep(5);
				SeleniumFunction.sendKeys(productsPage.newOptionValueLink2(), "black");
				WaitTool.sleep(5);
				ScreenShot.takeScreenShot(driver, "Added Variant filled info");
				SeleniumFunction.click(productsPage.saveVariantsButton());
				WaitTool.sleep(5);
				ScreenShot.takeScreenShot(driver, "list of added variant");
				jse.executeScript("window.scrollBy(0,550)", "");			
				SeleniumFunction.clickJS(driver, productsPage.saveButton1());
				
		//SeleniumFunction.clickJS(driver, productsPage.inventoryExpandButton());
		jse.executeScript("window.scrollBy(0,-300)", "");	
		//ScreenShot.takeScreenShot(driver, "SaveVariant");
		SeleniumFunction.sendKeys(productsPage.vendorpriceTextbox(), "10");
		SeleniumFunction.sendKeys(productsPage.wholesaleTextbox(), "10");
		SeleniumFunction.sendKeys(productsPage.SKUTextbox(), "123");
		SeleniumFunction.sendKeys(productsPage.quantityTextbox(), "1");
		jse.executeScript("window.scrollBy(0,550)", "");
		ScreenShot.takeScreenShot(driver, "adding inventory");
		SeleniumFunction.clickJS(driver, productsPage.saveButton1());
		WaitTool.sleep(3);
		jse.executeScript("window.scrollBy(0,-400)", "");	
		//ScreenShot.takeScreenShot(driver, "SaveVariant");
		SeleniumFunction.sendKeys(productsPage.vendorpriceTextbox(), "20");
		SeleniumFunction.sendKeys(productsPage.wholesaleTextbox(), "20");
		SeleniumFunction.sendKeys(productsPage.SKUTextbox(), "12345");
		SeleniumFunction.sendKeys(productsPage.quantityTextbox(), "1");
		jse.executeScript("window.scrollBy(0,650)", "");
		SeleniumFunction.clickJS(driver, productsPage.saveButton1());
		WaitTool.sleep(6);
		
		//productsPage.editProductIcon();
		ScreenShot.takeScreenShot(driver, "ProductSaved");
		jse.executeScript("window.scrollBy(0,550)", "");
	/*	SeleniumFunction.clickJS(driver, productsPage.editProductIcon());
		SeleniumFunction.clickJS(driver, productsPage.addVariantButton());
		productsPage.newOptionsGroupButton();
		ScreenShot.takeScreenShot(driver, "AddVariant");

		SeleniumFunction.clickJS(driver, productsPage.newOptionsGroupButton());
		WaitTool.sleep(10);
		
		SeleniumFunction.sendKeysJS(driver,productsPage.optionGroupNameTexbox(), "Color");
		WaitTool.sleep(5);
		SeleniumFunction.sendKeysJS(driver,productsPage.optionValuesTexbox(), "Red");
		SeleniumFunction.clickJS(driver, productsPage.newOptionValueLink());
		WaitTool.sleep(5);
		SeleniumFunction.sendKeysJS(driver, productsPage.newOptionValueLink2(), "Black");
		WaitTool.sleep(5);
		SeleniumFunction.clickJS(driver, productsPage.saveVariantsButton());
		
		productsPage.inventoryExpandButton();
		ScreenShot.takeScreenShot(driver, "SaveVariant");
		SeleniumFunction.clickJS(driver, productsPage.inventoryExpandButton());
		SeleniumFunction.sendKeys(productsPage.SKUTextbox(), "54321");
		SeleniumFunction.clickJS(driver, productsPage.updateSaveButton());
		ScreenShot.takeScreenShot(driver, "NewVariantSaved");*/

		
		
		//SeleniumFunction.click(productsPage.exprortProduct());
		adminPortalWindow =driver.getWindowHandle();		
		//SeleniumFunction.click(productsPage.isSellable());
		WaitTool.sleep(5);
		jse.executeScript("window.scrollBy(0,550)", "");
		SeleniumFunction.click(productsPage.viewProduct1());
		WaitTool.sleep(38);
		
	    SeleniumFunction.getCurrentWindow(driver);
	    websiteWindow =driver.getWindowHandle();
	    System.out.println("Title of original Page:" + driver.getTitle());
	    SeleniumFunction.click(driver.findElement(By.xpath("//*[@id='form-newsletter-modal']/div/div/div[1]/button")));
		String Productname=productsPage.productname().getText();
		System.out.println(Productname);
		UseAssert.assertEquals(Productname.trim(), prodName.trim());
		ScreenShot.takeScreenShot(driver, "ProductView");
		
		driver.close();
		driver.switchTo().window(adminPortalWindow);
		
	}
	
}