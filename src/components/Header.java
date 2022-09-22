package components;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testmessages.Messages;

public class Header {
	
	private WebDriver driver;

	public Header(WebDriver driver) {
		this.driver = driver;
	}
	
	private By applLogo = By.xpath("//div[@class=\"header_label\"]/div[@class=\"app_logo\"]");
	private By burgerButton = By.id("react-burger-menu-btn");
	private By burgerButtonElements = By.xpath("//nav/a");
	private By fleeceClick = By.id("item_5_title_link");
	private By burgerButtonAllItems = By.id("inventory_sidebar_link");
	private By burgerButtonAbout = By.id("about_sidebar_link");
	private By burgerButtonLogOut = By.id("logout_sidebar_link");
	private By burgerButtonReset = By.id("reset_sidebar_link");
	private By burgerButtonClose = By.id("react-burger-cross-btn");
	private By shoppingCart = By.id("shopping_cart_container");
	private By shoppingCartBadge = By.className("shopping_cart_badge");
	private By prod = By.xpath("//div[@class=\"header_secondary_container\"]/span");
	private By peek = By.className("peek");
	private By selectOne = By.xpath("//select[@class=\"product_sort_container\"]/option");
	private By selectTwo = By.xpath("//select[@class=\"product_sort_container\"]");
	private By selectSix = By.className("product_sort_container");
	private By secondaryHeaderColor = By.className("header_secondary_container");

	

