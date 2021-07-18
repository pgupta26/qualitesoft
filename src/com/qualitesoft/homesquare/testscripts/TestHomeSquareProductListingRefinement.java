package com.qualitesoft.homesquare.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.homesquare.pageobjects.HomeSquareHomePage;

public class TestHomeSquareProductListingRefinement extends InitializeTest  {
	
	@Test
	public void testProductListingRefinement()
	{
		 WebDriver driver = getDriver();
		 
		 HomeSquareHomePage homePage = new HomeSquareHomePage(driver);
			
		//SeleniumFunction.click(homePage.HomeSqcloseButton());			 
		 //WebElement hsqHomeLink=homePage.hsqHomeLink();
		 //SeleniumFunction.click(hsqHomeLink);
		 WaitTool.sleep(5);

		 if(homePage.closePopupWrapperStatus() == true){
			 SeleniumFunction.clickJS(driver, homePage.closePopupWrapper());
			 WaitTool.sleep(2);
		 }	
		 
		 WebElement diningChairsLink = homePage.diningChairsLink();
		 SeleniumFunction.hoverAction(driver, diningChairsLink);
		 
		 WaitTool.sleep(5);
		 SeleniumFunction.click(homePage.HomeSqdiningChairs());
		 WaitTool.sleep(5);
		 
		 //WebElements used
		 WebElement sortDropdown=homePage.HomeSqsortDropdown();

		 SeleniumFunction.select(sortDropdown, "Lowest Price");
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("window.scrollBy(0,250)", "");
		 ScreenShot.takeScreenShot(driver, "Lowest Price");	

/*		 SeleniumFunction.hoverAction(driver, diningChairsLink);
		 WaitTool.sleep(4);
		 SeleniumFunction.click(homePage.HomeSqdiningChairs());
		 WaitTool.sleep(5);*/
		 WebElement sortDropdown1=homePage.HomeSqsortDropdown();
		 SeleniumFunction.select(sortDropdown1, "Highest Price");
		 WaitTool.sleep(5);
		 jse.executeScript("window.scrollBy(0,250)", "");
		 ScreenShot.takeScreenShot(driver, "Highest Price");	
		
		 //Filter options
		/* SeleniumFunction.click(homePage.homePrice());
         SeleniumFunction.click(homePage.HomeSqunder$250Filter());
         WaitTool.sleep(5);
         jse.executeScript("window.scrollBy(0,250)", "");
         ScreenShot.takeScreenShot(driver, "Under-250");
	     
		 WebElement diningChairsLink1 = homePage.diningChairsLink();
		 SeleniumFunction.hoverAction(driver, diningChairsLink1);
		 
		 WaitTool.sleep(5);
		 SeleniumFunction.click(homePage.HomeSqdiningChairs());	     
	     //Multiple Check
         SeleniumFunction.click(homePage.homeDesign());
	     SeleniumFunction.click(homePage.HomeSqarmChair());
         WaitTool.sleep(1);	
         SeleniumFunction.click(homePage.homeDesign());
	     SeleniumFunction.click(homePage.HomeSqbanquette());
        // WaitTool.sleep(1);
	     jse.executeScript("window.scrollBy(0,250)", "");
	     ScreenShot.takeScreenShot(driver, "Multiple Selection");*/
	     //wait///
		 
	     //List View and Grid View
		 WebElement listView=homePage.homelistView();
		 WebElement gridView=homePage.homegridView();
	     SeleniumFunction.click(listView);
		 WaitTool.sleep(1);
		 jse.executeScript("window.scrollBy(0,250)", "");
		 ScreenShot.takeScreenShot(driver, "listview");
		 SeleniumFunction.click(gridView);
		 WaitTool.sleep(1);
		 jse.executeScript("window.scrollBy(0,250)", "");
		 ScreenShot.takeScreenShot(driver, "gridview");
		 
		 
	}
	

}
