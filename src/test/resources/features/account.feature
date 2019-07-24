Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I go to accounts
    And I create account "Account To Delete"
    And I go to dashboard
    And I click the new project button
    And I create the project with:
      | name    | Test     |
      | account | account1 |
      | privacy | public   |

  Scenario: Delete Account
    When I go to accounts
    And I manage account "Account To Delete"
    And I delete this account and notice "Account To Delete was successfully deleted." is displayed
    And I go to accounts
    Then I validate account "Account To Delete" is not displayed
    And I go to dashboard
    And I validate account "Account To Delete" is not displayed in create project dropdown
    And I validate account "Account To Delete" is not displayed in project "Test" settings
