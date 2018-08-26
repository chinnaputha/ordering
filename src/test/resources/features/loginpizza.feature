Feature: verify that user is able to login pizza application
Scenario: login to pizza using valid login credentials
    Given open pizza app
    When enter valid username and password
    Then user should able to login
 
 Scenario: Verify that user is able to logout application
     Given click logout button
     When app should comeout from home page
     Then login page should display