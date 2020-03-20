Feature: Login Action

Scenario: User gets error with invalid credentials
	Given User on Home Page
	When User Clicks on LogIn link
	And User Check cursor at default
	And User Enters "Invalid username" to email field
	Then User Gets error "Indiquez votre adresse e-mail" and observe highlight in red of the field
	
Scenario: User logs in successfully with valid credentials
	Given User on Home Page
	When User Clicks on LogIn link
	And User Enters valid username "buyer.nvg01@gmail.com" and password "nvg07072012""
	And User Clicks My Anibis
	And User Clicks User Account
	Then User See the email "buyer.nvg01@gmail.com" in personal page

Scenario: User search
	Given User on Home Page
	When User Clicks on All Categories link
	And User Clicks Immobilien category
	And User Clicks Apply
	And User Select Price from "1000" to "5000"
	And User Select Location "Zurich" and "10 km" around
	Then User Verifies the number of results on First page is 20
	And User Select sort by date
