# Author: anand.ramkumar@experionglobal.com
Feature: Demonstrating CRUD Operations

  # Background runs before each scenario
  Background: 
    * url baseURL
    * header Accept = headerAccept

  # Combined Objective: Perform CRUD operations on user Morpheus.

  # Step 1: Create user Morpheus with the role of a captain.
  Scenario: Create, Retrieve, Update, and Delete User - Morpheus
    * path 'api/users'
    * request {"name": "morpheus", "job": "captain"}
    * method POST
    * status 201
    * print response
    * match response contains { id: '#string', name: 'morpheus', "job": "captain"}

    # Step 2: Retrieve user data.
    * path 'api/users/2'
    * method GET
    * status 200
    * print response
    * match response.data contains { id: '#number', first_name: "#string" }

    # Step 3: Update Morpheus, promote him to the role of Commander.
    * path 'api/users/2'
    * param name = 'morpheus'
    * request {"name": "morpheus", "job": "commander"}
    * method PUT
    * print response
    * status 200
    * match response contains { name: 'morpheus', "job": "commander"}

    # Step 4: Delete the user Morpheus.
    * path 'api/users/2'
    * method DELETE
    * status 204