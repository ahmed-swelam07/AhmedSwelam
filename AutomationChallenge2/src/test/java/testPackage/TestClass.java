package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleHome;
import pages.SearchResults;

public class TestClass {
	// declaration
	WebDriver driver;
	GoogleHome home;
	SearchResults results;


	@Test(description = "search for a query using Enter Key")
	public void checkThatResultStatsIsNotEmpty() {		
		home.searchForQuery("Instabug");
		var resultStatsText = results.getResultStats();
		Assert.assertNotEquals(resultStatsText, "");
	}
	
	@Test(description = "search for an empty query using Enter Key")
	public void searchForNothing() {		
		home.searchForQuery("");
		var currenturl = results.getNoResult();
		Assert.assertEquals("https://www.google.com/",currenturl);
	}
	
	@Test(description = "search for a query using Google Search Button ")
	public void clickGoogleSearchButton() {		
		home.searchForQuery("AlAhly");
		var resultStatsText = results.getResultStats();
		Assert.assertNotEquals(resultStatsText, "");
	}

	@BeforeClass
	public void beforeClass() {
		// setting up chromedriver
		WebDriverManager.chromedriver().setup();
//		WebDriverManager.firefoxdriver().setup();
		// assignation
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		// calling
		driver.manage().window().maximize();
		home = new GoogleHome(driver);
		results = new SearchResults(driver);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		home.navigate();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
