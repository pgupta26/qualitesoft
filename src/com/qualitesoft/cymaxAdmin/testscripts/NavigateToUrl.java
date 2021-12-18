package com.qualitesoft.cymaxAdmin.testscripts;

import org.testng.annotations.Test;
import com.qualitesoft.core.InitializeTest;

public class NavigateToUrl extends InitializeTest{

	@Test
	public void navigateToUrl(){		
		String url = "http://qa-adminportal.cymax.com/orderdetail.aspx?orderid={orderId}&cancelreturn_display=true&Details_Display=true&Transactions_Display=true&Bills_Display=true&HomeDirect_Display=true&Claim_Display=true&CM_Display=true&Rep_Display=true&call=";
		driver.navigate().to(url.replace("{orderId}", testData));
	}
}
