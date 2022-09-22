package components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Footer {

	private WebDriver driver;

	public Footer(WebDriver driver) {
		this.driver = driver;
	}
	
	private By footerColor = By.xpath("//footer[@class=\"footer\"]");
	private By footerLinks = By.xpath("//footer[@class=\"footer\"]/ul/li/a");
	private By footerText = By.xpath("//footer[@class=\"footer\"]/div[@class=\"footer_copy\"]");
	private By footerPicture = By.xpath("//footer[@class=\"footer\"]/div[@class=\"footer_copy\"]/following-sibling::img");
	
	// FOOTER BACKGROUND COLOR
	public String getFooterBackgroundColor() {
		return driver.findElement(footerColor).getCssValue("background-color");
	}
	// FOOTER's LINKS
	public void footerLinks() {
		List<WebElement> links = driver.findElements(footerLinks);
		System.out.println("Links on footer: " + links.size());
		
		for(WebElement link : links) {
			System.out.println(link.getText() + "  -  " + link.getAttribute("href"));
		}		
	}
	// FOOTER TEXT
	public String footerText() {
		return driver.findElement(footerText).getText();
	}
	// FOOTER PICTURE LOCATION
	public void footerPicture() {
		System.out.println("Footer's picture location:		" + driver.findElement(footerPicture).getLocation());
		System.out.println("Footer's picture source:		" + driver.findElement(footerPicture).getAttribute("src"));
	}
	
}
