package Approver05MultiReqRouting;

import com.DriverFactory.DriverFactory;
import com.StoringLocalValues.ScenarioContext;
import com.pages.*;

import io.cucumber.java.en.*;

public class Approver05MultiReqRouting {
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
	
	@When("Enter the login Credentials of Approver O5")
	public void LoginwithApproverO5() throws InterruptedException {
		GetAllCompanyCredentials();
		Login.EnterUsernameandpassword("***********@gmail.com", "********");
		Login.LoginBTN();
		Thread.sleep(2000);
		Login.SelectProduct(AppName);
		Login.SelectCompany(CompanyName);
		Login.AfterLoginDoSomewait(AppName);
	}
	@Then("verify that the Create PO Button is appearing with respect to the ReqNo O8")
	public void verifythattheCreatePOButtonisappearingwithrespecttotheReqNoO8() {
		RPF.CheckTheCreatePOBtnIsAppearing();
	}
	@Then("Create a PO with respect to the ReqNo O8")
	public void CreateaPOwithrespecttotheReqNoO8() throws InterruptedException {
		RPF.CreatePO("7", "Approver 05", "With");
	}
	@Then("verify that the Create PO Button is appearing with respect to the ReqNo O9")
	public void verifythattheCreatePOButtonisappearingwithrespecttotheReqNoO9() {
		RPF.CheckTheCreatePOBtnIsAppearing();
	}
	@Then("Reject the Req with respect to the ReqNo O9")
	public void RejecttheReqwithrespecttotheReqNoO9() throws InterruptedException {
		RPF.RejectRequisition();
	}
}
