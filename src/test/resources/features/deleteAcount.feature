Feature: Delete an account
  Background:
    Given I sign in as "??"

  Scenario: Delete an empty account
    And I create an account
    When I click manage account button
    And I click settins tab
    And I click delete this account
    Then I validate the deleted account message is displayed
    And I validate the account is no longer visible from accounts menu