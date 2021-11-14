package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {
		
		// 1 Define the web driver
		System.setProperty("webdriver.chrome.driver", "C:\\Sridevi\\Udemyclasses\\selenium\\SDET_training\\software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	
		// 2 open web browser and navigate to page
       // http://sdettraining.com/trguitransactions/AccountManagement.aspx
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		//fill out the form
		// Find elements: Locate the element, Determine the action, Pass any parameters
		//  Enter email address
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");
		
		//  Enter password
				driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");
		
		//  Click login
				driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
		
		// 5. Get confirmation
		String message = driver.findElement(By.id("conf_message")).getText();
		System.out.println("CONFORMATION:" + message);
		
		String pageTitle = driver.getTitle();
		    System.out.println("PAGE TITLE:" + pageTitle);
				
		// 6. close the browser	    
		   driver.close();
		   
	}

}
