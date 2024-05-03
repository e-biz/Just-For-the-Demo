package OriginatorMultiReqRouting;

import java.util.List;
import java.util.Map;
import org.testng.Assert;
import com.DriverFactory.DriverFactory;
import com.StoringLocalValues.ScenarioContext;
import com.pages.*;

//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
//import java.time.Duration;

public class OriginatorMultiReqRouting {

	private LoginPage Login = new LoginPage(DriverFactory.getDriver());
	private MenuNavBar MM = new MenuNavBar(DriverFactory.getDriver());
	private RequisitionProcessFlow RPF = new RequisitionProcessFlow(DriverFactory.getDriver());
//	private WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(20));

	public String AppName;
	public String CompanyName;
	public String AEmail;
	public String Env;
	public String Password;

	public void GetAllCompanyCredentials() {
		AppName = ScenarioContext.get("AppName");
		AEmail = ScenarioContext.get("AEmail");
		CompanyName = ScenarioContext.get("CompanyName");
		Password = ScenarioContext.get("Password");
		Env = ScenarioContext.get("Environment");
	}

	@Given("Open the eRequisition Application")
	public void Open_the_eRequisition_Application() {
		GetAllCompanyCredentials();
		if (Env.equals("QA")) {
			DriverFactory.getDriver().get("https://qaerequisition.e-bizsoft.net/Login.aspx");
		} else if (Env.equals("STAGING")) {
			DriverFactory.getDriver().get("https://ereqstg.e-bizsoft.net/Login.aspx");
		} else {
			Assert.fail("PLease set the Correct Environment : " + Env);
		}
	}

	@Then("Enter the login Credentials of Originator")
	public void Enter_The_Login_CredentialsOfOriginator() throws InterruptedException {
		Login.EnterUsernameandpassword("******@gmail.com", Password);
		Login.LoginBTN();
		Thread.sleep(2000);
		Login.SelectProduct(AppName);
		Login.SelectCompany(CompanyName);
		Login.AfterLoginDoSomewait(AppName);
	}

	@Then("Open the Requisition Page")
	public void OpenTheRequisitionpage() throws InterruptedException {
		MM.NewReqMenu();
	}

	@Then("Creating a l0 Requisiton O9 will be Submitted to the Next Approver and last one will create a PO")
	public void Creatinga10RequistionusingOriginatorAccount(DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> listdata = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> mapdata : listdata) {
			// Applying wait For the Fully load of the requisition page
//			wait.until(ExpectedConditions
//					.presenceOfElementLocated((By) DriverFactory.getDriver().findElement(By.id("txtMesgToVen"))));
			String ReqNo = mapdata.get("RequisitionNo");
			GetAllCompanyCredentials();
			String Apps = "";
			if (AppName.equals("TXO")) {
				Apps = AppName;
			} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
				Apps = "TRX"; // This TRX is added because the TRX and Standalone method are same
			}
			if (ReqNo.equals("1")) {

			} else {
				MM.NewReqMenu();
			}

			// VendorSelection TRXVendor1 TXOVendor1
			RPF.openVendorLookup();
			String VendorSelection = ScenarioContext.get(Apps + "Vendor" + ReqNo);
			RPF.Select_vendor(VendorSelection);
			// CustomerSelection TRXCustomer1 TXOCustomer1
			RPF.OpenCustomerLookup();
			String CustomerSelection = ScenarioContext.get(Apps + "Customer" + ReqNo);
			RPF.Select_Customer(CustomerSelection);
			// ItemSelection TXOItemsName1 TRXItemsName1
			RPF.OpenItemLookup();

