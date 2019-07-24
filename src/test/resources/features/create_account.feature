Feature: Accounts

  Background:
    Given I sign in as "owner"

  Scenario: Create Account
    When I create a new account called "AccountTest"
    Then I should see the "AccountTest" label
