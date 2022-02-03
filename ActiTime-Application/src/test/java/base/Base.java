package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {

	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation class\\chromedriver.exe");
		WebDriver driver= new ChromeDriver ();
		driver.manage().window().maximize();
		
		return driver;
	}
		public static WebDriver openEdgeBrowser() {
		System.setProperty("webdriver.edge.driver", "C:\\Automation class\\msedgedriver.exe");
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		return driver;
		
	} 
	

}
