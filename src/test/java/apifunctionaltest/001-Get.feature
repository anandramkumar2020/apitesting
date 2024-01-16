#Author: anand.ramkumar@experionglobal.com

Feature: Demonstrating GET Method

  # Background runs before each scenario
  Background: 
    * url baseURL
    * header Accept = headerAccept
    * header TestHeader = headerTest

  # Objective: Perform a simple GET request to retrieve user data from the specified API endpoint.
  Scenario: Retrieve User Data
    Given url 'https://reqres.in/api/users?page=2'
    When method GET
    Then status 200
    And print response
    And print responseStatus
    And print responseTime
    And print responseHeaders
    And print responseCookies

  # Objective: Demonstrate a GET request with a path using the background setup.
  @runonlythis
  Scenario: Retrieve User Data with Path
    * path 'api/users?page=2'
    * method GET
    * status 200
    * print response

  # Objective: Showcase a GET request with a path and query parameter.
  Scenario: Retrieve Users by Page
    * path 'api/users'
    * param page = 2
    * method GET
    * status 200
    * print response

  # Objective: Validate user data returned from the API using match and assert keywords.
  Scenario: Validate User Data
    * path 'api/users'
    * param page = 2
    * method GET
    * status 200
    * print response.data.length
    # The match keyword for strict equality comparison.
    * match response.data[0].first_name == 'Michael'
    # The assert keyword for flexible assertions.
    * assert response.data.length >= 6
    * match response.data[4].id == 11
