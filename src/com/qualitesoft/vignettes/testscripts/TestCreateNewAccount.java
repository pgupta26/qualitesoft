package com.qualitesoft.vignettes.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.americanmattress.pageobjects.CreateMyAccountPage;
import com.qualitesoft.americanmattress.pageobjects.HomePage;

public class TestCreateNewAccount extends InitializeTest {

	public static String emailAddress;

	@Test
	public void testCreateNewAccount() {

		

		
		HomePage homePage = new HomePage(driver);
	/*	if (homePage.closeModalButton() != null) {
			ScreenShot.takeScreenShot(driver, "HomePage");
			SeleniumFunction.click(homePage.closeModalButton());
		}*/
		WaitTool.sleep(4);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
	//	jse.executeScript("window.scrollBy(0,1550)", "");
		SeleniumFunction.clickJS(driver, homePage.myAccountLink_vig());
		ScreenShot.takeScreenShot(driver, "MyAccountPage");
		SeleniumFunction.clickJS(driver, homePage.createAnAccountLink());

		CreateMyAccountPage createMyAccountPage = new CreateMyAccountPage(driver);
		createMyAccountPage.firstNameTextField();
		ScreenShot.takeScreenShot(driver, "CreateNewAccountPage");
		SeleniumFunction.sendKeys(createMyAccountPage.firstNameTextField(), "TestSeleniumFirstName");
		SeleniumFunction.sendKeys(createMyAccountPage.lastNameTextField(), "TestSeleniumLastName");
		emailAddress = JavaFunction.emailAddress();
		SeleniumFunction.sendKeys(createMyAccountPage.emailAddressTextField(), emailAddress);
		SeleniumFunction.sendKeys(createMyAccountPage.passwordTextField(), "Cymax123");
		SeleniumFunction.sendKeys(createMyAccountPage.confirmPasswordTextField(), "Cymax123");
		SeleniumFunction.sendKeys(createMyAccountPage.streetAddressTextField(), "Selenium_Street");
		SeleniumFunction.sendKeys(createMyAccountPage.cityTextField(), "Selenium_City");
		SeleniumFunction.select(createMyAccountPage.countryDropdown(), "United States");
		createMyAccountPage.stateDropdownWaitForOptions();
		WaitTool.sleep(2);
		SeleniumFunction.select(createMyAccountPage.stateDropdown(), "Alaska");
		SeleniumFunction.sendKeys(createMyAccountPage.postalCodeTextField(), "99501");
		SeleniumFunction.sendKeys(createMyAccountPage.phoneTextField(), "907-465-2111");
		ScreenShot.takeScreenShot(driver, "CreateNewAccountPageFilled");
		SeleniumFunction.clickJS(driver, createMyAccountPage.registerButton());

		WaitTool.sleep(6);
		// SeleniumFunction.click(homePage.myAccountLink());
		ScreenShot.takeScreenShot(driver, "HomePageOnReturn");
	}
}
