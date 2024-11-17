package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException
	{
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop= new Properties();
		prop.load(fis);
		String url= prop.getProperty("QAUrl");
		String browser_properties=prop.getProperty("browser");
		String browser_maven=System.getProperty("browser");
		
		//Java Ternary Operation
		// result= conditionTrue ? value1 : value2;
		
		String browser= browser_maven!= null ? browser_maven : browser_properties; 
		//Firefox Browser
		
		if (driver==null)
		{
			if(browser.equalsIgnoreCase("firefox"))
			{
			System.setProperty("webdriver.gecko.driver", "/Users/yashchouhan/Downloaded_Jars/geckodriver");
			driver= new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			}
			
			if(browser == "chrome")
			{
				//chrome browser code
			}
			
			driver.get(url);   //url- "https://rahulshettyacademy.com/seleniumPractise/#/"
		}
		
		return driver;
		//Thread.sleep(2000);

	}

}
