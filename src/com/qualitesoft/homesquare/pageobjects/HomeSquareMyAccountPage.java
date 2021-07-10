package com.qualitesoft.homesquare.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class HomeSquareMyAccountPage {

	WebDriver driver;

	public HomeSquareMyAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement bedroomLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/bedroom-furniture--PC330.htm']"),
				3600);
	}
	public WebElement bedsLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/beds--C331.htm']"), 10);
	}

	public WebElement kitchenAndDiningLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/kitchen-dining--PC588.htm']"),
				3600);
	}

	public WebElement diningChairsLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/Dining-Chairs--C635.htm']"), 10);
	}

	public WebElement outdoorLink() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//a[@href='/patio-furniture-outdoor-furniture--PC991.htm']"), 30);
	}
	public WebElement outdoorSofaLink() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/outdoor-sofas--C1344.htm']"), 30);
	}

	public WebElement orderId() {

		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath(".//*[@id='tcAccount_tp0_orderList_List_row_0']/td[1]/a"), 30);
	}

	public WebElement logOffLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='Logout.aspx']"), 10);
	}
	
	public WebElement logOutLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@id='btn-logout']"), 10);
	}

	public WebElement logoutText() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//b[text()='Logout']"), 10);
	}

	public WebElement HomeSqdiningChairsLink() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/dining-chairs--C635.htm']"), 30);
	}

	//***************Copied from cymax
	public WebElement emailTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='UserName']"), 90);
	}

	public WebElement passwordTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Password']"), 60);
	}
	public WebElement Loginbutton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@type='submit']"), 60);
	}

	public WebElement Loginbutton1() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.id("Login1"), 60);
	}

	public WebElement HomeSqlogoLoggOff() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/Portal/Account/Logout.aspx']"),30);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"form1\"]/div[3]/div[2]/div/div/div[1]/a"), 90);
	}

}
