package com.qualitesoft.freightclub_enhancement.qa517.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class ManageCarrierPage {
	
	WebDriver driver;

	public ManageCarrierPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void manageCarriersLink() {
		SeleniumFunction.click(WaitTool.returnWebElement(driver, By.xpath("//a[@href='/Admin/ManageCarriers']")));
	}
	
	public void filterCarrier(String carrierName) {
		if(carrierName.equals("Pilot Freight Services[Televisions]")) {
			SeleniumFunction.sendKeys(WaitTool.returnWebElement(driver, By.id("carriers-list-filter")), "Pilot");
			driver.findElement(By.id("carriers-list-filter")).sendKeys(Keys.ENTER);
			WaitTool.sleep(5);
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//h5[contains(text(),'Pilot Freight Services  [Televisions]')]"), 20));
		}else {
			SeleniumFunction.sendKeys(WaitTool.returnWebElement(driver, By.id("carriers-list-filter")), carrierName);
			driver.findElement(By.id("carriers-list-filter")).sendKeys(Keys.ENTER);	
		}
	}
	
	public void selectResidentialPickUp() {
		WebElement residentialPickUP = WaitTool.returnWebElement(driver, By.xpath("//*[@id='optionsTab']/div[1]/div/input"));
		if(!residentialPickUP.isSelected()) {
			SeleniumFunction.click(residentialPickUP);
		}
	}
	
	public void unselectResidentialPickUp() {
		WebElement residentialPickUP = WaitTool.returnWebElement(driver, By.xpath("//*[@id='optionsTab']/div[1]/div/input"));
		if(residentialPickUP.isSelected()) {
			SeleniumFunction.click(residentialPickUP);
		}
	}
	
	public void selectLooseCartoon() {
		WebElement looseCartoon = WaitTool.returnWebElement(driver, By.xpath("//*[@id='optionsTab']/div[2]/div/input"));
		if(!looseCartoon.isSelected()) {
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath("//*[@id='optionsTab']/div[2]/div/input"), 10));
		}
	}
	
	public void unselectLooseCartoon() {
		WebElement looseCartoon = WaitTool.returnWebElement(driver, By.xpath("//*[@id='optionsTab']/div[2]/div/input"));
		if(looseCartoon.isSelected()) {
			SeleniumFunction.click(looseCartoon);
		}
	}
	
	

}
