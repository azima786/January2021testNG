package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import util.BrowserFactory;

public class LoginTest {
WebDriver driver;
	
	@Test
	public void ValidUserShouldBeAbleToLogin() {
	driver = BrowserFactory.init();
	
	LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
	loginpage.UserName("demo@techfios.com");
	loginpage.Password("abc123");
	loginpage.Login();
	
	DashboardPage Dp = PageFactory.initElements(driver, DashboardPage.class);
	Dp.verifyDashboardPage();
	
	BrowserFactory.teardown();
	}
}
