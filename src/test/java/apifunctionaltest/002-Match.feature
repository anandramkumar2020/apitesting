# Author: anand.ramkumar@experionglobal.com
@runonlythis
Feature: Exploring Match Functionality in API Validations

  # Background: Sets up the base URL for each scenario
  Background: 
    * url baseURL

  # Objective: Validate user data by checking the data type of id and email
  Scenario: Validate User ID and Email
    * path 'api/users/2'
    * method GET
    * status 200
    * print response
    * match response.data.id == '#number'
    * match response.data.email == '#string'
    * def userid = response.data.id
    # Appends the extracted id to the second path for the subsequent request.
    * path 'api/users/', userid
    * method GET
    * status 200
    * print response

  # Objective: Check data types and ignore certain fields
  Scenario: Validate Patient Information
    * def patientInfo = read('sample_patient_data.json')
    * print patientInfo
    # Below match will fail because the patient.id is a number
    # * match patientInfo.patient.id == '#number'
    * match patientInfo.patient.id != '#number'
    * match patientInfo.patient.firstName == '#string'
    * match patientInfo.patient.gender == '#ignore'

  # Objective: Validate specific fields in the response data
  Scenario: Validate User Data by Page
    * path 'api/users?page=2'
    * method GET
    * status 200
    * print response
    * match response.data[0] contains { id: 1, name: '#string', pantone_value: '#string'}

  # Objective: Validate response against a JSON file
  Scenario: Validate User Profile
    * path 'api/users/2'
    * method GET
    * status 200
    * print response
    * match response == read('userprofile.json')

  # Objective: Validate response IDs and check for specific IDs
  Scenario: Validate Response IDs
    * path 'api/users?page=2'
    * method GET
    * status 200
    * def responseIDs = get response.data[*].id
    * print responseIDs
    # match all ids
    * match responseIDs == [1,2,3,4,5,6]
    # match to check if any of some ids are present
    * match responseIDs contains [2,5]
