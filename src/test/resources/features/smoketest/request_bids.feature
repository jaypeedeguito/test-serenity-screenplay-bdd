@smoke
Feature: Request Bids

  Scenario: Request bids from nearest local
    Given that Jp is a registered Homeowner
    When he logs in with valid credentials
      | Username                          | Password   |
      | homeowner.jerome.ramos@yandex.com | Sc@ped2018 |
    * he remove all from cart
    * he select Soil from Products menu bar
    * he selects Fill Soil in Product page
    * he clicks the button Request Bids
    * he selects checkout type as Pickup
    * he populate Pickup details:
      | loc_radius      | loc_address | pick_window | instruction              |
      | Within 10 miles | 12345       | Anytime     | For testing purpose only |
    * he clicks the button Continue
    Then he should be able to view the labels:
      | Text Label     |
      | ORDER SUMMARY  |
    When he clicks the button Submit
    Then he should be able to view the labels:
      | Text Label        |
      | REQUEST SUBMITTED |
    And he clicks the button Finish

  Scenario: Request bids from supplier store
    Given that Jp is a registered Homeowner
    When he logs in with valid credentials
      | Username                          | Password   |
      | homeowner.jerome.ramos@yandex.com | Sc@ped2018 |
    * he remove all from cart
    * he search J Supplier! in the Suppliers
    * he clicks the button Shop
    * he selects Soil product in Store page
    * he selects Topsoil in Product page
    * he clicks the button Request Bids
    * he selects checkout type as Delivery
    * he populate Delivery details:
      | pick_window | instruction              |
      | Anytime     | For testing purpose only |
    * he clicks the button Continue
    Then he should be able to view the labels:
      | Text Label    |
      | ORDER SUMMARY |
    When he clicks the button Submit
    Then he should be able to view the labels:
      | Text Label        |
      | REQUEST SUBMITTED |
    And he clicks the button Finish

