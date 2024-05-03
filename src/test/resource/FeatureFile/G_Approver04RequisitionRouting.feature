@Approver04equisitionRouting
Feature: Approver 04 Requisition Routing
  In This Feature File we will Approve, Reject and Withdraw and Submit some Requisition and Verification of the Approver 04 Limits

  @Approver03MultipleRequisitionRouting
  Scenario: Verification of the Req which is Sent by the Approved by the Approver 03 and perform the action with respect to the Requisition No
  Given Open the eRequisition Application
  Then Enter the login Credentials of Approver O4
  When User is on Home Page
  #Req No 6 Originator -> Approver 01 -> Approver 02 -> Approver 03 -> Approver 04 Rejected Req
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O6
  Then Open the ReqNo O6
  Then Verify that the Vendor O6 and Customer O6 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O6
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O6
  Then Reject the Req with respect to the ReqNo O6
  #Req No 7 Originator -> Approver 01 -> Approver 02 -> Approver 03 -> Approver 04 Create PO
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O7
  Then Open the ReqNo O7
  Then Verify that the Vendor O7 and Customer O7 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O7
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O7
  Then Create a PO with respect to the ReqNo O7
  #Req No 8 Originator -> APR 01 -> APR 02 -> APR 03 -> APR 04 -> APR 05 Create PO
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O8
  Then Open the ReqNo O8
  Then Verify that the Vendor O8 and Customer O8 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O8
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O8
  Then verify that the Approve Button is appearing with respect to the ReqNo O8
  Then Approve the Req with respect to the ReqNo O8 for Approver O4
  #Req No 9 Originator -> APR 01 -> APR 02 -> APR 03 -> APR 04 -> APR 05 Reject Req
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O9
  Then Open the ReqNo O9
  Then Verify that the Vendor O9 and Customer O9 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O9
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O9
  Then verify that the Approve Button is appearing with respect to the ReqNo O9
  Then Approve the Req with respect to the ReqNo O9 for Approver O4