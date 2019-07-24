Feature: Accounts

  Background:
    Given I sign in as "owner"
    And I go to accounts
    And I create account "TesT Account"

  Scenario: Delete Account
    When I delete this account and notice "TesT Account was successfully deleted." is displayed
    And I go to accounts
    Then I validate account "TesT Account" is not displayed
    And I go to dashboard
    And I validate account "TesT Account" is not displayed in create project dropdown
    And I validate account "TesT Account" is not displayed in project "MyProject" settings
