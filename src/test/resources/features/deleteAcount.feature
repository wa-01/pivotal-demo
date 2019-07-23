Feature: Delete an account
  Background:
    Given I sign in as "owner"

  Scenario: Delete an empty account
    Given I click Profile dropdown list
    And I click Accounts
    And I create an account with name "My Account"
    #When I click manage account button
    And I click "Settings" tab
    And I click delete this account
    Then I validate the "My Account" is displayed in deleted account message
    And I validate the "My Account" is no longer visible from accounts menu
    And I validate the "My Account" is not visible from create project form
    And I validate the "My Account" is not visible from change account in project form