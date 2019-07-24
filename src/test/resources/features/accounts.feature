Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I click Profiles
    And I click Accounts
    And I click Create Account
    And I create new account "AccountToDelete101"

  Scenario: Delete Account
    When I click Profiles
    And I click Accounts
    And I click manageAccount button "AccountToDelete101"
    And I click Setting
    And I click Delete link
    Then I validate account "AccountToDelete101" was deleted
    And I validate account "AccountToDelete101" is not listed
    And I validate account "AccountToDelete101" is not listed in new project
    And I validate account "AccountToDelete101" is not listed in project settings
