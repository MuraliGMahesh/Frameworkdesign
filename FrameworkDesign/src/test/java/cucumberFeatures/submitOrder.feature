@submitOrder
Feature: Feature to test submit order

  Background: 
    Given I am on Login Page

  @scenario-1
  Scenario Outline: Scenario to test submit order
    Given I login to website with username <username> and password <password>
    When I add product <productName> to the cart
    And checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is dispalyed on confirmation page

    Examples: 
      | username             | password    | productName |
      | testuser99@gmail.com | TestUser123 | ZARA COAT 3 |
