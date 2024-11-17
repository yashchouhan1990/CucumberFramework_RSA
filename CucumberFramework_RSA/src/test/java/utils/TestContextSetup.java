package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {

	public String landingPageProductName;
	public WebDriver driver;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	public TestContextSetup() throws IOException
	{
		testBase= new TestBase();
		pageObjectManager=new PageObjectManager(testBase.WebDriverManager());
		genericUtils= new GenericUtils(testBase.WebDriverManager());
	}
	
}
