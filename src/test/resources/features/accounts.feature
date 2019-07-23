Feature: Accounts

  Background:
    Given I sign in as "emelyllanos" user and "Control123"
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
    Then I validate the account "AccountToDelete101" was deleted
