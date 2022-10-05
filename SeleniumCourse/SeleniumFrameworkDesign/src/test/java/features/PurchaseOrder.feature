@tag
Feature: Place order in the purahcse website

  @tag1
  Scenario Outline: Place an order
    Given The user is in the login page and login
    When The user select the target product <product>
    And The user goes to the cart page
    And Verifies the product <product> is on the cart
    And User proceed with the checkout 
    And fills the shipment information of the country <country>
    And place the order
    Then Verifies the conformation order message
    And returns to home
    
    Examples:
    |product|country|
    |IPHONE|Mexico|
    |ZARA COAT 3|Colombia|
    |ADIDAS ORIGINAL|Austria|

