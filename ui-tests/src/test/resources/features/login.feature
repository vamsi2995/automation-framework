Feature: User Login

  Scenario: Valid login
    Given User is on login page
    When User enters valid credentials
    And Click login
    Then User should login successfully


   Scenario: Invalid login
     Given User is on login page
     When User enters invalid credentials
     And Click login
     Then Error message should be displayed