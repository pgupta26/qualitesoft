package com.qualitesoft.homesquare.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.homesquare.pageobjects.HomePage;
import com.qualitesoft.homesquare.pageobjects.MuzeboardBasicInfoPage;
import com.qualitesoft.homesquare.pageobjects.MuzeboardDetailInfoPage;
import com.qualitesoft.homesquare.pageobjects.MuzeboardOverviewPage;

public class MuzeboardSignUp extends InitializeTest {

	@Test
	public void testMuzeboardSignUp() {

		WebDriver driver = getDriver();

		HomePage homePage = new HomePage(driver);
		WebElement signUpLink = homePage.signUpLink();
		ScreenShot.takeScreenShot(driver, "HomePage");
		SeleniumFunction.click(signUpLink);

		WebElement emailTextbox = homePage.emailTextbox();
		ScreenShot.takeScreenShot(driver, "SignupForm");
		SeleniumFunction.sendKeys(emailTextbox, emailAddress());
		SeleniumFunction.sendKeys(homePage.passowrdTextbox(), "password");
		ScreenShot.takeScreenShot(driver, "SignupFormFilled");
		SeleniumFunction.click(homePage.signUpButton());

		WebElement describeBestButton = homePage.describeBestButton();
		ScreenShot.takeScreenShot(driver, "DescribeBestButton");
		SeleniumFunction.click(describeBestButton);

		MuzeboardBasicInfoPage muzeboardBasicInfoPage = new MuzeboardBasicInfoPage(driver);
		WebElement firstNameTextbox = muzeboardBasicInfoPage.firstNameTextbox();
		ScreenShot.takeScreenShot(driver, "BasicInfoPage");
		SeleniumFunction.sendKeys(firstNameTextbox, "Selenium_First");
		SeleniumFunction.sendKeys(muzeboardBasicInfoPage.lastNameTextbox(), "Selenium_Last");
		SeleniumFunction.sendKeys(muzeboardBasicInfoPage.businessNameTextbox(), "Selenium_Business");
		SeleniumFunction.select(muzeboardBasicInfoPage.categoryDropdown(), "Appliances");
		SeleniumFunction.click(muzeboardBasicInfoPage.companyTypeCheckbox());
		SeleniumFunction.select(muzeboardBasicInfoPage.countryDropdown(), "United States");
		SeleniumFunction.select(muzeboardBasicInfoPage.stateDropdown(), "Alabama");
		SeleniumFunction.sendKeys(muzeboardBasicInfoPage.cityTextbox(), "Selenium_City");
		SeleniumFunction.sendKeys(muzeboardBasicInfoPage.phoneTextbox(), "123456789");
		WebElement continueButton = muzeboardBasicInfoPage.continueButton();
		ScreenShot.takeScreenShot(driver, "BasicInfoPageFilled");
		SeleniumFunction.click(continueButton);

		MuzeboardDetailInfoPage muzeboardDetailInfoPage = new MuzeboardDetailInfoPage(driver);
		WebElement businessDescriptionTextbox = muzeboardDetailInfoPage.businessDescriptionTextbox();
		ScreenShot.takeScreenShot(driver, "DetailInfoPage");
		SeleniumFunction.sendKeys(businessDescriptionTextbox, "Business Description");
		SeleniumFunction.sendKeys(muzeboardDetailInfoPage.servicesProvidedTextbox(), "Services Provided");
		SeleniumFunction.sendKeys(muzeboardDetailInfoPage.areaServedTextbox(), "Area Served");
		SeleniumFunction.sendKeys(muzeboardDetailInfoPage.websiteTextbox(), "http://seleniumhq.org");
		SeleniumFunction.sendKeys(muzeboardDetailInfoPage.licensenoTextbox(), "123698547");
		SeleniumFunction.sendKeys(muzeboardDetailInfoPage.certsAndAwardsTextbox(), "Certs n Awards");
		SeleniumFunction.sendKeys(muzeboardDetailInfoPage.affiliationsTextbox(), "Affiliations");
		
		muzeboardDetailInfoPage.uploadProficPicChrome();
		
		WaitTool.sleep(2);
		WebElement saveProfileButton = muzeboardDetailInfoPage.saveProfileButton();
		ScreenShot.takeScreenShot(driver, "DetailInfoPageFilled");
		SeleniumFunction.clickJS(driver, saveProfileButton);

		MuzeboardOverviewPage muzeboardOverviewPage = new MuzeboardOverviewPage(driver);
		muzeboardOverviewPage.overviewTab();
		ScreenShot.takeScreenShot(driver, "OverviewPage");
	}

	private static String emailAddress() {

		String emailAddress = JavaFunction.randomText("Selenium", 4) + "@email.com";
		return emailAddress;
	}

}
