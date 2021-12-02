package com.qualitesoft.cymaxAdmin.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitesoft.core.WaitTool;

public class ClaimPage {

	WebDriver driver;
	
	public ClaimPage(WebDriver driver){
		this.driver = driver;
	}
	
	By claimsTab = By.xpath("//span[contains(@id,'tcOrder_PnlClaims_tab')]");
	By newClaims = By.xpath("//a[contains(@id,'lbt_NewClaims')]");
	By checkbox = By.xpath("//input[contains(@id,'Cbox_GridNewClaim')]");
	
	public WebElement clickClaimsTab(){
		return WaitTool.waitForElementPresentAndDisplay(driver, claimsTab, 60);
	}
	public WebElement clickNewClaims(){
		return WaitTool.waitForElementPresentAndDisplay(driver, newClaims, 60);
	}
	public WebElement clickCheckbox(){
		return WaitTool.waitForElementPresentAndDisplay(driver, checkbox, 60);
	}
	
	By status = By.xpath("//select[contains(@id,'Claim_eStatus')]");
	By type = By.xpath("//select[contains(@id,'Claim_eType')]");
	By carrier = By.xpath("//select[contains(@id,'Claim_eCarrier')]");
	By vendor = By.xpath("//select[contains(@id,'Claim_eVendor')]");
	By tracking = By.xpath("//input[contains(@id,'txteTracking')]");
	By productClaimed = By.xpath("//input[contains(@id,'eProductClaimed')]");
	By freight = By.xpath("//input[contains(@id,'eFreight')]");
	By assignTo = By.xpath("//select[contains(@id,'Claim_eAssignedTo')]");
	
	By claimDueDate = By.xpath("//input[contains(@id,'txtClaimDueDate')]");
	By followUpDate = By.xpath("//input[contains(@id,'txtFollowUpDate')]");
	By fieldDate = By.xpath("//input[contains(@id,'eFiledDate')]");
	By responseDate = By.xpath("//input[contains(@id,'eResponseDate')]");
	By pakageDamage = By.xpath("//select[contains(@id,'ePackageDamage')]");
	By productImage = By.xpath("//select[contains(@id,'eProductImage')]");
	By claimPickup = By.xpath("//input[contains(@id,'eClaimRefNumber')]");
	By notes = By.xpath("//textarea[contains(@id,'txtExistingNewNote')]");
	
	public WebElement selectStatus(){
		return WaitTool.waitForElementPresentAndDisplay(driver, status, 60);
	}
	public WebElement selectType(){
		return WaitTool.waitForElementPresentAndDisplay(driver, type, 60);
	}
	public WebElement selectCarrier(){
		return WaitTool.waitForElementPresentAndDisplay(driver, carrier, 60);
	}
	public WebElement selectVendor(){
		return WaitTool.waitForElementPresentAndDisplay(driver, vendor, 60);
	}
	public WebElement getTrackingNum(){
		return WaitTool.waitForElementPresentAndDisplay(driver, tracking, 60);
	}
	public WebElement setProductClaimed(){
		return WaitTool.waitForElementPresentAndDisplay(driver, productClaimed, 60);
	}
	public WebElement setFreight(){
		return WaitTool.waitForElementPresentAndDisplay(driver, freight, 60);
	}
	public WebElement selectAssignTo(){
		return WaitTool.waitForElementPresentAndDisplay(driver, assignTo, 60);
	}
	
	public WebElement setClaimDueDate(){
		return WaitTool.waitForElementPresentAndDisplay(driver, claimDueDate, 60);
	}
	public WebElement setFollowUpDate(){
		return WaitTool.waitForElementPresentAndDisplay(driver, followUpDate, 60);
	}
	public WebElement setFieldDate(){
		return WaitTool.waitForElementPresentAndDisplay(driver, fieldDate, 60);
	}
	public WebElement setResponseDate(){
		return WaitTool.waitForElementPresentAndDisplay(driver, responseDate, 60);
	}
	public WebElement selectPakageDamage(){
		return WaitTool.waitForElementPresentAndDisplay(driver, pakageDamage, 60);
	}
	public WebElement selectProductImage(){
		return WaitTool.waitForElementPresentAndDisplay(driver, productImage, 60);
	}
	public WebElement setClaimPickup(){
		return WaitTool.waitForElementPresentAndDisplay(driver, claimPickup, 60);
	}
	public WebElement setNotes(){
		return WaitTool.waitForElementPresentAndDisplay(driver, notes, 60);
	}
	
