Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I create an account with "account1" as name

  Scenario: Delete Account
    When I click the manage option of the "account1"
    And I click settings option
    And I delete the account
    Then I verify the account named as "account1" is not found