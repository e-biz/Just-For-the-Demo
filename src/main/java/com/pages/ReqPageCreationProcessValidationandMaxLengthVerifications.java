package com.pages;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.StoringLocalValues.ScenarioContext;


public class ReqPageCreationProcessValidationandMaxLengthVerifications {

	WebDriver driver;
	
	
	public String vendor;
	public String customer;
	public String ItemName;
	public int noofcreationItems;

	String ItemCostCannotbeBlank = "Item cost can't be blank. Please specify.";
	String VendorAlreadyExist = "Another customer, vendor or employee is already using this name";
	String CustomerAlreadyExist = "Another customer, vendor or employee is already using this name";
	String VendorSuccessfullyAdded = "Vendor successfully added in your QuickBooks"; //Vendor successfully added in your QuickBooks lblNewVendorError
	String CustomerSuccessfullyAdded = "Customer successfully added in your QuickBooks";
	String ItemAlreadyExist = " Unable to create Item in QuickBooks : Item name already exists.";
	String ItemsSuccessfullyAdded = "Item successfully added in your QuickBooks";
	public String MaxDescriptionOfNonInventory = "Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inve";
	public String MaxDescriptionOfInventory = "Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Descr";
	public String MaxDescriptionOfServices = "Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Descripti";
	public String MaxDescriptionOfOtherCharge = "Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Descr";
	String ItemSuccessfullyCreated = "Item added successfully";

	public ReqPageCreationProcessValidationandMaxLengthVerifications(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, ReqPageCreationProcessValidationandMaxLengthVerifications.this);
	}
	SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yy HH-mm-ss"); // yyyy-MM-dd HH:mm
	Date date;
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy HH-mm-ss");  //yyyy-MM-dd HH:mm

	@FindBy(xpath = "//span[@class=\"prefix lefields-big  class-autocomplete-vendor  search\"]")
	WebElement VendorSearchIcon;

	@FindBy(id = "btnAddNewVendor")
	WebElement AddNewVendorBTN;

	@FindBy(id = "txtVendorName")
	WebElement VendorName;

	@FindBy(id = "txtCompanyName")
	WebElement VendorCompanyName;

	@FindBy(id = "txtBillingAddress1")
	WebElement BillingAddress1;

	@FindBy(id = "txtBillingAddress2")
	WebElement BillingAddress2;

	@FindBy(id = "txtBillingAddress3")
	WebElement BillingAddress3;

	@FindBy(id = "txtBillingAddress4")
	WebElement BillingAddress4;

	@FindBy(id = "txtBillingCity")
	WebElement VendorCity;

	@FindBy(id = "selectBillingStateOrProvince")
	WebElement VendorState;

	@FindBy(id = "txtBillingZipOrPostalCode")
	WebElement VendorZipcode;

	@FindBy(id = "selectBillingCountry")
	WebElement VendorCountry;

	@FindBy(id = "btnSaveNewVendor")
	WebElement SaveVendorBTN;

	@FindBy(id = "addnewvendor_modal_close")
	WebElement VendorCloseBTN;

	@FindBy(id = "txtContactFirstName")
	WebElement ContactFirstName;

	@FindBy(id = "txtContactLastName")
	WebElement ContactLastName;

	@FindBy(id = "txtPhone")
	WebElement VendorPhone;

	@FindBy(id = "txtFax")
	WebElement VendorFax;

	@FindBy(id = "txtContactEmail")
	WebElement VendorContactEmail;

	@FindBy(id = "lblNewVendorError")
	WebElement VendorErrorMsg;

	// Company and customer

	@FindBy(id = "ddlShipToType")
	WebElement MyCompany;

	@FindBy(xpath = "//span[@class=\"prefix lefields-big  class-autocomplete-header-customer  search\"]")
	WebElement CustomerSearchIcon;

	@FindBy(id = "btnAddNewcustomer_LineItem")
	WebElement AddNewCustomerBTN;

	@FindBy(id = "txtCustomer_Name")
	WebElement CustomerName;

	@FindBy(id = "txtCustomer_CompanyName")
	WebElement CustomerComapnyName;

	@FindBy(id = "txtCustomer_BillingAddress1")
	WebElement ShippingAddress1;

	@FindBy(id = "txtCustomer_BillingAddress2")
	WebElement ShippingAddress2;

	@FindBy(id = "txtCustomer_BillingAddress3")
	WebElement ShippingAddress3;

	@FindBy(id = "txtCustomer_BillingAddress4")
	WebElement ShippingAddress4;

	@FindBy(id = "txtCustomer_City")
	WebElement CustomerCity;

	@FindBy(id = "selectCustomer_BillingStateOrProvince")
	WebElement CustomerState;

	@FindBy(id = "txtCustomer_Zip")
	WebElement CustomerZipcode;

	@FindBy(id = "selectCustomer_BillingCountry")
	WebElement CustomerCountry;

	@FindBy(id = "btnSaveNewShipToCustomer")
	WebElement SaveCustomerBTN;

	@FindBy(id = "addnewcustomer_modal_close")
	WebElement CustomerCloseBTN;

	@FindBy(id = "lblNewcustomerError")
	WebElement CustomerErrorMsg;

	@FindBy(id = "txtCustomer_Contact_First_Name")
	WebElement CustomerFname;

	@FindBy(id = "txtCustomer_Contact_Last_Name")
	WebElement Customerlname;

	@FindBy(id = "txtCustomer_Contact_Phone")
	WebElement CustomerPhone;

	@FindBy(id = "txtCustomer_Contact_Fax")
	WebElement CustomerFax;

	@FindBy(id = "txtCustomer_Contact_Email")
	WebElement CustomerEmail;
	
	

	// items Creation Lookup

		@FindBy(id = "btnAddNewItem")
		WebElement C_ItemCreationIcon;

		// Item Services Radio button Locator
		@FindBy(xpath = "//input[@id = 'radio-service']//parent::div") 
		WebElement C_ServicesRadioBTN;

		// Item Inventory Radio button Locator
		@FindBy(xpath = "//input[@id = 'radio-inventory']//parent::div") 
		WebElement C_InventoryRadioBTN;

		// Item Non Inventory Radio button Locator
		@FindBy(xpath = "//input[@id = 'radio-noninventory']//parent::div") 
		WebElement C_NonInventoryRadioBTN; 
		
		@FindBy(xpath = "//input[@id = 'radio-othercharge']//parent::div")
		WebElement C_OtherChargeCheck;

		// Items Input Fields Locator
		@FindBy(id = "QBItemName")
		WebElement I_ItemName;

		@FindBy(id = "txtPurchaseDescription")
		WebElement I_PurchasedDescription;

		@FindBy(id = "txtUnitPrice")
		WebElement I_ItemAmount;

		@FindBy(id = "txtQtyOnHand")
		WebElement I_ItemQTYONHAND;

		@FindBy(id = "btnSaveNewItem")
		WebElement C_ItemsSaveBTN;

		// items Alread Exist
		@FindBy(id = "lblError")
		WebElement itemValidationMsg;

		// Vendor Already Exist
		@FindBy(id = "lblNewVendorError")
		WebElement VendorValidationMsg;

		// Customer Already Exist
		@FindBy(id = "lblNewcustomerError")
		WebElement CustomerValidationmsg;

		// Close Items Creation Lookup
		@FindBy(id = "addnewitem_modal_close")
		WebElement itemLookupCloseElement;

		@FindBy(id = "addnewvendor_modal_close")
		WebElement CloseVendorCreationLookup;

		@FindBy(id = "addnewcustomer_modal_close")
		WebElement CloseCustomerCreationLookup;

		@FindBy(id = "addnewitem_modal_close")
		WebElement CloseItemCreationLookup;

	@FindBy(id = "addNewRow")
	WebElement ItemAddNewRow;

	@FindBy(id = "btn_CreatePO")
	WebElement CreatePo;	
	
	public void addnewLineItemRow() {
		ItemAddNewRow.click();
	}
	
	public void OpenItemCreationLookup(String LineItem) throws InterruptedException {

		Thread.sleep(2000);
		WebElement LineitemlookupOpen = driver.findElement(By.xpath("//tr[" + LineItem
				+ "]//td//div//span[@class = 'prefix class-autocomplete-item lefields-big search']"));
		LineitemlookupOpen.click();
		Thread.sleep(10000);
		C_ItemCreationIcon.click();
		Thread.sleep(2000);

	}
	

