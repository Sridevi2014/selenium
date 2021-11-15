package smoketests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PageTitleJUnit {

	// Declare variables and objects at CLASS level in order to access in multiple methods through program
	WebDriver driver;
	String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
	
	@Test
	public void pageTitleTest()
	{
		System.out.println("Running the test");
			
		WebDriver driver = utilities.DriverFactory.open("chrome");
		driver.get(webURL);		
		String actualTitle = driver.getTitle();
		String expectedTitle = "SDET Trainging | Account Managemen";
		Assert.assertEquals(expectedTitle, actualTitle);
		//Assert.fail("We intentionally failed this test");
		
			
		}
	@Before
	public void setUp() {
		System.out.println("Initializing the driver");
		driver = utilities.DriverFactory.open("chrome");
	}
	
	@After
	public void tearDown ()
	{
		System.out.println("Closing the driver");
		driver.close();
	}
	
}
