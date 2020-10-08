package com.qualitesoft.floatingcart.pageobjects;


import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;

public class FloatingQuickQuote {

	WebDriver driver;

	public FloatingQuickQuote(WebDriver driver) {
		this.driver = driver;
	}
	
	public void acceptPopup() {
		//This is used to accept popup on pages
		if(WaitTool.isElementPresentAndDisplay(driver, By.xpath("//button[@data-role='end']"))) {
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@data-role='end']"), 10));
		}
	}
	
	public void selectCarrier(String carrierName) {
		if(carrierName.equals("ABF Freight")) {
			SeleniumFunction.scrollIntoView(driver, driver.findElement(By.xpath("//img[@src='/Content/Images/Logos/11.png']")));
			SeleniumFunction.clickJS(driver, WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath("//img[@src='/Content/Images/Logos/11.png']/ancestor::tr/td[7]/button"), 10));
		}else if(carrierName.equals("Ceva")){
			SeleniumFunction.clickJS(driver, WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath("//img[@src='/Content/Images/Logos/44.png']/ancestor::tr/td[7]/button"), 10));
		}else if(carrierName.equals("Pilot Freight Services[Televisions]")) {
			SeleniumFunction.clickJS(driver, WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath("//img[@src='/Content/Images/Logos/303.png']/ancestor::tr/td[7]/button"), 10));
		}else if(carrierName.equals("Werner")) {
			SeleniumFunction.scrollIntoView(driver, driver.findElement(By.xpath("//img[@src='/Content/Images/Logos/302.png']")));
			SeleniumFunction.clickJS(driver, WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath("//img[@src='/Content/Images/Logos/302.png']/ancestor::tr/td[7]/button"), 10));
		}else if(carrierName.equals("Pilot Freight Services[Televisions new]")) {
			SeleniumFunction.clickJS(driver, WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath("//img[@src='/Content/Images/Logos/33.png']/ancestor::tr/td[7]/button"), 10));
		}
	}
	
	public WebElement quickquoteLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/QuickQuote/QuickQuote']"), 30);
	}
	
	public void expandCarries() {
		System.out.println("Is Expand Carrier: "+WaitTool.isElementPresentAndDisplay(driver, By.xpath("//span[contains(text(),'Show')]")));
		if(WaitTool.isElementPresentAndDisplay(driver, By.xpath("//span[contains(text(),'Show')]"))) {
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[contains(text(),'Show')]"), 10));
		}
	}

	public WebElement manageOrdersLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@href='/Order/Index']"), 30);
	}
	/*	public WebElement manageOrdersLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[contains(@href,'/Order/Index')]"), 30);
	}*/
	public WebElement ParcelShipment() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='shipmentType' and @value='0']"), 30);
	}

	public WebElement LTLShipment() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='shipmentType' and @value='1']"), 30);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[@class='button-label-1']"), 30);

	}

	public WebElement OrderDate() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='OrderDate']"), 30);
	}
	public WebElement OrderDate1() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='datepicker-days']//td[@class='today day']"), 30);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='datepicker-days']//td[contains(@class,'today')]/following-sibling::td[1]"), 30);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='datepicker-days']//td[@class='day']"), 30);
	}

	public WebElement ClickDate(String date) {

		try{
			List<WebElement> allDates= driver.findElements(By.xpath("//div[@class='datepicker-days']//td"));
			for(WebElement ele: allDates)
			{
				String dt= ele.getText();
				if(dt.equalsIgnoreCase(date))
				{
					return ele;	
				}
			}
		}
		catch (Exception e) {
			Log.error("Not able to select date " + e.getMessage());
			throw e;
		}
		return null;

	}

	public WebElement OrderReferenceID() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='OrderReferenceID']"), 30);
	}

	public WebElement ServiceLevel() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='selectize-input items has-options full has-items']"), 30);
	}
	public WebElement ServiceLevelfloating() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='selectize-control form-input single']"), 30);
	}
	public WebElement ServiceLevelWG() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='selectize-dropdown single']//div[@data-value='357']"), 30);
	}

	public WebElement ServiceLevelBOT() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='selectize-dropdown single']//div[@data-value='351']"), 30);
	}

	public WebElement ServiceLevelCUR() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"app-content\"]/div/div/div/section/section/div/div[2]/div[3]/div/div/div[2]/div/div[2]/strong"), 30);
	}

	public WebElement ServiceLevelCURFloating() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='selectize-dropdown-content']//div[@data-value='352']"), 30);
	}	
	public WebElement ServiceLevelTHR() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='selectize-dropdown single']//div[@data-value='353']"), 30);
	}

	public WebElement ServiceLevelROC() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='selectize-dropdown single']//div[@data-value='354']"), 30);
	}

	public WebElement ServiceLevelWGPR() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='selectize-dropdown single']//div[@data-value='355']"), 30);
	}	
	public WebElement ServiceLevelOptions() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='selectize-dropdown single']//div[@data-value='357']"), 30);
	}

	public WebElement PickUpZip() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='pickupzipEntry']"), 30);
	}
	
	public WebElement PickUpLocationType() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//h5[text()='Pick Up Location ']/ancestor::div[@class='col-xs-12 col-sm-6']/descendant::select[@class='form-input form-control input-sm']"),60);
	}
	
	public WebElement DropOffLocationType() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//h5[text()='Drop Off Location ']/ancestor::div[@class='col-xs-12 col-sm-6']/descendant::select[@class='form-input form-control input-sm']"),60);
	}

	public WebElement PickUpZipLocationTypeRes() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@value='400']"), 30);
	}

	public WebElement PickUpZipLocationTypeCom() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@value='401']"), 30);
	}

	public WebElement DropOffZipLocationTypeResfloating() {
		SeleniumFunction.scrollIntoView(driver, WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@value='400'])[2]"), 30));
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@value='400'])[2]"), 30);
	}

	public WebElement DropOffZipLocationTypeComfloating() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"not-logged-quick-quote\"]/div/section/section/div/div[4]/div[2]/div[3]/div/div[1]/div[3]/label"), 30);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"page-content-wrapper\"]/section/div[2]/div/div/section/div[4]/div[2]/div[3]/div/div[1]/div[3]/label/input"), 30);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@value='401'][2]"), 30);
	}
	public WebElement DropOffZipLocationTypeRes() {
		SeleniumFunction.scrollIntoView(driver, WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"app-content\"]/div/div/div/section/section/div/div[3]/div[2]/div[3]/div/div[1]/div[2]/label"), 30));
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"app-content\"]/div/div/div/section/section/div/div[3]/div[2]/div[3]/div/div[1]/div[2]/label"), 30);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='page-content-wrapper']//div//div/section/div[2]/div//article/div[3]/div[2]/div[3]//div[1]/div[2]/label/input"), 30);
	}

	public WebElement DropOffZipLocationTypeCom() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"app-content\"]/div/div/div/div/section/div[2]/div/div/section/div[3]/div[2]/div[3]/div/div[1]/div[3]/label/input"), 30);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='page-content-wrapper']/div//div//section/div[2]/div//article/div[3]/div[2]/div[3]//div[1]/div[3]/label/input"), 30);
	}
	/*	public WebElement DropOffZipLocationTypeRes() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='page-content-wrapper']//div//div/section/div[2]/div//article/div[3]/div[2]/div[3]//div[1]/div[2]/label/input"), 30);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='page-content-wrapper']//div//div/section/div[2]/div/article/div[4]/div[2]/div[3]/div[1]/div[2]/label/input"), 30);
	}

	public WebElement DropOffZipLocationTypeCom() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='page-content-wrapper']/div//div//section/div[2]/div//article/div[3]/div[2]/div[3]//div[1]/div[3]/label/input"), 30);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='page-content-wrapper']/div//div//section/div[2]/div/article/div[4]/div[2]/div[3]/div[1]/div[3]/label/input"), 30);
	}*/

	public WebElement DropOffZip() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='dropoffzipEntry']"), 30);
	}
	public WebElement PackageType() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@placeholder='Select or Search...']"), 30);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='form-group col-sm-2']/div[@class='selectize-control form-input single']"), 90);
	}

	public WebElement PackageTypeOption() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='selectize-dropdown single packaging-type form-input']//div/div"), 30);
	}

	/*    public void PackageTypeOptions(String packageType) {

		try {
			List<WebElement> packages = driver.findElements(By.xpath("//div[@class='selectize-dropdown single packaging-type form-input']//div/div"));
			for (int packagetype = 0; packagetype <= packages.size(); packagetype++) {
				if (packages.get(packagetype).getText().trim().equalsIgnoreCase(packageType.trim())) {
					SeleniumFunction.click(driver.findElement(By.
							xpath("//div[@class='selectize-dropdown single packaging-type form-input']//div/div[5]")));
					break;
				}
			}
		} catch (Exception e) {
			Log.error("Not able to select package: " + e.getMessage());
			throw e;
		}
	}*/
	public void PackageTypeOptions(String packageType) {

		try {
			if(packageType.equalsIgnoreCase("Standard Pallet 1")){
				SeleniumFunction.click(driver.findElement
						(By.xpath("//div[@class='selectize-dropdown single form-input]//div/div[@data-value='850']")));
			}
			else if(packageType.equalsIgnoreCase("Standard Pallet 2")){
				SeleniumFunction.click(driver.findElement
						(By.xpath("//div[@class='selectize-dropdown single form-input']//div/div[@data-value='851']")));
			}
			else if(packageType.equalsIgnoreCase("Standard Pallet 3")){
				SeleniumFunction.click(driver.findElement
						(By.xpath("//div[@class='selectize-dropdown single form-input']//div/div[@data-value='852']")));
			}
			else if(packageType.equalsIgnoreCase("Custom Pallet (enter dimensions)")){
				SeleniumFunction.click(driver.findElement
						(By.xpath("//div[@class='selectize-control form-input single']//div/div[@data-value='853']")));
			}
			else if(packageType.equalsIgnoreCase("Boxed")){
				SeleniumFunction.click(driver.findElement
						(By.xpath("//div[@class='selectize-dropdown single form-input']//div/div[@data-value='854']")));
			}
			else if(packageType.equalsIgnoreCase("My Own Package")){
				SeleniumFunction.click(driver.findElement
						(By.xpath("//div[@class='selectize-dropdown single form-input']//div/div[@data-value='854']")));
			}
			else if(packageType.equalsIgnoreCase("USPS Flat Rate Envelope")){
				SeleniumFunction.click(driver.findElement
						(By.xpath("//div[@class='selectize-dropdown single form-input']//div/div[@data-value='5']")));
			}	
			else if(packageType.equalsIgnoreCase("Other Box")){
				SeleniumFunction.click(driver.findElement
						(By.xpath("//div[@class='selectize-dropdown single form-input']//div/div[@data-value='10']")));
			}		
		}

		catch (Exception e) {
			Log.error("Not able to select package: " + e.getMessage());
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}



	public WebElement Weight() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@class='form-inline weight']/div/input"), 30);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[@class='input-group-btn']/input[@type='number' and @class='form-control form-input input-sm']"), 30);
	}

	public WebElement DimensionL() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@type='number' and @placeholder='L']"), 30);
	}

	public WebElement DimensionW() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@type='number' and @placeholder='W']"), 30);
	}

	public WebElement DimensionH() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@type='number' and @placeholder='H']"), 30);
	}
	public WebElement CategoryButton() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='ms-choice']"), 30);

	}
	public WebElement Categoryother() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@value='347']"), 30);

	}
	public WebElement popupCateogory() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"app-content\"]/div/div/div/section/section/div/div[4]/div[1]/div[2]/div/div/div[2]/div/div/div[3]/div/div[2]/button"), 30);
	}
	public WebElement notloggedpopupCateogory() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"not-logged-quick-quote\"]/div/section/section/div/div[5]/div[1]/div[2]/div/div/div[2]/div/div/div[3]/div/div[2]/button"), 30);
		//Modified on 7th march
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//span[text()='Got it!']"), 30);

	}	
	public WebElement Category() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@class='form-input form-control input-sm']"), 30);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@class='m-categories form-input']"), 30);
	}


	public void ServiceLevel(String Category) {

		try {
			List<WebElement> Categories = driver.findElements(By.xpath("//div[@class='ms-drop bottom']"));
			for (int categorytypes = 0; categorytypes <= Categories.size(); categorytypes++) {
				if (Categories.get(categorytypes).getText().trim().equalsIgnoreCase(Category.trim())) {
					SeleniumFunction.click(driver.findElement(By.
							xpath("//div[@class='ms-drop bottom']/ul/li[13]")));
					break;
				}
			}
		} catch (Exception e) {
			Log.error("Not able to click package: " + e.getMessage());
			throw e;
		}
	}

	public WebElement DeclaredValue() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@type='number' and @min='0.01' and @step='0.01']"), 30);
	}
	public WebElement Accessorials() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default']"), 30);
	} 
	public WebElement selectAccessorials() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"app-content\"]/div/div/div/section/section/div/div[4]/div[1]/div[2]/div/div/div[1]/div[9]/span[1]/div/ul/li/a/label"), 30);
	} 
	public WebElement Cartons() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//td[@class='carton-count']/input[@class='form-control form-input input-sm']"), 30);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='carton-count form-group col-xs-6 col-sm-2 col-xl-1']/input[@class='form-control form-input input-sm']"), 30);
		//MOdified on 6th March by parshant
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='CartonHeaviest']/input[@type='number']"), 30);
	}
	public WebElement QuickEmail() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='PublicEmail']"), 30);
	} 
	public WebElement AccountType() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='PublicProfileType']"), 30);
	}
	public WebElement DonotStackCheckBox() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@class='form-control form-input input-sm' and type='checkbox']"), 30);		
	} 
	public WebElement SaveButton() {

		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@class='btn btn-success btn-lg pull-right large-spacer']"), 30);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[contains(text(),'Get Rate')]"), 30);
	}



	public WebElement Carries() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='col-xs-12 ratequote']"), 30);
	}
	public void ValidateCarriers(String i) {

		List <WebElement> carriers= driver.findElements(By.xpath("//div[@class='col-xs-12 ratequote']"));
		int carriercnt= carriers.size();
		String j=Integer.toString(carriercnt);
		UseAssert.assertEquals(j, i);

	}
	public static int orderDate(){
		Calendar cal=Calendar.getInstance();
		int val = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(new DateFormatSymbols().getWeekdays()[val]);
		String weekday=new DateFormatSymbols().getWeekdays()[val];


		if(weekday.equalsIgnoreCase("Saturday")){
			int orderdte=cal.get(Calendar.DAY_OF_MONTH)+2;
			return orderdte;
		}
		else if(weekday.equalsIgnoreCase("Sunday")){
			int orderdte=cal.get(Calendar.DAY_OF_MONTH)+1;
			return orderdte;
		}
		else {
			int orderdte=cal.get(Calendar.DAY_OF_MONTH);
			return orderdte;
		}

	}  


	public WebElement SelectCarrierCheckBox() {		
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//i[@class='fa fa-circle-o'][1]"), 60);	
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='row ratequote-item special'][1]"), 60);
	} 

	public WebElement NextButton() {	
		// return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-primary'][1]"), 60);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"table-quotes\"]/tbody/tr[1]/td[7]/button"), 60);		
	} 
	public WebElement NextButton2() {	
		// return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-primary'][1]"), 60);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"table-quotes\"]/tbody/tr[2]/td[7]/button[2]"), 60);		
	} 
	
	public WebElement TotalCartoonCount() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@class='form-control form-input input-sm']"), 60);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//textarea[@placeholder='e.g. 1 sofa, 2 beds, 4 chairs']"), 60);		
	}  
	public WebElement PalletDesc() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//textarea[@name='pallet-description']"), 60);
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//textarea[@placeholder='e.g. 1 sofa, 2 beds, 4 chairs']"), 60);		
	} 
	public WebElement PalletDescParcel() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//textarea[@placeholder='e.g. game console, microwave ']"), 60);		
	}    
	public WebElement SpecialHandling() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//textarea[@placeholder='Advise about any restrictions on Pick Up or Drop Off locations, special package handling, etc.']"), 30);		
	} 

	public WebElement LocationName() {	
		SeleniumFunction.scrollIntoView(driver, WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@placeholder='Search address book or type new label'])[1]"), 30));
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@placeholder='Search address book or type new label'])[1]"), 30);		
	} 

	public WebElement Address1() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='Address1']"), 30);		
	} 
	public WebElement Address2() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='Address2']"), 30);		
	} 

	public WebElement State() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='StateProvince']"), 30);		
	} 

	public WebElement Country() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='Country']"), 30);		
	} 
	public WebElement City() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='City']"), 30);		
	}  
	
	public WebElement ZipCode() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='ZipPostal']"), 30);		
	} 
	
	public WebElement FirstName() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='FirstName']"), 30);		
	} 
	public WebElement LastName() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='LastName']"), 30);		
	} 
	public WebElement Phone1() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='Phone1']"), 30);		
	} 
	public WebElement Email() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='Email']"), 30);		
	} 
	
	
	public WebElement PickUpAddress1() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@id='Address1'])[2]"), 30);		
	} 
	public WebElement PickUpFirstName() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@id='FirstName'])[1]"), 30);		
	} 
	public WebElement PickUpLastName() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@id='LastName'])[1]"), 30);		
	} 
	public WebElement PickUpPhone1() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@id='Phone1'])[2]"), 30);		
	}
	
	public WebElement DropLocationName() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@placeholder='Search address book or type new label'])[2]"), 30);		
	} 

	public WebElement DropAddress1() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@id='Address1'])[3]"), 30);		
	} 
	public WebElement DropAddress2() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@id='Address2'])[3]"), 30);		
	} 
	public WebElement DropFirstName() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@id='FirstName'])[2]"), 30);		
	} 
	public WebElement DropLastName() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@id='LastName'])[2]"), 30);		
	} 
	public WebElement DropPhone1() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@id='Phone1'])[3]"), 30);		
	} 
	public WebElement DropEmail() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@id='Email'])[3]"), 30);		
	} 
	public WebElement ReviewOrder() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-lg btn-primary pull-right']"), 30);	
	} 
	public WebElement CreditCardNumber() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='txtCreditCardNumber']"), 60);		
	}
	public WebElement existingcardCheckBox() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[@for='payWithPayPal']//input[@id='payWithSavedCardr']"), 120);		
	}
	public WebElement CardName() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='txtNameOnCard']"), 30);		
	} 
	public WebElement CVV() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='txtCVVOnCard']"), 30);		
	} 	
	public WebElement Month() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='ddlExpiryMonth']"), 30);		
	} 
	public WebElement Year() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@id='ddlExpiryYear']"), 30);		
	}
	public WebElement BillFirstName() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='first-name']"), 30);		
	}	
	public WebElement BillLastName() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='last-name']"), 30);		
	}	
	public WebElement BillCompanytName() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='company-name']"), 30);		
	}	
	public WebElement BillPhone() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='phone']"), 30);		
	}	
	public WebElement BillAddress1() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='address-1']"), 30);		
	}	
	public WebElement BillAddress2() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='address-2']"), 30);		
	}
	public WebElement Billzip() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='zip-code']"), 30);		
	}
	public WebElement Billcity() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@name='city']"), 30);		
	}
	public WebElement Billcountry() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@name='country']"), 30);		
	}
	public WebElement Billstate() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//select[@name='state']"), 30);		
	}	
	public WebElement BookandPay() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='btn btn-primary btn-block']"), 30);		
	}	
	public WebElement Okbutton() {		
		//return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='modal-footer']//button[@class='btn btn-primary']"), 30);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id='paymentSummaryModal']/div/div/div[3]/button"), 30);		
	}
	/*	public WebElement OkbuttonOrder() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='modal-footer']/button[@class='btn btn-success']"), 30);		
	}*/
	public WebElement OkbuttonOrder() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"orderHistoryDetail\"]/div/div/div[3]/button"), 30);
	}
	public WebElement updatehistory() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"orderDetailsTabs\"]/li[2]/a"), 30);
	}
	public WebElement toolTipskip() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@class='introjs-button introjs-skipbutton']"), 30);		
	}	
	public WebElement ViewDetail() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[text()='Detail'])[1]"), 30);
	}
}