Feature: Delete Account

  Background:
    Given I sign in as "owner"
    And I create a new Account with name "test_delete_account"
    And I go to the Account Page

  Scenario: Delete an account
    When I click the "Manage Account" of account "test_delete_account"
    And I click on "Settings" navbar button
    And I click on "delete this account" button

    Then I validate the account "test_delete_account" is deleted on Accounts Page
    And I validate a notice message is displayed with the message "test_delete_account was successfully deleted."

