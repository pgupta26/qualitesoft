package com.qualitesoft.constantretail.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.constantretail.pageobjects.AvailableSubscriptionPage;
import com.qualitesoft.constantretail.pageobjects.NewStorePage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class CreateNewStore extends InitializeTest {
	
	public static String adminPortalWindow;
	public static String websiteWindow;

	@Test
	public void testCreateNewStore() {

		WebDriver driver = getDriver();

		AvailableSubscriptionPage availableSubscriptionPage = new AvailableSubscriptionPage(driver);
		WaitTool.sleep(20);
		WebElement createNewStoreLink = availableSubscriptionPage.createNewStoreLink();
		//SeleniumFunction.clickJS(driver, createNewStoreLink);

		NewStorePage newStorePage = new NewStorePage(driver);
		WebElement storeNameTextField = newStorePage.storeNameTextField();
		ScreenShot.takeScreenShot(driver, "NewStoreName");
		SeleniumFunction.sendKeys(storeNameTextField, JavaFunction.randomText("Store ",5));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		if (InitializeTest.browser.equalsIgnoreCase("chrome")) {
			newStorePage.uploadLogoChrome();
		} else {
			newStorePage.uploadLogoFirefox();
		}

		newStorePage.validationSummaryMsg();
		ScreenShot.takeScreenShot(driver, "NewStoreUploadLogo");
		
		jse.executeScript("window.scrollBy(0,550)", "");
		SeleniumFunction.click(newStorePage.nextButton());
	//	newStorePage.selectTemplate(templateused);
		ScreenShot.takeScreenShot(driver, "SelectThisTemplate");
		jse.executeScript("window.scrollBy(0,550)", "");
		SeleniumFunction.click(newStorePage.nextButton());
		newStorePage.validationSummaryMsg();
		newStorePage.selectExistingBrandsCheckbox();
		newStorePage.selectExistingBrands(existingbrand);

		ScreenShot.takeScreenShot(driver, "SelectExistingBrands");
		jse.executeScript("window.scrollBy(0,550)", "");
		SeleniumFunction.clickJS(driver, newStorePage.nextButton());
		newStorePage.validationSummaryMsg();
		ScreenShot.takeScreenShot(driver, "CreatePage");
		jse.executeScript("window.scrollBy(0,-450)", "");
		SeleniumFunction.click(newStorePage.createButton());
		WaitTool.isElementPresentAndDisplay(driver, By.xpath("//*[@id='result_row']/div[3]"));
		WebElement websiteLink = newStorePage.websiteLink();
		Log.info("URL created: " + SeleniumFunction.getText(websiteLink));
		ScreenShot.takeScreenShot(driver, "WebsiteLinkPage");
		/*
		adminPortalWindow = driver.getWindowHandle();
		
		SeleniumFunction.click(websiteLink);		
		SeleniumFunction.getCurrentWindow(driver);*/
		//websiteWindow = driver.getWindowHandle();
		
//		driver.switchTo().window(adminPortalWindow);
//		WaitTool.sleep(2);
		
		//logout
		
/*		TopMenuBarPage topMenuBarPage = new TopMenuBarPage(driver);
		SeleniumFunction.click(topMenuBarPage.profilePicture());
		ScreenShot.takeScreenShot(driver, "LogoutLink");
		SeleniumFunction.click(topMenuBarPage.logoutLink());
		ScreenShot.takeScreenShot(driver, "LoggedOut");*/

	}
}
