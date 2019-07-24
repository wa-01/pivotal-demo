Feature: Accounts

  Background:
    Given I sign in as "owner"
      And I click the profile dropdown
      And I select Accounts
      And I click the "Create Account" button
      And I create the Account with:
        | accountName | TestAccount|
      And I go to the "Accounts" page

    Scenario:
    When I click "TestAccount" "manage account" button
      And I click the "settings" tab
      And I click the "delete this account" option
      And I accept the delete alert
    Then I validate "TestAccount" account is not available in accounts list
      And I validate "TestAccount" account "message was deleted" is displayed
      And I select a project
      And I select the "More" tab
      And I validate "TestAccount" account is not available in "Project Settings" dropdown
      And I click the header Project dropdown
      And I click the "Create Project" option
      And I validate "TestAccount" account is not available in "Create a new project" account dropdown


