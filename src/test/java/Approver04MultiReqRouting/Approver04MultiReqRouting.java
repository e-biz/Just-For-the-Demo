package Approver04MultiReqRouting;

import com.DriverFactory.DriverFactory;
import com.StoringLocalValues.ScenarioContext;
import com.pages.LoginPage;
import com.pages.RequisitionProcessFlow;

import io.cucumber.java.en.*;

public class Approver04MultiReqRouting {
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
	
	@When("Enter the login Credentials of Approver O4")
	public void LoginwithApproverO4() throws InterruptedException {
		GetAllCompanyCredentials();
		Login.EnterUsernameandpassword("*******@gmail.com", "********");
		Login.LoginBTN();
		Thread.sleep(2000);
		Login.SelectProduct(AppName);
		Login.SelectCompany(CompanyName);
		Login.AfterLoginDoSomewait(AppName);
	}
	@Then("Reject the Req with respect to the ReqNo O6")
	public void RejecttheReqwithrespecttotheReqNoO6() throws InterruptedException {
		RPF.RejectRequisition();
	}
	@Then("verify that the Create PO Button is appearing with respect to the ReqNo O7")
	public void verifythattheCreatePOButtonisappearingwithrespecttotheReqNoO7() throws InterruptedException {
		RPF.CheckTheCreatePOBtnIsAppearing();
	}
	
	@Then("Create a PO with respect to the ReqNo O7")
	public void CreateaPOWithRespectotheReqNo07() throws InterruptedException {
		RPF.CreatePO("6", "Approver 04", "With");
	}
	
	@Then("Approve the Req with respect to the ReqNo O8 for Approver O4")
	public void approve_the_req_with_respect_to_the_req_no_o8() throws InterruptedException {
		RPF.ApproverReq("Approver 05", "Approver 04", "8");
	}
	
	@Then("Approve the Req with respect to the ReqNo O9 for Approver O4")
	public void approve_the_req_with_respect_to_the_req_no_o9() throws InterruptedException {
		RPF.ApproverReq("Approver 05", "Approver 04", "9");
	}

}
