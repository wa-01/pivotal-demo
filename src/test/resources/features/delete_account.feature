Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I click in the profile dropdown
    And click on the Accounts link
    And click on Create Account button
    And I create the account with: "Magali"

  Scenario: Delete Account
    When click in Settings
    And click in delete this account link
    Then I validate the message is displayed "Magali was successfully deleted."
    And the account "Magali" is not present in Accounts
