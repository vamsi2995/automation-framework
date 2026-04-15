# Framework Architecture

##  Overview

The framework follows a modular hybrid architecture combining UI and API automation.

##  Modules

### 1. UI Tests (ui-tests)

* Uses Selenium + Cucumber
* Implements Page Object Model (POM)
* Handles UI workflows like login, signup, cart

### 2. API Tests (api-tests)

* Uses RestAssured + TestNG
* Covers CRUD operations
* Includes negative testing and schema validation

### 3. Common Module (common)

* ConfigReader → handles configuration
* TestContext → shares data across tests
* ScreenshotUtils → captures screenshots
* AdsHandler → handles ads/popups during UI execution
* WaitUtils → provides reusable wait methods for synchronization

---

##  Flow Diagram

automation-framework
├── ui-tests
├── api-tests
└── common

---

##  Key Features

* Reusable components
* Config-driven execution
* Scalable structure
* Supports both UI and API testing
