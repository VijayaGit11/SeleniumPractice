Feature: Yahoo login feature

Description: This feature is for yahoo login

Background: 
Given User launches yahoo mail

Scenario: Validation of yahoo login

When User clicks on mail icon
And User enters yahooUsername
|username|
|vijaya.sen@gmail.com|
Then User clicks on next button 