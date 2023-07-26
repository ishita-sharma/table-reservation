Feature: Enroll a new restaurant and add tables to an existing restaurant

  Scenario: a new restaurant is enrolled successfully and add tables

    Given a restaurant name Mini's restaurant, category TAKE_AWAY and cuisine INDIAN

    When a POST request is sent to endpoint restaurants
    Then a new restaurant is enrolled

    And  a POST request is sent to endpoint tables
    Then tables are successfully added

