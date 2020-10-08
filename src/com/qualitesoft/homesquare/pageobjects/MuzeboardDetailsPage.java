package com.qualitesoft.homesquare.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class MuzeboardDetailsPage {

	WebDriver driver;

	public MuzeboardDetailsPage(WebDriver driver) {

		this.driver = driver;
	}

	public void verifySuccessMessage() {

		WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@class='alert-success']"), 60);
		if (driver.findElement(By.xpath(".//*[@class='alert-success']")).isDisplayed()) {
			Log.info(SeleniumFunction.getText(driver.findElement(By.xpath(".//*[@class='alert-success']"))));
		} else {
			Log.warn("Success message not found.");
			Assert.fail();
		}
	}

	public WebElement createNewOneLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//a[@href='/Components/MuzeBoard/CreateMuzeBoard.aspx']"), 60);
	}
}
