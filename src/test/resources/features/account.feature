Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I create an account with :
      |AccountName    | AccountTest |
      |Owner    | default |

  Scenario: Delete an account
    When  I select the tab "Settings"
    And I click on delete account
    Then I validate the account with name "AccountTest" is not present in account list
    And I validate that account with name "AccountTest" is not present in new project form