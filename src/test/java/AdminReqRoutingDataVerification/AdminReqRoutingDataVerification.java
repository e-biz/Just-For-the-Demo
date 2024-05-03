package AdminReqRoutingDataVerification;

import com.DriverFactory.DriverFactory;
import com.StoringLocalValues.ScenarioContext;
import com.pages.*;

import io.cucumber.java.en.*;

public class AdminReqRoutingDataVerification {

	private LoginPage Login = new LoginPage(DriverFactory.getDriver());
	private MenuNavBar MM = new MenuNavBar(DriverFactory.getDriver());
	private RequisitionProcessFlow RPF = new RequisitionProcessFlow(DriverFactory.getDriver());
	private HistoryPage HP = new HistoryPage(DriverFactory.getDriver());
	
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
	
	@When("Enter the login Credentials of Admin")
	public void LoginwithAdmin() throws InterruptedException {
		GetAllCompanyCredentials();
		Login.EnterUsernameandpassword(AEmail, "*******");
		Login.LoginBTN();
		Thread.sleep(2000);
		Login.SelectProduct(AppName);
		Login.SelectCompany(CompanyName);
		Login.AfterLoginDoSomewait(AppName);
	}
	
	@Then("Open the History Page")
	public void openHistory_page() throws InterruptedException {
		MM.HistoryMenu();
	}
	
	@Then("Search the ReqNo O1")
	public void SearchtheReqNoO1() throws InterruptedException {
		String REQNO1_REQNO = ScenarioContext.get("ReqNumber1");
		HP.SearchTheSpecificPOorReq(REQNO1_REQNO);
	}
	
	@Then("Verification of the Data of Req O1 from all the column")
	public void VerificationoftheDataofReqO1fromallthecolumn() {
		GetAllCompanyCredentials();
		String Apps = "";
		String Status = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
			 Status = "PO Created";
		} else if (AppName.equals("TRX")) {
			Apps = "TRX";
			Status = "Pending Sync";
		} else if ( AppName.equals("Standalone")) {
			Apps = "TRX";
			Status = "PO Created";
		}
		
