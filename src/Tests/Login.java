package Tests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;

public class Login {
	
	@Test
	public void loginTestPOM() {
		// Initialize driver
		WebDriver driver = utilities.DriverFactory.open("Firefox");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

		// Enter login information (Login page)
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName("tim@Testemail.com");
		loginPage.setPassword("trpass");
		loginPage.clickSubmit();

		// Get confirmation(Dasboard Page)
		DashboardPage dashboardPage = new DashboardPage(driver);
		String conf = dashboardPage.confirmationMessage();
		String title = dashboardPage.title();

		// Assertions
		Assert.assertTrue(conf.contains("success"));
		Assert.assertTrue(title.contains("Account"));

		// Close the driver
		driver.quit();
	}

}
