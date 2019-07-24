Feature: Delete an account
  Background:
    Given I sign in as "owner"
    And I click the new project button
    And I create the project with:
      | name    | My_Project  |
      | account | account1    |
      | privacy | public      |
    And I go to Accounts menu
    And I click create account button
    And I create the account with name "My Account"

  Scenario: Delete an account
    When I go to Accounts menu
    And I open the account "My Account"
    And I go to "Settings" tab
    And I delete the account
    Then I see the confirmation message with the account "My Account"
    But I don't see the account "My Account" in the accounts menu
    And I go to dashboard
    And I click the new project button
    And I expand account droplist
    But I don't see the account "My Account" in the create project form
    And I open the project "My_Project"
    And I click "MORE" tab menu
    But I don't see the account "My Account" in project settings
