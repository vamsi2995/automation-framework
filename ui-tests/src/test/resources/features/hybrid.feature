Feature: Hybrid API + UI Testing

  Scenario: Create user via API and login via UI

    Given User creates account using API
    When User is on login page
    And User enters valid credentials
    And Click login
    Then User should login successfully