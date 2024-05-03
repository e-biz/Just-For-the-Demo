package Approver01MultiReqRouting;

import com.DriverFactory.DriverFactory;
import com.StoringLocalValues.ScenarioContext;
import com.pages.*;

import io.cucumber.java.en.*;

public class Approver01MultiReqRouting {
	
	private LoginPage Login = new LoginPage(DriverFactory.getDriver());
	private MenuNavBar MM = new MenuNavBar(DriverFactory.getDriver());
	private RequisitionProcessFlow RPF = new RequisitionProcessFlow(DriverFactory.getDriver());
	private HomePage HP = new HomePage(DriverFactory.getDriver());
	
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
	
	
	@When("Enter the login Credentials of Approver O1")
	public void LoginwithApproverO1() throws InterruptedException {
		GetAllCompanyCredentials();
		Login.EnterUsernameandpassword("*********@gmail.com", "*********");
		Login.LoginBTN();
		Thread.sleep(2000);
		Login.SelectProduct(AppName);
		Login.SelectCompany(CompanyName);
		Login.AfterLoginDoSomewait(AppName);
	}
	
	@When("User is on Home Page")
	public void user_is_on_home_page() {
		HP.GetTitleOfHomePage();
	}
	
	//----------------------------------------- ReqNO 01----------------------------------------------------------------
	@Then("Verify the Data with respect to the each column of the Home page according to the ReqNo O1")
	public void verify_the_data_with_respect_to_the_each_column_of_the_home_page_according_to_the_req_no_o1() throws InterruptedException {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		System.out.println(Apps + "Vendor" + 1);
		System.out.println(ScenarioContext.get(Apps + "Vendor" + 1));
		String REQNO1Vendor01 = ScenarioContext.get(Apps + "Vendor" + 1);
		String REQNO1_REQNO =ScenarioContext.get("ReqNumber1");
		String REQNO1_TotalAmount = ScenarioContext.get( "TotalAmountOfReq1");
	    HP.VerifyTheColumnDataWithRespectToTheReq(REQNO1_REQNO, "Req No 1 Originator -> Approver 01 Create PO", REQNO1Vendor01, "Originator 01", REQNO1_TotalAmount);
	}
	@Then("Open the ReqNo O1")
	public void open_the_req_no_o1() throws InterruptedException {
		String REQNO1_REQNO =ScenarioContext.get("ReqNumber1");
	    HP.VerifyThatTheReqisOnHomePageandOpenThatReq(REQNO1_REQNO);
	}
	@Then("Verify that the Vendor O1 and Customer O1 Data is appearing Correctly")
	public void verify_that_the_vendor_o1_and_customer_o1_data_is_appearing_correctly() {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		String REQNO1Vendor01 =ScenarioContext.get(Apps + "Vendor" + 1);
		String REQNO1Customer01 =ScenarioContext.get(Apps + "Customer" + 1);
	    RPF.VerifyTheDataOfTheReqOfVendorandCustomer(REQNO1Vendor01, REQNO1Customer01);
	}
	@Then("Verify that the Item are appearing Correctly with respect to the ReqNo O1")
	public void verify_that_the_item_are_appearing_correctly_with_respect_to_the_req_no_o1() {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		String item1 = ScenarioContext.get(Apps + "ItemsName" + 1);
		String item2 = ScenarioContext.get(Apps + "ItemsName" + 5);
		String item3 = ScenarioContext.get(Apps + "ItemsName" + 9);
		String item4 = ScenarioContext.get(Apps + "ItemsName" + 13);
		
		RPF.LineItemDataVerification("2", item1, "4.00", "15.25");
		RPF.LineItemDataVerification("3", item2, "3.00", "10.25");
		RPF.LineItemDataVerification("4", item3, "2.00", "7.25");
		RPF.LineItemDataVerification("5", item4, "1.00", "2.25");
		//LineItemDataVerification(String LineItemNo,String LineItemName,String LineItemQty, String LineItemRate) {
	}
	@Then("Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O1")
	public void verify_that_the_req_no_total_amount_is_displaying_correctly_and_other_data_with_respect_to_the_req_no_o1() {
	    RPF.GetTheTotalAmountandVerified("1");
	}
	@Then("verify that the PO Button is appearing with respect to the ReqNo O1")
	public void verify_that_the_po_button_is_appearing_with_respect_to_the_req_no_o1() {
	    RPF.CheckTheCreatePOBtnIsAppearing();
	}
	@Then("create the PO with respect to the ReqNo O1")
	public void create_the_po_with_respect_to_the_req_no_o1() throws InterruptedException {
	    RPF.CreatePO("2", "Approver 01", "With");
	}
	
