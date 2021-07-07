package com.qualitesoft.freightclub.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class ManagerOrderPage {
	
	WebDriver driver;

	public ManagerOrderPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement manageOrdersLink() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[contains(@href,'/Order/Index')]"), 30);
	}
	
	public WebElement ExpandMenupage() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@title='Click to retract or expand the page menu']"), 30);
	}
	
	public WebElement ViewDetail() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[text()='Detail'])[1]"), 30);
	}
	
	public void orderIDFilter(String orderid) {
		SeleniumFunction.sendKeys(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@ref='eColumnFloatingFilter'])[1]"), 10), orderid);
	}
	
	public WebElement ActionButton() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[@class='btn btn-primary btn-xs dropdown-toggle'])[1]"), 30);
	}
	
	public void billOfLoadingPdf() {
		SeleniumFunction.clickJS(driver,WaitTool.waitForElementPresentAndDisplay(driver, By.linkText("Download Bill of Lading(s) - PDF"), 10));
	}
	
	public boolean requestCancellation() {
		return WaitTool.isElementPresentAndDisplay(driver, By.xpath("//a[text()='Request Cancellation']"));
	}
	
	public WebElement clone() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[text()='Clone']"), 30);
	}
	
	public WebElement customerPONumber() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.id("poNumber"), 30);
	}
	
	public WebElement cloneNow() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"cloneModal\"]/div/div/form/div[2]/button[2]"), 30);
	}
	
	public WebElement customerPO() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div[1]/div[4])[1]"), 30);
	}
	
	public WebElement reQuote() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[text()='Re-Quote']"), 30);
	}
	
	public WebElement notQuoted() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.id("incompleteOrders"), 30);
	}
	
	public WebElement customerPO_NotQuoted() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div[1]/div[3])[3]"), 30);
	}
	
	public WebElement openQuotes() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='#quickOrders']"), 30);
	}
	
	public WebElement orderIdFilter() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"center\"]/div/div[1]/div[3]/div/div[2]/div[2]/div[1]/div/input"), 30);
	}
	
	public WebElement quotedPrice() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='quickOrders']/descendant::div[@class='ag-body-container']/div/div[6]"), 30);
	}
	
	public WebElement actions() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div[1]/div[7]/div/button"), 30);
	}
	
	public WebElement book() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div[1]/div[7]/div/ul/li[1]"), 30);
	}
	
	public WebElement delete() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"center\"]/div/div[4]/div[3]/div/div/div[1]/div[7]/div/ul/li[2]"), 30);
	}
	
	public WebElement openQuotesActions() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='center']/div/div[4]/div[3]/div/div/div[1]/div[9]/div/button"), 30);
	}
	
	public WebElement openQuotesBook() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='center']/div/div[4]/div[3]/div/div/div[1]/div[9]/div/ul/li[2]/a"), 30);
	}
	
	
	
}
