package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//data driven testing with testNG@dataProvider(.xls data)
public class LoginDDT {
	WebDriver driver;

	@Test(dataProvider = "getData")
	public void loginTest(String name, String email, String password) {		
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(email);
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();

		//  confirmation
		String message = driver.findElement(By.id("conf_message")).getText();
		System.out.println("CONFORMATION:" + message);

	}
	
	@BeforeMethod
	public void setup( ){
		driver = utilities.DriverFactory.open("Firefox");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	@DataProvider
	public String[][] getData() {
		return utilities.Excel.get("C:\\Sridevi\\Udemyclasses\\selenium\\UserLogin.xls");

	}
}
