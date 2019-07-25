Feature: Projects

  Background:
    Given I sign in as "owner"

  Scenario: Create Project
    When I click the new project button
    And I create the project with:
      | name    | MyProject278 |
      | account |  TestAccount1564029940678     |
      | privacy | public      |
    Then I validate the project label is "MyProject278"

  Scenario: Create Project
    When I click the new project button
    And I create the project with new account:
      | name    | MyProject279 |
      | account | account10    |
      | privacy | public      |
    Then I validate the project label is "MyProject279"
