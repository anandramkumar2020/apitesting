#Author: anand.ramkumar@experionglobal.com
Feature: Demonstrating

  # Background runs before each scenario
  Background: 
    * url baseURL

  Scenario: 
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

  @runonlythis
  Scenario: 
    * def patientInfo = read('sample_patient_data.json')
    * print patientInfo
    # Below match will fail , becase the patent.id is a number
    * match patientInfo.patient.id == '#number'
    * match patientInfo.patient.firstName == '#string'
    * match patientInfo.patient.gender == '#ignore'