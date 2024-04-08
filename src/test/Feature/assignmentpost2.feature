@postjson
Feature: Validate the name response in post call

  Scenario Outline: Do JSON post request validation
    Given User enter name "<name>" and "<year>" and "<price>"
    Then User create the conversion body
    When User post the url "<url>"
    And User validate the status code "<status_code>"
    And User validate the year in response "<response_year>"
    And User validate the price in response "<response_price>"
    And User validate the created date should not null

    Examples:
    |name|year|price|url|status_code|response_year|response_price|
    |Apple MacBook Pro 16|2019|1849.99|https://api.restful-api.dev//objects|200|2019|1849.99|

