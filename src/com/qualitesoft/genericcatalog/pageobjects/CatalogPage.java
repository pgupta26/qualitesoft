package com.qualitesoft.genericcatalog.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class CatalogPage {

	WebDriver driver;

	public CatalogPage(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> navigationlinkList() {

		return WaitTool.waitForElementsPresentAndDisplay(driver,
				By.xpath(".//*[@id='display-nav-bar']//a[@class='dropdown-toggle']"), 30);
	}

	public List<WebElement> navigationsublinkList(int i) {

		return WaitTool.waitForElementsPresentAndDisplay(driver,
				By.xpath("((.//*[@id='display-nav-bar']//a[@class='dropdown-toggle'])[" + i
						+ "]/parent::li//a[contains(@href,'/catalog/')])"),
				30);
	}

	public WebElement navigationLink(int i) {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("(.//*[@id='display-nav-bar']//a[@class='dropdown-toggle'])[" + i + "]"), 30);
	}

	public boolean navigationSubLinkList(int i) {

		return WaitTool.isElementPresentAndDisplay(driver,
				By.xpath("((.//*[@id='display-nav-bar']//a[@class='dropdown-toggle'])[" + i
						+ "]/parent::li//a[contains(@href,'/catalog/')])"));
	}

	public WebElement navigationsubLink(int i, int k) {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("((.//*[@id='display-nav-bar']//a[@class='dropdown-toggle'])[" + i
						+ "]/parent::li//a[contains(@href,'/catalog/')])[" + k + "]"),
				30);
	}

	public List<WebElement> footerCatalogLink() {

		return WaitTool.waitForElementsPresentAndDisplay(driver,
				By.xpath("(html/body/footer//a[contains(@href,'/pages/') or contains (@href,'/catalog/')])"), 30);
	}

	public WebElement footerCatalogLink(int i) {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("(html/body/footer//a[contains(@href,'/pages/') or contains (@href,'/catalog/')])[" + i + "]"), 30);
	}

	public List<WebElement> footerPagesLink() {

		return WaitTool.waitForElementsPresentAndDisplay(driver,
				By.xpath("(html/body/footer//a[contains(@href,'/pages/') or contains (@href,'/catalog/')])"), 30);
	}

	public WebElement footerPagesLink(int i) {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("(html/body/footer//a[contains(@href,'/pages/')])[" + i + "]"), 30);
	}

}
