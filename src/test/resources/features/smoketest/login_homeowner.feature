@smoke
Feature: Login

  Scenario: Successfully login Homeowner
    Given that Jp is a registered Homeowner
    When they logs in with valid credentials
      | Username                          | Password   |
      | homeowner.jerome.ramos@yandex.com | Sc@ped2018 |
    Then he should be able to view Scaped | Home Page Page