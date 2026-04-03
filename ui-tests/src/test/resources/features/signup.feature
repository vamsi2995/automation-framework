Feature: User Signup

  Scenario: Register new user successfully
    Given User is on signup page
    When User enters signup details
    And User fills account form
    Then Account should be created successfully