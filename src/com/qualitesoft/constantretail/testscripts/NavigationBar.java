package com.qualitesoft.constantretail.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qualitesoft.constantretail.pageobjects.NavigationBarPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class NavigationBar extends InitializeTest {

	public NavigationBar() {

	}

	@Test
	public void testNavigationBar() {

		WebDriver driver = getDriver();
		
		driver.switchTo().window(CreateNewStore.adminPortalWindow);

		NavigationBarPage navigationBarPage = new NavigationBarPage(driver);
		SeleniumFunction.click(navigationBarPage.dashboardLink());
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "DashboardPage");
		WaitTool.sleep(2);
		SeleniumFunction.clickJS(driver, navigationBarPage.ordersLink());
		SeleniumFunction.click(navigationBarPage.allOrdersLink());
		navigationBarPage.applyFilterButton();
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "AllOrdersPage");
		SeleniumFunction.click(navigationBarPage.productsLink());
		SeleniumFunction.click(navigationBarPage.allProductsLink());
		navigationBarPage.addProductButton();
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "AllProductsPage");
//		SeleniumFunction.click(navigationBarPage.collectionsLink());
//		WaitTool.sleep(2);
//		ScreenShot.takeScreenShot(driver, "CollectionsPage");
		SeleniumFunction.click(navigationBarPage.reportsLink());
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "ReportsPage");
		SeleniumFunction.click(navigationBarPage.locationsLink());
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "LocationsPage");
		SeleniumFunction.click(navigationBarPage.usersLink());
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "UsersPage");
		SeleniumFunction.click(navigationBarPage.generalLink());
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "GeneralPage");
		SeleniumFunction.click(navigationBarPage.shippingLink());
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "ShippingPage");
		SeleniumFunction.click(navigationBarPage.taxLink());
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "TaxPage");
		SeleniumFunction.click(navigationBarPage.pagesLink());
		ScreenShot.takeScreenShot(driver, "PagesPage");

		SeleniumFunction.clickJS(driver, navigationBarPage.socialLink());
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "SocialPage");

//		LogOut logOut = new LogOut();
//		logOut.testLogOut();
	}
}
