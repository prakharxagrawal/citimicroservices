Feature: Test Authentication and Authorisation functionalities

  @uservalidation
  Scenario: user authentication
    Given user have valid credentials
    When user open website
    And entered username and password
    Then user should be authenticated to see the product list page
    And should not have the access for Admin Features

  @adminvalidation
  Scenario: admin authentication
    Given admin have valid credentials
    When admin open website
    And entered username and password
    Then admin should be authenticated to see the product list page
    And should have ability to perform other admin activities as well

  @InvalidCredentials
  Scenario: authentication is failure for invalid credentials.
    Given user have invalid credentials
    When user open website
    And entered invalid username and password
    Then user should not be authenticated