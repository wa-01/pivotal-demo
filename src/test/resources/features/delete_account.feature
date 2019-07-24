Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I click on Accounts
    When I click new account button
    And I create "RPFH account" account
    Then I validate the account name is "RPFH account"


  Scenario: Delete Account
    When I click settings tab
    And I click delete link
    Then I validate the "RPFH account" is not displayed
    And I validate a delete "RPFH account" message is displayed
    And I validate "RPFH account" is not displayed on create project form
    And I validate "RPFH account" is not displayed on "TestProject" more tab