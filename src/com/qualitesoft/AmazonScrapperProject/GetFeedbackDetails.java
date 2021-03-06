package com.qualitesoft.AmazonScrapperProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.WaitTool;
import com.qualitesoft.core.Xls_Reader;
import com.qualitesoft.AmazonScrapperProject.pageobjects.LoginPage;

public class GetFeedbackDetails extends InitializeTest  {
	java.util.List<WebElement> feedbackdate,rating,orderId,comments;
	Xls_Reader xr,xr2,xr3,xr4,xr5,xr6,xr7,xr8;
	JavascriptExecutor jse;
	LoginPage loginPage = new LoginPage(driver);
	WebElement text;
	int j=2;

	String dbUrl,username1,password1;
	Connection con = null;
	Statement stmt=null;
	boolean gotResults ;
	ResultSet rs = null;
	String DBUser,DBPassword,feedid;
	int FeedId=0;
	
	@Test
	public void testGetPriceDetails() throws ClassNotFoundException, SQLException {


		driver = getDriver();
		jse = (JavascriptExecutor) driver;

		//Read data from excel		
		xr=new Xls_Reader("binaries/AmazonScrapperFeedback.xlsx");	
		/*xr2=new Xls_Reader("binaries/AmazonScrapper_2.xlsx");	
  		xr3=new Xls_Reader("binaries/AmazonScrapper_3.xlsx");	
  		xr4=new Xls_Reader("binaries/AmazonScrapper_4.xlsx");	
  		xr5=new Xls_Reader("binaries/AmazonScrapper_5.xlsx");	
  		xr6=new Xls_Reader("binaries/AmazonScrapper_6.xlsx");	
  		xr7=new Xls_Reader("binaries/AmazonScrapper_7.xlsx");
  		xr8=new Xls_Reader("binaries/AmazonScrapper_8.xlsx");*/

		jse.executeScript("window.scrollBy(0,250)", "");
		WaitTool.sleep(5);
		//getDetails();


		LoginPage loginPage = new LoginPage(driver);

		// pageTotal =(WebElement) driver.findElements(By.xpath("//*[@id=\"sc-content-container\"]/div/my-app/div/div/home/div/div[2]/kat-tabs/kat-tab[1]"));
		int Total =Integer.parseInt(loginPage.pageTotal().getText().toString());  
		System.out.println("Total:" + Total);
		// Total = 3370;
		for(int k=0;k<=Total-1;k++) 	
		{


			//WebElement clickIcon =(WebElement) driver.findElements(By.xpath("//kat-tab[@label=\"All ratings\"]/feedback-list/kat-pagination/ul/li[8]"));

			if(k==0) {
				System.out.println("k:" + k);
			}else {
				jse.executeScript("window.scrollBy(0,250)", "");
				System.out.println("k:" + k);
				loginPage.clickIcon().click();
				WaitTool.sleep(7);
			}

			feedbackdate= driver.findElements(By.xpath("//*[@id=\"sc-content-container\"]/div/my-app/div/div/home/div/div[2]/kat-tabs/kat-tab[1]/feedback-list/kat-table/kat-table-body/kat-table-row/kat-table-cell[1]"));
			rating= driver.findElements(By.xpath("//*[@id=\"sc-content-container\"]/div/my-app/div/div/home/div/div[2]/kat-tabs/kat-tab[1]/feedback-list/kat-table/kat-table-body/kat-table-row/kat-table-cell[2]"));	
			orderId= driver.findElements(By.xpath("//*[@id=\"sc-content-container\"]/div/my-app/div/div/home/div/div[2]/kat-tabs/kat-tab[1]/feedback-list/kat-table/kat-table-body/kat-table-row/kat-table-cell[3]/kat-link/a"));	
			comments= driver.findElements(By.xpath("//*[@id=\"sc-content-container\"]/div/my-app/div/div/home/div/div[2]/kat-tabs/kat-tab[1]/feedback-list/kat-table/kat-table-body/kat-table-row/kat-table-cell[4]/div/p"));	


			int productcount= feedbackdate.size();
			System.out.println("feedback:" + productcount);
			System.out.println("j:" + j);
			for (int i=0; i<=productcount-1; i++)
			{

				String feedback_date = feedbackdate.get(i).getText();
				String feedback_rating =  rating.get(i).getText();
				String feedback_orderId = orderId.get(i).getText();
				String feedback_comments = comments.get(i).getText();


				/*    		    	
 	    	int row=xr.getRowCount("ProductId");
 	    	System.out.println(row+ " row");
 	    	if(row>1) {
		 	    	for(int k=1;k<=row-1;k++) {

		 	    		String pid=xr.getCellData("ProductId", "ProductId", k);
		 	    		System.out.println(id[1]+ " id[1]");
		 	    		System.out.println(pid+ " pid");
			 	    		if(id[1].equals(pid)) {
			 	    			System.out.println(id[1]+ " already exist");
			 	    		}else {			 	    			
			 	    	    	xr.setCellData("ProductId", "ProductId", j, id[1]);
			 	    	    	xr.setCellData("ProductId", "Referral Fee Discount", j, Rfee[0]);
			 	    	    	xr.setCellData("ProductId", "Retail Threshold", j, getReplace(retail.get(i).getText(),"when sold at or below $",""));
			 	    	    	xr.setCellData("ProductId", "End Date", j, Rfee1[1]);
			 	    	    	//xr.setCellData("ProductId", "End Date", j, getDate(Rfee1[1].trim()));
			 	    	    	xr.setCellData("ProductId", "Your Price", j, getReplace(pricevalue[0],"$",""));
			 	    		}


		 	    		}
 	    	}else {*/
				//System.out.println("price:" + getReplace(pricevalue[0],"$",""));
				xr.setCellData("ProductId", "Date", j, feedback_date);
				xr.setCellData("ProductId", "Rating", j, feedback_rating);
				xr.setCellData("ProductId", "Order ID", j, feedback_orderId);
				xr.setCellData("ProductId", "Comments", j, feedback_comments);
				j++;
			}
			//j++;

			jse.executeScript("window.scrollBy(0,-350)", "");	    
		}	    




		//}
		/*   j=2;
 	    for (int i=301; i<=600; i++)
 		{

 	    	String id[] = productid.get(i).getText().split("\\r?\\n");
 	    	String Rfee[] = fee.get(i).getText().split("%");
 	    	String Rfee1[] = fee.get(i).getText().split("through");
 	    	String pricevalue[] = price.get(i).getText().split("\\r?\\n");

 	    	int row=xr.getRowCount("ProductId");
 	    	System.out.println(row+ " row");

 	    	if(row>301) {
		 	    	for(int k=301;k<=row-1;k++) {

		 	    		String pid=xr2.getCellData("ProductId", "ProductId", k);
		 	    		System.out.println(id[1]+ " id[1]");
		 	    		System.out.println(pid+ " pid");
			 	    		if(id[1].equals(pid)) {
			 	    			System.out.println(id[1]+ " already exist");
			 	    		}else {
			 	    	    	xr2.setCellData("ProductId", "ProductId", j, id[1]);
			 	    	    	xr2.setCellData("ProductId", "Referral Fee Discount", j, Rfee[0]);
			 	    	    	xr2.setCellData("ProductId", "Retail Threshold", j, getReplace(retail.get(i).getText(),"when sold at or below $",""));
			 	    	    	//xr2.setCellData("ProductId", "End Date", j, getDate(Rfee1[1]).trim());
			 	    	    	xr2.setCellData("ProductId", "End Date", j, Rfee1[1]);
			 	    	    	xr2.setCellData("ProductId", "Your Price", j, getReplace(pricevalue[0],"$",""));
			 	    		}


		 	    		}
 	    	}else {


 	    	//System.out.println("price:" + getReplace(pricevalue[0],"$",""));
 	    	xr2.setCellData("ProductId", "ProductId", j, id[1]);
 	    	xr2.setCellData("ProductId", "Referral Fee Discount", j, Rfee[0]);
 	    	xr2.setCellData("ProductId", "Retail Threshold", j, getReplace(retail.get(i).getText(),"when sold at or below $",""));
 	    	//xr2.setCellData("ProductId", "End Date", j, getDate(Rfee1[1]).trim());
 	    	xr2.setCellData("ProductId", "End Date", j, Rfee1[1]);
 	    	xr2.setCellData("ProductId", "Your Price", j, getReplace(pricevalue[0],"$",""));
 	    	}
 	    	j++;
 		}
 	   j=2;
 	    for (int i=601; i<=900; i++)
 		{

 	    	String id[] = productid.get(i).getText().split("\\r?\\n");
 	    	String Rfee[] = fee.get(i).getText().split("%");
 	    	String Rfee1[] = fee.get(i).getText().split("through");
 	    	String pricevalue[] = price.get(i).getText().split("\\r?\\n");
	    	int row=xr.getRowCount("ProductId");

 	    	System.out.println(row+ " row");
 	    	if(row>601) {
		 	    	for(int k=601;k<=row-1;k++) {

		 	    		String pid=xr3.getCellData("ProductId", "ProductId", k);
		 	    		System.out.println(id[1]+ " id[1]");
		 	    		System.out.println(pid+ " pid");
			 	    		if(id[1].equals(pid)) {
			 	    			System.out.println(id[1]+ " already exist");
			 	    		}else {
			 	    	    	xr3.setCellData("ProductId", "ProductId", j, id[1]);
			 	    	    	xr3.setCellData("ProductId", "Referral Fee Discount", j, Rfee[0]);
			 	    	    	xr3.setCellData("ProductId", "Retail Threshold", j, getReplace(retail.get(i).getText(),"when sold at or below $",""));
			 	    	    	xr3.setCellData("ProductId", "End Date", j, Rfee1[1]);
			 	    	    	xr3.setCellData("ProductId", "Your Price", j, getReplace(pricevalue[0],"$",""));
			 	    		}


		 	    		}
 	    	}else {


 	    	//System.out.println("price:" + getReplace(pricevalue[0],"$",""));
 	    	xr3.setCellData("ProductId", "ProductId", j, id[1]);
 	    	xr3.setCellData("ProductId", "Referral Fee Discount", j, Rfee[0]);
 	    	xr3.setCellData("ProductId", "Retail Threshold", j, getReplace(retail.get(i).getText(),"when sold at or below $",""));
 	    	xr3.setCellData("ProductId", "End Date", j, Rfee1[1]);
 	    	xr3.setCellData("ProductId", "Your Price", j, getReplace(pricevalue[0],"$",""));
 	    	}
 	    	j++;
 		}
 	   j=2;
 	    for (int i=901; i<=1200; i++)
 		{

 	    	String id[] = productid.get(i).getText().split("\\r?\\n");
 	    	String Rfee[] = fee.get(i).getText().split("%");
 	    	String Rfee1[] = fee.get(i).getText().split("through");
 	    	String pricevalue[] = price.get(i).getText().split("\\r?\\n");

	    	int row=xr.getRowCount("ProductId");
 	    	System.out.println(row+ " row");
 	    	if(row>901) {
		 	    	for(int k=901;k<=row-1;k++) {

		 	    		String pid=xr4.getCellData("ProductId", "ProductId", k);
		 	    		System.out.println(id[1]+ " id[1]");
		 	    		System.out.println(pid+ " pid");
			 	    		if(id[1].equals(pid)) {
			 	    			System.out.println(id[1]+ " already exist");
			 	    		}else {
			 	    	    	xr4.setCellData("ProductId", "ProductId", j, id[1]);
			 	    	    	xr4.setCellData("ProductId", "Referral Fee Discount", j, Rfee[0]);
			 	    	    	xr4.setCellData("ProductId", "Retail Threshold", j, getReplace(retail.get(i).getText(),"when sold at or below $",""));
			 	    	    	xr4.setCellData("ProductId", "End Date", j, Rfee1[1]);
			 	    	    	xr4.setCellData("ProductId", "Your Price", j, getReplace(pricevalue[0],"$",""));
			 	    		}


		 	    		}
 	    	}else {


 	    	//System.out.println("price:" + getReplace(pricevalue[0],"$",""));
 	    	xr4.setCellData("ProductId", "ProductId", j, id[1]);
 	    	xr4.setCellData("ProductId", "Referral Fee Discount", j, Rfee[0]);
 	    	xr4.setCellData("ProductId", "Retail Threshold", j, getReplace(retail.get(i).getText(),"when sold at or below $",""));
 	    	xr4.setCellData("ProductId", "End Date", j, Rfee1[1]);
 	    	xr4.setCellData("ProductId", "Your Price", j, getReplace(pricevalue[0],"$",""));

 	    	}
 	    	j++;
 		}
 	   j=2;
 	    for (int i=1201; i<=1500; i++)
 		{

 	    	String id[] = productid.get(i).getText().split("\\r?\\n");
 	    	String Rfee[] = fee.get(i).getText().split("%");
 	    	String Rfee1[] = fee.get(i).getText().split("through");
 	    	String pricevalue[] = price.get(i).getText().split("\\r?\\n");

	    	int row=xr.getRowCount("ProductId");
 	    	System.out.println(row+ " row");
 	    	if(row>1201) {
		 	    	for(int k=1201;k<=row-1;k++) {

		 	    		String pid=xr5.getCellData("ProductId", "ProductId", k);
		 	    		System.out.println(id[1]+ " id[1]");
		 	    		System.out.println(pid+ " pid");
			 	    		if(id[1].equals(pid)) {
			 	    			System.out.println(id[1]+ " already exist");
			 	    		}else {
			 	    	    	xr5.setCellData("ProductId", "ProductId", j, id[1]);
			 	    	    	xr5.setCellData("ProductId", "Referral Fee Discount", j, Rfee[0]);
			 	    	    	xr5.setCellData("ProductId", "Retail Threshold", j, getReplace(retail.get(i).getText(),"when sold at or below $",""));
			 	    	    	xr5.setCellData("ProductId", "End Date", j, Rfee1[1]);
			 	    	    	xr5.setCellData("ProductId", "Your Price", j, getReplace(pricevalue[0],"$",""));
			 	    		}


		 	    		}
 	    	}else {

 	    	//System.out.println("price:" + getReplace(pricevalue[0],"$",""));
 	    	xr5.setCellData("ProductId", "ProductId", j, id[1]);
 	    	xr5.setCellData("ProductId", "Referral Fee Discount", j, Rfee[0]);
 	    	xr5.setCellData("ProductId", "Retail Threshold", j, getReplace(retail.get(i).getText(),"when sold at or below $",""));
 	    	xr5.setCellData("ProductId", "End Date", j, Rfee1[1]);
 	    	xr5.setCellData("ProductId", "Your Price", j, getReplace(pricevalue[0],"$",""));
 	    	}
 	    	j++;
 		}
 	   j=2;
 	    for (int i=1501; i<=1700; i++)
 		{

 	    	String id[] = productid.get(i).getText().split("\\r?\\n");
 	    	String Rfee[] = fee.get(i).getText().split("%");
 	    	String Rfee1[] = fee.get(i).getText().split("through");
 	    	String pricevalue[] = price.get(i).getText().split("\\r?\\n");

	    	int row=xr.getRowCount("ProductId");
 	    	System.out.println(row+ " row");
 	    	if(row>1501) {
		 	    	for(int k=1501;k<=row-1;k++) {

		 	    		String pid=xr6.getCellData("ProductId", "ProductId", k);
		 	    		System.out.println(id[1]+ " id[1]");
		 	    		System.out.println(pid+ " pid");
			 	    		if(id[1].equals(pid)) {
			 	    			System.out.println(id[1]+ " already exist");
			 	    		}else {
			 	    	    	xr6.setCellData("ProductId", "ProductId", j, id[1]);
			 	    	    	xr6.setCellData("ProductId", "Referral Fee Discount", j, Rfee[0]);
			 	    	    	xr6.setCellData("ProductId", "Retail Threshold", j, getReplace(retail.get(i).getText(),"when sold at or below $",""));
			 	    	    	xr6.setCellData("ProductId", "End Date", j, Rfee1[1]);
			 	    	    	xr6.setCellData("ProductId", "Your Price", j, getReplace(pricevalue[0],"$",""));
			 	    		}


		 	    		}
 	    	}else {

 	    	//System.out.println("price:" + getReplace(pricevalue[0],"$",""));
 	    	xr6.setCellData("ProductId", "ProductId", j, id[1]);
 	    	xr6.setCellData("ProductId", "Referral Fee Discount", j, Rfee[0]);
 	    	xr6.setCellData("ProductId", "Retail Threshold", j, getReplace(retail.get(i).getText(),"when sold at or below $",""));
 	    	xr6.setCellData("ProductId", "End Date", j, Rfee1[1]);
 	    	xr6.setCellData("ProductId", "Your Price", j, getReplace(pricevalue[0],"$",""));
 	    	}
 	    	j++;
 		}
 	   j=2;
 	    for (int i=1701; i<=2000; i++)
 		{

 	    	String id[] = productid.get(i).getText().split("\\r?\\n");
 	    	String Rfee[] = fee.get(i).getText().split("%");
 	    	String Rfee1[] = fee.get(i).getText().split("through");
 	    	String pricevalue[] = price.get(i).getText().split("\\r?\\n");

	    	int row=xr.getRowCount("ProductId");
 	    	System.out.println(row+ " row");
 	    	if(row>1701) {
		 	    	for(int k=1701;k<=row-1;k++) {

		 	    		String pid=xr7.getCellData("ProductId", "ProductId", k);
		 	    		System.out.println(id[1]+ " id[1]");
		 	    		System.out.println(pid+ " pid");
			 	    		if(id[1].equals(pid)) {
			 	    			System.out.println(id[1]+ " already exist");
			 	    		}else {
			 	    	    	xr7.setCellData("ProductId", "ProductId", j, id[1]);
			 	    	    	xr7.setCellData("ProductId", "Referral Fee Discount", j, Rfee[0]);
			 	    	    	xr7.setCellData("ProductId", "Retail Threshold", j, getReplace(retail.get(i).getText(),"when sold at or below $",""));
			 	    	    	xr7.setCellData("ProductId", "End Date", j, Rfee1[1]);
			 	    	    	xr7.setCellData("ProductId", "Your Price", j, getReplace(pricevalue[0],"$",""));
			 	    		}


		 	    		}
 	    	}else {

 	    	//System.out.println("price:" + getReplace(pricevalue[0],"$",""));
 	    	xr7.setCellData("ProductId", "ProductId", j, id[1]);
 	    	xr7.setCellData("ProductId", "Referral Fee Discount", j, Rfee[0]);
 	    	xr7.setCellData("ProductId", "Retail Threshold", j, getReplace(retail.get(i).getText(),"when sold at or below $",""));
 	    	xr7.setCellData("ProductId", "End Date", j, Rfee1[1]);
 	    	xr7.setCellData("ProductId", "Your Price", j, getReplace(pricevalue[0],"$",""));
 	    	}
 	    	j++;
 		}
 	   j=2;
	    for (int i=2001; i<=productcount-1; i++)
 		{

 	    	String id[] = productid.get(i).getText().split("\\r?\\n");
 	    	String Rfee[] = fee.get(i).getText().split("%");
 	    	String Rfee1[] = fee.get(i).getText().split("through");
 	    	String pricevalue[] = price.get(i).getText().split("\\r?\\n");

	    	int row=xr.getRowCount("ProductId");
 	    	System.out.println(row+ " row");
 	    	if(row>2001) {
		 	    	for(int k=2001;k<=row-1;k++) {

		 	    		String pid=xr8.getCellData("ProductId", "ProductId", k);
		 	    		System.out.println(id[1]+ " id[1]");
		 	    		System.out.println(pid+ " pid");
			 	    		if(id[1].equals(pid)) {
			 	    			System.out.println(id[1]+ " already exist");
			 	    		}else {
			 	    	    	xr8.setCellData("ProductId", "ProductId", j, id[1]);
			 	    	    	xr8.setCellData("ProductId", "Referral Fee Discount", j, Rfee[0]);
			 	    	    	xr8.setCellData("ProductId", "Retail Threshold", j, getReplace(retail.get(i).getText(),"when sold at or below $",""));
			 	    	    	xr8.setCellData("ProductId", "End Date", j, Rfee1[1]);
			 	    	    	xr8.setCellData("ProductId", "Your Price", j, getReplace(pricevalue[0],"$",""));
			 	    		}


		 	    		}
 	    	}else {

 	    	//System.out.println("price:" + getReplace(pricevalue[0],"$",""));
 	    	xr8.setCellData("ProductId", "ProductId", j, id[1]);
 	    	xr8.setCellData("ProductId", "Referral Fee Discount", j, Rfee[0]);
 	    	xr8.setCellData("ProductId", "Retail Threshold", j, getReplace(retail.get(i).getText(),"when sold at or below $",""));
 	    	xr8.setCellData("ProductId", "End Date", j, Rfee1[1]);
 	    	xr8.setCellData("ProductId", "Your Price", j, getReplace(pricevalue[0],"$",""));
 	    	}
 	    	j++;
 		}
 //excelPrice();
 	    }   
	//}

	public void excelPrice() {

		 //Read data from excel		
 		xr=new Xls_Reader("binaries/AmazonScrapper.xlsx");	
 		xr2=new Xls_Reader("binaries/AmazonScrapper_2.xlsx");	
 		xr3=new Xls_Reader("binaries/AmazonScrapper_3.xlsx");	
 		xr4=new Xls_Reader("binaries/AmazonScrapper_4.xlsx");	
 		xr5=new Xls_Reader("binaries/AmazonScrapper_5.xlsx");	
 		xr6=new Xls_Reader("binaries/AmazonScrapper_6.xlsx");	
 		xr7=new Xls_Reader("binaries/AmazonScrapper_7.xlsx");
 		xr8=new Xls_Reader("binaries/AmazonScrapper_8.xlsx");
 		int row=xr.getRowCount("ProductId");
 		int row2=xr2.getRowCount("ProductId");
 		int row3=xr3.getRowCount("ProductId");
 		int row4=xr4.getRowCount("ProductId");
 		int row5=xr5.getRowCount("ProductId");
 		int row6=xr6.getRowCount("ProductId");
 		int row7=xr7.getRowCount("ProductId");
 		int row8=xr8.getRowCount("ProductId");




 		for(int i=2; i<=row-1;i++)
 		{
 			String ddate=xr.getCellData("ProductId", "End Date", j);
 			xr.setCellData("ProductId", "End Date", j, getDate(ddate));
 		} 
 		for(int i=2; i<=row2-1;i++)
 		{
 			String ddate=xr2.getCellData("ProductId", "End Date", j);
 			xr2.setCellData("ProductId", "End Date", j, getDate(ddate));
 		} 
 		for(int i=2; i<=row3-1;i++)
 		{
 			String ddate=xr3.getCellData("ProductId", "End Date", j);
 			xr3.setCellData("ProductId", "End Date", j, getDate(ddate));
 		} 
 		for(int i=2; i<=row4-1;i++)
 		{
 			String ddate=xr4.getCellData("ProductId", "End Date", j);
 			xr4.setCellData("ProductId", "End Date", j, getDate(ddate));
 		} 
 		for(int i=2; i<=row5-1;i++)
 		{
 			String ddate=xr5.getCellData("ProductId", "End Date", j);
 			xr5.setCellData("ProductId", "End Date", j, getDate(ddate));
 		} 
 		for(int i=2; i<=row6-1;i++)
 		{
 			String ddate=xr6.getCellData("ProductId", "End Date", j);
 			xr6.setCellData("ProductId", "End Date", j, getDate(ddate));
 		} 
 		for(int i=2; i<=row7-1;i++)
 		{
 			String ddate=xr7.getCellData("ProductId", "End Date", j);
 			xr7.setCellData("ProductId", "End Date", j, getDate(ddate));
 		} 
 		for(int i=2; i<=row8-1;i++)
 		{
 			String ddate=xr8.getCellData("ProductId", "End Date", j);
 			xr8.setCellData("ProductId", "End Date", j, getDate(ddate));
 		} 

	}	

	public void getDetails() {
		WaitTool.sleep(3);
	   	if(driver.findElements(By.xpath("//a[contains(text(), 'See more fee discounts')]")).size() != 0)		
    	{	   
	   		WaitTool.sleep(7);
	   		if(driver.findElements(By.xpath("//a[contains(text(), 'See more fee discounts')]")).size() != 0) {	
	   			WaitTool.sleep(5);
	   		if(driver.findElements(By.xpath("//a[contains(text(), 'See more fee discounts')]")).size() != 0) {	   			
	   		driver.findElement(By.linkText("See more fee discounts")).click();   		
	   		WaitTool.sleep(5);
    		jse.executeScript("window.scrollBy(0,1050)", "");
    		getDetails();
	   		}
	   		}else {
	   			System.out.println("inside mo more ");
	   		}


    	}else {
    		System.out.println("mo more ");
    	} 
}
	public String  getDate(String date1) {
	System.out.println(date1);
	 String[] d =date1.split(" ");
	 System.out.println(d[0]);
	 System.out.println(d[1]);
	 System.out.println(d[2]);
	 String month=null;
	 month =d[0];
if(month.equals("January")) {
	month="01";
}
if(month.equals("February")) {
	month="02";
}
if(month.equals("March")) {
	month="03";
}
if(month.equals("April")) {
	month="04";
}
if(month.equals("May")) {
	month="05";
}
if(month.equals("June")) {
	month="06";
}
if(month.equals("July")) {
	month="07";
}
if(month.equals("August")) {
	month="08";
}
if(month.equals("September")) {
	month="09";
}
if(month.equals("October")) {
	month="10";
}
if(month.equals("November")) {
	month="11";
}
if(month.equals("December")) {
	month="12";
}

String datee=null;
 datee=d[1].replace(",","" );
datee=datee.trim();
System.out.println(datee);
if(datee.equals("1"))
{
	datee="01";
}
if(datee.equals("2"))
{
	datee="02";
}
if(datee.equals("3"))
{
	datee="03";
}
if(datee.equals("4"))
{
	datee="04";
}
if(datee.equals("5"))
{
	datee="05";
}
if(datee.equals("6"))
{
	datee="06";
}
if(datee.equals("7"))
{
	datee="07";
}
if(datee.equals("8"))
{
	datee="08";
}
if(datee.equals("9"))
{
	datee="09";
}

String ddd=null;
		  ddd=month+"-"+datee+"-"+d[2]+" 12:12:12";
		  System.out.println(ddd);

	return ddd;

	}

	public String  getReplace(String p,String rep, String newrep) {
		String pp= p.replace(rep, newrep);
		return pp;

	}*/

	}
}