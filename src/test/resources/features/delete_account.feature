Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I navigate to accounts manager
    And I create a new account "testAccount"

  Scenario: Delete account
    When I click in "Settings" tab
    And I click in delete this account
    And I confirm the deletion of the account
    Then I validate the account "testAccount" was successfully deleted