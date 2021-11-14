package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	public static void main(String[] args) {

		String name = "Mary Smith";
		String email = "ms@testemail.com";
		String phoneNumber = "1231231234";
		String password = "mspass";
		String country = "Germany";
		String browserType = "chrome";
		String gender = "Female";
		boolean weeklyEmail = true;
		boolean monthlyEmail = false;
		boolean occassionalEmail = false;
		
		
		// Define Web driver
		WebDriver driver;
		driver = utilities.DriverFactory.open(browserType);
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.xpath("html/body/form/div[3]/div[2]/div/div[2]/a")).click();

		// Define web elements
		WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		WebElement phoneElement = driver.findElement(By.xpath(".//*[@id='MainContent_txtHomePhone']"));
		WebElement passwordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']"));
		WebElement verifyPasswordElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
		WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		WebElement maleRadio = driver.findElement(By.name("ctl00$MainContent$Gender"));
		WebElement femaleRadio = driver.findElement(By.id("MainContent_Female"));
		WebElement weeklyCheckbox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));
		WebElement submitButton = driver.findElement(By.id("MainContent_btnSubmit"));

		// fill out the form
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		phoneElement.sendKeys(phoneNumber);
		passwordElement.sendKeys(password);
		verifyPasswordElement.sendKeys(password);
		new Select(countryElement).selectByVisibleText(country);
		

		// Gender Radio Button Algorithm
		if (gender.equalsIgnoreCase("Male")) {
			maleRadio.click();
		} else {
			femaleRadio.click();
		}

		// check box Algorithm
		if (weeklyEmail) {
			if (!weeklyCheckbox.isSelected()) {
				weeklyCheckbox.click();
			}
		} else {
			if (weeklyCheckbox.isSelected()) {
				weeklyCheckbox.click();
			}
		}
		submitButton.click();

		// Get confirmation & close the browser
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		String expected = "Customer information added sucessfully";
		if (conf.equals(expected)) {
			System.out.println("CONFORMATION" + conf);
		} else {
			System.out.println("TEST FAILEd");
		}

		driver.close();

	}

}
