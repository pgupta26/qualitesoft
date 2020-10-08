package com.qualitesoft.floatingcart.testscripts;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.ProfileManagementPage;


public class TestManageProfiles extends InitializeTest{
	
	public void handleOkPopup(){
		java.util.List<WebElement> elements=WaitTool.waitForElementsPresentAndDisplay(driver, By.xpath("//button[text()='OK']"), 60);
		if(elements.size()>=1){
			WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[text()='OK']"), 60).click();
		}
	}
	
	@Test
	public void testManageProfiles(){
		
		ProfileManagementPage profileManagementPage = new ProfileManagementPage(driver);
		this.handleOkPopup();
		profileManagementPage.manageProfileLink();
		SeleniumFunction.clickJS(driver, profileManagementPage.manageProfileLink());
		ScreenShot.takeScreenShot(driver, "ProfileManagementPage");
		//profileManagementPage.companyNameLink();	
		//SeleniumFunction.click(profileManagementPage.companyNameLink());
		//SeleniumFunction.click(profileManagementPage.profileListfilter());
	    SeleniumFunction.sendKeys(profileManagementPage.profileListfilter(), "Rodrigo.r@cymax.com");//Search M store user
	    //SeleniumFunction.click(profileManagementPage.paymentType());
	    WaitTool.sleep(3);
		//profileManagementPage.paymentTypeOptions("CreditCard");
	    SeleniumFunction.selectByVisibleText(profileManagementPage.paymentType(), "OnAccount");
		WaitTool.sleep(3);
	    ScreenShot.takeScreenShot(driver, "OnAccount Payment Selected");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1700)", "");
		WaitTool.sleep(5);
		//Modified on 1st Nov
		//SeleniumFunction.click(profileManagementPage.saveProfileButton());
		SeleniumFunction.clickJS(driver,profileManagementPage.saveProfileButtonSurePost());
		WaitTool.sleep(2);
		ScreenShot.takeScreenShot(driver, "Profile Updated Succesfully");
		WaitTool.sleep(5);
	}

}
