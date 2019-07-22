Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I create an account with :
      |AccountName    | Account1 |

  Scenario: Delete an account
    When I go to manage settings
    And I delete the account with:
      |AccountName    | Account1 |
    Then I validate the account with name "Account1" is not present in account list
    And I validate that acount with name "Account1" is not present in new project form