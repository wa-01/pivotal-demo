Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I click Profiles
    And I click Accounts
    And I click Create Account
    And I create new account "account"

  Scenario: Delete Account
    When I click Profiles
    And I click Accounts
    And I click manageAccount button "account"
    And I click Setting
    And I click Delete link
    Then I validate account "account" was deleted
    And I validate account "account" is not listed
    And I validate account "account" is not listed in new project
    And I validate account "account" is not listed in project settings
