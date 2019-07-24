Feature: Delete Account

  Background:
    Given I sign in as "owner"
    And I create a new Account with name "test_delete_account"
    And I go to the "accounts" page

  Scenario: Delete an account
    When I click on "Manage Account" button for account "test_delete_account"
    And I click on "settings" navbar button
    And I click on "delete this account" link

    Then I validate the account "test_delete_account" is deleted on Accounts Page
    And I validate a notice message is displayed with the message "test_delete_account was successfully deleted."
    And I validate "test_delete_account" is not present on create project form

