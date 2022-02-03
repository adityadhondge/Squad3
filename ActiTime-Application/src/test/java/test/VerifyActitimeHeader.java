package test;

import java.io.File;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

//import org.testng.asserts.SoftAssert;
import base.Base;
import pom.ActitimeHeader;
import pom.LogIn;


public class VerifyActitimeHeader extends Base {
   private WebDriver driver;
	private LogIn login;
	private ActitimeHeader actitimeHeader;
	private int testID;
//	private UserList userList
//	private SoftAssert softAssert;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	@BeforeTest
	@Parameters("browser")
	
	public void launchBrowser(String browser) {
		reporter = new ExtentHtmlReporter(
				"test-output" + File.separator + "ExtentReport" + File.separator + "Extent.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
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
	public void initializePomClasses() {
		login= new LogIn(driver);
		actitimeHeader= new ActitimeHeader(driver);
		
	}
	
	@BeforeMethod
	    public void loginActitime() {
		System.out.println("loginActitime");
		driver.get("http://localhost/login.do");
		
		login.sendUserName();
		login.sendPassword();
		login.clickLoginButton();
		
		
//		userList = new UserList(driver);
//		String buttonName=userList.verifyCreateNewUser();
//		 softAssert= new SoftAssert();
		 
	}
	
	@Test
	public void verifyUserButton() {
		actitimeHeader.clickOnUserTab();
		String url= driver.getCurrentUrl();
		System.out.println(url);
	
	}
	
	@Test
	public void verifyReportTab() {
		actitimeHeader.clickOnReportTab();
		String url=driver.getCurrentUrl();
		
		System.out.println(url);
//		Assert.assertEquals(url, "http://localhost/reports/reports.do");
//		String title=driver.getTitle();
	}
	
	@AfterMethod
	public void logoutFromActitime() {
		actitimeHeader.clickOnLogout();
		System.out.println("clickOnLogout");
		
	}
	
	@AfterClass
	public void closeObjects() {
		login=null;
		actitimeHeader=null;
		
	}
    @AfterTest
    public void closeBrowser() {
    	
    	driver.quit();
    	driver=null;
    	System.gc();
    	
    	}
    
}
