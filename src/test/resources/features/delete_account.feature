Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I click the new project button
    And I create the project with:
      | name    | MyProjectlfc|
      | account | account1    |
      | privacy | public      |
    And I create an account with "lfcaccount" as name

  Scenario: Delete Account
    When I click the manage option of the "lfcaccount"
    And I click settings option in the account manage
    And I click delete account link in the account manage panel
    Then I verify the delete notification is displayed
    And I click accept delete account button
    Then I verify the account named as "lfcaccount" is not found in account panel
    And I go to the dashboard
    And I search the project "MyProjectlfc" in the dashboard
    And I click project settings button of the "MyProjectlfc" project
    Then I verify the account "lfcaccount" is not listed into the project settings
    And I go to the dashboard
    And I click the new project button
    Then I verify the account named as "lfcaccount" is not found in account selection