	//--------------------------------------End of ReqNO 01----------------------------------------------------------------
	
	
	
	//----------------------------------------- ReqNO 02----------------------------------------------------------------
	@Then("Verify the Data with respect to the each column of the Home page according to the ReqNo O2")
	public void verify_the_data_with_respect_to_the_each_column_of_the_home_page_according_to_the_req_no_o2() throws InterruptedException {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		System.out.println(Apps + "Vendor" + 2);
		System.out.println(ScenarioContext.get(Apps + "Vendor" + 2));
		String REQNO2Vendor02 = ScenarioContext.get(Apps + "Vendor" + 2);
		String REQNO2_REQNO =ScenarioContext.get("ReqNumber2");
		String REQNO2_TotalAmount = ScenarioContext.get( "TotalAmountOfReq2");
	    HP.VerifyTheColumnDataWithRespectToTheReq(REQNO2_REQNO, "Req No 2 Originator -> Approver 01 -> Approver 02 Create PO", REQNO2Vendor02, "Originator 01", REQNO2_TotalAmount);
	}
	@Then("Open the ReqNo O2")
	public void open_the_req_no_o2() throws InterruptedException {
		String REQNO2_REQNO =ScenarioContext.get("ReqNumber2");
	    HP.VerifyThatTheReqisOnHomePageandOpenThatReq(REQNO2_REQNO);
	}
	@Then("Verify that the Vendor O2 and Customer O2 Data is appearing Correctly")
	public void verify_that_the_vendor_o2_and_customer_o2_data_is_appearing_correctly() throws InterruptedException {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		String REQNO2Vendor02 =ScenarioContext.get(Apps + "Vendor" + 2);
		String REQNO2Customer02 =ScenarioContext.get(Apps + "Customer" + 2);
	    RPF.VerifyTheDataOfTheReqOfVendorandCustomer(REQNO2Vendor02, REQNO2Customer02);
	}
	@Then("Verify that the Item are appearing Correctly with respect to the ReqNo O2")
	public void verify_that_the_item_are_appearing_correctly_with_respect_to_the_req_no_o2() {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		String item1 = ScenarioContext.get(Apps + "ItemsName" + 1);
		String item2 = ScenarioContext.get(Apps + "ItemsName" + 5);
		String item3 = ScenarioContext.get(Apps + "ItemsName" + 9);
		String item4 = ScenarioContext.get(Apps + "ItemsName" + 13);
		
		RPF.LineItemDataVerification("2", item1, "4.00", "40.25");
		RPF.LineItemDataVerification("3", item2, "3.00", "10.25");
		RPF.LineItemDataVerification("4", item3, "2.00", "7.25");
		RPF.LineItemDataVerification("5", item4, "1.00", "2.25");
	}
	@Then("Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O2")
	public void verify_that_the_req_no_total_amount_is_displaying_correctly_and_other_data_with_respect_to_the_req_no_o2() {
		RPF.GetTheTotalAmountandVerified("2");
	}
	@Then("verify that the Approve Button is appearing with respect to the ReqNo O2")
	public void verify_that_the_po_button_is_appearing_with_respect_to_the_req_no_o2() {
	    RPF.CheckTheApproveBtnIsAppearing();
	}
	@Then("Approve the Req with respect to the ReqNo O2")
	public void approve_the_req_with_respect_to_the_req_no_o2() throws InterruptedException {
	    RPF.ApproverReq("Approver 02", "Approver 01", "2");
	}
	//-----------------------------------------End ReqNO 02----------------------------------------------------------------

