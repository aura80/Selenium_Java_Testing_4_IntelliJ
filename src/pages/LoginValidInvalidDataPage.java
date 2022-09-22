package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import util.AbstractInfo;

import org.openqa.selenium.Keys;

public class LoginValidInvalidDataPage extends AbstractInfo {

	private WebDriver driver;

	public LoginValidInvalidDataPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By usernameInput = By.name("user-name");
	private By passwordInput = By.name("password");
	private By loginButton = By.id("login-button");
	private By errorMsgText = By.xpath("//h3");

	
	public void usernameInput(String name) {
		driver.findElement(usernameInput).sendKeys(name);
	}

	public void passwordInput(String password) {
		driver.findElement(passwordInput).sendKeys(password);
	}
	
	public void loginClick() {	
		driver.findElement(loginButton).click();		
	}
	
	public void authenticate(String username, String password) {
		usernameInput(username);
		passwordInput(password);
		loginClick();
	}
	
	public String getErrorMsgText() {
		return driver.findElement(errorMsgText).getText();
	}

	public void usernameInput(Keys tab) {
//		driver.findElement(usernameInput).sendKeys(Keys.TAB);
		
	}

	public void passwordInput(Keys backSpace) {
		driver.findElement(passwordInput).sendKeys(Keys.BACK_SPACE);	
	}

}
