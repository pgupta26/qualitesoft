package com.qualitesoft.constantretail.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qualitesoft.constantretail.pageobjects.ProductList;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestAddProductStatic extends InitializeTest{

	
	@Test
	public void testAddProductStatic() {
		
		WebDriver driver = getDriver();
		
		
		ProductList productList = new ProductList(driver);
		WaitTool.sleep(5);
		SeleniumFunction.click(productList.addProductLink());
		SeleniumFunction.click(productList.productLists());
		//check shop name
		//WebDriverWait wait = new WebDriverWait(driver, 40);
		//wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//*[contains(@class,'navbar-brand-text')]")), "11July2017"));
		String Store=SeleniumFunction.getText(driver.findElement(By.xpath("//*[contains(@class,'navbar-brand-text')]")));
	    System.out.println("Store before:" + Store);
	    WaitTool.sleep(10);
		WaitTool.isElementPresentAndDisplay(driver,By.xpath(".//button[@type='button' and @data-bind='click: AddModal']"));
		WaitTool.sleep(10);
		SeleniumFunction.click(productList.addNewProductList());
		
		WaitTool.isElementPresentAndDisplay(driver, By.xpath("//label[@for='modal-brand' and contains(text,'')]"));
		WaitTool.waitForElementPresentAndDisplay(driver,By.xpath("//label[@for='modal-brand' and contains(text,'')]"), 20);
		
		
		String Title="StaticList";
		SeleniumFunction.sendKeys(productList.listDetailsTitle(), Title);
		SeleniumFunction.sendKeys(productList.listDetailsDecription(), "Selenium-Test-Description");
		SeleniumFunction.sendKeys(productList.listDetailsSEOMetdata(), "Test-Met-Data");
		
		SeleniumFunction.selectByvalue(productList.listType(), "4");
		
		SeleniumFunction.click(productList.listProductsTab());
		SeleniumFunction.sendKeys(productList.keywords(), keyword+Keys.TAB);
		WaitTool.sleep(10);
	    SeleniumFunction.click( productList.searchIcon());
		
		WaitTool.sleep(5);
		productList.checkAll();
		ScreenShot.takeScreenShot(driver, "Static-List"); 	
		SeleniumFunction.click(productList.checkAll());
		WaitTool.sleep(5);
		SeleniumFunction.click(productList.addkeywords());
		WaitTool.sleep(15);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,550)", "");
		SeleniumFunction.click(productList.saveButton() );
		
		WaitTool.sleep(5);
		SeleniumFunction.click(productList.editButton());
		
		String newTittle="test updated";
		SeleniumFunction.sendKeys(productList.listDetailsTitle(), newTittle);
		ScreenShot.takeScreenShot(driver, "Edit-Static-List"); 	
		SeleniumFunction.click(productList.saveButton());
		Log.info("New Tittle of Product List " + newTittle);
			
		WaitTool.sleep(10);
		SeleniumFunction.click(productList.deletePrductList());
		ScreenShot.takeScreenShot(driver, "delete-static-List");
		
	}
}
