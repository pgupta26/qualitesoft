package com.qualitesoft.constantretail.testscripts;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.qualitesoft.constantretail.pageobjects.TaxPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestTax extends InitializeTest{

	@Test
	public void testTax() {
		
	WebDriver driver = getDriver();
	JavascriptExecutor jse = (JavascriptExecutor) driver;	
	TaxPage taxPage = new TaxPage(driver);
    ((JavascriptExecutor) driver).executeScript(
		        "scroll(" + taxPage.taxLink().getLocation().getX() + "," + taxPage.taxLink().getLocation().getY() + ")");
		    
	SeleniumFunction.click(taxPage.taxLink());
	WaitTool.sleep(10);
	jse.executeScript("window.scrollBy(0,150)", "");
	SeleniumFunction.click(taxPage.allTaxes());
	jse.executeScript("window.scrollBy(0,150)", "");
	SeleniumFunction.click(taxPage.saveAllTax());
	ScreenShot.takeScreenShot(driver, "AllTax");
	jse.executeScript("window.scrollBy(0,150)", "");
	SeleniumFunction.click(taxPage.setUpTax());
	WaitTool.sleep(5);
	SeleniumFunction.click(taxPage.checkboxAlaska());
	SeleniumFunction.sendKeys(taxPage.albamaFedTax(),"5");
	SeleniumFunction.sendKeys(taxPage.albamaStateTax(), "5");
	jse.executeScript("window.scrollBy(0,-850)", "");
	SeleniumFunction.click(taxPage.saveTax());
	ScreenShot.takeScreenShot(driver, "SetUpTax");
		
		
	}
	}