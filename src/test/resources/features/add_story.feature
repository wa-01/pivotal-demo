Feature: Stories

  Background:
    Given I sign in as "owner"
    And I click the new project button
    And I create the project with:
      | name    | MyProject28 |
      | account | account1    |
      | privacy | public      |

  Scenario: Add story
    When I click the add story button on "icebox" panel
    And I add the story with:
      | title       | new Story               |
      | story_type  | feature                 |
      | points      | 3                       |
      | blockers    | blocker sample          |
      | description | This is a description   |
      | labels      | label sample            |
      | tasks       | this is a sample task   |
      | comment     | ths is a sample comment |
    Then I validate the story label is "new Story"
