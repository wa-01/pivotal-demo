Feature: Delete account

  Background:
    Given I sign in as "owner"
    When I click in the profile dropdown button
    And click on the Accounts link
    And click on Create Account button
    And I create the account with name:
      |eedgarTest01|

  Scenario: Delete Account
    When I click the account Settings
    And I click on  delete this account link
    And I accept the pop up
    Then I validate the message is "eedgarTest01 was successfully deleted."
    And account "eedgarTest01" is not present in the Accounts list
    And I open the Dashboard
    And I click the new project button
    And account "eedgarTest01" is not listed on create project dropdown
    And I go to the Dashboard
    And I click the new project button
    And I create the project with:
      | name    | EDaProjectA |
      | account | lehsim    |
      | privacy | public      |
    And I click the more tab in projects page
    And account "eedgarTest01" is not displayed on the project dropdown settings.

