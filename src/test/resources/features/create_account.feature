Feature: Accounts

  Background:
    Given I sign in as "owner"

  Scenario: Create Account
    When I click my username menu
    And I click "accounts" menu link
    And I click the create account button
    And I enter the account name "AccountTest"
    And I click create button
    Then I validate the account label is "AccountTest"
