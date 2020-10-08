package com.qualitesoft.constantretail.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qualitesoft.constantretail.pageobjects.WebsitePage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class NavigateWebsite extends InitializeTest{
	
	@Test
	public void testNavigateWebsite(){
		
		WebDriver driver = getDriver();
		
		//driver.switchTo().window(CreateNewStore.websiteWindow);
		ScreenShot.takeScreenShot(driver, "WebSite");
		
		WebsitePage websitePage = new WebsitePage(driver);
		SeleniumFunction.click(websitePage.closePopup());
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		
		SeleniumFunction.click(websitePage.logInRegister());
		ScreenShot.takeScreenShot(driver, "LoginPage");
		driver.navigate().back();
		
		SeleniumFunction.click(websitePage.resetPassword());
		ScreenShot.takeScreenShot(driver, "ResetPasswordPage");
		driver.navigate().back();
		
		SeleniumFunction.click(websitePage.myShoppingCart());
		ScreenShot.takeScreenShot(driver, "MyShoppingCartPage");
		driver.navigate().back();
		
		WaitTool.sleep(1);
		SeleniumFunction.click(websitePage.emailAddressTextbox());
		WaitTool.sleep(1);
		SeleniumFunction.click(websitePage.myOrderHistory());
		ScreenShot.takeScreenShot(driver, "MyOrderHistoryPage");
		driver.navigate().back();
		
		SeleniumFunction.click(websitePage.aboutUs());
		ScreenShot.takeScreenShot(driver, "AboutUsPage");
		driver.navigate().back();
		
		SeleniumFunction.click(websitePage.contactUs());
		ScreenShot.takeScreenShot(driver, "ContactUsPage");
		driver.navigate().back();
		
		SeleniumFunction.click(websitePage.termsAndConditions());
		ScreenShot.takeScreenShot(driver, "TermsAndConditionsPage");
		driver.navigate().back();
	}

}
