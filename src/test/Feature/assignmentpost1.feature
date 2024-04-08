@postassign
Feature: Validate the Postcall

Scenario Outline:Do xml post request validation
  Given user enter the "<Celsius>"
  Then user create the conversion body
  When User send post call "<url>"
  And User see the status code "<status_code>"
  And USer see the celcius response "<CelsiustoFerhenheit>"

  Examples:
  |Celsius|url|status_code|CelsiustoFerhenheit|
  |5      |https://www.w3schools.com/xml/tempconvert.asmx|200|41|
  |10      |https://www.w3schools.com/xml/tempconvert.asmx|200|50|
