package com.qualitesoft.cymax.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymax.pageobjects.HomePage;
import com.qualitesoft.cymax.pageobjects.MyAccountPage;

public class TestProductListingRefinement extends InitializeTest  {
	
	@Test
	public void testProductListingRefinement()
	{
		 WebDriver driver = getDriver();
		 
		 HomePage homePage = new HomePage(driver);
		 //SeleniumFunction.click(homePage.noThanks()); //to remove popup
		// WebElement cymaxHomeLink=homePage.cymaxHomeLink();
		 /////SeleniumFunction.click(cymaxHomeLink);
		 WaitTool.sleep(5);
		 
		 WebElement furnitureLink = homePage.furniturelink();
		 SeleniumFunction.hoverAction(driver,furnitureLink);
		 WaitTool.sleep(5);
//		 WebElement diningChairsLink = homePage.diningChairsLink();
//		 SeleniumFunction.click(diningChairsLink);
//		 WaitTool.sleep(1);
		 SeleniumFunction.click(homePage.diningChairs());
		 
		 //WebElements used
		 WebElement sortDropdown=homePage.sortDropdown();

		SeleniumFunction.select(sortDropdown, "Lowest Price");

		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("window.scrollBy(0,150)", "");
		 WaitTool.sleep(8);
		 ScreenShot.takeScreenShot(driver, "lowest Price");	
		 
		 WebElement sortDropdown1=homePage.sortDropdown();
		 SeleniumFunction.select(sortDropdown1, "Highest Price");
		 jse.executeScript("window.scrollBy(0,150)", "");
	   // SeleniumFunction.click(sortDropdown);
	    //SeleniumFunction.click(homePage.highestPrice());

		 //jse.executeScript("window.scrollBy(0,250)", "");
		 WaitTool.sleep(8);
		 ScreenShot.takeScreenShot(driver, "Highest Price");	
		 
		 //Filter options
		 SeleniumFunction.click(homePage.Price());
		 //SeleniumFunction.click(homePage.HomeSqunder$250Filter());
         SeleniumFunction.click(homePage.under$250Filter());
         WaitTool.sleep(1);
         jse.executeScript("window.scrollBy(0,400)", "");
         ScreenShot.takeScreenShot(driver, "Under-250");
	     
	     
	     //Multiple Check
         SeleniumFunction.click(homePage.Design());
         //SeleniumFunction.click(homePage.HomeSqarmChair());
	     SeleniumFunction.click(homePage.armChair());
         WaitTool.sleep(5);	
         SeleniumFunction.click(homePage.Design());
	     SeleniumFunction.click(homePage.banquette());
        // SeleniumFunction.click(homePage.HomeSqbanquette());
         WaitTool.sleep(5);
         jse.executeScript("window.scrollBy(0,250)", "");
	     ScreenShot.takeScreenShot(driver, "Multiple");
	     
		 
	     //List View and Grid View
	     jse.executeScript("window.scrollBy(250,0)", "");
		 WebElement listView=homePage.listView();
		 WebElement gridView=homePage.gridView();
	     SeleniumFunction.click(listView);
		 WaitTool.sleep(5);
		 ScreenShot.takeScreenShot(driver, "listview");
		 SeleniumFunction.click(gridView);
		 WaitTool.sleep(5);
		 ScreenShot.takeScreenShot(driver, "gridview");
		 
		 
	}
	

}
