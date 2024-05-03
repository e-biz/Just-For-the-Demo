@OriginatorRequisitionRouting
Feature: Originator Requisition Routing
  In This Feature File we will Creating a 10 Req and Submit the 09 Requisition to Approver 01 and Creating a 01 PO

  @originatorMultipleRequisitionRouting
  Scenario: Create a 10 Requisition and Submit that Req and Some PO Creation and Verification of The Data
  Given Open the eRequisition Application
  Then Enter the login Credentials of Originator
  Then Open the Requisition Page
  Then Creating a l0 Requisiton O9 will be Submitted to the Next Approver and last one will create a PO
  |RequisitionNo|
  |1|
  |2|
  |3|
  |4|
  |5|
  |6|
  |7|
  |8|
  |9|
  |10|
  Then Logout from the Application

  