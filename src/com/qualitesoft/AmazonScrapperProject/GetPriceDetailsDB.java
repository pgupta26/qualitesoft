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



public class GetPriceDetailsDB extends InitializeTest  {
	java.util.List<WebElement> productid,retail,fee,enddate,price,shipprice,offer,threshold,promotion,asin;
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
  		xr=new Xls_Reader("binaries/AmazonScrapper.xlsx");	
  	
  	
  		jse.executeScript("window.scrollBy(0,1050)", "");
  		WaitTool.sleep(5);
  		getDetails();
  		productid= driver.findElements(By.xpath("//table[@id='fd-page-discount-table']/tbody/tr/td[2]/span"));
 	    price= driver.findElements(By.xpath("//table[@id='fd-page-discount-table']/tbody/tr/td[3]"));	
 	    fee= driver.findElements(By.xpath("//table[@id='fd-page-discount-table']/tbody/tr/td[5]"));
 	    retail= driver.findElements(By.xpath("//table[@id='fd-page-discount-table']/tbody/tr/td[5]/span/span/a"));
 	   
 	    
	  shipprice= driver.findElements(By.xpath("//table[@id='fd-page-discount-table']/tbody/tr/td[3]/span"));
 	  offer= driver.findElements(By.xpath("//table[@id='fd-page-discount-table']/tbody/tr/td[4]/a"));
 	  threshold= driver.findElements(By.xpath("//table[@id='fd-page-discount-table']/tbody/tr/td[5]/span[1]/span/a"));
 	  promotion= driver.findElements(By.xpath("//table[@id='fd-page-discount-table']/tbody/tr/td[5]/span[2]"));
 	  asin= driver.findElements(By.xpath("//table[@id='fd-page-discount-table']/tbody/tr/td[2]/span/a"));
 	 
		
 	//--------------------Database--------------------------    
 	 // System.out.println("threshold1 "+threshold1);
 	    int productcount= productid.size();
 	    System.out.println("productcount:" + productcount);
 	    
  		DBUser=xr.getCellData("Sheet2","DBUser", 2).trim();
  		 DBPassword=xr.getCellData("Sheet2","DBPassword", 2).trim();
  		 feedid=xr.getCellData("Sheet2","FeedId", 2).trim();
  		dbUrl=xr.getCellData("Sheet2","DBUrl", 2).trim();
  		 //Float fid =Float.parseFloat(feedid);
  		 feedid =feedid.toString().replace(".0", "");
 	 	 //db
  		FeedId	=Integer.parseInt(feedid);	;
  		
