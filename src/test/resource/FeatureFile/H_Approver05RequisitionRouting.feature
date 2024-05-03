@Approver05equisitionRouting
Feature: Approver 05 Requisition Routing
  In This Feature File we will Approve, Reject and Withdraw and Submit some Requisition and Verification of the Approver 05 Limits

  @Approver05MultipleRequisitionRouting
  Scenario: Verification of the Req which is Sent by the Approved by the Approver 04 and perform the action with respect to the Requisition No
  Given Open the eRequisition Application
  Then Enter the login Credentials of Approver O5
  When User is on Home Page
  #Req No 8 Originator -> APR 01 -> APR 02 -> APR 03 -> APR 04 -> APR 05 Create PO
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O8
  Then Open the ReqNo O8
  Then Verify that the Vendor O8 and Customer O8 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O8
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O8
  Then verify that the Create PO Button is appearing with respect to the ReqNo O8
  Then Create a PO with respect to the ReqNo O8
  #Req No 9 Originator -> APR 01 -> APR 02 -> APR 03 -> APR 04 -> APR 05 Reject Req
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O9
  Then Open the ReqNo O9
  Then Verify that the Vendor O9 and Customer O9 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O9
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O9
  Then verify that the Create PO Button is appearing with respect to the ReqNo O9
  Then Reject the Req with respect to the ReqNo O9