package com.qualitesoft.freightclub.pageobjects;


import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.JavaFunction;
import com.qualitesoft.core.Log;
import com.qualitesoft.core.ScreenShot;
import com.qualitesoft.core.SeleniumFunction;
import com.qualitesoft.core.UseAssert;
import com.qualitesoft.core.WaitTool;


public class QuickQuoteFinal {

	WebDriver driver;

	public QuickQuoteFinal(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement quickQuoteLink() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[contains(@href,'/QuickQuote/QuickQuote')]"), 30);
	}

	public WebElement QQLink(){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//a[@id='link-quick-quote']"), 60);
	}

	public void acceptPopup() {
		WaitTool.sleep(5);
		if(WaitTool.isElementPresentAndDisplay(driver, By.xpath("//button[@data-role='end']"))) {
			ScreenShot.takeScreenShot(driver, "Popup"+JavaFunction.getRandomNumber(10, 10000));
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@data-role='end']"), 10));
		}
		WaitTool.sleep(2);
	}

	public WebElement shipmentType(String shipmentType) {
		if(shipmentType.equals("Parcel")) {
			return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//*[@id=\"app-content\"]/div/div/div/section/section/div/section/div[1]/div[1]/label"), 30);
		}else if(shipmentType.equals("Less Than Truckload")) {
			return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//strong[text()='Less-Than-Truckload (LTL)']/preceding::div[1]/parent::label/parent::div"), 30);
		}else if(shipmentType.equals("Custom")) {
			return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//strong[text()='Custom Order']/preceding::div[1]/parent::label/parent::div"), 30);
		}else {
			return null;
		}
	}

	public WebElement OrderDate() {
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='OrderDate']"), 30));
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

	public WebElement serviceLevel(String serviceLevel) {
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='selectize-control form-input single']"), 30));
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@class='selectize-dropdown-content']/descendant::strong[contains(text(),'"+serviceLevel+"')]"), 30);
	}

	public WebElement PickUpZip() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='pickupzipEntry']"), 30);
	}

	public WebElement DropOffZip() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//input[@id='dropoffzipEntry']"), 30);
	}

	public WebElement PickUpLocationType() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//h5[text()='Pick Up Location ']/ancestor::div[@class='col-xs-12 col-sm-6']/descendant::select[@class='form-input form-control input-sm']"),60);
	}

	public WebElement DropOffLocationType() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//h5[text()='Drop Off Location ']/ancestor::div[@class='col-xs-12 col-sm-6']/descendant::select[@class='form-input form-control input-sm']"),60);
	}

	public WebElement PackageType(String packageType, int itemIndex) {
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@placeholder='Select or Search...'])['"+itemIndex+"']"), 30));
		WaitTool.sleep(3);
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@data-group='packaging']/div[contains(text(),'"+packageType+"')])["+itemIndex+"]"), 30);
	}
	
	public WebElement addProduct(int itemIndex) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@data-group='packaging']/following-sibling::div/div[contains(text(),'New Product')])["+itemIndex+"]"), 30);
	}
	
	public WebElement productvalue(int itemIndex) {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@placeholder='Select or Search...'])["+itemIndex+"]"), 30);		
	}
	
	public WebElement quantity(int itemIndex) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//span[contains(text(),'Quantity')]/following::input[1])["+itemIndex+"]"), 30);
	}


	public WebElement Weight(int itemIndex) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[contains(@class,'weight')])["+itemIndex+"]/descendant::input[1]"), 30);
	}

	public WebElement DimensionL(int itemIndex) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@type='number' and @placeholder='Length'])["+itemIndex+"]"), 30);
	}

	public WebElement DimensionW(int itemIndex) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@type='number' and @placeholder='Width'])["+itemIndex+"]"), 30);
	}

	public WebElement DimensionH(int itemIndex) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@type='number' and @placeholder='Height'])["+itemIndex+"]"), 30);
	}

	public WebElement Category(int itemIndex) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//span[@title='Category']/parent::label/following-sibling::select)["+itemIndex+"]"), 30);
	}

	public WebElement popupCateogory(int itemIndex) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//span[text()='Got it!'])["+itemIndex+"]"), 30);
	}

	public WebElement DeclaredValue(int itemIndex) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@type='number' and @min='0.01' and @step='0.01'])["+itemIndex+"]"), 30);
	}

	public WebElement Cartons(int itemIndex) {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@id='CartonHeaviest']/input)["+itemIndex+"]"), 30);
	}

	public WebElement addadditionalItem() {

		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//button[@class='btn btn-info btn-xs'])[1]"), 30);
	}

	public void copyItemInformation(int index) {
		try {
			SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[contains(@class,'well well-white quote-item margin-right-10')]/descendant::button[1])["+(index+1)+"]"), 10));	
		}catch(Exception ex) {
			System.out.println("test");
		}

	}

	public void deleteItemInformation() {
		SeleniumFunction.click(WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//div[@class='row margin-left-0'])[1]/descendant::li[2]/button"), 10));
	}
	
	public WebElement SaveButton() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[contains(text(),'Get Rate')] | //button[text()='Submit for Quote']"), 30);
	}

	public void waitForQuotesToAppear() {

		String displayValue ;		
		for(int i = 2; i < 40; i=i+2) {
			displayValue =  driver.findElement(By.xpath("//span[text()='Searching for quotes...']")).getCssValue("display");
			if(!displayValue.equals("none")){
				System.out.println("------i-------------"+i);
				WaitTool.sleep(i);
			}
		}
	}
	
	public WebElement NextButton() {		
		return WaitTool.waitForElementPresentAndDisplay(driver,By.xpath("//table[@id='table-quotes']//tbody//tr[1]//td[7]//button"), 60);
	} 
	
	public void selectCarrier(String carrierName) {
		if(carrierName.equals("ABF Freight")) {
			SeleniumFunction.clickJS(driver, WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath("//img[@src='/Content/Images/Logos/11.png']/ancestor::tr/td[7]/button"), 10));
		}else if(carrierName.equals("Ceva")){
			SeleniumFunction.clickJS(driver, WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath("//img[@src='/Content/Images/Logos/44.png']/ancestor::tr/td[7]/button"), 10));
		}else if(carrierName.equals("Pilot Freight Services[Televisions]")) {
			SeleniumFunction.clickJS(driver, WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath("//img[@src='/Content/Images/Logos/33.png']/ancestor::tr/td[7]/button"), 10));
		}else if(carrierName.equals("Werner")) {
			SeleniumFunction.clickJS(driver, WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath("//img[@src='/Content/Images/Logos/302.png']/ancestor::tr/td[7]/button"), 10));
		} else if(carrierName.equals("FC Test Carrier")) {
			SeleniumFunction.clickJS(driver, WaitTool.waitForElementPresentAndDisplaySoft(driver, By.xpath("//img[@src='/Content/Images/Logos/222.png']/ancestor::tr/td[7]/button"), 10));
		}
	}

	//Shipment Completion Tab
	public WebElement totalCartonCount() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[text()='Total Carton Count:']/following-sibling::span"), 30);
	}
	public WebElement genericPallet() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.name("palletType0"), 30);
	}

	public WebElement palletDescription() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.name("pallet-description"), 30);
	}

	public WebElement numberOfCartoons() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//label[text()='Number of cartons on pallet']/following::input"), 30);
	}
	
	public WebElement SpecialHandling() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//textarea[@placeholder='Advise about any restrictions on Pick Up or Drop Off locations, special package handling, etc.']"), 30);		
	} 

	public WebElement LocationName() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("(//input[@placeholder='Search address book or type new label'])[1]"), 30);		
	}
	public WebElement ReviewOrder() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@class='btn btn-lg btn-primary pull-right']"), 30);	
	}
	public WebElement Book() {		
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@type='submit' and @class='btn btn-lg btn-primary pull-right']"), 30);		
	}
	public WebElement Okbutton1() {
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//button[@id='btn-continue-to-orders']"), 60);
	}
	
}