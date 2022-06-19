package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleHome {
	WebDriver driver;
	//variables
	String url = "https://www.google.com/";
	
	//locators
	By googleLogoImage = By.xpath("//img[@alt='Google']");
	By searchBox = By.name("q");
	
	//constructor
	public GoogleHome(WebDriver driver) {
		this.driver = driver;
	}
	
	//keywords / actions
	public void navigate() {
		driver.navigate().to(url);
	}

	public void searchForQuery(String query) {
		driver.findElement(searchBox).sendKeys(query + Keys.ENTER);
	}
	
}