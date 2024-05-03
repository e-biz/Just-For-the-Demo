package com.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImportData {

	WebDriver driver;
		public ImportData(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, ImportData.this);
	}
		//Import data All tabs defined over here
		
     @FindBy(xpath="//label[text()='Customers']")
     public
     WebElement CustomersTab;

     @FindBy(xpath="//label[text()='Vendors']")
     public
     WebElement VendorsTab;
     
     @FindBy(xpath="//label[text()='Products & Services']")
     public
     WebElement ItemsTab;
     
     @FindBy(xpath="//label[text()='Charts of Account']")
	public
     WebElement ChartsOfAccountTab;
     
     @FindBy(xpath="//label[text()='Class']")
     public
     WebElement ClassTab;
     
     @FindBy(xpath="//label[text()='Ship Via']")
     public
     WebElement ShipViaTab;
        
     @FindBy(xpath="//label[text()='Terms']")
     public
     WebElement TermsTab;
     
     //Buttons
     
     @FindBy(id="btnFileUploadCustomer") 
	public
     WebElement Customer_ImportData_Button;
     
     @FindBy(id="btnSubmitUploaderCustomer")
	public
     WebElement Customer_Submit_Button;
     
     @FindBy(id="btnFileUploadVendor")
     WebElement Vendor_ImportData_Button;
     
     @FindBy(id="btnSubmitUploaderVendor")
     public
     WebElement Vendor_Submit_Button;
     
     @FindBy(id="btnFileUploadItem")
     WebElement Item_ImportData_Button;
     
     @FindBy(id="btnSubmitUploaderItem")
     public
     WebElement Item_Submit_Button;
     
     @FindBy(id="btnFileUploadAccount")
     WebElement Accounts_ImportData_Button;
     
     @FindBy(id="btnSubmitUploaderAccount")
     public
     WebElement Accounts_Submit_Button;
     
     @FindBy(id="btnFileUploadClass")
     WebElement Class_ImportData_Button;
     
     @FindBy(id="btnSubmitUploaderClass")
     public
     WebElement Class_Submit_Button;
     
     @FindBy(id="btnFileUploadShipVia")
     WebElement ShipVia_ImportData_Button;
     
     @FindBy(id="btnSubmitUploaderShipVia")
     public
     WebElement ShipVia_Submit_Button;
     
     @FindBy(id="btnFileUploadTerm")
     WebElement Terms_ImportData_Button;
     
     @FindBy(id="btnSubmitUploaderTerm")
     public
     WebElement Terms_Submit_Button;
     
     //Result and Error Count
     
     @FindBy(id="Uploader-Customer-count")
     WebElement CustomerResultCount;
     
     @FindBy(id="Uploader-errorCustomer-count")
     WebElement CustomerErrorCount;
     
     @FindBy(id="Uploader-Vendor-count")
     WebElement VendorResultCount;
     
     @FindBy(id="Uploader-errorVendor-count")
     WebElement VendorErrorCount;
     
     @FindBy(id="Uploader-Item-count")
     WebElement ItemResultCount;
     
     @FindBy(id="Uploader-errorItem-count")
     WebElement ItemErrorCount;
     
     @FindBy(id="Uploader-Account-count")
     WebElement AccountResultCount;
     
     @FindBy(id="Uploader-errorAccount-count")
     WebElement AccountErrorCount;
     
     @FindBy(id="Uploader-Class-count")
     WebElement ClassResultCount;
     
     @FindBy(id="Uploader-errorClass-count")
     WebElement ClassErrorCount;
     
     @FindBy(id="Uploader-ShipVia-count")
     WebElement ShipViaResultCount;
     
     @FindBy(id="Uploader-errorShipVia-count")
     WebElement ShipViaErrorCount;
     
     @FindBy(id="Uploader-Term-count")
     WebElement TermResultCount;
     
     @FindBy(id="Uploader-errorTerm-count")
     WebElement TermErrorCount;
     
     
     // Pop Up Msg 
     
    
     
     @FindBy(xpath="//button[@class=\"confirm\"]")
     public
     WebElement Okay_Button_popup;
   
     @FindBy(xpath="//div[@class='swal-text']")
	public
     WebElement PopUpTexTWithRespectToTheEnities;
     
     
     @FindBy(xpath="//div[text()='No Data Found to Import.']")
     WebElement NoDataFoundMsg;
     
     @FindBy(xpath="//div[text()='Please fill all the mandatory fields.']")
     WebElement FillMandatoryFieldsPopUPMsg;
     
     @FindBy(xpath="//div[@class='swal-title']")
     WebElement SuccessOrErrorMsg;
     
     @FindBy(xpath="//button[@class='swal-button swal-button--cancel']")
     WebElement CancelButtonOnWarningPopup;
     
     @FindBy(xpath ="//div[@class='swal-modal']")
	public
     WebElement  SelectFileValidationMsg;
     
     @FindBy (xpath= "//div[@class='swal-content']//div")
     WebElement SkippedNoteMsgPopUp; 
     //div[@class=\"swal-content\"]
