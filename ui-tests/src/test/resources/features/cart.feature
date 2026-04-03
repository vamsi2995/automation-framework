Feature: Cart functionality

  Scenario: Add product to cart
    Given User is logged in
    When User navigates to products page
    And User adds product to cart
    Then Product should be added to cart

Scenario: Remove product from cart
  Given User is logged in
  When User navigates to products page
  And User adds product to cart
  And User removes product
  Then Cart should be empty