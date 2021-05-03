package com.qualitesoft.freightclub.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.freightclub.pageobjects.ProfileManagementPage;
import com.qualitesoft.freightclub.pageobjects.CarrierMarkups;
import com.qualitesoft.freightclub.pageobjects.ManageCarrierPage;

public class TestManageProfile extends InitializeTest {

	@Test
	public void handleOkPopup(){
		if(WaitTool.isElementPresentAndDisplay(driver, By.xpath("//button[text()='OK']"))) {
			SeleniumFunction.click(driver.findElement(By.xpath("//button[text()='OK']")));
			WaitTool.sleep(2);
		}
	}
	@Test
	public void searchProfile(){
			ProfileManagementPage profileManagementPage = new ProfileManagementPage(driver);
			profileManagementPage.manageProfileLink();
			WaitTool.sleep(3);
			this.handleOkPopup();
			WaitTool.sleep(1);
			SeleniumFunction.scrollDownByPixel(driver, "100");
			SeleniumFunction.clickJS(driver, profileManagementPage.manageProfileLink());
			SeleniumFunction.sendKeys(profileManagementPage.profileListfilter(), "15678");//15678
			WaitTool.sleep(10);
		}

	@Test
	public void profileSettingsSelectGroundAndSurepost(){
			ProfileManagementPage profile=new ProfileManagementPage(driver);
			CarrierMarkups markups=new CarrierMarkups(driver);

			SeleniumFunction.click(profile.upsSetting());			
			if(!profile.selectGround().isSelected()) {
				SeleniumFunction.click(profile.selectGround());
			}
			
			if(!profile.selectUPSSurepost().isSelected()) {
				SeleniumFunction.click(profile.selectUPSSurepost());	
			}
			
			SeleniumFunction.scrollDownByPixel(driver, "1000");
			/*SeleniumFunction.clickJS(driver, profile.saveProfileBtn());
			SeleniumFunction.scrollUPUptoHeader(driver);
			Assert.assertTrue(markups.clickCarrierMarkups().isDisplayed());*/
	}

	@Test
	public void selectUPSCarrier(){
			ManageCarrierPage carriers=new ManageCarrierPage(driver);
			WaitTool.sleep(10);
			SeleniumFunction.clickJS(driver, carriers.clkManageCarrier());
			WebElement element= carriers.UPSToggleBtn();
			SeleniumFunction.scrollIntoView(driver, element);
			if(SeleniumFunction.getText(carriers.UPSToggleBtn()).equals("OFF")){
				SeleniumFunction.clickJS(driver,WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//td[contains(text(),'UPS Freight')]//preceding::td[2]//label//div[@class='v-switch-button']"), 60));
				Log.info(SeleniumFunction.getText(carriers.UPSToggleBtn()));
			}
			else
			{
				Log.info("UPS checkbox already Active");
			}
	}
}

