package com.qualitesoft.constantretail.testscripts;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import com.qualitesoft.constantretail.pageobjects.ShippingPage;

import com.qualitesoft.core.InitializeTest;

import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;




public class TestShipping extends InitializeTest   {

	@Test
	public void testShipping(){
		
        WebDriver driver = getDriver();
     
		ShippingPage shippingPage = new ShippingPage(driver);
		
		((JavascriptExecutor) driver).executeScript(
	            "scroll(" + shippingPage.shippingLink().getLocation().getX() + "," + shippingPage.shippingLink().getLocation().getY() + ")");
		
		WaitTool.sleep(10);
		SeleniumFunction.click(shippingPage.shippingLink());
		WaitTool.waitForElementsPresentAndDisplay(driver, By.xpath(".//input[@value='price']"), 20);
		WaitTool.sleep(10);
		SeleniumFunction.click(shippingPage.setByPrice());
		WaitTool.sleep(30);
        SeleniumFunction.click(shippingPage.addShippingRates());
		
		WebElement toField=shippingPage.priceToField();
		WebElement fromField=shippingPage.priceFromField();
		WebElement priceCost=shippingPage.priceShippingCost();
		WebElement rateButton=shippingPage.addRateButton();
		
		//set by price
		
        SeleniumFunction.sendKeys(toField, "500.00"+ Keys.TAB);
        SeleniumFunction.sendKeys(priceCost, "19.25"+ Keys.TAB);
        WaitTool.sleep(10);
        SeleniumFunction.clickJS(driver, rateButton);
        ScreenShot.takeScreenShot(driver, "single-Rate");
        
        SeleniumFunction.sendKeys(fromField, "502.00" +Keys.TAB);
        SeleniumFunction.sendKeys(toField, "5000.00");
        SeleniumFunction.sendKeys(priceCost,"39.99"+Keys.TAB); 
        WaitTool.sleep(5);
        SeleniumFunction.clickJS(driver, rateButton);
        WaitTool.sleep(5);
        ScreenShot.takeScreenShot(driver, "multiple-Rate");
        
        //set by weight
       SeleniumFunction.click(shippingPage.setByWeight());
        SeleniumFunction.click(shippingPage.addRateWeight());
        
        SeleniumFunction.sendKeys(shippingPage.weighTo(), "60"+ Keys.TAB);
        SeleniumFunction.sendKeys(shippingPage.shippingRateWeight(), "9.99" +Keys.TAB);
        WaitTool.sleep(5);
        SeleniumFunction.clickJS(driver, shippingPage.saveWeight());
        ScreenShot.takeScreenShot(driver, "single-Rate-Weight");
        
        SeleniumFunction.sendKeys(shippingPage.weightFrom(), "61"+ Keys.TAB);
        SeleniumFunction.sendKeys(shippingPage.weighTo(), "2000" + Keys.TAB);
        SeleniumFunction.sendKeys(shippingPage.shippingRateWeight(),"29.99" + Keys.TAB); 
        
        SeleniumFunction.clickJS(driver, shippingPage.saveWeight());
        WaitTool.sleep(5);
        ScreenShot.takeScreenShot(driver, "multiple-Rate-Weight");
        
       //Set by Distance
        SeleniumFunction.click(shippingPage.setByDistance());
        SeleniumFunction.click(shippingPage.addRateLocation());
        
        SeleniumFunction.sendKeys(shippingPage.locationFrom(), "100"+ Keys.TAB);
        SeleniumFunction.sendKeys(shippingPage.locationShipppingRate(), "9.99" +Keys.TAB);
        WaitTool.sleep(5);
        SeleniumFunction.clickJS(driver,shippingPage.saveRatesLocation());
        ScreenShot.takeScreenShot(driver, "single-Rate-Location");
        
        SeleniumFunction.sendKeys(shippingPage.locationTo(), "101"+ Keys.TAB);
        SeleniumFunction.sendKeys(shippingPage.locationFrom(), "20000" + Keys.TAB);
        SeleniumFunction.sendKeys(shippingPage.locationShipppingRate(),"59.99" + Keys.TAB); 
        
        SeleniumFunction.clickJS(driver, shippingPage.saveRatesLocation());
        WaitTool.sleep(5);
        ScreenShot.takeScreenShot(driver, "multiple-Rate-Location");    
        
        //Set By ZipCode
        SeleniumFunction.click(shippingPage.setByZip());
        SeleniumFunction.click(shippingPage.addRateZip());
        
        SeleniumFunction.sendKeys(shippingPage.shippingRate(), "9.99"+ Keys.TAB);
        SeleniumFunction.sendKeys(shippingPage.shippingZone(), "Zone1" +Keys.TAB);
        shippingPage.uploadzipChrome();
        WaitTool.sleep(5);
        SeleniumFunction.clickJS(driver,shippingPage.saveZip());
        ScreenShot.takeScreenShot(driver, "single-Rate-Location");
        
	}
	
}
