Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I click the "Accounts" item in the profile menu
    And I click the create account button
    And I add a new account with name "AccountToDelete"

  Scenario: Delete Account
    When I click the "Settings" tab
    And I click the delete account link and confirm with "OK"
    Then I validate the notice "AccountToDelete was successfully deleted." is displayed
    And I validate the "AccountToDelete" is not listed in the accounts page