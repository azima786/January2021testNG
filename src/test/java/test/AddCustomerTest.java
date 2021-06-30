package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.AddCustomerPage;
import pages.DashboardPage;
import pages.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {
WebDriver driver;
	
	@Test
	public void ValidUserShouldBeAbleToCreateCustomer() {
	driver = BrowserFactory.init();
	
	LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
	loginpage.UserName("demo@techfios.com");
	loginpage.Password("abc123");
	loginpage.Login();
	
	DashboardPage Dp = PageFactory.initElements(driver, DashboardPage.class);
	Dp.verifyDashboardPage();
	Dp.clickonCustomer();
	Dp.clickonAddCustomer();
	
	AddCustomerPage AddCustomer = PageFactory.initElements(driver, AddCustomerPage.class);
	AddCustomer.enterfullname("Selenium");
	AddCustomer.enterCompany("Techfios");
	AddCustomer.enterEmail("abc123@gmail.com");
	
	BrowserFactory.teardown();
	
	}
}
