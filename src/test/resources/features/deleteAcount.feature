Feature: Delete an account
  Background:
    Given I sign in as "owner"
    And I click the new project button
    And I create the project with:
      | name    | My_Project  |
      | account | account1    |
      | privacy | public      |
    And I have an account created "My Account"

  Scenario: Delete an account
    When I open the account settings for "My Account"
    And I delete the account
    Then I see the confirmation message with the account "My Account"
    But I don't see the account "My Account" in the accounts menu
    But I don't see the account "My Account" in the create project form
    But I don't see the account "My Account" in project settings