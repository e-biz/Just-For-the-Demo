@Approver03equisitionRouting
Feature: Approver 03 Requisition Routing
  In This Feature File we will Approve, Reject and Withdraw and Submit some Requisition and Verification of the Approver 02 Limits

  @Approver03MultipleRequisitionRouting
  Scenario: Verification of the Req which is Sent by the Approved by the Approver 02 and perform the action with respect to the Requisition No
  Given Open the eRequisition Application
  Then Enter the login Credentials of Approver O3
  When User is on Home Page
  #Req No 4 Originator -> Approver 01 -> Approver 02 -> Approver 03 Create PO
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O4
  Then Open the ReqNo O4
  Then Verify that the Vendor O4 and Customer O4 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O4
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O4
  Then verify that the Create PO Button is appearing with respect to the ReqNo O4
  Then Create a PO with respect to the ReqNo O4
  #Req No 5 Originator -> Approver 01 -> Approver 02 -> Approver 03 Cancelled Req
   Then Verify the Data with respect to the each column of the Home page according to the ReqNo O5
  Then Open the ReqNo O5
  Then Verify that the Vendor O5 and Customer O5 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O5
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O5
  Then Cancelled the Req with respect to the ReqNo O5
  #Req No 6 Originator -> Approver 01 -> Approver 02 -> Approver 03 -> Approver 04 Rejected Req
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O6
  Then Open the ReqNo O6
  Then Verify that the Vendor O6 and Customer O6 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O6
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O6
  Then verify that the Approve Button is appearing with respect to the ReqNo O6
  Then Approve the Req with respect to the ReqNo O6 for Approver O3
  #Req No 7 Originator -> Approver 01 -> Approver 02 -> Approver 03 -> Approver 04 Create PO
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O7
  Then Open the ReqNo O7
  Then Verify that the Vendor O7 and Customer O7 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O7
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O7
  Then verify that the Approve Button is appearing with respect to the ReqNo O7
  Then Approve the Req with respect to the ReqNo O7 for Approver O3
  #Req No 8 Originator -> APR 01 -> APR 02 -> APR 03 -> APR 04 -> APR 05 Create PO
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O8
  Then Open the ReqNo O8
  Then Verify that the Vendor O8 and Customer O8 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O8
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O8
  Then verify that the Approve Button is appearing with respect to the ReqNo O8
  Then Approve the Req with respect to the ReqNo O8 for Approver O3
  #Req No 9 Originator -> APR 01 -> APR 02 -> APR 03 -> APR 04 -> APR 05 Reject Req
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O9
  Then Open the ReqNo O9
  Then Verify that the Vendor O9 and Customer O9 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O9
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O9
  Then verify that the Approve Button is appearing with respect to the ReqNo O9
  Then Approve the Req with respect to the ReqNo O9 for Approver O3
  #Req 11 -> Approver 02 -> Approver 03 Create PO
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo 11
  Then Open the ReqNo 11
  Then Verify that the Vendor O9 and Customer O9 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo 11
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo 11
  Then verify that the Create PO Button is appearing with respect to the ReqNo 11
  Then Create a PO Req with respect to the ReqNo 11