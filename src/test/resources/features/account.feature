Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I create an account with :
      |AccountName    | AccountTest |
      |Owner    | default |

  Scenario: Delete an account
    When I go to manage settings
    And I delete the account with:
      |AccountName    | AccountTest |
    Then I validate the account with name "AccountTest" is not present in account list
    And I validate that acount with name "AccountTest" is not present in new project form