//	----------------------------------------------------------------------------------------------
//	--------------------Vendor Creation Min and Max Info of TXO and TRX---------------------------
//	---------------------------------------------------------------------------------------------
	
	public void TRX_VendorCreationWithMinInfo(String NoOfCreation) throws InterruptedException {

		int NoOfCreation1 = Integer.parseInt(NoOfCreation);
		if (NoOfCreation1 <= 11) {
			for (int i = 1; i <= NoOfCreation1; i++) {
				Thread.sleep(1000);
				VendorSearchIcon.click();
				Thread.sleep(5000);
				AddNewVendorBTN.click();
				Thread.sleep(1000);
				date = new Date();
				vendor = "Vendor -> " + formatter1.format(date);
				if (i == 1) {
					ScenarioContext.put("TRXVendor1", vendor);
				} else if (i == 2) {
					ScenarioContext.put("TRXVendor2", vendor);
				} else if (i == 3) {
					ScenarioContext.put("TRXVendor3", vendor);
				}

				else if (i == 4) {
					ScenarioContext.put("TRXVendor4", vendor);
				}

				else if (i == 5) {
					ScenarioContext.put("TRXVendor5", vendor);
				}

				else if (i == 6) {
					ScenarioContext.put("TRXVendor6", vendor);
				}

				else if (i == 7) {
					ScenarioContext.put("TRXVendor7", vendor);
				}

				else if (i == 8) {
					ScenarioContext.put("TRXVendor8", vendor);
				}

				else if (i == 9) {
					ScenarioContext.put("TRXVendor9", vendor);
				} else if (i == 10) {
					ScenarioContext.put("TRXVendor10", vendor);
				} else {
					Assert.fail("Vendor Creation Limitation is Exceed" + NoOfCreation1);
				}
				VendorName.sendKeys(vendor);
				BillingAddress1.sendKeys("Billing Address 1");
				VendorCity.sendKeys("Taraus");
				VendorZipcode.sendKeys("12345");
				Select country = new Select(VendorCountry);
				Thread.sleep(2000);
				country.selectByVisibleText("United States");
				Thread.sleep(2000);
				Select state = new Select(VendorState);
				state.selectByVisibleText("Florida");
				Thread.sleep(1000);
				SaveVendorBTN.click();
				Thread.sleep(4000);
				String GetVendorValidationmsg = VendorErrorMsg.getText();

				if (GetVendorValidationmsg.equals("Vendor already exist")) {
					System.out.println(vendor + " This Vendor is already exist in this Company");
					Thread.sleep(5000);
				} else if (GetVendorValidationmsg.equals("Vendor added successfully")) {
					System.out.println(vendor + " This Vendor is Successfully Added");
					Thread.sleep(5000);
				} else {
					System.out.println(vendor + " Not able to add the vendor due to the " + GetVendorValidationmsg);
					Thread.sleep(5000);
				}
			}
		} else {
			Assert.fail("VENDOR LIMITATION IS EXCEED" + NoOfCreation1);
		}

	}
	
	public void TXO_VendorCreationWithMinInfo(String NoOfCreation) throws InterruptedException {

		int NoOfCreation1 = Integer.parseInt(NoOfCreation);
		if (NoOfCreation1 <= 11) {
			for (int i = 1; i <= NoOfCreation1; i++) {
				Thread.sleep(1000);
				VendorSearchIcon.click();
				Thread.sleep(5000);
				AddNewVendorBTN.click();
				Thread.sleep(1000);
				date = new Date();
				vendor = "Vendor -> " + formatter1.format(date);
				if (i == 1) {
					ScenarioContext.put("TXOVendor1", vendor);
				} else if (i == 2) {
					ScenarioContext.put("TXOVendor2", vendor);
				} else if (i == 3) {
					ScenarioContext.put("TXOVendor3", vendor);
				}

				else if (i == 4) {
					ScenarioContext.put("TXOVendor4", vendor);
				}

				else if (i == 5) {
					ScenarioContext.put("TXOVendor5", vendor);
				}

				else if (i == 6) {
					ScenarioContext.put("TXOVendor6", vendor);
				}

				else if (i == 7) {
					ScenarioContext.put("TXOVendor7", vendor);
				}

				else if (i == 8) {
					ScenarioContext.put("TXOVendor8", vendor);
				}

				else if (i == 9) {
					ScenarioContext.put("TXOVendor9", vendor);
				} else if (i == 10) {
					ScenarioContext.put("TXOVendor10", vendor);
				} else {
					Assert.fail("Vendor Creation Limitation is Exceed" + NoOfCreation1);
				}
				VendorName.sendKeys(vendor);
				Thread.sleep(1000);
				SaveVendorBTN.click();
				Thread.sleep(3000);
				String GetVendorValidationmsg = VendorErrorMsg.getText();
				if (GetVendorValidationmsg.equals(VendorAlreadyExist)) {
					System.out.println(vendor + " This Vendor is already exist in this Company");
					Thread.sleep(4000);
				} else if (GetVendorValidationmsg.equals(VendorSuccessfullyAdded)) {
					System.out.println(vendor + " This Vendor is Successfully Added");
					Thread.sleep(4000);
				} else {
					System.out.println(vendor + " Not able to add the vendor due to the " + GetVendorValidationmsg);
					Thread.sleep(4000);
				}
			}
		} else {
			Assert.fail("VENDOR LIMITATION IS EXCEED" + NoOfCreation1);
		}
	}
	
	public void TRX_VendorCreationWithMaxInfo() throws InterruptedException {
				Thread.sleep(1000);
				VendorSearchIcon.click();
				Thread.sleep(5000);
				AddNewVendorBTN.click();
				Thread.sleep(1000);
				date = new Date();
				vendor = "Vendor -> " + formatter1.format(date);
				ScenarioContext.put("TRXMaxVendor", vendor);
				VendorName.sendKeys(vendor);
				BillingAddress1.sendKeys("Billing Address Test 01 Maximum Info TRX");
				BillingAddress2.sendKeys("Billing Address Test 02 Maximum Info TRX");
				BillingAddress3.sendKeys("Billing Address Test 03 Maximum Info TRX");
				BillingAddress4.sendKeys("Billing Address Test 04 Maximum Info TRX");
				VendorCity.sendKeys("Taraus");
				VendorZipcode.sendKeys("12345");
				Select country = new Select(VendorCountry);
				Thread.sleep(2000);
				country.selectByVisibleText("United States");
				Thread.sleep(2000);
				Select state = new Select(VendorState);
				state.selectByVisibleText("Florida");
				ContactFirstName.sendKeys("Contact First Name");
				ContactLastName.sendKeys("Contact Last Name");
				Actions action = new Actions(driver);
				action.moveToElement(VendorContactEmail);
				VendorPhone.sendKeys("+1-999-999-9999");
				VendorFax.sendKeys("091334658");
				Thread.sleep(1000);
				SaveVendorBTN.click();
				Thread.sleep(3000);
				String GetVendorValidationmsg = VendorErrorMsg.getText();

				if (GetVendorValidationmsg.equals("Vendor already exist")) {
					System.out.println(vendor + " This Vendor is already exist in this Company");
					Thread.sleep(4000);
				} else if (GetVendorValidationmsg.equals("Vendor added successfully")) {
					System.out.println(vendor + " This Vendor is Successfully Added");
					Thread.sleep(4000);
				} else {
					System.out.println(vendor + " Not able to add the vendor due to the " + GetVendorValidationmsg);
					Thread.sleep(4000);
				}
	}
	
	public void TXO_VendorCreationWithMaxInfo() throws InterruptedException {
				Thread.sleep(1000);
				VendorSearchIcon.click();
				Thread.sleep(5000);
				AddNewVendorBTN.click();
				Thread.sleep(1000);
				date = new Date();
				vendor = "Vendor -> " + formatter1.format(date);
				ScenarioContext.put("TXOMaxVendor", vendor);
				VendorName.sendKeys(vendor);
				BillingAddress1.sendKeys("Billing Address Test 01 Maximum Info TRX");
				BillingAddress2.sendKeys("Billing Address Test 02 Maximum Info TRX");
				BillingAddress3.sendKeys("Billing Address Test 03 Maximum Info TRX");
				BillingAddress4.sendKeys("Billing Address Test 04 Maximum Info TRX");
				VendorCity.sendKeys("Taraus");
				VendorZipcode.sendKeys("12345");
				Select country = new Select(VendorCountry);
				Thread.sleep(2000);
				country.selectByVisibleText("United States");
				Thread.sleep(3000);
				Select state = new Select(VendorState);
				state.selectByVisibleText("Florida");
				ContactFirstName.sendKeys("Contact First Name");
				ContactLastName.sendKeys("Contact Last Name");
				Actions action = new Actions(driver);
				action.moveToElement(VendorContactEmail);
				VendorPhone.sendKeys("+1-999-999-9999");
				VendorFax.sendKeys("091334658");
				action.moveToElement(VendorContactEmail);
				Thread.sleep(1000);
				SaveVendorBTN.click();
				Thread.sleep(3000);
				String GetVendorValidationmsg = VendorErrorMsg.getText();

				if (GetVendorValidationmsg.equals(VendorAlreadyExist)) {
					System.out.println(vendor + " This Vendor is already exist in this Company");
					Thread.sleep(4000);
				} else if (GetVendorValidationmsg.equals(VendorSuccessfullyAdded)) {
					System.out.println(vendor + " This Vendor is Successfully Added");
					Thread.sleep(4000);
				} else {
					System.out.println(vendor + " Not able to add the vendor due to the " + GetVendorValidationmsg);
					Thread.sleep(4000);
				}

	}

//	----------------------------------------------------------------------------------------------
//	--------------------Customer Creation Min and Max Info of TXO and TRX---------------------------
//	---------------------------------------------------------------------------------------------
	
	public void TRX_CustomerCreationWithMinInfo(String NoOfCreation) throws InterruptedException {
		
		Thread.sleep(1000);
		Select state = new Select(MyCompany);
		state.selectByVisibleText("Customer");
		int NoOfCreation1 = Integer.parseInt(NoOfCreation);
		if (NoOfCreation1 <= 11) {
			for (int i = 1; i <= NoOfCreation1; i++) {
				Thread.sleep(1000);
				CustomerSearchIcon.click();
				Thread.sleep(5000);
				AddNewCustomerBTN.click();
				Thread.sleep(1000);
				date = new Date();
				customer = "Customer -> " + formatter1.format(date);
				if (i == 1) {
					ScenarioContext.put("TRXCustomer1", customer);
				} else if (i == 2) {
					ScenarioContext.put("TRXCustomer2", customer);
				} else if (i == 3) {
					ScenarioContext.put("TRXCustomer3", customer);
				}
				else if (i == 4) {
					ScenarioContext.put("TRXCustomer4", customer);
				}
				else if (i == 5) {
					ScenarioContext.put("TRXCustomer5", customer);
				}
				else if (i == 6) {
					ScenarioContext.put("TRXCustomer6", customer);
				}
				else if (i == 7) {
					ScenarioContext.put("TRXCustomer7", customer);
				}
				else if (i == 8) {
					ScenarioContext.put("TRXCustomer8", customer);
				}
				else if (i == 9) {
					ScenarioContext.put("TRXCustomer9", customer);
				} else if (i == 10) {
					ScenarioContext.put("TRXCustomer10", customer);
				} else {
					Assert.fail("Customer Creation Limitation is Exceeded" + NoOfCreation1);
				}
				CustomerName.sendKeys(customer);
				ShippingAddress1.sendKeys("Shipping Address Test 1");
				CustomerCity.sendKeys("Taurus");
				CustomerZipcode.sendKeys("12345");
				Select country1 = new Select(CustomerCountry);
				country1.selectByVisibleText("United States");
				Thread.sleep(2000);
				Select state1 = new Select(CustomerState);
				state1.selectByVisibleText("California");
				Thread.sleep(1000);
				SaveCustomerBTN.click();
				Thread.sleep(3000);
				String GetCustomerValidationmsg = CustomerErrorMsg.getText();

				if (GetCustomerValidationmsg.equals("Customer already exist")) {
					System.out.println(customer + " This customer is already exist in this Company");
					Thread.sleep(4000);
				} else if (GetCustomerValidationmsg.equals("Customer added successfully")) {
					System.out.println(customer + " This customer is Successfully Added");
					Thread.sleep(4000);
				} else {
					System.out
							.println(customer + " Not able to add the customer due to the " + GetCustomerValidationmsg);
					Thread.sleep(4000);
				}

			}
		} else {
			Assert.fail("CUSTOMER LIMITATION IS EXCEEDED" + NoOfCreation1);
		}
	}
	
    public void TXO_CustomerCreationWithMinInfo(String NoOfCreation) throws InterruptedException {
		
		Thread.sleep(1000);
		int NoOfCreation1 = Integer.parseInt(NoOfCreation);
		if (NoOfCreation1 <= 11) {
			for (int i = 1; i <= NoOfCreation1; i++) {
				Thread.sleep(1000);
				CustomerSearchIcon.click();
				Thread.sleep(5000);
				AddNewCustomerBTN.click();
				Thread.sleep(1000);
				date = new Date();
				customer = "Customer -> " + formatter1.format(date);
				if (i == 1) {
					ScenarioContext.put("TXOCustomer1", customer);
				} else if (i == 2) {
					ScenarioContext.put("TXOCustomer2", customer);
				} else if (i == 3) {
					ScenarioContext.put("TXOCustomer3", customer);
				}
				else if (i == 4) {
					ScenarioContext.put("TXOCustomer4", customer);
				}
				else if (i == 5) {
					ScenarioContext.put("TXOCustomer5", customer);
				}
				else if (i == 6) {
					ScenarioContext.put("TXOCustomer6", customer);
				}
				else if (i == 7) {
					ScenarioContext.put("TRXCustomer7", customer);
				}
				else if (i == 8) {
					ScenarioContext.put("TXOCustomer8", customer);
				}
				else if (i == 9) {
					ScenarioContext.put("TXOCustomer9", customer);
				} else if (i == 10) {
					ScenarioContext.put("TXOCustomer10", customer);
				} else {
					Assert.fail("Customer Creation Limitation is Exceeded" + NoOfCreation1);
				}
				CustomerName.sendKeys(customer);
				Thread.sleep(1000);
				SaveCustomerBTN.click();
				Thread.sleep(3000);
				String GetCustomerValidationmsg = CustomerErrorMsg.getText();

				if (GetCustomerValidationmsg.equals(CustomerAlreadyExist)) {
					System.out.println(customer + " This customer is already exist in this Company");
					Thread.sleep(4000);
				} else if (GetCustomerValidationmsg.equals(CustomerSuccessfullyAdded)) {
					System.out.println(customer + " This customer is Successfully Added");
					Thread.sleep(4000);
				} else {
					System.out
							.println(customer + " Not able to add the customer due to the " + GetCustomerValidationmsg);
					Thread.sleep(4000);
				}

			}
		} else {
			Assert.fail("CUSTOMER LIMITATION IS EXCEEDED" + NoOfCreation1);
		}
	}

    public void TRX_CustomerCreationWithMaxInfo() throws InterruptedException {
		
		Thread.sleep(1000);
		Select state = new Select(MyCompany);
		state.selectByVisibleText("Customer");
				Thread.sleep(1000);
				CustomerSearchIcon.click();
				Thread.sleep(5000);
				AddNewCustomerBTN.click();
				Thread.sleep(1000);
				date = new Date();
				customer = "Customer -> " + formatter1.format(date);
				ScenarioContext.put("TRXMaxCustomer", customer);
				CustomerName.sendKeys(customer);
				ShippingAddress1.sendKeys("Shipping Address Test 01 Test Cycle1 TXO");
				ShippingAddress2.sendKeys("Shipping Address Test 02 Test Cycle1 TXO");
				ShippingAddress3.sendKeys("Shipping Address Test 03 Test Cycle1 TXO");
				ShippingAddress4.sendKeys("Shipping Address Test 04 Test Cycle1 TXO");
				CustomerCity.sendKeys("Taurus");
				CustomerZipcode.sendKeys("12345");
				Select country1 = new Select(CustomerCountry);
				country1.selectByVisibleText("United States");
				Thread.sleep(2000);
				Select state1 = new Select(CustomerState);
				state1.selectByVisibleText("California");
				Thread.sleep(1000);
				CustomerFname.sendKeys("Contact First Name");
				Customerlname.sendKeys("Contact Last Name");
				Actions action = new Actions(driver);
				action.moveToElement(VendorContactEmail);
				CustomerPhone.sendKeys("+1-999-999-9999");
				CustomerFax.sendKeys("091334658");
				Thread.sleep(1000);
				SaveCustomerBTN.click();
				Thread.sleep(3000);
				String GetCustomerValidationmsg = CustomerErrorMsg.getText();

				if (GetCustomerValidationmsg.equals("Customer already exist")) {
					System.out.println(customer + " This customer is already exist in this Company");
					Thread.sleep(4000);
				} else if (GetCustomerValidationmsg.equals("Customer added successfully")) {
					System.out.println(customer + " This customer is Successfully Added");
					Thread.sleep(4000);
				} else {
					System.out
							.println(customer + " Not able to add the customer due to the " + GetCustomerValidationmsg);
					Thread.sleep(4000);
				}
	}

    public void TXO_CustomerCreationWithMaxInfo() throws InterruptedException {
		
		Thread.sleep(1000);
				Thread.sleep(1000);
				CustomerSearchIcon.click();
				Thread.sleep(5000);
				AddNewCustomerBTN.click();
				Thread.sleep(1000);
				date = new Date();
				customer = "Customer -> " + formatter1.format(date);
				String customers =  formatter1.format(date);
				ScenarioContext.put("TXOMaxCustomer", customers);
				CustomerName.sendKeys(customer);
				ShippingAddress1.sendKeys("Shipping Address Test 01 Test Cycle1 TXO");
				ShippingAddress2.sendKeys("Shipping Address Test 02 Test Cycle1 TXO");
				ShippingAddress3.sendKeys("Shipping Address Test 03 Test Cycle1 TXO");
				ShippingAddress4.sendKeys("Shipping Address Test 04 Test Cycle1 TXO");
				CustomerCity.sendKeys("Taurus");
				CustomerZipcode.sendKeys("12345");
				Select country1 = new Select(CustomerCountry);
				Thread.sleep(1000);
				country1.selectByVisibleText("United States");
				Thread.sleep(3000);
				Select state1 = new Select(CustomerState);
				state1.selectByVisibleText("California");
				Thread.sleep(1000);
				CustomerFname.sendKeys("Contact First Name");
				Customerlname.sendKeys("Contact Last Name");
				Actions action = new Actions(driver);
				action.moveToElement(CustomerEmail);
				CustomerPhone.sendKeys("+1-999-999-9999");
				CustomerFax.sendKeys("091334658");
				Thread.sleep(1000);
				SaveCustomerBTN.click();
				Thread.sleep(3000);
				String GetCustomerValidationmsg = CustomerErrorMsg.getText();

				if (GetCustomerValidationmsg.equals(CustomerAlreadyExist)) {
					System.out.println(customer + " This customer is already exist in this Company");
					Thread.sleep(4000);
				} else if (GetCustomerValidationmsg.equals(CustomerSuccessfullyAdded)) {
					System.out.println(customer + " This customer is Successfully Added");
					Thread.sleep(4000);
				} else {
					System.out
							.println(customer + " Not able to add the customer due to the " + GetCustomerValidationmsg);
					Thread.sleep(4000);
				}
	}

    
