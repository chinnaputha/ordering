Feature: verify that user is able to login pizza application
Scenario: login to pizza using valid login credentials
    Given open pizza app
    When enter valid username and password
    Then user should able to login