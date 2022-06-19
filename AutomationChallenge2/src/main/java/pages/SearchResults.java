package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResults {
	//variables
	WebDriver driver;
	
	//locators
	By resultStats = By.id("result-stats");
	
	//constructor
	public SearchResults(WebDriver driver) {
		this.driver = driver;
	}
	
	//actions / keywords
	public String getResultStats() {
		return new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.presenceOfElementLocated(resultStats)).getText();
	}

	public String getNoResult() {
		return driver.getCurrentUrl();
	}

}


