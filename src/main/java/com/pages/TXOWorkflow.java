package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;



public class TXOWorkflow {

	WebDriver driver;

	public TXOWorkflow(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, TXOWorkflow.this);
	}
	
//	private static final Logger LOGGER = Logger.getLogger( TXOWorkflow.class);
//	SoftAssert softassert = new SoftAssert();

	@FindBy(id = "MainContent_rbOpt1")
	WebElement Companylevelworkflow;
	// Approver 1

	@FindBy(id = "MainContent_gvWholeComapny_CheckBox5_0")
	WebElement ChkApprover1;

	@FindBy(id = "ddlApp1")
	WebElement User1;

	@FindBy(id = "MainContent_gvWholeComapny_chk1_0")
	WebElement ChkLimit1;

	@FindBy(id = "MainContent_gvWholeComapny_txtAmt1_0")
	WebElement txtLimit1;
	
	@FindBy(id = "MainContent_gvWholeComapny_txtEmail1_0")
	WebElement TxtEmail1;

	// Approver 2

	@FindBy(id = "MainContent_gvWholeComapny_CheckBox1_0")
	WebElement ChkApprover2;

	@FindBy(id = "MainContent_gvWholeComapny_ddlApp2_0")
	WebElement User2;

	@FindBy(id = "MainContent_gvWholeComapny_chk2_0")
	WebElement ChkLimit2;

	@FindBy(id = "MainContent_gvWholeComapny_txtAmt2_0")
	WebElement txtLimit2;
	
	@FindBy(id = "MainContent_gvWholeComapny_txtEmail2_0")
	WebElement TxtEmail2;

	// Approver 3

	@FindBy(id = "MainContent_gvWholeComapny_CheckBox2_0")
	WebElement ChkApprover3;

	@FindBy(id = "MainContent_gvWholeComapny_ddlApp3_0")
	WebElement User3;

	@FindBy(id = "MainContent_gvWholeComapny_chk3_0")
	WebElement ChkLimit3;

	@FindBy(id = "MainContent_gvWholeComapny_txtAmt3_0")
	WebElement txtLimit3;
	
	@FindBy(id = "MainContent_gvWholeComapny_txtEmail3_0")
	WebElement TxtEmail3;

	// Approver 4

	@FindBy(id = "MainContent_gvWholeComapny_CheckBox3_0")
	WebElement ChkApprover4;

	@FindBy(id = "MainContent_gvWholeComapny_ddlApp4_0")
	WebElement User4;

	@FindBy(id = "MainContent_gvWholeComapny_chk4_0")
	WebElement ChkLimit4;

	@FindBy(id = "MainContent_gvWholeComapny_txtAmt4_0")
	WebElement txtLimit4;
	
	@FindBy(id = "MainContent_gvWholeComapny_txtEmail4_0")
	WebElement TxtEmail4;

	// Approver 5

	@FindBy(id = "MainContent_gvWholeComapny_CheckBox4_0")
	WebElement ChkApprover5;

	@FindBy(id = "MainContent_gvWholeComapny_ddlApp5_0")
	WebElement User5;

	@FindBy(id = "MainContent_gvWholeComapny_chk5_0")
	WebElement ChkLimit5;

	@FindBy(id = "MainContent_gvWholeComapny_txtAmt5_0")
	WebElement txtLimit5;
	
	@FindBy(id = "MainContent_gvWholeComapny_txtEmail5_0")
	WebElement TxtEmail5;

	// Approver 6

	@FindBy(id = "MainContent_gvWholeComapny_CheckBox14_0")
	WebElement ChkApprover6;

	@FindBy(id = "MainContent_gvWholeComapny_ddlApp6_0")
	WebElement User6;
	
	@FindBy(id = "MainContent_gvWholeComapny_txtEmail6_0")
	WebElement TxtEmail6;

	@FindBy(id = "btn_Insert")
	WebElement SaveBTN;

	@FindBy(id = "MainContent_rbOpt2")
	WebElement DeptLevelWorkflow;
	//div[@class = 'sweet-alert showSweetAlert visible']//p
	@FindBy(xpath = "//div[@class = 'sweet-alert showSweetAlert visible']//p")
	List<WebElement> WorkflowValidationMsg;
	
	public String AproverSelectFromDLLMsg = "Please select the approver from the dropdown and then proceed.";
	public String ApproverCanNotBeSameMsg = "Selected user cannot be same.";
	public String  ThankyouMsg = "Thank you! Your changes have been saved.";
	public String ApprovalLimitCanntbeEmpty = "'Approval Limit $' value cannot be empty.";
	public String ApprovalLimitIncreaseMsg = "Please adjust the approval limit(s) to increase in value from one approver to the next.";
	public String ApprovalFinalLimitMsg = "Final approver(s) cannot have an approval limit.";
	public String InvalidEmailmsg = "Please enter a valid email address. (i.e. name@domain.com)";
	
	public void ByDefaultCheckOnCompanyLevel() {
		Assert.assertEquals(Companylevelworkflow.isSelected(),true, "New Company Creation Workflow is by Defualt not selected at Company level Workflow");
	}
	public void ResetWorkflow() throws InterruptedException {
		if (Companylevelworkflow.isSelected()) {
			DeptLevelWorkflow.click();
			Thread.sleep(2000);
			SaveBTN.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div//button[@class = 'confirm']")).click();
		} else if (DeptLevelWorkflow.isSelected()) {
			Companylevelworkflow.click();
			Thread.sleep(6000);
			SaveBTN.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div//button[@class = 'confirm']")).click();
		}
	}

	public void SelectCompanyLevelWorkflow() throws InterruptedException {
		Companylevelworkflow.click();
		Thread.sleep(3000);
	}
	public void SaveTheWorkflow() throws InterruptedException {
		SaveBTN.click();
		Thread.sleep(2000);
		 String alertMsg = driver.findElement(By.xpath("//div[@class = 'sweet-alert showSweetAlert visible']//h2")).getText();
		 String thankyou = "Success!";
		 Assert.assertEquals(alertMsg, thankyou);
		 driver.findElement(By.xpath("//div//button[@class = 'confirm']")).click();
	}

	public void SaveBTN() throws InterruptedException {
		SaveBTN.click();
		Thread.sleep(3000);
	}
	
	public void WorkflowValidationPopupVerification(String ValidationMSG) throws InterruptedException {
		String AcutalValidationMsg = WorkflowValidationMsg.get(0).getText();
		Assert.assertEquals(AcutalValidationMsg, ValidationMSG, "Validation is not appearing as expected see snapshot");
		 driver.findElement(By.xpath("//div//button[@class = 'confirm']")).click();
		 Thread.sleep(2000);
	}

	public void SetWorkflowAccordingToTheUserCount(String UserLimitWorkflowSet) throws InterruptedException {
		
		if(UserLimitWorkflowSet.equals("1")) {
			// Approver 1
			Thread.sleep(5000);
			ChkApprover1.click();
			Thread.sleep(5000);
			Select DDrop1 = new Select(User1);
			DDrop1.selectByVisibleText("Originator 01");
			Thread.sleep(5000);
		}
		else if(UserLimitWorkflowSet.equals("2")) {
			// Approver 1
			Thread.sleep(5000);
			ChkApprover1.click();
			Thread.sleep(5000);
			Select DDrop1 = new Select(User1);
			DDrop1.selectByVisibleText("Originator 01");
			Thread.sleep(5000);
			ChkLimit1.click();
			Thread.sleep(6000);
			txtLimit1.sendKeys("100");
			
			ChkApprover2.click();
			Thread.sleep(5000);
			Select DDrop2 = new Select(User2);
			DDrop2.selectByVisibleText("Approver 01");
		}
		else if(UserLimitWorkflowSet.equals("3")) {
			// Approver 1
			System.out.println("1");
						Thread.sleep(5000);
						ChkApprover1.click();
						System.out.println("1");
						Thread.sleep(5000);
						System.out.println("1");
						Select DDrop1 = new Select(User1);
						DDrop1.selectByVisibleText("Originator 01");
						Thread.sleep(5000);
						ChkLimit1.click();
						Thread.sleep(6000);
						txtLimit1.sendKeys("100");
						
						ChkApprover2.click();
						Thread.sleep(5000);
						Select DDrop2 = new Select(User2);
						DDrop2.selectByVisibleText("Approver 01");
						Thread.sleep(5000);
						ChkLimit2.click();
						Thread.sleep(6000);
						txtLimit2.sendKeys("200");
						
						ChkApprover3.click();
						Thread.sleep(5000);
						Select DDrop3 = new Select(User3);
						DDrop3.selectByVisibleText("Approver 02");
		}
		else if(UserLimitWorkflowSet.equals("4")) {
			// Approver 1
						Thread.sleep(5000);
						ChkApprover1.click();
						Thread.sleep(5000);
						Select DDrop1 = new Select(User1);
						DDrop1.selectByVisibleText("Originator 01");
						Thread.sleep(5000);
						ChkLimit1.click();
						Thread.sleep(6000);
						txtLimit1.sendKeys("100");
						
						ChkApprover2.click();
						Thread.sleep(5000);
						Select DDrop2 = new Select(User2);
						DDrop2.selectByVisibleText("Approver 01");
						Thread.sleep(5000);
						ChkLimit2.click();
						Thread.sleep(6000);
						txtLimit2.sendKeys("200");
						
						ChkApprover3.click();
						Thread.sleep(5000);
						Select DDrop3 = new Select(User3);
						DDrop3.selectByVisibleText("Approver 02");
						Thread.sleep(5000);
						ChkLimit3.click();
						Thread.sleep(6000);
						txtLimit3.sendKeys("300");
						
						ChkApprover4.click();
						Thread.sleep(5000);
						Select DDrop4 = new Select(User4);
						DDrop4.selectByVisibleText("Approver 03");

		}
		else if(UserLimitWorkflowSet.equals("5")) {
			// Approver 1
						Thread.sleep(5000);
						ChkApprover1.click();
						Thread.sleep(5000);
						Select DDrop1 = new Select(User1);
						DDrop1.selectByVisibleText("Originator 01");
						Thread.sleep(5000);
						ChkLimit1.click();
						Thread.sleep(6000);
						txtLimit1.sendKeys("100");
						
						ChkApprover2.click();
						Thread.sleep(5000);
						Select DDrop2 = new Select(User2);
						DDrop2.selectByVisibleText("Approver 01");
						Thread.sleep(5000);
						ChkLimit2.click();
						Thread.sleep(6000);
						txtLimit2.sendKeys("200");
						
						ChkApprover3.click();
						Thread.sleep(5000);
						Select DDrop3 = new Select(User3);
						DDrop3.selectByVisibleText("Approver 02");
						Thread.sleep(5000);
						ChkLimit3.click();
						Thread.sleep(6000);
						txtLimit3.sendKeys("300");
						
						ChkApprover4.click();
						Thread.sleep(5000);
						Select DDrop4 = new Select(User4);
						DDrop4.selectByVisibleText("Approver 03");
						Thread.sleep(5000);
						ChkLimit4.click();
						Thread.sleep(6000);
						txtLimit4.sendKeys("400");
						
						ChkApprover5.click();
						Thread.sleep(5000);
						Select DDrop5 = new Select(User5);
						DDrop5.selectByVisibleText("Approver 04");

		}else if(UserLimitWorkflowSet.equals("6")) {
			// Approver 1
			Thread.sleep(5000);
			ChkApprover1.click();
			Thread.sleep(5000);
			Select DDrop1 = new Select(User1);
			DDrop1.selectByVisibleText("Originator 01");
			Thread.sleep(5000);
			ChkLimit1.click();
			Thread.sleep(6000);
			txtLimit1.sendKeys("100");
			
			ChkApprover2.click();
			Thread.sleep(5000);
			Select DDrop2 = new Select(User2);
			DDrop2.selectByVisibleText("Approver 01");
			Thread.sleep(5000);
			ChkLimit2.click();
			Thread.sleep(6000);
			txtLimit2.sendKeys("200");
			
			ChkApprover3.click();
			Thread.sleep(5000);
			Select DDrop3 = new Select(User3);
			DDrop3.selectByVisibleText("Approver 02");
			Thread.sleep(5000);
			ChkLimit3.click();
			Thread.sleep(6000);
			txtLimit3.sendKeys("300");
			
			ChkApprover4.click();
			Thread.sleep(5000);
			Select DDrop4 = new Select(User4);
			DDrop4.selectByVisibleText("Approver 03");
			Thread.sleep(5000);
			ChkLimit4.click();
			Thread.sleep(6000);
			txtLimit4.sendKeys("400");
			
			ChkApprover5.click();
			Thread.sleep(5000);
			Select DDrop5 = new Select(User5);
			DDrop5.selectByVisibleText("Approver 04");
			Thread.sleep(5000);
			ChkLimit5.click();
			Thread.sleep(6000);
			txtLimit5.sendKeys("500");
			
			ChkApprover6.click();
			Thread.sleep(5000);
			Select DDrop6 = new Select(User6);
			DDrop6.selectByVisibleText("Approver 05");
		}
		SaveBTN();
		WorkflowValidationPopupVerification(ThankyouMsg);
	}
	
}
