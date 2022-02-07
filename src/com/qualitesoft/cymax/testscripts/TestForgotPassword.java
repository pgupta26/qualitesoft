package com.qualitesoft.cymax.testscripts;

import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.cymax.pageobjects.HomePage;
import com.qualitesoft.cymax.pageobjects.LoginPage;

public class TestForgotPassword extends InitializeTest {
	
	@Test
	public void testForgotPassword(){
				
		HomePage homePage = new HomePage(driver);
		if(homePage.cymaxPopup()!=null) {
			SeleniumFunction.click(homePage.cymaxPopup());
		}
		
		SeleniumFunction.click(homePage.myAccountLink());
		LoginPage loginPage = new LoginPage(driver);
		SeleniumFunction.click(loginPage.forgotPassword());
		SeleniumFunction.sendKeys(loginPage.recoveryEmail(), emailAddress);
		SeleniumFunction.click(loginPage.sendPasswordResetRequest());
		UseAssert.assertEquals(SeleniumFunction.getText(loginPage.newPasswordSuccessMessage()).trim(), "A new password will be emailed to you. It could take up to 5 minutes for the email to go out.");
	
		/*SeleniumFunction.executeJS(driver, "window.open('');");
		SeleniumFunction.getCurrentWindow(driver);
	    	SeleniumFunction.open(driver, "http://www.yopmail.com/en/");
	    	YopMailPage yopMailPage = new YopMailPage(driver);
	    	yopMailPage.emailAddress(emailAddress);
	    	yopMailPage.checkInbox();
	    	SeleniumFunction.selectFrame(driver, "ifinbox");
	    		SeleniumFunction.click(yopMailPage.selectEmail());
	    	SeleniumFunction.selectParentframe(driver);
	    	SeleniumFunction.selectFrame(driver, "ifmail");
	    		WaitTool.sleep(2);
	    		SeleniumFunction.click(yopMailPage.resetPasswordLink());
			SeleniumFunction.selectParentframe(driver);
	    	SeleniumFunction.closeWindow(driver);
	    SeleniumFunction.getCurrentWindow(driver);
	    
	    SeleniumFunction.sendKeys(loginPage.newPassword(), "CymaxQA4321");
	    SeleniumFunction.sendKeys(loginPage.confirmNewPassword(), "CymaxQA4321");
	    SeleniumFunction.click(loginPage.newPasswordSubmit());*/
	    
	}
}
