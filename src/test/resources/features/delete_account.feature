Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I click in the profile dropdown
    And click on the Accounts link
    And click on Create Account button
    And I create the account with: "MagaliAccount"

  Scenario: Delete Account
    When click in Settings
    And click in delete this account link
    Then I validate the message is displayed "MagaliAccount was successfully deleted."
    And the account "MagaliAccount" is not present in Accounts
    And the account "MagaliAccount" is not visible when new project is created
    And the account "MagaliAccount" is not visible on project settings of new project created
      | name    | MagaliProject |
      | account | account1    |
      | privacy | public      |

