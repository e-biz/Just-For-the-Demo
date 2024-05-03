package com.pages;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.StoringLocalValues.ScenarioContext;

public class RequisitionProcessFlow {

	WebDriver driver;
	JavascriptExecutor executor = (JavascriptExecutor) driver;

	public RequisitionProcessFlow(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, RequisitionProcessFlow.this);
	}

	@FindBy(xpath = "//input[@id = 'btn_NeWReq_New_UI']")
	WebElement REQ_BTN;

	@FindBy(xpath = "//input[@id ='btn_CreatePO']")
	WebElement btn_CreatePO;

	@FindBy(id = "ddlPriority")
	WebElement Priority;

	@FindBy(id = "txtMemo")
	WebElement memo;

	@FindBy(id = "txtMesgToVen")
	WebElement Notes;

	@FindBy(xpath = "//Div[@id = 'DivddlLocation']//Span[@class = 'prefix lefields-big  class-autocomplete-department   search']")
	WebElement UDFDEPT;

	@FindBy(id = "TxtUDF2")
	WebElement UDFC1;

	@FindBy(id = "TxtUDF3")
	WebElement UDFC2;

	@FindBy(id = "TxtUDF4")
	WebElement UDFC3;

	@FindBy(id = "lblReqTotal")
	WebElement REQTOTAL;

	@FindBy(id = "btn_CreatePO")
	WebElement CreatePO;

	@FindBy(id = "btn_Submit")
	WebElement SubmitReq;

	@FindBy(xpath = "//div//div//a[@id = 'btn_Save']")
	WebElement SaveReq;

	@FindBy(id = "Label18")
	WebElement REQNO;

	@FindBy(id = "Text23")
	WebElement PromiseDate;

	@FindBy(xpath = "//a[@class = 'ui-datepicker-prev ui-corner-all']//span[@class='ui-icon ui-icon-circle-triangle-w']")
	WebElement PrevBtn;

	@FindBy(xpath = "//a[@class = 'ui-datepicker-next ui-corner-all']//span[@class='ui-icon ui-icon-circle-triangle-e']")
	WebElement NextBtn;

	@FindBy(xpath = "//div[@class = 'ui-datepicker-title']//span[@class='ui-datepicker-month']")
	WebElement CurrentMonth;

	@FindBy(xpath = "//div[@class = 'ui-datepicker-title']//span[@class='ui-datepicker-year']")
	WebElement CurrentYear;

	@FindBy(id = "Text23")
	WebElement C_PrmoiseDate;

	@FindBy(id = "Text2")
	WebElement C_ReqDate;

	@FindBy(id = "//table[@id='gvRequisition']//tbody//tr[2]//td[2]")
	WebElement HomePageReqNoVerification;

	@FindBy(xpath = "//span[@id = 'Label18']")
	WebElement GetSubmittedmsg;

	@FindBy(id = "companyORcustomer")
	WebElement GetCustomerName;

	@FindBy(id = "vendor")
	WebElement GetVendorName;

	@FindBy(id = "location")
	WebElement GetLocation;

	@FindBy(id = "modalInfoClose")
	WebElement CloseBTN;

	@FindBy(id = "modalPOCreatedClose")
	WebElement POClosed;

	@FindBy(id = "Label9")
	WebElement POSuccess;

	@FindBy(xpath = "//span[@id ='Label10']")
	WebElement ApproverSubmitmsg;

	@FindBy(id = "divMainTitle")
	WebElement Header_ReqNo;

	@FindBy(id = "lblMsgPOCreated")
	WebElement PONOMsg;

	String ReqTotal;
	String ReqNo;

	@FindBy(id = "btn_Approve")
	WebElement ApproveBTN;

	@FindBy(id = "Label18")
	WebElement PopupofSUbmitCreatePOREQ;

	@FindBy(xpath = "//button[@id ='btnAddToRequisition']")
	WebElement AddtoReqBTN;

	@FindBy(xpath = "//div[@class = 'confirmModal open']//div[@id = 'dvBeforePageLeave']//img[@id='ImgYes']")
	WebElement LeavepageofReq;

	@FindBy(xpath = "//span[@class ='prefix lefields-big  class-autocomplete-vendor  search']")
	WebElement VendorLookupClick;

	@FindBy(xpath = "//span[@class='prefix lefields-big  class-autocomplete-header-customer  search']")
	WebElement CustomerLookupClick;

	@FindBy(xpath = "//div[@class ='test']//span[@class = 'prefix class-autocomplete-item lefields-big search']")
	WebElement ItemLookupClick;

	@FindBy(id = "txtDesc")
	WebElement Description;

	@FindBy(id = "ddlShipToType")
	WebElement MyCompany;

	@FindBy(xpath = "//span[@id='Label33']")
	WebElement ValidationErrorMsg;

	@FindBy(id = "btn_Reject")
	WebElement RejectButton;

	@FindBy(id = "btnwithdrawyes")
	WebElement RejectOrWithdrawProceedBtn;

	@FindBy(id = "modalRejectClose")
	WebElement CloseRejectPopup;

	@FindBy(id = "modalWithdrawClose")
	WebElement CloseWithdrawPopup;

	@FindBy(id = "btnCancel")
	WebElement WithDraw_btn;

	@FindBy(id = "btn_Save")
	WebElement saveBtn;

	@FindBy(id = "modalErrorClose")
	WebElement ModalErrorCloseIcon;

	@FindBy(id = "btnCancel")
	WebElement WithdrawnBTN;

	@FindBy(id = "txtReasonComment")
	WebElement ReasonOfCancellationReq;

	@FindBy(id = "btnwithdrawyes")
	WebElement ProceedBtnofWithdrawns;

	@FindBy(id = "modalWithdrawClose")
	WebElement CancelBtnOfWithdrawn;

	@FindBy(id = "ImgCancelYes")
	WebElement ProceedBtnOfWithdrawnTXO;

	@FindBy(id = "modalWithdrawClose")
	WebElement CancelBtnOfWithdrawnTXO;

	public String GetVendorAfterSelecting;
	public String GetCustomerAfterSelecting;
	public String Getpriority;
	public String GetLocationAfterSlecting;
	public String GetSM;
	public String POMsg;
	public String PONOmsg;
	public String CM_b;
	public String CY_b;
	public String PONO;
	public String ActualReqNo;
	public String ReqNumber;
	String EnterVendorValidationMsg = "Enter vendor!";

	public void LeaveReqPage() throws InterruptedException {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", LeavepageofReq);
		Thread.sleep(5000);
	}

//	-------------------------------Vendor Selection-----------------------------------------------------------------
	public void openVendorLookup() throws InterruptedException {
		try {
			driver.findElement(By.xpath("//span[@class ='prefix lefields-big  class-autocomplete-vendor  search']"))
					.click();
			Thread.sleep(6000);
		} catch (NoSuchElementException x) {
			driver.findElement(By.xpath("//span[@class ='prefix lefields-big  class-autocomplete-vendor  search']"))
					.click();
			Thread.sleep(6000);
		}
	}

	public void SearchVendor(String Vendorname) throws InterruptedException {
		WebElement i_vendor = driver.findElement(By.id("filterVendor"));
		i_vendor.clear();
		i_vendor.click();
		i_vendor.sendKeys(Vendorname);
		Thread.sleep(5000);
	}

	public void CloseVendorLookup() {
		driver.findElement(By.id("vendor_lookup_close")).click();
	}

	public void Select_vendor(String Vendorname) throws InterruptedException {
		Actions action = new Actions(driver);
		try {
			SearchVendor(Vendorname);
			WebElement doubleclick = driver
					.findElement(By.xpath("//div[@id = 'vendor_lookup']//tr//td[text() = '" + Vendorname + "']"));
			action.doubleClick(doubleclick).perform();
		} catch (NoSuchElementException X) {
			SearchVendor(Vendorname);
			WebElement doubleclick1 = driver
					.findElement(By.xpath("//div[@id = 'vendor_lookup']//tr//td[text() = '" + Vendorname + "']"));
			action.doubleClick(doubleclick1).perform();
			try {
			} catch (StaleElementReferenceException e) {
				SearchVendor(Vendorname);
				WebElement doubleclick2 = driver
						.findElement(By.xpath("//div[@id = 'vendor_lookup']//tr//td[text() = '" + Vendorname + "']"));
				action.doubleClick(doubleclick2).perform();
			}
		} catch (StaleElementReferenceException e) {
			SearchVendor(Vendorname);
			WebElement doubleclick3 = driver
					.findElement(By.xpath("//div[@id = 'vendor_lookup']//tr//td[text() = '" + Vendorname + "']"));
			action.doubleClick(doubleclick3).perform();
		}
	}

