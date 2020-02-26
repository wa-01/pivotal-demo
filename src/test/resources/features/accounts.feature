Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I click Profiles
    And I click Accounts
    And I click Create Account
    And I create new account "accountToDelete"

  Scenario: Delete Account
    When I click Profiles
    And I click Accounts
    And I click manageAccount button "accountToDelete"
    And I click Setting
    And I click Delete link
    Then I validate account "accountToDelete" was deleted
    And I validate account "accountToDelete" is not listed
    And I validate account "accountToDelete" is not listed in new project
    And I validate account "accountToDelete" is not listed in project settings
