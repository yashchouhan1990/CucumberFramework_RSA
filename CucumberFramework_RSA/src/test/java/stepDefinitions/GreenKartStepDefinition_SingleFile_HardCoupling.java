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

public class GreenKartStepDefinition_SingleFile_HardCoupling {
public String landingPageProductName;
public String offerPageProductName;
public WebDriver driver;
	
	@Given("User is on GreenCart Land Page\\(SingleFileofStepDefinition_HardCoupling)")
	public void user_is_on_GreenCart_Land_Page() {
		//Firefox Browser
		System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
		driver= new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		//Thread.sleep(2000);

	}

	@When("user searched with the Shortname {string} and extracted actual name of product\\(SingleFileofStepDefinition_HardCoupling)")
	public void user_searched_with_the_Shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		
		//Css selector
		//driver.findElement(By.cssSelector("input.search-keyword")).sendKeys("Tom");
		//By xpath
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
		landingPageProductName=driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println("Product name is "+landingPageProductName);
	}

	@Then("user searched for {string} shortname in offers page\\(SingleFileofStepDefinition_HardCoupling)")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {
	    // Offer page-> enter-> grab text
		driver.findElement(By.linkText("Top Deals")).click();
		
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1=s1.iterator();
		String parentWindow=i1.next();
		String childWidow=i1.next();
		
		driver.switchTo().window(childWidow);
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
		offerPageProductName=driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		
		
	}
	

	@Then("validate the product name in offers page matches with Landing Page\\(SingleFileofStepDefinition_HardCoupling)")
	public void validate_the_product_name_in_offers_page_matches_with_Landing_Page() {
	  Assert.assertEquals(landingPageProductName, offerPageProductName);
	}
}
