package com.qualitesoft.constantretail.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class SitePagesPage {

	WebDriver driver;

	public SitePagesPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement aboutUsLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//span[@class='icon glyphicon'])[1]/parent::*"), 60);
	}

	public WebElement generalInfoEditButton() {

		return driver.findElement(By.xpath("(//button[@contentitem-id='5596ca48-f720-4ee5-aa43-f849c7f5e89f'])"));
	}
	
	public WebElement addNewLinkButton() {

		return driver.findElement(By.xpath("//button[@class='btn btn-success site-editor-button margin-bottom-10']"));
	}
	
	public WebElement aboutUsEditButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[@onclick='SiteEditor.EditButtonClicked(this)'])[3]"),30);
	}
	
	public WebElement generalInfoEditTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[text()='Title']/following-sibling::*"),30);
	}
	
	public WebElement aboutUsTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='note-editable']"),30);
	}
	
	public WebElement saveButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[@class='btn btn-primary btn-lg site-editor-button' and contains(text(),'Save')])[2]"),30);
	}
	
	public WebElement generalInfoSaveButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[@class='btn btn-primary btn-lg site-editor-button' and contains(text(),'Save')])[1]"),30);
	}
	
	public WebElement newElement() {

		return driver.findElement(By.xpath("//li[@class='list-group-item node-itemsNavigation'][1]"));
	}
	
	public WebElement newElementWebsite() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//li[@contentitem-type='4'])[13]//a"),30);
	}
	
	public WebElement homeViewLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//li[@class='list-group-item node-itemsTreeFirst' and @data-nodeid='3']"),30);
	}

}
