package com.qualitesoft.constantretail.testscripts;


import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import com.qualitesoft.constantretail.pageobjects.ProductPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestEditProduct extends InitializeTest{
	
	public static String adminPortalWindow;
	public static String websiteWindow;
	@Test
	public void testEditProduct(){
		
	  ProductPage productsPage = new ProductPage(driver);
	  SeleniumFunction.click(productsPage.editProductIcon());
	  WaitTool.sleep(10);
	  SeleniumFunction.clickJS(driver, productsPage.productExpandButton());
	  String Updateprod="Selenium - black";
	  SeleniumFunction.sendKeys(productsPage.titleTextbox(), "Selenium");
	  WaitTool.sleep(2);
	  JavascriptExecutor jse = (JavascriptExecutor) driver;
	  jse.executeScript("window.scrollBy(0,550)", "");

	  SeleniumFunction.clickJS(driver, productsPage.updateSaveButton1());
	  WaitTool.sleep(2);
	  jse.executeScript("window.scrollBy(0,550)", "");
	/*  jse.executeScript("window.scrollBy(0,-250)", "");
	  SeleniumFunction.clickJS(driver, productsPage.inventoryExpandButton());
	  SeleniumFunction.sendKeys(productsPage.SKUTextbox(), "54321");
	  SeleniumFunction.sendKeys(productsPage.quantityTextbox(), "1");
	  jse.executeScript("window.scrollBy(0,550)", "");*/
	  WaitTool.sleep(2);
	  productsPage.editProductIcon();
	  
	  adminPortalWindow =driver.getWindowHandle();
	  jse.executeScript("window.scrollBy(0,550)", "");
	  SeleniumFunction.click(productsPage.viewProduct1());
	  WaitTool.sleep(22);
	  SeleniumFunction.getCurrentWindow(driver);
	  websiteWindow =driver.getWindowHandle();
	  System.out.println("Title of original Page:" + driver.getTitle());
		
	  String Productname=productsPage.productname().getText();
	  System.out.println(Productname);
	 // UseAssert.assertEquals(Productname.trim(), Updateprod.trim());
	  ScreenShot.takeScreenShot(driver, "ProductView");
		
      driver.close();
	  driver.switchTo().window(adminPortalWindow);
	  
	}
	



}	