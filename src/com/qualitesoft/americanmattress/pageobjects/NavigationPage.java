package com.qualitesoft.americanmattress.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class NavigationPage {

	WebDriver driver;

	public NavigationPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement mattressLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[contains(@href,'/catalog/')]"), 60);
	}
	public WebElement furnitureLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"display-nav-bar\"]/ul/li[1]/a')]"), 60);
	}

}
