package com.qualitesoft.MBShopify.testscripts;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qualitesoft.MBShopify.pageobjects.InstallMuzeBoard;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class TestInstallMuzeBoard extends InitializeTest{
	@Test
	public void testInstallMuzeBoard(){
		WebDriver driver = getDriver();
		InstallMuzeBoard install = new InstallMuzeBoard(driver);
		SeleniumFunction.click(install.Apps());
		ScreenShot.takeScreenShot(driver, "Apps");
		WaitTool.sleep(4);
		SeleniumFunction.click(install.AppName());

		ScreenShot.takeScreenShot(driver, "MuzeBoard Staging");
		WaitTool.sleep(4);
		SeleniumFunction.click(install.moreaction());
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//jse.executeScript("window.scrollBy(0,250)", "");
		SeleniumFunction.click(install.createappstore());
		ScreenShot.takeScreenShot(driver, "Create App Store listing");
		jse.executeScript("window.scrollBy(0,150)", "");
		SeleniumFunction.click(install.editapp());
		ScreenShot.takeScreenShot(driver, "Edit App submission form");
		jse.executeScript("window.scrollBy(0,150)", "");
		WaitTool.sleep(4);
		//SeleniumFunction.click(install.saveButton());
		//WaitTool.sleep(4);
		//ScreenShot.takeScreenShot(driver, "Saved");
		WaitTool.sleep(4);
		jse.executeScript("window.scrollBy(0,150)", "");
		SeleniumFunction.click(install.ViewApplisting());
		WaitTool.sleep(8);
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1));//move to second tab
		ScreenShot.takeScreenShot(driver, "Get App");
		
		SeleniumFunction.click(install.Get());
		ScreenShot.takeScreenShot(driver, "View App listing");
		SeleniumFunction.click(install.LogIn());
		ScreenShot.takeScreenShot(driver, "Login");
		WaitTool.sleep(5);
		//change url
		String url = driver.getCurrentUrl();
		String url_new = url.replaceAll("https", "http");
		driver.navigate().to(url_new);
		WaitTool.sleep(5);
		jse.executeScript("window.scrollBy(0,250)", "");
		SeleniumFunction.click(install.Installunlisted());
		ScreenShot.takeScreenShot(driver, "Intall unlisting apps");
		WaitTool.sleep(5);
	
	
	}
}
