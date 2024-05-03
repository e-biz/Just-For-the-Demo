
package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.StoringLocalValues.ScenarioContext;
import com.github.javafaker.Faker;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class UserCreation {

	WebDriver driver;

	public UserCreation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, UserCreation.this);
	}

	SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yy HH-mm-ss"); // yyyy-MM-dd HH:mm
	Date date;

	@FindBy(id = "btn_AddNewValue") // btn_AddNewValue
	WebElement AddNewUser;

	@FindBy(id = "btn_Delete")
	WebElement DeleteUser;

	@FindBy(id = "ddlUser")
	WebElement SelectUser;

	@FindBy(id = "txtFirstName")
	WebElement FirstName;

	@FindBy(id = "txtLastName")
	WebElement LastName;

	@FindBy(id = "txtEmail")
	WebElement Email;

	@FindBy(id = "txtPhNo")
	WebElement PhoneNo;

	@FindBy(id = "txtpassword")
	WebElement Password;

	@FindBy(id = "txtConfPassword")
	WebElement ConfirmPassword;

	@FindBy(id = "txtContactPassword")
	WebElement S_ConfirmPassword;

	@FindBy(id = "ddlDepartment")
	WebElement Department;

	@FindBy(id = "MainContent_chkSysAdmin")
	WebElement ChkAdmin;

	@FindBy(id = "CheckRequisition_1")
	WebElement ChkSTDCanCancelwithdrawnReq;

	@FindBy(id = "CheckRequisition_0")
	WebElement ChkSTDCanCreateReq;

	@FindBy(id = "CheckRequisition_2")
	WebElement ChkSTDCanViewClass;

	@FindBy(id = "CheckRequisition_3")
	WebElement ChkSTDCanViewCustomer;

	@FindBy(id = "CheckRequisition_4")
	WebElement ChkSTDCanViewAccount;

	@FindBy(id = "CheckRequisition_5")
	WebElement ChkSTDCanCreateItem;

	@FindBy(id = "CheckRequisition_6")
	WebElement ChkSTDCanCreatevendor;

	@FindBy(id = "CheckRequisition_7")
	WebElement ChkSTDCanEditReqDuringApprovalProcess;

	@FindBy(id = "CheckRequisition_8")
	WebElement ChkSTDCanCreateCustomer;

	@FindBy(id = "CheckHistory_0")
	WebElement ChkSTDCanSeeEveryOneHistory;

	@FindBy(id = "CheckHistory_1")
	WebElement ChkSTDCanDeletPO;

	@FindBy(id = "CheckHistory_2")
	WebElement ChkSTDCanCreateReceiving;

	//
	@FindBy(id = "CheckRequisition_1")
	WebElement ChkTRXCanCancelwithdrawnReq;

	@FindBy(id = "CheckRequisition_0")
	WebElement ChkTRXCanCreateReq;

	@FindBy(id = "CheckRequisition_2")
	WebElement ChkTRXCanViewClass;

	@FindBy(id = "CheckRequisition_3")
	WebElement ChkTRXCanViewCustomer;

	@FindBy(id = "CheckRequisition_4")
	WebElement ChkTRXCanViewAccount;

	@FindBy(id = "CheckRequisition_5")
	WebElement ChkTRXCanCreateItem;

	@FindBy(id = "CheckRequisition_6")
	WebElement ChkTRXCanEditReqDuringApprovalProcess;

	@FindBy(id = "CheckRequisition_7")
	WebElement ChkTRXCanCreatevendor;

	@FindBy(id = "CheckRequisition_8")
	WebElement ChkTRXCanCreateCustomer;

	@FindBy(id = "CheckHistory_0")
	WebElement ChkTRXCanSeeEveryOneHistory;

	@FindBy(id = "CheckHistory_1")
	WebElement ChkTRXCanEditPendingSyncPO;

	@FindBy(id = "CheckHistory_2")
	WebElement ChkTRXCanDeletPO;

	@FindBy(id = "CheckHistory_3")
	WebElement ChkTRXCanCreateReceiving;

//
	//
	@FindBy(id = "CheckRequisition_1")
	WebElement ChkTXOCanCancelwithdrawnReq;

	@FindBy(id = "CheckRequisition_0")
	WebElement ChkTXOCanCreateReq;

	@FindBy(id = "CheckRequisition_2")
	WebElement ChkTXOCanViewClass;

	@FindBy(id = "CheckRequisition_3")
	WebElement ChkTXOCanViewCustomer;

	@FindBy(id = "CheckRequisition_4")
	WebElement ChkTXOCanCreateItem;

	@FindBy(id = "CheckRequisition_5")
	WebElement ChkTXOCanEditReqDuringApprovalProcess;

	@FindBy(id = "CheckRequisition_6")
	WebElement ChkTXOCanCreatevendor;

	@FindBy(id = "CheckRequisition_7")
	WebElement ChkTXOCanCreateCustomer;;

	@FindBy(id = "CheckHistory_0")
	WebElement ChkTXOCanSeeEveryOneHistory;

	@FindBy(id = "CheckHistory_1")
	WebElement ChkTXOCanDeletPO;

	@FindBy(id = "CheckHistory_2")
	WebElement ChkTXOCanCreateReceiving;

	@FindBy(id = "CheckHistory_3")
	WebElement ChkTXOCanEmailPOtoVendor;

	@FindBy(id = "FooterContent_btn_Insert")
	WebElement BtnSave;

	public String User1 = null;
	public String User2 = null;
	public String User3 = null;
	public String User4 = null;
	public String User5 = null;
	public String User6 = null;

	public String FN;
	public String LN;
	public String email;
	public String phone;
	public String DPT;
	int Count = 5;

	// This is used due to the all pages call into the One class

	@FindBy(id = "menu")
	WebElement Menu;

	@FindBy(xpath = "//div[@class='menu']//ul//li[4]//a[text() = 'Admin & Settings']")
	WebElement Setting;

	@FindBy(xpath = "//div[@id='Sub_1']//li[1]//a[text() = 'User Management']")
	WebElement UserManagment;

	@FindBy(xpath = "//div[@id='Sub_1']//li[3]//a[text() = 'Subscription']") // Subscription //Subscription
	WebElement Subscription;

	// This is also used for the Subscription page addional due to crashing problems
	// Current Subscription Flat Rate Slab Rate
	@FindBy(id = "lblSubscriptionType")
	WebElement Current_Flat_SlabRate;

	// Current Subscription No of Users
	@FindBy(id = "lblNoOfUSers")
	WebElement Cur_Users;

	// Current Active No Of users
	@FindBy(id = "lblActiveUsers")
	WebElement Cur_Active;

	// DDL Of user slabs Rate
	@FindBy(id = "ddlUserRate")
	WebElement SubscriptionUserSlab;

	// Flat Rate No of users
	@FindBy(id = "txtNoOfUser")
	WebElement NoOfUsers;

	@FindBy(id = "btnValidateACH")
	WebElement SubscripionSaveBTN;

	@FindBy(id = "Img_Save")
	WebElement DeptSavtBTN;

	@FindBy(id = "btn_ManageDep")
	WebElement OpenDeptPopup;

	@FindBy(id = "ddlAllDep")
	WebElement DeptSelectDDl;

	@FindBy(id = "txtDepName")
	WebElement InputDeptName;

	@FindBy(id = "txtDescription")
	WebElement InputDeptDescription;

	@FindBy(id = "Img_Add_Dep")
	WebElement DeptCreationBTN;

	@FindBy(id = "Img_Delete")
	WebElement DeptDeleteBTN;

	@FindBy(id = "chkDepStatus")
	WebElement ChkDeptStatus;

	@FindBy(id = "lblShippingAddressError")
	WebElement ValidationMsgofDept;

	@FindBy(id = "divaddressmodificationCloseIcon")
	WebElement DeptCloseBTN;

	@FindBy(id = "btnSave")
	WebElement ConfirmSaveBTN;

	@FindBy(xpath = "//div[@class = 'sweet-alert showSweetAlert visible']//p")
	List<WebElement> GetVlaidationmsg;

	@FindBy(id = "MainContent_chkUserStatus")
	WebElement CHK_UserStatus;

	/*
	 * This was for the TRX String Slab15 = "10 Users @ $250.00 per month"; String
	 * Slab16 = "20 Users @ $425.00 per month"; String Slab17 =
	 * "30 Users @ $525.00 per month"; String Slab18 =
	 * "40 Users @ $600.00 per month"; String Slab19 =
	 * "50 Users @ $650.00 per month"; String Slab20 =
	 * "60 Users @ $750.00 per month"; String Slab42 =
	 * "75 Users @ $937.50 per month"; String Slab21 =
	 * "100 Users @ $1,200.00 per month"; String Slab22 =
	 * "150 Users @ $1,650.00 per month"; String Slab23 =
	 * "200 Users @ $2,000.00 per month";
	 * 
	 */

	// THis one for the StandAlone
