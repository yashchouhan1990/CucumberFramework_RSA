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
import utils.TestBase;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
public String landingPageProductName;
public String offerPageProductName;
public WebDriver driver;
TestContextSetup testContextSetup;
LandingPage landingPage;

//Creating the constructor for step definition

public LandingPageStepDefinition(TestContextSetup testContextSetup) {
	
	this.testContextSetup=testContextSetup;
	this.landingPage=testContextSetup.pageObjectManager.getLandingPage();
}

	@Given("User is on GreenCart Land Page")
	public void user_is_on_GreenCart_Land_Page() {
		//Firefox Browser
	//	System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
	//	testContextSetup.driver= new FirefoxDriver();
		
	//	testContextSetup.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	//	testContextSetup.driver.manage().window().maximize();
	//	testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		//Thread.sleep(2000);

	//	TestBase testBase= new TestBase();
	//	testBase.WebDriverManager();
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}

	@When("^user searched with the Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_the_Shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		
		//Css selector
		//driver.findElement(By.cssSelector("input.search-keyword")).sendKeys("Tom");
		//By xpath
		//testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		//LandingPage landingPage=new LandingPage(testContextSetup.driver);
		LandingPage landingPage=testContextSetup.pageObjectManager.getLandingPage();
		landingPage.searchItems(shortName);
		
		Thread.sleep(2000);
		//testContextSetup.landingPageProductName=testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		testContextSetup.landingPageProductName=landingPage.getProductName().split("-")[0].trim();
		System.out.println("Product name is "+testContextSetup.landingPageProductName);
	}
	
	@When("Added {string} items of the selected product to cart")
	public void Added_items_prodict(String quantity)
	{
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}

}
