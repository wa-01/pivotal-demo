Feature: Accounts

  Background:
    Given I sign in as "owner"
      And I click the profile dropdown
      And I select Accounts
      And I click the Create Account button
      And I create the Account name:
        | accountName | TestAccount|
      And I go to the Accounts page

    Scenario:
    When I click "TestAccount" manage account button
      And I click the settings tab
      And I click delete this account
      And I accept delete alert
      And I validate "TestAccount" account is deleted
      And I validate "TestAccount" account message was deleted is displayed
      And I validate "TestAccount" account is not available in project setting dropdown
      And I validate "TestAccount" account is not available in create project dropdown











