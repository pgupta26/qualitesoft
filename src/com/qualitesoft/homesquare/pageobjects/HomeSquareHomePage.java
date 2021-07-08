package com.qualitesoft.homesquare.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class HomeSquareHomePage {

	WebDriver driver;

	public HomeSquareHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement myAccountLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath
				("//a[@href='/MyAccount/Default.aspx']"), 10);
	}


	public WebElement searchTextField() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[contains(@id,'searchTextBox')]"), 10);
	}

	public WebElement searchField(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='Search']"), 60);
	}
	//*[@id="Under$250"]

	public WebElement searchButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='frm']/div/span/button"), 10);
	}
	public WebElement searchButton1(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@id='btn-top-search']"), 60);
	}

	public WebElement homeLink() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@src='/images/homesquare-logo.png' or @href='http://qa.homesquare.com']"), 10);
	}

	public WebElement diningChairsLink() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/kitchen-dining--PC588.htm']"), 10);
	}

	public WebElement diningChairs() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/Dining-Chairs--C635.htm']"), 10);
	}

	public WebElement sortDropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='filter-dropdown' or @class='form-control input-sm spacer-mobile select-sort']"), 10);
	}

	public WebElement sortDropdownhigh() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*//*[@id='filter-dropdown']/option[6]"), 10);
	}
	public WebElement listView() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='list']"), 10);
	}

	public WebElement gridView() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='grid']"), 10);
	}

	public WebElement under$250Filter() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='collapsePrice']/ul/li[1]/label"), 10);
	}

	public WebElement armChair() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='collapseDesign']/ul/li[1]/label"), 10);
	}

	public WebElement banquette() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='collapseDesign']/ul/li[2]/label"), 10);
	}


	//*****************Random CC popup***********
	public WebElement closePopupWrapper(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[contains(@id,'pop-section')]//a)[1]") , 10);
	}

	public boolean closePopupWrapperStatus(){
		return WaitTool.isElementPresentAndDisplay(driver,  By.xpath("(//div[contains(@id,'pop-section')]//a)[1]"));
	}
	//*****************Copied from cymax***********
	public WebElement HomeSqmyAccountLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath
				("//*[@id=\"my-account-btn\"]"), 15);
	}

	public WebElement HomeSqmyOrder() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath
				("//a[@href='/MyAccount/Default.aspx?ti=0']"), 30);
	}	


	public WebElement signUpLink() {
		return WaitTool.waitForElementPresentAndDisplay(driver,
				By.xpath("//a[@href='/Components/MuzeBoard/loginSignup.aspx']"), 10);
	}

	public WebElement emailTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='body_Email']"), 10);
	}

	public WebElement passowrdTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='body_Password']"), 10);
	}

	public WebElement signUpButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@id='signUpBtn']"), 10);
	}

	public WebElement describeBestButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@id='body_btnProfessional']"), 30);
	}

	public WebElement HomeSqdiningChairs() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@href='/dining-chairs--C635.htm']"), 30);
	}

	public WebElement homegridView() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='grid']"), 10);

	}	
	public WebElement homelistView() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='list']"), 10);

	}	

	public WebElement HomeSqsortDropdown() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='filter-dropdown']"), 30);
	}
	public WebElement HomeSqsearchTextField() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[contains(@name,'Search')]"), 60);

	}	
	public WebElement HomeSqsearchButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//i[@class='pe-7s-search']"), 10);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-main logSearch hidden-xms']"), 60);
	}	
	public WebElement homesquareLogo() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//img[@src='/images/homesquare-logo.png'])[1]"), 10);
	}
	
	public WebElement emailSigninTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='UserName']"), 10);
	}
	
	public WebElement signInLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/MyAccount/Login.aspx']"), 30);
	}
	
	public WebElement passowrdSigninTextbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Password']"), 10);
	}
	
	public WebElement designerCheckbox() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='chkIsDesigner']"), 10);
	}
	
	public WebElement loginButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath(".//*[@id='Login1']"), 10);
	}
	
}
