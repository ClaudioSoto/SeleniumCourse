@tag
Feature: Place order in the purahcse website

  @order
  Scenario Outline: Place an order
    Given The user is in the login page and enter <user> and <password>
    When The user select the target product <product>
    And The user goes to the cart page
    And Verifies the product <product> is on the cart
    And User proceed with the checkout 
    And fills the shipment information of the country <country>
    And place the order
    Then Verifies the conformation order message "Thankyou for the order."
    And returns to home
    
    Examples:
    |user|password|product|country|
    |claudio.soto.ayala@gmail.com|Legostarwars10.|IPHONE|Mexico|
    |claudio.soto.ayala@gmail.com|Legostarwars10.|ZARA COAT 3|Colombia|
    |claudio.soto.ayala@gmail.com|Legostarwars10.|ADIDAS ORIGINAL|Austria|

