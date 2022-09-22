package pages;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.GeneralInfo;


public class InventoryPage extends GeneralInfo {
	
	private WebDriver driver;

	public InventoryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	private By applLogo = By.xpath("//div[@class=\"header_label\"]/div[@class=\"app_logo\"]");
	private By prod = By.xpath("//div[@class=\"header_secondary_container\"]/span");
	private By products = By.xpath("//div[@class=\"inventory_list\"]/div/descendant::div[contains(@class,\"inventory_item_name\")]");
	private By prices = By.xpath("//div[@class=\"inventory_list\"]/div/descendant::div[contains(@class,\"inventory_item_price\")]");
	private By description = By.xpath("//div[@class=\"inventory_item_label\"]/div");
	private By allLinks = By.tagName("a");

	// CURRENT URL, TITLE, PAGE SOURCE, WINDOW HANDLE
	@Before @Override
	public void generalInfos() {
		super.generalInfos();
	}
	// PRODUCTS	
	public List<String> getListOfProducts(){
		List<WebElement> produse = driver.findElements(products);
		List<String> produseText = new ArrayList<String>();
		
		for (WebElement produs : produse) {
				produseText.add(produs.getText());
		}
		
		return produseText;
	}
	// PRICES
	public List<String> getListOfPrices(){
		List<WebElement> preturi = driver.findElements(prices);
		List<String> preturiText = new ArrayList<String>();
		
		for (WebElement pret : preturi) {
			preturiText.add(pret.getText());
		}
		
		return preturiText;
	}
	// DESCRIPTIONS
	public List<String> getListOfDescriptions(){
		List<WebElement> descrieri = driver.findElements(description);
		List<String> descrieriText = new ArrayList<String>();
		
		for (WebElement descriere : descrieri) {
			descrieriText.add(descriere.getText());
		}
		
		return descrieriText;
	}
	// ALL LINKS
	public void allLinks() {
		List<WebElement> links = driver.findElements(allLinks);
		System.out.println("Links on page: " + links.size());		
		for(WebElement link : links) {
			System.out.println(link.getAttribute("href"));			
		}
	}
	
	
}
