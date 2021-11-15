package stepimplementations;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

//Behaviour-Driven Development 
public class BDDLoginTest {
	WebDriver driver;

	//Given user is on the login page //cucumber annotation
	@Given("^user is on the login page$")
	public void user_is_on_the_login_page() {
		System.out.println("user is on the login page");
		//open driver
		driver = utilities.DriverFactory.open("Chrome");
		//navigate to login page
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

	}

	//When user enters correct username and correct password
	@When("^user enters correct username and correct password$")
	public void user_enters_correct_username_and_correct_password() {
		System.out.println("user enters correct username and correct password");
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();

	}
	
	//When user enters email <usename>
	@When ("^user enters email(.*)$")
	public void user_enters_usename(String username){
		System.out.println("TESTING: " + username);
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(username);
	}
	
	//And user enters  password <password>
	@And("^user enters password(.*)$")
	public void user_enters_password(String password)
	{
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
		click_login();
	}

	//And user clicks  login button
	@And("^user clicks login button")
	public void clicks_login()
	{
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
	}

	//Then user gets confirmation 
	@Then("^user gets confirmation$")
	public void user_gets_confirmation() {
		System.out.println("user gets confirmation");
		Assert.assertTrue(driver.findElement(By.id("conf_message")).getText().contains("success"));
	}
	//cucumber annotation JUnit
	@After
	public void tearDown(){
		driver.quit();
	}
}
