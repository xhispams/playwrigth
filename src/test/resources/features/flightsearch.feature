# src/test/resources/features/flightSearch.feature
Feature: Flight search
  Scenario Outline: Search for flights
    Given I am on the Blazedemo homepage
    When I select "<departureCity>" as the departure city
    And I select "<destinationCity>" as the destination city
    And I click on find flights
    Then I should see a list of available flights
    Examples:
      | departureCity | destinationCity |
      | Paris         | London          |
      | Boston        | Berlin          |
      | San Diego     | Buenos Aires    |