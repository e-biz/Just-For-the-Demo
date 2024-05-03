package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.StoringLocalValues.ScenarioContext;

public class HomePage {
	
	WebDriver driver;
	
	
	public HomePage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,HomePage.this );
	}
	
	
	@FindBy(id = "btnClose")
	WebElement CloseModalofUnconnectedCOmpany;
	
	@FindBy(id = "lblUserName")
	WebElement UserNameOfHeader;
	
	@FindBy(id = "gvRequisition_btnDraft_0")
	WebElement OpenSaveReq;
	
	@FindBy(id = "btn_NeWReq_New_UI")
	WebElement ReqBtn;
	
	@FindBy(id = "lblUserName")
	WebElement ClickEvent;
	
	@FindBy(xpath = "//div//div//table//tbody//tr//td[text() = 'Draft']//parent::tr//td[8]//table//tbody//tr//td")
	List<WebElement> DraftreqOpen;
	
	@FindBy(id = "Draft")
	WebElement Draft;
	
	
	
	public void GetTitleOfHomePage() {
		String TitleOfHomePage = driver.getTitle();
		Assert.assertEquals(TitleOfHomePage,"eRequisition Home", "The User is not Redirect to the Home Page of eRequisition See Snapshot");
	}
	
	public void UserNameVerification(String UserName) throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(UserNameOfHeader.getText(), UserName);
	}
	
	public void CheckthePopupmsgisRunning() {
		WebElement ConnectedQBMSG = driver.findElement(By.id("ModalPopupExtender1_foregroundElement"));
		Assert.assertEquals(ConnectedQBMSG.isEnabled(),true );
	}
	
    public void VerifyThatTheReqisOnHomePageandOpenThatReq(String ReqNo) throws InterruptedException {
    	String AN = ScenarioContext.get("AppName");
    	if(AN.equals("TXO")) {
    	WebElement pleaseReview = driver.findElement(By.xpath(
				"//table[@class = 'table table-hover table-fixed centered-header']//tbody//tr//td[2]//span[text() = '"
						+ ReqNo
						+ "']//parent::td//parent::tr//td[8]//table//tbody//tr//td[2]//input[@id = 'btnReview']"));
		pleaseReview.click();
		Thread.sleep(12000);
    	}else {    	
    	WebElement pleaseReview = driver.findElement(By.xpath("//table[@class = 'table table-hover table-fixed centered-header']//tbody//tr//td[1]//span[text() = '"+ReqNo+"']//parent::td//parent::tr//td[8]//table//tbody//tr//td[2]//input[@id = 'btnReview']"));
		pleaseReview.click();
		Thread.sleep(15000);
    	}
    }
    
    
    public void VerifyTheColumnDataWithRespectToTheReq(String ReqNo,String ExpDescription,String ExpVendor, String ExpOriginatedBY, String ExpTotal) throws InterruptedException {
    	String AppName = ScenarioContext.get("AppName");
		if(AppName.equals("TXO")) 
		{
			List<WebElement> Vendor = driver.findElements(By.xpath("//table[@class = 'table table-hover table-fixed centered-header']//tbody//tr//td[2]//span[text() = '"+ReqNo+"']//parent::td//parent::tr//td[4]"));
			List<WebElement> originatedBy = driver.findElements(By.xpath("//table[@class = 'table table-hover table-fixed centered-header']//tbody//tr//td[2]//span[text() = '"+ReqNo+"']//parent::td//parent::tr//td[5]"));
			List<WebElement> TotalAmount = driver.findElements(By.xpath("//table[@class = 'table table-hover table-fixed centered-header']//tbody//tr//td[2]//span[text() = '"+ReqNo+"']//parent::td//parent::tr//td[6]"));
			
			String AcutalVendor = Vendor.get(0).getText(); 
			String AcutalOrignatedBy = originatedBy.get(0).getText(); 
			String AcutalTotalAMT = TotalAmount.get(0).getText(); 
			
			Assert.assertEquals(AcutalVendor, ExpVendor, "According to ReqNo # '"+ReqNo+"' Expected Vendor Name not Match");
			Assert.assertEquals(AcutalOrignatedBy, ExpOriginatedBY, "According to ReqNo # '"+ReqNo+"' Expected Originated BY Name not Match");
			Assert.assertEquals(AcutalTotalAMT,"$"+ExpTotal, "According to ReqNo # '"+ReqNo+"' Expected Total amount not Match");
			
			
		}else 
		{
			List<WebElement> Description = driver.findElements(By.xpath("//table[@class = 'table table-hover table-fixed centered-header']//tbody//tr//td[1]//span[text() = '"+ReqNo+"']//parent::td//parent::tr//td[3]"));
			List<WebElement> Vendor = driver.findElements(By.xpath("//table[@class = 'table table-hover table-fixed centered-header']//tbody//tr//td[1]//span[text() = '"+ReqNo+"']//parent::td//parent::tr//td[4]"));
			List<WebElement> originatedBy = driver.findElements(By.xpath("//table[@class = 'table table-hover table-fixed centered-header']//tbody//tr//td[1]//span[text() = '"+ReqNo+"']//parent::td//parent::tr//td[5]"));
			List<WebElement> TotalAmount = driver.findElements(By.xpath("//table[@class = 'table table-hover table-fixed centered-header']//tbody//tr//td[1]//span[text() = '"+ReqNo+"']//parent::td//parent::tr//td[6]"));
			
			
			String AcutalVendor = Vendor.get(0).getText(); 
			String AcutalOrignatedBy = originatedBy.get(0).getText(); 
			String AcutalTotalAMT = TotalAmount.get(0).getText(); 
			
			if(ExpDescription.equals("")) {
				String AcutalDes = Description.get(0).getText();
				Assert.assertEquals(AcutalDes.trim(), ExpDescription, "According to ReqNo # '"+ReqNo+"' Expected Description not Match");
			}
			
			
			Assert.assertEquals(AcutalVendor, ExpVendor, "According to ReqNo # '"+ReqNo+"' Expected Vendor Name not Match");
			Assert.assertEquals(AcutalOrignatedBy, ExpOriginatedBY, "According to ReqNo # '"+ReqNo+"' Expected OringatedBy Name not Match");
			Assert.assertEquals(AcutalTotalAMT,"$"+ ExpTotal, "According to ReqNo # '"+ReqNo+"' Expected TotalAmount not Match");

		}
		}
 
	


}
