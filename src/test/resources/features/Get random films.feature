Feature: Get Random Films from API
  As a user I would like the API to return random movies

  Scenario Outline: Get a list of random movies
    Given I want a "<number>" of movies I would like found
    When I send the request
    Then The request return status code 200

    Examples:
      | number |
      | 3      |
      | 15     |
      | 1001   |

  Scenario Outline: Get a list of random movies by genre
    Given I want a "<number>" of movies I would like found
    And I want to find by "<genre>"
    When I send the request
    Then The request return status code 200

    Examples:
      | number | genre       |
      | 2      | Action      |
      | 3      | Animation   |
      | 4      | Children    |
      | 5      | Classics    |
      | 6      | Comedy      |
      | 7      | Documentary |
      | 8      | Drama       |
      | 9      | Family      |
      | 10     | Foreign     |
      | 1      | Games       |
      | 2      | Horror      |
      | 3      | Music       |
      | 4      | New         |
      | 5      | Sci-Fi      |
      | 6      | Sports      |
      | 7      | Travel      |

  Scenario Outline: Get a list of random movies by actor
    Given I want a "<number>" of movies I would like found
    And I want to find by "<actor_firstname>" "<actor_lastname>"
    When I send the request
    Then The request return status code 200

    Examples:
      | number | actor_firstname | actor_lastname |
      | 5      | PENELOPE        | GUINESS        |
      | 7      | KIRSTEN         | AKROYD         |
      | 9      | IAN             | TANDY          |
      | 11     | REESE           | WEST           |
      | 13     | JIM             | MOSTEL         |
      | 15     | UMA             | WOOD           |
      | 17     | MAE             | HOFFMAN        |
