Feature: Accounts

  Background:
    Given I sign in as "owner"

  Scenario: Create Account
    When I create a new account called "AccountLizzyTest"
    Then I should see the "AccountLizzyTest" label
