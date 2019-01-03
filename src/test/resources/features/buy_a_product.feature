@buy
Feature: buy a product

  Scenario: successful purchase of one unit of a product
    Given user navigates to a product page
    When user adds one unit of the product to the basket
    And navigates to basket summary page
    Then user should see the product added to basket

  Scenario: successful purchase of multiple units of a product
     Given user navigates to a product page
    When user adds two units of the product to the basket
    And navigates to basket summary page
    Then user should see appropriate units of the product added to basket








