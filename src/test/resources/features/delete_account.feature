Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I click on Accounts

  Scenario: Create Account
    When I click new account button
    And I create "RPFH account" account
    Then I validate the account name is "RPFH account"


  Scenario: Delete Account
    When I click manage account button for "RPFH account" account
    And I click settings tab
    And I click delete link
    Then I validate the account name is "RPFH account" is not displayed
