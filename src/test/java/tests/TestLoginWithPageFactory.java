package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.Login;

public class TestLoginWithPageFactory {

	WebDriver driver;
	Login objLogin;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@Test
	public void test_HomePage_Appear_Correct() {
		objLogin = new Login(driver);
		
		//verify login page text
		String loginPageMessage=objLogin.getLoginText();
		System.out.println(loginPageMessage);
		Assert.assertTrue(loginPageMessage.contains("Username"));
		
		//To login to application
		objLogin.loginToApplication("Admin", "admin123");
		//Verifying Home Page title
		Assert.assertEquals(driver.getTitle(), "OrangeHRM", "Page title is correct");
		driver.quit();
	}
}
