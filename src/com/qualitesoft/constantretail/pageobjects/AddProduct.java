package com.qualitesoft.constantretail.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class AddProduct {
	

		WebDriver driver;

		public AddProduct(WebDriver driver) {
			this.driver = driver;
		
}

		public WebElement addProductLink() {

			return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@data-slug='products']"), 60);
		}
        
		public WebElement allProductLink() {

			return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/products']"), 60);
		}
		
		public WebElement addProduct() {

			return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/products/add']"), 60);
		}
		
		public WebElement addProductImage() {

			return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='product-pickfiles']"), 60);
		}
		
		public WebElement inventoryLink() {

			return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='#productInventory']"), 60);
		}
		
		public WebElement inventorySKU() {

			return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='edit-modal-sku']"), 60);
		}
		
		public WebElement prodcutExpand() {

			return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='#productInformation']"), 60);
		}
		
		public void selectExistingBrands(String existingBrand) {

			try {
				List<WebElement> brands = driver.findElements(By.xpath("//*[@id='brand-list-search']"));
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
		
		
		public WebElement category() {

			return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='category-list-search']"), 10);
		}
		public WebElement countryDropDown() {

			return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='edit-modal-country-of-origin']"), 10);
		}
		public WebElement productName() {

			return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@onclick='updateOrAddProduct']"), 10);
		}

		public void uploadLogoChrome() {

			try {
				SeleniumFunction.click(addProductImage());
				String[] path = { System.getProperty("user.dir") + "\\binaries\\logo\\logo.jpg" };
				SeleniumFunction.runAutoItScript("logoUploadChrome.exe", path[0]);
				WaitTool.waitForElementPresentAndDisplay(driver,
						By.xpath(".//*[@id='uploadprogress']/span[contains(text(),'100%')]"), 20);
			} catch (Exception e) {
				Log.error("Not able to upload logo: " + e.getMessage());
				throw e;
			}
		}

		public void uploadLogoFirefox() {

			try {
				SeleniumFunction.click(addProductImage());
				String[] path = { System.getProperty("user.dir") + "\\binaries\\logo\\logo.jpg" };
				SeleniumFunction.runAutoItScript("logoUploadFirefox.exe", path[0]);
				WaitTool.waitForElementPresentAndDisplay(driver,
						By.xpath(".//*[@id='uploadprogress']/span[contains(text(),'100%')]"), 20);
			} catch (Exception e) {
				Log.error("Not able to upload logo: " + e.getMessage());
				throw e;
			}
		}

		
		
}

