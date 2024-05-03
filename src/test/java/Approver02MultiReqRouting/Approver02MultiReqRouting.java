package Approver02MultiReqRouting;

import com.DriverFactory.DriverFactory;
import com.StoringLocalValues.ScenarioContext;
import com.pages.*;

import io.cucumber.java.en.*;

public class Approver02MultiReqRouting {

	private LoginPage Login = new LoginPage(DriverFactory.getDriver());
	private RequisitionProcessFlow RPF = new RequisitionProcessFlow(DriverFactory.getDriver());
	
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
	
	
	@When("Enter the login Credentials of Approver O2")
	public void LoginwithApproverO1() throws InterruptedException {
		GetAllCompanyCredentials();
		Login.EnterUsernameandpassword("*******@gmail.com", "******");
		Login.LoginBTN();
		Thread.sleep(2000);
		Login.SelectProduct(AppName);
		Login.SelectCompany(CompanyName);
		Login.AfterLoginDoSomewait(AppName);
	}
	
	@Then("verify that the Create PO Button is appearing with respect to the ReqNo O2")
	public void verifythattheCreatePOButtonisappearingwithrespecttotheReqNoO2() {
		RPF.CheckTheCreatePOBtnIsAppearing();
	}
	@Then("Create the PO with respect to the ReqNo O2")
	public void CreatethePOwithrespecttotheReqNoO2() throws InterruptedException {
		RPF.CreatePO("3", "Approver 02", "With");
	}
	@Then("Reject the Req with respect to the ReqNo O3")
	public void RejecttheReqwithrespecttotheReqNoO3() throws InterruptedException {
		RPF.RejectRequisition();
	}
	@Then("Approve the Req with respect to the ReqNo O4 for Approver O2")
	public void approve_the_req_with_respect_to_the_req_no_o4_for_Approver_O2() throws InterruptedException {
	    RPF.ApproverReq("Approver 03", "Approver 02", "4");
	}
	
	@Then("Approve the Req with respect to the ReqNo O5 for Approver O2")
	public void approve_the_req_with_respect_to_the_req_no_o5() throws InterruptedException {
		RPF.ApproverReq("Approver 03", "Approver 02", "5");
	}
	
	@Then("Approve the Req with respect to the ReqNo O6 for Approver O2")
	public void approve_the_req_with_respect_to_the_req_no_o6() throws InterruptedException {
		RPF.ApproverReq("Approver 03", "Approver 02", "6");
	}
	
	@Then("Approve the Req with respect to the ReqNo O7 for Approver O2")
	public void approve_the_req_with_respect_to_the_req_no_o7() throws InterruptedException {
		RPF.ApproverReq("Approver 03", "Approver 02", "7");
	}
	
	@Then("Approve the Req with respect to the ReqNo O8 for Approver O2")
	public void approve_the_req_with_respect_to_the_req_no_o8() throws InterruptedException {
		RPF.ApproverReq("Approver 03", "Approver 02", "8");
	}
	
	@Then("Approve the Req with respect to the ReqNo O9 for Approver O2")
	public void approve_the_req_with_respect_to_the_req_no_o9() throws InterruptedException {
		RPF.ApproverReq("Approver 03", "Approver 02", "9");
	}
	
	
	@Then("Change in ammount above 3OO and verify that the Approve button will appeared")
	public void Changeinammountabove2OOanverifythattheApprovebuttonwillappeared() throws InterruptedException {
		RPF.ChangeTheLineItemsDescriptionQtyAndRate(2, "Requisition Creation  ", "1",
				"205.25");
		RPF.ChangeTheLineItemsDescriptionQtyAndRate(3, "Requisition Creation ", "1",
				"100.25");
		RPF.ChecktheSubmitIsAppearing();
	}
	@Then("again change the amount less than 3OO and verify that the Create PO button is appearing")
	public void againchangetheamountlessthan2OOandverifythattheCreatePObuttonisappearing() throws InterruptedException {
		RPF.ChangeTheLineItemsDescriptionQtyAndRate(2, "Requisition Creation  ", "1",
				"105.25");
		RPF.ChangeTheLineItemsDescriptionQtyAndRate(3, "Requisition Creation ", "1",
				"100.25");
		RPF.CheckTheCreatePOBtnIsAppearing();
	}
	@Then("again change the amount and Submit the Req to Approver O3")
	public void againchangetheamountandSubmittheReqtoApproverO3() throws InterruptedException {
		RPF.ChangeTheLineItemsDescriptionQtyAndRate(2, "Requisition Creation", "1",
				"205.25");
		RPF.ChangeTheLineItemsDescriptionQtyAndRate(3, "Requisition Creation ", "1",
				"100.25");
		RPF.SubmitReq("11", "Approver 03");
	}
}
