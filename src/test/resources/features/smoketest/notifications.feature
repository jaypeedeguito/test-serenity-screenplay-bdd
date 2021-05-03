@smoke
Feature: Notifications

  Scenario: View Notifications
    Given that Jp is a registered Homeowner
    When he logs in with valid credentials
      | Username                          | Password   |
      | homeowner.jerome.ramos@yandex.com | Sc@ped2018 |
    When he opens the Notifications
    Then he should be able to view the labels:
      | Text Label    |
      | NOTIFICATIONS |