Feature: Enroll a new restaurant

  Scenario: a new restaurant is enrolled successfully

    Given a restaurant name Mini's restaurant, category TAKE_AWAY and cuisine INDIAN

    When a POST request is sent to endpoint restaurants

    Then a new restaurant is enrolled