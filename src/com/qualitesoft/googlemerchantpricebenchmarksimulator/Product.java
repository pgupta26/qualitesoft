package com.qualitesoft.googlemerchantpricebenchmarksimulator;



import java.io.File;
import java.util.ArrayList;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.googlemerchantpricebenchmarksimulator.pageobjects.LoginPage;

public class Product extends InitializeTest{
	@Test
	public void testProduct() {
		LoginPage loginPage = new LoginPage(driver);
        driver = getDriver();
 		 //Read data from excel		
  		 Xls_Reader xr=new Xls_Reader("binaries/Inputfile.xlsx");
  		 int rcnt=xr.getRowCount("products");
		 System.out.println("rcntTESTRUN:" + rcnt);
		 SeleniumFunction.clickJS(driver,loginPage.products());
		 WaitTool.sleep(12);
		 SeleniumFunction.click(loginPage.pricebench());
		 WaitTool.sleep(14);
		 ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		for(int i=2;i<=rcnt;i++)
		{
			String Category=xr.getCellData("products","Products", i).trim();
			driver.switchTo().window(newTab.get(0));//move to second tab
			SeleniumFunction.sendKeys(loginPage.category(),Category);
			ScreenShot.takeScreenShot(driver, "Category"+i);
			loginPage.category().sendKeys(Keys.ENTER);
			WaitTool.sleep(10);
			SeleniumFunction.click(loginPage.downloadicon());			
			WaitTool.sleep(30);
		
		}
		//String dir=xr.getCellData("products","Dir", 2).trim();
		String dir=xr.getCellData("Sheet2","Download", 2).trim();
			for(int i=2;i<=rcnt;i++)
			{
			    //Rename file name			
				String Category=xr.getCellData("products","Products", i).trim();				
				File file = new File(dir);
				File[] listFiles = file.listFiles(new MyFileNameFilter(Category));
				if (listFiles.length == 0) {
					System.out.println(dir + "doesn't have any file with name " + Category);
				}else {
					String filename =listFiles[0].getName();
					String old =dir+"\\"+filename;
					File oldfile =new File(old);
					File newfile =new File(dir+"\\price_report_US_"+Category+".csv");
					System.out.println(oldfile);
					if(((File) oldfile).renameTo(newfile)){
						System.out.println("Rename succesful");
					}else{
						System.out.println("Rename failed");
					}
				}	
			}
	    WaitTool.sleep(20);
	   
 
	}
}

