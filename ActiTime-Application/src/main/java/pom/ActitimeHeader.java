package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActitimeHeader {

	@FindBy(xpath="//div[text()='Users']")
	private WebElement user;
	
	
	@FindBy(xpath="//div[text()='Reports']")
	private WebElement report;
	
	
	@FindBy(xpath="//div[text()='Tasks']")
	private WebElement tasks;
	
	@FindBy (xpath="//a[text()='Logout']")
	private WebElement logoutbutton;
	
	public ActitimeHeader(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		
	}
	
	public void clickOnUserTab() {
		user.click();
	}
	
public void clickOnReportTab() {
		report.click();
	}
public void clickOnTaskTab() {
	tasks.click();
}
public void clickOnLogout() {
	logoutbutton.click();
}
	
	
	
}
