package com.qualitesoft.cymaxAdmin.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymaxAdmin.pageobjects.RefundPage;

public class TestRefund extends InitializeTest{

	@Test
	public void submitRefund(){
		try{
			RefundPage refundpage = new RefundPage(driver);
			
			SeleniumFunction.click(refundpage.clickRefundTab());
			SeleniumFunction.click(refundpage.clickCheckbox());
			SeleniumFunction.selectByVisibleText(refundpage.selectRefundReason(), "Credit");
			WaitTool.sleep(20);
			SeleniumFunction.selectByVisibleText(refundpage.selectCategory(), "Carrier error");
			WaitTool.sleep(10);
			SeleniumFunction.selectByVisibleText(refundpage.selectSubcategory(), "Delivery issues");
			WaitTool.sleep(10);
			SeleniumFunction.sendKeys(refundpage.setBalanceSuggested(), "100");
			SeleniumFunction.sendKeys(refundpage.setComment(), "Test Refund Comment");
			SeleniumFunction.click(refundpage.clickSubmitButton());
			SeleniumFunction.scrollIntoView(driver, refundpage.acceptRecoveryWarning());
			SeleniumFunction.click(refundpage.acceptRecoveryWarning());
		}catch(Exception e){
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
}
