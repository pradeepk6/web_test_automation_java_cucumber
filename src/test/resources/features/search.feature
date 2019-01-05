@search
Feature: search

  Background:
Given user navigates to home page


  Scenario Outline: search successfully for a product category

    When user searches for product category <category>
    Then user should land in that category page
    Examples:
      | category  |
      | usb sticks |

  Scenario Outline: typo error in search should show corrected suggestion

    When user searches with typo error <typo>
    Then user should see results page with corrected suggestion <suggestion>
  Examples:
  | typo    | suggestion |
  | flowers | blowers    |


  Scenario Outline: search for non existent product should show no results
    When user searches for nonexistent product <searchString>
    Then user should see no results page
    Examples:
      | searchString  |
      | blahblah |









