package com.qualitesoft.constantretail.testscripts;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.qualitesoft.constantretail.pageobjects.LocationPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestLocation extends InitializeTest{

	
	@Test
	public void testLocation() {
		
	WebDriver driver = getDriver();
	JavascriptExecutor jse = (JavascriptExecutor) driver;
		
	LocationPage locationPage = new LocationPage(driver);
	SeleniumFunction.click(locationPage.locationLink());
	WaitTool.sleep(10);
	
	SeleniumFunction.click(locationPage.addNewLocation());
	WaitTool.sleep(5);
	String storeName="SelStore";
	String storeupdated="upStore";
	SeleniumFunction.sendKeys(locationPage.locationName(), storeName);
	SeleniumFunction.sendKeys(locationPage.streetName(),"50 elm court");
	SeleniumFunction.click(locationPage.pickUp());
	SeleniumFunction.click(locationPage.shipping());
	SeleniumFunction.sendKeys(locationPage.cityName(), "Los Angeles");
	SeleniumFunction.sendKeys(locationPage.zipCode(), "90001");
	SeleniumFunction.selectByVisibleText(locationPage.countryName(), "United States");
	WaitTool.sleep(5);
	SeleniumFunction.selectByVisibleText(locationPage.stateName(), "California");
	ScreenShot.takeScreenShot(driver, "Locations-filled"); 	
	jse.executeScript("window.scrollBy(0,550)", "");
	SeleniumFunction.click(locationPage.saveButton());
	
	WaitTool.sleep(10);
	jse.executeScript("window.scrollBy(0,550)", "");
	SeleniumFunction.sendKeys(locationPage.searchValue(), storeName);
	jse.executeScript("window.scrollBy(0,150)", "");
	SeleniumFunction.click(locationPage.applyFilter());
	WaitTool.sleep(5);
	jse.executeScript("window.scrollBy(0,150)", "");
	SeleniumFunction.click(locationPage.editLocation());
	WaitTool.sleep(10);
	SeleniumFunction.sendKeys(locationPage.locationName(), storeupdated);
	jse.executeScript("window.scrollBy(0,150)", "");
	SeleniumFunction.click(locationPage.saveButton());
	WaitTool.sleep(10);
	SeleniumFunction.sendKeys(locationPage.searchValue(), storeupdated);
	jse.executeScript("window.scrollBy(0,150)", "");
	SeleniumFunction.click(locationPage.applyFilter());
//	locationPage.ValidateLocationName(storeupdated);
	WaitTool.sleep(10);
	ScreenShot.takeScreenShot(driver, "UpdatedStore");
	
	
	}
	
}	
		
		