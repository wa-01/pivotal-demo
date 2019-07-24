Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I create an account with :
      |AccountName    | AccountTest |
      |Owner    | default |
    And I capture accountID
  Scenario: Delete an account
    When  In ManageAccountPage select the tab "Settings"
    And I click on delete account
    Then I validate that the message "AccountTest was successfully deleted." is displayed
    And I validate the account with accountID is not present in account list
    And I validate that account with name "AccountTest" is not in project form
    And I click the new project button
    And I create the project with:
      | name    | AuxiliaryProject |
      | account | Test   |
      | privacy | public      |
    And I validate that account with accountID is not present in project settings "AuxiliaryProject"
