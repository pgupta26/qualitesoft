package com.qualitesoft.cymax.testscripts;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymax.pageobjects.AddToCartPage;
import com.qualitesoft.cymax.pageobjects.HomePage;
import com.qualitesoft.cymax.pageobjects.LoginPage;
import com.qualitesoft.cymax.pageobjects.MyAccountPage;
import com.qualitesoft.cymax.pageobjects.ProductsPage;

public class TestFooterLinks extends InitializeTest {

	@Test
	public void testFooterLinksHomePage() {
		HomePage homePage = new HomePage(driver);
		if (homePage.cymaxPopup() != null) {
			SeleniumFunction.click(homePage.cymaxPopup());
		}

		HashMap<String, String> pageTitles = new HashMap<String, String>();
		pageTitles.put("Log in / Register", "Login | Cymax Stores");
		pageTitles.put("Order Status", "Track Order Status | Cymax Stores");
		pageTitles.put("Business Program", "Business Program | Cymax Stores");
		pageTitles.put("Shipping", "Ordering Information | Cymax Stores");
		pageTitles.put("Returns", "Return Damage & Cancellation | Cymax Stores");
		pageTitles.put("Contact Us", "Contact | Cymax Stores");
		pageTitles.put("Accessibility Statement", "Accessibility Statement | Cymax Stores");
		pageTitles.put("Careers", "Careers — Cymax Group");

		SeleniumFunction.scrollDownUptoFooter(driver);
		for (Map.Entry<String, String> entry : pageTitles.entrySet()) {
			SeleniumFunction
					.click(WaitTool.waitForElementPresentAndDisplay(driver, By.partialLinkText(entry.getKey()), 30));
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.titleIs( entry.getValue()));
			String actualPageTitle = driver.getTitle();
			Log.info("Page Title: " + actualPageTitle);
			UseAssert.assertEquals(actualPageTitle, entry.getValue());
			driver.navigate().back();
		}
	}

	@Test
	public void testFooterLinksLoginPage() {
		HomePage homePage = new HomePage(driver);
		if (homePage.cymaxPopup() != null) {
			SeleniumFunction.click(homePage.cymaxPopup());
		}

		// Navigate to login Page
		SeleniumFunction.click(homePage.myAccountLink());
		LoginPage loginPage = new LoginPage(driver);
		SeleniumFunction.click(loginPage.createNewAccountLink());
		ScreenShot.takeFullScreenShot("LoginPage");

		HashMap<String, String> pageTitles = new HashMap<String, String>();
		pageTitles.put("Log in / Register", "Login | Cymax Stores");
		pageTitles.put("Order Status", "Track Order Status | Cymax Stores");
		pageTitles.put("Business Program", "Business Program | Cymax Stores");
		pageTitles.put("Shipping", "Ordering Information | Cymax Stores");
		pageTitles.put("Returns", "Return Damage & Cancellation | Cymax Stores");
		pageTitles.put("Contact Us", "Contact | Cymax Stores");
		pageTitles.put("Accessibility Statement", "Accessibility Statement | Cymax Stores");
		pageTitles.put("Careers", "Careers — Cymax Group");

		SeleniumFunction.scrollDownUptoFooter(driver);

		for (Map.Entry<String, String> entry : pageTitles.entrySet()) {
			SeleniumFunction
					.click(WaitTool.waitForElementPresentAndDisplay(driver, By.partialLinkText(entry.getKey()), 30));
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.titleIs( entry.getValue()));
			String actualPageTitle = driver.getTitle();
			Log.info("Page Title: " + actualPageTitle);
			UseAssert.assertEquals(actualPageTitle, entry.getValue());
			driver.navigate().back();
		}

	}

	@Test
	public void testFooterLinksCartPage() {
		HomePage homePage = new HomePage(driver);
		if (homePage.cymaxPopup() != null) {
			SeleniumFunction.click(homePage.cymaxPopup());
		}

		// Navigate to cart Page
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		SeleniumFunction.hoverAction(driver, myAccountPage.furniturelink());
		myAccountPage.bedLink();
		myAccountPage.murphyBeds();
		ScreenShot.takeScreenShot(driver, "Beds category page");
		ProductsPage productPage = new ProductsPage(driver);
		productPage.murphyBed();
		ScreenShot.takeScreenShot(driver, "Product detail page");
		AddToCartPage addToCartPage = new AddToCartPage(driver);
		SeleniumFunction.clickJS(driver, addToCartPage.addToCartButton());
		WaitTool.sleep(5);

		HashMap<String, String> pageTitles = new HashMap<String, String>();
		pageTitles.put("Log in / Register", "Login | Cymax Stores");
		pageTitles.put("Order Status", "Track Order Status | Cymax Stores");
		pageTitles.put("Business Program", "Business Program | Cymax Stores");
		pageTitles.put("Shipping", "Ordering Information | Cymax Stores");
		pageTitles.put("Returns", "Return Damage & Cancellation | Cymax Stores");
		pageTitles.put("Contact Us", "Contact | Cymax Stores");
		pageTitles.put("Accessibility Statement", "Accessibility Statement | Cymax Stores");
		pageTitles.put("Careers", "Careers — Cymax Group");

		SeleniumFunction.scrollDownUptoFooter(driver);
		for (Map.Entry<String, String> entry : pageTitles.entrySet()) {
			SeleniumFunction
					.click(WaitTool.waitForElementPresentAndDisplay(driver, By.partialLinkText(entry.getKey()), 30));
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.titleIs( entry.getValue()));
			String actualPageTitle = driver.getTitle();
			Log.info("Page Title: " + actualPageTitle);
			UseAssert.assertEquals(actualPageTitle, entry.getValue());
			driver.navigate().back();
		}
	}

	/*@DataProvider(name = "SearchProvider")
	public Object[][] getFooterLinksDataprovider() {
		return new Object[][] {

				{ "Log in / Register", "Login | Cymax Stores" },
				{ "Order Status", "Track Order Status | Cymax Stores" },
				{ "Business Program", "Business Program | Cymax Stores" },
				{ "Shipping", "Ordering Information | Cymax Stores" },
				{ "Returns", "Return Damage & Cancellation | Cymax Stores" },
				{ "Contact Us", "Contact | Cymax Stores" },
				{ "Accessibility Statement", "Accessibility Statement | Cymax Stores" },
				{ "Careers", "Careers — Cymax Group" }, };
	}*/

}
