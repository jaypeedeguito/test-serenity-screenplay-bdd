@smoke
Feature: Create an Account for Homeowner, Contractor and Supplier

  Scenario: Create Homeowner Account
    Given that JP is in the Registration page.
    When he wants to create an account as Homeowner
    And he populates the User Profile
      | field            | value              |
      | First Name       | #                  |
      | Last Name        | #                  |
      | Email address    | home.auto@test.com |
      | Phone Number     | 9086257460         |
      | Password         | Sc@ped2018         |
      | Confirm Password | Sc@ped2018         |
    * he clicks the button Next
    * he searches  East Absecon Boulevard in Address 1 field
    * he selects first suggestion result in Address 1 field
    Then he should see the input field City is notBlank
    * he should see the input field State is notBlank
    * he should see the input field Zip is notBlank
    When he clicks the button Next
    And he selects the platform Google in survey how did you hear about us
    * he clicks the button Submit
    Then he should be able to view the labels:
      | Text Label                                                                      |
      | Thank you for your interest                                                     |
      | in joining Scaped!                                                              |
      | Before you can log in, please verify your email address by clicking the link in |
      | the email we just sent to the email address you used to register.               |

  Scenario: Create Professional Account
    Given that JP is in the Registration page.
    When he wants to create an account as Professional
    And he populates the User Profile
      | field            | value              |
      | First Name       | #                  |
      | Last Name        | #                  |
      | Email address    | prof.auto@test.com |
      | Phone Number     | 9086257460         |
      | Password         | Sc@ped2018         |
      | Confirm Password | Sc@ped2018         |
    * he clicks the button Next
    * he enters Business Name Automation Professional
    * he provides PO Box Address:
      | field       | value                             |
      | PO BOX#     | 123                               |
      | City        | Edison                            |
      | State       | NJ                                |
      | Post Office | 2101 NJ-27, Edison, NJ 08817, USA |
    Then he should see the input field City contains value Edison
    * he should see the input field State contains value New Jersey
    * he should see the input field Zip contains value 08817
    When he clicks the button Next
    And he selects the Services licensed to offer:
      | services              |
      | Audio & TV & Security |
    * he clicks the button Next
    * he selects the platform Google in survey how did you hear about us
#    When he clicks the button REGISTER
#    Then he should be able to view the labels:
#      | Text Label                                     |
#      | Thank you for your interest in joining Scaped! |

  @test
  Scenario: Create Supplier Account
    Given that JP is in the Registration page.
    Then he should be able to view the Scaped Registration page.
    When he wants to create an account as Supplier
    And he populates the User Profile
      | field            | value              |
      | First Name       | #                  |
      | Last Name        | #                  |
      | Email address    | supp.auto@test.com |
      | Phone Number     | 9086257460         |
      | Password         | Sc@ped2018         |
      | Confirm Password | Sc@ped2018         |
    * he clicks the button Next
    * he enters Business Name Automation Supplier
    * he provides PO Box Address:
      | field       | value                                   |
      | PO BOX#     | 123                                     |
      | City        | Stewartsville                           |
      | State       | NJ                                      |
      | Post Office | 731 NJ-57, Stewartsville, NJ 08886, USA |
    Then he should see the input field Address 2 contains value P.O. Box 123
    * he should see the input field City contains value Stewartsville
    * he should see the input field State contains value New Jersey
    * he should see the input field Zip contains value 08886
    When he clicks the button Next
    And he selects the platform Google in survey how did you hear about us
#    When he clicks the button REGISTER
#    Then he should be able to view the labels:
#      | Text Label                                     |
#      | Thank you for your interest in joining Scaped! |