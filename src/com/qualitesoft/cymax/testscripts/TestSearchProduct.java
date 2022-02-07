package com.qualitesoft.cymax.testscripts;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.cymax.pageobjects.HomePage;

public class TestSearchProduct extends InitializeTest {
	int i = 0;

	@Test(dataProvider = "SearchProvider")
	public void testSearchProduct(String product, String value) {
			HomePage homePage = new HomePage(driver);
			if(homePage.cymaxPopup()!=null) {
				SeleniumFunction.click(homePage.cymaxPopup());
			}
			WebElement searchTextField = homePage.searchTextField();
			WaitTool.sleep(5);
			WebElement searchButton = homePage.searchButton();

			// Enter Product Name and Make Search
			SeleniumFunction.sendKeys(searchTextField, value);
			SeleniumFunction.clickJS(driver, searchButton);
			WaitTool.sleep(15);
			String title = driver.getTitle();
			if (title.equals("The wait operation timed out")) {
				driver.navigate().refresh();
			}
			ScreenShot.takeScreenShot(driver, value);
	}

	@DataProvider(name = "SearchProvider")
	public Object[][] getDataFromDataprovider() {
		return new Object[][] {

				{ "Product1", "chairs" }, { "Product2", "wall clock" }, { "Product3", "Digital wall clock" },
				{ "Product4", "rectangular wood dining tables" }, { "Product5", "367581" } };
	}
}
