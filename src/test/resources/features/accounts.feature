Feature: Accounts

  Background:
    Given I sign in as "emelyllanos" user and "Control123"
    And I click Profiles
    And I click Accounts
    And I click Create Account
    And I create new account "AccountToDelete1"

  Scenario: Delete Account
    When I click Profiles
    And I click Accounts
    When I click manageAccount button "AccountToDelete1"
    And I click Delete link
    And I click ENTER key
    Then I validate the account "AccountToDelete" is not listed
