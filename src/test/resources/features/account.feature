Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I click profile dropdown button
    And I navigate to accounts
    And I create account "Account To Delete"

  Scenario: Delete Account
    #When I click profile dropdown button
    #And I navigate to accounts
    #And I manage account "Account To Delete"
    And I click "Settings" accounts tab
    And I click delete this account
    Then I validate notice "Account To Delete was successfully deleted." is displayed