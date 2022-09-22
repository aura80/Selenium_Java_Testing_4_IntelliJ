package tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import components.Footer;
import components.Header;
import junit.framework.Assert;

import pages.InventoryPage;
import pages.LoginValidInvalidDataPage;
import pages.LogoutPage;
import pages.ProductDetails;
import pages.StartPage;
import testdata.URL;
import testdata.UserLogin;
import testmessages.Messages;

@SuppressWarnings("deprecation")			// to suppress the compiler warnings
public class SaucedemoBaseTest {

	static WebDriver driver;
	
	public static LoginValidInvalidDataPage loginValidInvalidDataPage;
	public static StartPage startPage;
	public static InventoryPage inventoryPage;
	public static ProductDetails productDetails;
	public static LogoutPage logoutPage;
	public static Header header;
	public static Footer footer;
	
	// POJO instantiation
	
	public static UserLogin userloginTD = new UserLogin("uservalidlogin");
	public static UserLogin userinvalidloginTD = new UserLogin("userinvalidlogin");

	
	@Before
	public void before() throws AWTException {
		
		// SETTING THE PROPERTY OF THE DRIVER 
		System.setProperty("webdriver.chrome.driver", "src/resource/chromedriver.exe");
		driver = new ChromeDriver();																		// o singura data creez instanta de browser
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		// PAGES INSTANTIATION
		
		loginValidInvalidDataPage = new LoginValidInvalidDataPage(driver);
		inventoryPage = new InventoryPage(driver);
		startPage = new StartPage(driver);
		productDetails = new ProductDetails(driver);
		logoutPage = new LogoutPage(driver);
		
		// COMPONENTS INSTANTIATION
		
		header = new Header(driver);
		footer = new Footer(driver);
		
		// HANDLING THE COORDINATES OF THE BROWSER ZOOMING OUT
		
		Robot robot = new Robot();
		
		for (int i = 0; i < 5; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		
		driver.navigate().to(URL.BASE_URL);
		
		Assert.assertEquals("login_logo", startPage.getHeaderClassName());
		Assert.assertTrue(startPage.headerDisplayed());
		Assert.assertTrue(startPage.usernameInputCheck());
		Assert.assertTrue(startPage.getPasswordInputCheck());
		Assert.assertTrue(startPage.getErrorMsgEnabled());
		Assert.assertTrue(startPage.getErrorMsgDispalyed());
		Assert.assertTrue(startPage.getLoginButtonEnabled());
		Assert.assertTrue(startPage.getLoginButtonDisplayed());
		Assert.assertEquals(URL.BASE_URL, driver.getCurrentUrl());
		Assert.assertEquals(Messages.BASE_TITLE, driver.getTitle());
		
	}
	
	@After
	public void after() {
		driver.close();
		driver.quit();
	}
		
}
