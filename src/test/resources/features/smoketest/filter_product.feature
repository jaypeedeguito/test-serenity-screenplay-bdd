@smoke
Feature: Filter a Products, Hauling and Services

  Background: User is logged-in as registered Homeowner
    Given that Jp is a registered Homeowner
    When he logs in with valid credentials
      | Username                          | Password   |
      | homeowner.jerome.ramos@yandex.com | Sc@ped2018 |
    Then he should be able to view Scaped | Home Page Page

  Scenario: Filter Products
    When he filter the Products
    Then he should see filter results for Products

  Scenario: Filter Hauling
    When he filter the Hauling
    Then he should see filter results for Hauling

  Scenario: Filter Services
    When he filter the Services
    Then he should see filter results for Services