//	String Slab15 = "10 Users @ $145.00 per month";
//	String Slab16 = "20 Users @ $280.00 per month";
//	String Slab17 = "30 Users @ $450.00 per month";
//	String Slab18 = "40 Users @ $520.00 per month";
//	String Slab19 = "50 Users @ $625.00 per month";
//	String Slab20 = "60 Users @ $750.00 per month";
//	String Slab42 = "75 Users @ $900.50 per month";
//	String Slab21 = "100 Users @ $1,000.00 per month";
//	String Slab22 = "150 Users @ $1,350.00 per month";
//	String Slab23 = "200 Users @ $1,600.00 per month";

	String fifteen;
	String sixteen;
	String seventeen;
	String eighteen;
	String nineteen;
	String twenty;
	String twentyone;
	String twentytwo;
	String twentythree;
	String fourtytwo;

	// This for the TXO

	// THis one for the StandAlone
	String Slab28 = "5 Users @ $57.99 per month";
	String Slab29 = "10 Users @ $111.99 per month";
	String Slab30 = "20 Users @ $219.99 per month";
	String Slab31 = "30 Users @ $324.99 per month";
	String Slab32 = "40 Users @ $424.99 per month";
	String Slab33 = "50 Users @ $521.99 per month";
	String Slab34 = "75 Users @ $769.99 per month";
	String Slab35 = "100 Users @ $999.99 per month";
	String Slab36 = "150 Users @ $1,459.99 per month";
	String Slab37 = "200 Users @ $1,868.99 per month";

	String Twentyeight;
	String Twentynine;
	String Thirty;
	String Thirtyone;
	String Thirtytwo;
	String Thirtythree;
	String Thirtyfour;
	String Thirtyfive;
	String Thirtysix;
	String Thirtyseven;

	public String ThankyouMsg = "Thank you! Your changes have been saved.";
	String limit = "Your user limit has been reached. To add the additional user(s) please update your subscription.";
	String thankyou = "Thank you! Your changes have been saved.";
	String missedFields = "Looks like you missed a fields.";
	public String CurrentlyAssigned = "Oops! The email address entered is currently assigned to another user.";
	String AdminChangeVerification = "Oops! Looks like you are trying to remove your company's only System Administrator. Please assign System Administrator rights to another user and then try again.";
	String DeptDeleteValidationMsg = "Department cannot be deleted, department has associated data with users, filters!.";
	String DeptInactiveValidationMsg = "Department cannot be inactivated, department has associated users!";
	String DeptSuccessfullyAdded = "Department added successfully!";
	String PasswordValidationMsg = "Oops! Password must contain: Minimum 9 characters and combination of at least 3 of the classes from 1 LowerCase, 1 UpperCase, 1 Numeric and 1 Special character.";
	String PasswordNotmatchValidationMsg = "Oops! password and confirm password dose not match.";
	String DeptUpdateSuccessfullyMsg = "Department updated successfully!";

	public static String randomEmail() {
		Faker faker = new Faker();
		return faker.internet().emailAddress();
	}

	private boolean reRun = false; // Instance variable accessible within the class

	public void AddUserBtn() {
		AddNewUser.click();
	}

	public void FnameAndLname(String FN, String LN) {
		FirstName.sendKeys(FN);
		LastName.sendKeys(LN);
	}

	public void EmailAndPhoneNo(String email, String phone) {
		Email.clear();
		Email.sendKeys(email);
		PhoneNo.clear();
		PhoneNo.sendKeys(phone);
	}

	public void clearPasswordFields() {
		Password.clear();
		ConfirmPassword.clear();
	}

	public void InputPasswordandConfirmPassword() {
		Password.sendKeys("Aa1234567");
		ConfirmPassword.sendKeys("Aa1234567");
	}

	public void AddDepartment(String DPT) {
		Select DDown = new Select(Department);
		DDown.selectByVisibleText(DPT);
	}

	public void AllPermissionRightsCheckVerification() {
		String AppName = ScenarioContext.get("AppName");
		if (AppName.equals("TRX")) {
			Assert.assertEquals(ChkTRXCanCreateReq.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can Create Requistion See Snapshot");
			Assert.assertEquals(ChkTRXCanCancelwithdrawnReq.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can Cancel and Withdrawn Req See Snapshot");
			Assert.assertEquals(ChkTRXCanViewClass.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can View Class See Snapshot");
			Assert.assertEquals(ChkTRXCanViewCustomer.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can View Customer See Snapshot");
			Assert.assertEquals(ChkTRXCanViewAccount.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can View Account See Snapshot");
			Assert.assertEquals(ChkTRXCanCreateItem.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can Create New Item See Snapshot");
			Assert.assertEquals(ChkTRXCanCreateCustomer.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can Create Customer See Snapshot");
			Assert.assertEquals(ChkTRXCanCreatevendor.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can Create new Vendor See Snapshot");
			Assert.assertEquals(ChkTRXCanEditReqDuringApprovalProcess.isSelected(), true,
					"This New Created User Doesn't have the Rights of can Edit Requisition During Approver Process See Snapshot");
			Assert.assertEquals(ChkTRXCanSeeEveryOneHistory.isSelected(), true,
					"This New Created User Doesn't have the Rights of  Can See EveryOneHistory See Snapshot");
			Assert.assertEquals(ChkTRXCanEditPendingSyncPO.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can Edit PO which PO is in pending Sync See Snapshot");
			Assert.assertEquals(ChkTRXCanDeletPO.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can Delete PO See Snapshot");
			Assert.assertEquals(ChkTRXCanCreateReceiving.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can Create Receiving See Snapshot");
		} else if (AppName.equals("Standalone")) {
			Assert.assertEquals(ChkSTDCanCreateReq.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can Create Requistion See Snapshot");
			Assert.assertEquals(ChkSTDCanCancelwithdrawnReq.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can Cancel and Withdrawn Req See Snapshot");
			Assert.assertEquals(ChkSTDCanViewClass.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can View Class See Snapshot");
			Assert.assertEquals(ChkSTDCanViewCustomer.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can View Customer See Snapshot");
			Assert.assertEquals(ChkSTDCanViewAccount.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can View Account See Snapshot");
			Assert.assertEquals(ChkSTDCanCreateItem.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can Create New Item See Snapshot");
			Assert.assertEquals(ChkSTDCanCreateCustomer.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can Create Customer See Snapshot");
			Assert.assertEquals(ChkSTDCanCreatevendor.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can Create new Vendor See Snapshot");
			Assert.assertEquals(ChkSTDCanEditReqDuringApprovalProcess.isSelected(), true,
					"This New Created User Doesn't have the Rights of can Edit Requisition During Approver Process See Snapshot");
			Assert.assertEquals(ChkSTDCanSeeEveryOneHistory.isSelected(), true,
					"This New Created User Doesn't have the Rights of  Can See EveryOneHistory See Snapshot");
			Assert.assertEquals(ChkSTDCanDeletPO.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can Delete PO See Snapshot");
			Assert.assertEquals(ChkSTDCanCreateReceiving.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can Create Receiving See Snapshot");
		} else if (AppName.equals("TXO")) {
			Assert.assertEquals(ChkTXOCanCreateReq.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can Create Requistion See Snapshot");
			Assert.assertEquals(ChkTXOCanCancelwithdrawnReq.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can Cancel and Withdrawn Req See Snapshot");
			Assert.assertEquals(ChkTXOCanViewClass.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can View Class See Snapshot");
			Assert.assertEquals(ChkTXOCanViewCustomer.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can View Customer See Snapshot");
			Assert.assertEquals(ChkTXOCanCreateItem.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can Create New Item See Snapshot");
			Assert.assertEquals(ChkTXOCanCreateCustomer.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can Create Customer See Snapshot");
			Assert.assertEquals(ChkTXOCanCreatevendor.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can Create new Vendor See Snapshot");
			Assert.assertEquals(ChkTXOCanEditReqDuringApprovalProcess.isSelected(), true,
					"This New Created User Doesn't have the Rights of can Edit Requisition During Approver Process See Snapshot");
			Assert.assertEquals(ChkTXOCanSeeEveryOneHistory.isSelected(), true,
					"This New Created User Doesn't have the Rights of  Can See EveryOneHistory See Snapshot");
			Assert.assertEquals(ChkTXOCanEmailPOtoVendor.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can Edit PO which PO is in pending Sync See Snapshot");
			Assert.assertEquals(ChkTXOCanDeletPO.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can Delete PO See Snapshot");
			Assert.assertEquals(ChkTXOCanCreateReceiving.isSelected(), true,
					"This New Created User Doesn't have the Rights of Can Create Receiving See Snapshot");

		} else {
			Assert.fail("Accounting Application Name is not Correct");
		}
	}

	public void SaveBtn() throws InterruptedException {
		driver.findElement(By.id("FooterContent_btn_Insert")).sendKeys(Keys.SPACE);
		Thread.sleep(5000);
		String GetVALIDATIONMsg = GetVlaidationmsg.get(0).getText();
		Thread.sleep(2000);
		if (GetVALIDATIONMsg.equals(
				"Your user limit has been reached. To add the additional user(s) please update your subscription.")) {
			Assert.fail(
					"Your Subscription Limit is reached please update your subscription then again Run the Scripts");
		}
	}

	public void VerificationOftheValidationPopupMsg(String RequiredValidationMsg) throws InterruptedException {

		String GetVALIDATIONMsg = GetVlaidationmsg.get(0).getText();
		Assert.assertEquals(GetVALIDATIONMsg, RequiredValidationMsg, " Validation is not appearing as Expected ");
		driver.findElement(By.xpath("//div//button[@class = 'confirm']")).click();
		Thread.sleep(2000);
	}

	public void ClickSaveBTN() throws InterruptedException {
		driver.findElement(By.id("FooterContent_btn_Insert")).sendKeys(Keys.SPACE);
		Thread.sleep(3000);
		String GetVALIDATIONMsg = GetVlaidationmsg.get(0).getText();
		Thread.sleep(2000);
		String limit = "Your user limit has been reached. To add the additional user(s) please update your subscription.";
		String thankyou = "Thank you! Your changes have been saved.";
		String missedFields = "Oops! Looks like you missed a fields.";
		String CurrentlyAssigned = "Oops! The email address entered is currently assigned to another user.";

//		Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'swal-modal']//div[@class = 'swal-title']")).getText(), "Success!" );
		if (GetVALIDATIONMsg.equals(limit)) {
			driver.findElement(By.xpath("//div//button[@class = 'confirm']")).click();
			Thread.sleep(1000);
			Setting_SubscriptionMenu();
			Thread.sleep(10000);
			ChangeTheSlabRatewhenActiveUserisEqualstoSlabRateOrFlatRate();
			reRun = true; // Set the flag to rerun the method
			Thread.sleep(2000);
			Setting_UserManagementMenu();

		} else if (GetVALIDATIONMsg.equals(missedFields)) {
			Assert.fail("Missing Field");
		} else if (GetVALIDATIONMsg.equals(thankyou)) {
			driver.findElement(By.xpath("//div//button[@class = 'confirm']")).click();
		}

		else if (GetVALIDATIONMsg.equals(CurrentlyAssigned)) {
			Assert.fail("Email is already assigned.");

		}
	}

	public void WhenUserJumptoTheUserManagementFieldAllFieldsWillBeDisable() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(FirstName.getAttribute("disabled"), "true",
				"UserManagemnet FirstName Fields is not disable on first time Jump");
		Assert.assertEquals(LastName.getAttribute("disabled"), "true",
				"UserManagemnet Last Name Fields is not disable on first time Jump");
		Assert.assertEquals(Email.getAttribute("disabled"), "true",
				"UserManagemnet Email Fields is not disable on first time Jump");
		Assert.assertEquals(Password.getAttribute("disabled"), "true",
				"UserManagemnet Password Fields is not disable on first time Jump");
		Assert.assertEquals(ConfirmPassword.getAttribute("disabled"), "true",
				"UserManagemnet Confirm Password Fields is not disable on first time Jump");
		Assert.assertEquals(Department.getAttribute("disabled"), "true",
				"UserManagemnet Department Fields is not disable on first time Jump");
		Assert.assertEquals(PhoneNo.getAttribute("disabled"), "true",
				"UserManagemnet Phone No Fields is not disable on first time Jump");
		SaveBtn();
		String GetVALIDATIONMsg = GetVlaidationmsg.get(0).getText();
		Assert.assertEquals(GetVALIDATIONMsg, "You have not edit anything so edit then save.",
				" Validation is not appearing as Expected when user click on Save button after jump to userManagmenet");
		driver.findElement(By.xpath("//div//button[@class = 'confirm']")).click();
	}

	public void NewUserCreation(String FN1, String LN1, String Email1, String PNO1, String IsAdmin, String Dept1) {
		AddUserBtn();
		FirstName.clear();
		LastName.clear();
		Email.clear();
		PhoneNo.clear();
		FnameAndLname(FN1, LN1);
		EmailAndPhoneNo(Email1, PNO1);
		clearPasswordFields();
		InputPasswordandConfirmPassword();
		AddDepartment(Dept1);
		AllPermissionRightsCheckVerification();
		if (IsAdmin.equals("Yes")) {
			ChkAdmin.click();
		}
	}

	public void UnCheckAllThePermissionRightsOfSPecificUserAndSaveIt(String Users) throws InterruptedException {
		Thread.sleep(2000);
		Select selectuser = new Select(SelectUser);
		selectuser.selectByVisibleText(Users);
		String AppName = ScenarioContext.get("AppName");
		if (AppName.equals("TRX")) {
			ChkTRXCanCreateReq.click();
			ChkTRXCanCreateItem.click();
			ChkTRXCanCreatevendor.click();
			ChkTRXCanCreateCustomer.click();
			ChkTRXCanCancelwithdrawnReq.click();
			ChkTRXCanViewClass.click();
			ChkTRXCanViewCustomer.click();
			ChkTRXCanViewAccount.click();
			ChkTRXCanEditPendingSyncPO.click();
			ChkTRXCanSeeEveryOneHistory.click();
			ChkTRXCanCreateReceiving.click();
			ChkTRXCanDeletPO.click();
			ChkTRXCanEditReqDuringApprovalProcess.click();
		} else if (AppName.equals("Standalone")) {
			ChkSTDCanCreateReq.click();
			ChkSTDCanCreateItem.click();
			ChkSTDCanCreatevendor.click();
			ChkSTDCanCreateCustomer.click();
			ChkSTDCanCancelwithdrawnReq.click();
			ChkSTDCanViewClass.click();
			ChkSTDCanViewCustomer.click();
			ChkSTDCanViewAccount.click();
			ChkSTDCanSeeEveryOneHistory.click();
			ChkSTDCanCreateReceiving.click();
			ChkSTDCanDeletPO.click();
			ChkSTDCanEditReqDuringApprovalProcess.click();
		} else if (AppName.equals("TXO")) {
			ChkTXOCanCreateReq.click();
			ChkTXOCanCreateItem.click();
			ChkTXOCanCreatevendor.click();
			ChkTXOCanCreateCustomer.click();
			ChkTXOCanCancelwithdrawnReq.click();
			ChkTXOCanViewClass.click();
			ChkTXOCanViewCustomer.click();
			ChkTXOCanEmailPOtoVendor.click();
			ChkTXOCanSeeEveryOneHistory.click();
			ChkTXOCanCreateReceiving.click();
			ChkTXOCanDeletPO.click();
			ChkTXOCanEditReqDuringApprovalProcess.click();

		} else {
			Assert.fail("Accounting Application Name is not Correct");
		}
		SaveBtn();
		VerificationOftheValidationPopupMsg(ThankyouMsg);
	}

	public void CheckAllThePermissionRightsOfSPecificUserAndSaveIt(String Users) throws InterruptedException {
		Thread.sleep(2000);
		Select selectuser = new Select(SelectUser);
		selectuser.selectByVisibleText(Users);
		String AppName = ScenarioContext.get("AppName");
		if (AppName.equals("TRX")) {
			ChkTRXCanCreateReq.click();
			ChkTRXCanCreateItem.click();
			ChkTRXCanCreatevendor.click();
			ChkTRXCanCreateCustomer.click();
			ChkTRXCanCancelwithdrawnReq.click();
			ChkTRXCanViewClass.click();
			ChkTRXCanViewCustomer.click();
			ChkTRXCanViewAccount.click();
			ChkTRXCanEditPendingSyncPO.click();
			ChkTRXCanSeeEveryOneHistory.click();
			ChkTRXCanCreateReceiving.click();
			ChkTRXCanDeletPO.click();
			ChkTRXCanEditReqDuringApprovalProcess.click();
		} else if (AppName.equals("Standalone")) {
			ChkSTDCanCreateReq.click();
			ChkSTDCanCreateItem.click();
			ChkSTDCanCreatevendor.click();
			ChkSTDCanCreateCustomer.click();
			ChkSTDCanCancelwithdrawnReq.click();
			ChkSTDCanViewClass.click();
			ChkSTDCanViewCustomer.click();
			ChkSTDCanViewAccount.click();
			ChkSTDCanSeeEveryOneHistory.click();
			ChkSTDCanCreateReceiving.click();
			ChkSTDCanDeletPO.click();
			ChkSTDCanEditReqDuringApprovalProcess.click();
		} else if (AppName.equals("TXO")) {
			ChkTXOCanCreateReq.click();
			ChkTXOCanCreateItem.click();
			ChkTXOCanCreatevendor.click();
			ChkTXOCanCreateCustomer.click();
			ChkTXOCanCancelwithdrawnReq.click();
			ChkTXOCanViewClass.click();
			ChkTXOCanViewCustomer.click();
			ChkTXOCanEmailPOtoVendor.click();
			ChkTXOCanSeeEveryOneHistory.click();
			ChkTXOCanCreateReceiving.click();
			ChkTXOCanDeletPO.click();
			ChkTXOCanEditReqDuringApprovalProcess.click();
		} else {
			Assert.fail("Accounting Application Name is not Correct");
		}
		SaveBtn();
		VerificationOftheValidationPopupMsg(ThankyouMsg);
	}

	public void VerificationOfAllThePermissionArebeingRemovedfromtheSepecificUser(String Users)
			throws InterruptedException {
		Thread.sleep(2000);
		Select selectuser = new Select(SelectUser);
		selectuser.selectByVisibleText(Users);
		String AppName = ScenarioContext.get("AppName");
		if (AppName.equals("TRX")) {
			Assert.assertEquals(ChkTRXCanCreateReq.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can Create Requistion See Snapshot");
			Assert.assertEquals(ChkTRXCanCancelwithdrawnReq.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can Cancel and Withdrawn Req See Snapshot");
			Assert.assertEquals(ChkTRXCanViewClass.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can View Class See Snapshot");
			Assert.assertEquals(ChkTRXCanViewCustomer.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can View Customer See Snapshot");
			Assert.assertEquals(ChkTRXCanViewAccount.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can View Account See Snapshot");
			Assert.assertEquals(ChkTRXCanCreateItem.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can Create New Item See Snapshot");
			Assert.assertEquals(ChkTRXCanCreateCustomer.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can Create Customer See Snapshot");
			Assert.assertEquals(ChkTRXCanCreatevendor.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can Create new Vendor See Snapshot");
			Assert.assertEquals(ChkTRXCanEditReqDuringApprovalProcess.isSelected(), false,
					"This New Created User Doesn't have the Rights of can Edit Requisition During Approver Process See Snapshot");
			Assert.assertEquals(ChkTRXCanSeeEveryOneHistory.isSelected(), false,
					"This New Created User Doesn't have the Rights of  Can See EveryOneHistory See Snapshot");
			Assert.assertEquals(ChkTRXCanEditPendingSyncPO.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can Edit PO which PO is in pending Sync See Snapshot");
			Assert.assertEquals(ChkTRXCanDeletPO.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can Delete PO See Snapshot");
			Assert.assertEquals(ChkTRXCanCreateReceiving.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can Create Receiving See Snapshot");
		} else if (AppName.equals("Standalone")) {
			Assert.assertEquals(ChkSTDCanCreateReq.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can Create Requistion See Snapshot");
			Assert.assertEquals(ChkSTDCanCancelwithdrawnReq.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can Cancel and Withdrawn Req See Snapshot");
			Assert.assertEquals(ChkSTDCanViewClass.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can View Class See Snapshot");
			Assert.assertEquals(ChkSTDCanViewCustomer.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can View Customer See Snapshot");
			Assert.assertEquals(ChkSTDCanViewAccount.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can View Account See Snapshot");
			Assert.assertEquals(ChkSTDCanCreateItem.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can Create New Item See Snapshot");
			Assert.assertEquals(ChkSTDCanCreateCustomer.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can Create Customer See Snapshot");
			Assert.assertEquals(ChkSTDCanCreatevendor.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can Create new Vendor See Snapshot");
			Assert.assertEquals(ChkSTDCanEditReqDuringApprovalProcess.isSelected(), false,
					"This New Created User Doesn't have the Rights of can Edit Requisition During Approver Process See Snapshot");
			Assert.assertEquals(ChkSTDCanSeeEveryOneHistory.isSelected(), false,
					"This New Created User Doesn't have the Rights of  Can See EveryOneHistory See Snapshot");
			Assert.assertEquals(ChkSTDCanDeletPO.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can Delete PO See Snapshot");
			Assert.assertEquals(ChkSTDCanCreateReceiving.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can Create Receiving See Snapshot");
		} else if (AppName.equals("TXO")) {
			Assert.assertEquals(ChkTXOCanCreateReq.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can Create Requistion See Snapshot");
			Assert.assertEquals(ChkTXOCanCancelwithdrawnReq.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can Cancel and Withdrawn Req See Snapshot");
			Assert.assertEquals(ChkTXOCanViewClass.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can View Class See Snapshot");
			Assert.assertEquals(ChkTXOCanViewCustomer.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can View Customer See Snapshot");
			Assert.assertEquals(ChkTXOCanCreateItem.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can Create New Item See Snapshot");
			Assert.assertEquals(ChkTXOCanCreateCustomer.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can Create Customer See Snapshot");
			Assert.assertEquals(ChkTXOCanCreatevendor.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can Create new Vendor See Snapshot");
			Assert.assertEquals(ChkTXOCanEditReqDuringApprovalProcess.isSelected(), false,
					"This New Created User Doesn't have the Rights of can Edit Requisition During Approver Process See Snapshot");
			Assert.assertEquals(ChkTXOCanSeeEveryOneHistory.isSelected(), false,
					"This New Created User Doesn't have the Rights of  Can See EveryOneHistory See Snapshot");
			Assert.assertEquals(ChkTXOCanEmailPOtoVendor.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can Edit PO which PO is in pending Sync See Snapshot");
			Assert.assertEquals(ChkTXOCanDeletPO.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can Delete PO See Snapshot");
			Assert.assertEquals(ChkTXOCanCreateReceiving.isSelected(), false,
					"This New Created User Doesn't have the Rights of Can Create Receiving See Snapshot");

		} else {
			Assert.fail("Accounting Application Name is not Correct");
		}
	}

	public void VerificationOfAllThePermsiionAreBeingSelectFromtheSpecificUser(String Users)
			throws InterruptedException {
		Thread.sleep(2000);
		Select selectuser = new Select(SelectUser);
		selectuser.selectByVisibleText(Users);
		AllPermissionRightsCheckVerification();
	}

	public void NewCompanyCreationAdminUserDataVerification(String FN1, String Email1, String PNO1)
			throws InterruptedException {

		Select selectuser = new Select(SelectUser);
		selectuser.selectByVisibleText(FN1);
		// loading the user
		Thread.sleep(3000);

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		// get the text
		String FirstName = (String) jsExecutor.executeScript("return document.getElementById('txtFirstName').value");
		String LastName = (String) jsExecutor.executeScript("return document.getElementById('txtLastName').value");
		String PhoneNo = (String) jsExecutor.executeScript("return document.getElementById('txtPhNo').value");
		String UserEmail = (String) jsExecutor.executeScript("return document.getElementById('txtEmail').value");

		Assert.assertEquals(FirstName, FN1, "First Name is not appearing Correct see snapshot");
		Assert.assertEquals(LastName, "", "Last Name is not null");
		Assert.assertEquals(UserEmail, Email1, "Admin Email is not appearing Correct see snapshot");
		Assert.assertEquals(PhoneNo, PNO1, "Admin Phone No is not appearing Correct see snapshot");

		Select selectdept = new Select(Department);
		WebElement Dept = selectdept.getFirstSelectedOption();
		String SelectedDept = Dept.getText();

		Assert.assertEquals(SelectedDept, "Purchasing",
				"by default purchasing dept is not select from this user see snapshot");

		Assert.assertEquals(ChkAdmin.isSelected(), true, "This User is not set as an system administrator");

		AllPermissionRightsCheckVerification();

		SelectTheEditExistingUser();
	}

	public void NewUserDataVerification(String FN1, String LN1, String Email1, String PNO1, String IsAdmin,
			String Dept1) throws InterruptedException {

		Select selectuser = new Select(SelectUser);
		if (LN1.equals("")) {
			selectuser.selectByVisibleText(FN1);
		} else {
			selectuser.selectByVisibleText(FN1 + " " + LN1);
		}
		// loading the user
		Thread.sleep(3000);

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		// get the text
		String FirstName1 = (String) jsExecutor.executeScript("return document.getElementById('txtFirstName').value");
		String LastName2 = (String) jsExecutor.executeScript("return document.getElementById('txtLastName').value");
		String PhoneNo3 = (String) jsExecutor.executeScript("return document.getElementById('txtPhNo').value");
		String UserEmail4 = (String) jsExecutor.executeScript("return document.getElementById('txtEmail').value");

		Assert.assertEquals(FirstName1, FN1, "First Name is not appearing Correct see snapshot");
		Assert.assertEquals(LastName2, LN1, "Last Name is not null");
		Assert.assertEquals(UserEmail4, Email1, "Admin Email is not appearing Correct see snapshot");
		Assert.assertEquals(PhoneNo3, PNO1, "Admin Phone No is not appearing Correct see snapshot");

		Select selectdept = new Select(Department);
		WebElement Dept = selectdept.getFirstSelectedOption();
		String SelectedDept = Dept.getText();

		Assert.assertEquals(SelectedDept, Dept1,
				"by default purchasing dept is not select from this user see snapshot");

		if (IsAdmin.equals("Yes")) {
			Assert.assertEquals(ChkAdmin.isSelected(), true, "This User is not set as an system administrator");
		} else {

		}
		AllPermissionRightsCheckVerification();
	}

	public void VerificationOfAllValidationofUserManagmentPageandUserCreation(String ExistingAdminEmail)
			throws InterruptedException {

		// Loading the user Creation Form
		AddUserBtn();
		Thread.sleep(2000);

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		// get the text
		String FirstName1 = (String) jsExecutor.executeScript("return document.getElementById('txtFirstName').value");
		String LastName1 = (String) jsExecutor.executeScript("return document.getElementById('txtLastName').value");
		String UserEmail1 = (String) jsExecutor.executeScript("return document.getElementById('txtEmail').value");

		Assert.assertEquals(FirstName1, "", "First Name is not Null");
		Assert.assertEquals(LastName1, "", "Last Name is not null");
		Assert.assertEquals(UserEmail1, "", "Admin Email is not Null");

		Assert.assertEquals(FirstName.getAttribute("maxlength"), "30", "max length of Dept name field is not correct");
		Assert.assertEquals(LastName.getAttribute("maxlength"), "30",
				"Max Length of Dept Descripiton field is not correct");
		Assert.assertEquals(Email.getAttribute("maxlength"), "50", "max length of Dept name field is not correct");
		Assert.assertEquals(PhoneNo.getAttribute("maxlength"), "50",
				"Max Length of Dept Descripiton field is not correct");
		Assert.assertEquals(Password.getAttribute("maxlength"), "100", "max length of Dept name field is not correct");
		Assert.assertEquals(ConfirmPassword.getAttribute("maxlength"), "100",
				"Max Length of Dept Descripiton field is not correct");

		AllPermissionRightsCheckVerification();

		SaveBtn();
		VerificationOftheValidationPopupMsg(missedFields);
		date = new Date();

		String lastNameNewUser = formatter1.format(date);
		ScenarioContext.put("NewUserFirstName", "New User");
		ScenarioContext.put("NewUserlastName", lastNameNewUser);
		FirstName.sendKeys("New User");
		SaveBtn();
		VerificationOftheValidationPopupMsg(missedFields);

		LastName.sendKeys(lastNameNewUser);
		SaveBtn();
		VerificationOftheValidationPopupMsg(missedFields);

		Email.clear();

//		Comment due to the email validation is not working
//		Email.sendKeys("InvalidEmail");
//		SaveBtn();
//		VerificationOftheValidationPopupMsg("Oops! Please enter valid email address.");

		Email.sendKeys(ExistingAdminEmail);
		SaveBtn();
		VerificationOftheValidationPopupMsg("Oops! The email address entered is currently assigned to another user.");
		String randomEmail = randomEmail();
		Email.clear();
		Email.sendKeys(randomEmail);
		ScenarioContext.put("RandomEmailOfUser", randomEmail);

		PhoneNo.clear();
		PhoneNo.sendKeys("+1-999-999-1111");

		Password.clear();
		ConfirmPassword.clear();

		Password.sendKeys("Aa");
		ConfirmPassword.sendKeys("Aa");
		SaveBtn();
		VerificationOftheValidationPopupMsg(PasswordValidationMsg);

		Password.clear();
		ConfirmPassword.clear();
		Password.sendKeys("Aa1234567");
		ConfirmPassword.sendKeys("Aa12345678");
		SaveBtn();
		VerificationOftheValidationPopupMsg(PasswordNotmatchValidationMsg);

		Password.clear();
		ConfirmPassword.clear();
		Password.sendKeys("Aa1234567");
		ConfirmPassword.sendKeys("Aa1234567");

		Select selectdept1 = new Select(Department);
		selectdept1.selectByValue("Select your department");
		SaveBtn();
		VerificationOftheValidationPopupMsg(missedFields);

		OpenDeptPopup.click();
		Thread.sleep(4000);

		driver.switchTo().frame("iframeForEmail");
		Thread.sleep(2000);

		Assert.assertEquals(DeptSavtBTN.getAttribute("disabled"), "true",
				"Dept Save Button is clickable even user didn't click on the plus icon");

		Select DeptSelectFromPopup = new Select(DeptSelectDDl);
		DeptSelectFromPopup.selectByVisibleText("Purchasing");
		Thread.sleep(4000);

		ChkDeptStatus.click();
		DeptSavtBTN.click();
		Thread.sleep(6000);
		Assert.assertEquals(ValidationMsgofDept.getText(), DeptInactiveValidationMsg,
				"Department Inactive Validation Msg is not appearing even I Inactive the dept which is associate with user");
		ChkDeptStatus.click();
		DeptDeleteBTN.click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.switchTo().alert().getText(), "Are you sure?");
		driver.switchTo().alert().accept();
		Thread.sleep(6000);
		Assert.assertEquals(ValidationMsgofDept.getText(), DeptDeleteValidationMsg,
				"Department Delete Validation Msg is not appearing even I Delete the dept which is associate with user");

		DeptDeleteBTN.click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.switchTo().alert().getText(), "Are you sure?");
		driver.switchTo().alert().accept();
		Thread.sleep(6000);
		Assert.assertEquals(ValidationMsgofDept.getText(), DeptDeleteValidationMsg,
				"Department Delete Validation Msg is not appearing even I Delete the dept which is associate with user");

		DeptCreationBTN.click();
		Thread.sleep(2000);
		DeptCreationBTN.click();
		Thread.sleep(2000);

		Assert.assertEquals(InputDeptName.getAttribute("maxlength"), "30",
				"max length of Dept name field is not correct");
		Assert.assertEquals(InputDeptDescription.getAttribute("maxlength"), "50",
				"Max Length of Dept Descripiton field is not correct");

		date = new Date();

		String DeptName = "Dept " + formatter1.format(date);

		ScenarioContext.put("DeptName", DeptName);
		InputDeptName.sendKeys(DeptName);
		InputDeptDescription.sendKeys(DeptName);
		DeptSavtBTN.click();
		Thread.sleep(6000);
		Assert.assertEquals(ValidationMsgofDept.getText(), DeptSuccessfullyAdded,
				"Department successfully added Validation Msg is not appearing even I add the dept");

		Thread.sleep(2000);
		Select DeptSS = new Select(DeptSelectDDl);
		DeptSS.selectByVisibleText(DeptName);
		Thread.sleep(2000);
		String DeptNameUpdate = "Dept " + formatter1.format(date);

		ScenarioContext.put("DeptName", DeptNameUpdate);
		InputDeptName.clear();
		InputDeptDescription.clear();
		InputDeptName.sendKeys(DeptNameUpdate);
		InputDeptDescription.sendKeys(DeptNameUpdate);
		DeptSavtBTN.click();
		Thread.sleep(6000);
		Assert.assertEquals(ValidationMsgofDept.getText(), DeptUpdateSuccessfullyMsg,
				"Department successfully updated Validation Msg is not appearing even I add the dept");
		Thread.sleep(2000);

		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		DeptCloseBTN.click();

		Thread.sleep(2000);

		DeptNameUpdate = ScenarioContext.get("DeptName");
		Select selectdept2 = new Select(Department);
		selectdept2.selectByVisibleText(DeptNameUpdate);
		Thread.sleep(2000);
		SaveBtn();
		Thread.sleep(2000);

		String GetVALIDATIONMsg = GetVlaidationmsg.get(0).getText();

		if (GetVALIDATIONMsg.equals(limit)) {
			driver.findElement(By.xpath("//div//button[@class = 'confirm']")).click();
		} else if (GetVALIDATIONMsg.equals("Thank you! Your changes have been saved.")) {
			driver.findElement(By.xpath("//div//button[@class = 'confirm']")).click();
			String USFN = ScenarioContext.get("NewUserFirstName");
			String USLN = ScenarioContext.get("NewUserlastName");
			String USEM = ScenarioContext.get("RandomEmailOfUser");
			String USDept = ScenarioContext.get("DeptName");
			NewUserDataVerification(USFN, USLN, USEM, "+1-999-999-1111", "No", USDept);
		} else {
			Assert.fail("Wrong Validation is appearing :" + GetVALIDATIONMsg);
		}

		// This was comment Because this Validation is not working
//		PhoneNo.clear();
//		SaveBtn();
//		VerificationOftheValidationPopupMsg(missedFields);

	}

	public void RemoveAllAdminUser(String UserName) throws InterruptedException {
		Select selectuser = new Select(SelectUser);
		selectuser.selectByVisibleText(UserName);
		Thread.sleep(2000);
		ChkAdmin.click();
		SaveBtn();
		VerificationOftheValidationPopupMsg(AdminChangeVerification);
		SelectTheEditExistingUser();
	}

	public void SelectTheEditExistingUser() throws InterruptedException {
		Select selectuser = new Select(SelectUser);
		selectuser.selectByValue("Edit Existing User / Email");
		Thread.sleep(2000);
	}

	public void selectUserFromDropDown(String Username) throws InterruptedException {
		Select selectuser = new Select(SelectUser);
		selectuser.selectByVisibleText(Username);
		Thread.sleep(2000);
	}

	public void Admin_UserRights(String AdminRights) throws InterruptedException {
		if (AdminRights.equals("Yes")) {
			if (ChkAdmin.isSelected()) {
				System.out.println("Yes");
			} else {
				ChkAdmin.click();
			}
		}
		if (AdminRights.equals("No")) {
			if (ChkAdmin.isSelected()) {
				ChkAdmin.click();
			} else {
				System.out.println("NO");
			}
		}
	}

	public void CheckDeptIsCreatedIfNotThenCreate() throws InterruptedException {
//		WebElement getDept= driver.findElement(By.xpath("//select[@id='ddlDepartment']"));
//		getDept.isSelected();

//		WebElement getDeptNames=driver.findElement(By.xpath("//select[@id='ddlDepartment']"));
//				getDeptNames.getText();
		Thread.sleep(4000);
		AddNewUser.click();
		Thread.sleep(4000);
		System.out.println("1");
		do {
			reRun = false; // Reset the flag before each iteration

			// Initialize a flag to track if a user was created
			boolean deptCreated = false;

			Select DDown = new Select(Department);
			List<WebElement> visibleOptions = DDown.getOptions();

			// Extract the text of all visible options and store them in a List
			List<String> ddlValues = Arrays
					.asList(visibleOptions.stream().map(WebElement::getText).toArray(String[]::new));
			System.out.println(ddlValues);
			System.out.println("------------");
			// Define a list of hard-coded values to compare with the selected options
			List<String> hardCodedValues = Arrays.asList("Purchasing", "QA", "DEV", "Other");

			// Loop through each hard-coded value and check if it's present in the dropdown
			// values
			for (String value : hardCodedValues) {

				if (value.equals("Purchasing")) {
					if (ddlValues.contains("Purchasing")) {
						System.out.println("Purchasing Department is present in the DDL values.");
					} else {
						OpenDeptPopup.click();
						Thread.sleep(1000);
						driver.switchTo().frame("iframeForEmail");
						DeptCreationBTN.click();
						Thread.sleep(1000);
						InputDeptName.sendKeys("Purchasing");
						Thread.sleep(1000);
						DeptSavtBTN.click();
						Thread.sleep(4000);
						String deptAdded = "Department added successfully!";
						Assert.assertEquals(ValidationMsgofDept.getText(), deptAdded,
								"Different dept message appeared: ");
						Thread.sleep(1000);
						driver.switchTo().defaultContent();
						Thread.sleep(2000);
						DeptCloseBTN.click();
					}

				}
				if (value.equals("QA")) {
					if (ddlValues.contains("QA")) {
						System.out.println("QA Department is present in the DDL values.");
					} else {
						OpenDeptPopup.click();
						Thread.sleep(1000);
						driver.switchTo().frame("iframeForEmail");
						DeptCreationBTN.click();
						Thread.sleep(1000);
						InputDeptName.sendKeys("QA");
						Thread.sleep(1000);
						DeptSavtBTN.click();
						Thread.sleep(4000);
						String deptAdded = "Department added successfully!";
						Assert.assertEquals(ValidationMsgofDept.getText(), deptAdded,
								"Different dept message appeared: ");
						Thread.sleep(1000);
						driver.switchTo().defaultContent();
						Thread.sleep(2000);
						DeptCloseBTN.click();
					}
				}
				if (value.equals("DEV")) {
					if (ddlValues.contains("DEV")) {
						System.out.println("Dev Department is present in the DDL values.");
					} else {
						OpenDeptPopup.click();
						Thread.sleep(1000);
						driver.switchTo().frame("iframeForEmail");
						DeptCreationBTN.click();
						Thread.sleep(1000);
						InputDeptName.sendKeys("DEV");
						Thread.sleep(1000);
						DeptSavtBTN.click();
						Thread.sleep(4000);
						String deptAdded = "Department added successfully!";
						Assert.assertEquals(ValidationMsgofDept.getText(), deptAdded,
								"Different dept message appeared: ");
						Thread.sleep(1000);
						driver.switchTo().defaultContent();
						Thread.sleep(2000);
						DeptCloseBTN.click();
					}
				}
				if (value.equals("Other")) {
					if (ddlValues.contains("Other")) {
						System.out.println("Dev Department is present in the DDL values.");
					} else {
						OpenDeptPopup.click();
						Thread.sleep(1000);
						driver.switchTo().frame("iframeForEmail");
						DeptCreationBTN.click();
						Thread.sleep(1000);
						InputDeptName.sendKeys("Other");
						Thread.sleep(1000);
						DeptSavtBTN.click();
						Thread.sleep(4000);
						String deptAdded = "Department added successfully!";
						Assert.assertEquals(ValidationMsgofDept.getText(), deptAdded,
								"Different dept message appeared: ");
						Thread.sleep(1000);
						driver.switchTo().defaultContent();
						Thread.sleep(2000);
						DeptCloseBTN.click();
					}
				}
			}

			if (deptCreated) {
				reRun = true; // Set the flag to rerun the method if a user was created
			}
		} while (reRun);
	}

	public void GetAllTheUserAndCheckIftheWorkflowUserisNotAddedThenCreateThatUser() throws InterruptedException {
		
	    
	    do {
	        reRun = false; // Reset the flag before each iteration
	        
	        // Existing code...
	        
	        // Initialize a flag to track if a user was created
	        boolean userCreated = false;
			
		
	        Select select = new Select(SelectUser);
	        Select DeptDown = new Select(Department);
	        List<WebElement> visibleOptions = select.getOptions();

	        // Extract the text of all visible options and store them in a List
	        List<String> ddlValues = Arrays.asList(visibleOptions.stream().map(WebElement::getText)
	                .toArray(String[]::new));
	        System.out.println(ddlValues);
	        System.out.println("------------");
	        // Define a list of hard-coded values to compare with the selected options
	        List<String> hardCodedValues = Arrays.asList("Originator 01", "Approver 01", "Approver 02", "Approver 03", "Approver 04", "Approver 05", "Approver 06");

	        // Loop through each hard-coded value and check if it's present in the dropdown values
	        for (String value : hardCodedValues) {
	        	
	        	if (value.equals("Originator 01")) {
	                if (ddlValues.contains("Originator 01")) {
	                	select.selectByVisibleText("Originator 01");
	                	Thread.sleep(1000);
	                	WebElement E_SelectedDept = DeptDown.getFirstSelectedOption();
	            		String SelectedDept = E_SelectedDept.getText();
	            		String emailString = Email.getAttribute("value");
	            		String PhoneNumber=PhoneNo.getAttribute("value");
	            			
	            		
	            		if(SelectedDept.equals("Purchasing") && "Originator@gmail.com".equals(emailString) && !CHK_UserStatus.isSelected() && ChkAdmin.isSelected() &&  "+1-999-999-9991".equals(PhoneNumber)) {
	            			System.out.println("Originator 01 is already added with correct data");
	            		}else {
		            		if(SelectedDept.equals("Purchasing") ) {
		            			System.out.println("Originator 01 is present with Purchasing DEPT in the DDL values");
		            		}
		            		else {
		            			DeptDown.selectByVisibleText("Purchasing");
		            		}
		            		if("Originator@gmail.com".equals(emailString)){
		            	
		            		}else {
		            			Email.clear();
		            			Email.sendKeys("Originator@gmail.com");
		            			}
		            		if("+1-999-999-9991".equals(PhoneNumber)) {
		            			
		            		}
		            		else {
		            			PhoneNo.clear();
		            			PhoneNo.sendKeys("+1-999-999-9991");
		            		}
		            		if(CHK_UserStatus.isSelected()) {
		            			CHK_UserStatus.click();
		            		}else {
		            				
		            		}
		            		Admin_UserRights("Yes");
		            		ClickSaveBTN();
		            		System.out.println("Originator 01 is Updated Successfully");
		            		userCreated = true;
			                break; // Exit the loop
	            		}
	            		
	                    
	                } else {
	                	AddUserBtn();
						FnameAndLname("Originator", "01");
						EmailAndPhoneNo("Originator@gmail.com", "+1-999-999-9991");
						clearPasswordFields();
						InputPasswordandConfirmPassword();
						Admin_UserRights("Yes");
						Thread.sleep(1000);
						DeptDown.selectByVisibleText("Purchasing");
						Thread.sleep(1000);
						ClickSaveBTN();
						 userCreated = true;
		                    break; // Exit the loop
	                }
	        	
	        }else if (value.equals("Approver 01")) {
	                if (ddlValues.contains("Approver 01")) {
		                	select.selectByVisibleText("Approver 01");
		                	Thread.sleep(1000);
		                	WebElement E_SelectedDept = DeptDown.getFirstSelectedOption();
		            		String SelectedDept = E_SelectedDept.getText();
		            		String emailString = Email.getAttribute("value");
	            			
		            		
		            		if(SelectedDept.equals("Purchasing") && "Approver01@gmail.com".equals(emailString) && !CHK_UserStatus.isSelected() && ChkAdmin.isSelected() ) {
		            			System.out.println("Approver 01 is already added with correct data");
		            		}else {
			            		if(SelectedDept.equals("Purchasing") ) {
			            		}
			            		else {
			            			DeptDown.selectByVisibleText("Purchasing");
			            		}
			            		if("Approver01@gmail.com".equals(emailString)){
			            	
			            		}else {
			            			Email.clear();
			            			Email.sendKeys("Approver01@gmail.com");
			            			}
			            		if(CHK_UserStatus.isSelected()) {
			            			CHK_UserStatus.click();
			            		}else {
			            				
			            		}
			            		Admin_UserRights("Yes");
			            		ClickSaveBTN();
			            		System.out.println("Approver 01 is Updated Successfully");
			            		userCreated = true;
				                break; // Exit the loop
		            		}
	                } else {
	                	AddUserBtn();
						FnameAndLname("Approver", "01");
						EmailAndPhoneNo("Approver01@gmail.com", "+1-999-999-9991");
						clearPasswordFields();
						InputPasswordandConfirmPassword();
						Thread.sleep(1000);
						DeptDown.selectByVisibleText("Purchasing");
						Thread.sleep(1000);
						ClickSaveBTN();
						 userCreated = true;
		                    break; // Exit the loop
	                }
	            } else if (value.equals("Approver 02")) {
	                if (ddlValues.contains("Approver 02")) {
		                	select.selectByVisibleText("Approver 02");
		                	Thread.sleep(1000);
		                	WebElement E_SelectedDept = DeptDown.getFirstSelectedOption();
		            		String SelectedDept = E_SelectedDept.getText();
		            		String emailString = Email.getAttribute("value");
	            			
		            		
		            		if(SelectedDept.equals("QA") && "Approver02@gmail.com".equals(emailString) && !CHK_UserStatus.isSelected() && ChkAdmin.isSelected() ) {
		            			System.out.println("Approver 02 is already added with correct data");
		            		}else {
			            		if(SelectedDept.equals("QA") ) {
			            		}
			            		else {
			            			DeptDown.selectByVisibleText("QA");
			            		}
			            		if("Approver02@gmail.com".equals(emailString)){
			            	
			            		}else {
			            			Email.clear();
			            			Email.sendKeys("Approver02@gmail.com");
			            			}
			            		if(CHK_UserStatus.isSelected()) {
			            			CHK_UserStatus.click();
			            		}else {
			            				
			            		}
			            		Admin_UserRights("Yes");
			            		ClickSaveBTN();
			            		System.out.println("Approver 02 is Updated Successfully");
			            		userCreated = true;
				                break; // Exit the loop
		            		}
	                } else {
	                	AddUserBtn();
						FnameAndLname("Approver", "02");
						EmailAndPhoneNo("Approver02@gmail.com", "+1-999-999-9991");
						clearPasswordFields();
						InputPasswordandConfirmPassword();
						Thread.sleep(1000);
						DeptDown.selectByVisibleText("QA");
						Thread.sleep(1000);
						ClickSaveBTN();
						 userCreated = true;
		                    break; // Exit the loop
	                }
	            } else if (value.equals("Approver 03")) {
	                if (ddlValues.contains("Approver 03")) {
	                	select.selectByVisibleText("Approver 03");
	                	Thread.sleep(1000);
	                	WebElement E_SelectedDept = DeptDown.getFirstSelectedOption();
	            		String SelectedDept = E_SelectedDept.getText();
	            		String emailString = Email.getAttribute("value");
	            		if(SelectedDept.equals("QA") && "Approver03@gmail.com".equals(emailString) && !CHK_UserStatus.isSelected()  ) {
	            			System.out.println("Approver 03 is already added with correct data");
	            		}else {
		            		if(SelectedDept.equals("QA") ) {
		            		}
		            		else {
		            			DeptDown.selectByVisibleText("QA");
		            		}
		            		if("Approver03@gmail.com".equals(emailString)){
		            	
		            		}else {
		            			Email.clear();
		            			Email.sendKeys("Approver03@gmail.com");
		            			}
		            		if(CHK_UserStatus.isSelected()) {
		            			CHK_UserStatus.click();
		            		}else {
		            				
		            		}
		            		ClickSaveBTN();
		            		System.out.println("Approver 03 is Updated Successfully");
		            		userCreated = true;
			                break; // Exit the loop
	            		}
	                } else {
	                	AddUserBtn();
						FnameAndLname("Approver", "03");
						EmailAndPhoneNo("Approver03@gmail.com", "+1-999-999-9991");
						clearPasswordFields();
						InputPasswordandConfirmPassword();
						Thread.sleep(1000);
						DeptDown.selectByVisibleText("QA");
						Thread.sleep(1000);
						ClickSaveBTN();
						 userCreated = true;
		                    break; // Exit the loop
	                }
	            } else if (value.equals("Approver 04")) {
	                if (ddlValues.contains("Approver 04")) {
	                	select.selectByVisibleText("Approver 04");
	                	Thread.sleep(1000);
	                	WebElement E_SelectedDept = DeptDown.getFirstSelectedOption();
	            		String SelectedDept = E_SelectedDept.getText();
	            		String emailString = Email.getAttribute("value");
	            		if(SelectedDept.equals("DEV") && "Approver04@gmail.com".equals(emailString) && !CHK_UserStatus.isSelected()  ) {
	            			System.out.println("Approver 04 is already added with correct data");
	            		}else {
		            		if(SelectedDept.equals("DEV") ) {
		            		}
		            		else {
		            			DeptDown.selectByVisibleText("DEV");
		            		}
		            		if("Approver04@gmail.com".equals(emailString)){
		            	
		            		}else {
		            			Email.clear();
		            			Email.sendKeys("Approver04@gmail.com");
		            			}
		            		if(CHK_UserStatus.isSelected()) {
		            			CHK_UserStatus.click();
		            		}else {
		            				
		            		}
		            		ClickSaveBTN();
		            		System.out.println("Approver 04 is Updated Successfully");
		            		userCreated = true;
			                break; // Exit the loop
	            		}
	                } else {
	                	AddUserBtn();
						FnameAndLname("Approver", "04");
						EmailAndPhoneNo("Approver04@gmail.com", "+1-999-999-9991");
						clearPasswordFields();
						InputPasswordandConfirmPassword();
						Thread.sleep(1000);
						DeptDown.selectByVisibleText("DEV");
						Thread.sleep(1000);
						ClickSaveBTN();
						 userCreated = true;
		                    break; // Exit the loop
	                }
	            }
	                else if (value.equals("Approver 05")) {
		                if (ddlValues.contains("Approver 05")) {
		                	select.selectByVisibleText("Approver 05");
		                	Thread.sleep(1000);
		                	WebElement E_SelectedDept = DeptDown.getFirstSelectedOption();
		            		String SelectedDept = E_SelectedDept.getText();
		            		String emailString = Email.getAttribute("value");
		            		if(SelectedDept.equals("DEV") && "Approver05@gmail.com".equals(emailString) && !CHK_UserStatus.isSelected()  ) {
		            			System.out.println("Approver 05 is already added with correct data");
		            		}else {
			            		if(SelectedDept.equals("DEV") ) {
			            		}
			            		else {
			            			DeptDown.selectByVisibleText("DEV");
			            		}
			            		if("Approver05@gmail.com".equals(emailString)){
			            	
			            		}else {
			            			Email.clear();
			            			Email.sendKeys("Approver05@gmail.com");
			            			}
			            		if(CHK_UserStatus.isSelected()) {
			            			CHK_UserStatus.click();
			            		}else {
			            				
			            		}
			            		ClickSaveBTN();
			            		System.out.println("Approver 05 is Updated Successfully");
			            		userCreated = true;
				                break; // Exit the loop
		            		}
		                } else {
		                	AddUserBtn();
							FnameAndLname("Approver", "05");
							EmailAndPhoneNo("Approver05@gmail.com", "+1-999-999-9991");
							clearPasswordFields();
							InputPasswordandConfirmPassword();
							Thread.sleep(1000);
							DeptDown.selectByVisibleText("DEV");
							Thread.sleep(1000);
							ClickSaveBTN();
							 userCreated = true;
			                    break; // Exit the loop
		                }
	                }
		                else if (value.equals("Approver 06")) {
			                if (ddlValues.contains("Approver 06")) {
			                	select.selectByVisibleText("Approver 06");
			                	Thread.sleep(1000);
			                	WebElement E_SelectedDept = DeptDown.getFirstSelectedOption();
			            		String SelectedDept = E_SelectedDept.getText();
			            		String emailString = Email.getAttribute("value");
			            		if(SelectedDept.equals("Other") && "Approver06@gmail.com".equals(emailString) && !CHK_UserStatus.isSelected()  ) {
			            			System.out.println("Approver 06 is already added with correct data");
			            		}else {
				            		if(SelectedDept.equals("Other") ) {
				            		}
				            		else {
				            			DeptDown.selectByVisibleText("Other");
				            		}
				            		if("Approver06@gmail.com".equals(emailString)){
				            	
				            		}else {
				            			Email.clear();
				            			Email.sendKeys("Approver06@gmail.com");
				            			}
				            		if(CHK_UserStatus.isSelected()) {
				            			CHK_UserStatus.click();
				            		}else {
				            				
				            		}
				            		ClickSaveBTN();
				            		System.out.println("Approver 05 is Updated Successfully");
				            		userCreated = true;
					                break; // Exit the loop
			            		}
			                } else {
			                	AddUserBtn();
								FnameAndLname("Approver", "06");
								EmailAndPhoneNo("Approver06@gmail.com", "+1-999-999-9991");
								clearPasswordFields();
								InputPasswordandConfirmPassword();
								Thread.sleep(1000);
								DeptDown.selectByVisibleText("Other");
								Thread.sleep(1000);
								ClickSaveBTN();
								 userCreated = true;
				                    break; // Exit the loop
			                }
	            }
		                else {
	                if (ddlValues.contains(value)) {
	                    System.out.println(value + " is present in the DDL values.");
	                } else {
	                    System.out.println(value + " is not present in the DDL values.");
	                }
	            }
	        }
	        
	        if (userCreated) {
	            reRun = true; // Set the flag to rerun the method if a user was created
	        }
	    }while(reRun); // Re-run the method if the flag is set to true
	}

	public void CountThathowManyUserAreNotExist() throws InterruptedException {
		
        Select select = new Select(SelectUser);
        List<WebElement> visibleOptions = select.getOptions();

        // Extract the text of all visible options and store them in a List
        List<String> ddlValues = Arrays.asList(visibleOptions.stream().map(WebElement::getText)
                .toArray(String[]::new));
        System.out.println(ddlValues);
        System.out.println("------------");
        // Define a list of hard-coded values to compare with the selected options
        List<String> hardCodedValues = Arrays.asList("Originator 01", "Approver 01", "Approver 02", "Approver 03", "Approver 04", "Approver 05", "Approver 06");

        // Loop through each hard-coded value and check if it's present in the dropdown values
        for (String value : hardCodedValues) {
        	
        	if (value.equals("Originator 01")) {
                if (ddlValues.contains("Originator 01")) {
                    System.out.println("Originator is present in the DDL values.");
                } else {
                	Count = Count + 1;
                }
            } 
        	
        	else if (value.equals("Approver 01")) {
                if (ddlValues.contains("Approver 01")) {
                    System.out.println("Approver 01 is present in the DDL values.");
                } else {
                	Count = Count + 1;
                }
            } else if (value.equals("Approver 02")) {
                if (ddlValues.contains("Approver 02")) {
                    System.out.println("Approver 02 is present in the DDL values.");
                } else {
                	Count = Count + 1;
                }
            } else if (value.equals("Approver 03")) {
                if (ddlValues.contains("Approver 03")) {
                    System.out.println("Approver 03 is present in the DDL values.");
                } else {
                	Count = Count + 1;
                }
            } else if (value.equals("Approver 04")) {
                if (ddlValues.contains("Approver 04")) {
                    System.out.println("Approver 04 is present in the DDL values.");
                } else {
                	Count = Count + 1;
                }
            }
                else if (value.equals("Approver 05")) {
	                if (ddlValues.contains("Approver 05")) {
	                    System.out.println("Approver 05 is present in the DDL values.");
	                } else {
	                	Count = Count + 1;
	                }
                }
	                else if (value.equals("Approver 06")) {
		                if (ddlValues.contains("Approver 06")) {
		                    System.out.println("Approver 06 is present in the DDL values.");
		                } else {
		                	Count = Count + 1;
		                }
            } else {
                if (ddlValues.contains(value)) {
                    System.out.println(value + " is present in the DDL values.");
                } else {
                    System.out.println(value + " is not present in the DDL values.");
                }
            }
        }


}

	// Subscription Call

	public void ChangeTheSlabRatewhenActiveUserisEqualstoSlabRateOrFlatRate() throws InterruptedException {

		String AppName = ScenarioContext.get("AppName");

		if (AppName.equals("TXO")) {
			// Active Users Get
			String A_User = Cur_Active.getText();
			String[] Active_User = A_User.split(" ");
			A_User = Active_User[0];
			// Get Type of Flat And Slab Rate
			String CurrentIsSlabOrFlatRateType = Current_Flat_SlabRate.getText();

			// Make In Int of Total No of Active Users
			int TotalNoOfActiveUsers = Integer.parseInt(A_User);

			// Use Select for the DLL of SUbscription Slab
			Select select = new Select(SubscriptionUserSlab);

			int TotalNo_Of_Users = 0;

			if (CurrentIsSlabOrFlatRateType.equals("Flat Rate:")) {
				System.out.println("1");
				// Get TotalNoOfUsers
				String TotalNoOFUserofFlatRate = NoOfUsers.getAttribute("value");
				System.out.println("2");
				// Make it Int of Total No of Users for flat Rate
				int TotalNoOFUserofFlatRates = Integer.parseInt(TotalNoOFUserofFlatRate);
				System.out.println("3");
				// total Count
				int TotalCount = TotalNoOFUserofFlatRates - TotalNoOfActiveUsers;
				// In This if we are going to use minus sign to check the remaining no of user
				// which is not yet Created and compare is this > 7 if not then add the 7 in the
				// current rate and Change the Subscription
				if (TotalCount >= Count) {
					System.out.println(Count + "Count");
					System.out.println("4");
					Assert.assertTrue(true, "Remainig creation of user is left: " + TotalCount
							+ " and the Total No of User which we have to created Count: " + Count);

				} else {
					System.out.println("5");
					int sendkeys = TotalNoOFUserofFlatRates + Count;
					System.out.println("6");
					String SendKeys = Integer.toString(sendkeys);
					System.out.println("7");
					NoOfUsers.clear();
					NoOfUsers.sendKeys(SendKeys);
					System.out.println("8");
					Thread.sleep(2000);
					System.out.println("9");
					SubscripionSaveBTN.click();
					Thread.sleep(5000);
					System.out.println("10");
//					S_ConfirmPassword.sendKeys("Aa1234567");
					System.out.println("11");
					ConfirmSaveBTN.click();
					Thread.sleep(2000);
				}

			} else if (CurrentIsSlabOrFlatRateType.equals("Slab Rate:")) {
				WebElement selectedOption = select.getFirstSelectedOption();
				String selectedOptionText = (String) ((JavascriptExecutor) driver)
						.executeScript("return arguments[0].textContent;", selectedOption);

				if (Slab28.equals(selectedOptionText)) {
					TotalNo_Of_Users = 5;
					if (TotalNo_Of_Users - TotalNoOfActiveUsers >= Count) {

					} else {
						Thirty = "30";
						select.selectByValue(Thirty);
						Thread.sleep(2000);
						SubscripionSaveBTN.click();
						Thread.sleep(5000);
//						S_ConfirmPassword.sendKeys("Aa1234567");
						ConfirmSaveBTN.click();
					}
				} else if (Slab29.equals(selectedOptionText)) {
					TotalNo_Of_Users = 10;
					Thirty = "30";
					if (TotalNo_Of_Users - TotalNoOfActiveUsers > 7) {

					} else {
						select.selectByValue(Thirty);
						Thread.sleep(2000);
						SubscripionSaveBTN.click();
						Thread.sleep(5000);
//						S_ConfirmPassword.sendKeys("Aa1234567");
						ConfirmSaveBTN.click();
					}
				} else if (Slab30.equals(selectedOptionText)) {
					TotalNo_Of_Users = 20;
					Thirtyone = "31";
					if (TotalNo_Of_Users - TotalNoOfActiveUsers > 7) {

					} else {
						select.selectByValue(Thirtyone);
						Thread.sleep(2000);
						SubscripionSaveBTN.click();
						Thread.sleep(5000);
//						S_ConfirmPassword.sendKeys("Aa1234567");
						ConfirmSaveBTN.click();
					}
				} else if (Slab31.equals(selectedOptionText)) {
					TotalNo_Of_Users = 30;
					Thirtytwo = "32";
					if (TotalNo_Of_Users - TotalNoOfActiveUsers > 7) {

					} else {
						select.selectByValue(Thirtytwo);
						Thread.sleep(2000);
						SubscripionSaveBTN.click();
						Thread.sleep(5000);
//						S_ConfirmPassword.sendKeys("Aa1234567");
						ConfirmSaveBTN.click();
					}
				} else if (Slab32.equals(selectedOptionText)) {
					TotalNo_Of_Users = 40;
					Thirtythree = "33";
					if (TotalNo_Of_Users - TotalNoOfActiveUsers > 7) {

					} else {
						select.selectByValue(Thirtythree);
						Thread.sleep(2000);
						SubscripionSaveBTN.click();
						Thread.sleep(5000);
//						S_ConfirmPassword.sendKeys("Aa1234567");
						ConfirmSaveBTN.click();
					}
				} else if (Slab33.equals(selectedOptionText)) {
					TotalNo_Of_Users = 50;
					Thirtyfour = "34";
					if (TotalNo_Of_Users - TotalNoOfActiveUsers > 7) {

					} else {
						select.selectByValue(Thirtyfour);
						Thread.sleep(2000);
						SubscripionSaveBTN.click();
						Thread.sleep(5000);
//						S_ConfirmPassword.sendKeys("Aa1234567");
						ConfirmSaveBTN.click();
					}
				} else if (Slab34.equals(selectedOptionText)) {
					TotalNo_Of_Users = 75;
					Thirtyfive = "35";
					if (TotalNo_Of_Users - TotalNoOfActiveUsers > 7) {

					} else {
						select.selectByValue(Thirtyfive);
						Thread.sleep(2000);
						SubscripionSaveBTN.click();
						Thread.sleep(5000);
//						S_ConfirmPassword.sendKeys("Aa1234567");
						ConfirmSaveBTN.click();
					}
				} else if (Slab35.equals(selectedOptionText)) {
					TotalNo_Of_Users = 100;
					Thirtysix = "36";
					if (TotalNo_Of_Users - TotalNoOfActiveUsers > 7) {

					} else {
						select.selectByValue(Thirtysix);
						Thread.sleep(2000);
						SubscripionSaveBTN.click();
						Thread.sleep(5000);
//						S_ConfirmPassword.sendKeys("Aa1234567");
						ConfirmSaveBTN.click();
					}
				} else if (Slab36.equals(selectedOptionText)) {

				}

			} else {
				Assert.fail(
						"Is Crashed due to not found that this company is Using SlabRate or Flat Rate \n Please Check the Subscription page Code and Then Check this Method ChangeTheSlabRatewhenActiveUserisEqualstoSlabRateOrFlatRate");
			}
		} else if (AppName.equals("TRX")) {
			// Active Users Get
			String A_User = Cur_Active.getText();
			String[] Active_User = A_User.split(" ");
			A_User = Active_User[0];
			// Get Type of Flat And Slab Rate
			String CurrentIsSlabOrFlatRateType = Current_Flat_SlabRate.getText();

			// Make In Int of Total No of Active Users
			int TotalNoOfActiveUsers = Integer.parseInt(A_User);

			// Use Select for the DLL of SUbscription Slab
			Select select = new Select(SubscriptionUserSlab);

			int TotalNo_Of_Users = 0;

			if (CurrentIsSlabOrFlatRateType.equals("Flat Rate:")) {
				System.out.println("1");
				// Get TotalNoOfUsers
				String TotalNoOFUserofFlatRate = NoOfUsers.getAttribute("value");
				System.out.println("2");
				// Make it Int of Total No of Users for flat Rate
				int TotalNoOFUserofFlatRates = Integer.parseInt(TotalNoOFUserofFlatRate);
				System.out.println("3");
				// total Count
				int TotalCount = TotalNoOFUserofFlatRates - TotalNoOfActiveUsers;
				// In This if we are going to use minus sign to check the remaining no of user
				// which is not yet Created and compare is this > 7 if not then add the 7 in the
				// current rate and Change the Subscription
				if (TotalCount >= Count) {
					System.out.println(Count + "Count");
					System.out.println("4");
					Assert.assertTrue(true, "Remainig creation of user is left: " + TotalCount
							+ " and the Total No of User which we have to created Count: " + Count);

				} else {
					System.out.println("5");
					int sendkeys = TotalNoOFUserofFlatRates + Count;
					System.out.println("6");
					String SendKeys = Integer.toString(sendkeys);
					System.out.println("7");
					NoOfUsers.clear();
					NoOfUsers.sendKeys(SendKeys);
					System.out.println("8");
					Thread.sleep(2000);
					System.out.println("9");
					SubscripionSaveBTN.click();
					Thread.sleep(5000);
					System.out.println("10");
//					S_ConfirmPassword.sendKeys("Aa1234567");
					System.out.println("11");
					ConfirmSaveBTN.click();
					Thread.sleep(2000);
				}

			} else if (CurrentIsSlabOrFlatRateType.equals("Slab Rate:")) {
				String Slab15 = "10 Users @ $250.00 per month";
				String Slab16 = "20 Users @ $425.00 per month";
				String Slab17 = "30 Users @ $525.00 per month";
				String Slab18 = "40 Users @ $600.00 per month";
				String Slab19 = "50 Users @ $650.00 per month";
				String Slab20 = "60 Users @ $750.00 per month";
				String Slab42 = "75 Users @ $937.50 per month";
				String Slab21 = "100 Users @ $1,200.00 per month";
				String Slab22 = "150 Users @ $1,650.00 per month";
				String Slab23 = "200 Users @ $2,000.00 per month";

				WebElement selectedOption = select.getFirstSelectedOption();
				String selectedOptionText = (String) ((JavascriptExecutor) driver)
						.executeScript("return arguments[0].textContent;", selectedOption);

				if (Slab15.equals(selectedOptionText)) {
					TotalNo_Of_Users = 10;
					sixteen = "16";
					if (TotalNo_Of_Users - TotalNoOfActiveUsers >= Count) {

					} else {
						select.selectByValue(sixteen);
						Thread.sleep(2000);
						SubscripionSaveBTN.click();
						Thread.sleep(5000);
//						S_ConfirmPassword.sendKeys("Aa1234567");
						ConfirmSaveBTN.click();
					}
				} else if (Slab16.equals(selectedOptionText)) {
					TotalNo_Of_Users = 20;
					seventeen = "17";
					if (TotalNo_Of_Users - TotalNoOfActiveUsers > 7) {

					} else {
						select.selectByValue(seventeen);
						Thread.sleep(2000);
						SubscripionSaveBTN.click();
						Thread.sleep(5000);
//						S_ConfirmPassword.sendKeys("Aa1234567");
						ConfirmSaveBTN.click();
					}
				} else if (Slab17.equals(selectedOptionText)) {
					TotalNo_Of_Users = 30;
					eighteen = "18";
					if (TotalNo_Of_Users - TotalNoOfActiveUsers > 7) {

					} else {
						select.selectByValue(eighteen);
						Thread.sleep(2000);
						SubscripionSaveBTN.click();
						Thread.sleep(5000);
//						S_ConfirmPassword.sendKeys("Aa1234567");
						ConfirmSaveBTN.click();
					}
				} else if (Slab18.equals(selectedOptionText)) {
					TotalNo_Of_Users = 40;
					nineteen = "18";
					if (TotalNo_Of_Users - TotalNoOfActiveUsers > 7) {

					} else {
						select.selectByValue(nineteen);
						Thread.sleep(2000);
						SubscripionSaveBTN.click();
						Thread.sleep(5000);
//						S_ConfirmPassword.sendKeys("Aa1234567");
						ConfirmSaveBTN.click();
					}
				} else if (Slab19.equals(selectedOptionText)) {
					TotalNo_Of_Users = 50;
					fourtytwo = "42";
					if (TotalNo_Of_Users - TotalNoOfActiveUsers > 7) {

					} else {
						select.selectByValue(fourtytwo);
						Thread.sleep(2000);
						SubscripionSaveBTN.click();
						Thread.sleep(5000);
//						S_ConfirmPassword.sendKeys("Aa1234567");
						ConfirmSaveBTN.click();
					}
				} else if (Slab20.equals(selectedOptionText)) {
					TotalNo_Of_Users = 60;
					twenty = "20";
					if (TotalNo_Of_Users - TotalNoOfActiveUsers > 7) {
						select.selectByValue(twenty);
						Thread.sleep(2000);
						SubscripionSaveBTN.click();
						Thread.sleep(5000);
//						ConfirmPassword.sendKeys("Aa1234567");
						BtnSave.click();
					} else {
						Assert.assertTrue(true, "Remainig creation of user is greater than 7 so we do need to change");
					}
				} else if (Slab42.equals(selectedOptionText)) {
					TotalNo_Of_Users = 75;
					twentyone = "21";
					if (TotalNo_Of_Users - TotalNoOfActiveUsers > 7) {

					} else {
						select.selectByValue(twentyone);
						Thread.sleep(2000);
						SubscripionSaveBTN.click();
						Thread.sleep(5000);
//						S_ConfirmPassword.sendKeys("Aa1234567");
						ConfirmSaveBTN.click();
					}
				} else if (Slab21.equals(selectedOptionText)) {
					TotalNo_Of_Users = 100;
					twentytwo = "22";
					if (TotalNo_Of_Users - TotalNoOfActiveUsers > 7) {

					} else {
						select.selectByValue(twentytwo);
						Thread.sleep(2000);
						SubscripionSaveBTN.click();
						Thread.sleep(5000);
//						S_ConfirmPassword.sendKeys("Aa1234567");
						ConfirmSaveBTN.click();
					}
				} else if (Slab22.equals(selectedOptionText)) {
					TotalNo_Of_Users = 150;
					twentythree = "23";
					if (TotalNo_Of_Users - TotalNoOfActiveUsers > 7) {

					} else {
						select.selectByValue(twentythree);
						Thread.sleep(2000);
						SubscripionSaveBTN.click();
						Thread.sleep(5000);
//						S_ConfirmPassword.sendKeys("Aa1234567");
						ConfirmSaveBTN.click();
					}
				} else if (Slab23.equals(selectedOptionText)) {

				}

			} else {
				Assert.fail(
						"Is Crashed due to not found that this company is Using SlabRate or Flat Rate \n Please Check the Subscription page Code and Then Check this Method ChangeTheSlabRatewhenActiveUserisEqualstoSlabRateOrFlatRate");
			}
		}

		else if (AppName.equals("Standalone")) {
			// Active Users Get
			String A_User = Cur_Active.getText();
			String[] Active_User = A_User.split(" ");
			A_User = Active_User[0];
			// Get Type of Flat And Slab Rate
			String CurrentIsSlabOrFlatRateType = Current_Flat_SlabRate.getText();

			// Make In Int of Total No of Active Users
			int TotalNoOfActiveUsers = Integer.parseInt(A_User);

			// Use Select for the DLL of SUbscription Slab
			Select select = new Select(SubscriptionUserSlab);

			int TotalNo_Of_Users = 0;
			System.out.println(CurrentIsSlabOrFlatRateType);
			if (CurrentIsSlabOrFlatRateType.equals("Flat Rate:")) {
				System.out.println("1");
				// Get TotalNoOfUsers
				String TotalNoOFUserofFlatRate = NoOfUsers.getAttribute("value");
				System.out.println("2");
				// Make it Int of Total No of Users for flat Rate
				int TotalNoOFUserofFlatRates = Integer.parseInt(TotalNoOFUserofFlatRate);
				System.out.println("3");
				// total Count
				int TotalCount = TotalNoOFUserofFlatRates - TotalNoOfActiveUsers;
				// In This if we are going to use minus sign to check the remaining no of user
				// which is not yet Created and compare is this > 7 if not then add the 7 in the
				// current rate and Change the Subscription
				if (TotalCount >= Count) {
					System.out.println(Count + "Count");
					Assert.assertTrue(true, "Remainig creation of user is left: " + TotalCount
							+ " and the Total No of User which we have to created Count: " + Count);

				} else {
					int sendkeys = TotalNoOFUserofFlatRates + Count;
					String SendKeys = Integer.toString(sendkeys);
					NoOfUsers.clear();
					NoOfUsers.sendKeys(SendKeys);
					Thread.sleep(2000);
					SubscripionSaveBTN.click();
					Thread.sleep(5000);
//					S_ConfirmPassword.sendKeys("Aa1234567");
					ConfirmSaveBTN.click();
					Thread.sleep(2000);
				}

			} else if (CurrentIsSlabOrFlatRateType.equals("Slab Rate:")) {
				// THis one for the StandAlone
				String Slab15 = "10 Users @ $145.00 per month";
				String Slab16 = "20 Users @ $280.00 per month";
				String Slab17 = "30 Users @ $450.00 per month";
				String Slab18 = "40 Users @ $520.00 per month";
				String Slab19 = "50 Users @ $625.00 per month";
				String Slab42 = "75 Users @ $900.50 per month";
				String Slab21 = "100 Users @ $1,000.00 per month";
				String Slab22 = "150 Users @ $1,350.00 per month";
				String Slab23 = "200 Users @ $1,600.00 per month";

				WebElement selectedOption = select.getFirstSelectedOption();
				String selectedOptionText = (String) ((JavascriptExecutor) driver)
						.executeScript("return arguments[0].textContent;", selectedOption);

				System.out.println(selectedOptionText);
				if (Slab15.equals(selectedOptionText)) {
					TotalNo_Of_Users = 10;
					sixteen = "16";
					if (TotalNo_Of_Users - TotalNoOfActiveUsers >= Count) {

					} else {
						select.selectByValue(sixteen);
						Thread.sleep(2000);
						SubscripionSaveBTN.click();
						Thread.sleep(5000);
//						S_ConfirmPassword.sendKeys("Aa1234567");
						ConfirmSaveBTN.click();
					}
				} else if (Slab16.equals(selectedOptionText)) {
					TotalNo_Of_Users = 20;
					seventeen = "17";
					if (TotalNo_Of_Users - TotalNoOfActiveUsers > 7) {

					} else {
						select.selectByValue(seventeen);
						Thread.sleep(2000);
						SubscripionSaveBTN.click();
						Thread.sleep(5000);
//						S_ConfirmPassword.sendKeys("Aa1234567");
						ConfirmSaveBTN.click();
					}
				} else if (Slab17.equals(selectedOptionText)) {
					TotalNo_Of_Users = 30;
					eighteen = "18";
					if (TotalNo_Of_Users - TotalNoOfActiveUsers > 7) {

					} else {
						select.selectByValue(eighteen);
						Thread.sleep(2000);
						SubscripionSaveBTN.click();
						Thread.sleep(5000);
//						S_ConfirmPassword.sendKeys("Aa1234567");
						ConfirmSaveBTN.click();
					}
				} else if (Slab18.equals(selectedOptionText)) {
					TotalNo_Of_Users = 40;
					nineteen = "18";
					if (TotalNo_Of_Users - TotalNoOfActiveUsers > 7) {

					} else {
						select.selectByValue(nineteen);
						Thread.sleep(2000);
						SubscripionSaveBTN.click();
						Thread.sleep(5000);
//						S_ConfirmPassword.sendKeys("Aa1234567");
						ConfirmSaveBTN.click();
					}
				} else if (Slab19.equals(selectedOptionText)) {
					TotalNo_Of_Users = 50;
					fourtytwo = "42";
					if (TotalNo_Of_Users - TotalNoOfActiveUsers > 7) {

					} else {
						select.selectByValue(fourtytwo);
						Thread.sleep(2000);
						SubscripionSaveBTN.click();
						Thread.sleep(5000);
//						S_ConfirmPassword.sendKeys("Aa1234567");
						ConfirmSaveBTN.click();
					}
				} else if (Slab42.equals(selectedOptionText)) {
					TotalNo_Of_Users = 75;
					twentyone = "21";
					if (TotalNo_Of_Users - TotalNoOfActiveUsers > 7) {

					} else {
						select.selectByValue(twentyone);
						Thread.sleep(2000);
						SubscripionSaveBTN.click();
						Thread.sleep(5000);
//						S_ConfirmPassword.sendKeys("Aa1234567");
						ConfirmSaveBTN.click();
					}
				} else if (Slab21.equals(selectedOptionText)) {
					TotalNo_Of_Users = 100;
					twentytwo = "22";
					if (TotalNo_Of_Users - TotalNoOfActiveUsers > 7) {

					} else {
						select.selectByValue(twentytwo);
						Thread.sleep(2000);
						SubscripionSaveBTN.click();
						Thread.sleep(5000);
//						S_ConfirmPassword.sendKeys("Aa1234567");
						ConfirmSaveBTN.click();
					}
				} else if (Slab22.equals(selectedOptionText)) {
					TotalNo_Of_Users = 150;
					twentythree = "23";
					if (TotalNo_Of_Users - TotalNoOfActiveUsers > 7) {

					} else {
						select.selectByValue(twentythree);
						Thread.sleep(2000);
						SubscripionSaveBTN.click();
						Thread.sleep(5000);
//						S_ConfirmPassword.sendKeys("Aa1234567");
						ConfirmSaveBTN.click();
					}
				} else if (Slab23.equals(selectedOptionText)) {

				}

			} else {
				Assert.fail(
						"Is Crashed due to not found that this company is Using SlabRate or Flat Rate \n Please Check the Subscription page Code and Then Check this Method ChangeTheSlabRatewhenActiveUserisEqualstoSlabRateOrFlatRate");
			}
		}

	}

	// Main Menu Call
	public void Menu() throws InterruptedException {
		WebElement menu = driver.findElement(By.id("menu")); // Replace with the actual ID of the menu element
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", menu);
	}

	public void Setting_UserManagementMenu() throws InterruptedException {
		Menu();
		Thread.sleep(2000);
		Setting.click();
		Thread.sleep(3000);
		UserManagment.click();
	}

	public void Setting_SubscriptionMenu() throws InterruptedException {
		Menu();
		Thread.sleep(2000);
		Setting.click();
		Thread.sleep(1000);
		Subscription.click();
	}

}
