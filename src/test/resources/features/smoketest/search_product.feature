@smoke
Feature: Search in Marketplace, Suppliers and Contractors

  Scenario: Search Marketplace
    Given that Jp is a registered Homeowner
    When he logs in with valid credentials
      | Username                          | Password   |
      | homeowner.jerome.ramos@yandex.com | Sc@ped2018 |
    When he search Fill Soil in the Marketplace
    Then he should be able to view the labels:
      | Text Label   |
      | Products /   |
      | Request Bids |

  Scenario: Search Suppliers
    Given that Jp is a registered Homeowner
    When he logs in with valid credentials
      | Username                          | Password   |
      | homeowner.jerome.ramos@yandex.com | Sc@ped2018 |
    When he search J Supplier in the Suppliers
    Then he should be able to view the labels:
      | Text Label |
      | Supplier / |
      | Shop       |

  Scenario: Search Contractors
    Given that Jp is a registered Homeowner
    When he logs in with valid credentials
      | Username                          | Password   |
      | homeowner.jerome.ramos@yandex.com | Sc@ped2018 |
    When he search J Contract! in the Contractors
    Then he should be able to view the labels:
      | Text Label   |
      | Contractor / |
      | Shop         |