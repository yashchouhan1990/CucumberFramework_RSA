package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	public WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locators
	By cartBag=By.xpath("//img[@alt=\"Cart\"]");   //css cssSelector("[alt='Cart']")
	By checkoutButton=By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promoBtn=By.cssSelector("button.promoBtn");
	By placeOrder=By.xpath("//button[contains(text(),'Place Order')]");
	

	//Action Methods
	
	public void CheckoutItems()
	{
		driver.findElement(cartBag).click();
		driver.findElement(checkoutButton).click();
	}
	
	public boolean VerifyPromoBtn()
	{
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public boolean VerifyPlaceOrder()
	{
		return driver.findElement(placeOrder).isDisplayed();
	}
}


