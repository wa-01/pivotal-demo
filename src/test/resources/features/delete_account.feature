Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I click in the profile dropdown
    And I click on the Accounts link
    And I click on Create Account button
    And I create the account with: "MagaliAccount"

  Scenario: Delete Account
    When I click in Settings
    And I click in delete this account link
    And I accept the popup
    Then I validate the message is "MagaliAccount was successfully deleted."
    And I validate the "MagaliAccount" is not displayed in the Accounts list
    And I go to the Dashboard
    And I click the new project button
    And I validate the "MagaliAccount" account is not displayed in the dropdown
    And I go to the Dashboard
    And I click the new project button
    And I create the project with:
      | name    | MagaliProject |
      | account | account1          |
    And I click the "More" tab in projects page
    And I validate the "MagaliAccount" account is not displayed in the change account dropdown.


