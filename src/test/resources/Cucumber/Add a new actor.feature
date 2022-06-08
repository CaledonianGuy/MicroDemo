Feature: Adding a new actor
  As a user I would like to add a new actor into my table

  Scenario: I successfully add an actor into my table
    Given I have the actors information
    When I input the data into the database
    Then I get the success return string

#  Scenario: I do not have enough information
#    Given I have an actors first name
#    And I do not have their last name
#    When I try to add them into the database
#    Then I get an error message