	//-----------------------------------------ReqNO 03----------------------------------------------------------------
	@Then("Verify the Data with respect to the each column of the Home page according to the ReqNo O3")
	public void verify_the_data_with_respect_to_the_each_column_of_the_home_page_according_to_the_req_no_o3() throws InterruptedException {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		System.out.println(Apps + "Vendor" + 3);
		System.out.println(ScenarioContext.get(Apps + "Vendor" + 3));
		String REQNO3Vendor03 = ScenarioContext.get(Apps + "Vendor" + 3);
		String REQNO3_REQNO =ScenarioContext.get("ReqNumber3");
		String REQNO3_TotalAmount = ScenarioContext.get( "TotalAmountOfReq3");
	    HP.VerifyTheColumnDataWithRespectToTheReq(REQNO3_REQNO, "Req No 3 Originator -> Approver 01 -> Approver 02 Reject Req", REQNO3Vendor03, "Originator 01", REQNO3_TotalAmount);
	}
	@Then("Open the ReqNo O3")
	public void open_the_req_no_o3() throws InterruptedException {
		String REQNO3_REQNO =ScenarioContext.get("ReqNumber3");
	    HP.VerifyThatTheReqisOnHomePageandOpenThatReq(REQNO3_REQNO);
	}
	@Then("Verify that the Vendor O3 and Customer O3 Data is appearing Correctly")
	public void verify_that_the_vendor_o3_and_customer_o3_data_is_appearing_correctly() {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		String REQNO3Vendor03 =ScenarioContext.get(Apps + "Vendor" + 3);
		String REQNO3Customer03 =ScenarioContext.get(Apps + "Customer" + 3);
	    RPF.VerifyTheDataOfTheReqOfVendorandCustomer(REQNO3Vendor03, REQNO3Customer03);
	}
	@Then("Verify that the Item are appearing Correctly with respect to the ReqNo O3")
	public void verify_that_the_item_are_appearing_correctly_with_respect_to_the_req_no_o3() {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		String item1 = ScenarioContext.get(Apps + "ItemsName" + 1);
		String item2 = ScenarioContext.get(Apps + "ItemsName" + 5);
		String item3 = ScenarioContext.get(Apps + "ItemsName" + 9);
		String item4 = ScenarioContext.get(Apps + "ItemsName" + 13);
		
		RPF.LineItemDataVerification("2", item1, "4.00", "40.25");
		RPF.LineItemDataVerification("3", item2, "3.00", "10.25");
		RPF.LineItemDataVerification("4", item3, "2.00", "7.25");
		RPF.LineItemDataVerification("5", item4, "1.00", "2.25");
	}
	@Then("Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O3")
	public void verify_that_the_req_no_total_amount_is_displaying_correctly_and_other_data_with_respect_to_the_req_no_o3() {
		RPF.GetTheTotalAmountandVerified("3");
	}
	@Then("verify that the Approve Button is appearing with respect to the ReqNo O3")
	public void verify_that_the_approve_button_is_appearing_with_respect_to_the_req_no_o3() {
		RPF.CheckTheApproveBtnIsAppearing();
	}
	@Then("Approve the Req with respect to the ReqNo O3")
	public void approve_the_req_with_respect_to_the_req_no_o3() throws InterruptedException {
		RPF.ApproverReq("Approver 02", "Approver 01", "3");
	}
	
	
	//----------------------------------------- End ReqNO 03----------------------------------------------------------------
	
