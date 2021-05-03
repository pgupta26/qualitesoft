package com.qualitesoft.freightclub.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class OverageDetails {
	
	WebDriver driver;
	
	public OverageDetails(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getLabel(String label) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[text()='"+label+"']/following-sibling::span | //label[text()='"+label+"']/following-sibling::input"), 10);
	}
	
	public WebElement getSelect(String label) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[text()='"+label+"']/following-sibling::div/descendant::div[contains(@class,'has-item')]"), 10);
	}
	
	public WebElement setSelect(String label, String value) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[text()='"+label+"']/following-sibling::div/descendant::div[@class='option' and text()='"+value+"']"), 10);
	}
	
	public WebElement documents() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='k-button k-upload-button']"), 10);
	}
	
	public WebElement comments() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//textarea[@placeholder='Add your comment...']"), 10);
	}
	
	public WebElement saveComment() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[contains(text(),'Save Comment')]"), 10);
	}
	
	public WebElement saveChanges() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[contains(text(),'Save Changes')]"), 10);
	}
	
	public WebElement savedComment() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='details-area']/descendant::div[@class='col-xs-4']/descendant::td[1]"), 10);
	}
	
	public WebElement savedUserName() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='details-area']/descendant::div[@class='col-xs-4']/descendant::td[2]/strong"), 10);
	}
	
	public WebElement uploadName() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='details-area']/descendant::label[text()='Documents to support dispute:']/following-sibling::table/tbody/tr/td[1]"), 10);
	}
	
	public WebElement dateTime() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='details-area']/descendant::label[text()='Documents to support dispute:']/following-sibling::table/tbody/tr/td[2]"), 10);
	}
	
	public WebElement viewable() {
		return WaitTool.returnWebElement(driver, By.xpath("//div[@id='details-area']/descendant::label[text()='Documents to support dispute:']/following-sibling::/table/tbody/tr/td[3]/a[1]"));
	}
	
	public WebElement downloadable() {
		return WaitTool.returnWebElement(driver, By.xpath("//div[@id='details-area']/descendant::label[text()='Documents to support dispute:']/following-sibling::/table/tbody/tr/td[3]/a[2]"));
	}
	
	public WebElement removable() {
		return WaitTool.returnWebElement(driver, By.xpath("//div[@id='details-area']/descendant::label[text()='Documents to support dispute:']/following-sibling::/table/tbody/tr/td[3]/i"));
	}
	
	public WebElement submitForReview() {
		return WaitTool.returnWebElement(driver, By.xpath("//button[contains(text(),'Submit for Review')]"));
	}
	
	//Sent to carrier popup
	public WebElement getLabelFromModal(String modal, String label) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='"+modal+"']/descendant::label[text()='"+label+"']/following-sibling::input | //div[@id='sentToCarrierModal']/descendant::label[text()='"+label+"']/following-sibling::textarea"), 10);
	}
	
	public WebElement sendEmail(String modal) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='"+modal+"']/descendant::button[contains(text(),'Send Email')]"), 10);
	}
	

}
