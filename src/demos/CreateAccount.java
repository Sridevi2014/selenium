package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) {
		// 1. Create WebDriver, Pass the path fire path(debugging in fire bug)
		System.setProperty("webdriver.gecko.driver",
				"C:\\Sridevi\\Udemyclasses\\selenium\\SDET_training\\software\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		// open Browser to account management page >> Click on create Account
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.linkText("Create Account")).click(); // a tag

		//fill out the form
		// How to locate elements
		driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Mary Smith");
		driver.findElement(By.id("MainContent_txtEmail")).sendKeys("ms@testemail.com");

		//practice
		driver.findElement(By.xpath(".//*[@id='MainContent_txtHomePhone']")).sendKeys("1231231234");//fire path
																									
        //practice
		driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']")).sendKeys("mspass");
		driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword")).sendKeys("mspass");

		// How to interact with other HTML elements 
		//radio button
		driver.findElement(By.id("MainContent_Female")).click();
		// driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='value'")).click();
        
		//drop down menu
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("Germany");
		
         //check box
		driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();
		
		//submit button
		driver.findElement(By.id("MainContent_btnSubmit")).click();

		// Get confirmation
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		System.out.println("CONFORMATION:" + conf);

		// close the browser
		driver.close();
	}

}
