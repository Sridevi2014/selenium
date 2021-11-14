package Tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Expedia {
	WebDriver driver;
	String browserType = "Chrome";
	String city = "New York, NY";
	String checkIn = "10/02/2017";
	String checkOut = "10/09/2017";
	String numberOfGuests = "2";
	String starRating = "star4";
	String searchResult = "2";
	
	@Test
	public void hotleReservation() {
		// 1 search
		driver.findElement(By.id("tab-hotel-tab-hp"));
		driver.findElement(By.id("hotel-destination-hp-hotel")).clear();
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
		driver.findElement(By.id("hotel-checkin-hp-hotel")).clear();
		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkIn);
		driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOut);
		new Select(driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[4]/div[4]/label/select"))).selectByValue(numberOfGuests);
		
		driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[4]/div[4]/label/select")).click();
		//2. Modify the search results page, give criteria
		driver.findElement(By.cssSelector("input[name-'star'][id='" + starRating + "']")).click();
		
		//Print name this city
		String actualCity = driver.findElement(By.xpath("//*id=\"hotelResultTitle\"]/h1")).getText();
		System.out.println("CITY: " + actualCity);
		
		//3. Analyze the results and make our selection
		driver.findElement(By.xpath("//*[@id=\"resultsContainer\"]/section/article["  + searchResult + "]/div[2]/div/a")).click();
		
		//Switch the window to the pop
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		// Print hotel name and star rating
		String hotelName = driver.findElement(By.id("hotel-name")).getText();
		//String hotelRating = driver.findElement(By.cssSelector("span[class-rating-number']")).getText();
		System.out.println("HOTEL: " + hotelName);
		
		
		//4. Book reservation
		driver.findElement(By.xpath("//*[id=\"rooms-and-rates\"]/div/article/table/tbody/tr/td[5]/form/div[1]/button")).click();
		
		String hotelPrice = driver.findElement(By.cssSelector("span[class='amout-value']")).getText();
		System.out.println("PRICE: " + hotelPrice);
		
		//5. Fill out contact / billing
		
		//6. Get confirmation
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains("Payments"));
		
		
	}
	
	@BeforeMethod
	public void setup() {
		driver = utilities.DriverFactory.open(browserType);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.expedia.com/");
		
	}
	

	@AfterMethod
    public void tearDown() {
    driver.quit();
    }
}
