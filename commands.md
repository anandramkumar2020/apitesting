# Prerequisites

- Install Java (`java --version`)
- Download Scala and add it to the PATH (`scala --version`)
- Download Maven or use the Maven provided in the project folder

# Gatling

## 1. Help

- Navigate to the project folder `..\apitesting`
- Run `.\mvnw gatling:help`

## 2. Recorder (As Proxy)

- Navigate to the project folder `..\apitesting`
- Run `.\mvnw gatling:recorder`
- Generate CA if required and set certificate and key in the recorder
- If required, click on "No static resource"
- Set the browser proxy to send communication through the recorder
- Start recording

## 3. Test

- Navigate to the project folder `..\apitesting`
- Run `.\mvnw gatling:test`
- Reports are generated; paste in the browser to view the results

## 4. Test a Specific Simulation

- Navigate to the project folder `..\apitesting`
- Run `.\mvnw gatling:test -D"gatling.simulationClass=com.experion.ComputerDatabase"`
- Reports are generated; paste in the browser to view the results

## 5. Test a Karate Scenario

- Navigate to the project folder `..\apitesting`
- Run `.\mvnw clean test -P gatling`
- Reports are generated; paste in the browser to view the results

## 6. Test a Karate Scenario, provide cmd arguments

- Navigate to the project folder `..\apitesting`
- Run `.\mvnw clean test -D"karate.env=qa" -P gatling`
- Reports are generated; paste in the browser to view the results

# Karate

## 1. Test (Runs Test class, *feature in the same or its sub-package)

- Navigate to the project folder `..\apitesting`
- Run `.\mvnw test`
- Reports are generated; paste in the browser to view the results

## 2. Test (Specify variable value)

- Navigate to the project folder `..\apitesting`
- Run `.\mvnw test -D"karate.env=qa"`
- Reports are generated; paste in the browser to view the results
