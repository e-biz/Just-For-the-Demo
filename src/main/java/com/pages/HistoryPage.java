package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.StoringLocalValues.ScenarioContext;

public class HistoryPage {
	WebDriver driver;
	
	public HistoryPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, HistoryPage.this);
	}
	
	@FindBy(id = "txt_Search")
	WebElement SearchBOX;
	
	@FindBy(id = "btnSearch")
	WebElement SearchBTN;
	
	@FindBy(xpath = "//table[@id = 'grdHistory']//tbody//tr[2]//td[8]")
	List<WebElement> ReqNORow;
	
	@FindBy(xpath = "//table[@id = 'grdHistory']//tbody//tr[2]//td[6]")
	List<WebElement>  PONORow;
	
	@FindBy(xpath = "//table[@id = 'grdHistory']//tbody//tr[2]//td[10]")
	List<WebElement>  DescriptionRow;
	
	@FindBy(xpath = "//table[@id = 'grdHistory']//tbody//tr[2]//td[11]")
	List<WebElement>  VendorRow;
	
	@FindBy(xpath = "//table[@id = 'grdHistory']//tbody//tr[2]//td[12]")
	List<WebElement>  OriginatedByRow;
	
	@FindBy(xpath = "//table[@id = 'grdHistory']//tbody//tr[2]//td[13]")
	List<WebElement>  CurrentOwnerRow;
	
	@FindBy(xpath = "//table[@id = 'grdHistory']//tbody//tr[2]//td[14]")
	List<WebElement>  TotalAmountRow;
	
	@FindBy(xpath = "//table[@id = 'grdHistory']//tbody//tr[2]//td[15]//Span[1]")
	List<WebElement>  StatusRow;
	
	@FindBy(xpath = "//table[@id = 'grdHistory']//tbody//tr[2]//td[2]//div//input[2]")
	WebElement ViewReqHistoryBTN;
	
	@FindBy(xpath = "//div[@id = \"a-container\"]//div//div[1]")
	List<WebElement> ReqHeader;
	
	public void OpenViewReqHistory() throws InterruptedException {
		ViewReqHistoryBTN.click();
		Thread.sleep(15000);
	}
	
	public void SearchTheSpecificPOorReq(String NO) throws InterruptedException {
		SearchBOX.sendKeys(NO);
		SearchBTN.click();
		Thread.sleep(10000);
	}
	
	public void VerificationOfTheDataoftheReqonHistoryPage(String PONO,String ReqNO,String Description,String Vendor,String Originatedby, String CurrentOwner,String TotalAmount, String Status) {
		String ReqNo1 = ReqNORow.get(0).getText();
		String PONO1 = PONORow.get(0).getText();
		String Description1 = DescriptionRow.get(0).getText();
		String Vendor1 = VendorRow.get(0).getText();
		String OriginatedBY1 = OriginatedByRow.get(0).getText();
		String CurrentOwner1 = CurrentOwnerRow.get(0).getText();
		String TotalAmount1 = TotalAmountRow.get(0).getText();
		String Status1 = StatusRow.get(0).getText();
		try {
		String REQNOFromPO10 = ScenarioContext.get("REQNOFromPO10");
		
		if(REQNOFromPO10.equals("10")) {
			Assert.assertEquals(PONO1, PONO , "PONO is in coorect according to the PONO : "+PONO);
			Assert.assertEquals(Description1, Description , "Description is in coorect according to the PONO : "+PONO);
			Assert.assertEquals(Vendor1, Vendor , "Vendor is in coorect according to the PONO : "+PONO);
			Assert.assertEquals(OriginatedBY1, Originatedby , "Originatedby is in coorect according to the PONO : "+PONO);
			Assert.assertEquals(CurrentOwner1, CurrentOwner , "CurrentOwner is in coorect according to the PONO : "+PONO);
			Assert.assertEquals(TotalAmount1, "$"+TotalAmount , "TotalAmount is in coorect according to the PONO : "+PONO);
			Assert.assertEquals(Status1,Status , "Status is in coorect according to the PONO : "+PONO);	
		}else {
			Assert.assertEquals(ReqNo1, ReqNO , "ReqNO is in coorect according to the ReqNO");
			Assert.assertEquals(PONO1, PONO , "PONO is in coorect according to the ReqNO : "+ReqNO);
			Assert.assertEquals(Description1, Description , "Description is in coorect according to the ReqNO : "+ReqNO);
			Assert.assertEquals(Vendor1, Vendor , "Vendor is in coorect according to the ReqNO : "+ReqNO);
			Assert.assertEquals(OriginatedBY1, Originatedby , "Originatedby is in coorect according to the ReqNO : "+ReqNO);
			Assert.assertEquals(CurrentOwner1, CurrentOwner , "CurrentOwner is in coorect according to the ReqNO : "+ReqNO);
			Assert.assertEquals(TotalAmount1, "$"+TotalAmount , "TotalAmount is in coorect according to the ReqNO : "+ReqNO);
			Assert.assertEquals(Status1,Status , "Status is in coorect according to the ReqNO : "+ReqNO);	
		}
			}catch(NullPointerException c) {
				
			}
		
	}
	
	public void clickOnTheViewRequisitionHistory() {
		ViewReqHistoryBTN.click();
	}
	
	public void VerificationOfTheHeaderReqNO(String ReqNO) {
		String HeaderReqNO = ReqHeader.get(0).getText();
		Assert.assertEquals(HeaderReqNO, "Requisition #: "+ReqNO);
	}
}