    //-----------------------------------------ReqNO 04----------------------------------------------------------------
	@Then("Verify the Data with respect to the each column of the Home page according to the ReqNo O4")
	public void verify_the_data_with_respect_to_the_each_column_of_the_home_page_according_to_the_req_no_o4() throws InterruptedException {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		System.out.println(Apps + "Vendor" + 4);
		System.out.println(ScenarioContext.get(Apps + "Vendor" + 4));
		String REQNO4Vendor04 = ScenarioContext.get(Apps + "Vendor" + 4);
		String REQNO4_REQNO =ScenarioContext.get("ReqNumber4");
		String REQNO4_TotalAmount = ScenarioContext.get( "TotalAmountOfReq4");
	    HP.VerifyTheColumnDataWithRespectToTheReq(REQNO4_REQNO, "Req No 4 Originator -> Approver 01 -> Approver 02 -> Approver 03 Create PO", REQNO4Vendor04, "Originator 01", REQNO4_TotalAmount);
	}
	@Then("Open the ReqNo O4")
	public void open_the_req_no_o4() throws InterruptedException {
		String REQNO4_REQNO =ScenarioContext.get("ReqNumber4");
	    HP.VerifyThatTheReqisOnHomePageandOpenThatReq(REQNO4_REQNO);
	}
	@Then("Verify that the Vendor O4 and Customer O4 Data is appearing Correctly")
	public void verify_that_the_vendor_o4_and_customer_o4_data_is_appearing_correctly() {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		String REQNO4Vendor04 =ScenarioContext.get(Apps + "Vendor" + 4);
		String REQNO4Customer04 =ScenarioContext.get(Apps + "Customer" + 4);
	    RPF.VerifyTheDataOfTheReqOfVendorandCustomer(REQNO4Vendor04, REQNO4Customer04);
	}
	@Then("Verify that the Item are appearing Correctly with respect to the ReqNo O4")
	public void verify_that_the_item_are_appearing_correctly_with_respect_to_the_req_no_o4() {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		String item1 = ScenarioContext.get(Apps + "ItemsName" + 2);
		String item2 = ScenarioContext.get(Apps + "ItemsName" + 6);
		String item3 = ScenarioContext.get(Apps + "ItemsName" + 10);
		String item4 = ScenarioContext.get(Apps + "ItemsName" + 14);
		
		RPF.LineItemDataVerification("2", item1, "4.00", "50.25");
		RPF.LineItemDataVerification("3", item2, "3.00", "30.25");
		RPF.LineItemDataVerification("4", item3, "2.00", "7.25");
		RPF.LineItemDataVerification("5", item4, "1.00", "2.25");
	}
	@Then("Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O4")
	public void verify_that_the_req_no_total_amount_is_displaying_correctly_and_other_data_with_respect_to_the_req_no_o4() {
		RPF.GetTheTotalAmountandVerified("4");
	}
	@Then("verify that the Approve Button is appearing with respect to the ReqNo O4")
	public void verify_that_the_approve_button_is_appearing_with_respect_to_the_req_no_o4() {
		RPF.CheckTheApproveBtnIsAppearing();
	}
	@Then("Approve the Req with respect to the ReqNo O4")
	public void approve_the_req_with_respect_to_the_req_no_o4() throws InterruptedException {
	    RPF.ApproverReq("Approver 02", "Approver 01", "4");
	}
	 //-----------------------------------------End ReqNO 04----------------------------------------------------------------
	
	 //-----------------------------------------ReqNO 05----------------------------------------------------------------
	@Then("Verify the Data with respect to the each column of the Home page according to the ReqNo O5")
	public void verify_the_data_with_respect_to_the_each_column_of_the_home_page_according_to_the_req_no_o5() throws InterruptedException {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		System.out.println(Apps + "Vendor" + 5);
		System.out.println(ScenarioContext.get(Apps + "Vendor" + 5));
		String REQNO5Vendor05 = ScenarioContext.get(Apps + "Vendor" + 5);
		String REQNO5_REQNO =ScenarioContext.get("ReqNumber5");
		String REQNO5_TotalAmount = ScenarioContext.get( "TotalAmountOfReq5");
	    HP.VerifyTheColumnDataWithRespectToTheReq(REQNO5_REQNO, "Req No 5 Originator -> Approver 01 -> Approver 02 -> Approver 03 Cancelled Req", REQNO5Vendor05, "Originator 01", REQNO5_TotalAmount);
	}
	@Then("Open the ReqNo O5")
	public void open_the_req_no_o5() throws InterruptedException {
		String REQNO5_REQNO =ScenarioContext.get("ReqNumber5");
	    HP.VerifyThatTheReqisOnHomePageandOpenThatReq(REQNO5_REQNO);
	}
	@Then("Verify that the Vendor O5 and Customer O5 Data is appearing Correctly")
	public void verify_that_the_vendor_o5_and_customer_o5_data_is_appearing_correctly() {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		String REQNO5Vendor05 =ScenarioContext.get(Apps + "Vendor" + 5);
		String REQNO5Customer05 =ScenarioContext.get(Apps + "Customer" + 5);
	    RPF.VerifyTheDataOfTheReqOfVendorandCustomer(REQNO5Vendor05, REQNO5Customer05);
	}
	@Then("Verify that the Item are appearing Correctly with respect to the ReqNo O5")
	public void verify_that_the_item_are_appearing_correctly_with_respect_to_the_req_no_o5() {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		String item1 = ScenarioContext.get(Apps + "ItemsName" + 2);
		String item2 = ScenarioContext.get(Apps + "ItemsName" + 6);
		String item3 = ScenarioContext.get(Apps + "ItemsName" + 10);
		String item4 = ScenarioContext.get(Apps + "ItemsName" + 14);
		
		RPF.LineItemDataVerification("2", item1, "4.00", "50.25");
		RPF.LineItemDataVerification("3", item2, "3.00", "30.25");
		RPF.LineItemDataVerification("4", item3, "2.00", "7.25");
		RPF.LineItemDataVerification("5", item4, "1.00", "2.25");
	}
	@Then("Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O5")
	public void verify_that_the_req_no_total_amount_is_displaying_correctly_and_other_data_with_respect_to_the_req_no_o5() {
		RPF.GetTheTotalAmountandVerified("5");
	}
	@Then("verify that the Approve Button is appearing with respect to the ReqNo O5")
	public void verify_that_the_approve_button_is_appearing_with_respect_to_the_req_no_o5() {
		RPF.CheckTheApproveBtnIsAppearing();
	}
	@Then("Approve the Req with respect to the ReqNo O5")
	public void approve_the_req_with_respect_to_the_req_no_o5() throws InterruptedException {
		RPF.ApproverReq("Approver 02", "Approver 01", "5");
	}
	//-----------------------------------------End ReqNO 05----------------------------------------------------------------
	
