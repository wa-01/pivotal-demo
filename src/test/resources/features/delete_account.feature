Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I create a new account called "AccountTest"
    And I should see the "AccountTest" label

  Scenario: Delete Account
    When I delete the account created
    Then I validate the message is "AccountTest was successfully deleted."
    And I validate the "AccountTest" account is not displayed in the accounts list
    And I validate the "AccountTest" account is not displayed in the dropdown list in create project
