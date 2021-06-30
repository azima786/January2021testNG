package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserFactory {
static WebDriver driver;

	
public static WebDriver init() {
	System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://techfios.com/billing/?ng=login/");
	return driver;
}

public static void teardown() {
	driver.quit();
	driver.close();
}
}
