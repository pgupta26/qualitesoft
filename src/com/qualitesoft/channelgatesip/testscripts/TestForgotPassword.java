package com.qualitesoft.channelgatesip.testscripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qualitesoft.channelgatesip.pageobjects.LoginPage;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.channelgatesip.pageobjects.Mailinator;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ReadPropertyFile;

public class TestForgotPassword extends InitializeTest{
	
	@Test(priority = 1)
	public void verifyRequiredFieldValidation(){
		LoginPage login = new LoginPage(driver);
		ReadPropertyFile rpf = new ReadPropertyFile();
		
		SeleniumFunction.click(login.forgotPasswordLink());
		WaitTool.sleep(5);
		SeleniumFunction.click(login.signInbutton());
		String emailValidation = SeleniumFunction.getText(login.validationMessage(1));
		UseAssert.assertEquals(emailValidation, rpf.getEmailValidation());
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
	public void verifyUnregisteredEmailValidation(){
		LoginPage login = new LoginPage(driver);
		ReadPropertyFile rpf = new ReadPropertyFile();
		
		SeleniumFunction.sendKeys(login.emailField(), "qatest852741@mailinator.com");
		SeleniumFunction.click(login.signInbutton());
		String emailValidation = SeleniumFunction.getText(login.incorrectValdiatonMessage(1));
		UseAssert.assertEquals(emailValidation, rpf.getForgotPasswordValidation2());
	}
	
	@Test(priority = 4)
	public void testForgotPassword(){
		LoginPage login = new LoginPage(driver);
		ReadPropertyFile rpf = new ReadPropertyFile();
		
		ScreenShot.takeScreenShot(driver, "Forgot Password Page");
		SeleniumFunction.sendKeys(login.emailField(), crusername);
		SeleniumFunction.click(login.signInbutton());
		String fpSuccessMessage = SeleniumFunction.getText(login.successMessage());
		UseAssert.assertEquals(fpSuccessMessage, rpf.getForgotPasswordSuccess());
	}

	@Test(priority = 5)
	public void verifyResetPasswordEmail(){

		SeleniumFunction.executeJS(driver, "window.open('');");
		SeleniumFunction.getCurrentWindow(driver);
		SeleniumFunction.open(driver, "https://www.mailinator.com/");

		Mailinator mailinator = new Mailinator(driver);

		SeleniumFunction.sendKeys(mailinator.searchBox(), crusername);
		WaitTool.sleep(2);
		SeleniumFunction.click(mailinator.goButton());
		WaitTool.sleep(5);
		SeleniumFunction.click(mailinator.firstMail());
		SeleniumFunction.selectFrame(driver, "html_msg_body");
		
		UseAssert.assertEquals(SeleniumFunction.getAttribute(mailinator.cgLogoImage(1), "src"), "https://media.cymaxstores.com/Images/CG/Resources/teamcg.png?h=100");
		UseAssert.assertEquals(SeleniumFunction.getText(mailinator.mailText(1)), "Channel Gate");
		UseAssert.assertEquals(SeleniumFunction.getText(mailinator.mailText(2)), "Hello Selenium_FirstName Selenium_LastName,");
		UseAssert.assertEquals(SeleniumFunction.getText(mailinator.mailText(3)), "Can't remember your password?");
		UseAssert.assertEquals(SeleniumFunction.getText(mailinator.mailText(4)), "If you didn't request this, please disregard this email.");
		UseAssert.assertEquals(SeleniumFunction.getText(mailinator.mailText(5)), "Your password won't change until you access the link above and create a new one.");
		UseAssert.assertEquals(SeleniumFunction.getText(mailinator.mailText(6)), "Regards,");
		UseAssert.assertEquals(SeleniumFunction.getAttribute(mailinator.cgLogoImage(2), "src"), "https://media.cymaxstores.com/Images/CG/Resources/teamcg.png");

		SeleniumFunction.click(mailinator.resetPasswordBtn());

		SeleniumFunction.selectParentframe(driver);
		SeleniumFunction.click(mailinator.deleteEmail());
		SeleniumFunction.closeWindow(driver);
		SeleniumFunction.getCurrentWindow(driver);
	}
	
	@Test(priority = 6)
	public void passwordRequiredValidation(){
		LoginPage login = new LoginPage(driver);
		ReadPropertyFile rpf = new ReadPropertyFile();

		SeleniumFunction.click(login.signInbutton());

		String passwordValidation = SeleniumFunction.getText(login.validationMessage(1));
		String cpasswordValidation = SeleniumFunction.getText(login.validationMessage(2));
		
		UseAssert.assertEquals(passwordValidation, rpf.getPasswordValidation());
		UseAssert.assertEquals(cpasswordValidation, rpf.getCPasswordValidation());
	}
	
	@Test(priority = 7)
	public void validPasswordValidation(){
		LoginPage login = new LoginPage(driver);
		ReadPropertyFile rpf = new ReadPropertyFile();
		
		SeleniumFunction.sendKeys(login.passwordfield(), "123");
		SeleniumFunction.click(login.signInbutton());

		String passwordValidation = SeleniumFunction.getText(login.validationMessage(1));
		
		UseAssert.assertEquals(passwordValidation, rpf.getPasswordLimitValidation1() +"\n" +rpf.getPasswordLimitValidation2()+"\n" +rpf.getPasswordLimitValidation3());
	}
	
	@Test(priority = 8)
	public void mismatchPasswordValidation(){
		LoginPage login = new LoginPage(driver);
		ReadPropertyFile rpf = new ReadPropertyFile();
		
		SeleniumFunction.sendKeys(login.passwordfield(), "QAtest123@");
		SeleniumFunction.sendKeys(login.confirmpasswordinbox(), "QAtest123!");
		SeleniumFunction.click(login.signInbutton());
		
		String passwordValidation = SeleniumFunction.getText(login.validationMessage(1));
		UseAssert.assertEquals(passwordValidation, rpf.getCpasswordMismatch());
	}
	@Test(priority = 9)
	public void resetPassword(){
		LoginPage login = new LoginPage(driver);
	
		SeleniumFunction.sendKeys(login.passwordfield(), password);
		SeleniumFunction.sendKeys(login.confirmpasswordinbox(), password);
		SeleniumFunction.click(login.signInbutton());
		WaitTool.sleep(10);
		ScreenShot.takeScreenShot(driver, "Reset Password Page");
		SeleniumFunction.closeWindow(driver);
		SeleniumFunction.getCurrentWindow(driver);
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
