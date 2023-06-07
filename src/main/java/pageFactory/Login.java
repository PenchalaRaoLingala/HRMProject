package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	WebDriver driver;
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[contains(text(), 'Username')]")
	WebElement MessageText;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement login;
	
	public Login(WebDriver driver) {
		this.driver= driver;
		//This initiElement method will create all webelements
		PageFactory.initElements(driver, this);
	}
	
	//set username in textbox
	public void setUserName(String strUserName)
	{
		userName.sendKeys(strUserName);
	}
	
	//set password in textbox
	public void setPassword(String strPassword) {
		password.clear();
		password.sendKeys(strPassword);
	}
	
	//click on login button
	public void clickLogin() {
		login.click();
	}
	
	//get the text of login page
	public String getLoginText() {
		return MessageText.getText();
	}
	
	// this POM method will be used in test cases to do the login
		public void loginToApplication(String strUserName,String strPassword) {
			//fill user name
			this.setUserName(strUserName);
			this.setPassword(strPassword); //to fill password
			this.clickLogin(); // to click login button
		}
}
