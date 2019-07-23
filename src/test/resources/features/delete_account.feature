Feature: Delete account

  Background:
    Given I sign in as "owner"
    When I click in the profile dropdown button
    And click on the Accounts link
    And click on Create Account button
    And I create the account with name:
      |AccountTest01|

  Scenario: Delete Account
    When I click the account Settings
    And I click on  delete this account link
    And I accept the pop up
    Then I validate the message is "AccountTest01 was successfully deleted."