package com.qualitesoft.constantretail.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;

public class RegisterPage {

	WebDriver driver;
	String pagetitle = "Register";

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public void registerPageDisplayed() {

		UseAssert.assertEquals(driver.getTitle(), pagetitle);
		Log.info("Page title " + pagetitle + " displayed.");
	}

	public WebElement firstNameTextBox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='FirstName']"), 10);
	}

	public WebElement lastNameTextBox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@*='LastName']"), 10);
	}

	public WebElement emailTextBox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@*='Email']"), 10);
	}

	public WebElement createPasswordTextBox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@name='Password']"), 10);
	}

	public WebElement confirmPassowrdTextBox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@name='ConfirmPassword']"), 10);
	}

	public WebElement signUpLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-primary btn-block submit btn-lg']"), 10);
	}

	private WebElement validationSummary() {

		return WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath(".//*[@id='val-summary']/li"), 5);
	}

	private WebElement validationError() {

		return WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath(".//*[contains(@id,'error')]"), 5);
	}

	public void validationSummaryMsg() {

		validationError();

		if (WaitTool.isElementPresentAndDisplay(driver, By.xpath(".//*[contains(@id,'error')]"))) {

			List<WebElement> errors = driver.findElements(By.xpath(".//*[contains(@id,'error')]"));
			for (WebElement error : errors) {
				Log.error("Validation error: " + SeleniumFunction.getText(error));
			}
			Assert.fail("Validation error is present and display on register page");
		}
		
		validationSummary();

		if (WaitTool.isElementPresentAndDisplay(driver, By.xpath(".//*[@id='val-summary']/li"))) {
			Assert.fail("Validation error: " + SeleniumFunction.getText(validationSummary()));
		}
	}

}
