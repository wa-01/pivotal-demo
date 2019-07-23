Feature: Accounts

  Background:
    Given I sign in as "owner"

  Scenario: Create Account
    When I click in the profile dropdown
    And click on the Accounts link
    And click on Create Account button
    And I create the account with:
      |Magali|
#    Then I validate the Account name is "Magali"


