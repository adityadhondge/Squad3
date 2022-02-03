package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn {
	@FindBy (xpath="//input[@name='username']")
    private WebElement userName;
	
	
	@FindBy (xpath="//input[@name='pwd']")
    private WebElement pass;
	
	
	@FindBy (xpath="//a[@id='loginButton']")
    private WebElement login;
	
        public LogIn (WebDriver driver1) {
		
		PageFactory.initElements(driver1,this );
        }	
		public void sendUserName() {
			if(userName.isDisplayed()) {
				userName.sendKeys("admin");
			}
		}
		
		public void sendPassword() {
			if(pass.isDisplayed()) {
				pass.sendKeys("manager");
			}
		}
	
        public void clickLoginButton() {
        	if(login.isDisplayed()) {
        		login.click();
        	}
        }
}