		 //-----------------------------------------ReqNO 06----------------------------------------------------------------
	@Then("Verify the Data with respect to the each column of the Home page according to the ReqNo O6")
	public void verify_the_data_with_respect_to_the_each_column_of_the_home_page_according_to_the_req_no_o6() throws InterruptedException {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		System.out.println(Apps + "Vendor" + 6);
		System.out.println(ScenarioContext.get(Apps + "Vendor" + 6));
		String REQNO6Vendor06 = ScenarioContext.get(Apps + "Vendor" + 6);
		String REQNO6_REQNO =ScenarioContext.get("ReqNumber6");
		String REQNO6_TotalAmount = ScenarioContext.get( "TotalAmountOfReq6");
	    HP.VerifyTheColumnDataWithRespectToTheReq(REQNO6_REQNO, "Req No 6 Originator -> Approver 01 -> Approver 02 -> Approver 03 -> Approver 04 Rejected Req", REQNO6Vendor06, "Originator 01", REQNO6_TotalAmount);
	}
	@Then("Open the ReqNo O6")
	public void open_the_req_no_o6() throws InterruptedException {
		String REQNO6_REQNO =ScenarioContext.get("ReqNumber6");
	    HP.VerifyThatTheReqisOnHomePageandOpenThatReq(REQNO6_REQNO);
	}
	@Then("Verify that the Vendor O6 and Customer O6 Data is appearing Correctly")
	public void verify_that_the_vendor_o6_and_customer_o6_data_is_appearing_correctly() {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		String REQNO6Vendor06 =ScenarioContext.get(Apps + "Vendor" + 6);
		String REQNO6Customer06 =ScenarioContext.get(Apps + "Customer" + 6);
	    RPF.VerifyTheDataOfTheReqOfVendorandCustomer(REQNO6Vendor06, REQNO6Customer06);
	}
	@Then("Verify that the Item are appearing Correctly with respect to the ReqNo O6")
	public void verify_that_the_item_are_appearing_correctly_with_respect_to_the_req_no_o6() {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		String item1 = ScenarioContext.get(Apps + "ItemsName" + 3);
		String item2 = ScenarioContext.get(Apps + "ItemsName" + 7);
		String item3 = ScenarioContext.get(Apps + "ItemsName" + 11);
		String item4 = ScenarioContext.get(Apps + "ItemsName" + 15);
		
		RPF.LineItemDataVerification("2", item1, "4.00", "70.25");
		RPF.LineItemDataVerification("3", item2, "3.00", "40.25");
		RPF.LineItemDataVerification("4", item3, "2.00", "7.25");
		RPF.LineItemDataVerification("5", item4, "1.00", "2.25");
	}
	@Then("Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O6")
	public void verify_that_the_req_no_total_amount_is_displaying_correctly_and_other_data_with_respect_to_the_req_no_o6() {
		RPF.GetTheTotalAmountandVerified("6");
	}
	@Then("verify that the Approve Button is appearing with respect to the ReqNo O6")
	public void verify_that_the_approve_button_is_appearing_with_respect_to_the_req_no_o6() {
		RPF.CheckTheApproveBtnIsAppearing();
	}
	@Then("Approve the Req with respect to the ReqNo O6")
	public void approve_the_req_with_respect_to_the_req_no_o6() throws InterruptedException {
		RPF.ApproverReq("Approver 02", "Approver 01", "6");
	}
	//-----------------------------------------End ReqNO 5----------------------------------------------------------------
	
