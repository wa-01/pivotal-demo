Feature: Projects

  Scenario: Create Project
    Given I sign in as "emelyllanos" user and "Control123"
    When I click the new project button
    And I set the project form
      | name    | MyProject100 |
      | account | account1    |
      | privacy | public      |
    Then I validate the project label is "MyProject100"
