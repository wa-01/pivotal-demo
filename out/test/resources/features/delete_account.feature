Feature: Account

  Background:
    Given I sign in as "owner"
    And I Create an Account "XXXGP"

  Scenario: Delete Account
    When I Delete the Account "XXXGP"
    Then I validate "XXXGP" account was successfully deleted message is displayed
    Then I validate "XXXGP" account is not displayed in Accounts menu




