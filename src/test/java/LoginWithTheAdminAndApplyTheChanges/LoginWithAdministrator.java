package LoginWithTheAdminAndApplyTheChanges;

import java.util.*;
import org.testng.Assert;
import com.DriverFactory.DriverFactory;
import com.pages.*;
import io.cucumber.java.en.*;
import com.StoringLocalValues.ScenarioContext;

public class LoginWithAdministrator {
	
	private LoginPage Login =new LoginPage(DriverFactory.getDriver());
	private MenuNavBar MM=new MenuNavBar(DriverFactory.getDriver());
	private UserCreation UC = new UserCreation(DriverFactory.getDriver());
	private RequisitionProcessFlow RequisitionPage=new RequisitionProcessFlow(DriverFactory.getDriver());
	private ReqPageCreationProcessValidationandMaxLengthVerifications CreationProcess=new ReqPageCreationProcessValidationandMaxLengthVerifications(DriverFactory.getDriver());
	private TRXWorkflow TRXWF= new TRXWorkflow(DriverFactory.getDriver());
	private TXOWorkflow TXOWF = new TXOWorkflow(DriverFactory.getDriver());
	
	//----------------------------------------------------------------------------------------------------
	//---------------------------For Background use-------------------------------------------------------
	//----------------------------------------------------------------------------------------------------
//	public String AppName= "TRX";
//	public String AdminEmail = "ChristenMicheal@gmail.com";
//	public String CompanyName = "CamposChaneyInc";
	
	
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

	@Given("Open the TRX application and Login with the Adminsitrator")
	public void Open_the_TRX_application_and_Login_with_the_Adminsitrator() throws InterruptedException {
		GetAllCompanyCredentials();
		if (Env.equals("QA")) {
			DriverFactory.getDriver().get("https://qaerequisition.e-bizsoft.net");
		} else if (Env.equals("STAGING")) {
			DriverFactory.getDriver().get("https://ereqstg.e-bizsoft.net");
		} else {
			Assert.fail("PLease set the Correct Environment : " + Env);
		}
		DriverFactory.getDriver().manage().window().maximize();
		Thread.sleep(2000);
		Login.EnterUsernameandpassword(AEmail, Password);
		Login.LoginBTN();
		Thread.sleep(2000);
		Login.SelectProduct(AppName);
		Login.SelectCompany(CompanyName);
		Login.AfterLoginDoSomewait(AppName);
	}

    @Then("open requisition page")
    public void open_requisition_page() throws InterruptedException {
    	MM.NewReqMenu();
    }
    
    @Then("create vendor customer and item and save it as a draft requisition")
    public void create_vendor_customer_and_item_and_save_it_as_a_draft_requisition() throws InterruptedException {
    	GetAllCompanyCredentials();
		if(AppName.equals("TXO")) {
		Thread.sleep(2000);
    	CreationProcess.TXO_VendorCreationWithMinInfo("10");
		CreationProcess.TXO_CustomerCreationWithMinInfo("10");
		MM.NewReqPage_fromReqPage();
    	RequisitionPage.openVendorLookup();
		RequisitionPage.Select_vendor(ScenarioContext.get("TXOVendor1"));
		RequisitionPage.OpenCustomerLookup();
		RequisitionPage.Select_Customer(ScenarioContext.get("TXOCustomer1"));
		CreationProcess.TXO_ItemCreationProcessFor_SVR_INV_NonINV_WithMinInfo("16");	
    	RequisitionPage.SavetheReq();
    	}
		else {
			Thread.sleep(2000);
	    	CreationProcess.TRX_VendorCreationWithMinInfo("10");
	    	CreationProcess.TRX_CustomerCreationWithMinInfo("10");
	    	MM.NewReqPage_fromReqPage();
	    	RequisitionPage.openVendorLookup();
			RequisitionPage.Select_vendor(ScenarioContext.get("TRXVendor1"));
			RequisitionPage.OpenCustomerLookup();
			RequisitionPage.Select_Customer(ScenarioContext.get("TRXCustomer1"));
			CreationProcess.TRX_MinItemCreationForSVR_INV_NINV_OC("16");	
	    	RequisitionPage.SavetheReq();
		}
    }
    
   
    
	@Then("Go to the User Management Page")
	public void go_to_the_user_management_page() throws InterruptedException {
		Thread.sleep(2000);
	    MM.Setting_UserManagementMenu();
	}
	

	@And("Check that the user is exist if not create that user")
	public void Check_that_the_user_is_exist_if_not_create_that_user() throws InterruptedException {
		UC.CheckDeptIsCreatedIfNotThenCreate();
		UC.CountThathowManyUserAreNotExist();
		UC.GetAllTheUserAndCheckIftheWorkflowUserisNotAddedThenCreateThatUser();
	}
	
	@Then("How many user want to ADD in Workflow")
	public void how_many_user_want_to_add_in_workflow(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {
		GetAllCompanyCredentials();
		Thread.sleep(2000);
		MM.Setting_WorkflowMenu();
		Thread.sleep(2000);
		if (AppName.equals("TXO")) {
			TXOWF.ResetWorkflow();
			TXOWF.SelectCompanyLevelWorkflow();
		} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
			TRXWF.ResetWorkflow();
			TRXWF.SelectCompanyLevelWorkflow();
		}
		List<Map<String, String>> listdata = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> mapdata : listdata) {
			if (AppName.equals("TXO")) {
				TXOWF.SetWorkflowAccordingToTheUserCount(mapdata.get("Users"));
			} else if (AppName.equals("TRX") || AppName.equals("Standalone")) {
				TRXWF.SetWorkflowAccordingToTheUserCount(mapdata.get("Users"));
			} else {
				Assert.fail("Accounting Name is not correct : " + AppName);
			}
		}

	}
	//----------------------------------------------------------------------------------------------------	
	//---------------------------For Background use End-------------------------------------------------------
	//----------------------------------------------------------------------------------------------------
}
