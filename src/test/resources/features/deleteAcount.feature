Feature: Delete an account
  Background:
    Given I sign in as "owner"
    And I click the new project button
    And I create the project with:
      | name    | My Project Eval |
      | account | Untitled    |
      | privacy | public      |
    And I click Profile dropdown list
    And I click Accounts
    And I create an account with name "My Account"

  Scenario: Delete an account
    When I click "Settings" tab
    And I click delete this account
    Then I validate the "My Account" is displayed in deleted account message
    And I validate the "My Account" is no longer visible from accounts menu
    And I validate the "My Account" is not visible from create project form
    And I validate that the account "My Account" is not visible changing account from project "My Project Eval"