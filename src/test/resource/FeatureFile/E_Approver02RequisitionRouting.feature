@Approver02equisitionRouting
Feature: Approver 02 Requisition Routing
  In This Feature File we will Approve, Reject and Withdraw and Submit some Requisition and Verification of the Approver 02 Limits

  @Approver02MultipleRequisitionRouting
  Scenario: Verification of the Req which is Sent by the Approved by the Approver 01 and perform the action with respect to the Requisition No
  Given Open the eRequisition Application
  Then Enter the login Credentials of Approver O2
  When User is on Home Page
  #Req Req 2 Originator -> Approver 01 -> Approver 02 Create PO
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O2
  Then Open the ReqNo O2
  Then Verify that the Vendor O2 and Customer O2 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O2
  Then verify that the Create PO Button is appearing with respect to the ReqNo O2
  Then Create the PO with respect to the ReqNo O2
  #Req No 3 Originator -> Approver 01 -> Approver 02 Reject Req
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O3
  Then Open the ReqNo O3
  Then Verify that the Vendor O3 and Customer O3 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O3
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O3
  Then Reject the Req with respect to the ReqNo O3
  #Req No 4 Originator -> Approver 01 -> Approver 02 -> Approver 03 Create P
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O4
  Then Open the ReqNo O4
  Then Verify that the Vendor O4 and Customer O4 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O4
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O4
  Then verify that the Approve Button is appearing with respect to the ReqNo O4
  Then Approve the Req with respect to the ReqNo O4 for Approver O2
  #Req No 5 Originator -> Approver 01 -> Approver 02 -> Approver 03 Cancelled Req
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O5
  Then Open the ReqNo O5
  Then Verify that the Vendor O5 and Customer O5 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O5
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O5
  Then verify that the Approve Button is appearing with respect to the ReqNo O5
  Then Approve the Req with respect to the ReqNo O5 for Approver O2
  #Req No 6 Originator -> Approver 01 -> Approver 02 -> Approver 03 -> Approver 04 Rejected Req
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O6
  Then Open the ReqNo O6
  Then Verify that the Vendor O6 and Customer O6 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O6
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O6
  Then verify that the Approve Button is appearing with respect to the ReqNo O6
  Then Approve the Req with respect to the ReqNo O6 for Approver O2
  #Req No 7 Originator -> Approver 01 -> Approver 02 -> Approver 03 -> Approver 04 Create PO
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O7
  Then Open the ReqNo O7
  Then Verify that the Vendor O7 and Customer O7 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O7
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O7
  Then verify that the Approve Button is appearing with respect to the ReqNo O7
  Then Approve the Req with respect to the ReqNo O7 for Approver O2
  #Req No 8 Originator -> APR 01 -> APR 02 -> APR 03 -> APR 04 -> APR 05 Create PO
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O8
  Then Open the ReqNo O8
  Then Verify that the Vendor O8 and Customer O8 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O8
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O8
  Then verify that the Approve Button is appearing with respect to the ReqNo O8
  Then Approve the Req with respect to the ReqNo O8 for Approver O2
  #Req No 9 Originator -> APR 01 -> APR 02 -> APR 03 -> APR 04 -> APR 05 Reject Req
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O9
  Then Open the ReqNo O9
  Then Verify that the Vendor O9 and Customer O9 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O9
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O9
  Then verify that the Approve Button is appearing with respect to the ReqNo O9
  Then Approve the Req with respect to the ReqNo O9 for Approver O2
  #Now Verify that the Approver O1 Approve and PO button verification
  When User Open the eReq page
  Then Select the Vendor and Customer
  Then Select Some Items
  Then Change in ammount above 3OO and verify that the Approve button will appeared
  Then again change the amount less than 3OO and verify that the Create PO button is appearing
 	Then again change the amount and Submit the Req to Approver O3
  