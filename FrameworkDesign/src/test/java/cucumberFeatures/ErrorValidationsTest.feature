@ErrorValidation
Feature: Feature to test invalid login error
  I want to use this template for my feature file

  @scenario-1
  Scenario Outline: Scenario to test invalid login error
    Given I am on Login Page
    Given I login to website with username <username> and password <password>
    Then "Incorrect email or password." message is dispalyed

    Examples: 
      | username             | password    |
      | testuser99@gmail.com | TestUser456 |
