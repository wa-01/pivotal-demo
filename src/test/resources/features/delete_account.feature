Feature: Account

  Background:
    Given I sign in as "owner"
    And I Create an Account "XXX"

  Scenario: Delete Account
    When I Delete the Account "XXX"
    Then I validate "XXX" account was successfully deleted message is displayed
    Then I validate "XXX" account is not displayed in Accounts menu




