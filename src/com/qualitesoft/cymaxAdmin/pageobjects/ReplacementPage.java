package com.qualitesoft.cymaxAdmin.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class ReplacementPage {

	WebDriver driver;
	
	public ReplacementPage(WebDriver driver){
		this.driver = driver;
	}
	
	By replacementTab = By.xpath("//span[contains(@id,'tcOrder_PnlRep_tab')]");
	By status = By.xpath("//select[contains(@name,'ddlRepStatus')]");
	By followDate = By.xpath("//input[contains(@id,'txtRepFollowupDate')]");
	By saveBtn = By.xpath("//input[contains(@name,'ReplacementSave')]");
	By selectedStatus = By.xpath("//select[contains(@name,'ddlRepStatus')]//option[@selected='selected']");
	By chooseFile = By.xpath("//div[contains(@id,'PnlRep_updFileUp')]//input[@type='file']");
	By uploadBtn = By.xpath("//div[contains(@id,'PnlRep_updFileUp')]//input[@type='submit']");
	
	By uploadedPhotos = By.xpath("//table[contains(@id,'gvReplacementPhotoLinks')]//td[2]");
	
	
	public WebElement clickReplacementTab(){
		return WaitTool.waitForElementPresentAndDisplay(driver, replacementTab, 120);
	}
	
	public WebElement selectStatus(){
		return WaitTool.waitForElementPresentAndDisplay(driver, status, 120);
	}
	
	public WebElement clickSaveBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, saveBtn, 120);
	}
	
	public WebElement getSelectedStatus(){
		return WaitTool.waitForElementPresentAndDisplay(driver, selectedStatus, 120);
	}
	
	public WebElement setFollowUpDate(){
		return WaitTool.waitForElementPresentAndDisplay(driver, followDate, 120);
	}
	
	public WebElement setChooseFile(){
		return WaitTool.waitForElementPresentAndDisplay(driver, chooseFile, 120);
	}
	
	public WebElement clickUploadBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, uploadBtn, 120);
	}
	
	public List<WebElement> getUploadedPhotosText(){
		return WaitTool.waitForElementsPresentAndDisplay(driver, uploadedPhotos, 60);
	}
	
}
