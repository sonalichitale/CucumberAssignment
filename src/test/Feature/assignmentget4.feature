
  @currget
Feature: Validate the arraylist

    Scenario Outline: Do the get call for arraylist
      Given User launch url "<url>"
      Then User hit a url
      Then user check the stuatus code "<statuscode>"
      And USer validate the currencies "<name>"
      And User validate the forwardtypes "<name>"
      And User validate outcometype as "<name>"

      Examples:
      |url|statuscode|name|name|name|
    |https://www.xignite.com/xCurrencies.asmx?wsdl|200|Currencies|ForwardTypes|OutcomeTypes|

