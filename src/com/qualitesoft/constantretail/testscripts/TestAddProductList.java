package com.qualitesoft.constantretail.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import com.qualitesoft.constantretail.pageobjects.ProductList;
import com.qualitesoft.core.InitializeTest;

import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestAddProductList extends InitializeTest{

	public static String listTypeValue;
	@Test
	public void testAddProductList() {
		
		WebDriver driver = getDriver();
		//check shop name
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//*[contains(@class,'navbar-brand-text')]")), "11July2017"));

		ProductList productList = new ProductList(driver);
		WaitTool.sleep(10);
		SeleniumFunction.click(productList.addProductLink());
		WaitTool.sleep(10);
		SeleniumFunction.click(productList.addProductLink());
		WaitTool.sleep(10);
		SeleniumFunction.click(productList.productLists());
		//WaitTool.isElementPresentAndDisplay(driver,By.xpath(".//button[@type='button' and @data-bind='click: AddModal']"));
		WaitTool.sleep(20);
		SeleniumFunction.click(productList.addNewProductList());
		
		WaitTool.isElementPresentAndDisplay(driver, By.xpath("//label[@for='modal-brand' and contains(text,'')]"));
		WaitTool.waitForElementPresentAndDisplay(driver,By.xpath("//*[@href='/settings/payment']"), 30);
		
		String Title="selenium";
		SeleniumFunction.sendKeys(productList.listDetailsTitle(), Title);
		SeleniumFunction.sendKeys(productList.listDetailsDecription(), "Selenium-Test-Description");
		SeleniumFunction.sendKeys(productList.listDetailsSEOMetdata(), "Test-Met-Data");
		
		SeleniumFunction.selectByvalue(productList.listType(), "2");
		
		SeleniumFunction.click(productList.listProductsTab());
		SeleniumFunction.sendKeys(productList.keywords(),keyword+Keys.TAB );
	   	WaitTool.sleep(4);
      // SeleniumFunction.clickJS(driver, productList.searchIcon());
		ScreenShot.takeScreenShot(driver, "Dynamic-List"); 	
		//SeleniumFunction.click(productList.checkAll());
		SeleniumFunction.click(productList.saveButton() );
		
		WaitTool.sleep(10);
		SeleniumFunction.click(productList.editButton());
		ScreenShot.takeScreenShot(driver, "Edit-Dynamic-List");
		String newTittle="test updated";
		SeleniumFunction.sendKeys(productList.listDetailsTitle(), newTittle);
		
		SeleniumFunction.click(productList.saveButton());
		Log.info("New Tittle of Product List " + newTittle);
			
		WaitTool.sleep(10);
		SeleniumFunction.click(productList.deletePrductList());
		ScreenShot.takeScreenShot(driver, "delete-dyn-List");
		
	}
}
