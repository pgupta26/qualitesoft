package com.qualitesoft.homesquare.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.homesquare.pageobjects.HomeSquareHomePage;


public class TestHomeSquareSearchProduct extends InitializeTest {
	int i=0;
	
   @Test(dataProvider="SearchProvider")

	public void testSearchProduct( String product,String value) {
	   
	    WebDriver driver = getDriver();
	    HomeSquareHomePage homePage = new HomeSquareHomePage(driver);
	    WaitTool.sleep(5); 
	 /*   if(driver.findElements(By.xpath("//div[@class='frel_button-close']")).size() != 0)
	    {
	    	SeleniumFunction.click(homePage.HomeSqcloseButton());	
	    }*/
	    
		//if(i==0)	
		//{
		//	SeleniumFunction.click(homePage.HomeSqcloseButton());		
		//i=1;
		//} 
				
		WebElement searchTextField=homePage.HomeSqsearchTextField();
	    WebElement searchButton=homePage.HomeSqsearchButton();
		
		//Enter Product Name and Make Search
		SeleniumFunction.sendKeys(searchTextField, value);
		SeleniumFunction.clickJS(driver, searchButton);
		WaitTool.sleep(5);
		ScreenShot.takeScreenShot(driver,value);
		
	}
	

    @DataProvider(name="SearchProvider")

    public Object[][] getDataFromDataprovider(){

        return new Object[][] {

        	{ "Product1", "Sofas" },
            { "Product2", "wall clock" },
            { "Product3", "pillow" },
            { "Product4", "Canvas" },
            { "Product5", "367581" }

            };
	
	}

}