//	-------------------------------Vendor Selection end-----------------------------------------------------------------

//	-------------------------------Customer Selection-----------------------------------------------------------------
	public void SelectCompanyLookup() throws InterruptedException {
		Select state = new Select(MyCompany);//
		state.selectByVisibleText("My Company");
		Thread.sleep(2000);
	}

	public void OpenCustomerLookup() throws InterruptedException {
		String AppName = ScenarioContext.get("AppName");
		if (AppName.equals("TXO")) {
			driver.findElement(
					By.xpath("//span[@class='prefix lefields-big  class-autocomplete-header-customer  search']"))
					.click();
		} else {
			Select state = new Select(MyCompany);
			state.selectByVisibleText("Customer");
			Thread.sleep(2000);
			driver.findElement(
					By.xpath("//span[@class='prefix lefields-big  class-autocomplete-header-customer  search']"))
					.click();
		}
		Thread.sleep(6000);
	}

	public void SearchCustomer(String CustomerName) throws InterruptedException {
		WebElement i_Cusotmer = driver.findElement(By.id("filterShipToType"));
		i_Cusotmer.clear();
		i_Cusotmer.sendKeys(CustomerName);
		Thread.sleep(5000);
	}

	public void CloseCustomerLookup() {
		driver.findElement(By.id("shiptotype_lookup_close")).click();
	}

	public void Select_Customer(String CustomerName) throws InterruptedException {
		Actions action = new Actions(driver);
		try {
			SearchCustomer(CustomerName);
			WebElement doubleclick1 = driver.findElement(By.xpath("//tr//td[text() = '" + CustomerName + "']"));
			action.doubleClick(doubleclick1).perform();
			Thread.sleep(2000);
			memo.click();
		} catch (NoSuchElementException X) {
			SearchCustomer(CustomerName);
			WebElement doubleclick2 = driver.findElement(By.xpath("//tr//td[text() = '" + CustomerName + "']"));
			action.doubleClick(doubleclick2).perform();
			Thread.sleep(2000);
			memo.click();
			try {

			} catch (StaleElementReferenceException e) {
				SearchCustomer(CustomerName);
				WebElement doubleclick3 = driver.findElement(By.xpath("//tr//td[text() = '" + CustomerName + "']"));
				action.doubleClick(doubleclick3).perform();
				Thread.sleep(2000);
				memo.click();
			}
		} catch (StaleElementReferenceException e) {
			SearchCustomer(CustomerName);
			WebElement doubleclick4 = driver.findElement(By.xpath("//tr//td[text() = '" + CustomerName + "']"));
			action.doubleClick(doubleclick4).perform();
			Thread.sleep(2000);
			memo.click();
		}
	}
//	-------------------------------Customer Selection Ended-----------------------------------------------------------------

//	-------------------------------Select Priority For TXO-----------------------------------------------------------------

	public void SetThePriority(String priority) throws InterruptedException {
		Select pri = new Select(Priority);
		Thread.sleep(2000);
		pri.selectByVisibleText(priority);
	}

//	-------------------------------Select Priority For TXO Ended-----------------------------------------------------------------

//	------------------------------Memo and Notes and Description-----------------------------------------------------------------

	public void MemoAndNotesClear() {
		String AppName = ScenarioContext.get("AppName");
		if (AppName.equals("TXO")) {
			memo.clear();
			Notes.clear();
		} else {
			memo.clear();
			Notes.clear();
			Description.clear();
		}

	}

	public void DescriptionCommentAndNotes(String Descriptions, String Note) throws InterruptedException {
		String AppName = ScenarioContext.get("AppName");
		if (AppName.equals("TXO")) {
			memo.sendKeys(Descriptions);
			Notes.sendKeys(Note);
		} else {
			Description.sendKeys(Descriptions);
			memo.sendKeys(Descriptions);
			Notes.sendKeys(Note);
		}
	}

//	------------------------------Memo and Notes and Description-----------------------------------------------------------------

