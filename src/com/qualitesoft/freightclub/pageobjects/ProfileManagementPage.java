package com.qualitesoft.freightclub.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class ProfileManagementPage {

	WebDriver driver;

	public static String manageCarriers = "//a[text()='Manage Carriers']";

	public ProfileManagementPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement manageProfileLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/Admin/Index']"), 30);
	}

	public WebElement companyNameLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//h5[contains(.,'Brand ID: 10534')]"), 30);
	}
	public WebElement profileListfilter() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@placeholder='Filter profiles']"), 30);
	}	
	public WebElement paymentTermTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='InvoicingCycleDays']"), 30);
	}

	public WebElement lockoutCheckbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='LockOutEnabled']"), 30);
	}

	public WebElement saveProfileButton() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-primary pull-right']"), 30);
	}

	public WebElement saveProfileButtonSurePost() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[contains(text(),'Save Profile')]"), 30);
	}

	public WebElement quickQuoteBookOrderError() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@class='pull-right text-danger']/strong"), 30);
	}
	public WebElement paymentType() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='col-xs-12 col-lg-9']/div[8]/div[@class='col-xs-12 col-lg-6']//select[@class='form-control']"), 30);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[text()='Payment Type']/following-sibling::select[@class='form-control']"), 30);
	}
	public WebElement selectParcel() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"profileManagement\"]/div[2]/div/div/div/div[2]/div[19]/div/div[3]/input[2]"), 30);
	}	
	public void paymentTypeOptions(String packageType) {

		try {
			if(packageType.equalsIgnoreCase("CreditCard")){
				SeleniumFunction.click(driver.findElement
						(By.xpath("//div[@class='col-xs-12 col-lg-9']/div[8]/div[@class='col-xs-12 col-lg-6']//select[@class='form-control']/option[@value='96']")));
			}
			else if(packageType.equalsIgnoreCase("OnAccount")){
				SeleniumFunction.click(driver.findElement
						(By.xpath("//label[text()='Payment Type']/following-sibling::select/option[@value='95']")));
			}				
		}

		catch (Exception e) {
			Log.error("Not able to select package: " + e.getMessage());
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}	
	public void quickQuoteBookOrderValidation() {
		quickQuoteBookOrderError();
		if (quickQuoteBookOrderError() != null) {
			if (driver.findElement(By.xpath(".//*[@class='pull-right text-danger']/strong"))
					.getText() != "duplicate") {
				Log.error(driver.findElement(By.xpath(".//*[@class='pull-right text-danger']/strong")).getText());				
			}
		}
	}	
	
	public WebElement upsSetting(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.linkText("UPS Settings"), 60);	
	}

	//Add by Shubham
	public WebElement selectGround(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[contains(text(),'Ground')]/input[1]"), 60);	
	}
	public WebElement selectUPSSurepost(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[contains(text(),'Ground')]/input[2]"), 60);	
	}

	public WebElement saveProfileBtn(){
		return WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath("//*[@id=\"upsTab\"]/div[3]/div[7]/div/button"), 60);
	}
	public WebElement selectInternational(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[contains(text(),'Can Book International Orders')]/input"), 60);
	}

	public void enableCarrier(String[] carrierNames) throws InterruptedException {
		for(String carrierName :carrierNames) {
			if(carrierName.equals("Pilot Freight Services[Televisions]")) {
				SeleniumFunction.scrollIntoView(driver, driver.findElement(By.xpath("//span[contains(text(),'[Televisions]')]/parent::td/following-sibling::td[2]/descendant::span")));
				String carrierStatus = SeleniumFunction.getText(driver.findElement(By.xpath("//span[contains(text(),'[Televisions]')]/parent::td/following-sibling::td[2]/descendant::span")));
				if(!carrierStatus.equals("Active")) {
					SeleniumFunction.clickJS(driver,driver.findElement(By.xpath("//span[contains(text(),'[Televisions]')]/parent::td/following-sibling::td[2]/label")));
				}
			}else {
				SeleniumFunction.scrollIntoView(driver, driver.findElement(By.xpath("//td[contains(text(),'"+carrierName+"')]/following-sibling::td[2]/descendant::span")));
				String carrierStatus = SeleniumFunction.getText(driver.findElement(By.xpath("//td[contains(text(),'"+carrierName+"')]/following-sibling::td[2]/descendant::span")));
				if(!carrierStatus.equals("Active")) {
					SeleniumFunction.clickJS(driver,driver.findElement(By.xpath("//td[contains(text(),'"+carrierName+"')]/following-sibling::td[2]/label")));
				}
			}
		}
	}

	public void disableCarrier(String[] carrierNames) throws InterruptedException {
		for(String carrierName :carrierNames) {
			SeleniumFunction.scrollIntoView(driver, driver.findElement(By.xpath("//td[contains(text(),'"+carrierName+"')]/following-sibling::td[2]/descendant::span")));
			String carrierStatus = SeleniumFunction.getText(driver.findElement(By.xpath("//td[contains(text(),'"+carrierName+"')]/following-sibling::td[2]/descendant::span")));
			if(carrierStatus.equals("Active")) {
				SeleniumFunction.click(driver.findElement(By.xpath("//td[contains(text(),'"+carrierName+"')]/following-sibling::td[2]/descendant::span")));
			}
		}
	}
	
	public void enableTruckLoad(String truckLoad) {
		WebElement element = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//label[contains(text(),'Truckload')])[2]/following::div[1]/input[3]"), 30);
		System.out.println("Is element selected: "+element.isSelected());
		 if(!element.isSelected()) {
			 SeleniumFunction.click(element);
		 }
	}
	
	public void disableTruckLoad(String truckLoad) {
		 WebElement element = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//label[contains(text(),'Truckload')])[2]/following::div[1]/input[3]"), 30);
		 System.out.println("Is element selected: "+element.isSelected());
		 if(element.isSelected()) {
			 SeleniumFunction.click(element);
		 }
	}
	
	
}
