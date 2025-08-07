Feature: login functionality
  Scenario: Successful login with valid credentials
    Given user is on loginpage
    When user the enter username
    And user enter password
    And user clicks on submit
    Then user redirects to homepage



