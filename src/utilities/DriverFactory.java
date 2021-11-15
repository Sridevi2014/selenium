package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

//cross browser
public class DriverFactory {
	
		//this method return a WebDriver object
		public static WebDriver open(String browserType)
{
	
	 if (browserType.equalsIgnoreCase("firefox" ))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Sridevi\\Udemyclasses\\selenium\\SDET_training\\software\\geckodriver.exe");
	       return new FirefoxDriver();
	       
		}
	 else if (browserType.equalsIgnoreCase("IE")){
		 
		 
		 System.setProperty("Webdriver.ie.driver", "C:\\Sridevi\\Udemyclasses\\selenium\\SDET_training\\software\\IEDriverServer.exe");
		 return new InternetExplorerDriver();
				 
	 }
		else
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Sridevi\\Udemyclasses\\selenium\\SDET_training\\software\\chromedriver.exe");
			return new ChromeDriver();
			 
			
		}
}

	}


