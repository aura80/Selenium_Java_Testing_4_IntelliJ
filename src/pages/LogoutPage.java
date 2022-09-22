package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import components.Header;
import testmessages.Messages;

import java.time.Duration;

public class LogoutPage {
	
	private WebDriver driver;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By logOut = By.xpath("//div[@class=\"bm-menu-wrap\"]/div/nav/a[3]");
	
	// LOGOUT CLICK  
	public void logOutClick() {		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(logOut));
		logout.click();
	}

}
