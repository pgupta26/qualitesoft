package com.qualitesoft.homesquare.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.homesquare.pageobjects.MuzeboardOverviewPage;
import com.qualitesoft.homesquare.pageobjects.ProfileInfoMuzeboardPage;

public class TestEditProfileDetails extends InitializeTest{
	
	@Test
	public void testEditProfileDetails(){
		
		MuzeboardOverviewPage muzeboardOverviewPage = new MuzeboardOverviewPage(driver);
		SeleniumFunction.click(muzeboardOverviewPage.editProfileLink());
		
		ProfileInfoMuzeboardPage profileInfoMuzeboardPage = new ProfileInfoMuzeboardPage(driver);
		profileInfoMuzeboardPage.aboutMeTextbox();
		ScreenShot.takeScreenShot(driver, "ProfileInfoPage");
		SeleniumFunction.sendKeys(profileInfoMuzeboardPage.aboutMeTextbox(), "Test Update");
		ScreenShot.takeScreenShot(driver, "AboutMe");
		SeleniumFunction.click(profileInfoMuzeboardPage.contactInfoLink());
		ScreenShot.takeScreenShot(driver, "ContactInfo");
		SeleniumFunction.sendKeys(profileInfoMuzeboardPage.zipCodeTextbox(), "85001");
		ScreenShot.takeScreenShot(driver, "ZipCode");
		SeleniumFunction.sendKeys(profileInfoMuzeboardPage.licenseNumberTextbox(), "9874563215");
		SeleniumFunction.clickAction(driver, profileInfoMuzeboardPage.saveButton());
		WaitTool.sleep(4);
		ScreenShot.takeScreenShot(driver, "ProfileSaved");
		
	}

}
