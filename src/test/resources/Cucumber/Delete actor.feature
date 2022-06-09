Feature: Deleting an actor
  As a user I would like to delete an actor from the database

  Scenario: I successfully deleted an actor
    Given I have the actors ID
    When I input the actor ID
    Then the actor will be added to the database