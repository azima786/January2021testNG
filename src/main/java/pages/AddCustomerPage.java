package pages;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCustomerPage extends BasePage{
	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]") WebElement FullName;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]") WebElement Company;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]") WebElement Email;

	public void enterfullname(String fullname) {
		FullName.sendKeys(randomnumber(999) + fullname);
	}
	


	public void enterCompany(String company) {	
		selectDropdown(Company, company);
	}

	public void enterEmail(String email) {
		Email.sendKeys(randomnumber(999) + email);
	}
}
