package com.qualitesoft.channelgatesip.testscripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qualitesoft.channelgatesip.pageobjects.LoginPage;
import com.qualitesoft.channelgatesip.pageobjects.ProductListing;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ReadPropertyFile;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;

public class TestLogin extends InitializeTest{ 
	
	@Test(priority = 1)
	public void verifyRequiredFieldValidation(){
		SeleniumFunction.get(driver, URL);
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "Login Page");
		LoginPage login = new LoginPage(driver);
		ReadPropertyFile rpf = new ReadPropertyFile();
		
		SeleniumFunction.click(login.signInbutton());
		String emailValidation = SeleniumFunction.getText(login.validationMessage(1));
		String passwordValidation = SeleniumFunction.getText(login.validationMessage(2));
		
		UseAssert.assertEquals(emailValidation, rpf.getEmailValidation());
		UseAssert.assertEquals(passwordValidation, rpf.getPasswordValidation());
	}
	
	@Test(priority = 2, dataProvider="InvalidEmailFormat")
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
		
		SeleniumFunction.sendKeys(login.emailField(), "qatest852741@mailinator.com");
		SeleniumFunction.sendKeys(login.passwordfield(), password);
		SeleniumFunction.click(login.signInbutton());
		String invalidCredentials= SeleniumFunction.getText(login.incorrectValdiatonMessage(1));
		
		UseAssert.assertEquals(invalidCredentials, rpf.getInvalidCredentialsValidation());
	}
	@Test(priority = 4)
	public void testInstance(){
		
		LoginPage login = new LoginPage(driver);
		ProductListing productListing = new ProductListing(driver);
		
		SeleniumFunction.sendKeys(login.emailField(), emailAddress);
		SeleniumFunction.sendKeys(login.passwordfield(), password);
		ScreenShot.takeScreenShot(driver, "Login filled details");
		SeleniumFunction.click(login.signInbutton());
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver, "After Login ");	
		String title = SeleniumFunction.getText(productListing.dialogTitle());
		UseAssert.assertEquals(title, "Welcome to Channel Gate");
		SeleniumFunction.click(productListing.skipTourBtn());
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
