Feature: Projects

  Scenario: Create Project
    Given I sign in as "Carledriss" user and "P@ssw0rd"
    When I click the new project button
    And I create the project with:
      | name    | MyProject27 |
      | account | account1    |
      | privacy | public      |
    Then I validate the project label is "MyProject27"