			if (ReqNo.equals("1")) {
				RPF.MemoAndNotesClear();
				RPF.DescriptionCommentAndNotes("Req No 1 Originator -> Approver 01 Create PO",
						"Vendor Message Req No 1");

				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 1));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 5));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 9));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 13));

				RPF.AddItemToReq();
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(2, "Requisition Creation " + ReqNo + " Services Item", "4",
						"15.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(3, "Requisition Creation " + ReqNo + " Inventory Item", "3",
						"10.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(4, "Requisition Creation " + ReqNo + " Non-Inventory Item",
						"2", "7.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(5,
						"Requisition Creation " + ReqNo + " Other Charge Item If TRX and If TXO its Services", "1",
						"2.25");

				RPF.SubmitReq(ReqNo, "Approver 01");
			} else if (ReqNo.equals("2")) {
				RPF.MemoAndNotesClear();
				RPF.DescriptionCommentAndNotes("Req No 2 Originator -> Approver 01 -> Approver 02 Create PO",
						"Vendor Message Req No 2");
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 1));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 5));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 9));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 13));

				RPF.AddItemToReq();
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(2, "Requisition Creation " + ReqNo + " Services Item", "4",
						"40.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(3, "Requisition Creation " + ReqNo + " Inventory Item", "3",
						"10.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(4, "Requisition Creation " + ReqNo + " Non-Inventory Item",
						"2", "7.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(5, "Requisition Creation " + ReqNo + " Other Charge Item",
						"1", "2.25");

				RPF.SubmitReq(ReqNo, "Approver 01");

			} else if (ReqNo.equals("3")) {
				RPF.MemoAndNotesClear();
				RPF.DescriptionCommentAndNotes("Req No 3 Originator -> Approver 01 -> Approver 02 Reject Req",
						"Vendor Message Req No 3");
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 1));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 5));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 9));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 13));

				RPF.AddItemToReq();
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(2, "Requisition Creation " + ReqNo + " Services Item", "4",
						"40.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(3, "Requisition Creation " + ReqNo + " Inventory Item", "3",
						"10.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(4, "Requisition Creation " + ReqNo + " Non-Inventory Item",
						"2", "7.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(5, "Requisition Creation " + ReqNo + " Other Charge Item",
						"1", "2.25");

				RPF.SubmitReq(ReqNo, "Approver 01");
			} else if (ReqNo.equals("4")) {
				RPF.MemoAndNotesClear();
				RPF.DescriptionCommentAndNotes(
						"Req No 4 Originator -> Approver 01 -> Approver 02 -> Approver 03 Create PO",
						"Vendor Message Req No 4");
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 2));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 6));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 10));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 14));

				RPF.AddItemToReq();
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(2, "Requisition Creation " + ReqNo + " Services Item", "4",
						"50.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(3, "Requisition Creation " + ReqNo + " Inventory Item", "3",
						"30.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(4, "Requisition Creation " + ReqNo + " Non-Inventory Item",
						"2", "7.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(5, "Requisition Creation " + ReqNo + " Other Charge Item",
						"1", "2.25");

				RPF.SubmitReq(ReqNo, "Approver 01");
			} else if (ReqNo.equals("5")) {
				RPF.MemoAndNotesClear();
				RPF.DescriptionCommentAndNotes(
						"Req No 5 Originator -> Approver 01 -> Approver 02 -> Approver 03 Cancelled Req",
						"Vendor Message Req No 5");
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 2));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 6));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 10));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 14));

				RPF.AddItemToReq();
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(2, "Requisition Creation " + ReqNo + " Services Item", "4",
						"50.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(3, "Requisition Creation " + ReqNo + " Inventory Item", "3",
						"30.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(4, "Requisition Creation " + ReqNo + " Non-Inventory Item",
						"2", "7.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(5, "Requisition Creation " + ReqNo + " Other Charge Item",
						"1", "2.25");

				RPF.SubmitReq(ReqNo, "Approver 01");
			} else if (ReqNo.equals("6")) {
				RPF.MemoAndNotesClear();
				RPF.DescriptionCommentAndNotes(
						"Req No 6 Originator -> Approver 01 -> Approver 02 -> Approver 03 -> Approver 04 Rejected Req",
						"Vendor Message Req No 6");
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 3));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 7));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 11));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 15));

				RPF.AddItemToReq();
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(2, "Requisition Creation " + ReqNo + " Services Item", "4",
						"70.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(3, "Requisition Creation " + ReqNo + " Inventory Item", "3",
						"40.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(4, "Requisition Creation " + ReqNo + " Non-Inventory Item",
						"2", "7.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(5, "Requisition Creation " + ReqNo + " Other Charge Item",
						"1", "2.25");

				RPF.SubmitReq(ReqNo, "Approver 01");
			} else if (ReqNo.equals("7")) {
				RPF.MemoAndNotesClear();
				RPF.DescriptionCommentAndNotes(
						"Req No 7 Originator -> Approver 01 -> Approver 02 -> Approver 03 -> Approver 04 Create PO",
						"Vendor Message Req No 7");
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 3));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 7));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 11));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 15));

				RPF.AddItemToReq();
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(2, "Requisition Creation " + ReqNo + " Services Item", "4",
						"70.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(3, "Requisition Creation " + ReqNo + " Inventory Item", "3",
						"40.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(4, "Requisition Creation " + ReqNo + " Non-Inventory Item",
						"2", "7.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(5, "Requisition Creation " + ReqNo + " Other Charge Item",
						"1", "2.25");

				RPF.SubmitReq(ReqNo, "Approver 01");
			} else if (ReqNo.equals("8")) {
				RPF.MemoAndNotesClear();
				RPF.DescriptionCommentAndNotes(
						"Req No 8 Originator -> APR 01 -> APR 02 -> APR 03 -> APR 04 -> APR 05 Create PO",
						"Vendor Message Req No 8");
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 4));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 8));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 12));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 16));

				RPF.AddItemToReq();
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(2, "Requisition Creation " + ReqNo + " Services Item", "4",
						"85.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(3, "Requisition Creation " + ReqNo + " Inventory Item", "3",
						"50.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(4, "Requisition Creation " + ReqNo + " Non-Inventory Item",
						"2", "7.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(5, "Requisition Creation " + ReqNo + " Other Charge Item",
						"1", "2.25");

				RPF.SubmitReq(ReqNo, "Approver 01");
			} else if (ReqNo.equals("9")) {
				RPF.MemoAndNotesClear();
				RPF.DescriptionCommentAndNotes(
						"Req No 9 Originator -> APR 01 -> APR 02 -> APR 03 -> APR 04 -> APR 05 Reject Req",
						"Vendor Message Req No 9");
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 4));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 8));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 12));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 16));

				RPF.AddItemToReq();
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(2, "Requisition Creation " + ReqNo + " Services Item", "4",
						"85.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(3, "Requisition Creation " + ReqNo + " Inventory Item", "3",
						"50.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(4, "Requisition Creation " + ReqNo + " Non-Inventory Item",
						"2", "7.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(5, "Requisition Creation " + ReqNo + " Other Charge Item",
						"1", "2.25");

				RPF.SubmitReq(ReqNo, "Approver 01");
			} else if (ReqNo.equals("10")) {
				RPF.MemoAndNotesClear();
				RPF.DescriptionCommentAndNotes("Req No 10 Originator Create PO", "Vendor Message Req No 10");
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 4));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 8));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 12));
				RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 16));

				RPF.AddItemToReq();
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(2, "Requisition Creation " + ReqNo + " Services Item", "4",
						"10.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(3, "Requisition Creation " + ReqNo + " Inventory Item", "3",
						"5.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(4, "Requisition Creation " + ReqNo + " Non-Inventory Item",
						"2", "7.25");
				RPF.ChangeTheLineItemsDescriptionQtyAndRate(5, "Requisition Creation " + ReqNo + " Other Charge Item",
						"1", "2.25");

				RPF.CreatePO("1", "Originator 01", "With");
			}
		}
	}

	@Then("Logout from the Application")
	public void logout() throws InterruptedException {
		MM.Logout();
	}
}
