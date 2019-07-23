Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I click profile dropdown button
    And I navigate to accounts
    And I create account "Account To Delete"

  Scenario: Delete Account
    And I click "Settings" accounts tab
    And I click delete this account
    Then I validate notice "Account To Delete was successfully deleted." is displayed
    When I click profile dropdown button
    And I navigate to accounts
    Then I validate account "Account To Delete" is not displayed
    When I go to dashboard
    And I click the new project button
    Then I verify account "Account To Delete" is not displayed in dropdown

