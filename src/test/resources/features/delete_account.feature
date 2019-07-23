Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I create an account with "account_lfc" as name

  Scenario: Delete Account
    When I click the manage option of the "account_lfc"
    And I click settings option
    And I delete the account
    Then I verify the account named as "account_lfc" is not found