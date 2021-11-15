package com.qualitesoft.cymaxAdmin.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.cymaxAdmin.pageobjects.HomePage;
import com.qualitesoft.cymaxAdmin.pageobjects.SearchOrderPage;

public class TestSearchOrderId extends InitializeTest{

	@Test
	public void searchOrderId(){
		try{
			HomePage homepage = new HomePage(driver);
			SearchOrderPage orderPage = new SearchOrderPage(driver);
			
			SeleniumFunction.hoverAction(driver, homepage.hoverOperationsTab());
			SeleniumFunction.click(homepage.clickSearchOrdersOption());
			
			SeleniumFunction.sendKeys(orderPage.setOrderId(), "");
			SeleniumFunction.click(orderPage.clickFindBtn());
			
			SeleniumFunction.click(orderPage.clickFirstOrderId());
			try{
				SeleniumFunction.getCurrentWindow(driver);
			}catch(Exception e){
				SeleniumFunction.closeWindow(driver);
				SeleniumFunction.getCurrentWindow(driver);
				Assert.fail();
			}
			
			String url = "http://qa-adminportal.cymax.com/orderdetail.aspx?orderid={orderId}&cancelreturn_display=true&Details_Display=true&Transactions_Display=true&Bills_Display=true&HomeDirect_Display=true&Claim_Display=true&CM_Display=true&Rep_Display=true&call=";
			driver.navigate().to(url.replace("{orderId}", testData));
		}catch(Exception e){
			Assert.fail();
		}
	}
}
