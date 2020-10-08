package com.qualitesoft.constantretail.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;

public class AvailableSubscriptionPage {

	WebDriver driver;
	String pagetitle = "My Constant Retail";

	public AvailableSubscriptionPage(WebDriver driver) {
		this.driver = driver;
	}

	public void availableSubscriptionPageDisplayed() {

		UseAssert.assertEquals(driver.getTitle(), pagetitle);
		Log.info("Page title " + pagetitle + " displayed.");
	}

	//used previouly not needed now
	public WebElement startYourFreeTrialButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("(//a[@onclick='ConfirmDialog(this)'])[" + JavaFunction.getRandomNumber(1, 3) + "]"), 60);
	}
	
	public WebElement startTrialButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//button[@class='btn btn-primary btn-block' and @data-subsid='11']"), 60);
	}
	
	public WebElement subscriptionConfirmationOKButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='recurlyProcessingButton']"), 10);
	}

	public WebElement firstNameTextField() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='BillingInfo_FirstName']"), 60);
	}

	public WebElement lastNameTextField() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='BillingInfo_LastName']"), 10);
	}

	public WebElement companyNameTextField() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='BillingInfo_Company']"), 10);
	}

	public WebElement creditCardTextField() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='BillingInfo_CreditCardNumber']"),
				10);
	}

	public WebElement monthDropDown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='BillingInfo_ExpirationMonth']"),
				10);
	}

	public WebElement yearDropDown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='BillingInfo_ExpirationYear']"),
				10);
	}

	public WebElement cvvTextBox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='BillingInfo_VerificationValue']"),
				10);
	}

	public WebElement addressTextBox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='BillingInfo_Address1']"), 10);
	}

	public WebElement address1TextBox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='BillingInfo_Address2']"), 10);
	}

	public WebElement cityTextBox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='BillingInfo_City']"), 10);
	}

	public WebElement zipCodeTextBox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='BillingInfo_PostalCode']"), 10);
	}

	public WebElement emailField() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Email']"), 10);
	}
	
	public WebElement countryDropDown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='BillingInfo_Country']"), 10);
	}

	public WebElement stateDropDown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='BillingInfo_State']"),
				10);
	}

	public WebElement submitDetailsButton() {

		return WaitTool.returnWebElement(driver, By.xpath("//button[@type='submit']"));
	}
	
	

	public WebElement successSubscription() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@class='toast toast-success']"), 60);
	}
	
	public WebElement createNewStoreLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/store/create']"), 30);
	}
	
	public WebElement gotoNewStore() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/store/create']"), 30);
	}

	private void subscriptionSuccessful() {

		successSubscription();

		if (!WaitTool.isElementPresentAndDisplay(driver, By.xpath(".//*[@class='toast toast-success']"))) {
			Log.warn("Success subscription message didnot displayed.");
			Assert.fail();
		} else {
			Log.info(SeleniumFunction.getText(successSubscription()));
		}
	}

	public WebElement errorsSubscriptionDetailPage() {

		return WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath(".//*[contains(@id,'error')]"), 4);
	}

	public WebElement errorsSummaryDetailPage() {

		return WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath(".//*[contains(@id,'error')]//li"), 4);
	}

	public void validateSubscriptionDetail() {

		errorsSubscriptionDetailPage();

		if (WaitTool.isElementPresentAndDisplay(driver, By.xpath(".//*[contains(@id,'error')]"))) {
			List<WebElement> errors = driver.findElements(By.xpath(".//*[contains(@id,'error')]"));
			Log.error("Validation errors.");
			for (WebElement error : errors) {
				Log.error(SeleniumFunction.getText(error));
			}
			Assert.fail();
		} else {
			Log.info("No validation errors on Subscription Details page.");
			subscriptionSuccessful();
		}

		errorsSummaryDetailPage();

		if (WaitTool.isElementPresentAndDisplay(driver, By.xpath(".//*[contains(@id,'error')]//li"))) {
			List<WebElement> errors = driver.findElements(By.xpath(".//*[contains(@id,'error')]//li"));
			Log.error("Validation errors.");
			for (WebElement error : errors) {
				Log.error(SeleniumFunction.getText(error));
			}
			Assert.fail();
		} else {
			Log.info("No validation errors on Subscription Details page.");
			subscriptionSuccessful();
		}

	}
	
	public WebElement subscriptionLink() {

		return WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath("(//a[@data-slug='OnlineStore'])[1]"), 4);
	}
	
	public WebElement availableLink() {

		return WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath("(//a[@href='/subscriptions/available'])[1]"), 4);
	}

}
