Feature: Projects

  Background:
    Given I sign in as "owner"

  Scenario: Create Project
    When I click the new project button
    And I create the project with:
      | name    | My_Project  |
      | account | account1    |
      | privacy | public      |
    Then I validate the project label is "My_Project"
