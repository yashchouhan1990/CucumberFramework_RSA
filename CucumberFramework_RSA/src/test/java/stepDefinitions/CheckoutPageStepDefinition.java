package stepDefinitions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestBase;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
public String landingPageProductName;
public String offerPageProductName;
public WebDriver driver;
public CheckoutPage checkoutPage;
TestContextSetup testContextSetup;

//Creating the constructor for step definition

public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
	
	this.testContextSetup=testContextSetup;
	checkoutPage=testContextSetup.pageObjectManager.getCheckoutPage();
}

@Then("verify user has ability to enter promo code and place the order")
public void verify_user_has_ability_enter_promo()
{
	//checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	Assert.assertTrue(checkoutPage.VerifyPromoBtn());
	Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
	
	
}

@Then("^user proceeds to Checkout and validate the (.+) items in checkout page$")
public void user_proceeds_to_checkout(String name)
{
	checkoutPage.CheckoutItems();
	//Assertion to extract name from screen and compare with name
	
}


}
