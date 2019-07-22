Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I click my username menu
    And I click "accounts" menu link
    And I click the create account button
    And I enter the account name "AccountTest"
    And I click create button

  Scenario: Delete Account
    When I click the "Settings" tab button
    And I click the "delete this account" link
    And I click the OK button to confirm
    Then I validate the confirmation label is "AccountTest was successfully deleted"