package com.qualitesoft.bush.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qualitesoft.bush.pageobjects.HomePage;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;


public class TestSearchProduct extends InitializeTest {
	int i=0;
	
  @Test(dataProvider="SearchProvider")

	public void testSearchProduct( String product,String value) {
	    
	    WebDriver driver = getDriver();
		HomePage homePage = new HomePage(driver);
		
		//SeleniumFunction.click(homePage.bushicon());
		driver.navigate().to("http://qa-bushfurniturecollection.constantretail.com/");
	/*	if(i==0)	
		{
		SeleniumFunction.click(homePage.noThanks());
		SeleniumFunction.click(homePage.searchIconButton()); //CLICK ON SEARCH ICON ONLY ONCE
		i=1;
		} */
		
		WaitTool.sleep(5);
		WebElement searchTextField=homePage.searchTextField();
		WaitTool.sleep(5);
		WebElement searchButton=homePage.searchButton();
		
		//Enter Product Name and Make Search
		SeleniumFunction.sendKeys(searchTextField, value);
		SeleniumFunction.clickJS(driver, searchButton);
		WaitTool.sleep(15);
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("window.scrollBy(0,250)", "");
		String title=driver.getTitle();
		if(title.equals("The wait operation timed out")) {
			driver.navigate().refresh();
		}
		ScreenShot.takeScreenShot(driver,value);
		
	}
	

    @DataProvider(name="SearchProvider")

    public Object[][] getDataFromDataprovider(){

        return new Object[][] {

                { "Product1", "chairs" },
                { "Product2", "Table" },
                { "Product3", "Bookcases" },
                { "Product4", "TV stands" },
                { "Product5", "CH57505K" }
          

            };
	
	}

}
