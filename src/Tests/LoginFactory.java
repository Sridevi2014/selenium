package Tests;

import org.openqa.selenium.WebDriver;

import pages.LoginPageFactory;

public class LoginFactory {

	String username = "time@testemail.com";
	String password = "trpass";
	
	public void LoginTestPageFactory() {
		// Initialize driver
	WebDriver driver = utilities.DriverFactory.open("Firefox");
	driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

	  // Enter login
	LoginPageFactory loginPage = new LoginPageFactory(driver);
	loginPage.login(username,  password);
		
	}
}
