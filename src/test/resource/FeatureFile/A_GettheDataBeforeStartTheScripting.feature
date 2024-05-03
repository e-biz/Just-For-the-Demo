
@GettingTheDataBeforeStarttheTesting
Feature: The UI Screen is open which is the Data SUbmit Form where End User will input the data and then starting the Scripts
  I want to use this template for my feature file

  @OpenUIScreen
  Scenario: Getting the Data from the End User
    Given Open the UI Screen
    When Screen is Open Check user is submiting the Valid Data
    Then Check if user correctly Input the Data Closed the Form and Start running the Scripts