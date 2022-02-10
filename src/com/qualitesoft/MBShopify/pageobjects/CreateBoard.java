package com.qualitesoft.MBShopify.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class CreateBoard {
	WebDriver driver;

	public CreateBoard(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement createmuzeboard() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-cyan pull-right margin-top-0 btn-create']"), 40);
	}
	public WebElement searchTextBox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("/html/body/my-app/layout/div[1]/div/muzeboard-create/div[1]/div[1]/div[4]/div/div/form/div/form-input/div/div/input"), 40);
	}	
	public WebElement searchbutton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-white btn-round btn-just-icon']"), 40);
	}
	public WebElement draggableimage() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//img[@class='draggable-image product']"), 40);
	}
	public WebElement addimage() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("/html/body/popover-container/div[2]/div/div[3]/div[3]/button"), 40);
	}
	public WebElement texticon() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//ul[@class='nav nav-tabs padding-15 margin-right-15 margin-left-15']/li[2]/a/span"), 40);
	}
	public WebElement addtext() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//form-input[@label='Add Text']/div/input"), 40);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("/html/body/my-app/layout/div[1]/div/muzeboard-create/div[1]/div[1]/div[2]/div/div/div/tabs/div[2]/tab[2]/div/div[1]/div[1]/form-input/div/div/input"), 40);
	}	
	public WebElement textbutton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-sm btn-cyan margin-top-30']"), 40);
	}
	public WebElement bgicon() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//ul[@class='nav nav-tabs padding-15 margin-right-15 margin-left-15']/li[3]/a/span"), 40);
	}
	public WebElement addbg() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("/html/body/my-app/layout/div[1]/div/muzeboard-create/div[1]/div[1]/div[2]/div/div/div/tabs/div[2]/tab[3]/div/div/span"), 40);
	}
	public WebElement bgcolor() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("/html/body/my-app/layout/div[1]/div/muzeboard-create/div[1]/div[1]/div[2]/div/div/div/tabs/div[2]/tab[3]/div/div/color-picker/div/div[6]/div[1]/input"), 40);
	}
	public WebElement bgokbutton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn bt n-primary btn-xs ng-star-inserted']"), 40);
	}
	public WebElement savebutton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"canvasb\"]/button[2]"), 40);
	}
	public WebElement boardname() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='boardName']"), 40);
	}
	public WebElement boarddesc() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='boardDescription']"), 40);
	}
	public WebElement saveboard() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-info btn-round pull-right']"), 40);
	}	
	public WebElement okbutton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("/html/body/my-app/layout/div[1]/div/muzeboard-create/div[3]/div/div/div[2]/div/div/button"), 40);
	}	
}

