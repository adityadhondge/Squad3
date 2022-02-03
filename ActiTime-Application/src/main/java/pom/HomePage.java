package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
//userspage
public class HomePage {

	private WebDriver driver;
	@FindBy (xpath="//div[text()='Users']")
	private WebElement users;
	
//	@FindBy (xpath="//div[@id='ext-gen7']")	
//	private WebElement User;
//	
//	@FindBy (xpath="//img[@id='closeUserDataLightBoxBtn']")
//	private WebElement cross;
	
	@FindBy (xpath="//table[@id='ext-comp-1020']")
	private WebElement dropdown;
	
	@FindBy (xpath="//a[@id='ext-gen65']")
	private WebElement manageCustomers;
	
	@FindBy (xpath="//a[text()='Logout']")
	private WebElement logoutbutton;
	
	public HomePage(WebDriver driver) {
			
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
			
public void clickOnUsersButton() {
	
	if(users.isDisplayed());{
		users.click();
	}
}
//	public void clickOnUserAdd() {
//		User.click();
//	}	
//	
//	public void clickOnCross() {
//		cross.click();
//	}
	public void ClickOnDropdown() {
		Actions act= new Actions(driver);
		act.moveToElement(dropdown).click().build().perform();
	}
	public void ClickManageCustomers() {
		manageCustomers.click();
	}
	public void ClickOnLogoutButton() {
		logoutbutton.click();
	}
	}

