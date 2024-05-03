@Approver01equisitionRouting
Feature: Approver 01 Requisition Routing
  In This Feature File we will Approve the 9 Requisition and Do a Verification of the APprover 01 Limit

  @Approver01MultipleRequisitionRouting
  Scenario: Verification of the Req which is Sent by the Originator and perform the action with respect to the Requisition No
  Given Open the eRequisition Application
  Then Enter the login Credentials of Approver O1
  When User is on Home Page
  #ReqNO 01 -> Create a PO
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O1
  Then Open the ReqNo O1
  Then Verify that the Vendor O1 and Customer O1 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O1
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O1
  Then verify that the PO Button is appearing with respect to the ReqNo O1
  Then create the PO with respect to the ReqNo O1
  #ReqNO 02 -> Approve a PO
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O2
  Then Open the ReqNo O2
  Then Verify that the Vendor O2 and Customer O2 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O2
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O2
  Then verify that the Approve Button is appearing with respect to the ReqNo O2
  Then Approve the Req with respect to the ReqNo O2
  #ReqNO 03 -> Approve a ReqNo 02
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O3
  Then Open the ReqNo O3
  Then Verify that the Vendor O3 and Customer O3 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O3
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O3
  Then verify that the Approve Button is appearing with respect to the ReqNo O3
  Then Approve the Req with respect to the ReqNo O3
  #ReqNO 04 -> Approve a PO
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O4
  Then Open the ReqNo O4
  Then Verify that the Vendor O4 and Customer O4 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O4
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O4
  Then verify that the Approve Button is appearing with respect to the ReqNo O4
  Then Approve the Req with respect to the ReqNo O4
  #ReqNO 05 -> Approve a PO
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O5
  Then Open the ReqNo O5
  Then Verify that the Vendor O5 and Customer O5 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O5
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O5
  Then verify that the Approve Button is appearing with respect to the ReqNo O5
  Then Approve the Req with respect to the ReqNo O5
  #ReqNO 06 -> Approve a PO
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O6
  Then Open the ReqNo O6
  Then Verify that the Vendor O6 and Customer O6 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O6
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O6
  Then verify that the Approve Button is appearing with respect to the ReqNo O6
  Then Approve the Req with respect to the ReqNo O6
  #ReqNO 07 -> Approve a PO
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O7
  Then Open the ReqNo O7
  Then Verify that the Vendor O7 and Customer O7 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O7
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O7
  Then verify that the Approve Button is appearing with respect to the ReqNo O7
  Then Approve the Req with respect to the ReqNo O7
  #ReqNO 08 -> Approve a PO
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O8
  Then Open the ReqNo O8
  Then Verify that the Vendor O8 and Customer O8 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O8
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O8
  #Then verify that the Approve Button is appearing with respect to the ReqNo O8
  Then Approve the Req with respect to the ReqNo O8
  #ReqNO 09 -> Approve a PO
  Then Verify the Data with respect to the each column of the Home page according to the ReqNo O9
  Then Open the ReqNo O9
  Then Verify that the Vendor O9 and Customer O9 Data is appearing Correctly
  Then Verify that the Item are appearing Correctly with respect to the ReqNo O9
  Then Verify that the ReqNo total amount is Displaying Correctly and other Data with respect to the ReqNo O9
  Then verify that the Approve Button is appearing with respect to the ReqNo O9
  Then Approve the Req with respect to the ReqNo O9 
  #Now Verify that the Approver O1 Approve and PO button verification
  When User Open the eReq page
  Then Select the Vendor and Customer
  Then Select Some Items
  Then Change in ammount above 2OO and verify that the Approve button will appeared
  Then again change the amount less than 2OO and verify that the Create PO button is appearing
 	Then Logout from the Application
  