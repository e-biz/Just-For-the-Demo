package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TRXWorkflow {


	WebDriver driver;

	public TRXWorkflow(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, TRXWorkflow.this);
	}

	@FindBy(id = "MainContent_rbOpt1")
	WebElement Companylevelworkflow;
	// Approver 1
//
	@FindBy(id = "ddlApp1")//MainContent_gvWholeComapny_ddlApp1_0")
	WebElement User1;

	@FindBy(id = "MainContent_gvWholeComapny_chk1_0")
	WebElement ChkLimit1;

	@FindBy(id = "MainContent_gvWholeComapny_txtAmt1_0")
	WebElement txtLimit1;
	
	@FindBy(id = "MainContent_gvWholeComapny_txtEmail1_0")
	WebElement txtEmail1;
	
	

	// Approver 2

	@FindBy(id = "MainContent_gvWholeComapny_ddlApp2_0")
	WebElement User2;

	@FindBy(id = "MainContent_gvWholeComapny_chk2_0")
	WebElement ChkLimit2;

	@FindBy(id = "MainContent_gvWholeComapny_txtAmt2_0")
	WebElement txtLimit2;
	
	@FindBy(id = "MainContent_gvWholeComapny_txtEmail2_0")
	WebElement txtEmail2;

	// Approver 3

	@FindBy(id = "MainContent_gvWholeComapny_ddlApp3_0")
	WebElement User3;

	@FindBy(id = "MainContent_gvWholeComapny_chk3_0")
	WebElement ChkLimit3;

	@FindBy(id = "MainContent_gvWholeComapny_txtAmt3_0")
	WebElement txtLimit3;
	
	@FindBy(id = "MainContent_gvWholeComapny_txtEmail3_0")
	WebElement txtEmail3;

	// Approver 4

	@FindBy(id = "MainContent_gvWholeComapny_ddlApp4_0")
	WebElement User4;

	@FindBy(id = "MainContent_gvWholeComapny_chk4_0")
	WebElement ChkLimit4;

	@FindBy(id = "MainContent_gvWholeComapny_txtAmt4_0")
	WebElement txtLimit4;
	
	@FindBy(id = "MainContent_gvWholeComapny_txtEmail4_0")
	WebElement txtEmail4;

	// Approver 5

	@FindBy(id = "MainContent_gvWholeComapny_ddlApp5_0")
	WebElement User5;

	@FindBy(id = "MainContent_gvWholeComapny_chk5_0")
	WebElement ChkLimit5;

	@FindBy(id = "MainContent_gvWholeComapny_txtAmt5_0")
	WebElement txtLimit5;
	
	@FindBy(id = "MainContent_gvWholeComapny_txtEmail5_0")
	WebElement txtEmail5;

	// Approver 6

	@FindBy(id = "MainContent_gvWholeComapny_ddlApp6_0")
	WebElement User6;
	
	@FindBy(id = "MainContent_gvWholeComapny_txtEmail6_0")
	WebElement txtEmail6;

	@FindBy(id = "btn_Insert")
	WebElement SaveBTN;

	@FindBy(id = "MainContent_rbOpt2")
	WebElement DeptLevelWorkflow;

	@FindBy(xpath = "//div[@class = 'sweet-alert showSweetAlert visible']//p")
	List<WebElement> WorkflowValidationMsg;
	
	public String ApproverLimitCannotBeEmpty = "'Create PO up to' value cannot be empty.";
	public String AproverSelectFromDLLMsg = "please select the approver from the dropdown and then proceed.";
	public String ApproverCanNotBeSameMsg = "Selected user cannot be same.";
	public String  ThankyouMsg = "Thank you! Your changes have been saved.";