	By pod = By.xpath("//select[contains(@id,'Claim_IsPOD')]");
	By pictures = By.xpath("//select[contains(@id,'HasPictures')]");
	By invoice = By.xpath("//select[contains(@id,'HasInvoice')]");
	By claimForm = By.xpath("//select[contains(@id,'HasClaimForm')]");
	By concealed = By.xpath("//select[contains(@id,'IsConcealed')]");
	By resolved = By.xpath("//select[contains(@id,'HasProofOfLiability')]");
	By readyToFile = By.xpath("//select[contains(@id,'IsReadyToFile')]");
	By declareValue = By.xpath("//input[contains(@id,'eDeclaredValue')]");
	By responce = By.xpath("//select[contains(@id,'eResponse')]");
	By creditRefNum = By.xpath("//input[contains(@id,'eCreditRefNumber')]");
	By amountReceived = By.xpath("//input[contains(@id,'eAmtReceived')]");
	By productReceived = By.xpath("//input[contains(@id,'txtProductReceived')]");
	By notes2 = By.xpath("//textarea[contains(@id,'Claim_eNote')]");
	By createClaimBtn = By.xpath("//a[contains(@id,'Claim_Button')]");
	
	public WebElement selectPod(){
		return WaitTool.waitForElementPresentAndDisplay(driver, pod, 60);
	}
	public WebElement selectPictures(){
		return WaitTool.waitForElementPresentAndDisplay(driver, pictures, 60);
	}
	public WebElement selectInvoice(){
		return WaitTool.waitForElementPresentAndDisplay(driver, invoice, 60);
	}
	public WebElement selectClaimForm(){
		return WaitTool.waitForElementPresentAndDisplay(driver, claimForm, 60);
	}
	public WebElement selectConcealed(){
		return WaitTool.waitForElementPresentAndDisplay(driver, concealed, 60);
	}
	public WebElement selectResolved(){
		return WaitTool.waitForElementPresentAndDisplay(driver, resolved, 60);
	}
	public WebElement selectReadyToFile(){
		return WaitTool.waitForElementPresentAndDisplay(driver, readyToFile, 60);
	}
	public WebElement setDeclareValue(){
		return WaitTool.waitForElementPresentAndDisplay(driver, declareValue, 60);
	}
	public WebElement selectResponce(){
		return WaitTool.waitForElementPresentAndDisplay(driver, responce, 60);
	}
	public WebElement setCreditRefNum(){
		return WaitTool.waitForElementPresentAndDisplay(driver, creditRefNum, 60);
	}
	public WebElement setAmountReceived(){
		return WaitTool.waitForElementPresentAndDisplay(driver, amountReceived, 60);
	}
	public WebElement setProductReceived(){
		return WaitTool.waitForElementPresentAndDisplay(driver, productReceived, 60);
	}
	public WebElement setNotes2(){
		return WaitTool.waitForElementPresentAndDisplay(driver, notes2, 60);
	}
	public WebElement clickCreateClaimBtn(){
		return WaitTool.waitForElementPresentAndDisplay(driver, createClaimBtn, 60);
	}
	
	//******************Table Data**************

	By getRows = By.xpath("//div[@id='Claims']//table[contains(@id,'GridClaim')]//tr");
	
	public List<WebElement> getRowsNum(){
		return WaitTool.waitForElementsPresentAndDisplay(driver, getRows, 60);
	}
	
	public WebElement getDataFromTable(int rowNum, int colNum){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='Claims']//table[contains(@id,'GridClaim')]//tr["+rowNum+"]//td["+colNum+"]"), 60);
	}
	
	public WebElement clickClaimId(int rowNum){
		return WaitTool.waitForElementPresentAndDisplay(driver, By.xpath("//div[@id='Claims']//table[contains(@id,'GridClaim')]//tr["+rowNum+"]//td[2]"), 60);
	}
}
