package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"username\"]")
	WebElement UserName;
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
	WebElement Password;
	@FindBy(how = How.XPATH, using = "//button[@name='login']")
	WebElement Login;

	public void UserName(String username) {
		UserName.sendKeys(username);
	}

	public void Password(String password) {
		Password.sendKeys(password);
	}

	public void Login() {
		Login.click();
	}

//Technique 2 - Less code but it can help when trying to find error
//public void enterUserNameandPassword(String username, String password) {
//	UserName.sendKeys(username);
//	Password.sendKeys(password);
//	Login.click();
//}
}
