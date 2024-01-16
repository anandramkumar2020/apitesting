@runonlythis
Feature: Config demo Title of your feature

  Background: 
    * url baseURL
    * header Accept = headerAccept
    * header MyEnvHeader = headerTest

  Scenario: Simple GET Reuqest
    * path "api/users/2"
    * method GET
    * status 200