//	------------------------------Select Items-----------------------------------------------------------------

	public void OpenItemLookup() throws InterruptedException {
		ItemLookupClick.click();
		Thread.sleep(10000);
	}

	public void SearchItem(String Itemsname) throws InterruptedException {
		WebElement Search_Item = driver.findElement(
				By.xpath("//div[@id = 'item_lookup']//div[@class = 'divfilter']//input[@id = 'filterItem2']"));
		Search_Item.clear();
		Search_Item.sendKeys(Itemsname);
		Thread.sleep(5000);
	}

	public void CloseItemLoookup() throws InterruptedException {
		WebElement imgElement = driver.findElement(By.id("item_lookup_close"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", imgElement);
	}

	public void select_the_items(String Itemsname) throws InterruptedException {
		try {
			SearchItem(Itemsname);
			WebElement SelectItem = driver.findElement(By.xpath("//tbody//tr//td[text() = '" + Itemsname + "']"));
			SelectItem.click();
		} catch (NoSuchElementException X) {
			SearchItem(Itemsname);
			WebElement SelectItem = driver.findElement(By.xpath("//tbody//tr//td[text() = '" + Itemsname + "']"));
			SelectItem.click();
		}
	}

	public void AddItemToReq() throws InterruptedException {
		AddtoReqBTN.click();
		Thread.sleep(2000);
	}

//	------------------------------Select Items Ended-----------------------------------------------------------------

//	------------------------------Change Line Item Description Qty and Amount-----------------------------------------------------------------

	public void ChangeTheLineItemsDescriptionQtyAndRate(int LineItemNo, String Description, String ItemQTY,
			String ItemAmount) throws InterruptedException {
		WebElement Des = driver
				.findElement(By.xpath("//table[@id = 'grdReq']//tbody//tr[" + LineItemNo + "]//td[3]//div//textarea"));
		Des.clear();
		Des.sendKeys(Description);
		Thread.sleep(1000);
		WebElement LineItemQTY = driver
				.findElement(By.xpath("//table[@id = 'grdReq']//tbody//tr[" + LineItemNo + "]//td[7]//div//input"));
		LineItemQTY.clear();
		LineItemQTY.sendKeys(ItemQTY);
		Thread.sleep(1000);
		WebElement LineItemAmount = driver
				.findElement(By.xpath("//table[@id = 'grdReq']//tbody//tr[" + LineItemNo + "]//td[8]//div//input"));
		LineItemAmount.clear();
		LineItemAmount.sendKeys(ItemAmount);
		Thread.sleep(1000);
	}

//	------------------------------Change Line Item Description Qty and Amount Ended-----------------------------------------------------------------

//--------------------------------------Getting the Total amount of Req-------------------------------
//	 public String GetTheTotalAmount() {
//		 Actions actions = new Actions(driver);
//		 actions.moveToElement(REQTOTAL);
//		 actions.perform();
//	        String ReqTotal1 = REQTOTAL.getText();
//	         return ReqTotal = ReqTotal1.replaceAll(",", "");        
//	    }

//--------------------------------------Getting the Total amount of Req Ended-------------------------------

//-------------------------------------Delete line items-------------------------------
	public void DeleteLineItems(String LineItemNo, String Delete) {
		if (Delete.equals("Delete")) {
			WebElement DeleteLineItem = driver.findElement(By.xpath("//table[@id = 'grdReq']//tbody//tr[" + LineItemNo
					+ "]//div//a//img[@class='image-delete-ios-style']"));
			DeleteLineItem.click();
		} else {
		}
	}

//--------------------------------------Deleting Line Items ended-------------------------------

//-------------------------------------- Set and Get The ReqNo and total amount Verification------------------------------
	public void SetReqNoandtotalamountWithRespectToTheReqSeqenceCreation(String CreationofReqNo, String ReqNO,
			String ReqTotalAmount) {
		ScenarioContext.put("ReqNumber" + CreationofReqNo, ReqNO);
		ScenarioContext.put("TotalAmountOfReq" + CreationofReqNo, ReqTotalAmount);
	}

	public void GetTheReqNoandVerify(String ReqNO, String ActualReqNO) {
		String ReqNOVerification = ScenarioContext.get("ReqNumber" + ReqNO);
		Assert.assertEquals(ActualReqNO, ReqNOVerification, "ReqNo is not Correct as Expected");
	}

	public void GetTheTotalAmountandVerified(String ReqNO) {
		String acutalTotalamount = REQTOTAL.getText();
		String ReqAmount = ScenarioContext.get("TotalAmountOfReq" + ReqNO);
		Assert.assertEquals(acutalTotalamount, ReqAmount, "Amount is not Correct as Expected");
	}
//-------------------------------------- Set and Get The ReqNo and total amount Verification  Ended------------------------------

//-------------------------------------- Set and Get The PONO and total amount Verification------------------------------
	public void Set_PONO_REQNO_TotalAmount_ForTXO(String CreationofPONo, String PONO, String REQNO,
			String ReqTotalAmount) {
		ScenarioContext.put("PONO" + CreationofPONo, PONO);
		ScenarioContext.put("TotalAmountOFPO" + CreationofPONo, ReqTotalAmount);
		ScenarioContext.put("REQNOofPO" + CreationofPONo, REQNO);
	}

	public void Set_PONO_TotalAmount_ForTRX(String CreationofPONo, String PONumber, String ReqTotalAmount) {
		ScenarioContext.put("PONO" + CreationofPONo, PONumber);
		ScenarioContext.put("TotalAmountOFPO" + CreationofPONo, ReqTotalAmount);
	}

	public void GetthePONoandVerify(String PONOs, String ActualPONO) {
		String ExpectedPONOVerification = ScenarioContext.get("PONO" + PONOs);
		Assert.assertEquals(ActualPONO, ExpectedPONOVerification, "PONO is not Correct as Expected");
	}

	public void GetTheTotalofPOAmountandVerified(String PONOs, String ActualTotalAmount) {
		String ExpectedTotalAmount = ScenarioContext.get("TotalAmountOFPO" + PONOs);
		Assert.assertEquals(ActualTotalAmount, ExpectedTotalAmount, "Total Amount is not Correct as Expected");
	}

	// -------------------------------------- Set and Get The PONO and total amount
	// Verification Ended------------------------------

//	/-------------------------------------- Verification which button is appearing------------------------------/

	public void ChecktheSubmitIsAppearing() {
		Assert.assertEquals(driver.findElement(By.id("btn_Submit")).isDisplayed(), true,
				"Instead of Appearing SubmitButton there is appearing other Button please see snapshot");
	}

	public void CheckTheApproveBtnIsAppearing() {
		Assert.assertEquals(driver.findElement(By.id("btn_Approve")).isDisplayed(), true,
				"Instead of Appearing Approve Button there is appearing other Button please see snapshot");

	}

	public void CheckTheCreatePOBtnIsAppearing() {
		Assert.assertEquals(driver.findElement(By.id("btn_CreatePO")).isDisplayed(), true,
				"Instead of Appearing CreatePO Button there is appearing other Button please see snapshot");
	}

//-------------------------------------- Verification which button is appearing------------------------------

//--------------------------------------Submit Req button ------------------------------
	public void SubmitReq(String NoOfReqCreation, String ExpectedSubmittoName) throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(REQTOTAL);
		actions.perform();
		String ReqTotal1 = REQTOTAL.getText();
		ReqTotal = ReqTotal1.replaceAll(",", "");
		float total = Float.valueOf(ReqTotal);
		if (ExpectedSubmittoName.equals("Approver 01")) {
			if (total > 100.00) {
				if (SubmitReq.isDisplayed()) {
					Thread.sleep(1000);
					SubmitReq.click();
					Thread.sleep(15000);
					String GetalltheDataofSubmitPOpup = PopupofSUbmitCreatePOREQ.getText();
					String[] str1 = GetalltheDataofSubmitPOpup.split(" ");
					String ReNO = str1[2];
					SetReqNoandtotalamountWithRespectToTheReqSeqenceCreation(NoOfReqCreation, ReNO, ReqTotal1);
					String GetMsgofSubmitted = ApproverSubmitmsg.getText();
					String ExpectedSubmittedMsg = "Submitted!";
					Assert.assertEquals(GetMsgofSubmitted, ExpectedSubmittedMsg,
							"Instead of Submit msg its appearing the Wrong Msg Please see snapshot");
					String FirstName = str1[7];
					String LastName = str1[8];
					String AcutalSubmitToname = FirstName + " " + LastName;
					System.out.println("Requisition Creation No : " + NoOfReqCreation + " ReqNO : " + ReNO
							+ " and ReqTotal : " + ReqTotal1 + " Submit to : " + AcutalSubmitToname);
					System.out.println(AcutalSubmitToname);
					Assert.assertEquals(AcutalSubmitToname, ExpectedSubmittoName,
							"Submit to Name is Incorrect (Correct is Approver 01");
					CloseBTN.click();
				} else {
					Assert.fail("Instead of Submit BTN its displaying the other BTN see Snapshot");
				}
			} else {
				Assert.fail(
						"Script Failed due to the Limit of the Orginator is not working properly please see snapshot if its greater then 100 then issue is in the workflow limit.");
			}
		} else if (ExpectedSubmittoName.equals("Approver 02")) {
			if (total > 200.00) {
				if (SubmitReq.isDisplayed()) {
					Thread.sleep(1000);
					SubmitReq.click();
					Thread.sleep(15000);
					String GetalltheDataofSubmitPOpup = PopupofSUbmitCreatePOREQ.getText();
					String[] str1 = GetalltheDataofSubmitPOpup.split(" ");
					String ReNO = str1[2];
					SetReqNoandtotalamountWithRespectToTheReqSeqenceCreation(NoOfReqCreation, ReNO, ReqTotal1);
					String GetMsgofSubmitted = ApproverSubmitmsg.getText();
					String ExpectedSubmittedMsg = "Submitted!";
					Assert.assertEquals(GetMsgofSubmitted, ExpectedSubmittedMsg,
							"Instead of Submit msg its appearing the Wrong Msg Please see snapshot");
					String FirstName = str1[7];
					String LastName = str1[8];
					String AcutalSubmitToname = FirstName + " " + LastName;
					System.out.println("Requisition Creation No : " + NoOfReqCreation + " ReqNO : " + ReNO
							+ " and ReqTotal : " + ReqTotal1 + " Submit to : " + AcutalSubmitToname);
					System.out.println(AcutalSubmitToname);
					Assert.assertEquals(AcutalSubmitToname, ExpectedSubmittoName,
							"Submit to Name is Incorrect (Correct is Approver 02");
					CloseBTN.click();
				} else {
					Assert.fail("Instead of Submit BTN its displaying the other BTN see Snapshot");
				}
			} else {
				Assert.fail(
						"Script Failed due to the Limit of the Approver 01 is not working properly please see snapshot if its greater then 200 then issue is in the workflow limit.");
			}
		} else if (ExpectedSubmittoName.equals("Approver 03")) {
			if (total > 300.00) {
				if (SubmitReq.isDisplayed()) {
					Thread.sleep(1000);
					SubmitReq.click();
					Thread.sleep(15000);
					String GetalltheDataofSubmitPOpup = PopupofSUbmitCreatePOREQ.getText();
					String[] str1 = GetalltheDataofSubmitPOpup.split(" ");
					String ReNO = str1[2];
					SetReqNoandtotalamountWithRespectToTheReqSeqenceCreation(NoOfReqCreation, ReNO, ReqTotal1);
					String GetMsgofSubmitted = ApproverSubmitmsg.getText();
					String ExpectedSubmittedMsg = "Submitted!";
					Assert.assertEquals(GetMsgofSubmitted, ExpectedSubmittedMsg,
							"Instead of Submit msg its appearing the Wrong Msg Please see snapshot");
					String FirstName = str1[7];
					String LastName = str1[8];
					String AcutalSubmitToname = FirstName + " " + LastName;
					System.out.println("Requisition Creation No : " + NoOfReqCreation + " ReqNO : " + ReNO
							+ " and ReqTotal : " + ReqTotal1 + " Submit to : " + AcutalSubmitToname);
					System.out.println(AcutalSubmitToname);
					Assert.assertEquals(AcutalSubmitToname, ExpectedSubmittoName,
							"Submit to Name is Incorrect (Correct is Approver 03");
					CloseBTN.click();
				} else {
					Assert.fail("Instead of Submit BTN its displaying the other BTN see Snapshot");
				}
			} else {
				Assert.fail(
						"Script Failed due to the Limit of the Approver 02 is not working properly please see snapshot if its greater then 300 then issue is in the workflow limit.");
			}
		} else if (ExpectedSubmittoName.equals("Approver 04")) {
			if (total > 400.00) {
				if (SubmitReq.isDisplayed()) {
					Thread.sleep(1000);
					SubmitReq.click();
					Thread.sleep(15000);
					String GetalltheDataofSubmitPOpup = PopupofSUbmitCreatePOREQ.getText();
					String[] str1 = GetalltheDataofSubmitPOpup.split(" ");
					String ReNO = str1[2];
					SetReqNoandtotalamountWithRespectToTheReqSeqenceCreation(NoOfReqCreation, ReNO, ReqTotal1);
					String GetMsgofSubmitted = ApproverSubmitmsg.getText();
					String ExpectedSubmittedMsg = "Submitted!";
					Assert.assertEquals(GetMsgofSubmitted, ExpectedSubmittedMsg,
							"Instead of Submit msg its appearing the Wrong Msg Please see snapshot");
					String FirstName = str1[7];
					String LastName = str1[8];
					String AcutalSubmitToname = FirstName + " " + LastName;
					System.out.println("Requisition Creation No : " + NoOfReqCreation + " ReqNO : " + ReNO
							+ " and ReqTotal : " + ReqTotal1 + " Submit to : " + AcutalSubmitToname);
					System.out.println(AcutalSubmitToname);
					Assert.assertEquals(AcutalSubmitToname, ExpectedSubmittoName,
							"Submit to Name is Incorrect (Correct is Approver 04");
					CloseBTN.click();
				} else {
					Assert.fail("Instead of Submit BTN its displaying the other BTN see Snapshot");
				}
			} else {
				Assert.fail(
						"Script Failed due to the Limit of the Approver 03 is not working properly please see snapshot if its greater then 400 then issue is in the workflow limit.");
			}
		} else if (ExpectedSubmittoName.equals("Approver 05")) {
			if (total > 400.00) {
				if (SubmitReq.isDisplayed()) {
					Thread.sleep(1000);
					SubmitReq.click();
					Thread.sleep(15000);
					String GetalltheDataofSubmitPOpup = PopupofSUbmitCreatePOREQ.getText();
					String[] str1 = GetalltheDataofSubmitPOpup.split(" ");
					String ReNO = str1[2];
					SetReqNoandtotalamountWithRespectToTheReqSeqenceCreation(NoOfReqCreation, ReNO, ReqTotal1);
					String GetMsgofSubmitted = ApproverSubmitmsg.getText();
					String ExpectedSubmittedMsg = "Submitted!";
					Assert.assertEquals(GetMsgofSubmitted, ExpectedSubmittedMsg,
							"Instead of Submit msg its appearing the Wrong Msg Please see snapshot");
					String FirstName = str1[7];
					String LastName = str1[8];
					String AcutalSubmitToname = FirstName + " " + LastName;
					System.out.println("Requisition Creation No : " + NoOfReqCreation + " ReqNO : " + ReNO
							+ " and ReqTotal : " + ReqTotal1 + " Submit to : " + AcutalSubmitToname);
					System.out.println(AcutalSubmitToname);
					Assert.assertEquals(AcutalSubmitToname, ExpectedSubmittoName,
							"Submit to Name is Incorrect (Correct is Approver 05");
					CloseBTN.click();
				} else {
					Assert.fail("Instead of Submit BTN its displaying the other BTN see Snapshot");
				}
			} else {
				Assert.fail(
						"Script Failed due to the Limit of the Approver 04 is not working properly please see snapshot if its greater then 500 then issue is in the workflow limit.");
			}
		}

	}

	// --------------------------------------Submit Req button Ended
	// ------------------------------

	// --------------------------------------Approve Req button
	// ------------------------------

	public void ApproverReq(String NextApproverName, String CurrentOwner, String ReqNoVerification)
			throws InterruptedException {
		GoDownOfTheReqPage();
		String ReqTotal1 = REQTOTAL.getText();
		ReqTotal = ReqTotal1.replaceAll(",", "");
		float total = Float.valueOf(ReqTotal);
		WebElement GetApproverMsg = driver.findElement(By.id("Label18"));
		String AppName = ScenarioContext.get("AppName");

		if (AppName.equals("TXO")) {

			if (ApproveBTN.isDisplayed()) {
				System.out.println("User is On Txo");
				if ("Approver 01".equals(CurrentOwner)) {
					if (total >= 200) {
						ApproveBTN.click();
						Thread.sleep(15000);
						String ApprovedMsg = ApproverSubmitmsg.getText();
						Assert.assertEquals(ApprovedMsg, "Approved!",
								"Instead of Approved! there is showing other word : " + ApprovedMsg);
						String GetAllMsgOfApprovedPopup = GetApproverMsg.getText();
						String[] Approvemsg = GetAllMsgOfApprovedPopup.split(" ");
						String FirstName = Approvemsg[8];
						System.out.println(FirstName);
						String LastName = Approvemsg[9];
						System.out.println(LastName);
						String AcutalApprovalname = FirstName + " " + LastName;
						Assert.assertEquals(AcutalApprovalname, NextApproverName,
								"Next Approver is Approver 02 but there are showing the Wrong Next Approver : "
										+ AcutalApprovalname);
						String AcutalReqNoVerification = Approvemsg[2];
						GetTheReqNoandVerify(ReqNoVerification, AcutalReqNoVerification);
						CloseBTN.click();
					} else {
						Assert.fail("Wrong Button is appeared instead of Approve Button See the Snapshot");
					}
				}
				if ("Approver 02".equals(CurrentOwner)) {
					if (total >= 300) {
						ApproveBTN.click();
						Thread.sleep(15000);
						String ApprovedMsg = ApproverSubmitmsg.getText();
						Assert.assertEquals(ApprovedMsg, "Approved!",
								"Instead of Approved! there is showing other word : " + ApprovedMsg);
						String GetAllMsgOfApprovedPopup = GetApproverMsg.getText();
						String[] Approvemsg = GetAllMsgOfApprovedPopup.split(" ");
						String FirstName = Approvemsg[7];
						System.out.println("1");
						String LastName = Approvemsg[8];
						System.out.println("2");
						String AcutalApprovalname = FirstName + " " + LastName;
						Assert.assertEquals(AcutalApprovalname, NextApproverName,
								"Next Approver is Approver 02 but there are showing the Wrong Next Approver : "
										+ AcutalApprovalname);
						String AcutalReqNoVerification = Approvemsg[2];
						GetTheReqNoandVerify(ReqNoVerification, AcutalReqNoVerification);
						CloseBTN.click();
					} else {
						Assert.fail("Wrong Button is appeared instead of Approve Button See the Snapshot");
					}
				}
				if ("Approver 03".equals(CurrentOwner)) {
					if (total >= 400) {
						ApproveBTN.click();
						Thread.sleep(15000);
						String ApprovedMsg = ApproverSubmitmsg.getText();
						Assert.assertEquals(ApprovedMsg, "Approved!",
								"Instead of Approved! there is showing other word : " + ApprovedMsg);
						String GetAllMsgOfApprovedPopup = GetApproverMsg.getText();
						String[] Approvemsg = GetAllMsgOfApprovedPopup.split(" ");
						String FirstName = Approvemsg[7];
						System.out.println("1");
						String LastName = Approvemsg[8];
						System.out.println("2");
						String AcutalApprovalname = FirstName + " " + LastName;
						Assert.assertEquals(AcutalApprovalname, NextApproverName,
								"Next Approver is Approver 02 but there are showing the Wrong Next Approver : "
										+ AcutalApprovalname);
						String AcutalReqNoVerification = Approvemsg[2];
						GetTheReqNoandVerify(ReqNoVerification, AcutalReqNoVerification);
						CloseBTN.click();
					} else {
						Assert.fail("Wrong Button is appeared instead of Approve Button See the Snapshot");
					}
				}
				if ("Approver 04".equals(CurrentOwner)) {
					if (total >= 500) {
						ApproveBTN.click();
						Thread.sleep(15000);
						String ApprovedMsg = ApproverSubmitmsg.getText();
						Assert.assertEquals(ApprovedMsg, "Approved!",
								"Instead of Approved! there is showing other word : " + ApprovedMsg);
						String GetAllMsgOfApprovedPopup = GetApproverMsg.getText();
						String[] Approvemsg = GetAllMsgOfApprovedPopup.split(" ");
						String FirstName = Approvemsg[7];
						System.out.println("1");
						String LastName = Approvemsg[8];
						System.out.println("2");
						String AcutalApprovalname = FirstName + " " + LastName;
						Assert.assertEquals(AcutalApprovalname, NextApproverName,
								"Next Approver is Approver 02 but there are showing the Wrong Next Approver : "
										+ AcutalApprovalname);
						String AcutalReqNoVerification = Approvemsg[2];
						GetTheReqNoandVerify(ReqNoVerification, AcutalReqNoVerification);
						CloseBTN.click();
					} else {
						Assert.fail("Wrong Button is appeared instead of Approve Button See the Snapshot");
					}
				}
			} else {
				Assert.fail("Wrong Button is appeared instead of Approve Button See the Snapshot");
			}

		} else if (AppName.equals("Standalone") || AppName.equals("TRX")) {
			if (ApproveBTN.isDisplayed()) {
				System.out.println("User is On Standalone");
				if ("Approver 01".equals(CurrentOwner)) {
					if (total >= 200) {
						ApproveBTN.click();
						Thread.sleep(15000);
						String ApprovedMsg = ApproverSubmitmsg.getText();
						Assert.assertEquals(ApprovedMsg, "Approved!",
								"Instead of Approved! there is showing other word : " + ApprovedMsg);
						String GetAllMsgOfApprovedPopup = GetApproverMsg.getText();
						String[] Approvemsg = GetAllMsgOfApprovedPopup.split(" ");
						String FirstName = Approvemsg[7];
						System.out.println(FirstName);
						String LastName = Approvemsg[8];
						System.out.println(LastName);
						String AcutalApprovalname = FirstName + " " + LastName;
						Assert.assertEquals(AcutalApprovalname, NextApproverName,
								"Next Approver is Approver 02 but there are showing the Wrong Next Approver : "
										+ AcutalApprovalname);
						String AcutalReqNoVerification = Approvemsg[2];
						GetTheReqNoandVerify(ReqNoVerification, AcutalReqNoVerification);
						CloseBTN.click();
					} else {
						Assert.fail("Wrong Button is appeared instead of Approve Button See the Snapshot");
					}
				}
				if ("Approver 02".equals(CurrentOwner)) {
					if (total >= 300) {
						ApproveBTN.click();
						Thread.sleep(15000);
						String ApprovedMsg = ApproverSubmitmsg.getText();
						Assert.assertEquals(ApprovedMsg, "Approved!",
								"Instead of Approved! there is showing other word : " + ApprovedMsg);
						String GetAllMsgOfApprovedPopup = GetApproverMsg.getText();
						String[] Approvemsg = GetAllMsgOfApprovedPopup.split(" ");
						String FirstName = Approvemsg[7];
						System.out.println("1");
						String LastName = Approvemsg[8];
						System.out.println("2");
						String AcutalApprovalname = FirstName + " " + LastName;
						Assert.assertEquals(AcutalApprovalname, NextApproverName,
								"Next Approver is Approver 02 but there are showing the Wrong Next Approver : "
										+ AcutalApprovalname);
						String AcutalReqNoVerification = Approvemsg[2];
						GetTheReqNoandVerify(ReqNoVerification, AcutalReqNoVerification);
						CloseBTN.click();
					} else {
						Assert.fail("Wrong Button is appeared instead of Approve Button See the Snapshot");
					}
				}
				if ("Approver 03".equals(CurrentOwner)) {
					if (total >= 400) {
						ApproveBTN.click();
						Thread.sleep(15000);
						String ApprovedMsg = ApproverSubmitmsg.getText();
						Assert.assertEquals(ApprovedMsg, "Approved!",
								"Instead of Approved! there is showing other word : " + ApprovedMsg);
						String GetAllMsgOfApprovedPopup = GetApproverMsg.getText();
						String[] Approvemsg = GetAllMsgOfApprovedPopup.split(" ");
						String FirstName = Approvemsg[7];
						System.out.println("1");
						String LastName = Approvemsg[8];
						System.out.println("2");
						String AcutalApprovalname = FirstName + " " + LastName;
						Assert.assertEquals(AcutalApprovalname, NextApproverName,
								"Next Approver is Approver 02 but there are showing the Wrong Next Approver : "
										+ AcutalApprovalname);
						String AcutalReqNoVerification = Approvemsg[2];
						GetTheReqNoandVerify(ReqNoVerification, AcutalReqNoVerification);
						CloseBTN.click();
					} else {
						Assert.fail("Wrong Button is appeared instead of Approve Button See the Snapshot");
					}
				}
				if ("Approver 04".equals(CurrentOwner)) {
					if (total >= 500) {
						ApproveBTN.click();
						Thread.sleep(15000);
						String ApprovedMsg = ApproverSubmitmsg.getText();
						Assert.assertEquals(ApprovedMsg, "Approved!",
								"Instead of Approved! there is showing other word : " + ApprovedMsg);
						String GetAllMsgOfApprovedPopup = GetApproverMsg.getText();
						String[] Approvemsg = GetAllMsgOfApprovedPopup.split(" ");
						String FirstName = Approvemsg[7];
						System.out.println("1");
						String LastName = Approvemsg[8];
						System.out.println("2");
						String AcutalApprovalname = FirstName + " " + LastName;
						Assert.assertEquals(AcutalApprovalname, NextApproverName,
								"Next Approver is Approver 02 but there are showing the Wrong Next Approver : "
										+ AcutalApprovalname);
						String AcutalReqNoVerification = Approvemsg[2];
						GetTheReqNoandVerify(ReqNoVerification, AcutalReqNoVerification);
						CloseBTN.click();
					} else {
						Assert.fail("Wrong Button is appeared instead of Approve Button See the Snapshot");
					}
				}
			} else {
				Assert.fail("Wrong Button is appeared instead of Approve Button See the Snapshot");
			}
		}
	}

	// --------------------------------------Approve Req button
	// ------------------------------

	// --------------------------------------Scroll Down and UP
	// ------------------------------
	public void GoDownOfTheReqPage() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	public void GOonTopofTheReqPage() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, 0);");
	}

	// --------------------------------------Scroll Down and UP Ended
	// ------------------------------

	// --------------------------------------PO Creations
	// ------------------------------

	public void CreatePO(String CreationofPONo, String CurrentOwner, String WithWithoutLimit)
			throws InterruptedException {
		String AppName = ScenarioContext.get("AppName");
		// --------------Handling PO Creation For TXO Starts From
		// Here-----------------------
		if (AppName.equals("TXO")) {

			if (CurrentOwner.equals("Originator 01")) {
				GoDownOfTheReqPage();
				String ReqTotal1 = REQTOTAL.getText();
				ReqTotal = ReqTotal1.replaceAll(",", "");
				float total = Float.valueOf(ReqTotal);

				// WithWithoutLimit is added to check if the limit is added then verify the
				// limitation of total amount if not then Click on Create PO button Without
				// Limitation
				if (WithWithoutLimit.equals("With")) {
					if (total <= 99.99) {
						if (btn_CreatePO.isDisplayed()) {
							btn_CreatePO.click();
							Thread.sleep(15000);
							POMsg = POSuccess.getText();
							Assert.assertEquals(POMsg, "PO Created!");
							PONOmsg = PONOMsg.getText();
							String[] str1 = PONOmsg.split(" ");
							PONO = str1[7];
							String Reqno = str1[10];
							System.out.println("PO Creation NO : " + CreationofPONo + " PONO: " + PONO + " ReqNO: "
									+ Reqno + " Requisition Total; " + ReqTotal);
							Set_PONO_REQNO_TotalAmount_ForTXO(CreationofPONo, PONO, Reqno, ReqTotal);
							POClosed.click();
						} else {
							Assert.fail(
									"Please check the Workflow Routing Because Instead of PO Button there is other button is appearing");
						}
					}
				} else {
					if (btn_CreatePO.isDisplayed()) {
						btn_CreatePO.click();
						Thread.sleep(15000);
						POMsg = POSuccess.getText();
						Assert.assertEquals(POMsg, "PO Created!");
						PONOmsg = PONOMsg.getText();
						String[] str1 = PONOmsg.split(" ");
						PONO = str1[7];
						String Reqno = str1[10];
						System.out.println("PO Creation NO : " + CreationofPONo + " PONO: " + PONO + " ReqNO: " + Reqno
								+ " Requisition Total; " + ReqTotal);
						Set_PONO_REQNO_TotalAmount_ForTXO(CreationofPONo, PONO, Reqno, ReqTotal);
						System.out.println("PO is Successfully Created " + PONO);
						POClosed.click();
					} else {
						Assert.fail("Please check the Workflow Routing");
					}
				}

			} else if (CurrentOwner.equals("Approver 01")) {
				GoDownOfTheReqPage();
				String ReqTotal1 = REQTOTAL.getText();
				ReqTotal = ReqTotal1.replaceAll(",", "");
				float total = Float.valueOf(ReqTotal);

				// WithWithoutLimit is added to check if the limit is added then verify the
				// limitation of total amount if not then Click on Create PO button Without
				// Limitation
				if (WithWithoutLimit.equals("With")) {
					if (total <= 199.99) {

						if (btn_CreatePO.isDisplayed()) {
							btn_CreatePO.click();
							Thread.sleep(15000);
							POMsg = POSuccess.getText();
							Assert.assertEquals(POMsg, "PO Created!");
							PONOmsg = PONOMsg.getText();
							String[] str1 = PONOmsg.split(" ");
							PONO = str1[7];
							String Reqno = str1[10];
							System.out.println("PO Creation NO : " + CreationofPONo + " PONO: " + PONO + " ReqNO: "
									+ Reqno + " Requisition Total; " + ReqTotal);
							Set_PONO_REQNO_TotalAmount_ForTXO(CreationofPONo, PONO, Reqno, ReqTotal);
							System.out.println("PO is Successfully Created " + PONO);
							POClosed.click();
						} else {
							Assert.fail("Please check the Workflow Routing");
						}
					}
				} else {
					if (btn_CreatePO.isDisplayed()) {
						btn_CreatePO.click();
						Thread.sleep(15000);
						POMsg = POSuccess.getText();
						Assert.assertEquals(POMsg, "PO Created!");
						PONOmsg = PONOMsg.getText();
						String[] str1 = PONOmsg.split(" ");
						PONO = str1[7];
						String Reqno = str1[10];
						System.out.println("PO Creation NO : " + CreationofPONo + " PONO: " + PONO + " ReqNO: " + Reqno
								+ " Requisition Total; " + ReqTotal);
						Set_PONO_REQNO_TotalAmount_ForTXO(CreationofPONo, PONO, Reqno, ReqTotal);
						System.out.println("PO is Successfully Created " + PONO);
						POClosed.click();
					} else {
						Assert.fail("Please check the Workflow Routing");
					}
				}

			} else if (CurrentOwner.equals("Approver 02")) {
				GoDownOfTheReqPage();
				String ReqTotal1 = REQTOTAL.getText();
				ReqTotal = ReqTotal1.replaceAll(",", "");
				float total = Float.valueOf(ReqTotal);

				// WithWithoutLimit is added to check if the limit is added then verify the
				// limitation of total amount if not then Click on Create PO button Without
				// Limitation
				if (WithWithoutLimit.equals("With")) {
					if (total <= 299.99) {
						if (btn_CreatePO.isDisplayed()) {
							btn_CreatePO.click();
							Thread.sleep(15000);
							POMsg = POSuccess.getText();
							Assert.assertEquals(POMsg, "PO Created!");
							PONOmsg = PONOMsg.getText();
							String[] str1 = PONOmsg.split(" ");
							PONO = str1[7];
							String Reqno = str1[10];
							System.out.println("PO Creation NO : " + CreationofPONo + " PONO: " + PONO + " ReqNO: "
									+ Reqno + " Requisition Total; " + ReqTotal);
							Set_PONO_REQNO_TotalAmount_ForTXO(CreationofPONo, PONO, Reqno, ReqTotal);
							System.out.println("PO is Successfully Created " + PONO);
							POClosed.click();
						} else {
							Assert.fail("Please check the Workflow Routing");
						}
					}
				} else {
					if (btn_CreatePO.isDisplayed()) {
						btn_CreatePO.click();
						Thread.sleep(15000);
						POMsg = POSuccess.getText();
						Assert.assertEquals(POMsg, "PO Created!");
						PONOmsg = PONOMsg.getText();
						String[] str1 = PONOmsg.split(" ");
						PONO = str1[7];
						String Reqno = str1[10];
						System.out.println("PO Creation NO : " + CreationofPONo + " PONO: " + PONO + " ReqNO: " + Reqno
								+ " Requisition Total; " + ReqTotal);
						;
						Set_PONO_REQNO_TotalAmount_ForTXO(CreationofPONo, PONO, Reqno, ReqTotal);
						System.out.println("PO is Successfully Created " + PONO);
						POClosed.click();
					} else {
						Assert.fail("Please check the Workflow Routing");
					}
				}

			} else if (CurrentOwner.equals("Approver 03")) {
				GoDownOfTheReqPage();
				String ReqTotal1 = REQTOTAL.getText();
				ReqTotal = ReqTotal1.replaceAll(",", "");
				float total = Float.valueOf(ReqTotal);

				// WithWithoutLimit is added to check if the limit is added then verify the
				// limitation of total amount if not then Click on Create PO button Without
				// Limitation
				if (WithWithoutLimit.equals("With")) {
					if (total <= 399.99) {
						if (btn_CreatePO.isDisplayed()) {
							btn_CreatePO.click();
							Thread.sleep(15000);
							POMsg = POSuccess.getText();
							Assert.assertEquals(POMsg, "PO Created!");
							PONOmsg = PONOMsg.getText();
							String[] str1 = PONOmsg.split(" ");
							PONO = str1[7];
							String Reqno = str1[10];
							System.out.println("PO Creation NO : " + CreationofPONo + " PONO: " + PONO + " ReqNO: "
									+ Reqno + " Requisition Total; " + ReqTotal);
							Set_PONO_REQNO_TotalAmount_ForTXO(CreationofPONo, PONO, Reqno, ReqTotal);
							System.out.println("PO is Successfully Created " + PONO);
							ReqNo = str1[10];
							POClosed.click();
						} else {
							Assert.fail("Please check the Workflow Routing");
						}
					}
				} else {
					if (btn_CreatePO.isDisplayed()) {
						btn_CreatePO.click();
						Thread.sleep(15000);
						POMsg = POSuccess.getText();
						Assert.assertEquals(POMsg, "PO Created!");
						PONOmsg = PONOMsg.getText();
						String[] str1 = PONOmsg.split(" ");
						PONO = str1[7];
						String Reqno = str1[10];
						System.out.println("PO Creation NO : " + CreationofPONo + " PONO: " + PONO + " ReqNO: " + Reqno
								+ " Requisition Total; " + ReqTotal);
						Set_PONO_REQNO_TotalAmount_ForTXO(CreationofPONo, PONO, Reqno, ReqTotal);
						System.out.println("PO is Successfully Created " + PONO);
						POClosed.click();
					} else {
						Assert.fail("Please check the Workflow Routing");
					}
				}

			} else if (CurrentOwner.equals("Approver 04")) {
				GoDownOfTheReqPage();
				String ReqTotal1 = REQTOTAL.getText();
				ReqTotal = ReqTotal1.replaceAll(",", "");
				float total = Float.valueOf(ReqTotal);

				// WithWithoutLimit is added to check if the limit is added then verify the
				// limitation of total amount if not then Click on Create PO button Without
				// Limitation
				if (WithWithoutLimit.equals("With")) {
					if (total <= 499.99) {
						if (btn_CreatePO.isDisplayed()) {
							btn_CreatePO.click();
							Thread.sleep(15000);
							POMsg = POSuccess.getText();
							Assert.assertEquals(POMsg, "PO Created!");
							PONOmsg = PONOMsg.getText();
							String[] str1 = PONOmsg.split(" ");
							PONO = str1[7];
							String Reqno = str1[10];
							System.out.println("PO Creation NO : " + CreationofPONo + " PONO: " + PONO + " ReqNO: "
									+ Reqno + " Requisition Total; " + ReqTotal);
							Set_PONO_REQNO_TotalAmount_ForTXO(CreationofPONo, PONO, Reqno, ReqTotal);
							System.out.println("PO is Successfully Created " + PONO);
							ReqNo = str1[10];
							POClosed.click();
						} else {
							Assert.fail("Please check the Workflow Routing");
						}
					}
				} else {
					if (btn_CreatePO.isDisplayed()) {
						btn_CreatePO.click();
						Thread.sleep(15000);
						POMsg = POSuccess.getText();
						Assert.assertEquals(POMsg, "PO Created!");
						PONOmsg = PONOMsg.getText();
						String[] str1 = PONOmsg.split(" ");
						PONO = str1[7];
						String Reqno = str1[10];
						System.out.println("PO Creation NO : " + CreationofPONo + " PONO: " + PONO + " ReqNO: " + Reqno
								+ " Requisition Total; " + ReqTotal);
						Set_PONO_REQNO_TotalAmount_ForTXO(CreationofPONo, PONO, Reqno, ReqTotal);
						System.out.println("PO is Successfully Created " + PONO);
						POClosed.click();
					} else {
						Assert.fail("Please check the Workflow Routing");
					}
				}

			}
			// Approver 05 is the last approver so they didnot have the Amount Limit
			else if (CurrentOwner.equals("Approver 05")) {
				GoDownOfTheReqPage();
				String ReqTotal1 = REQTOTAL.getText();
				ReqTotal = ReqTotal1.replaceAll(",", "");
				if (btn_CreatePO.isDisplayed()) {
					btn_CreatePO.click();
					Thread.sleep(15000);
					POMsg = POSuccess.getText();
					Assert.assertEquals(POMsg, "PO Created!");
					PONOmsg = PONOMsg.getText();
					String[] str1 = PONOmsg.split(" ");
					PONO = str1[7];
					String Reqno = str1[10];
					System.out.println("PO Creation NO : " + CreationofPONo + " PONO: " + PONO + " ReqNO: " + Reqno
							+ " Requisition Total; " + ReqTotal);
					Set_PONO_REQNO_TotalAmount_ForTXO(CreationofPONo, PONO, Reqno, ReqTotal);
					System.out.println("PO is Successfully Created " + PONO);
					ReqNo = str1[10];
					POClosed.click();
				} else {
					Assert.fail("Please check the Workflow Routing");
				}
			}

		}
		// ----------------Trx Code For Create PO Starts From Here
		// -----------------------------------------
		else {

			// This if check is used to check That the Current Owner is Originator and If
			// Yes then Implement Verify this Limitation
			if (CurrentOwner.equals("Originator 01")) {
				GoDownOfTheReqPage();
				String ReqTotal1 = REQTOTAL.getText();
				ReqTotal = ReqTotal1.replaceAll(",", "");
				float total = Float.valueOf(ReqTotal);

				// With and WithoutLimit is added to check if the limit is added then verify the
				// limitation of total amount if not then Click on Create PO button Without
				// Limitation
				if (WithWithoutLimit.equals("With")) {
					if (total <= 99.99) {
						if (btn_CreatePO.isDisplayed()) {
							btn_CreatePO.click();
							Thread.sleep(15000);
							POMsg = POSuccess.getText();
							Assert.assertEquals(POMsg, "PO Created!");
							PONOmsg = PONOMsg.getText();
							String[] str1 = PONOmsg.split(" ");
							PONO = str1[3];
							Set_PONO_TotalAmount_ForTRX(CreationofPONo, PONO, ReqTotal);
							System.out.println(
									"PO Creation NO : " + CreationofPONo + " PO is Successfully Created " + PONO);
							POClosed.click();
						} else {
							Assert.fail("Please check the Workflow Routing");
						}
					}
				} else {
					if (btn_CreatePO.isDisplayed()) {
						btn_CreatePO.click();
						Thread.sleep(15000);
						POMsg = POSuccess.getText();
						Assert.assertEquals(POMsg, "PO Created!");
						PONOmsg = PONOMsg.getText();
						String[] str1 = PONOmsg.split(" ");
						PONO = str1[3];
						System.out.print(PONO);
						Set_PONO_TotalAmount_ForTRX(CreationofPONo, PONO, ReqTotal);
						System.out
								.println("PO Creation NO : " + CreationofPONo + " PO is Successfully Created " + PONO);
						POClosed.click();
					} else {
						Assert.fail("Please check the Workflow Routing");
					}
				}

			} else if (CurrentOwner.equals("Approver 01")) {
				GoDownOfTheReqPage();
				String ReqTotal1 = REQTOTAL.getText();
				ReqTotal = ReqTotal1.replaceAll(",", "");
				float total = Float.valueOf(ReqTotal);

				// WithWithoutLimit is added to check if the limit is added then verify the
				// limitation of total amount if not then Click on Create PO button Without
				// Limitation
				if (WithWithoutLimit.equals("With")) {
					if (total <= 199.99) {

						if (btn_CreatePO.isDisplayed()) {
							btn_CreatePO.click();
							Thread.sleep(15000);
							POMsg = POSuccess.getText();
							Assert.assertEquals(POMsg, "PO Created!");
							PONOmsg = PONOMsg.getText();
							String[] str1 = PONOmsg.split(" ");
							PONO = str1[3];
							Set_PONO_TotalAmount_ForTRX(CreationofPONo, PONO, ReqTotal);
							System.out.println(
									"PO Creation NO : " + CreationofPONo + " PO is Successfully Created " + PONO);
							POClosed.click();
						} else {
							Assert.fail("Please check the Workflow Routing");
						}
					}
				} else {
					if (btn_CreatePO.isDisplayed()) {
						btn_CreatePO.click();
						Thread.sleep(15000);
						POMsg = POSuccess.getText();
						Assert.assertEquals(POMsg, "PO Created!");
						PONOmsg = PONOMsg.getText();
						String[] str1 = PONOmsg.split(" ");
						PONO = str1[3];
						Set_PONO_TotalAmount_ForTRX(CreationofPONo, PONO, ReqTotal);
						System.out
								.println("PO Creation NO : " + CreationofPONo + " PO is Successfully Created " + PONO);
						POClosed.click();
					} else {
						Assert.fail("Please check the Workflow Routing");
					}
				}

			} else if (CurrentOwner.equals("Approver 02")) {
				GoDownOfTheReqPage();
				String ReqTotal1 = REQTOTAL.getText();
				ReqTotal = ReqTotal1.replaceAll(",", "");
				float total = Float.valueOf(ReqTotal);

				// WithWithoutLimit is added to check if the limit is added then verify the
				// limitation of total amount if not then Click on Create PO button Without
				// Limitation
				if (WithWithoutLimit.equals("With")) {
					if (total <= 299.99) {
						if (btn_CreatePO.isDisplayed()) {
							btn_CreatePO.click();
							Thread.sleep(15000);
							POMsg = POSuccess.getText();
							Assert.assertEquals(POMsg, "PO Created!");
							PONOmsg = PONOMsg.getText();
							String[] str1 = PONOmsg.split(" ");
							PONO = str1[3];
							Set_PONO_TotalAmount_ForTRX(CreationofPONo, PONO, ReqTotal);
							System.out.println(
									"PO Creation NO : " + CreationofPONo + " PO is Successfully Created " + PONO);
							POClosed.click();
						} else {
							Assert.fail("Please check the Workflow Routing");
						}
					}
				} else {
					if (btn_CreatePO.isDisplayed()) {
						btn_CreatePO.click();
						Thread.sleep(15000);
						POMsg = POSuccess.getText();
						Assert.assertEquals(POMsg, "PO Created!");
						PONOmsg = PONOMsg.getText();
						String[] str1 = PONOmsg.split(" ");
						PONO = str1[3];
						Set_PONO_TotalAmount_ForTRX(CreationofPONo, PONO, ReqTotal);
						System.out
								.println("PO Creation NO : " + CreationofPONo + " PO is Successfully Created " + PONO);
						POClosed.click();
					} else {
						Assert.fail("Please check the Workflow Routing");
					}
				}

			} else if (CurrentOwner.equals("Approver 03")) {
				GoDownOfTheReqPage();
				String ReqTotal1 = REQTOTAL.getText();
				ReqTotal = ReqTotal1.replaceAll(",", "");
				float total = Float.valueOf(ReqTotal);

				// WithWithoutLimit is added to check if the limit is added then verify the
				// limitation of total amount if not then Click on Create PO button Without
				// Limitation
				if (WithWithoutLimit.equals("With")) {
					if (total <= 399.99) {
						if (btn_CreatePO.isDisplayed()) {
							btn_CreatePO.click();
							Thread.sleep(15000);
							POMsg = POSuccess.getText();
							Assert.assertEquals(POMsg, "PO Created!");
							PONOmsg = PONOMsg.getText();
							String[] str1 = PONOmsg.split(" ");
							PONO = str1[3];
							Set_PONO_TotalAmount_ForTRX(CreationofPONo, PONO, ReqTotal);
							System.out.println(
									"PO Creation NO : " + CreationofPONo + " PO is Successfully Created " + PONO);
							POClosed.click();
						} else {
							Assert.fail("Please check the Workflow Routing");
						}
					}
				} else {
					if (btn_CreatePO.isDisplayed()) {
						btn_CreatePO.click();
						Thread.sleep(15000);
						POMsg = POSuccess.getText();
						Assert.assertEquals(POMsg, "PO Created!");
						PONOmsg = PONOMsg.getText();
						String[] str1 = PONOmsg.split(" ");
						PONO = str1[3];
						Set_PONO_TotalAmount_ForTRX(CreationofPONo, PONO, ReqTotal);
						System.out
								.println("PO Creation NO : " + CreationofPONo + " PO is Successfully Created " + PONO);
						POClosed.click();
					} else {
						Assert.fail("Please check the Workflow Routing");
					}
				}

			} else if (CurrentOwner.equals("Approver 04")) {
				GoDownOfTheReqPage();
				String ReqTotal1 = REQTOTAL.getText();
				ReqTotal = ReqTotal1.replaceAll(",", "");
				float total = Float.valueOf(ReqTotal);

				// WithWithoutLimit is added to check if the limit is added then verify the
				// limitation of total amount if not then Click on Create PO button Without
				// Limitation
				if (WithWithoutLimit.equals("With")) {
					if (total <= 499.99) {
						if (btn_CreatePO.isDisplayed()) {
							btn_CreatePO.click();
							Thread.sleep(15000);
							POMsg = POSuccess.getText();
							Assert.assertEquals(POMsg, "PO Created!");
							PONOmsg = PONOMsg.getText();
							String[] str1 = PONOmsg.split(" ");
							PONO = str1[3];
							Set_PONO_TotalAmount_ForTRX(CreationofPONo, PONO, ReqTotal);
							System.out.println(
									"PO Creation NO : " + CreationofPONo + " PO is Successfully Created " + PONO);
							POClosed.click();
						} else {
							Assert.fail("Please check the Workflow Routing");
						}
					}
				} else {
					if (btn_CreatePO.isDisplayed()) {
						btn_CreatePO.click();
						Thread.sleep(15000);
						POMsg = POSuccess.getText();
						Assert.assertEquals(POMsg, "PO Created!");
						PONOmsg = PONOMsg.getText();
						String[] str1 = PONOmsg.split(" ");
						PONO = str1[3];
						Set_PONO_TotalAmount_ForTRX(CreationofPONo, PONO, ReqTotal);
						System.out
								.println("PO Creation NO : " + CreationofPONo + " PO is Successfully Created " + PONO);
						POClosed.click();
					} else {
						Assert.fail("Please check the Workflow Routing");
					}
				}

			}
			// Approver 05 is the last approver so they did not have the Amount Limit
			else if (CurrentOwner.equals("Approver 05")) {
				GoDownOfTheReqPage();
				String ReqTotal1 = REQTOTAL.getText();
				ReqTotal = ReqTotal1.replaceAll(",", "");
				if (btn_CreatePO.isDisplayed()) {
					btn_CreatePO.click();
					Thread.sleep(15000);
					POMsg = POSuccess.getText();
					Assert.assertEquals(POMsg, "PO Created!");
					PONOmsg = PONOMsg.getText();
					String[] str1 = PONOmsg.split(" ");
					PONO = str1[3];
					Set_PONO_TotalAmount_ForTRX(CreationofPONo, PONO, ReqTotal);
					System.out.println("PO Creation NO : " + CreationofPONo + " PO is Successfully Created " + PONO);
					POClosed.click();
				} else {
					Assert.fail("Please check the Workflow Routing");
				}
			}
		}

	}

	// --------------------------------------PO Creations Ended
	// ------------------------------

	// ----------------------Verification of header ReqNo of please review
	// Req-------------------------------

	public void VerifytheREQNOofHeaderLevel(String REQNO1) {
		String Rno = ScenarioContext.get("ReqNumber" + REQNO1);
		String ActualReqNo = Header_ReqNo.getText();
		Assert.assertEquals(ActualReqNo, "Requisition #: " + Rno);
	}

	// ----------------------Verification of header ReqNo of please review Req
	// Ended-------------------------------

	// ----------------------Verification of Vendor and
	// Customer-------------------------------

	public void VerifyTheDataOfTheReqOfVendorandCustomer(String Vendor, String Customer) {

		String ActualVendor = GetVendorName.getAttribute("selectedtext");
		Assert.assertEquals(ActualVendor, Vendor, "Vendor Name is not appearing correct");

		String ActualCustomer = GetCustomerName.getAttribute("selectedtext");
		Assert.assertEquals(ActualCustomer, Customer, "Customer Name is not appearing correct");
	}
	// ----------------------Verification of Vendor and Customer
	// Ended-------------------------------

	// ----------------------Verification of Priority-------------------------------
	public void HeaderLevelPriorityVerification(String priority) {
		String Actualpriority = Priority.getAttribute("selectedtext");
		Getpriority = priority;
		Assert.assertEquals(Actualpriority, Getpriority);
	}

	// ----------------------Verification of priority
	// Ended-------------------------------

	// ----------------------Save the Req-------------------------------
	public void SavetheReq() throws InterruptedException {
		WebElement saveLink = driver.findElement(By.id("btn_Save"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", saveLink);
		Thread.sleep(10000);
		CloseBTN.click();
	}
	// ----------------------Save the Req Ended-------------------------------

	// ----------------------Verification of the total line
	// items-------------------------------

	public void VerifyTotalLineItems(int ExpectedTotalLineItemRow) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		@SuppressWarnings("unchecked")
		List<WebElement> TotalLineItemRowsCount = (List<WebElement>) jsExecutor
				.executeScript("return document.querySelectorAll(\"td[class='RowNumber']\");");
		int ActualTotalLineItemRow1 = TotalLineItemRowsCount.size();
		System.out.println(ActualTotalLineItemRow1);
		Assert.assertEquals(ActualTotalLineItemRow1, ExpectedTotalLineItemRow,
				"Expexted Count is InCorrect Actual Count which is wrong : " + ActualTotalLineItemRow1);
	}

	// ----------------------Verification of the total line items
	// Ended-------------------------------

	// ----------------------Reject Button -------------------------------

	public void RejectRequisition() throws InterruptedException {
		String AppName = ScenarioContext.get("AppName");
		if (AppName.equals("TXO")) {
			RejectButton.click();
			Thread.sleep(10000);
			CloseRejectPopup.click();
		} else {
			RejectButton.click();
			Thread.sleep(2000);
			WebElement RejectComment = driver
					.findElement(By.xpath("//div[@id='Div29']//td//textarea[@id='txtReasonComment']"));
			RejectComment.sendKeys("Rejected");
			RejectOrWithdrawProceedBtn.click();
			Thread.sleep(10000);
			CloseRejectPopup.click();
		}
	}
	// ----------------------Reject Button Ended -------------------------------

	// ----------------------Withdrawn Button -------------------------------

	public void WithDraw() throws InterruptedException {
		String AppName = ScenarioContext.get("AppName");
		if (AppName.equals("TXO")) {
			WithdrawnBTN.click();
			Thread.sleep(1000);
			ProceedBtnOfWithdrawnTXO.click();
			Thread.sleep(10000);
			CancelBtnOfWithdrawnTXO.click();
		} else {
			WithdrawnBTN.click();
			Thread.sleep(1000);
			ReasonOfCancellationReq.sendKeys("Cancelled Requisition");
			ProceedBtnofWithdrawns.click();
			Thread.sleep(10000);
			CancelBtnOfWithdrawn.click();
		}
	}

	// ----------------------Withdrawn Button Ended -------------------------------

	public void LineItemDataVerification(String LineItemNo, String LineItemName, String LineItemQty,
			String LineItemRate) {
		WebElement total = driver.findElement(By.id("lblReqTotal"));
		Actions action = new Actions(driver);
		action.moveToElement(total).click().perform();

		int lineitemno = Integer.parseInt(LineItemNo);
		int LineNo = lineitemno - 1;

		WebElement ItemsName = driver.findElement(By.xpath("//table[@id = 'grdReq']//tbody//tr[" + LineItemNo
				+ "]//td[2]//input[@class = 'class-autocomplete-item lefields-big ppfix pre search']"));
		WebElement LineItem_Qty = driver
				.findElement(By.xpath("//table[@id = 'grdReq']//tbody//tr[" + LineItemNo + "]//td[7]//input"));
		WebElement LineItem_Rate = driver
				.findElement(By.xpath("//table[@id = 'grdReq']//tbody//tr[" + LineItemNo + "]//td[8]//input"));
		WebElement LineItem_Amount = driver
				.findElement(By.xpath("//table[@id = 'grdReq']//tbody//tr[" + LineItemNo + "]//td[9]//input"));

		String IN = ItemsName.getAttribute("itemname");
		String qty = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", LineItem_Qty);
		String Rate = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", LineItem_Rate);
		String amount = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
				LineItem_Amount);

		Assert.assertEquals(IN, LineItemName, "Line Item name is not same as expected on line item Number : " + LineNo);
		Assert.assertEquals(Rate, LineItemRate,
				"Line Item Rate is not same as expected on line item Number : " + LineNo);
		Assert.assertEquals(qty, LineItemQty, "Line Item Qty is not same as expected on line item Number : " + LineNo);

		float rate = Float.parseFloat(LineItemRate);
		float quantity = Float.parseFloat(LineItemQty);
		float totalAmount = rate * quantity;
		String actualAmount = String.format("%.2f", totalAmount);
		Assert.assertEquals(amount, actualAmount,
				"Line Item Amount is not same as expected on line item Number : " + LineNo);
		System.out.println(LineItemNo + " " + LineNo + " Total Amount: " + totalAmount);
	}
}
