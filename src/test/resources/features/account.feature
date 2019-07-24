Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I create an account with :
      |AccountName    | AccountTest |
      |Owner    | default |
    And I capture accountID
    And In ManageAccountPage select the tab "Projects"
    And I create project from account manage page with "ProjectAccountTest"

  Scenario: Delete an account
    When I go to accounts page
    And  I go to manage account page according to accountID
    And  In ManageAccountPage select the tab "Settings"
    And I click on delete account
    Then I validate that the message "AccountTest was successfully deleted." is displayed
    And I validate the account with accountID is not present in account list
    And I validate that account with name "AccountTest" is not in project form
    And I validate that account with accountID is not present in project settings "MyProject"
