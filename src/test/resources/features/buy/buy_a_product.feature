Feature: buy a product

  Scenario: buy one unit of a product
    Given user has navigated to a product page
    When user adds one unit of the product to the basket
    And navigates to basket summary page
    Then user should see the product added to basket







