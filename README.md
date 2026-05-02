# Automation Framework (UI + API)

##  Project Overview

This project is a hybrid automation framework developed for UI and API testing using Selenium, Cucumber, TestNG, and RestAssured. It ensures end-to-end validation of application functionality.

---

##  Tech Stack

* Java
* Selenium WebDriver
* Cucumber (BDD)
* TestNG
* RestAssured
* Maven

---

##  Framework Structure

* **ui-tests** → UI automation (Selenium + Cucumber)
* **api-tests** → API automation (RestAssured + TestNG)
* **common** → shared utilities (DriverFactory, ConfigReader, TestContext)

---

##  Features

* Page Object Model (POM) design for UI automation
* Modular and scalable architecture
* UI test scenarios covering login, navigation, and user workflows
* Cross-browser support for UI testing
* Reusable UI components and step definitions
* Logging using Log4j2
* API chaining (Create → Update → Delete)
* Negative testing for both UI and API
* JSON schema validation for API responses
* Centralized configuration management

---

##  How to Run Tests

### Run UI Tests:

mvn -pl ui-tests test

### Run API Tests:

mvn -pl api-tests test

### Run All:

mvn clean install

---

##  Reports

Reports are generated in:

* ui-tests/target/surefire-reports
* api-tests/target/surefire-reports

---

##  Screenshots

Screenshots are available in:
docs/screenshots/

---