//     (xpath= "//div[text()=' rows having errors will be skipped in importing process.']")
   
     
    public String CutsomerSuccessfullyAdded= "Customer(s) have been added successfully!";
    public String VendorSuccessfullyAdded="Vendor(s) have been added successfully!";
    public String ItemsSuccessfullyAdded="Item(s) have been added successfully!";
    public String AccountSuccessfullyAdded="Accounts(s) have been added successfully!";
    public String ClassSuccessfullyAdded="Class(s) have been added successfully!";
    public String ShipViaSuccessfullyAdded="Shipping method(s) have been added successfully!";
    public String TermsSuccessfullyAdded="Term(s) have been added successfully!";
    public String DataNotFoundError="No Data Found to Import.";
    public String WithoutGivingFileClickOnSubmitBtnValidationMsg="Please Select a File to Import.";
    public String NoDataFoundError="No data available to import";
    public String MandatoryDataMissingMsg=  "Please fill all the mandatory fields.";
    public String SkippedRowNote ="Note: rows having errors will be skipped in importing process.";
    public String fileFormatNotRecommended = "File format is not recommended.";
    public String DataLostWarning ="Note: Your unsave data will be lost.";
    
   
    public void ImportAccounts(String DirectoryURLofImportChartOfAccounts,int TotalRowsResults, int HardSleepforFileUpload, int HardSleepAfterSubmitButtonClick) throws InterruptedException {
   
    	//TotalRowsResults are total no of data we have in our excel sheet
    	        ChartsOfAccountTab.click();
    	        Thread.sleep(2000);
    	    	WebElement upload_file = driver.findElement(By.id("fileAccountUpload"));

    			  upload_file.sendKeys(DirectoryURLofImportChartOfAccounts);
    			  Thread.sleep(HardSleepforFileUpload);//To upload the data need hard sleep
    			  String GetClassErrorCountintString=  AccountErrorCount.getText();//getting error count
    			  int GetClassErrorCount = Integer.parseInt(GetClassErrorCountintString);
    			  System.out.println(GetClassErrorCount);
    			  if(GetClassErrorCount >= 1) {
    				  Accounts_Submit_Button.click();
    				  Thread.sleep(HardSleepAfterSubmitButtonClick);
    				  Okay_Button_popup.click(); 
    				  Thread.sleep(2000);
    				  Okay_Button_popup.click();
    			  }
    			  //When All the Results are Success
    			  else if(TotalRowsResults >= 1 ) {
    				 Accounts_Submit_Button.click();
    				  Thread.sleep(HardSleepAfterSubmitButtonClick);
    				  Okay_Button_popup.click();
    			  }
    	    }

    public void ImportClass(String DirectoryURLofImportClass,int TotalRowsResults, int HardSleepforFileUpload, int HardSleepAfterSubmitButtonClick) throws InterruptedException {
    	
    	//TotalRowsResults are total no of data we have in our excel sheet
    	Thread.sleep(HardSleepAfterSubmitButtonClick);         
    	ClassTab.click();
    	   Thread.sleep(2000);
    	    	WebElement upload_file = driver.findElement(By.id("fileClassUpload"));

    			  upload_file.sendKeys(DirectoryURLofImportClass);
    			  Thread.sleep(HardSleepforFileUpload);//To upload the data need hard sleep
    			  String GetClassErrorCountintString=  ClassErrorCount.getText();//getting error count
    			  int GetClassErrorCount = Integer.parseInt(GetClassErrorCountintString);
    			  System.out.println(GetClassErrorCount);
    			  
    			  if(GetClassErrorCount >= 1) {
    				  Class_Submit_Button.click();
    				  Thread.sleep(HardSleepAfterSubmitButtonClick);
    				  Okay_Button_popup.click(); 
    				  Thread.sleep(2000);
    				  Okay_Button_popup.click();
    			  }
    			  
    			  //When All the Results are Success
    			  else if(TotalRowsResults>= 1 ) {
    				 Class_Submit_Button.click();
    				  Thread.sleep(HardSleepAfterSubmitButtonClick);
    				  Okay_Button_popup.click();
    			  }
    	    }

   
    public void ImportTerms(String DirectoryURLofImportTerms,int TotalRowsResults, int HardSleepforFileUpload, int HardSleepAfterSubmitButtonClick) throws InterruptedException {
    
    	//TotalRowsResults are total no of data we have in our excel sheet
             	TermsTab.click();
                Thread.sleep(2000);
    	    	WebElement upload_file = driver.findElement(By.id("fileTermUpload"));
    	    	
    			  upload_file.sendKeys(DirectoryURLofImportTerms);
    			  Thread.sleep(HardSleepforFileUpload);//To upload the data need hard sleep
    			  String GetClassErrorCountintString=  TermErrorCount.getText();//getting error count
    			  int GetClassErrorCount = Integer.parseInt(GetClassErrorCountintString);
    			  System.out.println(GetClassErrorCount);
    			  
    			  if(GetClassErrorCount >= 1) {
    				  Terms_Submit_Button.click();
    				  Thread.sleep(HardSleepAfterSubmitButtonClick);
    				  Okay_Button_popup.click(); 
    				  Thread.sleep(2000);
    				  Okay_Button_popup.click();
    			  }
    			  //When All the Results are Success
    			  else if(TotalRowsResults >= 1 ) {
    				 Terms_Submit_Button.click();
    				  Thread.sleep(HardSleepAfterSubmitButtonClick);
    				  Okay_Button_popup.click();
    			  }
    	    }
   
}
