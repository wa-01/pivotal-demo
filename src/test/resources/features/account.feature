Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I go to accounts
    And I create account "Account To Delete"

  Scenario: Delete Account
    Then I delete this account and notice "Account To Delete was successfully deleted." is displayed
    When I go to accounts
    Then I validate account "Account To Delete" is not displayed
    When I go to dashboard
    Then I verify account "Account To Delete" is not displayed in create project dropdown

