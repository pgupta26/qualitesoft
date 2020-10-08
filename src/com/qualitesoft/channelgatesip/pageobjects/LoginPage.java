package com.qualitesoft.channelgatesip.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.Log;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;

public class LoginPage {

	WebDriver driver;
	String pagetitle = "Channel Gate SIP";

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void loginPageDisplayed() {

		UseAssert.assertEquals(driver.getTitle(), pagetitle);
		Log.info("Page title " + pagetitle + " displayed.");
		
	}
		
	public WebElement emailField(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='email']"), 30);
		return webElement;
	}
	
 public WebElement passwordfield(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='password']"), 10);
		return webElement;
	}

	
 public WebElement signInbutton(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@type='submit']"), 10);
		return webElement;
	}
 public WebElement siplink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//ul[@class='nav nav-pills-cyan nav-pills-icons nav-pills']/li[3]//a"), 50);
	}

 public WebElement adminPortal(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//tabs[@navclass='nav-pills-cyan nav-pills-icons']/div[2]/tab[3]/div/div[3]/div[1]/div/div/div[3]/button"), 30);
		return webElement;
	}

 public WebElement availablebrand(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"brands-list\"]/div/div/div[2]/div/div[1]/h4"), 30);
		return webElement;
	}
 public WebElement scorecard(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/app/sip/scorecard']"), 30);
		return webElement;
	}
 public WebElement bestsellers(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/app/sip/bestsellers']"), 60);
		return webElement;
	}
 public WebElement geoanalysis(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/app/sip/geoanalysis']"), 30);
		return webElement;
	}
 public WebElement gapanalysis(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/app/sip/gapanalysis']"), 30);
		return webElement;
	}
 public WebElement marketing(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/app/sip/marketing']"), 30);
		return webElement;
	}
 public WebElement keywordanalysis(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/app/sip/keywordanalysis']"), 30);
		return webElement;
	}
 public WebElement GeneralSettingsClose(){
	    WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("/html/body/my-app/layout/div[1]/side-bar/div/div[2]/side-menu/div/ul/li[1]/a/p']"), 30);
		//WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='sidebar-wrapper ps ps--theme_default ps--active-y']/side-menu//div//ul//li//a//p']"), 30);
		return webElement;
	}
 public WebElement teams(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/app/sip/team']"), 30);
		return webElement;
	}
 public WebElement inviteuserBtn(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("/html/body/my-app/layout/div[1]/div/users/div[1]/div/div/div/div[1]/button"), 30);
		return webElement;
	}
 public WebElement firstname(){
		
	 WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='firstName']"), 30);
		return webElement;
	}
 public WebElement lastname(){
		
	 WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='lastName']"), 30);
		return webElement;
	}
 public WebElement companyname(){
		
	 WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='company']"), 30);
		return webElement;
	}
 public WebElement usergroup(){
		
	    WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//form[@class='ng-untouched ng-invalid ng-dirty']/div[@class='form-group select2']/span/span[1]/span/ul"), 30);
		return webElement;
	}
 public WebElement useremail(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='email']"), 30);
		return webElement;
	}
 public WebElement invitebutton(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("/html/body/my-app/layout/div[1]/div/users/div[2]/div[1]/div/div[2]/form/div[3]/button"), 30);
		return webElement;
	}
 public WebElement searchbrand(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("/html/body/my-app/layout/div[1]/div/home/div/div/div/div/div/div/div[1]/div/div/span/span[1]/span/ul/li/input"), 30);
		return webElement;
	}
 public WebElement profile(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//ul[@class='nav navbar-nav navbar-right']/li[3]"), 30);
		return webElement;
	}
 public WebElement logout(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//ul[@role='menu']/li[2]"), 30);
		return webElement;
	}
 public WebElement loginemail(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/v3/login.jsp#signin']"), 30);
		return webElement;
	}
 public WebElement email(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='many_login_email']"), 30);
		return webElement;
	}
 public WebElement passwordemail(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@type='password']"), 30);
		return webElement;
	}
 public WebElement loginbtn(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='btn btn-default submit']"), 30);
		return webElement;
	}
 public WebElement emailmailinator(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/v3/']"), 30);
		return webElement;
	}
 public WebElement searchemail(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//header[@id='header-1']//nav//div//div//div[@class='navbar-header']//div//div//input"), 30);
		return webElement;
	}
 public WebElement gobtn(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"header-1\"]/nav/div/div[1]/div[2]/div/div/span/button"), 30);
		return webElement;
	}
 public WebElement checkbox(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//tbody//tr/td[3]"), 30);
		return webElement;
	}
 public WebElement activate(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//table/tbody/tr/td/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/a"), 30);
		return webElement;
	}
 public WebElement passwordinbox(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='password']"), 30);
		return webElement;
	}
 public WebElement confirmpasswordinbox(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='confirmPassword']"), 30);
		return webElement;
	}
 public WebElement terms(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='checkbox form-group']//label//span"), 30);
		return webElement;
	}
 public WebElement register(){
		
		WebElement webElement = WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@type='submit']"), 30);
		return webElement;
	}
}
