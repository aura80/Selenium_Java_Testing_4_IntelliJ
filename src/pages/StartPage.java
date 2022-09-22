package pages;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import testmessages.Messages;
import util.GeneralInfo;

public class StartPage extends GeneralInfo  {

	private WebDriver driver;

	public StartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	// locators , UI mapper
	
	private By headerClassName = By.className("login_logo");
	private By usernameInput = By.name("user-name");
	private By passwordInput = By.name("password");
	private By errorMsg = By.xpath("//div[@class=\"error-message-container\"]");
	private By loginButton = By.id("login-button");
	private By credentialsBox = By.xpath("//div[@class=\"login_credentials_wrap-inner\"]");
	private By credentialsUser = By.id("login_credentials");
	private By credentialsPassword = By.className("login_password");
	private By h4User = By.xpath("//div[@class=\"login_credentials\"]/h4");
	private By h4Password = By.xpath("//div[@class=\"login_password\"]/h4");
	private By robotSeen = By.xpath("//div[@class=\"bot_column\"]");
	private By chenar = By.className("login_wrapper-inner");
	
	// CURRENT URL, TITLE, PAGE SOURCE, WINDOW HANDLE
	@Before @Override
	public void generalInfos() {
		super.generalInfos();
	}
	
	// CHECK THE LOGIN LOGO UPPER SIDE OF THE START PAGE
	public String getHeaderClassName() {
		return driver.findElement(headerClassName).getAttribute("class");
	}
	// CHECK IF THE ELEMENT ABOVE IS DISPLAYED
	public Boolean headerDisplayed() {
		return driver.findElement(headerClassName).isDisplayed();
	}
	// BORDER OF login_wrapper-inner
	public String chenarUpper() {
		return driver.findElement(chenar).getCssValue("padding") + " " + driver.findElement(chenar).getCssValue("border");
	}
	// USERNAME INPUT BOX IS ENABLED 
	public Boolean usernameInputCheck() {
		return driver.findElement(usernameInput).isEnabled();
	}
	// USERNAME INPUT BOX LOCATION
	public void usernameInputLocation() {
		System.out.println("Username input location: " + driver.findElement(usernameInput).getLocation());
	}
	// BORDER BOTTOM CHECK
	public Boolean getBottomBoxUserPass() {
		return driver.findElement(usernameInput).getCssValue("border-bottom").valueOf(usernameInput) != driver.findElement(passwordInput).getCssValue("border-bottom").valueOf(passwordInput);
	}
	// PASSWORD INPUT BOX IS ENABLED 
	public Boolean getPasswordInputCheck() {
		return driver.findElement(passwordInput).isEnabled();
	}
	// PASSWORD INPUT BOX LOCATION
	public void passwordInputLocation() {
		System.out.println("Password input location: " + driver.findElement(passwordInput).getLocation());
	}
	// ERROR MESSAGE BOX ENABLED
	public Boolean getErrorMsgEnabled() {
		return driver.findElement(errorMsg).isEnabled();
	}
	// ERROR MESSAGE BOX DISPLAYED
	public Boolean getErrorMsgDispalyed() {
		return driver.findElement(errorMsg).isDisplayed();
	}
	// LOGIN BUTTON ENABLED
	public Boolean getLoginButtonEnabled() {
		return driver.findElement(loginButton).isEnabled();
	}
	// LOGIN BUTTON DISPLAYED
	public Boolean getLoginButtonDisplayed() {
		return driver.findElement(loginButton).isDisplayed();
	}
	// LOGIN BUTTON COLOR CHECK 
	public String loginButtonColorCheck() {
		return driver.findElement(loginButton).getCssValue("color");
	}
	// LOGIN BUTTON LOCATION CHECK 
	public String loginButtonXYLocationCheck() {
		return "X-axis: " + driver.findElement(loginButton).getLocation().getX() + "Y-axis: " + driver.findElement(loginButton).getLocation().getY();
	}
	// RIGHT SIDE IMAGE DISPLAYED
	public Boolean getRobotSeen() {
		return driver.findElement(robotSeen).isDisplayed();
	}
	// RIGHT SIDE IMAGE LOCATION AND BACKGROUND CHECK
	public void robotLocationCheck() {
		System.out.println("Image right location: " + driver.findElement(robotSeen).getLocation());
	}
	// BACKGROUND COLOR & BORDER & PADDING OF THE CREDENTIALS BOX
	public String getLoginCredentialsBox() {
		return driver.findElement(credentialsBox).getCssValue("padding") + " " + driver.findElement(credentialsBox).getCssValue("border");
	}
	// TEXT WITH ALL THE USERNAMES + h4
	public String getLoginCredentialsUser() {
		return driver.findElement(credentialsUser).getText();
	}
	// CREDENTIALS BOX CHARACTERISTICS
	public String credentialsTextStyle() {
		return driver.findElement(credentialsUser).getCssValue("font");
	}
	// CHECK THE USERNAME PRESENCE ON THE PAGE
	public Boolean getUserCheck() {
		return driver.findElement(credentialsUser).getText().contains(Messages.USERNAME_PROBLEM_USER);
	}
	// CHECKING THE TEXT "Accepted usernames are:"
	public String geth4User() {
		return driver.findElement(h4User).getText();
	}
	// TEXT WITH THE PASSWORD + h4
	public String getLoginCredentialsPassword() {
		return driver.findElement(credentialsPassword).getText();
	}
	// CHECK THE PASSWORD PRESENCE ON THE PAGE
	public Boolean getPasswordCheck() {
		return driver.findElement(credentialsPassword).getText().contains(Messages.PASSWORD);
	}
	// CHECKING THE TEXT "Password for all users:"
	public String geth4Password() {
		return driver.findElement(h4Password).getText();
	}
}
