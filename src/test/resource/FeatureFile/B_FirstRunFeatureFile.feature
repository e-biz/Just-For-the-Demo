@UserManagementWorkflowSetUserCreationAndItemVendorCustomerCreation
Feature: Test the User Management Page Permissions of Req
  I want to Test all the UserManagment permissions Rights

  @FirstRunAndLoginWithTheAdminandCheckthatallTheRemainingUsersareThereIfNotThenCreatethatUsers
  Scenario: First Run and Login With The Admin and Check that all The Remaining Users are There If Not then Create that Users
    Given Open the TRX application and Login with the Adminsitrator
    #Then Go to the User Management Page
    #And Check that the user is exist if not create that user
    #Then How many user want to ADD in Workflow
      #| Users |
      #|     6 |
    #Then open the import data page
    #Then click on import data button and Submit Account file and Verify the Results and Error and successful popup msg
      #| DirectoryURLofImportAmount                                                                    | SuccessfullyLineItemsResults | HardSleepforFileUpload | HardSleepAfterSubmitButtonClick |
      #| \eReqMultiReqRoutingTRXTXOSTD\Import_Valid_Data_with_5_lines\Account_Template.xlsx         |                            5 |                   5000 |                            3000 |
    Then open requisition page
    Then create vendor customer and item and save it as a draft requisition