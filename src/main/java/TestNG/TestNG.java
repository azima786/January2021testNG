package TestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG {

WebDriver driver;
String browser;	
String url;

@BeforeClass
public void readconfig() {
	System.out.println("Before Class");
	Properties prop = new Properties();
	//Input Stream, Buffer Reader, Scanner, File Reader - Class that can help us read any file
	try{
		InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
	prop.load(input);	
browser=	prop.getProperty("browser");
	System.out.println(browser);
	url = prop.getProperty("url");
	System.out.println(url);
	}
	catch(IOException e){
		e.printStackTrace();
	}
}

@BeforeMethod
public void start() throws InterruptedException {
	System.out.println("Before Method");
	if(browser.equalsIgnoreCase("chrome")) {
	System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
driver = new ChromeDriver();}
	
else if (browser.equalsIgnoreCase("FireFox")) {System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
	driver = new FirefoxDriver();}

	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.get("https://techfios.com/billing/?ng=login/");
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}

@Test (priority=1)
public void input() {
	System.out.println("Test1");
	Assert.assertEquals(driver.getTitle(), "Login - iBilling", "Wrong Page!!!!");
WebElement Username=driver.findElement(By.xpath("//*[@id=\"username\"]"));
WebElement Password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
WebElement Submit = driver.findElement(By.xpath("//button[@type='submit']"));

Username.clear();
Username.sendKeys("demo@techfios.com");
Password.sendKeys("abc123");
Submit.click();

Assert.assertEquals(driver.getTitle(), "Dashboard- iBilling", "Wrong Page!!!!");
}

@Test (priority=2)
public void addCustomerTest() {
	System.out.println("Test2");
	By UserName = By.id("username");
	By Password = By.xpath("//*[@id=\"password\"]");
	By Submit = By.xpath("//button[@type='submit']");
	By Customers = By.xpath("//span[contains(text(),'Customers')]");
	By AddCustomers =  By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a");
	By FullName = By.xpath("//input[@id='account']");
	By Company = By.xpath(("//select[@id='cid']"));
	By Email = By.xpath("//input[@id='email']");
	By Phone = By.xpath("//input[@id='phone']");
	By Address = By.xpath("//input[@id='address']");
	By City = By.xpath("//input[@id='city']");
	By State = By.xpath("//input[@id='state']");
	By Zip = By.xpath("//input[@id='zip']");
	By Country = By.xpath("//select[@id='country']");
	By Tags = By.xpath("//select[@id='tags']");
	By Group = By.xpath("//select[@id='group']");
	By Password1 = By.xpath("//input[@id='password']");
	By CPassword = By.xpath("//input[@id='cpassword']");
	By Save = By.xpath("//button[@id='submit']");

//Login Data
	String LoginID = "demo@techfios.com";
	String Password2 = "abc123";

//Test or Mock Data
	String FullNames = "Test January";
	String CompanyName = "Techfios";
	String Emails = "testJanuary@gmail.com";
	String PhoneNumber = "2057984523";	
	
//log in	
	Assert.assertEquals(driver.getTitle(), "Login - iBilling", "Wrong Page!!!!");	
	driver.findElement(UserName).sendKeys(LoginID);
	driver.findElement(Password).sendKeys(Password2);
	driver.findElement(Submit).click();
	Assert.assertEquals(driver.getTitle(), "Dashboard- iBilling", "Wrong Page!!!!");
	
	//add customer
	driver.findElement(Customers).click();
	waitForElement(driver, 5, AddCustomers);
	driver.findElement(AddCustomers).click();
	waitForElement(driver, 3, FullName);	
	
	//Random Number
		Random rnd = new Random();
	int number =	rnd.nextInt(999);
	
	driver.findElement(FullName).sendKeys(FullNames + number);
	
	Select sel1 = new Select(driver.findElement(Company));
	sel1.selectByVisibleText(CompanyName);
	
	driver.findElement(Email).sendKeys(number + Emails);
	driver.findElement(Phone).sendKeys(PhoneNumber + number);
	
}

public void waitForElement(WebDriver driver2, int timeInSeconds, By locator) {
	WebDriverWait wait = new WebDriverWait(driver,timeInSeconds);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	
}

@AfterMethod
public void teardownn() {
	System.out.println("After Method");
	driver.close();
	driver.quit();
}

@AfterClass
public void AfterClass() {
	System.out.println("After Class");
}

@AfterTest
public void AfterTest() {
	System.out.println("After Test");
}

@AfterSuite
public void AfterSuite() {
	System.out.println("After Suit");
}
}