	// SWAGLABS - LOGO DISPLAYED
	public Boolean applLogoDisplayed() {
		return driver.findElement(applLogo).isDisplayed();
	}
	// SWAGLABS - LOGO ENABLED
	public Boolean applLogoEnabled() {
		return driver.findElement(applLogo).isEnabled();
	}
	// SWAGLABS - LOGO GETCLASS
	public String applLogoGetClass() {
		return driver.findElement(applLogo).getClass().getName();	
	}
	// SWAGLABS - LOGO GETLOCATION
	public void applLogoGetLocation() {
		System.out.println("Logo location:			" + driver.findElement(applLogo).getLocation());
	}
	// CLICK ON FLEECE JACKET
	public void fleceJacketClick() {
		driver.findElement(fleeceClick).click();
	}
	// CLICK ON ALL ITEMS
	public void allItemsClick() {
		driver.findElement(burgerButtonAllItems).click();
	}
	// CLICK ON RESET
	public void resetClick() {
		driver.findElement(burgerButtonReset).click();
	}
	// CLICK ON ABOUT
	public void aboutClick() {
		driver.findElement(burgerButtonAbout).click();
	}
	// CLICK ON LOGOUT
	public void logoutClick() {
		driver.findElement(burgerButtonLogOut).click();
	}
	// BURGER DISPLAYED
	public Boolean burgerButtonDisplayed() {
		return driver.findElement(burgerButton).isDisplayed();
	}
	// BURGER ENABLED
	public Boolean burgerButtonEnabled() {
		return driver.findElement(burgerButton).isEnabled();
	}
	// BURGER GETCLASS
	public String burgerButtonGetClass() {
		return driver.findElement(burgerButton).getClass().getName();	
	}
	// BURGER GET LOCATION
	public void burgerButtonLocation() {
		System.out.println("Burger button location:		" + driver.findElement(burgerButton).getLocation());
	}
	// BURGER BUTTON CLICK
	public void burgerButtonClick() {
		driver.findElement(burgerButton).click();
	}
	// BURGER BUTTON ALL ITEMS
	public void burgerButtonAllItems() {
		driver.findElement(burgerButtonAllItems).click();
	}
	// BURGER BUTTON ELEMENTS
	public String burgerButtonElements() {
		List<WebElement> elements = driver.findElements(burgerButtonElements);
		
		for(WebElement element : elements) {
			element.getText();	
		}		
		
		return elements.get(0).getText() + " " + elements.get(1).getText() + " " + elements.get(2).getText() + " " +elements.get(3).getText();
	}
	// BURGER BUTTON CLOSE
	public void burgerButtonClose() {
		driver.findElement(burgerButtonClose).click();
	}
	// SHOPPING CART DISPLAYED
	public Boolean shoppingCartDisplayed() {
		return driver.findElement(shoppingCart).isDisplayed();
	}
	// SHOPPING CART ENABLED
	public Boolean shoppingCartEnabled() {
		return driver.findElement(shoppingCart).isEnabled();
	}
	// SHOPPING CART GETCLASS
	public String shoppingCartGetClass() {
		return driver.findElement(shoppingCart).getClass().getName();
	}
	// SHOPPING CART LOCATION
	public void shoppingCartLocation() {
		System.out.println("Shopping cart location:		" + driver.findElement(shoppingCart).getLocation());
	}
	// SHOPPING CART CLICK
	public void shoppingCartClick() {
		driver.findElement(shoppingCart).click();
	}
	// SHOPPING CART BADGE
	public String shoppingCartBadge() {
		return driver.findElement(shoppingCartBadge).getText();
	}
	// SECONDARY HEADER BACKGROUND COLOR
	public String getSecondaryHeaderBackgroundColor() {
		return driver.findElement(secondaryHeaderColor).getCssValue("background-color");
	}
	// PRODUCTS TEXT ON SECONDARY HEADER
	public String productsLogo() {
		return driver.findElement(prod).getText();		
	}
	// PEEK PICTURE FROM SECONDARY HEADER
	public Boolean peekPicture() {
		System.out.println("Peek picture location:		" + driver.findElement(peek).getLocation());
		return driver.findElement(peek).isDisplayed();
	}
	// SELECT METHOD ONE
	public List<String> selectMethodOne() {
		List<WebElement> options = driver.findElements(selectOne);
		List<String> filters = new ArrayList<String>();
		for(WebElement option : options) {
			filters.add(option.getText());
		}
		return filters;
	}
	// SELECT METHOD TWO
	public void selectMethodTwo() {
		driver.findElement(selectTwo).click();
		WebElement selectDoi = driver.findElement(selectTwo);
		List<WebElement> options = selectDoi.findElements(By.tagName("option"));
//		System.out.println("Click on: " + options.get(2).getText());
		options.get(2).click();	
	}
	// SELECT METHOD THREE
	public void selectMethodThree() {
		driver.findElement(selectTwo).click();
		WebElement selectDoi = driver.findElement(selectTwo);
		List<WebElement> options = selectDoi.findElements(By.tagName("option"));
//		System.out.println("Click on: " + options.get(1).getText());
		options.get(1).click();	
	}
	// SELECT METHOD FOUR
	public void selectMethodFour() {
		driver.findElement(selectTwo).click();
		WebElement selectDoi = driver.findElement(selectTwo);
		List<WebElement> options = selectDoi.findElements(By.tagName("option"));
//		System.out.println("Click on: " + options.get(0).getText());
		options.get(0).click();	
	}
	// SELECT METHOD FIVE
	public void selectMethodFive() {
		driver.findElement(selectTwo).click();
		WebElement selectDoi = driver.findElement(selectTwo);
		List<WebElement> options = selectDoi.findElements(By.tagName("option"));
//		System.out.println("Click on: " + options.get(3).getText());
		options.get(3).click();	
	}
	// SELECT METHOD SIX
	public void selectMethodSix() {
//		System.out.println(" *** " + Messages.SELECT_DROPDOWN_PRICE_LOW);
		Select selectProducts = new Select(driver.findElement(selectSix));
		selectProducts.selectByVisibleText(Messages.SELECT_DROPDOWN_PRICE_LOW);
	}
	// SELECT METHOD SEVEN
	public void selectMethodSeven() {
//		System.out.println(" *** " + Messages.SELECT_DROPDOWN_NAME_A);
		Select selectProducts = new Select(driver.findElement(selectSix));
		selectProducts.selectByIndex(Messages.SELECT_INDEX_0);
	}
}
