package Approver03MultiReqRouting;

import com.DriverFactory.DriverFactory;
import com.StoringLocalValues.ScenarioContext;
import com.pages.*;

import io.cucumber.java.en.*;

public class Approver03MultiReqRouting {

	private LoginPage Login = new LoginPage(DriverFactory.getDriver());
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
	
	@When("Enter the login Credentials of Approver O3")
	public void LoginwithApproverO3() throws InterruptedException {
		GetAllCompanyCredentials();
		Login.EnterUsernameandpassword("*********@gmail.com", "********");
		Login.LoginBTN();
		Thread.sleep(2000);
		Login.SelectProduct(AppName);
		Login.SelectCompany(CompanyName);
		Login.AfterLoginDoSomewait(AppName);
	}
	@Then("verify that the Create PO Button is appearing with respect to the ReqNo O4")
	public void verifythattheCreatePOButtonisappearingwithrespecttotheReqNoO4() {
		RPF.CheckTheCreatePOBtnIsAppearing();
	}
	@Then("Create a PO with respect to the ReqNo O4")
	public void CreateaPOwithrespecttotheReqNoO4() throws InterruptedException {
		RPF.CreatePO("4", "Approver 03", "With");
	}
	@Then("Cancelled the Req with respect to the ReqNo O5")
	public void CancelledtheReqwithrespecttotheReqNoO5() throws InterruptedException {
		RPF.WithDraw();
	}
	
	@Then("Approve the Req with respect to the ReqNo O6 for Approver O3")
	public void approve_the_req_with_respect_to_the_req_no_o6() throws InterruptedException {
		RPF.ApproverReq("Approver 04", "Approver 03", "6");
	}
	
	@Then("Approve the Req with respect to the ReqNo O7 for Approver O3")
	public void approve_the_req_with_respect_to_the_req_no_o7() throws InterruptedException {
		RPF.ApproverReq("Approver 04", "Approver 03", "7");
	}
	
	@Then("Approve the Req with respect to the ReqNo O8 for Approver O3")
	public void approve_the_req_with_respect_to_the_req_no_o8() throws InterruptedException {
		RPF.ApproverReq("Approver 04", "Approver 03", "8");
	}
	
	@Then("Approve the Req with respect to the ReqNo O9 for Approver O3")
	public void approve_the_req_with_respect_to_the_req_no_o9() throws InterruptedException {
		RPF.ApproverReq("Approver 04", "Approver 03", "9");
	}
	
	@Then("Verify the Data with respect to the each column of the Home page according to the ReqNo 11")
	public void verify_the_data_with_respect_to_the_each_column_of_the_home_page_according_to_the_req_no_11() throws InterruptedException {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		System.out.println(Apps + "Vendor" + 9);
		System.out.println(ScenarioContext.get(Apps + "Vendor" + 9));
		String REQNO11Vendor09 = ScenarioContext.get(Apps + "Vendor" + 9);
		String REQNO11_REQNO =ScenarioContext.get("ReqNumber11");
		String REQNO11_TotalAmount = ScenarioContext.get( "TotalAmountOfReq11");
	    HP.VerifyTheColumnDataWithRespectToTheReq(REQNO11_REQNO, "".trim(), REQNO11Vendor09, "Approver 02", REQNO11_TotalAmount);
	}
	@Then("Open the ReqNo 11")
	public void open_the_req_no11() throws InterruptedException {
		String REQNO11_REQNO =ScenarioContext.get("ReqNumber11");
	    HP.VerifyThatTheReqisOnHomePageandOpenThatReq(REQNO11_REQNO);
	}
	@Then("Verify that the Item are appearing Correctly with respect to the ReqNo 11")
	public void verify_that_the_item_are_appearing_correctly_with_respect_to_the_req_no_11() {
		GetAllCompanyCredentials();
		String Apps = "";
		if (AppName.equals("TXO")) {
			 Apps = AppName;
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			Apps = "TRX";
		}
		String item1 = ScenarioContext.get(Apps + "ItemsName" + 1);
		String item2 = ScenarioContext.get(Apps + "ItemsName" + 5);
		
		RPF.LineItemDataVerification("2", item1, "1.00", "205.25");
		RPF.LineItemDataVerification("3", item2, "1.00", "100.25");
	}
	@Then("Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo 11")
	public void verify_that_the_req_no_total_amount_is_displaying_correctly_and_other_data_with_respect_to_the_req_no_11() {
		RPF.GetTheTotalAmountandVerified("11");
	}
	@Then("verify that the Create PO Button is appearing with respect to the ReqNo 11")
	public void verify_that_the_CreatePO_button_is_appearing_with_respect_to_the_req_no_11() {
		RPF.CheckTheCreatePOBtnIsAppearing();
	}
	@Then("Create a PO Req with respect to the ReqNo 11")
	public void Create_a_PO_with_respect_to_the_req_no_11() throws InterruptedException {
		RPF.CreatePO("5", "Approver 03", "With");
	}
}
