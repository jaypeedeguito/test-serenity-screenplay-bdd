@smoke
Feature: Navigation



  Scenario: Navigate to Products from Menu bar
    Given that Jp is a registered Homeowner
    When he logs in with valid credentials
      | Username                          | Password   |
      | homeowner.jerome.ramos@yandex.com | Sc@ped2018 |
    When he select Soil from Products menu bar
    Then he should be able to view the labels:
      | Text Label |
      | Products / |

  Scenario: Navigate to Hauling from Menu bar
    Given that Jp is a registered Homeowner
    When he logs in with valid credentials
      | Username                          | Password   |
      | homeowner.jerome.ramos@yandex.com | Sc@ped2018 |
    When he select Bulk Material from Hauling menu bar
    Then he should be able to view the labels:
      | Text Label |
      | Hauling /  |

  Scenario: Navigate to Services from Menu bar
    Given that Jp is a registered Homeowner
    When he logs in with valid credentials
      | Username                          | Password   |
      | homeowner.jerome.ramos@yandex.com | Sc@ped2018 |
    When he select Property Care from Services menu bar
    Then he should be able to view the labels:
      | Text Label |
      | Services / |

  Scenario: Navigate to Orders from Account icon
    Given that Jp is a registered Homeowner
    When he logs in with valid credentials
      | Username                          | Password   |
      | homeowner.jerome.ramos@yandex.com | Sc@ped2018 |
    When he navigates to Orders from Account icon
    Then he should be able to view Scaped | Orders Page


  Scenario: Navigate to Favorites from Account icon
    Given that Jp is a registered Homeowner
    When he logs in with valid credentials
      | Username                          | Password   |
      | homeowner.jerome.ramos@yandex.com | Sc@ped2018 |
    When he navigates to Favorites from Account icon
    Then he should be able to view the labels:
      | Text Label   |
      | MY FAVORITES |

  Scenario: Navigate to Cart
    Given that Jp is a registered Homeowner
    When he logs in with valid credentials
      | Username                          | Password   |
      | homeowner.jerome.ramos@yandex.com | Sc@ped2018 |
    When he navigates to Cart
    Then he should see the Cart Page