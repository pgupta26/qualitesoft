package com.qualitesoft.homesquare.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class MuzeboardCreatePage {

	WebDriver driver;

	public MuzeboardCreatePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement searchTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='search-query']"), 60);
	}

	public WebElement searchButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("(//button[@type='submit']//span[@class='glyphicon glyphicon-search'])[1]"), 60);
	}

	public WebElement searchItem() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("(//div[@class='item ui-draggable ui-draggable-handle'])[1]//img"), 60);
	}
	
	public WebElement searchItemBackground() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("(//div[@class='item item-bg ui-draggable ui-draggable-handle'])[1]//img"), 60);
	}

	public List<WebElement> searchItems() {

		return WaitTool.waitForElementsPresentAndDisplay(driver,
				By.xpath("//div[@class='item ui-draggable ui-draggable-handle']"), 60);
	}

	public WebElement dropLocation() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//div[@class='canvas-container ui-droppable']"), 60);
	}

	public WebElement saveButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@id='btnSave']"), 60);
	}
	
	public WebElement boardNameTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='board-name']"), 60);
	}
	
	public WebElement descriptionTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//textarea[@id='board-description']"), 60);
	}
	
	public WebElement tagsTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='board-tags']//preceding-sibling::div"), 60);
	}
	
	public WebElement saveBoardButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@id='save-board']"), 60);
	}
	
	public WebElement publishButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@id='btnPublish']"), 60);
	}
	
	public WebElement backToBoardsLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='Overview.aspx']"), 60);
	}
	
	public WebElement browseImagesButton() {

		return WaitTool.returnWebElement(driver, By.xpath("//a[@id='inspired-image-pickfiles']"));
	}
	
	public void uploadInspiredPicChrome() {

		try {
			
			SeleniumFunction.clickAction(driver, browseImagesButton());
			String[] path = {
					System.getProperty("user.dir") + "\\binaries\\muzeboard\\logo.jpg" };
			SeleniumFunction.runAutoItScript("logoUploadchrome.exe", path[0]);
			WaitTool.waitForElementPresentAndDisplay(driver,
					By.xpath(".//*[@class='progress-bar-striped progress-bar progress-bar-info active']/span[contains(text(),'100%')]"), 20);
		} catch (Exception e) {
			Log.error("Not able to upload file: " + e.getMessage());
			throw e;
		}
	}
	
	public WebElement viewYourBoardLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@id='linkBoard']"),30);
	}
	
	public WebElement backgroundTabLink() {

		return WaitTool.returnWebElement(driver, By.xpath("//a[@href='#backgroundContainer']"));
	}
	
}
