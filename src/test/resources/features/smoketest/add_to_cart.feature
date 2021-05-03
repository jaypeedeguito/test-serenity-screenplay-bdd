@smoke
Feature: Add to Cart

  Scenario: Add to cart from nearest local
    Given that Jp is a registered Homeowner
    When he logs in with valid credentials
      | Username                          | Password   |
      | homeowner.jerome.ramos@yandex.com | Sc@ped2018 |
    * he remove all from cart
    * he select Mulch from Products menu bar
    * he selects Black Dyed Mulch in Product page
    * he add the item to cart
    Then he should see 1 in the Cart Counter

  Scenario: Add to cart from supplier store
    Given that Jp is a registered Homeowner
    When he logs in with valid credentials
      | Username                          | Password   |
      | homeowner.jerome.ramos@yandex.com | Sc@ped2018 |
    * he remove all from cart
    * he search J Supplier! in the Suppliers
    * he clicks the button Shop
    * he selects Soil product in Store page
    * he selects Fill Soil in Product page
    * he add the item to cart
    Then he should see 1 in the Cart Counter
