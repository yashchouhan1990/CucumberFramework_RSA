
Feature: Search and Place the order for Products
@OffersPage
Scenario Outline: Search Experience for product search in both home and Offers page

Given User is on GreenCart Land Page
When user searched with the Shortname <Name> and extracted actual name of product
Then user searched for <Name> shortname in offers page
And validate the product name in offers page matches with Landing Page

Examples:
|	Name	|
|	Tom		|
|	Beet	|