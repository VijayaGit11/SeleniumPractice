Feature: Excel reader feature

Scenario: User login to WordpressApplication

Given User Lauches the applicaton
Then User loads below fixture file at "C:/Users/HP/Documents/Framework/SeleniumPractice/fixtures/TestData.xlsx"
And User enters username and password
Then User closes the wordpress application

