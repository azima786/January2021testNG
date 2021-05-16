package TestNG;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class HW {
	WebDriver driver;

	@BeforeMethod
	public void start() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://techfios.com/billing/?ng=login/");
		Assert.assertEquals(driver.getTitle(), "Login - iBilling");
	}

	@Test
	public void input() {
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("demo@techfios.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("abc123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
WebElement Dashboard = driver.findElement(By.xpath("//h2[contains(text(),' Dashboard ')]"));
Assert.assertEquals(Dashboard.getText(), "Dashboard");	
		
WebElement Customers =	driver.findElement(By.xpath("//span[contains(text(),'Customers')]"));
WebElement Add =	driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a"));
WebElement name =	driver.findElement(By.xpath("//input[@id='account']"));
WebElement company = driver.findElement(By.xpath(("//select[@id='cid']")));
	Select sel = new Select(company);
	sel.selectByVisibleText("Google");

	double a = Math.random();
	
	waitforelement(driver, 10, name);
	name.sendKeys("James Martin");
	
WebElement Email=	driver.findElement(By.xpath("//input[@id='email']"));
	

driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("205-" + a + "-8023");
	driver.findElement(By.xpath("//input[@id='address']")).sendKeys("1000 Freeway Lane");
	driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Melbourne");
	driver.findElement(By.xpath("//input[@id='state']")).sendKeys("TX");
	driver.findElement(By.xpath("//input[@id='zip']")).sendKeys("85621");
WebElement Country=	driver.findElement(By.xpath("//select[@id='country']"));
WebElement Crime=	driver.findElement(By.xpath("//select[@id='group']"));
WebElement Tag=	driver.findElement(By.xpath("//select[@id='tags']"));
	Select Sel = new Select(Country);
	Select Sels= new Select(Tag);
	Select Sele= new Select(Crime);
Sel.selectByVisibleText("United States");

Sels.selectByVisibleText("crime");
Sele.selectByVisibleText("AUG 2020");

driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
driver.findElement(By.xpath("//input[@id='cpassword']")).sendKeys("123456");

WebElement email = driver.findElement(By.xpath("//div[@class='toggle-group']"));


driver.findElement(By.xpath("//button[@id='submit']")).click();



WebElement Customer = driver.findElement(By.xpath("//a[contains(text(),'List Customers')]"));
Customers.click();
Customer.click();


Assert.assertEquals("Jim Martin", name);

		

}

	private void waitforelement(WebDriver driver, int waitTime, WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	@AfterMethod
	public void teardownn() {
		driver.close();
		driver.quit();
	}

}
