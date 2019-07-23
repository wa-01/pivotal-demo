Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I click the "Accounts" item in the profile menu
    And I click the create account button
    And I add a new account with name "AccountToDelete"

  Scenario: Delete Account
    When I click the "Settings" tab
    And I click the delete account link and confirm with "OK"
    Then I validate the notice "AccountToDelete was successfully deleted." is displayed
    And I validate the "AccountToDelete" is not listed in the accounts page
    And I click Create Project button in the Pivotal Tracker dropdown
    And I validate the "AccountToDelete" is not in the account selector of Project Form
    And I create the project with:
      | name    | MyProject01 |
      | account | account1    |
      | privacy | public      |
    And I click the "More" tab in projects page
    And I validate the account "AccountToDelete" is not listed in the change account selector