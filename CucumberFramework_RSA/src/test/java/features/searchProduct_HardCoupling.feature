
Feature: Search and Place the order for Products

Scenario: Search Experience for product search in both home and Offers page

Given User is on GreenCart Land Page(SingleFileofStepDefinition_HardCoupling)
When user searched with the Shortname "Tom" and extracted actual name of product(SingleFileofStepDefinition_HardCoupling)
Then user searched for "Tom" shortname in offers page(SingleFileofStepDefinition_HardCoupling)
And validate the product name in offers page matches with Landing Page(SingleFileofStepDefinition_HardCoupling)

