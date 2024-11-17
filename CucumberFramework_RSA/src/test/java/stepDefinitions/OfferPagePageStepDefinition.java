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
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import pageObjects.PageObjectManager;
import utils.GenericUtils;
import utils.TestContextSetup;

public class OfferPagePageStepDefinition {
public String landingPageProductName;
public String offerPageProductName;
public WebDriver driver;
TestContextSetup testContextSetup;
PageObjectManager pageObjectManager;

//Single responsibility Principle (SRP)
//Loosely coupled
//Factor Design Pattern--> A java class will be create which is responsible for creating objects whenever we want for all page objects files
public OfferPagePageStepDefinition(TestContextSetup testContextSetup) {
	
	this.testContextSetup=testContextSetup;
}

	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {
	    // Offer page-> enter-> grab text
		System.out.println("Grabbed Text from Landing Page ="+shortName );
		switchToOffersPage();
		
		//testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		
		//OfferPage offerPage=new OfferPage(testContextSetup.driver);
		OfferPage offerPage=testContextSetup.pageObjectManager.getOfferPage();
		offerPage.searchItems(shortName);
		
		Thread.sleep(2000);
		
		//offerPageProductName=testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		offerPageProductName=offerPage.getProductName();
		
		System.out.println("Offers Page Product name "+offerPageProductName);
		
	}
	
//Method crethod to do Loose Coupling
	public void switchToOffersPage()
	{
		//if switched to offer page=> skip below part
		//if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase(""));
//		pageObjectManager=new PageObjectManager(testContextSetup.driver);
		LandingPage landingPage=testContextSetup.pageObjectManager.getLandingPage();
		
		//LandingPage landingPage=new LandingPage(testContextSetup.driver);
		
		landingPage.selectTopDealsPage();
		
		//testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		//Switch to child window
		//GenericUtils genericUtils= new GenericUtils();
		//genericUtils.SwitchWindowToChild();
		
		testContextSetup.genericUtils.SwitchWindowToChild();
				

	}
	
	@Then("validate the product name in offers page matches with Landing Page")
	public void validate_the_product_name_in_offers_page_matches_with_Landing_Page() {
	  Assert.assertEquals(offerPageProductName,testContextSetup.landingPageProductName);
	}
}
