Feature: Check first link title

Scenario: Check title on the first link page
Given I am the user who opens the home page
When I searches for keyword
And I open first link
Then I should check page title