 	   for (int i=0; i<=productcount-1; i++)
		{
 		   
 		  String number,minoffer;
 		  int pidd,oid;
 		   try{
 			 String pricev[] = price.get(i).getText().split("\\r?\\n");
	 	 	  String pricev1[] = pricev[1].toString().split("\\+");
	 	 	  String pricev2[] = pricev1[1].toString().split("$");
	 	 	  
	 	 	  if(offer.get(i).getText().contains("from")) {
	 	 		 String offer1[] = offer.get(i).getText().split("$");
		 	 	 String offer2[] = offer1[0].split("$");
		 	 	 String offer3[] = offer2[0].split("$");
		 	 	 String offer4[] = offer3[0].split("from"); 
		 	 	 minoffer=offer4[1].toString().replace(" $", "");
		 	 	 number=offer4[0].toString();
	 	 	   }else {
	 	 		 minoffer="0";
		 	 	 number=offer.get(i).getText();
	 	 	   }
	 	 	
	 	 	 String promotion1[] = promotion.get(i).getText().split("through");
	 	 	 String threshold1[]= threshold.get(i).getText().toString().split("$");
	 	 	
	 	 	String priceva = pricev2[0].toString().replace("$", "");
	 	 	
	 	 	String shiprice=priceva.toString().replace(")", "");
	 	 	
	 	 	String promotionPrice=promotion1[1].toString().trim();
	 	 	String threshold=threshold1[0].toString().replace("when sold at or below $", "");
	 	 	String asin11[]=asin.get(i).getAttribute("href").split("www.amazon.com/dp/");
	 	 	String asin1=asin11[1].toString();
	 	 	//String asin1=asin.get(i).getAttribute("href").replace("https://www.amazon.com/dp/", "");
	 	 	System.out.println("asin1 "+asin1); 
	 	 	  System.out.println("priceva "+shiprice);
	 	 	
	 	 	 System.out.println("promotion1 "+promotionPrice);
	 	 	 System.out.println("threshold1 "+threshold);
	 	 	 
	 	 	System.out.println("promotion1 "+getDate( promotionPrice));
	 	
	 	 
	 	 	 
	    	String id[] = productid.get(i).getText().split("\\r?\\n");
	    	String Rfee[] = fee.get(i).getText().split("%");
	    	String Rfee1[] = fee.get(i).getText().split("through");
	    	String pricevalue[] = price.get(i).getText().split("\\r?\\n");
	    	String pv =pricevalue[0].toString().replace("$","");
	    		    	
	    	//Integer result = Integer.valueOf(numberoffer);
	    	double offersnumber = Double.parseDouble(number);
	    	int offernumb =(int) offersnumber;
	    	if(id[1].contains("-")) {
	    		String idp[] =id[1].toString().split("-");
	    		String idd1=idp[0].toString();
	    		 pidd =Integer.parseInt(idd1.toString());
	    		String idd2=idp[1].toString();
	    		 oid =Integer.parseInt(idd2.toString());
	    	}else {
	    		 pidd =Integer.parseInt(id[1].toString());
	    		oid =0;
	    	}
	    	
	    	
	    	if(pv.contains(",")) {
	    		pv =pv.replace(",","");	    		
	    	}	    	
	    	double pv1 = Double.parseDouble(pv.toString());
	    	
	    	double shiprice1 = Double.parseDouble(shiprice.toString());
	    	
	    	if(minoffer.contains(",")) {
	    		minoffer =minoffer.replace(",","");	    		
	    	}
	    	double minoffer1 = Double.parseDouble(minoffer.toString());
	    	
	    	double feediss = Double.parseDouble(Rfee[0].toString());
	    	
	    	if(threshold.contains(",")) {
	    		 threshold =threshold.replace(",","");	    		
	    	}
	    	double thres1 = Double.parseDouble(threshold.toString());
	    	
	    	System.out.println("----------------values--------------------- ");
	    	System.out.println("pv1 "+pv1);
	    	System.out.println("shiprice1 "+shiprice1);
	    	System.out.println("minoffer1 "+minoffer1);
	    	System.out.println("feediss "+feediss);
	    	System.out.println("thres1 "+thres1);
	    	System.out.println("pidd "+pidd);
	    	System.out.println("asin1 "+asin1);
	    	System.out.println("FeedId "+FeedId);
	    	System.out.println("offernumb "+offernumb);
	    	System.out.println("oid "+oid);
	    	System.out.println("promotionPrice "+getDate(promotionPrice));	    	
	    	//db
	    	sql(pidd,oid,FeedId,asin1,pv1,shiprice1,minoffer1,offernumb ,feediss,thres1, getDate(promotionPrice));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		}
 	    
 	   
 //excelPrice();
	   
	}
	
	
	
	public void getDetails() {
	
	   	if(driver.findElements(By.xpath("//a[contains(text(), 'See more fee discounts')]")).size() != 0)
		
    	{	   			          		  		
	   		driver.findElement(By.linkText("See more fee discounts")).click();   		
	   		WaitTool.sleep(5);
    		jse.executeScript("window.scrollBy(0,1050)", "");
    		getDetails();
    		
    	}else {
    		
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
		
	}
	public void  sql(int pidd,int oid,int feedid ,String asin1,double pv1,double shiprice1,double minoffer1,int numberoffer1 ,double feediss,double thres1, String promotionPrice) throws SQLException, ClassNotFoundException {
					
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
	     
        //dbUrl = "jdbc:sqlserver://192.168.0.200\\SQLEXPRESS/AZURE-DEV-SQL/EPS:1433" ;
         //dbUrl = "jdbc:sqlserver://192.168.0.205\\SQLEXPRESS/Azure-QA-SQL01/EPS:1433" ;
		 username1 = DBUser;	

		 password1 = DBPassword;	
		 
		 
		/* CREATE PROCEDURE simpleproc (IN name varchar(50),IN user_name varchar(50),IN branch varchar(50))
		 BEGIN
		     insert into student (name,user_name,branch) values (name ,user_name,branch);
		 END*/
			//Query to Execute		
			String query = "INSERT INTO Gateway.amazon.RefferalFeeDiscount (ProductID,OptionID,FeedID,ASIN,Price,ShipPrice,MinOfferPrice,NumberOfOffers ,FeeDiscountPercentage,ThresholdPrice,PromotionEndDate)" + 
					"VALUES ('"+pidd+"','"+oid+"','"+feedid+"','"+asin1+"','"+pv1+"','"+shiprice1+"','"+minoffer1+"','"+numberoffer1+"','"+feediss+"','"+thres1+"','"+promotionPrice+"')";	
	
				try {
					con = DriverManager.getConnection(dbUrl,username1,password1);
					java.sql.CallableStatement cs = con.prepareCall("{call sp_test}"); 
					stmt = con.createStatement(); 	
					gotResults = stmt.execute(query);
					if(!gotResults){
						   System.out.println("No results returned");
						} else {
						   rs = stmt.getResultSet();
						}
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 	
				 con.close();  	
	}

}
