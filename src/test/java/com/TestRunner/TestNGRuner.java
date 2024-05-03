package com.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="C:\\eRequisition_Latest_Script\\eReqMultiReqRoutingTRXTXOSTD\\src\\test\\resource\\FeatureFile",
glue= {"AppHooks","UIScreen","LoginWithTheAdminAndApplyTheChanges","ImportAccountifStandalone","OriginatorMultiReqRouting","Approver01MultiReqRouting","Approver02MultiReqRouting","Approver03MultiReqRouting","Approver04MultiReqRouting","Approver05MultiReqRouting","AdminReqRoutingDataVerification"},
monochrome = true,
plugin = {"pretty",  "json:target/cucumber/report.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
//,tags = "@GettingTheDataBeforeStarttheTesting or @UserManagementWorkflowSetUserCreationAndItemVendorCustomerCreation or @OriginatorRequisitionRouting or @Approver01equisitionRouting or @AfterTheCompleteRoutingofReqThenVerifytheReqDataOnHistoryPage"
)
public class TestNGRuner extends AbstractTestNGCucumberTests{
} 

