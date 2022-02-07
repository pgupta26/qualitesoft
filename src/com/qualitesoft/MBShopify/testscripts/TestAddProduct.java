package com.qualitesoft.MBShopify.testscripts;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qualitesoft.MBShopify.pageobjects.AddProduct;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestAddProduct extends InitializeTest{
	@Test
	public void testAddProduct(){
		WebDriver driver = getDriver();
		AddProduct add = new AddProduct(driver);
		SeleniumFunction.click(add.LogInButton());
		WaitTool.sleep(8);
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1));//move to second tab
		
		ScreenShot.takeScreenShot(driver, "Admin Products");
		SeleniumFunction.click(add.products());
		ScreenShot.takeScreenShot(driver, "Products");
		SeleniumFunction.click(add.Addproduct());
		ScreenShot.takeScreenShot(driver, "Add Products");
		SeleniumFunction.sendKeys(add.Producttitle(),"product1");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)", "");
		//SeleniumFunction.sendKeys(add.Productdesc(),"product1");
		add.uploadLogoChrome();
		WaitTool.sleep(3);
		jse.executeScript("window.scrollBy(0,550)", "");
		SeleniumFunction.click(add.AddvariantButton());
		SeleniumFunction.sendKeys(add.variantvalue(),"test");	
		jse.executeScript("window.scrollBy(0,950)", "");
		WaitTool.sleep(3);
		SeleniumFunction.click(add.saveButton());
		jse.executeScript("window.scrollBy(0,950)", "");
		SeleniumFunction.click(add.saveButton());
		WaitTool.sleep(10);
		ScreenShot.takeScreenShot(driver, "Product saved");	
		WaitTool.sleep(3);
		SeleniumFunction.click(add.products());
		ScreenShot.takeScreenShot(driver, "Product Added");
		driver.close();
		driver.switchTo().window(newTab.get(0));
		WaitTool.sleep(2);

		
	}
}