//	public String ApprovalLimitCanntbeEmpty = "'Approval Limit $' value cannot be empty.";
	public String ApprovalLimitIncreaseMsg = "Please adjust the approval limit(s) to increase in value from one approver to the next.";
	public String ApprovalFinalLimitMsg = "Final approver(s) cannot have an approval limit.";
	public String InvalidEmailmsg = "Please enter a valid email address. (i.e. name@domain.com)";
	
	public void ByDefaultCheckOnDeptLevel() {
		Assert.assertEquals(DeptLevelWorkflow.isSelected(),true, "New Company Creation Workflow is by Defualt not selected at Departement level Workflow");
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

	public void SetWorkflowAccordingToTheUserCount(String UserQty) throws InterruptedException {
		if(UserQty.equals("1")) {
			Thread.sleep(2000);
			Select DD1 = new Select(User1);
			DD1.selectByVisibleText("Originator 01");
			Thread.sleep(2000);
		}
		else if(UserQty.equals("2")) {
			Thread.sleep(2000);
			Select DD1 = new Select(User1);
			DD1.selectByVisibleText("Originator 01");
			Thread.sleep(2000);
			ChkLimit1.click();
			Thread.sleep(6000);
			txtLimit1.sendKeys("100");
			
			Select DD2 = new Select(User2);
			DD2.selectByVisibleText("Approver 01");
			Thread.sleep(2000);
		}
		else if(UserQty.equals("3")) {
			Thread.sleep(2000);
			Select DD1 = new Select(User1);
			DD1.selectByVisibleText("Originator 01");
			Thread.sleep(2000);
			ChkLimit1.click();
			Thread.sleep(6000);
			txtLimit1.sendKeys("100");
			Thread.sleep(2000);
			
			Select DD2 = new Select(User2);
			DD2.selectByVisibleText("Approver 01");
			Thread.sleep(2000);
			ChkLimit2.click();
			Thread.sleep(6000);
			txtLimit2.sendKeys("200");
			Thread.sleep(2000);
			
			Select DD3 = new Select(User3);
			DD3.selectByVisibleText("Approver 02");
			Thread.sleep(2000);
		}
		else if(UserQty.equals("4")) {
			Thread.sleep(2000);
			Select DD1 = new Select(User1);
			DD1.selectByVisibleText("Originator 01");
			Thread.sleep(2000);
			ChkLimit1.click();
			Thread.sleep(6000);
			txtLimit1.sendKeys("100");
			Thread.sleep(2000);
			
			Select DD2 = new Select(User2);
			DD2.selectByVisibleText("Approver 01");
			Thread.sleep(2000);
			ChkLimit2.click();
			Thread.sleep(6000);
			txtLimit2.sendKeys("200");
			Thread.sleep(2000);
			
			Select DD3 = new Select(User3);
			DD3.selectByVisibleText("Approver 02");
			Thread.sleep(2000);
			ChkLimit3.click();
			Thread.sleep(6000);
			txtLimit3.sendKeys("300");
			Thread.sleep(2000);
			
			Select DD4 = new Select(User4);
			DD4.selectByVisibleText("Approver 03");
			Thread.sleep(2000);
		}
		else if(UserQty.equals("5")) {
			Thread.sleep(2000);
			Select DD1 = new Select(User1);
			DD1.selectByVisibleText("Originator 01");
			Thread.sleep(2000);
			ChkLimit1.click();
			Thread.sleep(6000);
			txtLimit1.sendKeys("100");
			Thread.sleep(2000);
			
			Select DD2 = new Select(User2);
			DD2.selectByVisibleText("Approver 01");
			Thread.sleep(2000);
			ChkLimit2.click();
			Thread.sleep(6000);
			txtLimit2.sendKeys("200");
			Thread.sleep(2000);
			
			Select DD3 = new Select(User3);
			DD3.selectByVisibleText("Approver 02");
			Thread.sleep(2000);
			ChkLimit3.click();
			Thread.sleep(6000);
			txtLimit3.sendKeys("300");
			Thread.sleep(2000);
			
			Select DD4 = new Select(User4);
			DD4.selectByVisibleText("Approver 03");
			Thread.sleep(2000);
			ChkLimit4.click();
			Thread.sleep(6000);
			txtLimit4.sendKeys("400");
			Thread.sleep(2000);
			
			Select DD5 = new Select(User5);
			DD5.selectByVisibleText("Approver 04");
			Thread.sleep(2000);
		}
		else if(UserQty.equals("6")) {
			Thread.sleep(2000);
			Select DD1 = new Select(User1);
			DD1.selectByVisibleText("Originator 01");
			Thread.sleep(2000);
			ChkLimit1.click();
			Thread.sleep(6000);
			txtLimit1.sendKeys("100");
			Thread.sleep(2000);
			
			Select DD2 = new Select(User2);
			DD2.selectByVisibleText("Approver 01");
			Thread.sleep(2000);
			ChkLimit2.click();
			Thread.sleep(6000);
			txtLimit2.sendKeys("200");
			Thread.sleep(2000);
			
			Select DD3 = new Select(User3);
			DD3.selectByVisibleText("Approver 02");
			Thread.sleep(2000);
			ChkLimit3.click();
			Thread.sleep(6000);
			txtLimit3.sendKeys("300");
			Thread.sleep(2000);
			
			Select DD4 = new Select(User4);
			DD4.selectByVisibleText("Approver 03");
			Thread.sleep(2000);
			ChkLimit4.click();
			Thread.sleep(6000);
			txtLimit4.sendKeys("400");
			Thread.sleep(2000);
			
			Select DD5 = new Select(User5);
			DD5.selectByVisibleText("Approver 04");
			Thread.sleep(2000);
			ChkLimit5.click();
			Thread.sleep(6000);
			txtLimit5.sendKeys("500");
			Thread.sleep(2000);
			
			Select DD6 = new Select(User6);
			DD6.selectByVisibleText("Approver 05");
			Thread.sleep(2000);
		}
		SaveBTN();
		WorkflowValidationPopupVerification(ThankyouMsg);
	}
	
	

	
	
}