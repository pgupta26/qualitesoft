package com.qualitesoft.cymax.testscripts;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymax.pageobjects.HomePage;

public class TestTopSellingProductListPrice extends InitializeTest {
	
	@Test
	public void testTopSellingProductListPrice() {
		
			HomePage homepage = new HomePage(driver);
			if(homepage.cymaxPopup()!=null) {
				SeleniumFunction.click(homepage.cymaxPopup());
			}
			
			//click on Home Office navigation menu
			SeleniumFunction.click(homepage.homeOfficeLink());
			
			//Check visibility of list price for each top selling product
			WaitTool.sleep(30);
			List<WebElement> elements = driver.findElements(By.xpath("//div[@id='door_crashers']/figure/div/span[2]"));
			for(WebElement element:elements) {
				if(element.isDisplayed()) {
					Assert.assertNotEquals(element.getText(), "$0.00");
				}
			}
			
			//Check visibility of save percentage for each top selling product
			List<WebElement> productsSavePercent = driver.findElements(By.xpath("//div[@id='door_crashers']/figure/div/p"));
			for(WebElement productSavePercent:productsSavePercent) {
				if(productSavePercent.isDisplayed()) {
					Assert.assertNotEquals(productSavePercent.findElement(By.xpath(".//span")).getText(), "INFINITY");
				}
			}
	}
}
