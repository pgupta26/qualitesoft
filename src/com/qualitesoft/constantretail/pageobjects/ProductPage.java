package com.qualitesoft.constantretail.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class ProductPage{
	
	WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement addProductButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/products/add']"), 60);
	}
	
	public WebElement productExpandButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='#productInformation']"), 60);
	}
	
	public WebElement uploadLogoButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@id='product-pickfiles']"), 60);
	}
	
	public void uploadLogoChrome() {

		try {
			SeleniumFunction.click(uploadLogoButton());
			String[] path = { System.getProperty("user.dir") + "\\binaries\\logo\\logo.jpg" };
			SeleniumFunction.runAutoItScript("logoUploadChrome.exe", path[0]);
		} catch (Exception e) {
			Log.error("Not able to upload logo: " + e.getMessage());
			throw e;
		}
	}
	
	public WebElement inventoryExpandButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='#productInventory']"), 60);
	}
	public WebElement vendorpriceTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='ListPrice']"), 60);
	}
	public WebElement wholesaleTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='WholesalePrice']"), 60);
	}	
	public WebElement SKUTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='SKU']"), 60);
	}
	public WebElement quantityTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='Quantity']"), 60);
	}	
	public WebElement saveButton() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='editOrAddProducts']//div[@class='row']//div[2]//div//button[2]"), 60);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@data-bind='click: updateOrAddProduct']"), 60);
	}
	public WebElement saveButton1() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='editOrAddProducts']//div[@class='row']//div[2]//div//button[2]"), 60);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@data-bind='click: updateOrAddProduct']"), 60);
	}
	public WebElement applyFilter() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@id='btn-search']"), 60);
	}
	public WebElement brandDropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='brand-list-search']"), 60);
	}
	public WebElement expand() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='collapse-link product-container-link collapsed']"), 60);
	}		
	public WebElement BrandId(String brandid) {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='brand-list-search']//option[@value='"+brandid+"']"), 60);
	}	
	public WebElement categoryListDropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='category-list-search']"), 60);
	}
	public WebElement FurnitureChairCategory() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='category-list-search']//option[@value='292']"), 30);
	}
	public WebElement IssellableCheckbox(String item) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"product-content\"]/div[1]/div/div[2]/div[2]/div[2]/table/tbody/tr["+item+"]/td[6]/input"), 30);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"product-content\"]/div[1]/div/div[3]/div/div[2]/table/tbody/tr["+item+"]/td[6]/input"), 30);
	}	
	public WebElement IsactiveCheckbox(String item) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\\\"product-content\\\"]/div[1]/div/div[3]/div/div[2]/table/tbody/tr["+item+"]/td[7]/input"), 30);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"product-content\"]/div[1]/div/div[3]/div/div[2]/table/tbody/tr["+item+"]/td[7]/input"), 30);
	}	

	public WebElement countryOfManufactureDropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='edit-modal-country-of-origin']"), 60);
	}
	
	public WebElement titleTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='edit-title']"), 60);
	}
	
	public WebElement editProductIcon() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//a[@title='Edit Product'])[1]"), 60);
	}
	public WebElement exportProduct() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"product-content\"]/div[1]/div/div[2]/header/div[2]/a"), 60);
	}	
	public WebElement isSellable() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@name='IsSellable'])[1]"), 60);
	}
	
	public WebElement addVariantButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@data-bind='click: $root.openVariantsModal']"), 60);
	}
	
	public WebElement newOptionsGroupButton() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-success pull-right']"), 60);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@data-bind='click: function() { $root.addOptionGroup() }']"), 60);
	}
	
	public WebElement optionGroupNameTexbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@data-bind='value: Name']"), 60);
	}
	
	public WebElement optionValuesTexbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@data-bind='value: Description']"), 60);
	}
	
	public WebElement newOptionValueLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@data-bind='click: function() { $root.addOptionValue($data) }']"), 60);
	}
	
	public WebElement newOptionValueLink2() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@data-bind='value: Description'])[2]"), 60);
	}
	
	public WebElement saveVariantsButton() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"modalOptionGroups\"]/div/div/div[3]/div/div[2]/a"), 60);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[text()='Save Variants']/ancestor::a"), 60);
	}
	//*[@id="modalOptionGroups"]/div/div/div[3]/div/div[2]/a
	public WebElement saveVariants() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='modalOptionGroups']/div/div/div[3]/div/div[2]/a"), 60);
	}
	public WebElement updateSaveButton1() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='editOrAddProducts']//div[@class='row']//div[2]//div//button[2]"), 60);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@data-bind='click: updateOrAddProduct']"), 60);
	}
	public WebElement updateSaveButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[@data-bind='click: updateOrAddProduct'])[2]"), 60);
	}
	
	public WebElement viewProductIcon() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@title='View Product']"), 60);
	}
 
	public WebElement chooseCategory() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[@class='select2-selection select2-selection--single' and @aria-labelledby='select2-category-list-search-container']"), 60);
	}
	
	public WebElement chooseCategorySearch() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@class='select2-search__field']"), 60);
	}
	
	public WebElement chooseCategoryResults() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='select2-category-list-search-results']/li[2]/div/div/div"), 60);
	}
	
	 public void SelectCategory(String Category) {

			try {
				SeleniumFunction.sendKeys(driver.findElement(By.xpath("//input[@class='select2-search__field']")), "Cleaner");
				List<WebElement> Categories = driver.findElements(By.xpath("//span[@class='select2-results']"));
				for (int categorytypes = 0; categorytypes <= Categories.size(); categorytypes++) {
					if (Categories.get(categorytypes).getText().trim().equalsIgnoreCase(Category.trim())) {
						SeleniumFunction.click(driver.findElement(By.
								xpath("//span[@class='select2-results']//li[@class='select2-results__option'][1]")));
						break;
					}
				}
			} catch (Exception e) {
				Log.error("Not able to click Category: " + e.getMessage());
				throw e;
			}
		}
	
		public WebElement viewProduct1() {

			return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[contains(@href,'selenium')]"), 60);
		}	
		
		public WebElement exprortProduct() {

			return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[contains(@data-bind, 'exportResults')]"), 60);
		}
		public WebElement productname() {

			return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='product-data']/h1"), 60);
		}
		
}