//	----------------------------------------------------------------------------------------------
//	--------------------ITEMS Creation Min and Max Info of TXO---------------------------
//	---------------------------------------------------------------------------------------------
    
	public void TXO_ItemCreationProcessFor_SVR_INV_NonINV_WithMinInfo(String NoOfCreation) throws InterruptedException 
	{
		int NoOfCreation1 = Integer.parseInt(NoOfCreation);
		noofcreationItems = NoOfCreation1;
		if (NoOfCreation1 >= 0 && NoOfCreation1 <= 24 ) 
		{
						for (int i = 1; i <= NoOfCreation1; i++) 
						{
							int lineitem = i + 1;
										String LineitemNointoString = Integer.toString(lineitem);
										OpenItemCreationLookup(LineitemNointoString);
										Thread.sleep(1000);
						
										if (i >= 1 && i <= 4) 
										{
											C_ServicesRadioBTN.click();
											date = new Date();
											ItemName = "SVR -> " + formatter1.format(date);
											if(i==1) {
												System.out.println(ItemName);
												ScenarioContext.put("TXOItemsName1", ItemName);
//												System.out.println("dead : " + ScenarioContext.get("TXOItemsName1"));
											}
											else if(i == 2) {
												ScenarioContext.put("TXOItemsName2", ItemName);
											}
											else if(i == 3) {
												ScenarioContext.put("TXOItemsName3", ItemName);
											}
											else if(i == 4) {
												ScenarioContext.put("TXOItemsName4", ItemName);
											}
											TXO_ServicesCreationWithMinInfo(ItemName);
										}
						
										else if (i >= 5 && i <= 8) 
										{
											C_InventoryRadioBTN.click();
											date = new Date();
											ItemName = "INV -> "+ formatter1.format(date);
											if(i == 5) {
												ScenarioContext.put("TXOItemsName5", ItemName);
											}
											else if(i == 6) {
												ScenarioContext.put("TXOItemsName6", ItemName);
											}
											else if(i == 7) {
												ScenarioContext.put("TXOItemsName7", ItemName);
											}
											else if(i == 8) {
												ScenarioContext.put("TXOItemsName8", ItemName);
											}
											TXO_InventoryCreationWithMinInfo(ItemName);
										}
										
										else if (i >= 9 && i <= 12) 
										{
											C_NonInventoryRadioBTN.click();
											date = new Date();
											ItemName = "NON_INV "  + formatter1.format(date);
											if(i == 9) {
												ScenarioContext.put("TXOItemsName9", ItemName);
											}
											else if(i == 10) {
												ScenarioContext.put("TXOItemsName10", ItemName);
											}
											else if(i == 11) {
												ScenarioContext.put("TXOItemsName11", ItemName);
											}
											else if(i == 12) {
												ScenarioContext.put("TXOItemsName12", ItemName);
											}
											TXO_NonInventoryCreationWithMinInfo(ItemName);
									}
						
										else if (i >= 13 && i <= 16) 
										{
											C_ServicesRadioBTN.click();
											date = new Date();
											ItemName = "Other -> "  + formatter1.format(date);
											if(i == 13) {
												ScenarioContext.put("TXOItemsName13", ItemName);
											}
											else if(i == 14) {
												ScenarioContext.put("TXOItemsName14", ItemName);
											}
											else if(i == 15) {
												ScenarioContext.put("TXOItemsName15", ItemName);
											}
											else{
												ScenarioContext.put("TXOItemsName16", ItemName);
											}
											TXO_ServicesCreationWithMinInfo(ItemName);
										}
											
										else if (i >= 17 && i <= 20) {
											C_InventoryRadioBTN.click();
											date = new Date();
											ItemName = "INV -> " + formatter1.format(date);
											if(i==17) {
												ScenarioContext.put("TXOItemsName17", ItemName);
											}
											else if(i == 18) {
												ScenarioContext.put("TXOItemsName18", ItemName);
											}
											else if(i == 19) {
												ScenarioContext.put("TXOItemsName19", ItemName);
											}
											else if(i == 20) {
												ScenarioContext.put("TXOItemsName20", ItemName);
											}
											TXO_InventoryCreationWithMinInfo(ItemName);
										}
										
										else if (i >= 21 && i <= 24)
										{
											C_NonInventoryRadioBTN.click();
											date = new Date();
											ItemName = "NON-INV -> "  + formatter1.format(date);
											if(i == 21) {
												ScenarioContext.put("TXOItemsName21", ItemName);
											}
											else if(i == 22) {
												ScenarioContext.put("TXOItemsName22", ItemName);
											}
											else if(i == 23) {
												ScenarioContext.put("TXOItemsName23", ItemName);
											}
											else if(i == 24) {
												ScenarioContext.put("TXOItemsName24", ItemName);
											}
											TXO_NonInventoryCreationWithMinInfo(ItemName);
										}
						if(lineitem >= 2 && i <= NoOfCreation1-1 ) 
						{
							addnewLineItemRow();
						}
					}
			}
	}
	
	public void TXO_ItemCreationProcessFor_SVR_INV_NonINV_And_VerificationOfEachValidation() throws InterruptedException 
	{
		String NoOfCreation = "4";
		int NoOfCreation1 = Integer.parseInt(NoOfCreation);
		noofcreationItems = NoOfCreation1;
		if (NoOfCreation1 >= 0 && NoOfCreation1 <= 4 ) 
		{
						for (int i = 1; i <= NoOfCreation1; i++) 
						{
							int lineitem = Count.size() + 1;
										String LineitemNointoString = Integer.toString(lineitem);
										OpenItemCreationLookup(LineitemNointoString);
										Thread.sleep(2000);
						
										if (i == 1) 
										{
											C_ServicesRadioBTN.click();
											date = new Date();
											ItemName = "SVR -> " + formatter1.format(date);
											ScenarioContext.put("TXOMaxServices", ItemName);
											TXO_ServicesCreationWithMaxInfo(ItemName);
										}
						
										else if (i == 2) 
										{
											C_InventoryRadioBTN.click();
											date = new Date();
											ItemName = "INV -> "+ formatter1.format(date);
											ScenarioContext.put("TXOMaxInventory", ItemName);
											TXO_InventoryCreationWithMaxInfo(ItemName);
										}
										
										else if (i == 3) 
										{
											C_NonInventoryRadioBTN.click();
											date = new Date();
											ItemName = "NON_INV "  + formatter1.format(date);
											ScenarioContext.put("TXOMaxNonInventory", ItemName);
											TXO_NonInventoryCreationWithMaxInfo(ItemName);
									}
										else if (i == 4) {
											// System.out.println(i);
											String ItemsName = ScenarioContext.get("TXOMaxServices");
											Thread.sleep(2000);
											C_ServicesRadioBTN.click();
											Thread.sleep(2000);
											TXO_DuplicateItemVerification(ItemsName);
											C_InventoryRadioBTN.click();
											TXO_DuplicateItemVerification(ItemsName);
											C_NonInventoryRadioBTN.click();
											TXO_DuplicateItemVerification(ItemsName);
											CloseItemCreationLookup.click();
											
										}
						if(lineitem >= 2 && i <= NoOfCreation1-1 ) 
						{
							addnewLineItemRow();
						}
					}
			}
	}
	
	public void TXO_DuplicateItemVerification(String ItemsName) throws InterruptedException {
		I_ItemName.clear();
		I_ItemName.sendKeys(ItemsName);
		I_ItemAmount.sendKeys("1.99");
		I_ItemQTYONHAND.sendKeys("2");
		C_ItemsSaveBTN.click();
		Thread.sleep(4000);
		String GetItemsValidationmsg = itemValidationMsg.getText();
		Assert.assertEquals(GetItemsValidationmsg, "Unable to create Item in QuickBooks : Item name already exists.","Dulicate msg is not appearing please see snapshot");		
	}
	
	public void TXO_ServicesCreationWithMinInfo(String ItemsName) throws InterruptedException {
		C_ServicesRadioBTN.click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.id("NewItemInfo")).getText(), "Complete the fields below to add a new item to your item list in QuickBooks Online.","item Creation Lookup is not correctly displaying the QBO msg");
		date = new Date();  
		I_ItemName.sendKeys(ItemsName);
		I_PurchasedDescription.sendKeys("Services Items Purchased Description "+ " ");
		I_ItemAmount.sendKeys("10");
		I_ItemQTYONHAND.sendKeys("100");
		C_ItemsSaveBTN.click();
		Thread.sleep(3000);
		String GetItemsValidationmsg = itemValidationMsg.getText();
		if (GetItemsValidationmsg.equals(ItemAlreadyExist)) {
			System.out.println("Item Name = "+ItemsName +" This Item is already exist in this Company");// formatter.format(date)+" This Item is already exist in this Company");
			Thread.sleep(5000);
		} else if (GetItemsValidationmsg.equals(ItemsSuccessfullyAdded)) {
			System.out.println(ItemsName +" This Item is Successfully Added");
			Thread.sleep(5000);
		} else {
			System.out.println(ItemsName +" Not able to add the Item due to the " + GetItemsValidationmsg);
			Thread.sleep(5000);
		}
	}

	public void TXO_InventoryCreationWithMinInfo(String ItemsName) throws InterruptedException {
		C_InventoryRadioBTN.click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.id("NewItemInfo")).getText(), "Complete the fields below to add a new item to your item list in QuickBooks Online.","item Creation Lookup is not correctly displaying the QBO msg");
		date = new Date();  
		I_ItemName.sendKeys(ItemsName);
		I_PurchasedDescription.sendKeys("Inventory Items Purchased Description "+ " ");
		I_ItemAmount.sendKeys("10");
		I_ItemQTYONHAND.sendKeys("100");
		C_ItemsSaveBTN.click();
		Thread.sleep(4000);
		String GetItemsValidationmsg = itemValidationMsg.getText();
		if (GetItemsValidationmsg.equals(ItemAlreadyExist)) {
			System.out.println("Item Name = "+ItemsName +" This Item is already exist in this Company");// formatter.format(date)+" This Item is already exist in this Company");
			Thread.sleep(5000);
		} else if (GetItemsValidationmsg.equals(ItemsSuccessfullyAdded)) {
			System.out.println(ItemsName +" This Item is Successfully Added");
			Thread.sleep(5000);
		} else {
			System.out.println(ItemsName +" Not able to add the Item due to the " + GetItemsValidationmsg);
			Thread.sleep(5000);
		}


	}

	public void TXO_NonInventoryCreationWithMinInfo(String ItemsName) throws InterruptedException {
		C_NonInventoryRadioBTN.click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.id("NewItemInfo")).getText(), "Complete the fields below to add a new item to your item list in QuickBooks Online.","item Creation Lookup is not correctly displaying the QBO msg");
		date = new Date();  
		I_ItemName.sendKeys(ItemsName );
		I_PurchasedDescription.sendKeys("Non Inventory Items Purchased Description" + " ");
		I_ItemAmount.sendKeys("10");
		I_ItemQTYONHAND.sendKeys("100");
		C_ItemsSaveBTN.click();
		Thread.sleep(4000);
		String GetItemsValidationmsg = itemValidationMsg.getText();
		if (GetItemsValidationmsg.equals(ItemAlreadyExist)) {
			System.out.println("Item Name "+ItemsName +"This Item is already exist in this Company");// formatter.format(date)+" This Item is already exist in this Company");
			Thread.sleep(5000);
		} else if (GetItemsValidationmsg.equals(ItemsSuccessfullyAdded)) {
			System.out.println(ItemsName +" This Item is Successfully Added");
			Thread.sleep(5000);
		} else {
			System.out.println(ItemsName +" Not able to add the Item due to the " + GetItemsValidationmsg);
			Thread.sleep(5000);
		}

	} 
	
	public void TXO_ServicesCreationWithMaxInfo(String ItemsName) throws InterruptedException {
		
		C_ServicesRadioBTN.click();
		Thread.sleep(2000);
		
		C_ItemsSaveBTN.click();
		String GetItemnameValidationmsg = itemValidationMsg.getText();
		Assert.assertEquals(GetItemnameValidationmsg, "The Product / Service name can't be blank. Please specify a name.", "Services items Name Validation is not properly Appearing");
		Assert.assertEquals(I_ItemName.getAttribute("maxlength"), "30", "Items Name Maxlength is not correct");
//		Assert.assertEquals(driver.findElement(By.xpath("//div[@id ='section-one']//span[2]")).getText(), "0/1000", "Items Name Maxlength is not correct");
		Assert.assertEquals(I_ItemAmount.getAttribute("maxlength"), "10", "Items Rate Maxlength is not correct");
		Assert.assertEquals(I_ItemQTYONHAND.getAttribute("maxlength"), "10", "Items qtyonHand Maxlength is not correct");
		
		date = new Date();  
		I_ItemName.sendKeys(ItemsName);
		I_PurchasedDescription.sendKeys(MaxDescriptionOfServices);
		
		C_ItemsSaveBTN.click();
		String GetItemCostValidationmsg = itemValidationMsg.getText();
		Assert.assertEquals(GetItemCostValidationmsg, "Item cost can't be blank. Please specify.", "item Cost Validation is not Appearing Properly");
		I_ItemAmount.sendKeys("9,999,999.99");
		
		C_ItemsSaveBTN.click();
		String GetItemOnHandqtyValidationmsg = itemValidationMsg.getText();
		Assert.assertEquals(GetItemOnHandqtyValidationmsg, "Qty on hand can't be blank. Please specify.", "item Qty on hand Validation is not Appearing Properly");
		
		I_ItemQTYONHAND.sendKeys("9,999,999.99");
		C_ItemsSaveBTN.click();
		Thread.sleep(3000);
		String GetItemsValidationmsg = itemValidationMsg.getText();
		if (GetItemsValidationmsg.equals(ItemAlreadyExist)) {
			System.out.println("Item Name = "+ItemsName +" This Item is already exist in this Company");// formatter.format(date)+" This Item is already exist in this Company");
			Thread.sleep(5000);
		} else if (GetItemsValidationmsg.equals(ItemsSuccessfullyAdded)) {
			System.out.println(ItemsName +" This Item is Successfully Added");
			Thread.sleep(5000);
		} else {
			System.out.println(ItemsName +" Not able to add the Item due to the " + GetItemsValidationmsg);
			Thread.sleep(5000);
		}
	}
	
	public void TXO_InventoryCreationWithMaxInfo(String ItemsName) throws InterruptedException {
		C_InventoryRadioBTN.click();
		Thread.sleep(2000);
		
		C_ItemsSaveBTN.click();
		String GetItemnameValidationmsg = itemValidationMsg.getText();
		Assert.assertEquals(GetItemnameValidationmsg, "The Product / Service name can't be blank. Please specify a name.", "Invneoty items Name Validation is not properly Appearing");
		Assert.assertEquals(I_ItemName.getAttribute("maxlength"), "30", "Items Name Maxlength is not correct");
//		Assert.assertEquals(driver.findElement(By.xpath("//div[@id ='section-one']//span[2]")).getText(), "0/1000", "Items Name Maxlength is not correct");
		Assert.assertEquals(I_ItemAmount.getAttribute("maxlength"), "10", "Items Rate Maxlength is not correct");
		Assert.assertEquals(I_ItemQTYONHAND.getAttribute("maxlength"), "10", "Items qtyonHand Maxlength is not correct");
		
		
		
		date = new Date();  
		I_ItemName.sendKeys(ItemsName);
		I_PurchasedDescription.sendKeys(MaxDescriptionOfInventory);
		
		C_ItemsSaveBTN.click();
		String GetItemCostValidationmsg = itemValidationMsg.getText();
		Assert.assertEquals(GetItemCostValidationmsg, "Item cost can't be blank. Please specify.", "item Cost Validation is not Appearing Properly");
		I_ItemAmount.sendKeys("99,999,999.99");
		
		C_ItemsSaveBTN.click();
		String GetItemOnHandqtyValidationmsg = itemValidationMsg.getText();
		Assert.assertEquals(GetItemOnHandqtyValidationmsg, "Qty on hand can't be blank. Please specify.", "item Qty on hand Validation is not Appearing Properly");
		
		
		I_ItemQTYONHAND.sendKeys("99,99,999.99");
		C_ItemsSaveBTN.click();
		Thread.sleep(4000);
		String GetItemsValidationmsg = itemValidationMsg.getText();
		Assert.assertEquals(GetItemsValidationmsg, "Unable to create Item in QuickBooks : Business Validation Error: An amount is either too large (> 99,999,999,999) or too small (< -99,999,999,999), or saving this transaction would result in an account balance that is too large (> 99,999,999,999) or too small (< -99,999,999,999).", "Exceed amount limit exception coming from QB is not appearing");
		I_ItemAmount.clear();
		I_ItemQTYONHAND.clear();
		I_ItemAmount.sendKeys("999.99");
		I_ItemQTYONHAND.sendKeys("99.99");
		C_ItemsSaveBTN.click();
		Thread.sleep(4000);
		String GetItemsValidationmsg1 = itemValidationMsg.getText();
		if (GetItemsValidationmsg1.equals(ItemAlreadyExist)) {
			System.out.println("Item Name = "+ItemsName +" This Item is already exist in this Company");// formatter.format(date)+" This Item is already exist in this Company");
			Thread.sleep(5000);
		} else if (GetItemsValidationmsg1.equals(ItemsSuccessfullyAdded)) {
			System.out.println(ItemsName +" This Item is Successfully Added");
			Thread.sleep(5000);
		} else {
			System.out.println(ItemsName +" Not able to add the Item due to the " + GetItemsValidationmsg);
			Thread.sleep(5000);
		}


	}
	
	public void TXO_NonInventoryCreationWithMaxInfo(String ItemsName) throws InterruptedException {
		C_NonInventoryRadioBTN.click();
		Thread.sleep(2000);
		
		C_ItemsSaveBTN.click();
		String GetItemnameValidationmsg = itemValidationMsg.getText();
		Assert.assertEquals(GetItemnameValidationmsg, "The Product / Service name can't be blank. Please specify a name.", "Non Inventory items Name Validation is not properly Appearing");
		Assert.assertEquals(I_ItemName.getAttribute("maxlength"), "30", "Items Name Maxlength is not correct");
//		Assert.assertEquals(driver.findElement(By.xpath("//div[@id ='section-one']//span[2]")).getText(), "0/1000", "Items Name Maxlength is not correct");
		Assert.assertEquals(I_ItemAmount.getAttribute("maxlength"), "10", "Items Rate Maxlength is not correct");
		Assert.assertEquals(I_ItemQTYONHAND.getAttribute("maxlength"), "10", "Items qtyonHand Maxlength is not correct");
		
		
		date = new Date();  
		I_ItemName.sendKeys(ItemsName );
		I_PurchasedDescription.sendKeys(MaxDescriptionOfNonInventory);
		
		C_ItemsSaveBTN.click();
		String GetItemCostValidationmsg = itemValidationMsg.getText();
		Assert.assertEquals(GetItemCostValidationmsg, "Item cost can't be blank. Please specify.", "item Cost Validation is not Appearing Properly");
		I_ItemAmount.sendKeys("9,999,999.99");
		
		C_ItemsSaveBTN.click();
		String GetItemOnHandqtyValidationmsg = itemValidationMsg.getText();
		Assert.assertEquals(GetItemOnHandqtyValidationmsg, "Qty on hand can't be blank. Please specify.", "item Qty on hand Validation is not Appearing Properly");
		
		
	
		I_ItemQTYONHAND.sendKeys("9,999,999.99");
		C_ItemsSaveBTN.click();
		Thread.sleep(4000);
		String GetItemsValidationmsg = itemValidationMsg.getText();
		if (GetItemsValidationmsg.equals(ItemAlreadyExist)) {
			System.out.println("Item Name "+ItemsName +"This Item is already exist in this Company");// formatter.format(date)+" This Item is already exist in this Company");
			Thread.sleep(5000);
		} else if (GetItemsValidationmsg.equals(ItemsSuccessfullyAdded)) {
			System.out.println(ItemsName +" This Item is Successfully Added");
			Thread.sleep(5000);
		} else {
			System.out.println(ItemsName +" Not able to add the Item due to the " + GetItemsValidationmsg);
			Thread.sleep(5000);
		}

	} 