		String REQNO1_REQNO = ScenarioContext.get("ReqNumber1");
		String REQNO1Vendor01 = ScenarioContext.get(Apps + "Vendor" + 1);
		String PONO2_TotalAmount = ScenarioContext.get( "TotalAmountOFPO2");
		String PONO2 = ScenarioContext.get("PONO2");
		System.out.println(PONO2);
		HP.VerificationOfTheDataoftheReqonHistoryPage(PONO2, REQNO1_REQNO, "Req No 1 Originator -> Approver 01 Create PO", REQNO1Vendor01, "Originator 01", "Approver 01", PONO2_TotalAmount,Status);
	}
	
	@Then("Open The Req O1 thorugh view Requisition history")
	public void OpenTheReqO1thorughviewRequisitionhistory() throws InterruptedException {
		HP.OpenViewReqHistory();
	}
	
	@Then("Verify the req O1 Data")
	public void VerifythereqO1Data() {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX")) {
			Apps = "TRX";
		} else if ( AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		
		String REQNO1_REQNO = ScenarioContext.get("ReqNumber1");
		String REQNO1Vendor01 = ScenarioContext.get(Apps + "Vendor" + 1);
		String REQNO1Customer01 =ScenarioContext.get(Apps + "Customer" + 1);
		
		HP.VerificationOfTheHeaderReqNO(REQNO1_REQNO);
		RPF.VerifyTheDataOfTheReqOfVendorandCustomer(REQNO1Vendor01, REQNO1Customer01);
		RPF.GetTheTotalAmountandVerified("1");
		
		String item1 = ScenarioContext.get(Apps + "ItemsName" + 1);
		String item2 = ScenarioContext.get(Apps + "ItemsName" + 5);
		String item3 = ScenarioContext.get(Apps + "ItemsName" + 9);
		String item4 = ScenarioContext.get(Apps + "ItemsName" + 13);
		
		RPF.LineItemDataVerification("2", item1, "4.00", "15.25");
		RPF.LineItemDataVerification("3", item2, "3.00", "10.25");
		RPF.LineItemDataVerification("4", item3, "2.00", "7.25");
		RPF.LineItemDataVerification("5", item4, "1.00", "2.25");
	}
	
	@Then("Go back to the History page")
	public void go_back_to_the_history_page() throws InterruptedException {
	    MM.HistoryMenu();
	}
	@Then("Search the ReqNo O2")
	public void search_the_req_no_o2() throws InterruptedException {
		String REQNO2_REQNO = ScenarioContext.get("ReqNumber2");
		HP.SearchTheSpecificPOorReq(REQNO2_REQNO);
	}
	@Then("Verification of the Data of Req O2 from all the column")
	public void verification_of_the_data_of_req_o2_from_all_the_column() {
		GetAllCompanyCredentials();
		String Apps = "";
		String Status = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
			 Status = "PO Created";
		} else if (AppName.equals("TRX")) {
			Apps = "TRX";
			Status = "Pending Sync";
		} else if ( AppName.equals("Standalone")) {
			Apps = "TRX";
			Status = "PO Created";
		}
		
		String REQNO1_REQNO = ScenarioContext.get("ReqNumber2");
		String REQNO1Vendor01 = ScenarioContext.get(Apps + "Vendor" + 2);
		String PONO2_TotalAmount = ScenarioContext.get( "TotalAmountOFPO3");
		String PONO3 = ScenarioContext.get("PONO3");
		System.out.println(PONO3);
		HP.VerificationOfTheDataoftheReqonHistoryPage(PONO3, REQNO1_REQNO, "Req No 2 Originator -> Approver 01 -> Approver 02 Create PO", REQNO1Vendor01, "Originator 01", "Approver 02", PONO2_TotalAmount,Status);
	}
	@Then("Open The Req O2 thorugh view Requisition history")
	public void open_the_req_o2_thorugh_view_requisition_history() throws InterruptedException {
	    HP.OpenViewReqHistory();
	}
	@Then("Verify the req O2 Data")
	public void verify_the_req_o2_data() throws InterruptedException {
        GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX")) {
			Apps = "TRX";
		} else if ( AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		
		String REQNO1_REQNO = ScenarioContext.get("ReqNumber2");
		String REQNO1Vendor01 = ScenarioContext.get(Apps + "Vendor" + 2);
		String REQNO1Customer01 =ScenarioContext.get(Apps + "Customer" + 2);
		
		HP.VerificationOfTheHeaderReqNO(REQNO1_REQNO);
		RPF.VerifyTheDataOfTheReqOfVendorandCustomer(REQNO1Vendor01, REQNO1Customer01);
		RPF.GetTheTotalAmountandVerified("2");
		
		String item1 = ScenarioContext.get(Apps + "ItemsName" + 1);
		String item2 = ScenarioContext.get(Apps + "ItemsName" + 5);
		String item3 = ScenarioContext.get(Apps + "ItemsName" + 9);
		String item4 = ScenarioContext.get(Apps + "ItemsName" + 13);
		
		RPF.LineItemDataVerification("2", item1, "4.00", "40.25");
		RPF.LineItemDataVerification("3", item2, "3.00", "10.25");
		RPF.LineItemDataVerification("4", item3, "2.00", "7.25");
		RPF.LineItemDataVerification("5", item4, "1.00", "2.25");
	}
	@Then("Search the ReqNo O3")
	public void search_the_req_no_o3() throws InterruptedException {
		String REQNO3_REQNO = ScenarioContext.get("ReqNumber3");
		HP.SearchTheSpecificPOorReq(REQNO3_REQNO);
	}
	@Then("Verification of the Data of Req O3 from all the column")
	public void verification_of_the_data_of_req_o3_from_all_the_column() {
		GetAllCompanyCredentials();
		String Apps = "";
		String Status = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
			 Status = "Rejected";
		} else if (AppName.equals("TRX")) {
			Apps = "TRX";
			Status = "Rejected";
		} else if ( AppName.equals("Standalone")) {
			Apps = "TRX";
			Status = "Rejected";
		}
		
		String REQNO3_REQNO = ScenarioContext.get("ReqNumber3");
		String REQNO3Vendor03 = ScenarioContext.get(Apps + "Vendor" + 3);
		String RejectReqNo3_TotalAmount = ScenarioContext.get("TotalAmountOfReq3");
		HP.VerificationOfTheDataoftheReqonHistoryPage("", REQNO3_REQNO, "Req No 3 Originator -> Approver 01 -> Approver 02 Reject Req", REQNO3Vendor03, "Originator 01", "Originator 01", RejectReqNo3_TotalAmount,Status);
	}
	@Then("Open The Req O3 thorugh view Requisition history")
	public void open_the_req_o3_thorugh_view_requisition_history() throws InterruptedException {
		HP.OpenViewReqHistory();
	}
	@Then("Verify the req O3 Data")
	public void verify_the_req_o3_data() throws InterruptedException {
	        GetAllCompanyCredentials();
			String Apps = "";
			if (AppName.equals("TXO")) {
				 Apps = AppName;
			} else if (AppName.equals("TRX")) {
				Apps = "TRX";
			} else if ( AppName.equals("Standalone")) {
				Apps = "TRX";
			}
			
			String REQNO3_REQNO = ScenarioContext.get("ReqNumber3");
			String REQNO3Vendor03 = ScenarioContext.get(Apps + "Vendor" + 3);
			String REQNO3Customer03 =ScenarioContext.get(Apps + "Customer" + 3);
			
			HP.VerificationOfTheHeaderReqNO(REQNO3_REQNO);
			RPF.VerifyTheDataOfTheReqOfVendorandCustomer(REQNO3Vendor03, REQNO3Customer03);
			RPF.GetTheTotalAmountandVerified("3");
			
			String item1 = ScenarioContext.get(Apps + "ItemsName" + 1);
			String item2 = ScenarioContext.get(Apps + "ItemsName" + 5);
			String item3 = ScenarioContext.get(Apps + "ItemsName" + 9);
			String item4 = ScenarioContext.get(Apps + "ItemsName" + 13);
			
			RPF.LineItemDataVerification("2", item1, "4.00", "40.25");
			RPF.LineItemDataVerification("3", item2, "3.00", "10.25");
			RPF.LineItemDataVerification("4", item3, "2.00", "7.25");
			RPF.LineItemDataVerification("5", item4, "1.00", "2.25");
	}
	@Then("Search the ReqNo O4")
	public void search_the_req_no_o4() throws InterruptedException {
		String REQNO4_REQNO = ScenarioContext.get("ReqNumber4");
		HP.SearchTheSpecificPOorReq(REQNO4_REQNO);
	}
	@Then("Verification of the Data of Req O4 from all the column")
	public void verification_of_the_data_of_req_o4_from_all_the_column() {
		GetAllCompanyCredentials();
		String Apps = "";
		String Status = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
			 Status = "PO Created";
		} else if (AppName.equals("TRX")) {
			Apps = "TRX";
			Status = "Pending Sync";
		} else if ( AppName.equals("Standalone")) {
			Apps = "TRX";
			Status = "PO Created";
		}
		
		String REQNO4_REQNO = ScenarioContext.get("ReqNumber4");
		String REQNO4Vendor04 = ScenarioContext.get(Apps + "Vendor" + 4);
		String PONO4_TotalAmount = ScenarioContext.get( "TotalAmountOFPO4");
		String PONO4 = ScenarioContext.get("PONO4");
		System.out.println(PONO4);
		HP.VerificationOfTheDataoftheReqonHistoryPage(PONO4, REQNO4_REQNO, "Req No 4 Originator -> Approver 01 -> Approver 02 -> Approver 03 Create PO", REQNO4Vendor04, "Originator 01", "Approver 03", PONO4_TotalAmount,Status);
	}
	@Then("Open The Req O4 thorugh view Requisition history")
	public void open_the_req_o4_thorugh_view_requisition_history() throws InterruptedException {
		HP.OpenViewReqHistory();
	}
	@Then("Verify the req O4 Data")
	public void verify_the_req_o4_data() {
		 GetAllCompanyCredentials();
			String Apps = "";
			if (AppName.equals("TXO")) {
				 Apps = AppName;
			} else if (AppName.equals("TRX")) {
				Apps = "TRX";
			} else if ( AppName.equals("Standalone")) {
				Apps = "TRX";
			}
			
			String REQNO1_REQNO = ScenarioContext.get("ReqNumber4");
			String REQNO1Vendor01 = ScenarioContext.get(Apps + "Vendor" + 4);
			String REQNO1Customer01 =ScenarioContext.get(Apps + "Customer" + 4);
			
			HP.VerificationOfTheHeaderReqNO(REQNO1_REQNO);
			RPF.VerifyTheDataOfTheReqOfVendorandCustomer(REQNO1Vendor01, REQNO1Customer01);
			RPF.GetTheTotalAmountandVerified("4");
			
			String item1 = ScenarioContext.get(Apps + "ItemsName" + 2);
			String item2 = ScenarioContext.get(Apps + "ItemsName" + 6);
			String item3 = ScenarioContext.get(Apps + "ItemsName" + 10);
			String item4 = ScenarioContext.get(Apps + "ItemsName" + 14);
			
			RPF.LineItemDataVerification("2", item1, "4.00", "50.25");
			RPF.LineItemDataVerification("3", item2, "3.00", "30.25");
			RPF.LineItemDataVerification("4", item3, "2.00", "7.25");
			RPF.LineItemDataVerification("5", item4, "1.00", "2.25");
	}
	@Then("Search the ReqNo O5")
	public void search_the_req_no_o5() throws InterruptedException {
		String REQNO5_REQNO = ScenarioContext.get("ReqNumber5");
		HP.SearchTheSpecificPOorReq(REQNO5_REQNO);
	}
	@Then("Verification of the Data of Req O5 from all the column")
	public void verification_of_the_data_of_req_o5_from_all_the_column() {
		GetAllCompanyCredentials();
		String Apps = "";
		String Status = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
			 Status = "Cancelled";
		} else if (AppName.equals("TRX")) {
			Apps = "TRX";
			Status = "Cancelled";
		} else if ( AppName.equals("Standalone")) {
			Apps = "TRX";
			Status = "Cancelled";
		}
		
		String REQNO1_REQNO = ScenarioContext.get("ReqNumber5");
		String REQNO1Vendor01 = ScenarioContext.get(Apps + "Vendor" + 5);
		String RejectReqNo5_TotalAmount = ScenarioContext.get("TotalAmountOfReq5");
		HP.VerificationOfTheDataoftheReqonHistoryPage("", REQNO1_REQNO, "Req No 5 Originator -> Approver 01 -> Approver 02 -> Approver 03 Cancelled Req", REQNO1Vendor01, "Originator 01", "Approver 03", RejectReqNo5_TotalAmount,Status);
	}
	@Then("Open The Req O5 thorugh view Requisition history")
	public void open_the_req_o5_thorugh_view_requisition_history() throws InterruptedException {
		HP.OpenViewReqHistory();
	}
	@Then("Verify the req O5 Data")
	public void verify_the_req_o5_data() {
		 GetAllCompanyCredentials();
			String Apps = "";
			if (AppName.equals("TXO")) {
				 Apps = AppName;
			} else if (AppName.equals("TRX")) {
				Apps = "TRX";
			} else if ( AppName.equals("Standalone")) {
				Apps = "TRX";
			}
			
			String REQNO1_REQNO = ScenarioContext.get("ReqNumber5");
			String REQNO1Vendor01 = ScenarioContext.get(Apps + "Vendor" + 5);
			String REQNO1Customer01 =ScenarioContext.get(Apps + "Customer" + 5);
			
			HP.VerificationOfTheHeaderReqNO(REQNO1_REQNO);
			RPF.VerifyTheDataOfTheReqOfVendorandCustomer(REQNO1Vendor01, REQNO1Customer01);
			RPF.GetTheTotalAmountandVerified("5");
			
			String item1 = ScenarioContext.get(Apps + "ItemsName" + 2);
			String item2 = ScenarioContext.get(Apps + "ItemsName" + 6);
			String item3 = ScenarioContext.get(Apps + "ItemsName" + 10);
			String item4 = ScenarioContext.get(Apps + "ItemsName" + 14);
			
			RPF.LineItemDataVerification("2", item1, "4.00", "50.25");
			RPF.LineItemDataVerification("3", item2, "3.00", "30.25");
			RPF.LineItemDataVerification("4", item3, "2.00", "7.25");
			RPF.LineItemDataVerification("5", item4, "1.00", "2.25");
	}
	@Then("Search the ReqNo O6")
	public void search_the_req_no_o6() throws InterruptedException {
		String REQNO6_REQNO = ScenarioContext.get("ReqNumber6");
		HP.SearchTheSpecificPOorReq(REQNO6_REQNO);
	}
	@Then("Verification of the Data of Req O6 from all the column")
	public void verification_of_the_data_of_req_o6_from_all_the_column() {
		GetAllCompanyCredentials();
		String Apps = "";
		String Status = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
			 Status = "Rejected";
		} else if (AppName.equals("TRX")) {
			Apps = "TRX";
			Status = "Rejected";
		} else if ( AppName.equals("Standalone")) {
			Apps = "TRX";
			Status = "Rejected";
		}
		
		String REQNO1_REQNO = ScenarioContext.get("ReqNumber6");
		String REQNO1Vendor01 = ScenarioContext.get(Apps + "Vendor" + 6);
		String REQNO6_TotalAmount = ScenarioContext.get( "TotalAmountOfReq6");
		HP.VerificationOfTheDataoftheReqonHistoryPage("", REQNO1_REQNO, "Req No 6 Originator -> Approver 01 -> Approver 02 -> Approver 03 -> Approver 04 Rejected Req", REQNO1Vendor01, "Originator 01", "Originator 01", REQNO6_TotalAmount,Status);
	}
	@Then("Open The Req O6 thorugh view Requisition history")
	public void open_the_req_o6_thorugh_view_requisition_history() throws InterruptedException {
		HP.OpenViewReqHistory();
	}
	@Then("Verify the req O6 Data")
	public void verify_the_req_o6_data() {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX")) {
			Apps = "TRX";
		} else if ( AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		
		String REQNO1_REQNO = ScenarioContext.get("ReqNumber6");
		String REQNO1Vendor01 = ScenarioContext.get(Apps + "Vendor" + 6);
		String REQNO1Customer01 =ScenarioContext.get(Apps + "Customer" + 6);
		
		HP.VerificationOfTheHeaderReqNO(REQNO1_REQNO);
		RPF.VerifyTheDataOfTheReqOfVendorandCustomer(REQNO1Vendor01, REQNO1Customer01);
		RPF.GetTheTotalAmountandVerified("6");
		
		String item1 = ScenarioContext.get(Apps + "ItemsName" + 3);
		String item2 = ScenarioContext.get(Apps + "ItemsName" + 7);
		String item3 = ScenarioContext.get(Apps + "ItemsName" + 11);
		String item4 = ScenarioContext.get(Apps + "ItemsName" + 15);
		
		RPF.LineItemDataVerification("2", item1, "4.00", "70.25");
		RPF.LineItemDataVerification("3", item2, "3.00", "40.25");
		RPF.LineItemDataVerification("4", item3, "2.00", "7.25");
		RPF.LineItemDataVerification("5", item4, "1.00", "2.25");
	}
	@Then("Search the ReqNo O7")
	public void search_the_req_no_o7() throws InterruptedException {
		String REQNO2_REQNO = ScenarioContext.get("ReqNumber7");
		HP.SearchTheSpecificPOorReq(REQNO2_REQNO);
	}
	@Then("Verification of the Data of Req O7 from all the column")
	public void verification_of_the_data_of_req_o7_from_all_the_column() {
		GetAllCompanyCredentials();
		String Apps = "";
		String Status = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
			 Status = "PO Created";
		} else if (AppName.equals("TRX")) {
			Apps = "TRX";
			Status = "Pending Sync";
		} else if ( AppName.equals("Standalone")) {
			Apps = "TRX";
			Status = "PO Created";
		}
		
		String REQNO1_REQNO = ScenarioContext.get("ReqNumber7");
		String REQNO1Vendor01 = ScenarioContext.get(Apps + "Vendor" + 7);
		String PONO2_TotalAmount = ScenarioContext.get( "TotalAmountOFPO6");
		String PONO3 = ScenarioContext.get("PONO6");
		System.out.println(PONO3);
		HP.VerificationOfTheDataoftheReqonHistoryPage(PONO3, REQNO1_REQNO, "Req No 7 Originator -> Approver 01 -> Approver 02 -> Approver 03 -> Approver 04 Create PO", REQNO1Vendor01, "Originator 01", "Approver 04", PONO2_TotalAmount,Status);
	}
	@Then("Open The Req O7 thorugh view Requisition history")
	public void open_the_req_o7_thorugh_view_requisition_history() throws InterruptedException {
		HP.OpenViewReqHistory();
	}
	@Then("Verify the req O7 Data")
	public void verify_the_req_o7_data() {
		 GetAllCompanyCredentials();
			String Apps = "";
			if (AppName.equals("TXO")) {
				 Apps = AppName;
			} else if (AppName.equals("TRX")) {
				Apps = "TRX";
			} else if ( AppName.equals("Standalone")) {
				Apps = "TRX";
			}
			
			String REQNO1_REQNO = ScenarioContext.get("ReqNumber7");
			String REQNO1Vendor01 = ScenarioContext.get(Apps + "Vendor" + 7);
			String REQNO1Customer01 =ScenarioContext.get(Apps + "Customer" + 7);
			
			HP.VerificationOfTheHeaderReqNO(REQNO1_REQNO);
			RPF.VerifyTheDataOfTheReqOfVendorandCustomer(REQNO1Vendor01, REQNO1Customer01);
			RPF.GetTheTotalAmountandVerified("7");
			
			String item1 = ScenarioContext.get(Apps + "ItemsName" + 3);
			String item2 = ScenarioContext.get(Apps + "ItemsName" + 7);
			String item3 = ScenarioContext.get(Apps + "ItemsName" + 11);
			String item4 = ScenarioContext.get(Apps + "ItemsName" + 15);
			
			RPF.LineItemDataVerification("2", item1, "4.00", "70.25");
			RPF.LineItemDataVerification("3", item2, "3.00", "40.25");
			RPF.LineItemDataVerification("4", item3, "2.00", "7.25");
			RPF.LineItemDataVerification("5", item4, "1.00", "2.25");
	}
	@Then("Search the ReqNo O8")
	public void search_the_req_no_o8() throws InterruptedException {
		String REQNO2_REQNO = ScenarioContext.get("ReqNumber8");
		HP.SearchTheSpecificPOorReq(REQNO2_REQNO);
	}
	@Then("Verification of the Data of Req O8 from all the column")
	public void verification_of_the_data_of_req_o8_from_all_the_column() {
		GetAllCompanyCredentials();
		String Apps = "";
		String Status = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
			 Status = "PO Created";
		} else if (AppName.equals("TRX")) {
			Apps = "TRX";
			Status = "Pending Sync";
		} else if ( AppName.equals("Standalone")) {
			Apps = "TRX";
			Status = "PO Created";
		}
		
		String REQNO1_REQNO = ScenarioContext.get("ReqNumber8");
		String REQNO1Vendor01 = ScenarioContext.get(Apps + "Vendor" + 8);
		String PONO2_TotalAmount = ScenarioContext.get( "TotalAmountOFPO7");
		String PONO3 = ScenarioContext.get("PONO7");
		System.out.println(PONO3);
		HP.VerificationOfTheDataoftheReqonHistoryPage(PONO3, REQNO1_REQNO, "Req No 8 Originator -> APR 01 -> APR 02 -> APR 03 -> APR 04 -> APR 05 Create PO", REQNO1Vendor01, "Originator 01", "Approver 05", PONO2_TotalAmount,Status);
	}
	@Then("Open The Req O8 thorugh view Requisition history")
	public void open_the_req_o8_thorugh_view_requisition_history() throws InterruptedException {
		HP.OpenViewReqHistory();
	}
	@Then("Verify the req O8 Data")
	public void verify_the_req_o8_data() throws InterruptedException {
		 GetAllCompanyCredentials();
			String Apps = "";
			if (AppName.equals("TXO")) {
				 Apps = AppName;
			} else if (AppName.equals("TRX")) {
				Apps = "TRX";
			} else if ( AppName.equals("Standalone")) {
				Apps = "TRX";
			}
			
			String REQNO1_REQNO = ScenarioContext.get("ReqNumber8");
			String REQNO1Vendor01 = ScenarioContext.get(Apps + "Vendor" + 8);
			String REQNO1Customer01 =ScenarioContext.get(Apps + "Customer" + 8);
			
			HP.VerificationOfTheHeaderReqNO(REQNO1_REQNO);
			RPF.VerifyTheDataOfTheReqOfVendorandCustomer(REQNO1Vendor01, REQNO1Customer01);
			RPF.GetTheTotalAmountandVerified("8");
			
			String item1 = ScenarioContext.get(Apps + "ItemsName" + 4);
			String item2 = ScenarioContext.get(Apps + "ItemsName" + 8);
			String item3 = ScenarioContext.get(Apps + "ItemsName" + 12);
			String item4 = ScenarioContext.get(Apps + "ItemsName" + 16);
			
			RPF.LineItemDataVerification("2", item1, "4.00", "85.25");
			RPF.LineItemDataVerification("3", item2, "3.00", "50.25");
			RPF.LineItemDataVerification("4", item3, "2.00", "7.25");
			RPF.LineItemDataVerification("5", item4, "1.00", "2.25");
	}
	@Then("Search the ReqNo O9")
	public void search_the_req_no_o9() throws InterruptedException {
		String REQNO2_REQNO = ScenarioContext.get("ReqNumber9");
		HP.SearchTheSpecificPOorReq(REQNO2_REQNO);
	}
	@Then("Verification of the Data of Req O9 from all the column")
	public void verification_of_the_data_of_req_o9_from_all_the_column() {
		GetAllCompanyCredentials();
		String Apps = "";
		String Status = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
			 Status = "Rejected";
		} else if (AppName.equals("TRX")) {
			Apps = "TRX";
			Status = "Rejected";
		} else if ( AppName.equals("Standalone")) {
			Apps = "TRX";
			Status = "Rejected";
		}
		
		String REQNO1_REQNO = ScenarioContext.get("ReqNumber9");
		String REQNO1Vendor01 = ScenarioContext.get(Apps + "Vendor" + 9);
		String PONO2_TotalAmount = ScenarioContext.get( "TotalAmountOfReq9");
		HP.VerificationOfTheDataoftheReqonHistoryPage("", REQNO1_REQNO, "Req No 9 Originator -> APR 01 -> APR 02 -> APR 03 -> APR 04 -> APR 05 Reject Req", REQNO1Vendor01, "Originator 01", "Originator 01", PONO2_TotalAmount,Status);
	}
	@Then("Open The Req O9 thorugh view Requisition history")
	public void open_the_req_o9_thorugh_view_requisition_history() throws InterruptedException {
		 HP.OpenViewReqHistory();
	}
	@Then("Verify the req O9 Data")
	public void verify_the_req_o9_data() {
		 GetAllCompanyCredentials();
			String Apps = "";
			if (AppName.equals("TXO")) {
				 Apps = AppName;
			} else if (AppName.equals("TRX")) {
				Apps = "TRX";
			} else if ( AppName.equals("Standalone")) {
				Apps = "TRX";
			}
			
			String REQNO1_REQNO = ScenarioContext.get("ReqNumber9");
			String REQNO1Vendor01 = ScenarioContext.get(Apps + "Vendor" + 9);
			String REQNO1Customer01 =ScenarioContext.get(Apps + "Customer" + 9);
			
			HP.VerificationOfTheHeaderReqNO(REQNO1_REQNO);
			RPF.VerifyTheDataOfTheReqOfVendorandCustomer(REQNO1Vendor01, REQNO1Customer01);
			RPF.GetTheTotalAmountandVerified("9");
			
			String item1 = ScenarioContext.get(Apps + "ItemsName" + 4);
			String item2 = ScenarioContext.get(Apps + "ItemsName" + 8);
			String item3 = ScenarioContext.get(Apps + "ItemsName" + 12);
			String item4 = ScenarioContext.get(Apps + "ItemsName" + 16);
			
			RPF.LineItemDataVerification("2", item1, "4.00", "85.25");
			RPF.LineItemDataVerification("3", item2, "3.00", "50.25");
			RPF.LineItemDataVerification("4", item3, "2.00", "7.25");
			RPF.LineItemDataVerification("5", item4, "1.00", "2.25");
	}
	@Then("Search the ReqNo 1O")
	public void search_the_req_no_1o() throws InterruptedException {
		String PONO1 = ScenarioContext.get("PONO1");
		HP.SearchTheSpecificPOorReq(PONO1);
	}
	@Then("Verification of the Data of Req 1O from all the column")
	public void verification_of_the_data_of_req_1o_from_all_the_column() {
		GetAllCompanyCredentials();
		String Apps = "";
		String Status = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
			 Status = "PO Created";
		} else if (AppName.equals("TRX")) {
			Apps = "TRX";
			Status = "Pending Sync";
			ScenarioContext.put("REQNOFromPO10", "10");
		} else if ( AppName.equals("Standalone")) {
			Apps = "TRX";
			Status = "PO Created";
			ScenarioContext.put("REQNOFromPO10", "10");
		}
		
		
		
		String REQNO1_REQNO = ScenarioContext.get("REQNOofPO1");
		String REQNO1Vendor01 = ScenarioContext.get(Apps + "Vendor" + 10);
		String PONO2_TotalAmount = ScenarioContext.get( "TotalAmountOFPO1");
		String PONO3 = ScenarioContext.get("PONO1");
		System.out.println(PONO3);
		HP.VerificationOfTheDataoftheReqonHistoryPage(PONO3, REQNO1_REQNO, "Req No 10 Originator Create PO", REQNO1Vendor01, "Originator 01", "Originator 01", PONO2_TotalAmount,Status);
	}
	@Then("Open The Req 1O thorugh view Requisition history")
	public void open_the_req_1o_thorugh_view_requisition_history() throws InterruptedException {
		HP.OpenViewReqHistory();
	}
	@Then("Verify the req 1O Data")
	public void verify_the_req_1o_data() {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX")) {
			Apps = "TRX";
		} else if ( AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		
		String REQNO1_REQNO = ScenarioContext.get("REQNOofPO1");
		String REQNO1Vendor01 = ScenarioContext.get(Apps + "Vendor" + 10);
		String REQNO1Customer01 =ScenarioContext.get(Apps + "Customer" + 10);
		
		HP.VerificationOfTheHeaderReqNO(REQNO1_REQNO);
		RPF.VerifyTheDataOfTheReqOfVendorandCustomer(REQNO1Vendor01, REQNO1Customer01);
//		RPF.GetTheTotalAmountandVerified("10");
		
		String item1 = ScenarioContext.get(Apps + "ItemsName" + 4);
		String item2 = ScenarioContext.get(Apps + "ItemsName" + 8);
		String item3 = ScenarioContext.get(Apps + "ItemsName" + 12);
		String item4 = ScenarioContext.get(Apps + "ItemsName" + 16);
		
		RPF.LineItemDataVerification("2", item1, "4.00", "10.25");
		RPF.LineItemDataVerification("3", item2, "3.00", "5.25");
		RPF.LineItemDataVerification("4", item3, "2.00", "7.25");
		RPF.LineItemDataVerification("5", item4, "1.00", "2.25");
	}
	@Then("Search the ReqNo 11")
	public void SearchtheReqNo11() throws InterruptedException {
		String REQNO2_REQNO = ScenarioContext.get("ReqNumber11");
		HP.SearchTheSpecificPOorReq(REQNO2_REQNO);
	}
	@Then("Verification of the Data of Req 11 from all the column")
	public void Verificationofthedataofreq11fromallthecolumn() {
		GetAllCompanyCredentials();
		String Apps = "";
		String Status = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
			 Status = "PO Created";
		} else if (AppName.equals("TRX")) {
			Apps = "TRX";
			Status = "Pending Sync";
		} else if ( AppName.equals("Standalone")) {
			Apps = "TRX";
			Status = "PO Created";
		}
		
		String REQNO1_REQNO = ScenarioContext.get("ReqNumber11");
		String REQNO1Vendor01 = ScenarioContext.get(Apps + "Vendor" + 9);
		String PONO2_TotalAmount = ScenarioContext.get( "TotalAmountOFPO5");
		String PONO3 = ScenarioContext.get("PONO5");
		System.out.println(PONO3);
		HP.VerificationOfTheDataoftheReqonHistoryPage(PONO3, REQNO1_REQNO, "Req 11 -> Approver 02 -> Approver 03 Create PO", REQNO1Vendor01, "Approver 02", "Approver 03", PONO2_TotalAmount,Status);
	}
	@Then("Open The Req 11 thorugh view Requisition history")
	public void OpenReq11throughHistoryPage() throws InterruptedException {
		HP.OpenViewReqHistory();
	}
	@Then("Verify the req 11 Data")
	public void Verifythereq11data() {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX")) {
			Apps = "TRX";
		} else if ( AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		
		String REQNO1_REQNO = ScenarioContext.get("ReqNumber11");
		String REQNO1Vendor01 = ScenarioContext.get(Apps + "Vendor" + 9);
		String REQNO1Customer01 =ScenarioContext.get(Apps + "Customer" + 9);
		
		HP.VerificationOfTheHeaderReqNO(REQNO1_REQNO);
		RPF.VerifyTheDataOfTheReqOfVendorandCustomer(REQNO1Vendor01, REQNO1Customer01);
		RPF.GetTheTotalAmountandVerified("11");
		
		String item1 = ScenarioContext.get(Apps + "ItemsName" + 1);
		String item2 = ScenarioContext.get(Apps + "ItemsName" + 5);
		
		RPF.LineItemDataVerification("2", item1, "4.00", "202.25");
		RPF.LineItemDataVerification("3", item2, "3.00", "100.25");
	}
}
