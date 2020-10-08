package com.qualitesoft.constantretail.testscripts;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.qualitesoft.constantretail.pageobjects.AvailableSubscriptionPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class SelectAndActivateSubscription extends InitializeTest {

	public SelectAndActivateSubscription() {
	}

	@Test
	public void testSelectAndActivateSubscription() {

		WebDriver driver = getDriver();

		AvailableSubscriptionPage availableSubscriptionPage = new AvailableSubscriptionPage(driver);
		ScreenShot.takeScreenShot(driver, "AvailableSubscriptionPage");
		
	//	SeleniumFunction.click(availableSubscriptionPage.subscriptionLink());
		WaitTool.sleep(2);
	//	SeleniumFunction.click(availableSubscriptionPage.availableLink());
		
		SeleniumFunction.click(availableSubscriptionPage.startTrialButton());

		WebElement subscriptionConfirmationOKButton = availableSubscriptionPage.subscriptionConfirmationOKButton();
		ScreenShot.takeScreenShot(driver, "SubscriptionConfirmPage");
		SeleniumFunction.click(subscriptionConfirmationOKButton);
		WaitTool.sleep(10);

		WebElement firstNameTextField = availableSubscriptionPage.firstNameTextField();
		ScreenShot.takeScreenShot(driver, "SubscriptionDetailPage");
		SeleniumFunction.sendKeys(firstNameTextField, "Selenium_First");
		SeleniumFunction.sendKeys(availableSubscriptionPage.lastNameTextField(), "Selenium_Last");
		SeleniumFunction.sendKeys(availableSubscriptionPage.emailField(), "test@test.com");
		SeleniumFunction.sendKeys(availableSubscriptionPage.companyNameTextField(), "Selenium_QS");
		SeleniumFunction.sendKeys(availableSubscriptionPage.creditCardTextField(), "4111111111111111");
		SeleniumFunction.select(availableSubscriptionPage.monthDropDown(), "January");
		SeleniumFunction.select(availableSubscriptionPage.yearDropDown(), "2020");
		SeleniumFunction.sendKeys(availableSubscriptionPage.cvvTextBox(), "321");
		SeleniumFunction.sendKeys(availableSubscriptionPage.addressTextBox(), "Selenium_Address");
		SeleniumFunction.sendKeys(availableSubscriptionPage.address1TextBox(), "Selenium_Address1");
		SeleniumFunction.sendKeys(availableSubscriptionPage.cityTextBox(), "Selenium_City");
		/*JavascriptExecutor jsExec = (JavascriptExecutor) driver;
		jsExec.executeScript("document.getElementById(availableSubscriptionPage.zipCodeTextBox()).scrollDown += 100");*/
		SeleniumFunction.sendKeys(availableSubscriptionPage.zipCodeTextBox(), "132103");
		
		SeleniumFunction.select(availableSubscriptionPage.countryDropDown(), "India");
		WaitTool.sleep(5);
		SeleniumFunction.select(availableSubscriptionPage.stateDropDown(), "IN");
		ScreenShot.takeScreenShot(driver, "SubscriptionDetailPageFilled");
		WaitTool.sleep(5);
		SeleniumFunction.clickJS(driver, availableSubscriptionPage.submitDetailsButton());
		
		//availableSubscriptionPage.validateSubscriptionDetail();
		ScreenShot.takeScreenShot(driver, "SubscriptionSuccessPage");
	}

}
