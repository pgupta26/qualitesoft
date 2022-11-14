package com.qualitesoft.channelgatesip.testscripts;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qualitesoft.channelgatesip.pageobjects.CommonPage;
import com.qualitesoft.channelgatesip.pageobjects.LoginPage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ReadPropertyFile;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;

public class TestLoginValidations extends InitializeTest {

	@Test(priority = 1)
	public void verifyRequiredFieldValidation(){
		SeleniumFunction.get(driver, URL);
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "Login Page");
		LoginPage login = new LoginPage(driver);
		ReadPropertyFile rpf = new ReadPropertyFile();
		
		SeleniumFunction.sendKeys(login.emailField(), Keys.TAB.toString());
		SeleniumFunction.sendKeys(login.passwordfield(), Keys.TAB.toString());
		
		String emailValidation = SeleniumFunction.getText(login.validationMessage(1));
		String passwordValidation = SeleniumFunction.getText(login.validationMessage(2));
		
		UseAssert.assertEquals(emailValidation, rpf.getEmailValidation());
		UseAssert.assertEquals(passwordValidation, rpf.getPasswordValidation());
	}
	
	@Test(priority = 2, dataProvider="InvalidEmailFormat", enabled = false)
	public void verifyInvalidEmailsValidation(String email, String value){
		
		LoginPage login = new LoginPage(driver);
		ReadPropertyFile rpf = new ReadPropertyFile();
		
		SeleniumFunction.sendKeys(login.emailField(), value);
		SeleniumFunction.click(login.signInbutton());
		String emailValidation = SeleniumFunction.getText(login.validationMessage(1));
		UseAssert.assertEquals(emailValidation, rpf.getInvalidEmailValidation());
	}
	
	@Test(priority = 3)
	public void verifyInvalidCredentialsValidation(){
		LoginPage login = new LoginPage(driver);
		ReadPropertyFile rpf = new ReadPropertyFile();
		CommonPage commonPage = new CommonPage(driver);
		
		SeleniumFunction.sendKeys(login.emailField(), "qatest852741@mailinator.com");
		SeleniumFunction.sendKeys(login.passwordfield(), password);
		SeleniumFunction.click(login.signInbutton());
		String invalidCredentials= SeleniumFunction.getText(commonPage.getToastMessageText(2));
		
		UseAssert.assertEquals(invalidCredentials, rpf.getInvalidCredentialsValidation());
	}
	
	@DataProvider(name="InvalidEmailFormat")

    public Object[][] getDataFromDataprovider(){

        return new Object[][] {

        	{ "email1", "qatest" },
            { "email2", "qatest@" },
            { "email3", "qatest@com" },
            { "email4", "qatest@test..com" },
            { "email5", "qatest@@test.com" },
            { "email6", "qatest@.test.com" },
            { "email7", "qatest.@test.com" },
            { "email8", "qa..test@test.com" },
            { "email9", ".qatest@test.com" },
            { "email10", "qatest@test.com." }
            };
	
	}
}
