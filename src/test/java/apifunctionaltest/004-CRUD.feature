# Author: anand.ramkumar@experionglobal.com
@runonlythis
Feature: Demonstrating CRUD Operations

  # Background runs before each scenario
  Background: 
    * url baseURL
    * header Accept = headerAccept

  # Objective: Create a user named morpheus with the role of a captain.
  Scenario: Create User - morpheus
    * path 'api/users'
    * request {"name": "morpheus", "job": "captain"}
    * method POST
    * status 201
    * print response
    * match response contains { id: '#string', name: 'morpheus', "job": "captain"}

  # Objective: Retrieve user data.
  Scenario: Retrieve User data
    * path 'api/users/2'
    * method GET
    * status 200
    * print response
    * match response.data contains { id: '#number', first_name: "#string" }

  # Objective: Update Morpheus, promote him to the role of Commander.
  Scenario: Update User name and role - Promote to Commander
    * path 'api/users/2'
    * param name = 'morpheus'
    * request {"name": "morpheus", "job": "commander"}
    * method PUT
    * print response
    * status 200
    * match response contains { name: 'morpheus', "job": "commander"}

  # Objective: Delete the user Morpheus.
  Scenario: Delete User - Morpheus
    * path 'api/users/2'
    * method DELETE
    * status 204