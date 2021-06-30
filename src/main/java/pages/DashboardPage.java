package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {
WebDriver driver;

public DashboardPage(WebDriver driver) {
	this.driver = driver;
}

@FindBy(how = How.XPATH, using = "//h2[contains(text(),' Dashboard ')]") WebElement Dashboard;
@FindBy(how = How.XPATH, using = "//span[contains(text(),'Customers')]") WebElement Customers;
@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add Customer')]") WebElement AddCustomer;

public void verifyDashboardPage() {
	Assert.assertEquals(Dashboard.getText(), "Dashboard");
}

public void clickonCustomer() {
	Customers.click();
}

public void clickonAddCustomer() {
	AddCustomer.click();
}
}