//	----------------------------------------------------------------------------------------------
//	--------------------ITEMS Creation Min and Max Info of TRX---------------------------
//	---------------------------------------------------------------------------------------------
	
	@FindBy(xpath = "//input[@id = 'radio-inventory']//parent::div")
	WebElement radioInventoryCheck;

	@FindBy(xpath = "//input[@id = 'radio-service']//parent::div")
	WebElement radioServiceCheck;

	@FindBy(xpath = "//input[@id = 'radio-noninventory']//parent::div")
	WebElement radioNonInventoryCheck;

	@FindBy(xpath = "//input[@id = 'radio-othercharge']//parent::div")
	WebElement radioOtherChargeCheck;
	
	// Items
		@FindBy(xpath = "//div[@id = 'item_lookup']//div[@class = 'divfilter']//input[@id = 'filterItem2']")
		WebElement SearchItemFields; 
		
		@FindBy(xpath = "//span[@class=\"prefix class-autocomplete-item lefields-big search\"]")
		WebElement ItemSearchIcon;

		@FindBy(id = "btnAddNewItem")
		WebElement AddNewItemBTN;

		@FindBy(id = "QBItemName")
		WebElement I_TRXItemName;

		@FindBy(id = "txtUnitPrice")
		WebElement Purchasedcost;

		@FindBy(id = "txtPurchaseDescription")
		WebElement Purchaseddesc;

		@FindBy(id = "txtSalesCost")
		WebElement SaleCost;

		@FindBy(id = "txtSalesDescription")
		WebElement Saledesc;
	
		//TRX Accounts 
		@FindBy(id = "select1")
		WebElement S_ExpenseAccount;

		@FindBy(id = "select1")
		WebElement S_COGSAccount;

		@FindBy(id = "select2")
		WebElement S_AssetAccount;

		@FindBy(id = "select3")
		WebElement S_IncomeAccount;

		@FindBy(id = "btnSaveNewItem")
		WebElement SaveItem;

		@FindBy(id = "addnewitem_modal_close")
		WebElement CloseItem;

		@FindBy(id = "lblError")
		WebElement ItemErrorMsg;
		
		@FindBy(xpath = "//table[@id = 'grdReq']//tbody//tr//td[@class = 'RowNumber']")
		List<WebElement> Count;		
		
		public String TRXitemalreadexist = "Item Name already exist";
		public 	String TRXVendorAlreadyExist = "Another customer, vendor or employee is already using this name";
		public String TRXCustomerAlreadyExist = "Another customer, vendor or employee is already using this name";
		public 	String TRXVendorSuccessfullyAdded = "Vendor successfully added in your QuickBooks"; //Vendor successfully added in your QuickBooks lblNewVendorError
		public String TRXCustomerSuccessfullyAdded = "Customer successfully added in your QuickBooks";
		public String TRXItemAlreadyExist = " Unable to create Item in QuickBooks : Item name already exists.";
		public String TRXItemsSuccessfullyAdded = "Item added successfully";
		public String TRXMaxDescriptionOfNonInventory = "Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inventory Items Purchased Description With Max Limit Test Non-Inve";
		public String TRXMaxDescriptionOfInventory = "Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Description Maximum Test Inventory Items Purchased Descr";
		public String TRXMaxDescriptionOfServices = "Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Description Test Services Items Purchased Descripti";
		public String TRXMaxDescriptionOfOtherCharge = "Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Description Test Other Charge Items Purchased Descr";
		
		public String TRXMaxSalesDescriptionOfNonInventory = "Non-Inventory Items Sales Description With Max Limit Test Non-Inventory Items Sales Description With Max Limit Test Non-Inventory Items Sales Description With Max Limit Test Non-Inventory Items Sales Description With Max Limit Test Non-Inventory Items Sales Description With Max Limit Test Non-Inventory Items Sales Description With Max Limit Test Non-Inventory Items Sales Description With Max Limit Test Non-Inventory Items Sales Description With Max Limit Test Non-Inventory Items Sales Description With Max Limit Test Non-Inventory Items Sales Description With Max Limit Test Non-Inventory Items Sales Description With Max Limit Test Non-Inventory Items Sales Description With Max Limit Test Non-Inventory Items Sales Description With Max Limit Test Non-Inventory Items Sales Description With Max Limit Test Non-Inventory Items Sales Description With Max Limit Test Non-Inventory Items Sales Description With Max Limit Test Non-Inve";
		public String TRXSalesMaxDescriptionOfInventory = "Inventory Items Sales Description Maximum Test Inventory Items Sales Description Maximum Test Inventory Items Sales Description Maximum Test Inventory Items Sales Description Maximum Test Inventory Items Sales Description Maximum Test Inventory Items Sales Description Maximum Test Inventory Items Sales Description Maximum Test Inventory Items Sales Description Maximum Test Inventory Items Sales Description Maximum Test Inventory Items Sales Description Maximum Test Inventory Items Sales Description Maximum Test Inventory Items Sales Description Maximum Test Inventory Items Sales Description Maximum Test Inventory Items Sales Description Maximum Test Inventory Items Sales Description Maximum Test Inventory Items Sales Description Maximum Test Inventory Items Sales Description Maximum Test Inventory Items Sales Description Maximum Test Inventory Items Sales Description Maximum Test Inventory Items Sales Descr";
		public String TRXSalesMaxDescriptionOfServices = "Services Items Sales Description Test Services Items Sales Description Test Services Items Sales Description Test Services Items Sales Description Test Services Items Sales Description Test Services Items Sales Description Test Services Items Sales Description Test Services Items Sales Description Test Services Items Sales Description Test Services Items Sales Description Test Services Items Sales Description Test Services Items Sales Description Test Services Items Sales Description Test Services Items Sales Description Test Services Items Sales Description Test Services Items Sales Description Test Services Items Sales Description Test Services Items Sales Description Test Services Items Sales Description Test Services Items Sales Description Test Services Items Sales Description Test Services Items Sales Description Test Services Items Sales Description Test Services Items Sales Descripti";
		public String TRXSalesMaxDescriptionOfOtherCharge = "Other Charge Items Sales Description Test Other Charge Items Sales Description Test Other Charge Items Sales Description Test Other Charge Items Sales Description Test Other Charge Items Sales Description Test Other Charge Items Sales Description Test Other Charge Items Sales Description Test Other Charge Items Sales Description Test Other Charge Items Sales Description Test Other Charge Items Sales Description Test Other Charge Items Sales Description Test Other Charge Items Sales Description Test Other Charge Items Sales Description Test Other Charge Items Sales Description Test Other Charge Items Sales Description Test Other Charge Items Sales Description Test Other Charge Items Sales Description Test Other Charge Items Sales Description Test Other Charge Items Sales Description Test Other Charge Items Sales Description Test Other Charge Items Sales Description Test Other Charge Items Sales Descr";

	
	public void TRX_MinItemCreationForSVR_INV_NINV_OC(String NoOfCreation) throws InterruptedException {
			int NoOfCreation1 = Integer.parseInt(NoOfCreation);
//			if(NoOfCreation1 >= 4 && NoOfCreation1 <= 11) {
			if (NoOfCreation1 >= 0 && NoOfCreation1 <= 24) {

				for (int i = 1; i <= NoOfCreation1; i++) {
					// System.out.println(i);
					int lineitem = i + 1;
					// System.out.println(lineitem);
					String LineitemNointoString = Integer.toString(lineitem);
					OpenItemCreationLookup(LineitemNointoString);
					Thread.sleep(2000);

					if (i >= 1 && i <= 4) {
						// System.out.println(i);
						Thread.sleep(2000);
						radioServiceCheck.click();
						Thread.sleep(2000);
						date = new Date();
						String ItemsName = "Service -> " + " " + formatter1.format(date);
						if (i == 1) {
							ScenarioContext.put("TRXItemsName1", ItemsName);
						} else if (i == 2) {
							ScenarioContext.put("TRXItemsName2", ItemsName);
						} else if (i == 3) {
							ScenarioContext.put("TRXItemsName3", ItemsName);
						} else if (i == 4) {
							ScenarioContext.put("TRXItemsName4", ItemsName);

						}
						TRX_ServicesCreationWithMinInfo(ItemsName);
					}

					else if (i >= 5 && i <= 8) {
						Thread.sleep(2000);
						radioInventoryCheck.click();
						Thread.sleep(2000);
						date = new Date();
						String ItemsName = "Inv -> " + " " + formatter1.format(date);
						if (i == 5) {
							ScenarioContext.put("TRXItemsName5", ItemsName);
						} else if (i == 6) {
							ScenarioContext.put("TRXItemsName6", ItemsName);
						} else if (i == 7) {
							ScenarioContext.put("TRXItemsName7", ItemsName);
						} else if (i == 8) {
							ScenarioContext.put("TRXItemsName8", ItemsName);

						}

						TRX_InventoryCreationWithMinInfo(ItemsName);
					}

					else if (i >= 9 && i <= 12) {

						Thread.sleep(3000);
						radioNonInventoryCheck.click();
						Thread.sleep(4000);
						date = new Date();
						String ItemsName = "Non-Inv -> " + " " + formatter1.format(date);
						if (i == 9) {
							ScenarioContext.put("TRXItemsName9", ItemsName);
						} else if (i == 10) {
							ScenarioContext.put("TRXItemsName10", ItemsName);
						} else if (i == 11) {
							ScenarioContext.put("TRXItemsName11", ItemsName);
						} else if (i == 12) {
							ScenarioContext.put("TRXItemsName12", ItemsName);

						}
						TRX_NonInventoryCreationWithMinInfo(ItemsName);

					}

					else if (i >= 13 && i <= 16) {

						Thread.sleep(3000);
						radioOtherChargeCheck.click();
						Thread.sleep(4000);
						date = new Date();
						String ItemsName = "OC -> " + " " + formatter1.format(date);
						if (i == 13) {
							ScenarioContext.put("TRXItemsName13", ItemsName);
						} else if (i == 14) {
							ScenarioContext.put("TRXItemsName14", ItemsName);
						} else if (i == 15) {
							ScenarioContext.put("TRXItemsName15", ItemsName);
						} else if (i == 16) {
							ScenarioContext.put("TRXItemsName16", ItemsName);

						}

						TRX_OtherChargeCreationWithMinInfo(ItemsName);
					}

					else if (i >= 17 && i <= 20) {
						Thread.sleep(3000);
						radioServiceCheck.click();
						Thread.sleep(4000);
						date = new Date();
						String ItemsName = "SRV -> " + " " + formatter1.format(date);
						if (i == 17) {
							ScenarioContext.put("TRXItemsName17", ItemsName);
						} else if (i == 18) {
							ScenarioContext.put("TRXItemsName18", ItemsName);
						} else if (i == 18) {
							ScenarioContext.put("TRXItemsName19", ItemsName);
						} else if (i == 20) {
							ScenarioContext.put("TRXItemsName20", ItemsName);

						}
						TRX_ServicesCreationWithMinInfo(ItemsName);
					}

					else if (i >= 21 && i <= 24) {

						radioInventoryCheck.click();
						Thread.sleep(4000);
						date = new Date();
						String ItemsName = "Inv -> " + " " + formatter1.format(date);
						if (i == 21) {
							ScenarioContext.put("TRXItemsName21", ItemsName);
						} else if (i == 22) {
							ScenarioContext.put("TRXItemsName22", ItemsName);
						} else if (i == 23) {
							ScenarioContext.put("TRXItemsName23", ItemsName);
						} else if (i == 24) {
							ScenarioContext.put("TRXItemsName24", ItemsName);

						}

						TRX_InventoryCreationWithMinInfo(ItemsName);
					}

					if (lineitem >= 2 && i <= NoOfCreation1 - 1) {
						addnewLineItemRow();
					}
				}

			}
//			}else {
//				Assert.fail(NoOfCreation1+" The NoOfCreation item Should be 4 or Greater Than 4");
//			}
		}
	
	public void TRX_MaxItemCreationForSVR_INV_NINV_OC_And_VerificationOfEahValidation() throws InterruptedException {
		String NoOfCreation = "5";
		int NoOfCreation1 = Integer.parseInt(NoOfCreation);
		noofcreationItems = NoOfCreation1;
		if (NoOfCreation1 >= 1 && NoOfCreation1 <= 4) {

			for (int i = 1; i <= NoOfCreation1; i++) {
				// System.out.println(i);
				int lineitem = Count.size() + 1;
				// System.out.println(lineitem);
				String LineitemNointoString = Integer.toString(lineitem);
				OpenItemCreationLookup(LineitemNointoString);
				Thread.sleep(2000);

				
				if (i == 1) {
					// System.out.println(i);
					Thread.sleep(2000);
					radioServiceCheck.click();
					Thread.sleep(2000);
					date = new Date();
					String ItemsName = "Service -> " + " " + formatter1.format(date);
					ScenarioContext.put("TRXMaxServices", ItemsName);
					TRX_ServicesCreationWithMaxInfoAndVerificationOfthePopupandValidation(ItemsName);
				}

				else if (i == 2) {
					Thread.sleep(2000);
					radioInventoryCheck.click();
					Thread.sleep(2000);
					date = new Date();
					String ItemsName = "Inv -> " + " " + formatter1.format(date);
					ScenarioContext.put("TRXMaxInventory", ItemsName);
					TRX_InventoryCreationWithMaxInfoAndVerificationOfthePopupandValidation(ItemsName);
				}

				else if (i  == 3) {

					Thread.sleep(3000);
					radioNonInventoryCheck.click();
					Thread.sleep(4000);
					date = new Date();
					String ItemsName = "Non-Inv -> " + " " + formatter1.format(date);
					ScenarioContext.put("TRXMaxNonInventory", ItemsName);
					TRX_NonInventoryCreationWithMaxInfoAndVerificationOfthePopupandValidation(ItemsName);

				}

				else if (i == 4) {

					Thread.sleep(3000);
					radioOtherChargeCheck.click();
					Thread.sleep(4000);
					date = new Date();
					String ItemsName = "OC -> " + " " + formatter1.format(date);
					ItemName = formatter1.format(date);
					ScenarioContext.put("TRXMaxOtherCharge", ItemName);
					TRX_OtherChargeCreationWithMaxInfoAndVerificationOfthePopupandValidation(ItemsName);
				}
				else if (i == 5) {
					// System.out.println(i);
					String ItemsName = ScenarioContext.get("TRXMaxServices");
					Thread.sleep(2000);
					radioServiceCheck.click();
					Thread.sleep(2000);
					TRX_ItemDuplicationVerification(ItemsName);
					radioInventoryCheck.click();
					TRX_ItemDuplicationVerification(ItemsName);
					radioNonInventoryCheck.click();
					TRX_ItemDuplicationVerification(ItemsName);
					CloseItem.click();
					
				}

				if (lineitem >= 2 && i <= NoOfCreation1 - 1) {
					addnewLineItemRow();
				}
			}

		}
	}
	
	public void TRX_ItemDuplicationVerification(String ItemName) throws InterruptedException {
		I_TRXItemName.clear();
		I_TRXItemName.sendKeys(ItemName);
		Thread.sleep(2000);
		Select ExpenseAcc = new Select(S_ExpenseAccount);
		ExpenseAcc.selectByVisibleText("Accumulated Depreciation");
		Thread.sleep(2000);
		Select IncomeAcc = new Select(S_IncomeAccount);
		IncomeAcc.selectByVisibleText("Depreciation Expense");
		Thread.sleep(1000);
		SaveItem.click();
		Thread.sleep(4000);
		String GetItemValidationmsg = ItemErrorMsg.getText();
		Assert.assertEquals(GetItemValidationmsg, "Item Name already exist","Duplicate Items msg is not appearing see snapshot");
	}

	public void TRX_ServicesCreationWithMinInfo(String ItemsName) throws InterruptedException {
		I_TRXItemName.sendKeys(ItemsName);
		Thread.sleep(2000);
		Select ExpenseAcc = new Select(S_ExpenseAccount);
		ExpenseAcc.selectByVisibleText("Accumulated Depreciation");
		Thread.sleep(2000);
		Select IncomeAcc = new Select(S_IncomeAccount);
		IncomeAcc.selectByVisibleText("Depreciation Expense");
		Thread.sleep(1000);
		SaveItem.click();
		Thread.sleep(3000);
		String GetItemValidationmsg = ItemErrorMsg.getText();
		if (GetItemValidationmsg.equals(TRXItemAlreadyExist)) {
			System.out.println(ItemsName + " This Services Item is already exist in this Company");
			Thread.sleep(5000);
			Thread.sleep(1000);
		} else if (GetItemValidationmsg.equals(TRXItemsSuccessfullyAdded)) {
			System.out.println(ItemsName + " This Services Item is Successfully Added");
			Thread.sleep(5000);
			Thread.sleep(1000);
		} else {
			System.out.println(ItemsName + " Not able to add the Services Item due to the " + GetItemValidationmsg);
			Thread.sleep(5000);
			Thread.sleep(1000);
		}
	}

	public void TRX_InventoryCreationWithMinInfo(String ItemsName) throws InterruptedException {
		I_TRXItemName.sendKeys(ItemsName);
		Select CogsAcc = new Select(S_COGSAccount);
		CogsAcc.selectByVisibleText("Accumulated Depreciation");
		Thread.sleep(2000);
		Select AssetAcc = new Select(S_AssetAccount);
		AssetAcc.selectByVisibleText("Accumulated Depreciation");
		Thread.sleep(2000);
		Select IncomeAcc = new Select(S_IncomeAccount);
		IncomeAcc.selectByVisibleText("Depreciation Expense");
		Thread.sleep(1000);
		SaveItem.click();
		Thread.sleep(3000);
		String GetItemValidationmsg = ItemErrorMsg.getText();
		if (GetItemValidationmsg.equals(TRXItemAlreadyExist)) {
			System.out.println(ItemsName + " This Inventory Item is already exist in this Company");
			Thread.sleep(5000);

		} else if (GetItemValidationmsg.equals(TRXItemsSuccessfullyAdded)) {
			System.out.println(ItemsName + " This Inventory Item is Successfully Added");
			Thread.sleep(5000);
			Thread.sleep(2000);
		} else {
			System.out.println(ItemsName + " Not able to add the Inventory Item due to the " + GetItemValidationmsg);
			Thread.sleep(5000);

		}

	}

	public void TRX_NonInventoryCreationWithMinInfo(String ItemsName) throws InterruptedException {
		I_TRXItemName.sendKeys(ItemsName);
		Thread.sleep(2000);
		Select ExpenseAcc = new Select(S_ExpenseAccount);
		ExpenseAcc.selectByVisibleText("Accumulated Depreciation");
		Thread.sleep(2000);
		Select IncomeAcc = new Select(S_IncomeAccount);
		IncomeAcc.selectByVisibleText("Depreciation Expense");
		Thread.sleep(1000);
		SaveItem.click();
		Thread.sleep(3000);
		String GetItemValidationmsg = ItemErrorMsg.getText();
		if (GetItemValidationmsg.equals(TRXItemAlreadyExist)) {
			System.out.println(ItemsName + " This Non-Inventory Item is already exist in this Company");
			Thread.sleep(5000);
			Thread.sleep(1000);
		} else if (GetItemValidationmsg.equals(TRXItemsSuccessfullyAdded)) {
			System.out.println(ItemsName + " This Non-Inventory Item is Successfully Added");
			Thread.sleep(5000);
		} else {
			System.out.println(ItemsName + " Not able to add the Non-Inventory Item due to the " + GetItemValidationmsg);
			Thread.sleep(5000);

		}
	}

	public void TRX_OtherChargeCreationWithMinInfo(String ItemsName) throws InterruptedException {
		I_TRXItemName.sendKeys(ItemsName);
		Thread.sleep(2000);
		Select ExpenseAcc = new Select(S_ExpenseAccount);
		ExpenseAcc.selectByVisibleText("Accumulated Depreciation");
		Thread.sleep(2000);
		Select IncomeAcc = new Select(S_IncomeAccount);
		IncomeAcc.selectByVisibleText("Depreciation Expense");
		Thread.sleep(1000);
		SaveItem.click();
		Thread.sleep(3000);
		String GetItemValidationmsg = ItemErrorMsg.getText();
		if (GetItemValidationmsg.equals(TRXItemAlreadyExist)) {
			System.out.println(ItemsName + " This other charge Item is already exist in this Company");
			Thread.sleep(5000);
			Thread.sleep(1000);
		} else if (GetItemValidationmsg.equals(TRXItemsSuccessfullyAdded)) {
			System.out.println(ItemsName + " This other charge Item is Successfully Added");
			Thread.sleep(5000);
			Thread.sleep(1000);
		} else {
			System.out.println(ItemsName + " Not able to add the other charge Item due to the " + GetItemValidationmsg);
			Thread.sleep(5000);
			Thread.sleep(1000);
		}
	}

	public void TRX_ServicesCreationWithMaxInfoAndVerificationOfthePopupandValidation(String ItemsName) throws InterruptedException {
//		String messages= driver.findElement(By.id("NewItemInfo")).getText();

//        int startIndex = messages.indexOf("Complete");// Find the starting index of the desired message        

//        String desiredMessage = messages.substring(startIndex);    // Extract the desired message substring

//        Assert.assertEquals(desiredMessage, "Complete the fields below to add a new item to your item list in QuickBooks. Upon saving, a sync needs to take place & then the new item will be created in QuickBooks.");
		
//		Assert.assertEquals(driver.findElement(By.id("NewItemInfo")).getText(), "Complete the fields below to add a new item to your item list in QuickBooks. Upon saving, a sync needs to take place & then the new item will be created in QuickBooks.");
		Assert.assertEquals(driver.findElement(By.id("IsImbursable-text")).getText(), "This service is used in assemblies or is performed by a subcontractor or partner.", " Services Msg are wrong appearing at the bottom of the purchased descripiton");
		Assert.assertEquals(I_TRXItemName.getAttribute("maxlength"), "30","Items Name Maxlength is not correct");
//		Assert.assertEquals(driver.findElement(By.xpath("//div[@id ='section-one']//span[2]")).getText(), "0/1000", "Items Name Maxlength is not correct");
//		Assert.assertEquals(driver.findElement(By.xpath("//div[@id ='section-three']//span[2]")).getText(), "0/1000", "Items Name Maxlength is not correct");
		Assert.assertEquals(Purchasedcost.getAttribute("maxlength"), "10", "Items Rate Maxlength is not correct");
		Assert.assertEquals(SaleCost.getAttribute("maxlength"), "10", "Items qtyonHand Maxlength is not correct");
		SaveItem.click();
		String GetItemNameValidationmsg = ItemErrorMsg.getText();
		Assert.assertEquals(GetItemNameValidationmsg, "The Product / Service name can't be blank. Please specify a name.", "Services Items Name Validation is not working properly");
		
		I_TRXItemName.sendKeys(ItemsName);
		Thread.sleep(2000);
		Select ExpenseAcc = new Select(S_ExpenseAccount);
		ExpenseAcc.selectByVisibleText("Expense account");
		SaveItem.click();
		String GetItemNameValidationmsg1 = ItemErrorMsg.getText();
		Assert.assertEquals(GetItemNameValidationmsg1, "You must specify an expense account for association.", "Services Expense Name Validation is not working properly");
		
		
		ExpenseAcc.selectByVisibleText("Accumulated Depreciation");
		Thread.sleep(2000);
		Select IncomeAcc = new Select(S_IncomeAccount);
		IncomeAcc.selectByVisibleText("Income account");
		SaveItem.click();
		String GetItemNameValidationmsg2 = ItemErrorMsg.getText();
		Assert.assertEquals(GetItemNameValidationmsg2, "You must specify an income account for association.", "Services Expense Name Validation is not working properly");
		
		
		IncomeAcc.selectByVisibleText("Depreciation Expense");
		Thread.sleep(1000);
		Purchasedcost.sendKeys("111,111,111.11");
		Thread.sleep(1000);
		SaleCost.sendKeys("999,999,999.990");
		I_PurchasedDescription.sendKeys(TRXMaxDescriptionOfServices);
		Saledesc.sendKeys(TRXSalesMaxDescriptionOfServices);
		Thread.sleep(1000);
		SaveItem.click();
		Thread.sleep(3000);
		String GetItemValidationmsg = ItemErrorMsg.getText();
		if (GetItemValidationmsg.equals(TRXItemAlreadyExist)) {
			System.out.println(ItemsName + " This Services Item is already exist in this Company");
			Thread.sleep(5000);
			Thread.sleep(1000);
		} else if (GetItemValidationmsg.equals(TRXItemsSuccessfullyAdded)) {
			System.out.println(ItemsName + " This Services Item is Successfully Added");
			Thread.sleep(5000);
			Thread.sleep(1000);
		} else {
			System.out.println(ItemsName + " Not able to add the Services Item due to the " + GetItemValidationmsg);
			Thread.sleep(5000);
			Thread.sleep(1000);
		}
	}

	public void TRX_InventoryCreationWithMaxInfoAndVerificationOfthePopupandValidation(String ItemsName) throws InterruptedException {
//		String messages= driver.findElement(By.id("NewItemInfo")).getText();

//        int startIndex = messages.indexOf("Complete");// Find the starting index of the desired message        

//        String desiredMessage = messages.substring(startIndex);    // Extract the desired message substring

//        Assert.assertEquals(desiredMessage, "Complete the fields below to add a new item to your item list in QuickBooks.Upon saving, a sync needs to take place & then the new item will be created in QuickBooks.");
		
//		Assert.assertEquals(driver.findElement(By.id("NewItemInfo")).getText(), "Complete the fields below to add a new item to your item list in QuickBooks. Upon saving, a sync needs to take place & then the new item will be created in QuickBooks.");
//		Assert.assertEquals(driver.findElement(By.xpath("//div[@id = 'NewItemInfo']//br")).getText(), "I purchase this assembly from a vendor.", " Invenotry Msg are wrong appearing at the bottom of the purchased descripiton");
		Assert.assertEquals(driver.findElement(By.id("IsImbursable-text")).getText(), "I purchase this assembly from a vendor.", " Invenotry Msg are wrong appearing at the bottom of the purchased descripiton");
		
		//div[@id = 'NewItemInfo']//br
		Assert.assertEquals(I_TRXItemName.getAttribute("maxlength"), "30","Items Name Maxlength is not correct");
//		Assert.assertEquals(driver.findElement(By.xpath("//div[@id ='section-one']//span[2]")).getText(), "0/1000", "Items Name Maxlength is not correct");
//		Assert.assertEquals(driver.findElement(By.xpath("//div[@id ='section-three']//span[2]")).getText(), "0/1000", "Items Name Maxlength is not correct");
		Assert.assertEquals(Purchasedcost.getAttribute("maxlength"), "10", "Items Rate Maxlength is not correct");
		Assert.assertEquals(SaleCost.getAttribute("maxlength"), "10", "Items qtyonHand Maxlength is not correct");
		
		SaveItem.click();
		String GetItemNameValidationmsg = ItemErrorMsg.getText();
		Assert.assertEquals(GetItemNameValidationmsg, "The Product / Service name can't be blank. Please specify a name.", "Inventory Items Name Validation is not working properly");
		
		
		I_TRXItemName.sendKeys(ItemsName);
		Select CogsAcc = new Select(S_COGSAccount);
		CogsAcc.selectByVisibleText("COGS account");
		SaveItem.click();
		String GetItemNameValidationmsg1 = ItemErrorMsg.getText();
		Assert.assertEquals(GetItemNameValidationmsg1, "You must specify a COGS account for association.", "Services Expense Name Validation is not working properly");
		
		
		
		
		CogsAcc.selectByVisibleText("Accumulated Depreciation");
		Thread.sleep(2000);
		Select AssetAcc = new Select(S_AssetAccount);
		AssetAcc.selectByVisibleText("Asset account");
		SaveItem.click();
		String GetItemNameValidationmsg2 = ItemErrorMsg.getText();
		Assert.assertEquals(GetItemNameValidationmsg2, "You must specify an asset account for association.", "Services Expense Name Validation is not working properly");
		
		
		
		AssetAcc.selectByVisibleText("Accumulated Depreciation");
		Thread.sleep(2000);
		Select IncomeAcc = new Select(S_IncomeAccount);
		IncomeAcc.selectByVisibleText("Income account");
		SaveItem.click();
		String GetItemNameValidationmsg3 = ItemErrorMsg.getText();
		Assert.assertEquals(GetItemNameValidationmsg3, "You must specify an income account for association.", "Services Expense Name Validation is not working properly");
		
		
		
		IncomeAcc.selectByVisibleText("Depreciation Expense");
		Thread.sleep(1000);
		Purchasedcost.sendKeys("111,111,111.11");
		Thread.sleep(1000);
		SaleCost.sendKeys("999,999,999.990");
		I_PurchasedDescription.sendKeys(TRXMaxDescriptionOfInventory);
		Saledesc.sendKeys(TRXSalesMaxDescriptionOfInventory);
		Thread.sleep(1000);
		SaveItem.click();
		Thread.sleep(3000);
		String GetItemValidationmsg = ItemErrorMsg.getText();
		if (GetItemValidationmsg.equals(TRXItemAlreadyExist)) {
			System.out.println(ItemsName + " This Inventory Item is already exist in this Company");
			Thread.sleep(5000);

		} else if (GetItemValidationmsg.equals(TRXItemsSuccessfullyAdded)) {
			System.out.println(ItemsName + " This Inventory Item is Successfully Added");
			Thread.sleep(5000);
			Thread.sleep(2000);
		} else {
			System.out.println(ItemsName + " Not able to add the Inventory Item due to the " + GetItemValidationmsg);
			Thread.sleep(5000);

		}

	}

	public void TRX_NonInventoryCreationWithMaxInfoAndVerificationOfthePopupandValidation(String ItemsName) throws InterruptedException {
		
//		Assert.assertEquals(driver.findElement(By.id("NewItemInfo")).getText(), "Complete the fields below to add a new item to your item list in QuickBooks. Upon saving, a sync needs to take place & then the new item will be created in QuickBooks.");
		Assert.assertEquals(driver.findElement(By.id("IsImbursable-text")).getText(), "This item is used in assemblies or is purchased for a specific customer/job.", "Non Invenotry Msg are wrong appearing at the bottom of the purchased descripiton");
		Assert.assertEquals(I_TRXItemName.getAttribute("maxlength"), "30","Items Name Maxlength is not correct");
//		Assert.assertEquals(driver.findElement(By.xpath("//div[@id ='section-one']//span[2]")).getText(), "0/1000", "Items Name Maxlength is not correct");
//		Assert.assertEquals(driver.findElement(By.xpath("//div[@id ='section-three']//span[2]")).getText(), "0/1000", "Items Name Maxlength is not correct");
		Assert.assertEquals(Purchasedcost.getAttribute("maxlength"), "10", "Items Rate Maxlength is not correct");
		Assert.assertEquals(SaleCost.getAttribute("maxlength"), "10", "Items qtyonHand Maxlength is not correct");
		
		SaveItem.click();
		String GetItemNameValidationmsg = ItemErrorMsg.getText();
		Assert.assertEquals(GetItemNameValidationmsg, "The Product / Service name can't be blank. Please specify a name.", "Non Invenotry Items Name Validation is not working properly");
		
		
		I_TRXItemName.sendKeys(ItemsName);
		Thread.sleep(2000);
		Select ExpenseAcc = new Select(S_ExpenseAccount);
		ExpenseAcc.selectByVisibleText("Expense account");
		SaveItem.click();
		String GetItemNameValidationmsg1 = ItemErrorMsg.getText();
		Assert.assertEquals(GetItemNameValidationmsg1, "You must specify an expense account for association.", "Services Expense Name Validation is not working properly");
		
		
		ExpenseAcc.selectByVisibleText("Accumulated Depreciation");
		Thread.sleep(2000);
		Select IncomeAcc = new Select(S_IncomeAccount);
		IncomeAcc.selectByVisibleText("Income account");
		SaveItem.click();
		String GetItemNameValidationmsg2 = ItemErrorMsg.getText();
		Assert.assertEquals(GetItemNameValidationmsg2, "You must specify an income account for association.", "Services Expense Name Validation is not working properly");
		
		
		
		
		
		IncomeAcc.selectByVisibleText("Depreciation Expense");
		Thread.sleep(1000);
		Purchasedcost.sendKeys("111,111,111.11");
		Thread.sleep(1000);
		SaleCost.sendKeys("999,999,999.990");
		I_PurchasedDescription.sendKeys(TRXMaxDescriptionOfNonInventory);
		Saledesc.sendKeys(TRXMaxSalesDescriptionOfNonInventory);
		Thread.sleep(1000);
		SaveItem.click();
		Thread.sleep(3000);
		String GetItemValidationmsg = ItemErrorMsg.getText();
		if (GetItemValidationmsg.equals(TRXItemAlreadyExist)) {
			System.out.println(ItemsName + " This Non-Inventory Item is already exist in this Company");
			Thread.sleep(5000);
			Thread.sleep(1000);
		} else if (GetItemValidationmsg.equals(TRXItemsSuccessfullyAdded)) {
			System.out.println(ItemsName + " This Non-Inventory Item is Successfully Added");
			Thread.sleep(5000);
			Thread.sleep(1000);
		} else {
			System.out
					.println(ItemsName + " Not able to add the Non-Inventory Item due to the " + GetItemValidationmsg);
			Thread.sleep(5000);

		}
	}

	public void TRX_OtherChargeCreationWithMaxInfoAndVerificationOfthePopupandValidation(String ItemsName) throws InterruptedException {
		
//		Assert.assertEquals(driver.findElement(By.id("NewItemInfo")).getText(), "Complete the fields below to add a new item to your item list in QuickBooks. Upon saving, a sync needs to take place & then the new item will be created in QuickBooks.");
		Assert.assertEquals(driver.findElement(By.id("IsImbursable-text")).getText(), "This item is used in assemblies or is a reimbursable charge.", "Other Charge Msg are wrong appearing at the bottom of the purchased descripiton");
		Assert.assertEquals(I_TRXItemName.getAttribute("maxlength"), "30","Items Name Maxlength is not correct");
//		Assert.assertEquals(driver.findElement(By.xpath("//div[@id ='section-one']//span[2]")).getText(), "0/1000", "Items Name Maxlength is not correct");
//		Assert.assertEquals(driver.findElement(By.xpath("//div[@id ='section-three']//span[2]")).getText(), "0/1000", "Items Name Maxlength is not correct");
		Assert.assertEquals(Purchasedcost.getAttribute("maxlength"), "10", "Items Rate Maxlength is not correct");
		Assert.assertEquals(SaleCost.getAttribute("maxlength"), "10", "Items qtyonHand Maxlength is not correct");
		
		SaveItem.click();
		String GetItemNameValidationmsg = ItemErrorMsg.getText();
		Assert.assertEquals(GetItemNameValidationmsg, "The Product / Service name can't be blank. Please specify a name.", "Other Charge Items Name Validation is not working properly");
		
		
		
		
		I_TRXItemName.sendKeys(ItemsName);
		Thread.sleep(2000);
		Select ExpenseAcc = new Select(S_ExpenseAccount);
		ExpenseAcc.selectByVisibleText("Expense account");
		SaveItem.click();
		String GetItemNameValidationmsg1 = ItemErrorMsg.getText();
		Assert.assertEquals(GetItemNameValidationmsg1, "You must specify an expense account for association.", "Services Expense Name Validation is not working properly");
		
		
		ExpenseAcc.selectByVisibleText("Accumulated Depreciation");
		Thread.sleep(2000);
		Select IncomeAcc = new Select(S_IncomeAccount);
		IncomeAcc.selectByVisibleText("Income account");
		SaveItem.click();
		String GetItemNameValidationmsg2 = ItemErrorMsg.getText();
		Assert.assertEquals(GetItemNameValidationmsg2, "You must specify an income account for association.", "Services Expense Name Validation is not working properly");
		
		
		
		IncomeAcc.selectByVisibleText("Depreciation Expense");
		Thread.sleep(1000);
		Purchasedcost.sendKeys("111,111,111.11");
		Thread.sleep(1000);
		SaleCost.sendKeys("999,999,999.990");
		I_PurchasedDescription.sendKeys(TRXMaxDescriptionOfOtherCharge);
		Saledesc.sendKeys(TRXSalesMaxDescriptionOfOtherCharge);
		Thread.sleep(1000);
		SaveItem.click();
		Thread.sleep(3000);
		String GetItemValidationmsg = ItemErrorMsg.getText();
		if (GetItemValidationmsg.equals(TRXItemAlreadyExist)) {
			System.out.println(ItemsName + " This other charge Item is already exist in this Company");
			Thread.sleep(5000);
			Thread.sleep(1000);
		} else if (GetItemValidationmsg.equals(TRXItemsSuccessfullyAdded)) {
			System.out.println(ItemsName + " This other charge Item is Successfully Added");
			Thread.sleep(5000);
			Thread.sleep(1000);
		} else {
			System.out.println(ItemsName + " Not able to add the other charge Item due to the " + GetItemValidationmsg);
			Thread.sleep(5000);
			Thread.sleep(1000);
		}
	}

	// --------------------------------------------------------------------------------------------
	//--------Maximum length Verification of the Vendor Customer Items Creation TXO TRX----------
	//-----------------------------------------------------------------------------------------
	
	public void TRX_CheckTheMaxLengthOfVendorCreationPopup() throws InterruptedException {
		Thread.sleep(1000);
		VendorSearchIcon.click();
		Thread.sleep(4000);
		AddNewVendorBTN.click();
		Thread.sleep(1000);
		Assert.assertEquals(VendorName.getAttribute("maxlength"),"40", "Vendor Name Maxlength is not correct");
		Assert.assertEquals(VendorCompanyName.getAttribute("maxlength"),"40","Vendor Company Name Maxlength is not correct");
		Assert.assertEquals(BillingAddress1.getAttribute("maxlength"),"40","Billing Address 1 Maxlength is not correct");
		Assert.assertEquals(BillingAddress2.getAttribute("maxlength"),"40","Billing Address 2 Maxlength is not correct");
		Assert.assertEquals(BillingAddress3.getAttribute("maxlength"),"40","Billing Address 3 Maxlength is not correct");
		Assert.assertEquals(BillingAddress4.getAttribute("maxlength"),"40","Billing Address 3 Maxlength is not correct");
		Assert.assertEquals(VendorCity.getAttribute("maxlength"),"30","Vendor City Maxlength  is not correct");	
		Assert.assertEquals(VendorZipcode.getAttribute("maxlength"),"12","Vendor Zipcode Maxlength is not correct");
		Assert.assertEquals(ContactFirstName.getAttribute("maxlength"),"20","Contact First Maxlength length is not correct");	
		Assert.assertEquals(ContactLastName.getAttribute("maxlength"),"20","Contact Last Name Maxlength is not correct");	
		Assert.assertEquals(VendorPhone.getAttribute("maxlength"),"25","Vendor Phone Maxlength is not correct");	
		Assert.assertEquals(VendorFax.getAttribute("maxlength"),"15","Vendor Fax Maxlength is not correct");
		VendorCloseBTN.click();
	}
	
	public void TXO_CheckTheMaxLengthOfVendorCreationPopup() throws InterruptedException {
		Thread.sleep(1000);
		VendorSearchIcon.click();
		Thread.sleep(4000);
		AddNewVendorBTN.click();
		Thread.sleep(1000);
		Assert.assertEquals(VendorName.getAttribute("maxlength"),"40", "Vendor Name Maxlength is not correct");
		Assert.assertEquals(VendorCompanyName.getAttribute("maxlength"),"40","Vendor Company Name Maxlength is not correct");
		Assert.assertEquals(BillingAddress1.getAttribute("maxlength"),"40","Billing Address 1 Maxlength is not correct");
		Assert.assertEquals(BillingAddress2.getAttribute("maxlength"),"40","Billing Address 2 Maxlength is not correct");
		Assert.assertEquals(BillingAddress3.getAttribute("maxlength"),"40","Billing Address 3 Maxlength is not correct");
		Assert.assertEquals(BillingAddress4.getAttribute("maxlength"),"40","Billing Address 3 Maxlength is not correct");
		Assert.assertEquals(VendorCity.getAttribute("maxlength"),"30","Vendor City Maxlength  is not correct");	
		Assert.assertEquals(VendorZipcode.getAttribute("maxlength"),"12","Vendor Zipcode Maxlength is not correct");
		Assert.assertEquals(ContactFirstName.getAttribute("maxlength"),"20","Contact First Maxlength length is not correct");	
		Assert.assertEquals(ContactLastName.getAttribute("maxlength"),"20","Contact Last Name Maxlength is not correct");	
		Assert.assertEquals(VendorPhone.getAttribute("maxlength"),"25","Vendor Phone Maxlength is not correct");	
		Assert.assertEquals(VendorFax.getAttribute("maxlength"),"15","Vendor Fax Maxlength is not correct");
		VendorCloseBTN.click();
	}
	
	public void TRX_CheckTheMaxLengthOfCustomerCreationPopup() throws InterruptedException {
		Thread.sleep(1000);
		Select state = new Select(MyCompany);
		state.selectByVisibleText("Customer");
		Thread.sleep(1000);
		CustomerSearchIcon.click();
		Thread.sleep(4000);
		AddNewCustomerBTN.click();
		Thread.sleep(1000);
		Assert.assertEquals(CustomerName.getAttribute("maxlength"),"40","Customer name Maxlength is not correct");
		Assert.assertEquals(CustomerComapnyName.getAttribute("maxlength"),"40","Customer Company Name Maxlength is not correct");
		Assert.assertEquals(ShippingAddress1.getAttribute("maxlength"),"40","Shipping Address 1 Maxlength is not correct");
		Assert.assertEquals(ShippingAddress2.getAttribute("maxlength"),"40","Shipping Address 1 Maxlength is not correct");
		Assert.assertEquals(ShippingAddress3.getAttribute("maxlength"),"40","Shipping Address 1 Maxlength is not correct");
		Assert.assertEquals(ShippingAddress4.getAttribute("maxlength"),"40","Shipping Address 1 Maxlength is not correct");
		Assert.assertEquals(CustomerCity.getAttribute("maxlength"),"30","Customer City Maxlength is not correct");
		Assert.assertEquals(CustomerZipcode.getAttribute("maxlength"),"12","Customer Zipcode Maxlength is not correct");
		Assert.assertEquals(CustomerFname.getAttribute("maxlength"),"20","Customer First name Maxlength is not correct");
		Assert.assertEquals(Customerlname.getAttribute("maxlength"),"20","Customer Last name Maxlength not correct");
		Assert.assertEquals(CustomerPhone.getAttribute("maxlength"),"25","Customer Phone name Maxlength is not correct");
		Assert.assertEquals(CustomerFax.getAttribute("maxlength"),"15","Customer Fax name Maxlength is not correct");	
		CustomerCloseBTN.click();		
	}

	public void TXO_CheckTheMaxLengthOfCustomerCreationPopup() throws InterruptedException {
		Thread.sleep(1000);
		CustomerSearchIcon.click();
		Thread.sleep(4000);
		AddNewCustomerBTN.click();
		Thread.sleep(1000);
		Assert.assertEquals(CustomerName.getAttribute("maxlength"),"40","Customer name Maxlength is not correct");
		Assert.assertEquals(CustomerComapnyName.getAttribute("maxlength"),"40","Customer Company Name Maxlength is not correct");
		Assert.assertEquals(ShippingAddress1.getAttribute("maxlength"),"40","Shipping Address 1 Maxlength is not correct");
		Assert.assertEquals(ShippingAddress2.getAttribute("maxlength"),"40","Shipping Address 1 Maxlength is not correct");
		Assert.assertEquals(ShippingAddress3.getAttribute("maxlength"),"40","Shipping Address 1 Maxlength is not correct");
		Assert.assertEquals(ShippingAddress4.getAttribute("maxlength"),"40","Shipping Address 1 Maxlength is not correct");
		Assert.assertEquals(CustomerCity.getAttribute("maxlength"),"30","Customer City Maxlength is not correct");
		Assert.assertEquals(CustomerZipcode.getAttribute("maxlength"),"12","Customer Zipcode Maxlength is not correct");
		Assert.assertEquals(CustomerFname.getAttribute("maxlength"),"20","Customer First name Maxlength is not correct");
		Assert.assertEquals(Customerlname.getAttribute("maxlength"),"20","Customer Last name Maxlength not correct");
		Assert.assertEquals(CustomerPhone.getAttribute("maxlength"),"25","Customer Phone name Maxlength is not correct");
		Assert.assertEquals(CustomerFax.getAttribute("maxlength"),"15","Customer Fax name Maxlength is not correct");
		CustomerCloseBTN.click();
	}

	
	// --------------------------------------------------------------------------------------------
	//---------------------Duplicate Creation Validation Verification TXO TRX -----------------------------
	//-----------------------------------------------------------------------------------------
	
	public void TRX_DuplicateVendorCreationVerificationAndmandatoryFieldVerification() throws InterruptedException {
		Thread.sleep(1000);
		VendorSearchIcon.click();
		Thread.sleep(3000);
		AddNewVendorBTN.click();
		Thread.sleep(1000);
		date = new Date();
		vendor = "Vendor -> " + formatter1.format(date);
		
		
		SaveVendorBTN.click();
		String GetVendorNameValidationmsg = VendorErrorMsg.getText();
		Assert.assertEquals(GetVendorNameValidationmsg, "Please specify Vendor name.", "Vendor Name Validation is not working");
		VendorName.sendKeys(vendor);
		
		SaveVendorBTN.click();
		String GetBillingValidationmsg = VendorErrorMsg.getText();
		Assert.assertEquals(GetBillingValidationmsg, "Please specify Billing address.", "Billing Information Validation is not working");
		BillingAddress1.sendKeys("Billing Address Test 01 Maximum Info TRX");
		
		SaveVendorBTN.click();
		String GetCityValidationmsg = VendorErrorMsg.getText();
		Assert.assertEquals(GetCityValidationmsg, "Please specify City.", "City Validation is not working");
		VendorCity.sendKeys("Taraus");
		
		
		SaveVendorBTN.click();
		String GetStateValidationmsg = VendorErrorMsg.getText();
		Assert.assertEquals(GetStateValidationmsg, "You must specify State/Province." ,"State Validation is not working" );
		Thread.sleep(2000);
		Select state = new Select(VendorState);
		state.selectByVisibleText("Florida");
		Thread.sleep(1000);
		
		SaveVendorBTN.click();
		String GetZipCodeValidationmsg = VendorErrorMsg.getText();
		Assert.assertEquals(GetZipCodeValidationmsg, "Please specify Zip/Postal Code.");
		VendorZipcode.sendKeys("12345");
	
		Thread.sleep(1000);
		SaveVendorBTN.click();
		Thread.sleep(4000);
		String GetVendorValidationmsg = VendorErrorMsg.getText();
		Assert.assertEquals(GetVendorValidationmsg, "Vendor added successfully"," Vendor is not Created Successfully check the reason see snapshot");
		Thread.sleep(4000);
	  //Again Creation of Same Name Vendor
		Thread.sleep(1000);
		VendorSearchIcon.click();
		Thread.sleep(3000);
		AddNewVendorBTN.click();
		Thread.sleep(1000);
		VendorName.sendKeys(vendor);
		BillingAddress1.sendKeys("Billing Address Test 01 Maximum Info TRX");
		VendorCity.sendKeys("Taraus");
		VendorZipcode.sendKeys("12345");
		Select country1 = new Select(VendorCountry);
		Thread.sleep(2000);
		country1.selectByVisibleText("United States");
		Thread.sleep(2000);
		Select state1 = new Select(VendorState);
		state1.selectByVisibleText("Florida");
		Thread.sleep(1000);
		SaveVendorBTN.click();
		Thread.sleep(4000);
		String GetVendorValidationmsg1 = VendorErrorMsg.getText();
		Assert.assertEquals(GetVendorValidationmsg1,"Vendor already exist", "Duplicate Vendor Creation msg is not appearing correct");
		VendorCloseBTN.click();	
}
	
	public void TRX_DuplicateCustomerCreationVerificationAndMandatoryFieldVerification() throws InterruptedException {
			
			Thread.sleep(1000);
			Select state = new Select(MyCompany);
			state.selectByVisibleText("Customer");
					Thread.sleep(1000);
					CustomerSearchIcon.click();
					Thread.sleep(1000);
					AddNewCustomerBTN.click();
					Thread.sleep(1000);
					date = new Date();
					customer = "Customer -> " + formatter1.format(date);
					
					
					SaveCustomerBTN.click();
					String GetCustomerNameValidationmsg = CustomerErrorMsg.getText(); 
					Assert.assertEquals(GetCustomerNameValidationmsg, "Please specify customer name.","Customer name Validation is not working");					
					CustomerName.sendKeys(customer);
					
					SaveCustomerBTN.click();
					String GetShippingAddressValidationmsg = CustomerErrorMsg.getText(); 
					Assert.assertEquals(GetShippingAddressValidationmsg, "Please specify Billing address.","Shipping Address Validation is not working");	
					ShippingAddress1.sendKeys("Shipping Address Test 01 Test Cycle1 TXO");
					
					SaveCustomerBTN.click();
					String GetCityValidationmsg = CustomerErrorMsg.getText(); 
					Assert.assertEquals(GetCityValidationmsg, "Please specify City.","City Validation is not working");	
					CustomerCity.sendKeys("Taurus");
					
					SaveCustomerBTN.click();
					String GetStateValidationmsg = CustomerErrorMsg.getText(); 
					Assert.assertEquals(GetStateValidationmsg, "You must specify State/Province.","State Validation is not working");	
					Select state1 = new Select(CustomerState);
					state1.selectByVisibleText("California");
					
					SaveCustomerBTN.click();
					String GetZipCodeValidationmsg = CustomerErrorMsg.getText(); 
					Assert.assertEquals(GetZipCodeValidationmsg, "Please specify Zip/Postal Code.","ZipCode Validation is not working");	
					CustomerZipcode.sendKeys("12345");
					
					Thread.sleep(1000);
					SaveCustomerBTN.click();
					Thread.sleep(4000);
					String GetCustomerValidationmsg = CustomerErrorMsg.getText(); 
					Assert.assertEquals(GetCustomerValidationmsg, "Customer added successfully","Customer Added Successfully");
					Thread.sleep(4000);
					//Duplicate check
					CustomerSearchIcon.click();
					Thread.sleep(1000);
					AddNewCustomerBTN.click();
					Thread.sleep(1000);
					CustomerName.sendKeys(customer);
					ShippingAddress1.sendKeys("Shipping Address Test 01 Test Cycle1 TXO");
					CustomerCity.sendKeys("Taurus");
					CustomerZipcode.sendKeys("12345");
					Select country2 = new Select(CustomerCountry);
					country2.selectByVisibleText("United States");
					Thread.sleep(2000);
					Select state2 = new Select(CustomerState);
					state2.selectByVisibleText("California");
					Thread.sleep(1000);
					SaveCustomerBTN.click();
					Thread.sleep(4000);
					String GetCustomerValidationmsg1 = CustomerErrorMsg.getText();
					Assert.assertEquals(GetCustomerValidationmsg1, "Customer already exist","Customer alread exist msg is not appearing");
					CustomerCloseBTN.click();
		
		}
	 

	public void TXO_DuplicateCustomerCreationVerificationandMandatoryFieldValidation() throws InterruptedException {

			Thread.sleep(1000);
			Thread.sleep(1000);
			CustomerSearchIcon.click();
			Thread.sleep(1000);
			AddNewCustomerBTN.click();
			Thread.sleep(1000);
			date = new Date();
			customer = "Customer -> " + formatter1.format(date);
			
			SaveCustomerBTN.click();
			String GetCustomerNameValidationmsg = CustomerErrorMsg.getText();
			Assert.assertEquals(GetCustomerNameValidationmsg, "Please specify customer name.", "Customer Name Validation is not working");
			
			CustomerName.sendKeys(customer);
			Thread.sleep(1000);
			SaveCustomerBTN.click();
			Thread.sleep(3000);
			String GetCustomerValidationmsg = CustomerErrorMsg.getText();
			Assert.assertEquals(GetCustomerValidationmsg, CustomerSuccessfullyAdded,
					"Customer doesn't added successfully see snapshot");
			Thread.sleep(4000);
			CustomerSearchIcon.click();
			Thread.sleep(3000);
			AddNewCustomerBTN.click();
			Thread.sleep(1000);
			CustomerName.sendKeys(customer);
			Thread.sleep(1000);
			SaveCustomerBTN.click();
			Thread.sleep(3000);
			String GetCustomerValidationmsg1 = CustomerErrorMsg.getText();
			Assert.assertEquals(GetCustomerValidationmsg1, CustomerAlreadyExist,
					"Customer already exist msg is not appearing");
			CustomerCloseBTN.click();
		}
	
	public void TXO_DuplicateVendorCreationVerificationAndMandatoryFieldVerification() throws InterruptedException {
			Thread.sleep(1000);
			VendorSearchIcon.click();
			Thread.sleep(3000);
			AddNewVendorBTN.click();
			Thread.sleep(1000);
			date = new Date();
			vendor = "Vendor -> " + formatter1.format(date);
			SaveVendorBTN.click();
			String GetVendornameValidationmsg = VendorErrorMsg.getText();
			Assert.assertEquals(GetVendornameValidationmsg, "Please specify Vendor name.", "Vendor Name Validation is not working");
			VendorName.sendKeys(vendor);
			SaveVendorBTN.click();
			Thread.sleep(3000);
			String GetVendorValidationmsg = VendorErrorMsg.getText();
			Assert.assertEquals(GetVendorValidationmsg, VendorSuccessfullyAdded,
					"Vendor Sucessfully added msg is notappearing see snapshot ");
			
			Thread.sleep(4000);
			// Duplicate Vendor Creation
			VendorSearchIcon.click();
			Thread.sleep(2000);
			AddNewVendorBTN.click();
			Thread.sleep(1000);
			VendorName.sendKeys(vendor);
			SaveVendorBTN.click();
			Thread.sleep(3000);
			String GetVendorValidationmsg1 = VendorErrorMsg.getText();
			Assert.assertEquals(GetVendorValidationmsg1, VendorAlreadyExist,
					"Vendor Sucessfully added msg is notappearing ");
			VendorCloseBTN.click();

		}



}



