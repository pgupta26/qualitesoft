package com.qualitesoft.cymax.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymax.pageobjects.HomePage;

public class TestProductListingRefinement extends InitializeTest {

	@Test
	public void testProductListingRefinement() {
		HomePage homePage = new HomePage(driver);
		WaitTool.sleep(5);

		WebElement furnitureLink = homePage.furniturelink();
		SeleniumFunction.hoverAction(driver, furnitureLink);
		WaitTool.sleep(5);
		SeleniumFunction.click(homePage.diningChairs());

		// WebElements used
		WebElement sortDropdown = homePage.sortDropdown();
		SeleniumFunction.select(sortDropdown, "Lowest Price");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,150)", "");
		WaitTool.sleep(10);
		ScreenShot.takeScreenShot(driver, "lowest Price");

		WebElement sortDropdown1 = homePage.sortDropdown();
		SeleniumFunction.select(sortDropdown1, "Highest Price");
		jse.executeScript("window.scrollBy(0,150)", "");
		WaitTool.sleep(10);
		ScreenShot.takeScreenShot(driver, "Highest Price");

		// Filter options
		SeleniumFunction.click(homePage.Price());
		SeleniumFunction.click(homePage.under$250Filter());
		WaitTool.sleep(10);
		jse.executeScript("window.scrollBy(0,400)", "");
		ScreenShot.takeScreenShot(driver, "Under-250");

		// Multiple Check
		SeleniumFunction.click(homePage.Design());
		SeleniumFunction.click(homePage.armChair());
		WaitTool.sleep(10);
		SeleniumFunction.click(homePage.Design());
		SeleniumFunction.click(homePage.banquette());
		WaitTool.sleep(10);
		jse.executeScript("window.scrollBy(0,250)", "");
		ScreenShot.takeScreenShot(driver, "Multiple");

		// List View and Grid View
		jse.executeScript("window.scrollBy(250,0)", "");
		WebElement listView = homePage.listView();
		WebElement gridView = homePage.gridView();
		SeleniumFunction.click(listView);
		WaitTool.sleep(10);
		ScreenShot.takeScreenShot(driver, "listview");
		SeleniumFunction.click(gridView);
		WaitTool.sleep(10);
		ScreenShot.takeScreenShot(driver, "gridview");

	}
}
