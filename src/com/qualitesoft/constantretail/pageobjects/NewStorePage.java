package com.qualitesoft.constantretail.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class NewStorePage {

	WebDriver driver;

	public NewStorePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement storeNameTextField() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='shopName']"), 60);
	}

	public WebElement uploadLogoButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='pickfiles']"), 10);
	}

	public void uploadLogoChrome() {

		try {
			SeleniumFunction.click(uploadLogoButton());
			String[] path = { System.getProperty("user.dir") + "\\binaries\\logo\\logo.jpg" };
			//WaitTool.sleep(2);
			SeleniumFunction.runAutoItScript("logoUploadChrome.exe", path[0]);
			WaitTool.waitForElementPresentAndDisplay(driver,
					By.xpath(".//*[@id='uploadprogress']/span[contains(text(),'100%')]"), 40);
		} catch (Exception e) {
			Log.error("Not able to upload logo: " + e.getMessage());
			throw e;
		}
	}

	public void uploadLogoFirefox() {

		try {
			SeleniumFunction.click(uploadLogoButton());
			String[] path = { System.getProperty("user.dir") + "\\binaries\\logo\\logo.jpg" };
			SeleniumFunction.runAutoItScript("logoUploadFirefox.exe", path[0]);
			WaitTool.waitForElementPresentAndDisplay(driver,
					By.xpath(".//*[@id='uploadprogress']/span[contains(text(),'100%')]"), 20);
		} catch (Exception e) {
			Log.error("Not able to upload logo: " + e.getMessage());
			throw e;
		}
	}

	public WebElement nextButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='nextwizardbutton']"), 10);
	}

	public WebElement selectThisTemplateButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@onclick='SetTemplate(this)']"), 20);
	}

	public WebElement templateText() {

		return driver.findElement(By.xpath(".//*[@class='template-container']"));
	}

	public void selectTemplate(String templatename) {

		try {
			List<WebElement> templates = driver.findElements(By.xpath(".//*[@class='template-container']//h3"));
			for (int template = 0; template <= templates.size(); template++) {
				if (templates.get(template).getText().trim().equalsIgnoreCase(templatename.trim())) {
					SeleniumFunction.click(driver
							.findElement(By.xpath("(//button[@onclick='SetTemplate(this)'])[" + (template + 1) + "]")));
					break;
				}
			}
		} catch (Exception e) {
			Log.error("Not able to select Template: " + e.getMessage());
			throw e;
		}
	}

	public WebElement selectExistingBrandsCheckbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath(".//*[@type='checkbox']/following-sibling::label"), 30);
	}

	public void selectExistingBrands(String existingBrand) {

		try {
			List<WebElement> brands = driver.findElements(By.xpath(".//*[@type='checkbox']/following-sibling::label"));
			for (WebElement brand : brands) {
				if (brand.getText().trim().equalsIgnoreCase(existingBrand.trim())) {
					SeleniumFunction.click(brand);
					break;
				}
			}
		} catch (Exception e) {
			Log.error("Not able to select exixsting brands: " + e.getMessage());
			throw e;
		}
	}

	public WebElement createButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@onclick='CreateStore()']"), 20);
	}

	public WebElement websiteLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='ourDNS']"), 180);
	}

	private WebElement validationError() {

		WaitTool.sleep(1);
		return WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath(".//*[contains(@id,'error')]"), 4);
	}

	public void validationSummaryMsg() {

		validationError();

		if (WaitTool.isElementPresentAndDisplay(driver, By.xpath(".//*[contains(@id,'error')]"))) {

			List<WebElement> errors = driver.findElements(By.xpath(".//*[contains(@id,'error')]"));
			for (WebElement error : errors) {
				Log.error("Validation error: " + SeleniumFunction.getText(error));
			}
			Assert.fail("Validation error is present and display on new store page");
		}
	}
}