	 //-----------------------------------------ReqNO 07----------------------------------------------------------------
	@Then("Verify the Data with respect to the each column of the Home page according to the ReqNo O7")
	public void verify_the_data_with_respect_to_the_each_column_of_the_home_page_according_to_the_req_no_o7() throws InterruptedException {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		System.out.println(Apps + "Vendor" + 7);
		System.out.println(ScenarioContext.get(Apps + "Vendor" + 7));
		String REQNO7Vendor07 = ScenarioContext.get(Apps + "Vendor" + 7);
		String REQNO7_REQNO =ScenarioContext.get("ReqNumber7");
		String REQNO7_TotalAmount = ScenarioContext.get( "TotalAmountOfReq7");
	    HP.VerifyTheColumnDataWithRespectToTheReq(REQNO7_REQNO, "Req No 7 Originator -> Approver 01 -> Approver 02 -> Approver 03 -> Approver 04 Create PO", REQNO7Vendor07, "Originator 01", REQNO7_TotalAmount);

	}
	@Then("Open the ReqNo O7")
	public void open_the_req_no_o7() throws InterruptedException {
		String REQNO7_REQNO =ScenarioContext.get("ReqNumber7");
	    HP.VerifyThatTheReqisOnHomePageandOpenThatReq(REQNO7_REQNO);
	}
	@Then("Verify that the Vendor O7 and Customer O7 Data is appearing Correctly")
	public void verify_that_the_vendor_o7_and_customer_o7_data_is_appearing_correctly() {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		String REQNO7Vendor07 =ScenarioContext.get(Apps + "Vendor" + 7);
		String REQNO7Customer07 =ScenarioContext.get(Apps + "Customer" + 7);
	    RPF.VerifyTheDataOfTheReqOfVendorandCustomer(REQNO7Vendor07, REQNO7Customer07);
	}
	@Then("Verify that the Item are appearing Correctly with respect to the ReqNo O7")
	public void verify_that_the_item_are_appearing_correctly_with_respect_to_the_req_no_o7() {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		String item1 = ScenarioContext.get(Apps + "ItemsName" + 3);
		String item2 = ScenarioContext.get(Apps + "ItemsName" + 7);
		String item3 = ScenarioContext.get(Apps + "ItemsName" + 11);
		String item4 = ScenarioContext.get(Apps + "ItemsName" + 15);
		
		RPF.LineItemDataVerification("2", item1, "4.00", "70.25");
		RPF.LineItemDataVerification("3", item2, "3.00", "40.25");
		RPF.LineItemDataVerification("4", item3, "2.00", "7.25");
		RPF.LineItemDataVerification("5", item4, "1.00", "2.25");
	}
	@Then("Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O7")
	public void verify_that_the_req_no_total_amount_is_displaying_correctly_and_other_data_with_respect_to_the_req_no_o7() {
		RPF.GetTheTotalAmountandVerified("7");
	}
	@Then("verify that the Approve Button is appearing with respect to the ReqNo O7")
	public void verify_that_the_approve_button_is_appearing_with_respect_to_the_req_no_o7() {
		RPF.CheckTheApproveBtnIsAppearing();
	}
	@Then("Approve the Req with respect to the ReqNo O7")
	public void approve_the_req_with_respect_to_the_req_no_o7() throws InterruptedException {
		RPF.ApproverReq("Approver 02", "Approver 01", "7");
	}
	//-----------------------------------------End ReqNO 7----------------------------------------------------------------
	
