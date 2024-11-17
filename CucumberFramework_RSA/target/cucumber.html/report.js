$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/searchProduct.feature");
formatter.feature({
  "name": "Search and Place the order for Products",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Search Experience for product search in both home and Offers page",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@OffersPage"
    }
  ]
});
formatter.step({
  "name": "User is on GreenCart Land Page",
  "keyword": "Given "
});
formatter.step({
  "name": "user searched with the Shortname \u003cName\u003e and extracted actual name of product",
  "keyword": "When "
});
formatter.step({
  "name": "user searched for \u003cName\u003e shortname in offers page",
  "keyword": "Then "
});
formatter.step({
  "name": "validate the product name in offers page matches with Landing Page",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Name"
      ]
    },
    {
      "cells": [
        "Tom"
      ]
    },
    {
      "cells": [
        "Beet"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Search Experience for product search in both home and Offers page",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@OffersPage"
    }
  ]
});
formatter.step({
  "name": "User is on GreenCart Land Page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.LandingPageStepDefinition.user_is_on_GreenCart_Land_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "user searched with the Shortname Beet and extracted actual name of product",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.LandingPageStepDefinition.user_searched_with_the_Shortname_and_extracted_actual_name_of_product(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "user searched for Beet shortname in offers page",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.OfferPagePageStepDefinition.user_searched_for_shortname_in_offers_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "validate the product name in offers page matches with Landing Page",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.OfferPagePageStepDefinition.validate_the_product_name_in_offers_page_matches_with_Landing_Page()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected [Beetroot] but found [No data]\n\tat org.testng.Assert.fail(Assert.java:97)\n\tat org.testng.Assert.assertEqualsImpl(Assert.java:136)\n\tat org.testng.Assert.assertEquals(Assert.java:118)\n\tat org.testng.Assert.assertEquals(Assert.java:575)\n\tat org.testng.Assert.assertEquals(Assert.java:585)\n\tat stepDefinitions.OfferPagePageStepDefinition.validate_the_product_name_in_offers_page_matches_with_Landing_Page(OfferPagePageStepDefinition.java:81)\n\tat ✽.validate the product name in offers page matches with Landing Page(file:///Users/yashchouhan/eclipse-workspace/CucumberFramework_RSA/src/test/java/features/searchProduct.feature:9)\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png", "image");
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});