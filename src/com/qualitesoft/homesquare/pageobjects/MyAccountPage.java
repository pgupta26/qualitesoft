package com.qualitesoft.homesquare.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;

public class MyAccountPage {

	WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement amazonPayBtn() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//img[@id='OffAmazonPaymentsWidgets0']"),60);
	}
	public void bedLink() {
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/beds--p1.htm']"), 10));
	}
	public void murphyBeds() {
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/beds--C331-10137.htm']"), 10));
	}
	public WebElement bedLink2() {
		String href= driver.findElement(By.xpath("//span[text()='Beds']//parent::a")).getAttribute("href");
		System.out.println(href.substring(href.indexOf("/beds")));
		String hrefBed= href.substring(href.indexOf("/beds"));
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href=" + hrefBed + "]"), 20);
	}

	public WebElement kitchenAndDiningLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/kitchen-dining--PC588.htm']"),10);
	}

	public WebElement furniturelink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/Furniture--PC100078.htm']"), 10);
	}


	public WebElement diningChairsLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/Dining-Chairs--C635.htm' ]"), 10);
	}
	public WebElement HomeSqdiningChairsLink() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/dining-chairs--C635.htm']"), 30);
	}
	public WebElement orderId() {

		return WaitTool.waitForElementPresentAndDisplay(driver,By.xpath(".//*[@id='tcAccount_tp0_orderList_List_row_0']/td[1]/a"), 50);
		//return WaitTool.waitForElementPresentAndDisplay(driver,By.xpath(".//*[@href='javascript:orderClicked('8A7DD619-16ED-424D-8630-6E46A9DAEAD0;0')"), 30);
	}

	public WebElement logOffLink() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/Portal/Account/Logout.aspx']"), 30);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"btn-logout\"]"), 60);
	}
	public WebElement HomeSqlogoLoggOff() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/Portal/Account/Logout.aspx']"),30);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"form1\"]/div[3]/div[2]/div/div/div[1]/a"), 90);
	}
	public WebElement HomeSqlogOffLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='signout-action logSignout']"), 90);
	}
	public WebElement logoutText() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//p[@class='margin-bottom-20 alert alert-success']"), 90);
	}
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
}