		 //-----------------------------------------ReqNO 08----------------------------------------------------------------
	@Then("Verify the Data with respect to the each column of the Home page according to the ReqNo O8")
	public void verify_the_data_with_respect_to_the_each_column_of_the_home_page_according_to_the_req_no_o8() throws InterruptedException {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		System.out.println(Apps + "Vendor" + 8);
		System.out.println(ScenarioContext.get(Apps + "Vendor" + 8));
		String REQNO8Vendor08 = ScenarioContext.get(Apps + "Vendor" + 8);
		String REQNO8_REQNO =ScenarioContext.get("ReqNumber8");
		String REQNO8_TotalAmount = ScenarioContext.get( "TotalAmountOfReq8");
	    HP.VerifyTheColumnDataWithRespectToTheReq(REQNO8_REQNO, "Req No 8 Originator -> APR 01 -> APR 02 -> APR 03 -> APR 04 -> APR 05 Create PO", REQNO8Vendor08, "Originator 01", REQNO8_TotalAmount);

	}
	@Then("Open the ReqNo O8")
	public void open_the_req_no_o8() throws InterruptedException {
		String REQNO8_REQNO =ScenarioContext.get("ReqNumber8");
	    HP.VerifyThatTheReqisOnHomePageandOpenThatReq(REQNO8_REQNO);
	}
	@Then("Verify that the Vendor O8 and Customer O8 Data is appearing Correctly")
	public void verify_that_the_vendor_o8_and_customer_o8_data_is_appearing_correctly() {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		String REQNO8Vendor08 =ScenarioContext.get(Apps + "Vendor" + 8);
		String REQNO8Customer08 =ScenarioContext.get(Apps + "Customer" + 8);
	    RPF.VerifyTheDataOfTheReqOfVendorandCustomer(REQNO8Vendor08, REQNO8Customer08);
	}
	@Then("Verify that the Item are appearing Correctly with respect to the ReqNo O8")
	public void verify_that_the_item_are_appearing_correctly_with_respect_to_the_req_no_o8() {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		String item1 = ScenarioContext.get(Apps + "ItemsName" + 4);
		String item2 = ScenarioContext.get(Apps + "ItemsName" + 8);
		String item3 = ScenarioContext.get(Apps + "ItemsName" + 12);
		String item4 = ScenarioContext.get(Apps + "ItemsName" + 16);
		
		RPF.LineItemDataVerification("2", item1, "4.00", "85.25");
		RPF.LineItemDataVerification("3", item2, "3.00", "50.25");
		RPF.LineItemDataVerification("4", item3, "2.00", "7.25");
		RPF.LineItemDataVerification("5", item4, "1.00", "2.25");
	}
	@Then("Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O8")
	public void verify_that_the_req_no_total_amount_is_displaying_correctly_and_other_data_with_respect_to_the_req_no_o8() {
		RPF.GetTheTotalAmountandVerified("8");
	}
	
	@Then("verify that the Approve Button is appearing with respect to the ReqNo O8")
	public void verify_that_the_approve_button_is_appearing_with_respect_to_the_req_no_o8() {
		RPF.CheckTheApproveBtnIsAppearing();
	}
	@Then("Approve the Req with respect to the ReqNo O8")
	public void approve_the_req_with_respect_to_the_req_no_o8() throws InterruptedException {
		RPF.ApproverReq("Approver 02", "Approver 01", "8");
	}
	//-----------------------------------------End ReqNO 8----------------------------------------------------------------
	
	 //-----------------------------------------ReqNO 09----------------------------------------------------------------

