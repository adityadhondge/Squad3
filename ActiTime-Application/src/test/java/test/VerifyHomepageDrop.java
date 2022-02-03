package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Base;
import pom.HomePage;
//import pom.LogIN;
import pom.LogIn;

public class VerifyHomepageDrop extends Base {
	
	private WebDriver driver;
	private LogIn login;
	private HomePage homepage;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) {
		System.out.println("launchBrowser");
		
		if(browser.equals("chrome")) {
			driver=openChromeBrowser();
			
		}
		if(browser.equals("edge")) {
			driver=openEdgeBrowser();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	
	}
		
		@BeforeClass
		public void beforeClass() {
			System.out.println("BeforeClass");
	System.setProperty("webdriver.chrome.driver","C:\\Automation class\\chromedriver.exe");
			
			 driver= new ChromeDriver();
		}
	
		@BeforeMethod
		public void launchBrowser() {
			System.out.println("launchBrowser");
			driver.get("http://localhost/login.do");
			login = new LogIn(driver);
			login.sendUserName();
			login.sendPassword();
			login.clickLoginButton();
			homepage = new HomePage(driver);
		}
	
	@Test
	public void toVerifyDropdown() {
		homepage.ClickOnDropdown();
		
	}
	
	@Test
	public void tiVerifyManageCustomers() {
		homepage.ClickManageCustomers();
	}
	
	@AfterMethod
	public void logOutFromHomePage() {
//		System.out.println("logOutFromHomePage");
		homepage.ClickOnLogoutButton();
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("closeBrowser");
		driver.quit();
	}

}
