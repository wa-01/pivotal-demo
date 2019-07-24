Feature: Delete account

  Background:
    Given I sign in as "owner"
    When I click the new project button
    And I create the project with:
      | name    | MyProject27 |
      | account | edgar2    |
      | privacy | public      |
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
    And account "AccountTest01" is not present in the Accounts list
    And account "AccountTest01" is not listed on create project dropdown
#    And account "AccountTest01" is not displayed on the project dropdown settings.

