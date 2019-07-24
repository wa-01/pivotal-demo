Feature: Delete an account
  Background:
    Given I login
    And I have a project created
    And I have an account created

  Scenario: Delete an account
    When I open the account settings
    And I delete the account
    Then I see the confirmation message
    But I don't see the account in the accounts menu
    But I don't see the account in the create project form
    But I don't see the account in project settings