	@Then("Verify the Data with respect to the each column of the Home page according to the ReqNo O9")
	public void verify_the_data_with_respect_to_the_each_column_of_the_home_page_according_to_the_req_no_o9() throws InterruptedException {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		System.out.println(Apps + "Vendor" + 9);
		System.out.println(ScenarioContext.get(Apps + "Vendor" + 9));
		String REQNO9Vendor09 = ScenarioContext.get(Apps + "Vendor" + 9);
		String REQNO9_REQNO =ScenarioContext.get("ReqNumber9");
		String REQNO9_TotalAmount = ScenarioContext.get( "TotalAmountOfReq9");
	    HP.VerifyTheColumnDataWithRespectToTheReq(REQNO9_REQNO, "Req No 9 Originator -> APR 01 -> APR 02 -> APR 03 -> APR 04 -> APR 05 Reject Req", REQNO9Vendor09, "Originator 01", REQNO9_TotalAmount);

	}
	@Then("Open the ReqNo O9")
	public void open_the_req_no_o9() throws InterruptedException {
		String REQNO9_REQNO =ScenarioContext.get("ReqNumber9");
	    HP.VerifyThatTheReqisOnHomePageandOpenThatReq(REQNO9_REQNO);
	}
	@Then("Verify that the Vendor O9 and Customer O9 Data is appearing Correctly")
	public void verify_that_the_vendor_o9_and_customer_o9_data_is_appearing_correctly() throws InterruptedException {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		String REQNO9Vendor09 =ScenarioContext.get(Apps + "Vendor" + 9);
		String REQNO9Customer09 =ScenarioContext.get(Apps + "Customer" + 9);
	    RPF.VerifyTheDataOfTheReqOfVendorandCustomer(REQNO9Vendor09, REQNO9Customer09);
	}
	@Then("Verify that the Item are appearing Correctly with respect to the ReqNo O9")
	public void verify_that_the_item_are_appearing_correctly_with_respect_to_the_req_no_o9() {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		String item1 = ScenarioContext.get(Apps + "ItemsName" + 4);
		String item2 = ScenarioContext.get(Apps + "ItemsName" + 8);
		String item3 = ScenarioContext.get(Apps + "ItemsName" + 12);
		String item4 = ScenarioContext.get(Apps + "ItemsName" + 16);
		
		RPF.LineItemDataVerification("2", item1, "4.00", "85.25");
		RPF.LineItemDataVerification("3", item2, "3.00", "50.25");
		RPF.LineItemDataVerification("4", item3, "2.00", "7.25");
		RPF.LineItemDataVerification("5", item4, "1.00", "2.25");

	}
	@Then("Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O9")
	public void verify_that_the_req_no_total_amount_is_displaying_correctly_and_other_data_with_respect_to_the_req_no_o9() {
		RPF.GetTheTotalAmountandVerified("9");
	}
	@Then("verify that the Approve Button is appearing with respect to the ReqNo O9")
	public void verify_that_the_approve_button_is_appearing_with_respect_to_the_req_no_o9() {
		RPF.CheckTheApproveBtnIsAppearing();
	}
	@Then("Approve the Req with respect to the ReqNo O9")
	public void approve_the_req_with_respect_to_the_req_no_o9() throws InterruptedException {
		RPF.ApproverReq("Approver 02", "Approver 01", "9");
	}
	//-----------------------------------------End ReqNO 9----------------------------------------------------------------
	
	//-----------------------------------------Verification of the Approval Limit of Approve 01----------------------------------------------------------------
	@When("User Open the eReq page")
	public void UserOpentheeReqpage() throws InterruptedException {
		MM.NewReqMenu();
	}
	@Then("Select the Vendor and Customer")
	public void SelecttheVendorandCustomer() throws InterruptedException {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		RPF.openVendorLookup();
		String VendorSelection = ScenarioContext.get(Apps + "Vendor" + 9);
		RPF.Select_vendor(VendorSelection);
		// CustomerSelection TRXCustomer1 TXOCustomer1
		RPF.OpenCustomerLookup();
		String CustomerSelection = ScenarioContext.get(Apps + "Customer" + 9);
		RPF.Select_Customer(CustomerSelection);
	}
	@Then("Select Some Items")
	public void SelectSomeItems() throws InterruptedException {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		RPF.OpenItemLookup();
		RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 1));
		RPF.select_the_items(ScenarioContext.get(Apps + "ItemsName" + 5));
		RPF.AddItemToReq();
	}
	@Then("Change in ammount above 2OO and verify that the Approve button will appeared")
	public void Changeinammountabove2OOanverifythattheApprovebuttonwillappeared() throws InterruptedException {
		RPF.ChangeTheLineItemsDescriptionQtyAndRate(2, "Requisition Creation  ", "1",
				"105.25");
		RPF.ChangeTheLineItemsDescriptionQtyAndRate(3, "Requisition Creation ", "1",
				"100.25");
		RPF.ChecktheSubmitIsAppearing();
	}
	@Then("again change the amount less than 2OO and verify that the Create PO button is appearing")
	public void againchangetheamountlessthan2OOandverifythattheCreatePObuttonisappearing() throws InterruptedException {
		RPF.ChangeTheLineItemsDescriptionQtyAndRate(2, "Requisition Creation  ", "1",
				"10.25");
		RPF.ChangeTheLineItemsDescriptionQtyAndRate(3, "Requisition Creation ", "1",
				"100.25");
		RPF.CheckTheCreatePOBtnIsAppearing();
	}
}
