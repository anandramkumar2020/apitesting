# Author: anand.ramkumar@experionglobal.com
@runonlythis
Feature: Demonstrating POST Method

  # Background runs before each scenario
  Background: 
    * url baseURL
    * header Accept = headerAccept

  # Objective: Create a user named Morpheus with the role of a leader.
  Scenario: Create User - Morpheus
    * path 'api/users'
    * request {"name": "morpheus", "job": "leader"}
    * method POST
    * status 201
    * print response
    * match response contains { id: '#string', name: 'morpheus', "job": "leader"}

  # Objective: Create users dynamically with different names and roles and verify their creation.
  Scenario Outline: Create User - Dynamic
    * path 'api/users'
    * request {name: '#(names)', job: '#(job)'}
    * method POST
    * status 201
    * print response
    * match response contains { id: '#string', name: '#(names)'}
    # Comment: Extracting the created user's ID for future reference
    * def idCreated = response.id
    * print "id created :" + idCreated
    * path 'api/users/', idCreated
    * method GET

    Examples: 
      | names    | job     |
      | Neo      | The One |
      | Trinity  | Hacker  |
      | Morpheus | Captain |

  #| Agent Smith | Agent    |
  #| Cypher      | Traitor  |
  #| Oracle      | Seer     |
  #| Dozer       | Operator |
  #| Switch      | Operator |
  #| Tank        | Operator |
  # Objective: Create a user from a predefined JSON file and verify its creation.
  Scenario: Create User - From JSON
    * def jsonBody = read("user_data.json")
    * print jsonBody
    * path 'api/users'
    * request jsonBody
    * method POST
    * print response
    * match response == { id: '#ignore', name: "Oracle", job : "Seer", createdAt : '#string'}
    * print responseBytes.length
    * assert responseBytes.length >= 75
