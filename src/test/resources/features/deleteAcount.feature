Feature: Delete an account
  Background:
    Given I sign in as "owner"

  Scenario: Delete an account
    Given I click Profile dropdown list
    And I click Accounts
    And I create an account with name "My Account"
    When I click "Settings" tab
    And I click delete this account
    Then I validate the "My Account" is displayed in deleted account message
    And I validate the "My Account" is no longer visible from accounts menu
    And I validate the "My Account" is not visible from create project form