@facebookLogin
Feature: FacebookLoginFeature
  This feature deals with the login functionality of the application

  Scenario: Login with correct username and password
    Given User navigated to facebook login page
    When User fills in Email and Password
      | Email           | Password    |
      | 100029299460449 | j1gtjkg8n30 |
    Then User clicks on Log-In Button
    And User post Status "Hola2 World"