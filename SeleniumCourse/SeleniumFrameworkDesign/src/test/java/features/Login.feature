@tag
Feature: Login to the purchase website

  @login
  Scenario Outline: Verify login using valid data
    Given The user is in the login page
    When The user login the application by enter <user> and <password>
    Then Validate if redirected to the cart page
    
    Examples: 
      | user  | password |
      |claudio.soto.ayala@gmail.com|Legostarwars10.|

  @login
  Scenario Outline: Verify login using invalid data
    Given The user is in the login page
    When The user login the application by enter <user> and <password>
    Then Verify if the message error is displayed

    Examples: 
      | user  | password |
      |not.a.valid@gmail.com|Legostarwars10.|
      |claudio.soto.ayala@gmail.com|NotavalidPassword.|
      |not.a.valid@gmail.com|NotavalidPassword.|
