Feature: Projects

  Background:
    Given I sign in as "owner"

  Scenario: Create Project
    When I click the new project button
    And I create the project with:
      | name    | MyProject27 |
      | account | account1    |
      | privacy | public      |
    Then I validate the project label is "MyProject27"
